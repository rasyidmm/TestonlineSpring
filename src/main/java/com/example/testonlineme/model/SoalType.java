package com.example.testonlineme.model;

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
public class SoalType extends Additional implements Serializable {

    @OneToMany(mappedBy = "soalType")
    private List<Soal> soals;


    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    @Column(length = 10, nullable = false,unique = true)
    private String nama_type_soal;
   
   

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
        if (!(object instanceof SoalType)) {
            return false;
        }
        SoalType other = (SoalType) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SoalType[ id=" + getId() + " ]";
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
     * @return the nama_type_soal
     */
    public String getNama_type_soal() {
        return nama_type_soal;
    }

    /**
     * @param nama_type_soal the nama_type_soal to set
     */
    public void setNama_type_soal(String nama_type_soal) {
        this.nama_type_soal = nama_type_soal;
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
