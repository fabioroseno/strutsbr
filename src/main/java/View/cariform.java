/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author asroni
 */
public class cariform extends org.apache.struts.action.ActionForm {
    
    private String nama;
    private int nimCari;

    /**
     * @return
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param string
     */
    public void setNama(String string) {
        nama = string;
    }

    /**
     * @return
     */
    public int getNim() {
        return nimCari;
    }

    /**
     * @param i
     */
    public void setNim(int i) {
        nimCari = i;
    }

    /**
     *
     */
    public cariform() {
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
        if (getNama() == null || getNama().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
    public static void main(String[] args) {
        System.out.println(new cariform().getNama());
    }
}
