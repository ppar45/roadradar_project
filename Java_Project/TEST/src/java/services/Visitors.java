/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Parth
 */
@Entity
@Table(name = "VISITORS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visitors.findAll", query = "SELECT v FROM Visitors v")
    , @NamedQuery(name = "Visitors.findByVisitorId", query = "SELECT v FROM Visitors v WHERE v.visitorId = :visitorId")
    , @NamedQuery(name = "Visitors.findByVisitorName", query = "SELECT v FROM Visitors v WHERE v.visitorName = :visitorName")
    , @NamedQuery(name = "Visitors.findByVisitorContact", query = "SELECT v FROM Visitors v WHERE v.visitorContact = :visitorContact")})
public class Visitors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VISITOR_ID")
    private Integer visitorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "VISITOR_NAME")
    private String visitorName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "VISITOR_CONTACT")
    private String visitorContact;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visitorId")
    private Collection<RoadReport> roadReportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visitorId")
    private Collection<RoadSegmentReport> roadSegmentReportCollection;

    public Visitors() {
    }

    public Visitors(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public Visitors(Integer visitorId, String visitorName, String visitorContact) {
        this.visitorId = visitorId;
        this.visitorName = visitorName;
        this.visitorContact = visitorContact;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorContact() {
        return visitorContact;
    }

    public void setVisitorContact(String visitorContact) {
        this.visitorContact = visitorContact;
    }

    @XmlTransient
    public Collection<RoadReport> getRoadReportCollection() {
        return roadReportCollection;
    }

    public void setRoadReportCollection(Collection<RoadReport> roadReportCollection) {
        this.roadReportCollection = roadReportCollection;
    }

    @XmlTransient
    public Collection<RoadSegmentReport> getRoadSegmentReportCollection() {
        return roadSegmentReportCollection;
    }

    public void setRoadSegmentReportCollection(Collection<RoadSegmentReport> roadSegmentReportCollection) {
        this.roadSegmentReportCollection = roadSegmentReportCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visitorId != null ? visitorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitors)) {
            return false;
        }
        Visitors other = (Visitors) object;
        if ((this.visitorId == null && other.visitorId != null) || (this.visitorId != null && !this.visitorId.equals(other.visitorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "services.Visitors[ visitorId=" + visitorId + " ]";
    }
    
}
