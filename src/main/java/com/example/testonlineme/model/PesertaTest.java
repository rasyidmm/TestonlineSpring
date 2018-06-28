package com.example.testonlineme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author rasyid
 */
@Entity
public class PesertaTest extends Additional implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Test test;
    @ManyToOne
    private Peserta peserta;
    @JsonIgnore
    @OneToMany(mappedBy = "pesertatest")
    private List<PesertaJawabaDetail> pesertaJawabaDetails;

    public PesertaTest() {
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
        if (!(object instanceof PesertaTest)) {
            return false;
        }
        PesertaTest other = (PesertaTest) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PesertaTest[ id=" + getId() + " ]";
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
     * @return the test
     */
    public Test getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(Test test) {
        this.test = test;
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

    /**
     * @return the pesertaJawabaDetails
     */
    public List<PesertaJawabaDetail> getPesertaJawabaDetails() {
        return pesertaJawabaDetails;
    }

    /**
     * @param pesertaJawabaDetails the pesertaJawabaDetails to set
     */
    public void setPesertaJawabaDetails(List<PesertaJawabaDetail> pesertaJawabaDetails) {
        this.pesertaJawabaDetails = pesertaJawabaDetails;
    }

}
