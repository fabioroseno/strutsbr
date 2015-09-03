package Controller;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import Model.Dosen;

/**
 *
 * @author asronisme
 */
public class DosenMethodCRUD {
    
    Session ses = Model.HibernateUtilStruts.getSessionFactory().openSession();
    private String ds;
    /**
     * 
     * 
     * 
     * */
    public String lihatData(int b) {
        try {
            ses.beginTransaction();
            Query qw = ses.createQuery("from Dosen like '%"+b);
            
            List ls = qw.list();
            for (int a = 0; a < ls.size(); a++) {
                Dosen ds = (Dosen) ls.get(a);
                
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return ds;
    }
    
    public void insertDosen(int a, String b) {
        try {
             Session sesin =Model.HibernateUtilStruts.getSessionFactory().openSession();
            Transaction tr = sesin.beginTransaction();
            Dosen ds = new Dosen();
            ds.setNama(b);
            ds.setNip(a);
            sesin.save(ds);
            System.out.println("Berhasil Insert Data :)");
            tr.commit();
        } catch (Exception z) {
            System.out.println(z);
        }
    }
    
    public void updateData(int a, String b) {
        try {
            Transaction tr = ses.beginTransaction();
            Dosen ds = (Dosen) ses.load(Dosen.class, a);
            ds.setNama(b);
            System.out.println("Data telah terupdate :-)");
            tr.commit();            
        } catch (Exception s) {
            System.out.println(s);
        }
    }
    
    public void DeleteData(int a) {
        try {
            Transaction tr = ses.beginTransaction();
            Dosen ds = (Dosen) ses.load(Dosen.class, a);
            ses.delete(ds);
            System.out.println("Data telah terhapus");
            tr.commit();
            
        } catch (Exception x) {
            System.out.println(x);
        }
    }
}
