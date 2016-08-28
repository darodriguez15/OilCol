/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.main.PersistenceManager;
import com.example.models.JefeAsignado;
import com.example.models.JefeAsignadoDTO;
import com.example.models.JefeDeCampo;
import com.example.models.JefeDeCampoDTO;
import com.example.models.Pozo;
import com.example.models.PozoDTO;
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
 * @author da.rodriguez15
 */
@Path("/jefes")
@Produces(MediaType.APPLICATION_JSON)
public class JefesService {
    
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
    @Path("/getjefecampo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJefesCampo() {
        Query q = entityManager.createQuery("select u from JefeDeCampo u order by u.id ASC");
        List<JefeDeCampo> jcs = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(jcs).build();
    } 
    
    
    @GET
    @Path("/getjefeasignado")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJefesAsignados() {
        Query q = entityManager.createQuery("select u from JefeAsignado u order by u.id ASC");
        List<JefeAsignado> jefes = q.getResultList();
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(jefes).build();
    } 
    
    @POST
    @Path("/addJc")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createJefeCampo(JefeDeCampoDTO jefe) {
        JSONObject rta = new JSONObject();
        JefeDeCampo j = new JefeDeCampo();
        j.setNombre(jefe.getNombre());
        j.setCedula(jefe.getCedula());
        j.setDireccion(jefe.getDireccion());
        j.setEdad(jefe.getEdad());
        j.setNacionalidad(jefe.getNacionalidad());
        j.setTelefono(jefe.getTelefono());
 
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(j);
            entityManager.getTransaction().commit();
            entityManager.refresh(j);
            rta.put("jefedecampo_id", j.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            j = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    } 
    
    
    @POST
    @Path("/addJa")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createJefeAsignado(JefeAsignadoDTO jefe) {
        JSONObject rta = new JSONObject();
        JefeAsignado j = new JefeAsignado();
        j.setNombre(jefe.getNombre());
        j.setCedula(jefe.getCedula());
        j.setDireccion(jefe.getDireccion());
        j.setEdad(jefe.getEdad());
        j.setNacionalidad(jefe.getNacionalidad());
        j.setTelefono(jefe.getTelefono());
 
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(j);
            entityManager.getTransaction().commit();
            entityManager.refresh(j);
            rta.put("jefeasignado_id", j.getId());
        } catch (Throwable t) {
            t.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            j = null;
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(rta).build();
    } 
    
    
    
    
}
