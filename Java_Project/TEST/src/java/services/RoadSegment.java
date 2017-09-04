/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ROAD_SEGMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoadSegment.findAll", query = "SELECT r FROM RoadSegment r")
    , @NamedQuery(name = "RoadSegment.findByRoadSegmentId", query = "SELECT r FROM RoadSegment r WHERE r.roadSegmentId = :roadSegmentId")
    , @NamedQuery(name = "RoadSegment.findByRoadSegmentLatitude", query = "SELECT r FROM RoadSegment r WHERE r.roadSegmentLatitude = :roadSegmentLatitude")
    , @NamedQuery(name = "RoadSegment.findByRoadSegmentLongtitude", query = "SELECT r FROM RoadSegment r WHERE r.roadSegmentLongtitude = :roadSegmentLongtitude")
    , @NamedQuery(name = "RoadSegment.findByRoadSegmentMark", query = "SELECT r FROM RoadSegment r WHERE r.roadSegmentMark = :roadSegmentMark")})
public class RoadSegment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROAD_SEGMENT_ID")
    private Integer roadSegmentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ROAD_SEGMENT_LATITUDE")
    private String roadSegmentLatitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ROAD_SEGMENT_LONGTITUDE")
    private String roadSegmentLongtitude;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROAD_SEGMENT_MARK")
    private double roadSegmentMark;
    @JoinColumn(name = "ROAD_DATA_ID", referencedColumnName = "ROAD_DATA_ID")
    @ManyToOne(optional = false)
    private RoadData roadDataId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roadSegmentId")
    private Collection<RoadSegmentReport> roadSegmentReportCollection;

    public RoadSegment() {
    }

    public RoadSegment(Integer roadSegmentId) {
        this.roadSegmentId = roadSegmentId;
    }

    public RoadSegment(Integer roadSegmentId, String roadSegmentLatitude, String roadSegmentLongtitude, Double roadSegmentMark) {
        this.roadSegmentId = roadSegmentId;
        this.roadSegmentLatitude = roadSegmentLatitude;
        this.roadSegmentLongtitude = roadSegmentLongtitude;
        this.roadSegmentMark = roadSegmentMark;
    }

    public Integer getRoadSegmentId() {
        return roadSegmentId;
    }

    public void setRoadSegmentId(Integer roadSegmentId) {
        this.roadSegmentId = roadSegmentId;
    }

    public String getRoadSegmentLatitude() {
        return roadSegmentLatitude;
    }

    public void setRoadSegmentLatitude(String roadSegmentLatitude) {
        this.roadSegmentLatitude = roadSegmentLatitude;
    }

    public String getRoadSegmentLongtitude() {
        return roadSegmentLongtitude;
    }

    public void setRoadSegmentLongtitude(String roadSegmentLongtitude) {
        this.roadSegmentLongtitude = roadSegmentLongtitude;
    }

    public Double getRoadSegmentMark() {
        return roadSegmentMark;
    }

    public void setRoadSegmentMark(Double roadSegmentMark) {
        this.roadSegmentMark = roadSegmentMark;
    }

    public RoadData getRoadDataId() {
        return roadDataId;
    }

    public void setRoadDataId(RoadData roadDataId) {
        this.roadDataId = roadDataId;
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
        hash += (roadSegmentId != null ? roadSegmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoadSegment)) {
            return false;
        }
        RoadSegment other = (RoadSegment) object;
        if ((this.roadSegmentId == null && other.roadSegmentId != null) || (this.roadSegmentId != null && !this.roadSegmentId.equals(other.roadSegmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "services.RoadSegment[ roadSegmentId=" + roadSegmentId + " ]";
    }
    
}
