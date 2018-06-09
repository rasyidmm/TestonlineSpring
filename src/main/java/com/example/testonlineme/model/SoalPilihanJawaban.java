package com.example.testonlineme.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author rasyid
 */
@Entity
public class SoalPilihanJawaban extends Additional implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1000, nullable = false)
    private String pilihanjawaban1;
    @Column(length = 1000, nullable = false)
    private int kuncijawaban;
    @ManyToOne
    private Soal soal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoalPilihanJawaban)) {
            return false;
        }
        SoalPilihanJawaban other = (SoalPilihanJawaban) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SoalPilihanJawaban[ id=" + getId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }


    public int getKuncijawaban() {
        return kuncijawaban;
    }

    public void setKuncijawaban(int kuncijawaban) {
        this.kuncijawaban = kuncijawaban;
    }

    /**
     * @return the soal

     */
    public Soal getSoal() {
        return soal;
    }

    /**
     * @param soal the soal to set
     */
    public void setSoal(Soal soal) {
        this.soal = soal;
    }


    public String getPilihanjawaban1() {
        return pilihanjawaban1;
    }

    public void setPilihanjawaban1(String pilihanjawaban1) {
        this.pilihanjawaban1 = pilihanjawaban1;
    }
}

