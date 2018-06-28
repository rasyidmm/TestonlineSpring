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
public class TestSubSoal extends Additional implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private TestSub testSub;
    @ManyToOne
    private Soal soal;

    public TestSubSoal() {
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
        if (!(object instanceof TestSubSoal)) {
            return false;
        }
        TestSubSoal other = (TestSubSoal) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TestSubSoal[ id=" + getId() + " ]";
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
     * @return the testSub
     */
    public TestSub getTestSub() {
        return testSub;
    }

    /**
     * @param testSub the testSub to set
     */
    public void setTestSub(TestSub testSub) {
        this.testSub = testSub;
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

