/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.bhintranet.fe.service.inf;

import java.util.Collection;
import java.util.List;
import pe.bhintranet.model.bean.Propiedad;

/**
 *
 * @author moises_rodriguez
 */
public interface PropiedadFeService {
	 
    public List<Propiedad> listarPropiedad( String token);
    public abstract Propiedad findPropiedadById(Long id, String token);

}
