package services;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import services.RoadReport;
import services.RoadSegment;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-02T14:27:37")
@StaticMetamodel(RoadData.class)
public class RoadData_ { 

    public static volatile SingularAttribute<RoadData, String> startLatitude;
    public static volatile SingularAttribute<RoadData, BigDecimal> roadAverageMark;
    public static volatile SingularAttribute<RoadData, String> endLongtitude;
    public static volatile CollectionAttribute<RoadData, RoadSegment> roadSegmentCollection;
    public static volatile SingularAttribute<RoadData, String> startLongtitude;
    public static volatile CollectionAttribute<RoadData, RoadReport> roadReportCollection;
    public static volatile SingularAttribute<RoadData, Integer> roadDataId;
    public static volatile SingularAttribute<RoadData, String> endLatitude;
    public static volatile SingularAttribute<RoadData, String> roadName;

}