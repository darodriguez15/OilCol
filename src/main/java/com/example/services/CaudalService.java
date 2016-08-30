/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.main.PersistenceManager;
import com.example.models.Caudal;
import com.example.models.CaudalDTO;
import com.example.models.Reporte;
import com.example.models.ReporteDTO;
        
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONObject;
/**
 *
 * @author fa.vera10
 */
@Path("/caudal")
@Produces(MediaType.APPLICATION_JSON)
public class CaudalService 
{
    @PersistenceContext(unitName ="OilPU")
    EntityManager entityManager; 
    
    @PostConstruct
    public void init() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        Query q = entityManager.createQuery("select u from Caudal u order by u.id ASC");
        List<Reporte> reportes = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(reportes).build();
    } 
    
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCaudal(CaudalDTO caudal) {
        JSONObject rta = new JSONObject();
        Caudal rep = new Caudal();
        rep.setCaudal(caudal.getCaudal()
        
        );
      
 
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(rep);
            entityManager.getTransaction().commit();
            entityManager.refresh(rep);
            rta.put("caudal_id", rep.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            rep = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    } 
    
    
    
}