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
@Table(name = "ROAD_SEGMENT_REPORT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoadSegmentReport.findAll", query = "SELECT r FROM RoadSegmentReport r")
    , @NamedQuery(name = "RoadSegmentReport.findByRoadSegmengReportId", query = "SELECT r FROM RoadSegmentReport r WHERE r.roadSegmengReportId = :roadSegmengReportId")
    , @NamedQuery(name = "RoadSegmentReport.findByReportDate", query = "SELECT r FROM RoadSegmentReport r WHERE r.reportDate = :reportDate")})
public class RoadSegmentReport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROAD_SEGMENG_REPORT_ID")
    private Integer roadSegmengReportId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REPORT_DATE")
    @Temporal(TemporalType.DATE)
    private Date reportDate;
    @JoinColumn(name = "ROAD_SEGMENT_ID", referencedColumnName = "ROAD_SEGMENT_ID")
    @ManyToOne(optional = false)
    private RoadSegment roadSegmentId;
    @JoinColumn(name = "VISITOR_ID", referencedColumnName = "VISITOR_ID")
    @ManyToOne(optional = false)
    private Visitors visitorId;

    public RoadSegmentReport() {
    }

    public RoadSegmentReport(Integer roadSegmengReportId) {
        this.roadSegmengReportId = roadSegmengReportId;
    }

    public RoadSegmentReport(Integer roadSegmengReportId, Date reportDate) {
        this.roadSegmengReportId = roadSegmengReportId;
        this.reportDate = reportDate;
    }

    public Integer getRoadSegmengReportId() {
        return roadSegmengReportId;
    }

    public void setRoadSegmengReportId(Integer roadSegmengReportId) {
        this.roadSegmengReportId = roadSegmengReportId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public RoadSegment getRoadSegmentId() {
        return roadSegmentId;
    }

    public void setRoadSegmentId(RoadSegment roadSegmentId) {
        this.roadSegmentId = roadSegmentId;
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
        hash += (roadSegmengReportId != null ? roadSegmengReportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoadSegmentReport)) {
            return false;
        }
        RoadSegmentReport other = (RoadSegmentReport) object;
        if ((this.roadSegmengReportId == null && other.roadSegmengReportId != null) || (this.roadSegmengReportId != null && !this.roadSegmengReportId.equals(other.roadSegmengReportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "services.RoadSegmentReport[ roadSegmengReportId=" + roadSegmengReportId + " ]";
    }
    
}
