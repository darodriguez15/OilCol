package controllers;

import dispatchers.AkkaDispatcher;
import java.util.concurrent.CompletableFuture;
import static play.libs.Json.toJson;
import models.CaudalEntity;
import akka.dispatch.MessageDispatcher;
import play.mvc.*;
import java.util.concurrent.CompletionStage;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;

public class CaudalController  extends Controller
{


    public CompletionStage<Result> getCaudales() {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {
                            return CaudalEntity.FINDER.all();
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        caudalEntities -> {
                            return ok(toJson(caudalEntities));
                        }
                );
    }



    public CompletionStage<Result> getCaudal(Long id) {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {

                            return CaudalEntity.FINDER.byId(id);
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        caudalEntities -> {
                            return ok(toJson(caudalEntities));
                        }
                );
    }



    public CompletionStage<Result> createCaudal(){
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;
        JsonNode nCaudal = request().body().asJson();
        CaudalEntity cau = Json.fromJson( nCaudal , CaudalEntity.class ) ;
        return CompletableFuture.supplyAsync(
                ()->{
                    cau.save();
                    return cau;
                }
        ).thenApply(
                caudalEntity -> {
                    return ok(Json.toJson(caudalEntity));
                }
        );
    }
}