/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Dosen;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author asroni
 */
public class cariAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "berhasil";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        cariform cfb = (cariform) form;
        int b = cfb.getNim();
        Session ses = Model.HibernateUtilStruts.getSessionFactory().openSession();
        ArrayList<temporary> lis = new ArrayList<temporary>();
            try {
                ses.beginTransaction();
                Query qw = ses.createQuery("from Dosen where NIP=212");
                List ls = qw.list();
                for (int a = 0; a < ls.size(); a++) {
                    Dosen ds = (Dosen) ls.get(a);
                    lis.add(new temporary(ds.getNip(), ds.getNama()));
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            request.setAttribute("lis", lis);
        

        return mapping.findForward(SUCCESS);
    }
}
