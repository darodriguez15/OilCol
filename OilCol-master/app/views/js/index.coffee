$ ->
  $.get  "/caudales", (caudales)->
    $.each caudales,(index, caudal)->
      $('#caudales').append $('<li>').text caudal.caudal
