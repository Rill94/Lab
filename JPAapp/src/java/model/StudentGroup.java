/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Valerie
 */
@Entity
@Table(name = "group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentGroup.findAll", query = "SELECT s FROM StudentGroup s"),
    @NamedQuery(name = "StudentGroup.findByIdGroup", query = "SELECT s FROM StudentGroup s WHERE s.idGroup = :idGroup"),
    @NamedQuery(name = "StudentGroup.findByCourse", query = "SELECT s FROM StudentGroup s WHERE s.course = :course")})
public class StudentGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGroup")
    private Integer idGroup;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "faculty")
    private String faculty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "course")
    private int course;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupID")
    private Collection<Student> studentCollection;

    public StudentGroup() {
    }

    public StudentGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public StudentGroup(Integer idGroup, String name, String faculty, int course) {
        this.idGroup = idGroup;
        this.name = name;
        this.faculty = faculty;
        this.course = course;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroup != null ? idGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentGroup)) {
            return false;
        }
        StudentGroup other = (StudentGroup) object;
        if ((this.idGroup == null && other.idGroup != null) || (this.idGroup != null && !this.idGroup.equals(other.idGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.StudentGroup[ idGroup=" + idGroup + " ]";
    }
    
}
