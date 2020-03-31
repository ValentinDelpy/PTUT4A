<%-- 
    Document   : index
    Created on : 26 mars 2020, 13:46:22
    Author     : Soul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>EM Crisis</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="../css/main.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Telex&display=swap" rel="stylesheet">
        <style>
            body { 
                background: url("icones/background_main.svg") no-repeat center center fixed; 
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
                font-family: 'Telex', sans-serif;
                font-size: 59px;
                color:#2D9CDB;
            }
            .button{
                font-size:40px;
                border-radius:20px;
                border: 5px solid white;
                background-color:transparent;
                box-shadow:
                    0 1.9px 2.2px rgba(0, 0, 0, 0.02),
                    0 4.7px 5.3px rgba(0, 0, 0, 0.028),
                    0 8.8px 10px rgba(0, 0, 0, 0.035),
                    0 15.6px 17.9px rgba(0, 0, 0, 0.042),
                    0 29.2px 33.4px rgba(0, 0, 0, 0.05),
                    0 70px 80px rgba(0, 0, 0, 0.07)
                    ;
                text-shadow: 2px 4px 3px rgba(0,0,0,0.3);
                color:white;
                width:500px;
                height:100px;
                margin:10px;
            }

        </style>
    </head>
    <body>
        <div class="text-right">
            <img src="icones/isis_logo.png" class="img-fluid" width="100" height="100" alt="">

        </div>
        <div class="text-center">
            <img src="icones/main_icon.jpg" class="img-fluid" width="200" height="200" alt="">
            <br/>
            EM Crisis
            <br/>
            <br/>
            <br/>
            <button id="redirect" class="button">Earthquake</button><br/>
            <button id="redirect" class="button">Ebola Epidemic</button><br/>
            <button id="redirect" class="button">Terrorist Attack</button><br/>
        </div>
    </body>
<script type="text/javascript">
    document.getElementById("redirect").onclick = function () {
        location.href = "personal_infos.html";
        session
    };
    
    $.ajax({
          url: 'AddDisease',
          method: 'POST',
          data : { "interventions" : json,
                    "name" : $("#nameDisease").val()},
          dataType : "text/html"      
        });
      }   
    })
</script>
</html>
