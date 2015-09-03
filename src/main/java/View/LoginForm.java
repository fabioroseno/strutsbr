/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Fahmiizme
 */
public class LoginForm extends org.apache.struts.action.ActionForm {
    
    private String username;
    private String password;

    /**
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param string
     */
    public void setUsername(String string) {
        username = string;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param i
     */
    public void setPassword(String i) {
        password = i;
    }

    /**
     *
     */
    public LoginForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getUsername()== null || getUsername().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
