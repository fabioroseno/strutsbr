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
 * @author fahmisme_Z
 */
public class FormBean extends org.apache.struts.action.ActionForm {

    private int nim;
    private String nama;
    private String Action;

    /**
     * @return
     */
    public String getAction(){
        return Action;
    }
    public void SetAction(String a){
        this.Action=a;
    }
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
        return nim;
    }

    /**
     * @param i
     */
    public void setNim(int i) {
        nim = i;
    }

    /**
     *
     */
    public FormBean() {
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
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getNama() == null || getNama().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
    public static void main(String[] args) {
        FormBean a=new FormBean();
       
        System.out.println( a.getNim());
        System.out.println(a.getNama());
    }
}
