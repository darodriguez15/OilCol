package controllers;

import dispatchers.AkkaDispatcher;
import java.util.concurrent.CompletableFuture;
import static play.libs.Json.toJson;
import akka.dispatch.MessageDispatcher;
import play.mvc.*;
import java.util.concurrent.CompletionStage;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;

import models.ConsumoEnergiaEntity;

public class ConsumoEnergiaController  extends Controller
{


    public CompletionStage<Result> getConsumosEnergia() {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {
                            return ConsumoEnergiaEntity.FINDER.all();
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        consumoEnergiaEntities -> {
                            return ok(toJson(consumoEnergiaEntities));
                        }
                );
    }



    public CompletionStage<Result> getConsumoEnergia(Long id) {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {

                            return ConsumoEnergiaEntity.FINDER.byId(id);
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        consumoEnergiaEntities -> {
                            return ok(toJson(consumoEnergiaEntities));
                        }
                );
    }



    public CompletionStage<Result> createConsumoEnergia(){
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;
        JsonNode nConsumoEnergia = request().body().asJson();
        ConsumoEnergiaEntity con = Json.fromJson( nConsumoEnergia , ConsumoEnergiaEntity.class ) ;
        return CompletableFuture.supplyAsync(
                ()->{
                    con.save();
                    return con;
                }
        ).thenApply(
                consumoEnergiaEntity -> {
                    return ok(Json.toJson(consumoEnergiaEntity));
                }
        );
    }
}