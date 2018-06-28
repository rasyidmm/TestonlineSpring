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
public class Soal extends Additional implements Serializable {
    @JsonIgnore
    @OneToMany(mappedBy = "soal")
    private List<PesertaJawabaDetail> pesertaJawabaDetails;
    @JsonIgnore
    @OneToMany(mappedBy = "soal")
    private List<TestSubSoal> testSubSoals;
    @JsonIgnore
    @OneToMany(mappedBy = "soal")
    private List<SoalPilihanJawaban> soalPilihanJawabans;



    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String soal;
    @Basic(optional = false)
    @Column(length = 100, nullable = false)
    private int nilai_soal;
    @ManyToOne
    private SoalKelompok soalKelompok;
    @ManyToOne
    private SoalType soalType;


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
        if (!(object instanceof Soal)) {
            return false;
        }
        Soal other = (Soal) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Soal[ id=" + getId() + " ]";
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
     * @return the soal
     */
    public String getSoal() {
        return soal;
    }

    /**
     * @param soal the soal to set
     */
    public void setSoal(String soal) {
        this.soal = soal;
    }



    /**
     * @return the soalKelompok
     */
    public SoalKelompok getSoalKelompok() {
        return soalKelompok;
    }

    /**
     * @param soalKelompok the soalKelompok to set
     */
    public void setSoalKelompok(SoalKelompok soalKelompok) {
        this.soalKelompok = soalKelompok;
    }

    /**
     * @return the soalType
     */
    public SoalType getSoalType() {
        return soalType;
    }

    /**
     * @param soalType the soalType to set
     */
    public void setSoalType(SoalType soalType) {
        this.soalType = soalType;
    }

    /**
     * @return the nilai_soal
     */
    public int getNilai_soal() {
        return nilai_soal;
    }

    /**
     * @param nilai_soal the nilai_soal to set
     */
    public void setNilai_soal(int nilai_soal) {
        this.nilai_soal = nilai_soal;
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

    /**
     * @return the testSubSoals
     */
    public List<TestSubSoal> getTestSubSoals() {
        return testSubSoals;
    }

    /**
     * @param testSubSoals the testSubSoals to set
     */
    public void setTestSubSoals(List<TestSubSoal> testSubSoals) {
        this.testSubSoals = testSubSoals;
    }

    /**
     * @return the soalPilihanJawabans
     */
    public List<SoalPilihanJawaban> getSoalPilihanJawabans() {
        return soalPilihanJawabans;
    }

    /**
     * @param soalPilihanJawabans the soalPilihanJawabans to set
     */
    public void setSoalPilihanJawabans(List<SoalPilihanJawaban> soalPilihanJawabans) {
        this.soalPilihanJawabans = soalPilihanJawabans;
    }

    /**
     * @return the soalTypes
     */


}
