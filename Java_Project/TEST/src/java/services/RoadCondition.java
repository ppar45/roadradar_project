/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author shelley
 */
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shelley
 */
@XmlRootElement
public class RoadCondition implements Serializable {

    private String roadCondition;
    private String middlePoint;
    private String duration;
    private String distance;

    public RoadCondition() {
    
}
    public RoadCondition(String roadCondition, String middlePoint, String duration, String distance){
        
        this.roadCondition = roadCondition;
        this.middlePoint = middlePoint;
        this.duration = duration;
        this.distance = distance;
    }

    public String getRoadCondition() {
        return roadCondition;
    }

    public void setRoadCondition(String roadCondition) {
        this.roadCondition = roadCondition;
    }

    public String getMiddlePoint() {
        return middlePoint;
    }

    public void setMiddlePoint(String middlePoint) {
        this.middlePoint = middlePoint;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
    



}

