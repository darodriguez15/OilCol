package controllers;

import dispatchers.AkkaDispatcher;
import java.util.concurrent.CompletableFuture;
import static play.libs.Json.toJson;
import models.JefeAsignadoEntity;
import akka.dispatch.MessageDispatcher;
import play.mvc.*;
import java.util.concurrent.CompletionStage;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import views.html.*;
import play.data.Form;
public class JefeAsignadoController  extends Controller
{

    public CompletionStage<Result> getJefesAsignado() {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {
                            return JefeAsignadoEntity.FINDER.all();
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        jefeAsignadoEntities -> {
                            return ok(toJson(jefeAsignadoEntities));
                        }
                );
    }



    public CompletionStage<Result> getJefeAsignado(Long id) {
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;

        return CompletableFuture.
                supplyAsync(
                        () -> {

                            return JefeAsignadoEntity.FINDER.byId(id);
                        }
                        ,jdbcDispatcher)
                .thenApply(
                        jefeAsignadoEntities -> {
                            return ok(toJson(jefeAsignadoEntities));
                        }
                );
    }



    public CompletionStage<Result> createJefeAsignado(){
        MessageDispatcher jdbcDispatcher = AkkaDispatcher.jdbcDispatcher;
        JsonNode nJefeAsignado = request().body().asJson();
        JefeAsignadoEntity con = Form.form(JefeAsignadoEntity.class).bindFromRequest().get();
        return CompletableFuture.supplyAsync(
                ()->{
                    con.save();
                    return con;
                }
        ).thenApply(
                jefeAsignadoEntity -> {
                    return ok(Json.toJson(jefeAsignadoEntity));
                }
        );
    }
}