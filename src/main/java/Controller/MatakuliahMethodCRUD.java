package Controller;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import Model.Matakuliah;
        

/**
 *
 * @author asronisme
 */
public class MatakuliahMethodCRUD {

    Session ses = Model.HibernateUtilStruts.getSessionFactory().openSession();

    public void lihatData(int z) {
        try {
            ses.beginTransaction();
            Query qw = ses.createQuery("from Matakuliah");
            List ls = qw.list();
            for (int a = 0; a < ls.size(); a++) {
                Matakuliah x=(Matakuliah) ls.get(a);
                System.out.println("|" + x.getId() + "|" + x.getMatkul() + "|" + x.getSks() + "|");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void insertMatakuliah(int a, String b, int c) {
        try {
            Transaction tr = ses.beginTransaction();
           Matakuliah mk=new Matakuliah();
            mk.setId(a);
            mk.setMatkul(b);
            mk.setSks(c);
            ses.save(mk);
            System.out.println("Berhasil Insert Data Mata Kuliah :)");
            tr.commit();
        } catch (Exception z) {
            System.out.println(z);
        }
    }

    public void updateData(int a, String b, int c) {
        try {
            Transaction tr = ses.beginTransaction();
            Matakuliah mks = (Matakuliah) ses.load(Matakuliah.class, a);
            mks.setMatkul(b);
            mks.setSks(c);
            System.out.println("Data telah terupdate :-)");
            tr.commit();

        } catch (Exception s) {
            System.out.println(s);
        }
    }

    public void DeleteData(int a) {
        try {
            Transaction tr = ses.beginTransaction();
            Matakuliah mhs = (Matakuliah) ses.load(Matakuliah.class, a);
            ses.delete(mhs);
            System.out.println("Data telah terhapus");
            tr.commit();
        } catch (Exception x) {
            System.out.println(x);
        }
    }
}
