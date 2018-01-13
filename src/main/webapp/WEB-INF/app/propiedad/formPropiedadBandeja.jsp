<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <c:set var="contextPathUrl" scope="session" value="${pageContext.request.contextPath}"/>
        <title>Propiedades</title>
        <%@include file="../includes/includes.jsp"%>
        <style>
        .modal-header, h4, .close {
            background-color: #337ab7;
            color:white !important;
            text-align: center;
            font-size: 20px;
        }
        .modal-footer {
            background-color: #f9f9f9;
                         
        }
       
        .minusculas{
            text-transform:lowercase;
        }	
        .mayusculas{
            text-transform:uppercase;
        }
        .in.fade.modal {     
            bottom: auto;
        }
        </style>        
    </head>
    <body>
        <div class="container">        
            <div class="row">
                <div class="col-md-12">
                    <%@include file="../includes/menu.jsp" %>
                </div>
            </div>        
            <div class="row">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Propiedades</h3>
                    </div>      
                    <div class="panel-body">                  
                        <div class='col-md-3'>                    
                            <div class="form-group">                        
                                <div class='input-group date' id='datetimepicker6'>                            
                                    <input type='text' class="form-control" placeholder="Desde" id="txtDesde" value="${fechaDesde}" />
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class='col-md-3'>
                            <div class="form-group">
                                <div class='input-group date' id='datetimepicker7'>
                                    <input type='text' class="form-control" placeholder="Hasta" id="txtHasta" value="${fechaHasta}"/>
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                            </div>
                        </div>

                        <div class='col-md-3'>
                            <select id="selEstado" class="selectpicker" title="Estado">
                                <option value="0">TODOS</option>                 
                            </select>
                        </div>

                        <div class='col-md-3'>
                            <button type="button" class="btn btn-default" id="idBtnBuscar">Buscar</button>
                        </div> 
                    </div>
                </div>
            </div>     

            <div class="row">
                <div id="divErrorMessageConsultarSolicitudAlmancen" class="row divError">
                    <div class="col-xs-12">
                        <label id="etiquetaErrorConsultarSolicitudAlmancen" class="btn-sm"></label>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title" >Lista de Propiedades 
                            <button type="button" class="btn btn-default" style="float: right;" id="idBtnAgregar">Agregar</button>                            
                        </h3>
                    </div>      
                    <div class="panel-body">                      
                        <div class="col-md-12" id="divPedidosTable">  
                            <div class="table-responsive">
                            <table id="example" class="table table-striped table-bordered datatable" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>Codigo</th>
                                        <th>Asesor</th>
                                        <th>Propiedad</th>
                                        <th>Oferta</th>
                                        <th>Estado</th>
                                        <th>Distrito</th>
                                        <th>Mon</th>
                                        <th>Precio</th>
                                        <th>Tipo</th>
                                        <th>dimension</th>
                                        <th>comision</th>
                                        <th>Accion</th>
                                        <th>File</th>
                                    </tr>                                
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>Codigo</th>
                                        <th>Asesor</th>
                                        <th>Propiedad</th>
                                        <th>Oferta</th>
                                        <th>Estado</th>
                                        <th>Distrito</th>
                                        <th>Mon</th>
                                        <th>Precio</th>
                                        <th>Tipo</th>
                                        <th>dimension</th>
                                        <th>comision</th>
                                        <th>Accion</th>
                                        <th>File</th>
                                    </tr>                                  
                                </tfoot>
                                <tbody>
                                    <c:forEach items="${propiedades}" var="p" varStatus="i" >
                                        <tr>
                                            <td> ${p.codpropiedad} </td>
                                            <td> ${p.usuarioasesor} </td>
                                            <td> ${p.nombretipopropiedad} </td>
                                            <td> ${p.codtipooferta} </td>
                                            <td> ${p.codsituacionestado} </td>
                                            <td> ${p.nombredistrito} </td>
                                            <td> ${p.preciomoneda} </td>
                                            <td> ${p.preciovalor} </td>
                                            <td> ${p.areaterrenoum} </td>
                                            <td> ${p.areaterrenocantidad} </td>
                                            <td> ${p.comisionporcentaje} </td>
                                            <td> 
                                               <a href="#" onClick="javascript:wf_editar(${p.codpropiedad})" > Editar</a>
                                            </td>
                                            <td> FILE</td>
                                        </tr>
                                    </c:forEach>                                      
                                </tbody>
                            </table>
                            </div>
                            <div id="divPedidosPagerTable" class="jqGridGeneralPagerClass"></div>
                        </div>                        
                    </div>
                </div>
            </div>           

       

        </div>        

                                 
        <!-- Includes -->
        
        <jsp:include page="../propiedad/formPropiedadRegistro.jsp" />
        <jsp:include page="../propiedad/formPropiedadArchivoListado.jsp" />
        <jsp:include page="../propiedad/formPropiedadArchivo.jsp" />

        


<script type="text/javascript" src="${pageContext.request.contextPath}/js/commonGeneral.js"></script>

<script type="text/javascript">
    var contextPathUrl = "${contextPathUrl}";
    
//======================================
//inicio eventos personalizados
//======================================
//=========================INICIO DE BUSQUEDA DE PERSONAL DELEGADO A======================================

var tablaExample= $('#example').DataTable( {
	"language":"",
	oLanguage : {
		sLengthMenu	: "Mostrar _MENU_ registros",
		sZeroRecords: "No se encontraron resultados",
		sInfo		: "Mostrando del _START_ al _END_ de un total de _TOTAL_ registros",
		sInfoEmpty	: "Registros del 0 al 0 de un total de 0 registros",
		sEmptyTable	: '<i>No hay informacion de Personal</i>',
		sSearch		: "Buscar: ",
		sInfoFiltered: "(filtrado de un total de _MAX_ registros)",
		sLoadingRecords: "Cargando...",
		oPaginate : {
		"sFirst":    "Primero",
        "sLast":     "Ultimo",
        "sNext":     "Siguiente >",
        "sPrevious": "< Anterior"
		},
		oAria: {
			sSortAscending: ": Activar para ordenar la columna de manera ascendente",
			sSortDescending: ": Activar para ordenar la columna de manera descendente"
		}
	},
	columns : [
		{data :	"codpropiedad"},
		{data :	"usuarioasesor"},
		{data :	"nombretipopropiedad"},
		{data :	"codtipooferta"},
		{data :	"codsituacionestado"},
                {data :	"nombredistrito"},
                {data :	"preciomoneda"},
                {data :	"preciovalor"},
                {data :	"areaterrenoum"},
                {data :	"areaterrenocantidad"},
                {data :	"comisionporcentaje"},
                {render: function ( data, type, row ) {                    
                    return '<a href="#" onClick="javascript:wf_editar(' + row.codpropiedad + ')">Editar</a>';
                  }   
                },
                {render: function ( data, type, row ) {   
                    //return '<a href="' + contextPathUrl + '/archivos/file1?id=' + row.codusuario + '&idEntidad=ase">File</a>';
                    return '<a href="#" onClick="javascript:wf_verListaArchivo(' + row.codpropiedad + ')">Archivo</a>';
                  }   
                }
	],
        dom: 'Bfrtip',
	buttons: ['copy', 'csv', 'excel', 'pdf', 'print'],
        ordering			:	false,
        bScrollAutoCss		:	true,
        bStateSave			:	false,
        bAutoWidth			:	false,
        bScrollCollapse		:	false,
        searching			:	true,
        paging				:	true,
        pagingType			:   "full_numbers",
        iDisplayLength		:	7,
        responsive			:	true,
        bLengthChange		: 	false,
        fnDrawCallback		:	function(oSettings) {	
        if (oSettings.fnRecordsTotal() == 0) {
                $('#example_paginate').addClass('hiddenDiv'); //el footer de paginacion siempre tiene como ID "miTablaID_paginate"
                //no se oculta automaticamente
                //cuando hay 0 registros, por eso se oculta anadiendo el class .hiddenDiv
        }
        else {
                $('#example_paginate').removeClass('hiddenDiv');

                //$('#example td:nth-child('+(5)+')').hide(); //Oculta la columna (4)
                //$('#example td:nth-child('+(6)+')').hide(); //Oculta la columna (5)
        }
        }
   //
	        
}); //Fin de inicializar tabla

var tablaArchivoListado= $('#tablaarchivolistado').DataTable( {
	"language":"",
	oLanguage : {
		sLengthMenu	: "Mostrar _MENU_ registros",
		sZeroRecords: "No se encontraron resultados",
		sInfo		: "Mostrando del _START_ al _END_ de un total de _TOTAL_ registros",
		sInfoEmpty	: "Registros del 0 al 0 de un total de 0 registros",
		sEmptyTable	: '<i>No hay informacion de Personal</i>',
		sSearch		: "Buscar: ",
		sInfoFiltered: "(filtrado de un total de _MAX_ registros)",
		sLoadingRecords: "Cargando...",
		oPaginate : {
		"sFirst":    "Primero",
        "sLast":     "Ultimo",
        "sNext":     "Siguiente >",
        "sPrevious": "< Anterior"
		},
		oAria: {
			sSortAscending: ": Activar para ordenar la columna de manera ascendente",
			sSortDescending: ": Activar para ordenar la columna de manera descendente"
		}
	},
	columns : [
		{data :	"codpropiedadarchivo"},
		{render: function ( data, type, row ) {                    
                    return '<a href="#" onClick="javascript:wf_verImagen(\''+row.rutaarchivo + '\')">'+row.rutaarchivo+'</a>';
                  }   
                },
		{data :	"codtipoarchivo"},
		{data :	"codgrupoarchivo"},
		{data :	"estado"},                
                {render: function ( data, type, row ) {                    
                    return '<a href="#" onClick="javascript:wf_editarArchivo(' + row.codpropiedadarchivo + ')">Archivo</a>';
                  }   
                }
	],        
        ordering			:	false,
        bScrollAutoCss		:	true,
        bStateSave			:	false,
        bAutoWidth			:	false,
        bScrollCollapse		:	false,
        searching			:	true,
        paging				:	true,
        pagingType			:   "full_numbers",
        iDisplayLength		:	7,
        responsive			:	true,
        bLengthChange		: 	false,
        fnDrawCallback		:	function(oSettings) {	
        if (oSettings.fnRecordsTotal() == 0) {
                $('#tablaarchivolistado_paginate').addClass('hiddenDiv'); //el footer de paginacion siempre tiene como ID "miTablaID_paginate"
                //no se oculta automaticamente
                //cuando hay 0 registros, por eso se oculta anadiendo el class .hiddenDiv
        }
        else {
                $('#tablaarchivolistado_paginate').removeClass('hiddenDiv');

                //$('#example td:nth-child('+(5)+')').hide(); //Oculta la columna (4)
                //$('#example td:nth-child('+(6)+')').hide(); //Oculta la columna (5)
        }
        }
   //
	        
}); //Fin de inicializar tabla

        
//1. wf_buscar
function wf_buscar(){	
	var fechaDesdeText = $("#txtDesde").val();
	var fechaHastaText = $("#txtHasta").val();
	//hideElement("divErrorMessageConsultarSolicitudAlmancen");
	var flagValidacionFormulario = true;
	var errorMessage = "";	
        obtenerDatos();
        
    //
    
}

function obtenerDatos(){
    
        var ajax_data = {"id": "0"};
        $.ajax({
            url: contextPathUrl + "/propiedad/listar",
            data: ajax_data,
            type: "post",
            dataType: "json",
            cache: false,
            async: false,
            beforeSend: function () {
                console.log('flagEstadoPagina:e2');
            },
            complete: function () {
                console.log('flagEstadoPagina:e3');
            },
            success: function (respuesta) {                
                console.log(respuesta);                
                if(respuesta.propiedades.length > 0){
                    $('#example').dataTable().fnClearTable(); //limpia registros
                    $('#example').dataTable().fnAddData(respuesta.propiedades); //carga registros en grilla
                    $('#example').dataTable().fnDraw(); //redibuja objeto
                }else{
                    $('#example').dataTable().fnClearTable();
                }
            },
            error: function () {
                console.log('error moises 1');
                
            }
        });
}

function obtenerDatosArchivoListado(codpropiedad){
    
        var ajax_data = {"codpropiedad": codpropiedad};
        $.ajax({
            url: contextPathUrl + "/propiedadArchivo/listar",
            data: ajax_data,
            type: "post",
            dataType: "json",
            cache: false,
            async: false,
            beforeSend: function () {
                console.log('flagEstadoPagina:e2');
            },
            complete: function () {
                console.log('flagEstadoPagina:e3');
            },
            success: function (respuesta) {                
                console.log(respuesta);                
                if(respuesta.propiedadArchivos.length > 0){
                    $('#tablaarchivolistado').dataTable().fnClearTable(); //limpia registros
                    $('#tablaarchivolistado').dataTable().fnAddData(respuesta.propiedadArchivos); //carga registros en grilla
                    $('#tablaarchivolistado').dataTable().fnDraw(); //redibuja objeto
                }else{
                    $('#tablaarchivolistado').dataTable().fnClearTable();
                }
            },
            error: function () {
                console.log('error moises 1');
                
            }
        });
}
//1. wf_agregar
    function wf_agregar() {
        $("#id_flagEstadoPagina").val("");
        var flagEstadoPagina = "A";
        var ajax_data = {"id": "0"};
        
        $.ajax({
            url: contextPathUrl + "/propiedad/agregar",
            data: ajax_data,
            type: "post",
            dataType: "json",
            cache: false,
            async: false,
            beforeSend: function () {
                console.log('flagEstadoPagina:e2');
            },
            complete: function () {
                console.log('flagEstadoPagina:e3');
            },
            success: function (respuesta) {
                var flagEstadoPagina = respuesta.flagEstadoPagina;
                console.log('flagEstadoPagina:e4');
                $('#idFormRegistro')[0].reset();
                if (flagEstadoPagina == "A") {                    
                    $("#id_flagEstadoPagina").val("A");
                    $("#id_codpropiedad").val(respuesta.propiedad.codpropiedad);
                    $("#id_codusuarioasesor").val(respuesta.propiedad.codusuarioasesor);
                    $("#id_codpais").val(respuesta.propiedad.codpais);
                    $("#id_coddepartamento").val(respuesta.propiedad.coddepartamento);
                    $("#id_codprovincia").val(respuesta.propiedad.codprovincia);
                    $("#id_coddistrito").val(respuesta.propiedad.coddistrito);
                    $("#id_preciomoneda").val(respuesta.propiedad.preciomoneda);
                    $("#id_preciovalor").val(respuesta.propiedad.preciovalor);                    
                    $("#id_areaterrenoum").val(respuesta.propiedad.areaterrenoum);
                    $("#id_areaterrenocantidad").val(respuesta.propiedad.areaterrenocantidad);                    
                    $("#id_comisionporcentaje").val(respuesta.propiedad.comisionporcentaje);                    
                    $("#id_codtipooferta").val(respuesta.propiedad.codtipooferta);                     
                    $("#id_notaespanol").val(respuesta.propiedad.notaespanol);
                    $("#id_descripcionespanol").val(respuesta.propiedad.descripcionespanol);                    
                    $("#id_direccion").val(respuesta.propiedad.direccion); 
                    $("#id_nrodireccion").val(respuesta.propiedad.nrodireccion);
                    //$("#id_areacontruccionum").val(respuesta.propiedad.areacontruccionum);
                    $("#id_areaconstruccioncantidad").val(respuesta.propiedad.areaconstruccioncantidad); 
                    $("#id_codfranquicia").val(respuesta.propiedad.codfranquicia);                     
                    $("#id_usuarioasesor").val(respuesta.propiedad.usuarioasesor);                     
                    $("#id_usuarioasesor" ).prop( "disabled", true );
                    $("#id_codpropiedad" ).prop( "disabled", true );
                    $("#id_codtipopropiedad").val(respuesta.propiedad.codtipopropiedad); 
                    $("#id_codtipodireccion").val(respuesta.propiedad.codtipodireccion);
                    $("#id_codsituacionestado").val(respuesta.propiedad.codsituacionestado);
                                        
                    var coddistritos = respuesta.coddistritos;
                    var codtipopropiedades = respuesta.codtipopropiedades;
                    var codtipodirecciones = respuesta.codtipodirecciones;
                    var codsituacionestados = respuesta.codsituacionestados;
                    
                    //codigo distritos
                    for (i = 0; i < coddistritos.length; i++) {
                        if (coddistritos[i].coddistrito == respuesta.propiedad.coddistrito) {
                            $('#id_coddistrito').append("<option selected='true' value=" + coddistritos[i].coddistrito + ">" + coddistritos[i].nombrecorto + "</option>");
                        } else {
                            $('#id_coddistrito').append("<option value=" + coddistritos[i].coddistrito + ">" + coddistritos[i].nombrecorto + "</option>");
                        }
                    }
                    //Tipo propiedades
                    for (i = 0; i < codtipopropiedades.length; i++) {
                        if (codtipopropiedades[i].codargumento == respuesta.propiedad.codtipopropiedad) {
                            $('#id_codtipopropiedad').append("<option selected='true' value=" + codtipopropiedades[i].codargumento + ">" + codtipopropiedades[i].nombrecorto + "</option>");
                        } else {
                            $('#id_codtipopropiedad').append("<option value=" + codtipopropiedades[i].codargumento + ">" + codtipopropiedades[i].nombrecorto + "</option>");
                        }
                    }
                    //Tipo direcciones
                    for (i = 0; i < codtipodirecciones.length; i++) {
                        if (codtipodirecciones[i].codargumento == respuesta.propiedad.codtipodireccion) {
                            $('#id_codtipodireccion').append("<option selected='true' value=" + codtipodirecciones[i].codargumento + ">" + codtipodirecciones[i].nombrecorto + "</option>");
                        } else {
                            $('#id_codtipodireccion').append("<option value=" + codtipodirecciones[i].codargumento + ">" + codtipodirecciones[i].nombrecorto + "</option>");
                        }
                    } 
                    //Tipo estados
                    for (i = 0; i < codsituacionestados.length; i++) {
                        if (codsituacionestados[i].codargumento == respuesta.propiedad.codsituacionestado) {
                            $('#id_codsituacionestado').append("<option selected='true' value=" + codsituacionestados[i].codargumento + ">" + codsituacionestados[i].nombrecorto + "</option>");
                        } else {
                            $('#id_codsituacionestado').append("<option value=" + codsituacionestados[i].codargumento + ">" + codsituacionestados[i].nombrecorto + "</option>");
                        }
                    }                    
                    //
                    $("#divModalPopupRegistroPropiedadForm").modal("show");
                }
            },
            error: function () {
                console.log('flagEstadoPagina:e5');
                $("#divModalPopupRegistroPropiedadForm").modal("hide");
            }
        });
        //
    }

//1. wf_editar
  function wf_editar(codpropiedad) {
        $("#id_flagEstadoPagina").val("");
        var flagEstadoPagina = "C";
        console.log('flagEstadoPagina:' + flagEstadoPagina);
        var ajax_data = {"id": codpropiedad};
        $.ajax({
            url: contextPathUrl + "/propiedad/editar",
            data: ajax_data,
            type: "post",
            dataType: "json",
            cache: false,
            async: false,
            beforeSend: function () {
                console.log('flagEstadoPagina:e2');
            },
            complete: function () {
                console.log('flagEstadoPagina:e3');
            },
            success: function (respuesta) {
                var flagEstadoPagina = respuesta.flagEstadoPagina;
                console.log('flagEstadoPagina:e4');
                console.log('respuesta:' + respuesta);

                if (flagEstadoPagina == "E") {   
                    $("#id_flagEstadoPagina").val("E");
                    $("#id_codpropiedad").val(respuesta.propiedad.codpropiedad);
                    $("#id_codusuarioasesor").val(respuesta.propiedad.codusuarioasesor);
                    $("#id_codpais").val(respuesta.propiedad.codpais);
                    $("#id_coddepartamento").val(respuesta.propiedad.coddepartamento);
                    $("#id_codprovincia").val(respuesta.propiedad.codprovincia);
                    $("#id_coddistrito").val(respuesta.propiedad.coddistrito);
                    $("#id_preciomoneda").val(respuesta.propiedad.preciomoneda);
                    $("#id_preciovalor").val(respuesta.propiedad.preciovalor);                    
                    $("#id_areaterrenoum").val(respuesta.propiedad.areaterrenoum);
                    $("#id_areaterrenocantidad").val(respuesta.propiedad.areaterrenocantidad);                    
                    $("#id_comisionporcentaje").val(respuesta.propiedad.comisionporcentaje);                    
                    $("#id_codtipooferta").val(respuesta.propiedad.codtipooferta);                     
                    $("#id_notaespanol").val(respuesta.propiedad.notaespanol);
                    $("#id_descripcionespanol").val(respuesta.propiedad.descripcionespanol);                    
                    $("#id_direccion").val(respuesta.propiedad.direccion); 
                    $("#id_nrodireccion").val(respuesta.propiedad.nrodireccion);
                    //$("#id_areacontruccionum").val(respuesta.propiedad.areacontruccionum);
                    $("#id_areaconstruccioncantidad").val(respuesta.propiedad.areaconstruccioncantidad); 
                    $("#id_codfranquicia").val(respuesta.propiedad.codfranquicia);                     
                    $("#id_usuarioasesor").val(respuesta.propiedad.usuarioasesor);                     
                    $("#id_usuarioasesor" ).prop( "disabled", true );
                    $("#id_codpropiedad" ).prop( "disabled", true );
                    $("#id_preciomoneda" ).prop( "disabled", true );
                    $("#id_codtipopropiedad").val(respuesta.propiedad.codtipopropiedad); 
                    $("#id_codtipodireccion").val(respuesta.propiedad.codtipodireccion);
                    $("#id_codsituacionestado").val(respuesta.propiedad.codsituacionestado);
                                        
                    var coddistritos = respuesta.coddistritos;
                    var codtipopropiedades = respuesta.codtipopropiedades;
                    var codtipodirecciones = respuesta.codtipodirecciones;
                    var codsituacionestados = respuesta.codsituacionestados;
                    
                    //codigo distritos
                    for (i = 0; i < coddistritos.length; i++) {
                        if (coddistritos[i].coddistrito == respuesta.propiedad.coddistrito) {
                            $('#id_coddistrito').append("<option selected='true' value=" + coddistritos[i].coddistrito + ">" + coddistritos[i].nombrecorto + "</option>");
                        } else {
                            $('#id_coddistrito').append("<option value=" + coddistritos[i].coddistrito + ">" + coddistritos[i].nombrecorto + "</option>");
                        }
                    }
                    //Tipo propiedades
                    for (i = 0; i < codtipopropiedades.length; i++) {
                        if (codtipopropiedades[i].codargumento == respuesta.propiedad.codtipopropiedad) {
                            $('#id_codtipopropiedad').append("<option selected='true' value=" + codtipopropiedades[i].codargumento + ">" + codtipopropiedades[i].nombrecorto + "</option>");
                        } else {
                            $('#id_codtipopropiedad').append("<option value=" + codtipopropiedades[i].codargumento + ">" + codtipopropiedades[i].nombrecorto + "</option>");
                        }
                    }
                    //Tipo direcciones
                    for (i = 0; i < codtipodirecciones.length; i++) {
                        if (codtipodirecciones[i].codargumento == respuesta.propiedad.codtipodireccion) {
                            $('#id_codtipodireccion').append("<option selected='true' value=" + codtipodirecciones[i].codargumento + ">" + codtipodirecciones[i].nombrecorto + "</option>");
                        } else {
                            $('#id_codtipodireccion').append("<option value=" + codtipodirecciones[i].codargumento + ">" + codtipodirecciones[i].nombrecorto + "</option>");
                        }
                    } 
                    //Tipo estados
                    for (i = 0; i < codsituacionestados.length; i++) {
                        if (codsituacionestados[i].codargumento == respuesta.propiedad.codsituacionestado) {
                            $('#id_codsituacionestado').append("<option selected='true' value=" + codsituacionestados[i].codargumento + ">" + codsituacionestados[i].nombrecorto + "</option>");
                        } else {
                            $('#id_codsituacionestado').append("<option value=" + codsituacionestados[i].codargumento + ">" + codsituacionestados[i].nombrecorto + "</option>");
                        }
                    }

                    $("#divModalPopupRegistroPropiedadForm").modal("show");
                }
            },
            error: function () {
                console.log('flagEstadoPagina:e5');
                $("#divModalPopupRegistroPropiedadForm").modal("hide");
            }
        });
        //
    }

//2. wf_confirmar
function wf_confirmar(){
$("#spaMensajeConfirmacionTitulo").html("&iquest;Esta seguro de Guardar los cambios?");
$("#divMensajeConfirmacion").modal("show");
}

//3. wf_guardar
  function wf_guardar() {
    var flagEstadoPagina=$("#id_flagEstadoPagina").val();
    var codpropiedad=$("#id_codpropiedad").val();
    var codusuarioasesor=$("#id_codusuarioasesor").val();
    var codpais=$("#id_codpais").val();
    var coddepartamento=$("#id_coddepartamento").val();
    var codprovincia=$("#id_codprovincia").val();
    var coddistrito=$("#id_coddistrito").val();
    var preciomoneda=$("#id_preciomoneda").val();
    var preciovalor=$("#id_preciovalor").val();                    
    var areaterrenoum=$("#id_areaterrenoum").val();
    var areaterrenocantidad=$("#id_areaterrenocantidad").val();                    
    var comisionporcentaje=$("#id_comisionporcentaje").val();
    var codsituacionestado=$("#id_codsituacionestado").val();    
    var codtipooferta=$("#id_codtipooferta").val();    
    var codtipopropiedad=$("#id_codtipopropiedad").val();    
    var notaespanol=$("#id_notaespanol").val();    
    var descripcionespanol=$("#id_descripcionespanol").val();    
    var codtipodireccion=$("#id_codtipodireccion").val();    
    var direccion=$("#id_direccion").val();    
    var nrodireccion=$("#id_nrodireccion").val();    
    var areaconstruccioncantidad=$("#id_areaconstruccioncantidad").val();    
    var codfranquicia=$("#id_codfranquicia").val();    
        
    var ajax_data = {"flagEstadoPagina": flagEstadoPagina,
        "codpropiedad": codpropiedad,
        "codusuarioasesor": $.trim(codusuarioasesor),
        "codpais": $.trim(codpais),
        "coddepartamento": $.trim(coddepartamento),
        "codprovincia": $.trim(codprovincia),
        "coddistrito": $.trim(coddistrito),
        "preciomoneda": $.trim(preciomoneda),
        "preciovalor": $.trim(preciovalor),
        "areaterrenoum": areaterrenoum,
        "areaterrenocantidad": areaterrenocantidad,
        "comisionporcentaje":comisionporcentaje,
        "codsituacionestado":$.trim(codsituacionestado),
        "codtipooferta":$.trim(codtipooferta),
        "codtipopropiedad":codtipopropiedad,
        "notaespanol":$.trim(notaespanol),
        "descripcionespanol":$.trim(descripcionespanol),
        "codtipodireccion":$.trim(codtipodireccion),
        "direccion":$.trim(direccion),
        "nrodireccion":$.trim(nrodireccion),        
        "areaconstruccioncantidad":$.trim(areaconstruccioncantidad),
        "codfranquicia":$.trim(codfranquicia)
        };
        
        $.ajax({
            url: contextPathUrl + "/propiedad/guardar",
            data: ajax_data,
            type: "post",
            dataType: "json",
            cache: false,
            async: false,
            beforeSend: function () {
                console.log('flagEstadoPagina:e2');
            },
            complete: function () {
                console.log('flagEstadoPagina:e3');
            },
            success: function (respuesta) {
                var flagEstadoPagina = respuesta.flagEstadoPagina;
                console.log('flagEstadoPagina:e4');
                console.log('respuesta:' + respuesta);

                if (flagEstadoPagina == "OK") { 
                    $("#divModalPopupRegistroPropiedadForm").modal("hide");
                    obtenerDatos();
                }
            },
            error: function () {
                console.log('flagEstadoPagina:e5');
                $("#divModalPopupRegistroPropiedadForm").modal("hide");
            }
        });
        //
    }
    
//1. wf_subirArchivo
  function wf_verListaArchivo(codpropiedad) {
        $("#id_flagEstadoPagina").val("");
        $("#id_id").val(codpropiedad);
        $("#id_iditem").val(0);        
        $("#id_idEntidad").val("pro");
        $("#id_codpropiedad_pal").val(codpropiedad);
        obtenerDatosArchivoListado(codpropiedad);
        $("#divModalPopupPropiedadArchivoListadoForm").modal("show"); 
        //
    }
   
  function wf_abrirSubirArchivo(codpropiedadarchivo,estado) {
      var codpropiedad=$("#id_codpropiedad_pal").val();
        $("#id_flagEstadoPaginaArchivo").val(estado);
        $("#id_id").val(codpropiedad);
        $("#id_iditem").val(codpropiedadarchivo);
        $("#id_idEntidad").val("pro");
        $("#id_frmsubir")[0].reset();
        $("#divModalPopupPropiedadArchivoForm").modal("show"); 
        //
    }  
    
 function wf_editarArchivo(codpropiedadarchivo) {
     wf_abrirSubirArchivo(codpropiedadarchivo,"E");
 }    

function wf_verImagen(nombrearchivofoto) {
$('.imagepreview').attr("src","${pageContext.request.contextPath}/archivos/download/"+nombrearchivofoto);
$('#imagemodal').modal('show'); 
}               
//fin eventos personaliados
//======================================
    $(document).ready(function () {
        //

        $(function () {
            /*$('.pop').on('click', function() {
                //$('.imagepreview').attr('src', $(this).find('img').attr('src'));
                $('.imagepreview').attr("src","${pageContext.request.contextPath}/archivos/download/"+nombrearchivofoto);
                $('#imagemodal').modal('show');   
            });   */
            
            $('#datetimepicker6').datetimepicker({
                useCurrent: true, //Important! See issue #1075
                format: 'DD/MM/YYYY'
            });
            $('#datetimepicker7').datetimepicker({
                useCurrent: true, //Important! See issue #1075
                format: 'DD/MM/YYYY'
            });
            $("#datetimepicker6").on("dp.change", function (e) {
                $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
            });
            $("#datetimepicker7").on("dp.change", function (e) {
                $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
            });
             
            //4. botones
            $("#idBtnBuscar").on('click', function () {
                    wf_buscar();        
            });
            $("#idBtnAgregar").on('click', function () {
                    wf_agregar();        
            });

            $("#idBtnConfirmar").on('click', function () {
                    wf_confirmar();        
            });

            $("#btnSiMensaje").on('click', function () {                    
                $("#divMensajeConfirmacion").modal("hide");
                //$("#idFormRegistro").submit();
                wf_guardar();
            });
            
            $("#btnNoMensaje").on('click', function () {
                    $("#divMensajeConfirmacion").modal("hide");      
            });

            $("#idBtnAgregarArchivo").on('click', function () {
                    wf_abrirSubirArchivo(0,'A');
            });

            $("#idBtnSubirArchivo").on('click', function () {
                    $("#id_frmsubir").submit(); //Submit the form
            });
            //Callback handler for form submit event
            $("#id_frmsubir").submit(function(e)
            {
                
                var formObj = $(this);
                var codpropiedad=$("#id_codpropiedad_pal").val();
                var formURL = formObj.attr("action");
                var formData = new FormData(this);
                $.ajax({
                    url: formURL,
                    type: 'POST',
                    dataType: "json",
                    data:  formData,
                    mimeType:"multipart/form-data",
                    contentType: false,
                    cache: false,
                    processData:false,
                    success: function(data, textStatus, jqXHR){
                        var flagEstadoPagina = data.flagEstadoPagina;                    
                        console.log('data' + data);

                        if (flagEstadoPagina == "OK") { 
                            $("#divModalPopupPropiedadArchivoForm").modal("hide");
                            obtenerDatosArchivoListado(codpropiedad);
                            //$("#divModalPopupPropiedadArchivoListadoForm").modal("show"); 
                        }

                    },
                     error: function(jqXHR, textStatus, errorThrown){
                         alert("File has been uploaded error");
                     }          
                });
                e.preventDefault(); //Prevent Default action. 
                //e.unbind();
            }); 
            //
            //------------------------------
        });
    });

        </script>                
    </body>
</html>