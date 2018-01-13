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
import pe.bhintranet.model.bean.Distrito;
import pe.bhintranet.model.dao.DistritoDAO;
import pe.bhintranet.service.inf.DistritoService;

/**
 *
 * @author moises_rodriguez
 */
@Service
@Transactional
public class DistritoServiceImpl implements DistritoService{
    @Autowired
    DistritoDAO distritoDAO;    
    //personalizado
    @Override
    public Collection listarPorCodProvincia(Distrito record){
        return distritoDAO.listarPorCodProvincia(record);
    }
}
