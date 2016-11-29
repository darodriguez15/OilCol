package controllers;

import dispatchers.AkkaDispatcher;
import java.util.concurrent.CompletableFuture;
import static play.libs.Json.toJson;
import models.ReporteEntity;
import akka.dispatch.MessageDispatcher;
import play.mvc.*;
import java.util.concurrent.CompletionStage;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import views.html.*;
import play.data.Form;
import models.SensoresSegurosEntity;
import java.util.List;
import java.util.Date;

public class ReporteController  extends Controller
{


    public CompletionStage<Result> getReportes() {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {
                            return ReporteEntity.FINDER.all();
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        reporteEntities -> {
                            return ok(toJson(reporteEntities));
                        }
                );
    }



    public CompletionStage<Result> getReporte(Long id) {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {

                            return ReporteEntity.FINDER.byId(id);
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        reporteEntities -> {
                            return ok(toJson(reporteEntities));
                        }
                );
    }
    
 


    public CompletionStage<Result> createReporte() {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;
        JsonNode nReporte = request().body().asJson();
        ReporteEntity con = Form.form(ReporteEntity.class).bindFromRequest().get();
        String contra = con.getContrasenaSensor();
        String id = con.getIdSensor();

        List x = SensoresSegurosEntity.FINDER.where().like("idPozo", "%"+id+"%").findList();

        for(int i = 0; i<x.size();i++)
        {
            SensoresSegurosEntity s = (SensoresSegurosEntity)x.get(i);
            if(!s.getContraseña().equals(contra))
            {
               return null;
            }
        }


            return CompletableFuture.supplyAsync(
                ()->{
                    con.save();
                    return con;
                }
        ).thenApply(
                reporteEntity -> {
                    return ok(Json.toJson(reporteEntity));
                }
        );
    }
}