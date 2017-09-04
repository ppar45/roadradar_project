/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Parth
 */
@Entity
@Table(name = "ROAD_REPORT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoadReport.findAll", query = "SELECT r FROM RoadReport r")
    , @NamedQuery(name = "RoadReport.findByRoadReportId", query = "SELECT r FROM RoadReport r WHERE r.roadReportId = :roadReportId")
    , @NamedQuery(name = "RoadReport.findByReportDate", query = "SELECT r FROM RoadReport r WHERE r.reportDate = :reportDate")})
public class RoadReport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROAD_REPORT_ID")
    private Integer roadReportId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REPORT_DATE")
    @Temporal(TemporalType.DATE)
    private Date reportDate;
    @JoinColumn(name = "ROAD_DATA_ID", referencedColumnName = "ROAD_DATA_ID")
    @ManyToOne(optional = false)
    private RoadData roadDataId;
    @JoinColumn(name = "VISITOR_ID", referencedColumnName = "VISITOR_ID")
    @ManyToOne(optional = false)
    private Visitors visitorId;

    public RoadReport() {
    }

    public RoadReport(Integer roadReportId) {
        this.roadReportId = roadReportId;
    }

    public RoadReport(Integer roadReportId, Date reportDate) {
        this.roadReportId = roadReportId;
        this.reportDate = reportDate;
    }

    public Integer getRoadReportId() {
        return roadReportId;
    }

    public void setRoadReportId(Integer roadReportId) {
        this.roadReportId = roadReportId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public RoadData getRoadDataId() {
        return roadDataId;
    }

    public void setRoadDataId(RoadData roadDataId) {
        this.roadDataId = roadDataId;
    }

    public Visitors getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Visitors visitorId) {
        this.visitorId = visitorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roadReportId != null ? roadReportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoadReport)) {
            return false;
        }
        RoadReport other = (RoadReport) object;
        if ((this.roadReportId == null && other.roadReportId != null) || (this.roadReportId != null && !this.roadReportId.equals(other.roadReportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "services.RoadReport[ roadReportId=" + roadReportId + " ]";
    }
    
}
