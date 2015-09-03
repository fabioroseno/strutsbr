/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DosenMethodCRUD;
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
import org.hibernate.Transaction;

/**
 *
 * @author fahmisme_Z
 */
public class FormAction extends org.apache.struts.action.Action {

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
        FormBean abb = (FormBean) form;
        DosenMethodCRUD dmc = new DosenMethodCRUD();
        int a = abb.getNim();
        String b = abb.getNama();
        //dmc.insertDosen(a, b);
        String act = request.getParameter("Action");
        if (act.equals("Simpan")) {
            dmc.insertDosen(a, b);
        } else if (act.equals("Edit")) {
            dmc.updateData(a, b);
        } else if (act.equals("Cari")) {
            Session session = Model.HibernateUtilStruts.getSessionFactory().openSession();
            ArrayList<temporary> lis = new ArrayList<temporary>();
            try {
                session.beginTransaction();
                Query qw = session.createQuery("from Dosen where NIP=" + b);
                List ls = qw.list();
                for (int z = 0; z < ls.size(); z++) {
                    Dosen ds = (Dosen) ls.get(z);
                    lis.add(new temporary(ds.getNip(), ds.getNama()));
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            request.setAttribute("lis", lis);
        } else if (act.equals("Delete")) {
            dmc.DeleteData(a);
        }
        return mapping.findForward(SUCCESS);
    }
}
