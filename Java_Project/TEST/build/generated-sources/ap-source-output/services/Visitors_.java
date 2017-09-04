package services;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import services.RoadReport;
import services.RoadSegmentReport;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-02T14:27:37")
@StaticMetamodel(Visitors.class)
public class Visitors_ { 

    public static volatile SingularAttribute<Visitors, String> visitorName;
    public static volatile CollectionAttribute<Visitors, RoadReport> roadReportCollection;
    public static volatile CollectionAttribute<Visitors, RoadSegmentReport> roadSegmentReportCollection;
    public static volatile SingularAttribute<Visitors, String> visitorContact;
    public static volatile SingularAttribute<Visitors, Integer> visitorId;

}