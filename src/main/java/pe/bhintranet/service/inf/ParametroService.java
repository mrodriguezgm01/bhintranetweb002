/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.bhintranet.service.inf;

import java.util.Collection;
import pe.bhintranet.model.bean.Parametro;

/**
 *
 * @author moises_rodriguez
 */
public interface ParametroService {
    //personalizado
    public Collection listarPorCodParametro(Parametro record);
}
