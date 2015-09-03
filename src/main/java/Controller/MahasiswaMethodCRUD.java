package Controller;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import Model.Mahasiswa;

/**
 *
 * @author asronisme
 */
public class MahasiswaMethodCRUD {

    Session ses = Model.HibernateUtilStruts.getSessionFactory().openSession();

    public void lihatData(int z) {
        try {
            ses.beginTransaction();
            Query qw = ses.createQuery("from Mahasiswa where nim="+z);
            List ls = qw.list();
            for (int a = 0; a < ls.size(); a++) {
                Mahasiswa mh = (Mahasiswa) ls.get(a);
                System.out.println("|"+mh.getNim() + "|" + mh.getNama() + "|" + mh.getAlamat()+"|");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
/**
 * int a
 * int b
 * int c
 * a: apa?
 * b: apa?
 * c: apa?
 * 
 * 
 * */
    public void insertMahasiswa(int a, String b, String c) {
        try {
            Transaction tr = ses.beginTransaction();
            Mahasiswa mh = new Mahasiswa();
            mh.setNim(a);
            mh.setNama(b);
            mh.setAlamat(c);
            ses.save(mh);
            System.out.println("Berhasil Insert Data");
            tr.commit();
            

        } catch (Exception z) {
            System.out.println(z);
        }
    }

    public void updateData(int a, String b, String c) {
        try {
            Transaction tr = ses.beginTransaction();
            Mahasiswa mhs = (Mahasiswa) ses.load(Mahasiswa.class, a);
            mhs.setNama(b);
            mhs.setAlamat(c);
            System.out.println("Data telah terupdate :-)");
            tr.commit();
            
        } catch (Exception s) {
            System.out.println(s);
        }
    }

    public void DeleteData(int a) {
        try {
            Transaction tr = ses.beginTransaction();
            Mahasiswa mhs = (Mahasiswa) ses.load(Mahasiswa.class, a);
            ses.delete(mhs);
            System.out.println("Data telah terhapus");
            tr.commit();
            
        } catch (Exception x) {
            System.out.println(x);
        }
    }
}
