<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Modal -->
<div class="modal fade" id="divModalPopupPropiedadArchivoListadoForm" role="dialog" data-backdrop="static" data-keyboard="false" aria-hidden="true" tabindex="-1">
  <div class="modal-dialog" style="width:100%;height:100%">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Lista de Archivos</h4>
      </div>
      <div class="form-group row">
                        <div class="col-sm-2">
                            <label class="control-label col-sm-2" for="codpropiedad_pal">Cod. Propiedad:</label>
                        </div>
                        <div required class="col-sm-5">
                            <input type="input" class="form-control" id="id_codpropiedad_pal" name="codpropiedad_pal" placeholder="Codigo de propiedad" disabled="true">
                        </div>
                        <div required class="col-sm-5">                            
                            <button type="button" class="btn btn-secondary" id="idBtnAgregarArchivo">Agregar Archivo</button>
                        </div>
      </div>       
        
        
      <div class="modal-body">
                    <div class="panel-body">                      
                        <div class="col-md-12" id="divPedidosTable2">  
                            <div class="table-responsive">
                            <table id="tablaarchivolistado" class="table table-striped table-bordered datatable" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>Codigo</th>
                                        <th>Archivo</th>
                                        <th>Tipo</th>
                                        <th>Grupo</th>
                                        <th>Estado</th>                                      
                                        <th>Accion</th>                                        
                                    </tr>                                
                                </thead>
                                <tbody>
                                    <c:forEach items="${propiedadarchivos}" var="p" varStatus="i" >
                                        <tr>
                                            <td> ${p.codpropiedadarchivo} </td>
                                            <td> 
                                                <a href="#" onClick="javascript:wf_verImagen(${p.rutaarchivo})" >${p.rutaarchivo} </a>
                                            </td>
                                            <td> ${p.codtipoarchivo} </td>
                                            <td> ${p.codgrupoarchivo} </td>
                                            <td> ${p.estado} </td>
                                            <td> 
                                               <a href="#" onClick="javascript:wf_editarArchivo(${p.codpropiedadarchivo})" >Archivo</a>
                                            </td>
                                        </tr>
                                    </c:forEach>                                      
                                </tbody>
                            </table>
                            </div>
                            <div id="divPedidosPagerTable" class="jqGridGeneralPagerClass"></div>
                        </div>                        
                    </div>          
          
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        
      </div>
    </div>

  </div>   

</div>  

<div class="modal fade" id="imagemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" style="width:100%;height:100%">
    <div class="modal-content">  
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>        
      </div>        
      <div class="modal-body">       
        <img src="" class="imagepreview" style="width: 90%;" >
      </div>
    </div>
  </div>
</div>