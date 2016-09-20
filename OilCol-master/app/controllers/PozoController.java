package controllers;

import dispatchers.AkkaDispatcher;
import java.util.concurrent.CompletableFuture;
import static play.libs.Json.toJson;
import models.PozoEntity;
import akka.dispatch.MessageDispatcher;
import play.mvc.*;
import java.util.concurrent.CompletionStage;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;

public class PozoController  extends Controller
{


    public CompletionStage<Result> getPozos() {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {
                            return PozoEntity.FINDER.all();
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        pozoEntities -> {
                            return ok(toJson(pozoEntities));
                        }
                );
    }





    public CompletionStage<Result> getPozo(Long id) {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {

                            return PozoEntity.FINDER.byId(id);
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        pozoEntities -> {
                            return ok(toJson(pozoEntities));
                        }
                );
    }








        public CompletionStage<Result> cambiarPozo(Long id, String estado ) {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;
        PozoEntity con = PozoEntity.FINDER.byId(id);        con.setEstado(estado);
        return CompletableFuture.supplyAsync(
                        () -> {


                            con.save();
                            return con;

                        }
                        ,jdbcDispatcher)
                .thenApply(
                        pozoEntity -> {
                            return ok(toJson(pozoEntity));
                        }
                );
    }


    public CompletionStage<Result> createPozo(){
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;
        JsonNode nPozo = request().body().asJson();
        PozoEntity con = Json.fromJson( nPozo , PozoEntity.class ) ;
        return CompletableFuture.supplyAsync(
                ()->{
                    con.save();
                    return con;
                }
        ).thenApply(
                pozoEntity -> {
                    return ok(Json.toJson(pozoEntity));
                }
        );
    }
}