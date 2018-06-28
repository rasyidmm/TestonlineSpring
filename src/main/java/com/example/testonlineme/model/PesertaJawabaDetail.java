package com.example.testonlineme.model;

import java.io.Serializable;
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
public class PesertaJawabaDetail extends Additional implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jawaban_peserta;
    @ManyToOne
    private PesertaTest pesertatest;
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
        if (!(object instanceof PesertaJawabaDetail)) {
            return false;
        }
        PesertaJawabaDetail other = (PesertaJawabaDetail) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PesertaJawabaDetail[ id=" + getId() + " ]";
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

    /**
     * @return the jawaban_peserta
     */
    public String getJawaban_peserta() {
        return jawaban_peserta;
    }

    /**
     * @param jawaban_peserta the jawaban_peserta to set
     */
    public void setJawaban_peserta(String jawaban_peserta) {
        this.jawaban_peserta = jawaban_peserta;
    }

    /**
     * @return the pesertatest
     */
    public PesertaTest getPesertatest() {
        return pesertatest;
    }

    /**
     * @param pesertatest the pesertatest to set
     */
    public void setPesertatest(PesertaTest pesertatest) {
        this.pesertatest = pesertatest;
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

}
