/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fahmiizme
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "successlogin";
    private static final String FAILURE = "failurelogin";

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
        LoginForm lf = (LoginForm) form;
        Session ses = Model.HibernateUtilStruts.getSessionFactory().openSession();

        try {
            Transaction trans = ses.beginTransaction();
            trans.begin();
            String command = "from Login where username='"
                    + lf.getUsername() + "'and password='" + lf.getPassword() + "'";
            Query query = ses.createQuery(command);
            List list = query.list();
            if (list.size() == 1) {
                HttpSession hs=request.getSession();
                hs.setAttribute("username", lf.getUsername());
                hs.setAttribute("password", lf.getPassword());
                
                return mapping.findForward(SUCCESS);
            } else {
                return mapping.findForward(FAILURE);
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
