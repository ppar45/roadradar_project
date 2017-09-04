/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import services.RoadCondition;
import services.RoadSegment;

/**
 *
 * @author Parth
 */
@Stateless
@Path("services.roadsegment")
public class RoadSegmentFacadeREST extends AbstractFacade<RoadSegment> {

    @PersistenceContext(unitName = "TESTPU")
    private EntityManager em;

    public RoadSegmentFacadeREST() {
        super(RoadSegment.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(RoadSegment entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, RoadSegment entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

      @GET
    @Path("getRoadCondition/{newStart}/{newEnd}")
    @Produces({"application/json"})
    public RoadCondition getRoadCondition(@PathParam("newStart") String newStart, @PathParam("newEnd") String newEnd) throws JSONException {
        
        String BASE_URI = "https://maps.googleapis.com/maps/api/directions/json?origin=";
        String APIKey = "AIzaSyCUOEfSlgXlMJwMgLi3zqh__TqWk0Z6YiE";
        double arg_mark = 0.0;
        double TOLRATE = 0.0001;
        int count = 0;
           
       int i_start = newStart.lastIndexOf(", ");
       String start1 = newStart.substring(0, i_start - 1);
       String start2 = newStart.substring(i_start, newStart.length());
       String start3 = start1.replace(",", "");
       String start = start3.replace(' ', '+') + start2.replace(' ', '+');
       
       
       int i_end = newEnd.lastIndexOf(", ");
       String end1 = newEnd.substring(0, i_end - 1);
       String end2 = newEnd.substring(i_end, newEnd.length());
       String end3 = end1.replace(",", "");
       String end = end3.replace(' ', '+') + end2.replace(' ', '+');       
       
       
        String methodPath = start + "&destination=" + end + "&key=" + APIKey;
        URL url = null;
        HttpURLConnection conn = null;
        String jasonString ="";
        int roadId = 1;
        ArrayList<String> rcs = new ArrayList<String>();
        
        try {
            url = new URL(BASE_URI + methodPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            Scanner inStream = new Scanner(conn.getInputStream());

            while (inStream.hasNextLine()) {
                jasonString += inStream.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        
        JSONObject jo = new JSONObject(jasonString);
        

        
        JSONArray jo1 = jo.getJSONArray("routes");
       

            
            JSONObject jo2 = jo1.getJSONObject(0);
            JSONArray jo3 = jo2.getJSONArray("legs");   
            JSONObject jo4 = jo3.getJSONObject(0);  
            
            //get middle point name
            String midPoint = jo2.getString("summary");
            JSONObject joD = jo4.getJSONObject("distance");
            String distance = joD.getString("text") + "les";
            JSONObject joDu = jo4.getJSONObject("duration");
            String duration = joDu.getString("text");
            
            
            JSONArray ja1 = jo4.getJSONArray("steps");
            ArrayList<RoadSegment> rds = new ArrayList<RoadSegment>();
            
            for(int j = 0; j < ja1.length(); j++){
                JSONObject jo5 = ja1.getJSONObject(0).getJSONObject("end_location");
                Double lat = jo5.getDouble("lat");
                
                DecimalFormat df = new DecimalFormat();
                String style = "0.00000";
                df.applyPattern(style);
                                
                String latS = df.format(lat);
                
                Double lng = jo5.getDouble("lng");              
                String lngS = df.format(lng);
                
                RoadSegment rd = new RoadSegment(roadId);
                rd.setRoadSegmentLatitude(latS);
                rd.setRoadSegmentLongtitude(lngS);
                rds.add(rd);
                roadId++;
                
            }
            

        List<RoadSegment> rd_datas = new ArrayList<RoadSegment>();
        Query query = em.createNamedQuery("RoadSegment.findAll");
        rd_datas = query.getResultList();
        
        // Google Map API lat$lng rds
        for(int k = 0; k < rds.size(); k++){
        
           RoadSegment resRd = rds.get(k);
           
           // database rd_dates
           for(int j = 0; j < rd_datas.size(); j++){
               
               double error = Math.abs(Double.valueOf(rd_datas.get(j).getRoadSegmentLatitude())) - Math.abs(Double.valueOf(rds.get(k).getRoadSegmentLatitude()));
               if(error <= TOLRATE){
                   arg_mark = arg_mark + rd_datas.get(j).getRoadSegmentMark();
                   count++;
               }
           }
           
            arg_mark = arg_mark / count;
            
        }
            
       
        RoadCondition rc = new RoadCondition(Double.toString(arg_mark), midPoint, duration, distance);
        
        return rc;
              
        
    }
     
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public RoadSegment find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RoadSegment> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RoadSegment> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
