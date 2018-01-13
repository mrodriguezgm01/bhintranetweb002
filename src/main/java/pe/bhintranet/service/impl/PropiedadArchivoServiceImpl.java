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
import pe.bhintranet.model.bean.PropiedadArchivo;
import pe.bhintranet.model.dao.PropiedadArchivoDAO;
import pe.bhintranet.service.inf.PropiedadArchivoService;

/**
 *
 * @author moises_rodriguez
 */
@Service
@Transactional
public class PropiedadArchivoServiceImpl implements PropiedadArchivoService{
    @Autowired
    PropiedadArchivoDAO propiedadArchivoDAO;

@Override
    public int insertar(PropiedadArchivo propiedadArchivo) {
            
            int i = 0;
            try {
                    propiedadArchivoDAO.insertSelective(propiedadArchivo);
            }catch (Exception ex) {                    
                  ex.printStackTrace();  
            }finally {                    
            }
            return i;
    }
    
    @Override
    public void actualizar(PropiedadArchivo propiedadArchivo) {
            
            int i = 0;
            try {
                    propiedadArchivoDAO.updateByPrimaryKeySelective(propiedadArchivo);
            }catch (Exception ex) {
                   ex.printStackTrace();                     
            }finally {                    
            }
            //return i;
    }    

    @Override
    public PropiedadArchivo recuperar(Long codpropiedadarchivo) {
            
            int i = 0;
            try {
                PropiedadArchivo propiedadArchivo=    propiedadArchivoDAO.selectByPrimaryKey(codpropiedadarchivo);
                return propiedadArchivo;
            }catch (Exception ex) {                    
                    ex.printStackTrace();
            }finally {                    
            }
            return null;
    }
    
    @Override
    public Collection listarPorCodPropiedad(PropiedadArchivo propiedadArchivo) {
        
        return propiedadArchivoDAO.listarPorCodPropiedad(propiedadArchivo);
        
    }
    
}
