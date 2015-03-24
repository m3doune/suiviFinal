package com.mycompany.suivifinal;

import com.mycompany.suivifinal.util.JsfUtil;
import com.mycompany.suivifinal.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("suiviController")
@SessionScoped
public class SuiviController implements Serializable {

    @EJB
    private com.mycompany.suivifinal.SuiviFacade ejbFacade;
    private List<Suivi> items = null;
    private Suivi selected;

    public SuiviController() {
    }

    public Suivi getSelected() {
        return selected;
    }

    public void setSelected(Suivi selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getSuiviPK().setIdPatient(selected.getPatient().getIdPatient());
        selected.getSuiviPK().setIdMaladie(selected.getMaladie().getIdMaladie());
        selected.getSuiviPK().setIdMedecin(selected.getMedecin().getIdMedecin());
    }

    protected void initializeEmbeddableKey() {
        selected.setSuiviPK(new com.mycompany.suivifinal.SuiviPK());
    }

    private SuiviFacade getFacade() {
        return ejbFacade;
    }

    public Suivi prepareCreate() {
        selected = new Suivi();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SuiviCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SuiviUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SuiviDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Suivi> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Suivi getSuivi(com.mycompany.suivifinal.SuiviPK id) {
        return getFacade().find(id);
    }

    public List<Suivi> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Suivi> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Suivi.class)
    public static class SuiviControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SuiviController controller = (SuiviController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "suiviController");
            return controller.getSuivi(getKey(value));
        }

        com.mycompany.suivifinal.SuiviPK getKey(String value) {
            com.mycompany.suivifinal.SuiviPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.mycompany.suivifinal.SuiviPK();
            key.setIdPatient(Long.parseLong(values[0]));
            key.setIdMaladie(Integer.parseInt(values[1]));
            key.setIdMedecin(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(com.mycompany.suivifinal.SuiviPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdPatient());
            sb.append(SEPARATOR);
            sb.append(value.getIdMaladie());
            sb.append(SEPARATOR);
            sb.append(value.getIdMedecin());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Suivi) {
                Suivi o = (Suivi) object;
                return getStringKey(o.getSuiviPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Suivi.class.getName()});
                return null;
            }
        }

    }

}
