

 function Agregar(){
        alert("Soy funcion");
     document.getElementById(mainContent).innerHTML = "<include src='almacenes.zul'>";
 };


var nuevo = zk.Widget.$('$nuevo');
nuevo.setValue("Yo soy el nuevo");
