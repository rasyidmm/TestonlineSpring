package com.example.testonlineme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author noname
 */
@Entity
public class SoalKelompok extends Additional implements Serializable {
    @JsonIgnore
    @OneToMany(mappedBy = "soalKelompok")
    private List<Soal> soals;



    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @Column(length = 10, nullable = false,unique = true)
    private String nama_kelomok_soal;
  
  

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
        if (!(object instanceof SoalKelompok)) {
            return false;
        }
        SoalKelompok other = (SoalKelompok) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SoalKelompok[ id=" + getId() + " ]";
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
     * @return the nama_kelomok_soal
     */
    public String getNama_kelomok_soal() {
        return nama_kelomok_soal;
    }

    /**
     * @param nama_kelomok_soal the nama_kelomok_soal to set
     */
    public void setNama_kelomok_soal(String nama_kelomok_soal) {
        this.nama_kelomok_soal = nama_kelomok_soal;
    }

    /**
     * @return the soals
     */
    public List<Soal> getSoals() {
        return soals;
    }

    /**
     * @param soals the soals to set
     */
    public void setSoals(List<Soal> soals) {
        this.soals = soals;
    }






    
}
