package Model;
// Generated Jun 1, 2013 7:24:08 PM by Hibernate Tools 3.2.1.GA



/**
 * Matakuliah generated by hbm2java
 */
public class Matakuliah  implements java.io.Serializable {


     private int id;
     private String matkul;
     private Integer sks;

    public Matakuliah() {
    }

	
    public Matakuliah(int id) {
        this.id = id;
    }
    public Matakuliah(int id, String matkul, Integer sks) {
       this.id = id;
       this.matkul = matkul;
       this.sks = sks;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getMatkul() {
        return this.matkul;
    }
    
    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }
    public Integer getSks() {
        return this.sks;
    }
    
    public void setSks(Integer sks) {
        this.sks = sks;
    }




}


