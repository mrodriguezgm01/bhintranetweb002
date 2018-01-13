/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.bhintranet.service.impl;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.bhintranet.model.bean.Parametro;
import pe.bhintranet.model.dao.ParametroDAO;
import pe.bhintranet.service.inf.ParametroService;

/**
 *
 * @author moises_rodriguez
 */
@Service
@Transactional
public class ParametroServiceImpl implements ParametroService{
    @Autowired
    ParametroDAO parametroDAO;    
    //personalizado
    @Override
    public Collection listarPorCodParametro(Parametro record){
        return parametroDAO.listarPorCodParametro(record);
    }
}
