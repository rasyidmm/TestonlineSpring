package com.example.testonlineme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author rasyid
 */
@Entity
public class Test extends Additional implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nama_test;
    private String tgl_test;
    @JsonIgnore
    @OneToMany(mappedBy = "test")
    private List<TestSub> testSubs;
    @JsonIgnore
    @OneToMany(mappedBy = "test")
    private List<PesertaTest> pesertaTests;


    public Test() {
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
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Test[ id=" + getId() + " ]";
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
     * @return the nama_test
     */
    public String getNama_test() {
        return nama_test;
    }

    /**
     * @param nama_test the nama_test to set
     */
    public void setNama_test(String nama_test) {
        this.nama_test = nama_test;
    }

    /**
     * @return the tgl_test
     */
    public String getTgl_test() {
        return tgl_test;
    }

    /**
     * @param tgl_test the tgl_test to set
     */
    public void setTgl_test(String tgl_test) {
        this.tgl_test = tgl_test;
    }

    /**
     * @return the testSubs
     */
    public List<TestSub> getTestSubs() {
        return testSubs;
    }

    /**
     * @param testSubs the testSubs to set
     */
    public void setTestSubs(List<TestSub> testSubs) {
        this.testSubs = testSubs;
    }

    /**
     * @return the pesertaTests
     */
    public List<PesertaTest> getPesertaTests() {
        return pesertaTests;
    }

    /**
     * @param pesertaTests the pesertaTests to set
     */
    public void setPesertaTests(List<PesertaTest> pesertaTests) {
        this.pesertaTests = pesertaTests;
    }

}

