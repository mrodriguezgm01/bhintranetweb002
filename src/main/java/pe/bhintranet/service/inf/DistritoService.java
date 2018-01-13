/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.bhintranet.service.inf;

import java.util.Collection;
import pe.bhintranet.model.bean.Distrito;

/**
 *
 * @author moises_rodriguez
 */
public interface DistritoService {
    //personalizado
    public Collection listarPorCodProvincia(Distrito record);
}
