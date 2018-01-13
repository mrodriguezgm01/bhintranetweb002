/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.bhintranet.fe.service.impl;

import java.util.Collection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.bhintranet.fe.service.inf.PropiedadFeService;
import pe.bhintranet.model.bean.Propiedad;
import pe.bhintranet.rc.client.util.BackendRestInvoker;
import pe.bhintranet.rc.client.util.ConstantesURL;

/**
 *
 * @author moises_rodriguez
 */
@Service
public class PropiedadFeServiceImpl implements PropiedadFeService {
private static final Log LOG = LogFactory.getLog(PropiedadFeServiceImpl.class);
    @Override
    public List<Propiedad> listarPropiedad(String token) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         LOG.info("METHOD 'listarPropiedad'");
         BackendRestInvoker<Propiedad> restInvoker= new BackendRestInvoker<Propiedad>(ConstantesURL.BACKEND_SERVER,ConstantesURL.BACKEND_PORT);

          ResponseEntity<List<Propiedad>> responseEntity=
                        restInvoker.sendGetList(ConstantesURL.BACKEND_CONTEXT +"/rest/propiedades"  , Propiedad.class, token);

         // responseEntity.getStatusCode() 

          List<Propiedad> propiedades = responseEntity.getBody();
          LOG.info("METHOD  fin 'listarPropiedad'" + propiedades.size());
          return propiedades;
    }

    @Override
    public Propiedad findPropiedadById(Long id, String token) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BackendRestInvoker<Propiedad> restInvoker= new BackendRestInvoker<Propiedad>(ConstantesURL.BACKEND_SERVER,ConstantesURL.BACKEND_PORT);

          ResponseEntity<Propiedad> responseEntity=
                        restInvoker.sendGet(ConstantesURL.BACKEND_CONTEXT +"/rest/propiedades/"+ id  , Propiedad.class, token);

         // responseEntity.getStatusCode() 
          Propiedad propiedad = responseEntity.getBody();
          return propiedad;        
    }
    
}
