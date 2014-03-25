/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Valerie
 */
@Entity
@Table(name = "schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findByIdSchedule", query = "SELECT s FROM Schedule s WHERE s.idSchedule = :idSchedule"),
    @NamedQuery(name = "Schedule.findByDate", query = "SELECT s FROM Schedule s WHERE s.date = :date"),
    @NamedQuery(name = "Schedule.findByClassShape", query = "SELECT s FROM Schedule s WHERE s.classShape = :classShape"),
    @NamedQuery(name = "Schedule.findByNumOfAH", query = "SELECT s FROM Schedule s WHERE s.numOfAH = :numOfAH")})
public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSchedule")
    private Integer idSchedule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "theme")
    private String theme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "classShape")
    private String classShape;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numOfAH")
    private int numOfAH;
    @JoinTable(name = "attendance", joinColumns = {
        @JoinColumn(name = "scheduleID", referencedColumnName = "idSchedule")}, inverseJoinColumns = {
        @JoinColumn(name = "studentID", referencedColumnName = "idStudent")})
    @ManyToMany
    private Collection<Student> studentCollection;
    @JoinColumn(name = "subjectID", referencedColumnName = "idSubject")
    @ManyToOne(optional = false)
    private Subject subjectID;

    public Schedule() {
    }

    public Schedule(Integer idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Schedule(Integer idSchedule, Date date, String theme, String classShape, int numOfAH) {
        this.idSchedule = idSchedule;
        this.date = date;
        this.theme = theme;
        this.classShape = classShape;
        this.numOfAH = numOfAH;
    }

    public Integer getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Integer idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getClassShape() {
        return classShape;
    }

    public void setClassShape(String classShape) {
        this.classShape = classShape;
    }

    public int getNumOfAH() {
        return numOfAH;
    }

    public void setNumOfAH(int numOfAH) {
        this.numOfAH = numOfAH;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    public Subject getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Subject subjectID) {
        this.subjectID = subjectID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSchedule != null ? idSchedule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.idSchedule == null && other.idSchedule != null) || (this.idSchedule != null && !this.idSchedule.equals(other.idSchedule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Schedule[ idSchedule=" + idSchedule + " ]";
    }
    
}
