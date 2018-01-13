package pe.bhintranet.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.bhintranet.model.bean.Parametro;
import pe.bhintranet.model.bean.Propiedad;
import pe.bhintranet.service.inf.ParametroService;
import pe.bhintranet.service.inf.PropiedadService;


import pe.bhintranet.util.CustomErrorType;

@Controller
@RequestMapping("/rest")
public class PropiedadRC {	
    private static Logger log = Logger.getLogger(PropiedadRC.class);
	
    @Autowired
    PropiedadService  propiedadService;
    @Autowired
    ParametroService parametroService;
	
	//GET
    @RequestMapping(value="/propiedades", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Propiedad>> getPropiedades(){
        System.out.println("RC:paso 1"); 
        List<Propiedad> propiedades = new ArrayList<Propiedad>();
        Propiedad propiedad=new Propiedad();
        propiedad.setCodfranquicia(1);

        propiedades = propiedadService.listarPorFiltroRC(propiedad);
        if (propiedades.isEmpty()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        log.debug(" lista de propiedades  "+ propiedades.size() );
        return new ResponseEntity<List<Propiedad>>(propiedades, HttpStatus.OK);



    }
    //GET
    @RequestMapping(value="/propiedades/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Propiedad> getPropiedadById(@PathVariable("id") Long idPropiedad){
        System.out.println("RC:paso 2"); 
        if (idPropiedad == null || idPropiedad <= 0) {
                return new ResponseEntity(new CustomErrorType("idPropiedad es requerido"), HttpStatus.CONFLICT);
        }

        Propiedad propiedad = propiedadService.recuperar(idPropiedad);
        if (propiedad == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Propiedad>(propiedad, HttpStatus.OK);
    }
        
    @RequestMapping(value="/propiedadesver/{id}", method = RequestMethod.GET, headers = "Accept=application/json")    
    public @ResponseBody Map<String, Object> ver(@RequestParam Long id, Model model,HttpServletRequest request) {
        System.out.println("RC:paso 3"); 
        Map<String, Object> respuesta = new HashMap<String, Object>();
        respuesta.put("propiedad", propiedadService.recuperar(id));    
        respuesta.put("codtipopropiedades",parametroService.listarPorCodParametro(new Parametro(7)));
        respuesta.put("flagEstadoPagina","OK");//EDICION
        return respuesta;
    }

}