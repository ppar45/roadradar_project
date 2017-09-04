/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Parth
 */
@Entity
@Table(name = "REPORT_TABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportTable.findAll", query = "SELECT r FROM ReportTable r")
    , @NamedQuery(name = "ReportTable.findById", query = "SELECT r FROM ReportTable r WHERE r.id = :id")
    , @NamedQuery(name = "ReportTable.findByIssueType", query = "SELECT r FROM ReportTable r WHERE r.issueType = :issueType")
    , @NamedQuery(name = "ReportTable.findByLatitude", query = "SELECT r FROM ReportTable r WHERE r.latitude = :latitude")
    , @NamedQuery(name = "ReportTable.findByLongitude", query = "SELECT r FROM ReportTable r WHERE r.longitude = :longitude")
    , @NamedQuery(name = "ReportTable.findByReportDate", query = "SELECT r FROM ReportTable r WHERE r.reportDate = :reportDate")})
public class ReportTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ID")
    private String id;
    @Size(max = 20)
    @Column(name = "ISSUE_TYPE")
    private String issueType;
    @Size(max = 20)
    @Column(name = "LATITUDE")
    private String latitude;
    @Size(max = 20)
    @Column(name = "LONGITUDE")
    private String longitude;
    @Size(max = 20)
    @Column(name = "REPORT_DATE")
    private String reportDate;

    public ReportTable() {
    }
    
        public ReportTable(String id, String issueType, String latitude, String longtitude, String reportDate) {
        this.id = id;
        this.issueType = issueType;
        this.latitude = latitude;
        this.longitude = longtitude;
        this.reportDate = reportDate;
    }

    public ReportTable(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportTable)) {
            return false;
        }
        ReportTable other = (ReportTable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "services.ReportTable[ id=" + id + " ]";
    }
    
}
