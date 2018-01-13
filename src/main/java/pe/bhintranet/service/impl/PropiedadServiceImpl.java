/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.bhintranet.service.impl;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.bhintranet.model.bean.Propiedad;
import pe.bhintranet.model.dao.PropiedadDAO;
import pe.bhintranet.service.inf.PropiedadService;

/**
 *
 * @author moises_rodriguez
 */
@Service
@Transactional
public class PropiedadServiceImpl implements PropiedadService{
    @Autowired
    PropiedadDAO propiedadDAO;

@Override
    public int insertar(Propiedad propiedad) {
            
            int i = 0;
            try {
                    propiedadDAO.insertSelective(propiedad);
            }catch (Exception ex) {                    
                  ex.printStackTrace();  
            }finally {                    
            }
            return i;
    }
    
    @Override
    public void actualizar(Propiedad propiedad) {
            
            int i = 0;
            try {
                    propiedadDAO.updateByPrimaryKeySelective(propiedad);
            }catch (Exception ex) {
                   ex.printStackTrace();                     
            }finally {                    
            }
            //return i;
    }    

    @Override
    public Propiedad recuperar(Long codpropiedad) {
            
            int i = 0;
            try {
                Propiedad propiedad=    propiedadDAO.selectByPrimaryKey(codpropiedad);
                return propiedad;
            }catch (Exception ex) {                    
                    ex.printStackTrace();
            }finally {                    
            }
            return null;
    }
    
    @Override
    public Collection listarPorFiltro(Propiedad propiedad) {
        
        return propiedadDAO.listarPorFiltro(propiedad);
        
    }
    public List listarPorFiltroRC(Propiedad propiedad) {
        
        return propiedadDAO.listarPorFiltroRC(propiedad);
        
    }    
}
