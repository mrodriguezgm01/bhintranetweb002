<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal -->
<div class="modal fade" id="divModalPopupRegistroPropiedadForm" role="dialog" data-backdrop="static" data-keyboard="false" aria-hidden="true">
    <div class="modal-dialog" role="document" style="width:100%;height:100%">
        <div class="modal-content">
            <div class="modal-header" >
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">Mantenimiento de Propiedades</h4>
            </div>
            <form id="idFormRegistro" action="${pageContext.request.contextPath}/propiedad/guardar" method="post" class="form-horizontal" data-toggle="validator">
                <div class="modal-body">
                    <input type="hidden" id="id_flagEstadoPagina" name="flagEstadoPagina" value="" />
                    <input type="hidden" id="id_codusuarioasesor" name="codusuarioasesor" value="${propiedad.codusuarioasesor}" />
                    <input type="hidden" id="id_codfranquicia" name="codfranquicia" value="${propiedad.codfranquicia}" />
                    <input type="hidden" id="id_codpais" name="codpais" value="${propiedad.codpais}" />
                    <input type="hidden" id="id_coddepartamento" name="coddepartamento" value="${propiedad.coddepartamento}" />
                    <input type="hidden" id="id_codprovincia" name="codprovincia" value="${propiedad.codprovincia}" />
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="codpropiedad">Cod. Propiedad:</label>
                        </div>
                        <div required class="col-sm-10">
                            <input type="input" class="form-control" id="id_codpropiedad" name="codpropiedad" placeholder="Codigo de propiedad" value="${propiedad.codpropiedad}" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" required >
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="usuarioasesor">Usuario Asesor:</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="input" class="form-control" id="id_usuarioasesor" name="usuarioasesor" placeholder="Nombre Asesor" value="${propiedad.usuarioasesor}" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" required >
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="codtipopropiedad">Tipo Propiedad:</label>
                        </div>
                        <div class="col-sm-10">
                            <select id="id_codtipopropiedad" name="codtipopropiedad" class="form-control input-sm upperCaseTextClase" required>
                               <option value=" ">Seleccione</option> 
                            </select>                            
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="codtipooferta">Tipo Oferta:</label>
                        </div>
                        <div class="col-sm-10">
                            <select id="id_codtipooferta" name="codtipooferta" class="form-control input-sm upperCaseTextClase" required>
                               <option value=" ">Seleccione</option> 
                               <option value="VEN">VENTA</option> 
                               <option value="ALQ">ALQUILER</option> 
                            </select>                            
                        </div>
                    </div>  
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="codsituacionestado">Estado Proceso:</label>
                        </div>
                        <div class="col-sm-10">
                            <select id="id_codsituacionestado" name="codsituacionestado" class="form-control input-sm upperCaseTextClase" required>
                               <option value=" ">Seleccione</option>
                            </select>                            
                        </div>
                    </div>    
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="coddistrito">Distrito:</label>
                        </div>
                        <div class="col-sm-10">
                            <select id="id_coddistrito" name="coddistrito" class="form-control input-sm upperCaseTextClase" required>
                               <option value=" ">Seleccione</option>
                            </select>                            
                        </div>
                    </div>                        
                        
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="preciomoneda">Moneda:</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="input" class="form-control" id="id_preciomoneda" name="preciomoneda" placeholder="Moneda" value="${propiedad.preciomoneda}" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" required >
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="preciovalor">Precio valor:</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="input" class="form-control" id="id_preciovalor" name="preciovalor" placeholder="preciovalor" value="${propiedad.preciovalor}" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" required >
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="comisionporcentaje">Porc. Comision:</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="input" class="form-control" id="id_comisionporcentaje" name="comisionporcentaje" placeholder="comisionporcentaje" value="${propiedad.comisionporcentaje}" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" required >
                        </div>
                    </div>      
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="areaterrenoum">UM. Terreno:</label>
                        </div>
                        <div class="col-sm-10">                        
                            <select id="id_areaterrenoum" name="areaterrenoum" class="form-control">
                                <option value="M2" selected>M2</option>
                                <option value="HA">HA</option>
                                <option value="FT">FT</option>
                            </select>                        
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="areaterrenocantidad">Area Terreno:</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="input" class="form-control" id="id_areaterrenocantidad" name="areaterrenocantidad" placeholder="areaterrenocantidad" value="${propiedad.areaterrenocantidad}" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" required >
                        </div>
                    </div>       
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="areaconstruccioncantidad">Area Construccion:</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="input" class="form-control" id="id_areaconstruccioncantidad" name="areaconstruccioncantidad" placeholder="areaconstruccioncantidad" value="${propiedad.areaconstruccioncantidad}" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" required >
                        </div>
                    </div>                         
                        
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="codtipodireccion">Tipo Direccion:</label> 
                        </div>
                        <div class="col-sm-10">
                            <select id="id_codtipodireccion" name="codtipodireccion" class="form-control">
                                <option value=" ">Seleccione</option>
                            </select>  
                        </div>
                    </div> 
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="direccion">direccion:</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="input" class="form-control" id="id_direccion" name="direccion" placeholder="direccion" value="${propiedad.direccion}" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" required >
                        </div>
                    </div>                        
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="nrodireccion">nro. direccion:</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="input" class="form-control" id="id_nrodireccion" name="nrodireccion" placeholder="nrodireccion" value="${propiedad.nrodireccion}" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" required >
                        </div>
                    </div>        
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="notaespanol">Etiqueta Propiedad:</label>
                        </div>
                        <div required class="col-sm-10">
                            <input type="input" class="form-control" id="id_notaespanol" name="notaespanol" placeholder="notaespanol" value="${propiedad.notaespanol}" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" required >
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="descripcionespanol">Descripcion propiedad:</label>
                        </div>
                        <div required class="col-sm-10">
                            <input type="input" class="form-control" id="id_descripcionespanol" name="descripcionespanol" placeholder="descripcionespanol" value="${propiedad.descripcionespanol}" style="text-transform:uppercase;" onkeyup="javascript:this.value = this.value.toUpperCase();" required >
                        </div>
                    </div>                      
                </div>

                <div class="modal-footer">
                    <button id="id_btnsalir"  type="button" class="btn btn-secondary" data-dismiss="modal">Salir</button>
                    <button type="button" class="btn btn-secondary" id="idBtnConfirmar">Guardar</button>
                </div>
            </form>

            <!-- Modal -->

            <div id="divMensajeConfirmacion" class="modal fade" data-keyboard="false" data-backdrop="static" aria-hidden="true">
                <div class="container verticalAlignCenter">
                    <div class="row verticalAlignCenter">
                        <div class="col-xs-4">
                            <div class="panel panel-primary">
                                <div class="panel-heading"><span id="spaMensajeConfirmacionTitulo"></span></div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="text-center">
                                            <button id="btnSiMensaje" type="button" class="btn btn-primary btn-sm">Si</button>
                                            <button id="btnNoMensaje" type="button" class="btn btn-primary btn-sm">No</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>                    