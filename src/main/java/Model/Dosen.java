package Model;
// Generated Jun 1, 2013 7:24:08 PM by Hibernate Tools 3.2.1.GA



/**
 * Dosen generated by hbm2java
 */
public class Dosen  implements java.io.Serializable {


     private int nip;
     private String nama;

    public Dosen() {
    }

	
    public Dosen(int nip) {
        this.nip = nip;
    }
    public Dosen(int nip, String nama) {
       this.nip = nip;
       this.nama = nama;
    }
   
    public int getNip() {
        return this.nip;
    }
    
    public void setNip(int nip) {
        this.nip = nip;
    }
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }




}

