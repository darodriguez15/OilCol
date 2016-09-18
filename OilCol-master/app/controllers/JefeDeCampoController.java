package controllers;

import dispatchers.AkkaDispatcher;
import java.util.concurrent.CompletableFuture;
import static play.libs.Json.toJson;
import models.ProductEntity;
import akka.dispatch.MessageDispatcher;
import play.mvc.*;
import java.util.concurrent.CompletionStage;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;

import models.JefeDeCampoEntity;

public class JefeDeCampoController  extends Controller
{


    public CompletionStage<Result> getJefesDeCampo() {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {
                            return JefeDeCampoEntity.FINDER.all();
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        jefeDeCampoEntities -> {
                            return ok(toJson(jefeDeCampoEntities));
                        }
                );
    }



    public CompletionStage<Result> getJefeDeCampo(Long id) {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {

                            return JefeDeCampoEntity.FINDER.byId(id);
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        jefeDeCampoEntities -> {
                            return ok(toJson(jefeDeCampoEntities));
                        }
                );
    }



    public CompletionStage<Result> createJefeDeCampo(){
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;
        JsonNode nJefeDeCampo = request().body().asJson();
        JefeDeCampoEntity con = Json.fromJson( nJefeDeCampo , JefeDeCampoEntity.class ) ;
        return CompletableFuture.supplyAsync(
                ()->{
                    con.save();
                    return con;
                }
        ).thenApply(
                jefeDeCampoEntity -> {
                    return ok(Json.toJson(jefeDeCampoEntity));
                }
        );
    }
}