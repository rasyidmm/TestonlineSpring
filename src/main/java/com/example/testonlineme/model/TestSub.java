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
public class TestSub extends Additional implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nama_testSub;
    @ManyToOne
    private Test test;
    @JsonIgnore
    @OneToMany(mappedBy = "testSub")
    private List<TestSubSoal> testSubSoals;

    public TestSub() {
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
        if (!(object instanceof TestSub)) {
            return false;
        }
        TestSub other = (TestSub) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TestSub[ id=" + getId() + " ]";
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
     * @return the nama_testSub
     */
    public String getNama_testSub() {
        return nama_testSub;
    }

    /**
     * @param nama_testSub the nama_testSub to set
     */
    public void setNama_testSub(String nama_testSub) {
        this.nama_testSub = nama_testSub;
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

}

