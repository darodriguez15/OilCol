/**
 * Created by jc.gomez18 on 17/11/2016.
 */
$.ajax({
    method: "GET",
    url:"/pozos"
}).done(function(msg){
    console.log(msg [5]);
    var pozos = [];
    for(var i=0;i<msg.length;i++){
        var este = {idPozo:msg[i].id,latt:msg[i].lat,long:msg[i].lon,est:msg[i].estado};
        var pozoActual = [este.idPozo,este.latt,este.long,este.est];
        pozos.push(pozoActual);
    }
    console.log(pozos);
    $('#caudales').DataTable({
        data: pozos,
        columns: [
            { title: "ID Pozo"},
            { title: "Latitud"},
            { title: "Longitud"},
            { title: "Estado"}
        ]
    });

});

//Post pozo
$('#btnSave').click(function() {
    console.log("Click en Guardar")
    console.log($('#longitud').val());
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "/pozo");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify({
        "lon": $('#longitud').val(),
        "lat": $('#latitud').val(),
        "estado": $('#estado').val(),
        "campo": {
            "id": 2,
            "idJefeCampo": {
                "username": "tamuTAMU1",
                "type": null,
                "password": null,
                "notifications": []
            },
            "region": "AMAZONAS",
            "pozos": []
        }
    }));
});