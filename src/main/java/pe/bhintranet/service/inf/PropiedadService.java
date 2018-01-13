/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.bhintranet.service.inf;

import java.util.Collection;
import java.util.List;
import pe.bhintranet.model.bean.Propiedad;

/**
 *
 * @author moises_rodriguez
 */
public interface PropiedadService {
    //personalizado
    public int insertar(Propiedad propiedad);
    public void actualizar(Propiedad propiedad);
    public Propiedad recuperar(Long codpropiedad);    
    public Collection listarPorFiltro(Propiedad propiedad); 
    public List listarPorFiltroRC(Propiedad propiedad); 
}
