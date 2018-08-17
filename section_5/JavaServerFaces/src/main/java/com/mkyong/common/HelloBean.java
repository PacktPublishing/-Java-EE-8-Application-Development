package com.mkyong.common;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void validateText(FacesContext context, UIComponent comp,
                                Object value) {

        System.out.println("inside validate method");

        String mno = (String) value;

        if (mno.length() < 4) {
            ((UIInput) comp).setValid(false);

            FacesMessage message = new FacesMessage(
                    "Minimum length of text is 4");
            context.addMessage(comp.getClientId(context), message);

        }

    }

}
//deployement

//http://localhost:8080/JavaServerFaces/hello.jsf
//cp target/JavaServerFaces.war ../../apache-tomcat-9.0.10/webapps