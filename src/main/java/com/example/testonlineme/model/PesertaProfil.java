package com.example.testonlineme.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author noname
 */
@Entity
public class PesertaProfil extends Additional implements Serializable {


    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String nama_foto;
    @Basic(optional = false)
    @Column(length = 100,nullable = false)
    private String nama_peserta;
    @Basic(optional = false)
    @Column(length = 100,nullable = false)
    private String alamat_peserta;
    @Basic(optional = false)
    @Column(length = 100, nullable = false)
    private String tempat_lahir;
    @Basic(optional = false)
    @Column(length = 100, nullable = false)
    private String no_telp;
   // @Temporal(javax.persistence.TemporalType.DATE)
    private String tanggal_lahir;
    @OneToOne
    private Peserta peserta;

    public String getNama_foto() {
        return nama_foto;
    }

    public void setNama_foto(String nama_foto) {
        this.nama_foto = nama_foto;
    }



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
        if (!(object instanceof PesertaProfil)) {
            return false;
        }
        PesertaProfil other = (PesertaProfil) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProfilPeserta[ id=" + getId() + " ]";
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
     * @return the nama_peserta
     */
    public String getNama_peserta() {
        return nama_peserta;
    }

    /**
     * @param nama_peserta the nama_peserta to set
     */
    public void setNama_peserta(String nama_peserta) {
        this.nama_peserta = nama_peserta;
    }

    /**
     * @return the alamat_peserta
     */
    public String getAlamat_peserta() {
        return alamat_peserta;
    }

    /**
     * @param alamat_peserta the alamat_peserta to set
     */
    public void setAlamat_peserta(String alamat_peserta) {
        this.alamat_peserta = alamat_peserta;
    }

    /**
     * @return the tempat_lahir
     */
    public String getTempat_lahir() {
        return tempat_lahir;
    }

    /**
     * @param tempat_lahir the tempat_lahir to set
     */
    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }






    /**
     * @return the no_telp
     */
    public String getNo_telp() {
        return no_telp;
    }

    /**
     * @param no_telp the no_telp to set
     */
    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    /**
     * @return the tanggal_lahir
     */
    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    /**
     * @param tanggal_lahir the tanggal_lahir to set
     */
    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    /**
     * @return the peserta
     */
    public Peserta getPeserta() {
        return peserta;
    }

    /**
     * @param peserta the peserta to set
     */
    public void setPeserta(Peserta peserta) {
        this.peserta = peserta;
    }





}
