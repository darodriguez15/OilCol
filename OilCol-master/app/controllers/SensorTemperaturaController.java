package controllers;

import dispatchers.AkkaDispatcher;
import java.util.concurrent.CompletableFuture;
import static play.libs.Json.toJson;
import models.SensorTemperaturaEntity;
import akka.dispatch.MessageDispatcher;
import play.mvc.*;
import java.util.concurrent.CompletionStage;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import views.html.*;
import play.data.Form;
public class SensorTemperaturaController  extends Controller
{


    public CompletionStage<Result> getSensoresTemperatura() {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {
                            return SensorTemperaturaEntity.FINDER.all();
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        sensorTemperaturaEntities -> {
                            return ok(toJson(sensorTemperaturaEntities));
                        }
                );
    }



    public CompletionStage<Result> getSensorTemperatura(Long id) {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {

                            return SensorTemperaturaEntity.FINDER.byId(id);
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        sensorTemperaturaEntities -> {
                            return ok(toJson(sensorTemperaturaEntities));
                        }
                );
    }



    public CompletionStage<Result> createSensorTemperatura(){
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;
        JsonNode nSensorTemperatura = request().body().asJson();
      SensorTemperaturaEntity con = Form.form(SensorTemperaturaEntity.class).bindFromRequest().get();
        return CompletableFuture.supplyAsync(
                ()->{
                    con.save();
                    return con;
                }
        ).thenApply(
                sensorTemperaturaEntity -> {
                    return ok(Json.toJson(sensorTemperaturaEntity));
                }
        );
    }
}