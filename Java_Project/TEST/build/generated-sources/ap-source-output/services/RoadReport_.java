package services;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import services.RoadData;
import services.Visitors;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-02T14:27:37")
@StaticMetamodel(RoadReport.class)
public class RoadReport_ { 

    public static volatile SingularAttribute<RoadReport, Date> reportDate;
    public static volatile SingularAttribute<RoadReport, Integer> roadReportId;
    public static volatile SingularAttribute<RoadReport, RoadData> roadDataId;
    public static volatile SingularAttribute<RoadReport, Visitors> visitorId;

}