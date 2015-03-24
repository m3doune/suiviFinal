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

@Named("descriptionController")
@SessionScoped
public class DescriptionController implements Serializable {

    @EJB
    private com.mycompany.suivifinal.DescriptionFacade ejbFacade;
    private List<Description> items = null;
    private Description selected;

    public DescriptionController() {
    }

    public Description getSelected() {
        return selected;
    }

    public void setSelected(Description selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getDescriptionPK().setIdMaladie(selected.getMaladie().getIdMaladie());
        selected.getDescriptionPK().setIdIndicateur(selected.getIndicateur().getIdIndicateur());
        selected.getDescriptionPK().setIdPatient(selected.getPatient().getIdPatient());
    }

    protected void initializeEmbeddableKey() {
        selected.setDescriptionPK(new com.mycompany.suivifinal.DescriptionPK());
    }

    private DescriptionFacade getFacade() {
        return ejbFacade;
    }

    public Description prepareCreate() {
        selected = new Description();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DescriptionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DescriptionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DescriptionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Description> getItems() {
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

    public Description getDescription(com.mycompany.suivifinal.DescriptionPK id) {
        return getFacade().find(id);
    }

    public List<Description> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Description> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Description.class)
    public static class DescriptionControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DescriptionController controller = (DescriptionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "descriptionController");
            return controller.getDescription(getKey(value));
        }

        com.mycompany.suivifinal.DescriptionPK getKey(String value) {
            com.mycompany.suivifinal.DescriptionPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.mycompany.suivifinal.DescriptionPK();
            key.setIdMaladie(Integer.parseInt(values[0]));
            key.setIdIndicateur(Integer.parseInt(values[1]));
            key.setIdPatient(Long.parseLong(values[2]));
            return key;
        }

        String getStringKey(com.mycompany.suivifinal.DescriptionPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdMaladie());
            sb.append(SEPARATOR);
            sb.append(value.getIdIndicateur());
            sb.append(SEPARATOR);
            sb.append(value.getIdPatient());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Description) {
                Description o = (Description) object;
                return getStringKey(o.getDescriptionPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Description.class.getName()});
                return null;
            }
        }

    }

}
