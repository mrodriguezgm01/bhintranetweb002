/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.bhintranet.service.inf;

import java.util.Collection;
import pe.bhintranet.model.bean.PropiedadArchivo;

/**
 *
 * @author moises_rodriguez
 */
public interface PropiedadArchivoService {
    //personalizado
    public int insertar(PropiedadArchivo propiedadArchivo);
    public void actualizar(PropiedadArchivo propiedadArchivo);
    public PropiedadArchivo recuperar(Long codpropiedadarchivo);    
    public Collection listarPorCodPropiedad(PropiedadArchivo propiedadArchivo); 
}
