package controllers;

import dispatchers.AkkaDispatcher;
import java.util.concurrent.CompletableFuture;
import static play.libs.Json.toJson;
import models.SensorEmergenciaEntity;
import akka.dispatch.MessageDispatcher;
import play.mvc.*;
import java.util.concurrent.CompletionStage;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;

public class SensorEmergenciaController  extends Controller
{


    public CompletionStage<Result> getSensoresEmergencia() {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {
                            return SensorEmergenciaEntity.FINDER.all();
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        sensorEmergenciaEntities -> {
                            return ok(toJson(sensorEmergenciaEntities));
                        }
                );
    }



    public CompletionStage<Result> getSensorEmergencia(Long id) {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {

                            return SensorEmergenciaEntity.FINDER.byId(id);
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        sensorEmergenciaEntities -> {
                            return ok(toJson(sensorEmergenciaEntities));
                        }
                );
    }



    public CompletionStage<Result> createSensorEmergencia(){
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;
        JsonNode nSensorEmergencia = request().body().asJson();
      SensorEmergenciaEntity con = Json.fromJson( nSensorEmergencia , SensorEmergenciaEntity.class ) ;
        return CompletableFuture.supplyAsync(
                ()->{
                    con.save();
                    return con;
                }
        ).thenApply(
                sensorEmergenciaEntity -> {
                    return ok(Json.toJson(sensorEmergenciaEntity));
                }
        );
    }
}