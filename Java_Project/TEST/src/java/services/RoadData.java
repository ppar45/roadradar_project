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
@Table(name = "ROAD_DATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoadData.findAll", query = "SELECT r FROM RoadData r")
    , @NamedQuery(name = "RoadData.findByRoadDataId", query = "SELECT r FROM RoadData r WHERE r.roadDataId = :roadDataId")
    , @NamedQuery(name = "RoadData.findByRoadName", query = "SELECT r FROM RoadData r WHERE r.roadName = :roadName")
    , @NamedQuery(name = "RoadData.findByStartLatitude", query = "SELECT r FROM RoadData r WHERE r.startLatitude = :startLatitude")
    , @NamedQuery(name = "RoadData.findByStartLongtitude", query = "SELECT r FROM RoadData r WHERE r.startLongtitude = :startLongtitude")
    , @NamedQuery(name = "RoadData.findByEndLatitude", query = "SELECT r FROM RoadData r WHERE r.endLatitude = :endLatitude")
    , @NamedQuery(name = "RoadData.findByEndLongtitude", query = "SELECT r FROM RoadData r WHERE r.endLongtitude = :endLongtitude")
    , @NamedQuery(name = "RoadData.findByRoadAverageMark", query = "SELECT r FROM RoadData r WHERE r.roadAverageMark = :roadAverageMark")})
public class RoadData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROAD_DATA_ID")
    private Integer roadDataId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ROAD_NAME")
    private String roadName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "START_LATITUDE")
    private String startLatitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "START_LONGTITUDE")
    private String startLongtitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "END_LATITUDE")
    private String endLatitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "END_LONGTITUDE")
    private String endLongtitude;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROAD_AVERAGE_MARK")
    private BigDecimal roadAverageMark;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roadDataId")
    private Collection<RoadReport> roadReportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roadDataId")
    private Collection<RoadSegment> roadSegmentCollection;

    public RoadData() {
    }

    public RoadData(Integer roadDataId) {
        this.roadDataId = roadDataId;
    }

    public RoadData(Integer roadDataId, String roadName, String startLatitude, String startLongtitude, String endLatitude, String endLongtitude, BigDecimal roadAverageMark) {
        this.roadDataId = roadDataId;
        this.roadName = roadName;
        this.startLatitude = startLatitude;
        this.startLongtitude = startLongtitude;
        this.endLatitude = endLatitude;
        this.endLongtitude = endLongtitude;
        this.roadAverageMark = roadAverageMark;
    }

    public Integer getRoadDataId() {
        return roadDataId;
    }

    public void setRoadDataId(Integer roadDataId) {
        this.roadDataId = roadDataId;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(String startLatitude) {
        this.startLatitude = startLatitude;
    }

    public String getStartLongtitude() {
        return startLongtitude;
    }

    public void setStartLongtitude(String startLongtitude) {
        this.startLongtitude = startLongtitude;
    }

    public String getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(String endLatitude) {
        this.endLatitude = endLatitude;
    }

    public String getEndLongtitude() {
        return endLongtitude;
    }

    public void setEndLongtitude(String endLongtitude) {
        this.endLongtitude = endLongtitude;
    }

    public BigDecimal getRoadAverageMark() {
        return roadAverageMark;
    }

    public void setRoadAverageMark(BigDecimal roadAverageMark) {
        this.roadAverageMark = roadAverageMark;
    }

    @XmlTransient
    public Collection<RoadReport> getRoadReportCollection() {
        return roadReportCollection;
    }

    public void setRoadReportCollection(Collection<RoadReport> roadReportCollection) {
        this.roadReportCollection = roadReportCollection;
    }

    @XmlTransient
    public Collection<RoadSegment> getRoadSegmentCollection() {
        return roadSegmentCollection;
    }

    public void setRoadSegmentCollection(Collection<RoadSegment> roadSegmentCollection) {
        this.roadSegmentCollection = roadSegmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roadDataId != null ? roadDataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoadData)) {
            return false;
        }
        RoadData other = (RoadData) object;
        if ((this.roadDataId == null && other.roadDataId != null) || (this.roadDataId != null && !this.roadDataId.equals(other.roadDataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "services.RoadData[ roadDataId=" + roadDataId + " ]";
    }
    
}
