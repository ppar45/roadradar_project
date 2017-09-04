package services;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import services.RoadData;
import services.RoadSegmentReport;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-02T14:27:37")
@StaticMetamodel(RoadSegment.class)
public class RoadSegment_ { 

    public static volatile SingularAttribute<RoadSegment, Double> roadSegmentMark;
    public static volatile SingularAttribute<RoadSegment, String> roadSegmentLatitude;
    public static volatile SingularAttribute<RoadSegment, String> roadSegmentLongtitude;
    public static volatile CollectionAttribute<RoadSegment, RoadSegmentReport> roadSegmentReportCollection;
    public static volatile SingularAttribute<RoadSegment, Integer> roadSegmentId;
    public static volatile SingularAttribute<RoadSegment, RoadData> roadDataId;

}