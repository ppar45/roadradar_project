package services;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import services.RoadSegment;
import services.Visitors;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-02T14:27:37")
@StaticMetamodel(RoadSegmentReport.class)
public class RoadSegmentReport_ { 

    public static volatile SingularAttribute<RoadSegmentReport, Date> reportDate;
    public static volatile SingularAttribute<RoadSegmentReport, Integer> roadSegmengReportId;
    public static volatile SingularAttribute<RoadSegmentReport, RoadSegment> roadSegmentId;
    public static volatile SingularAttribute<RoadSegmentReport, Visitors> visitorId;

}