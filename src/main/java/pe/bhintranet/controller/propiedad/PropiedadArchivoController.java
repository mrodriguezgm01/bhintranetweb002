package pe.bhintranet.controller.propiedad;

import java.io.File;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import pe.edu.tecsup.springmvc.model.PreAfiliado;
import pe.bhintranet.model.bean.Usuario;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import pe.bhintranet.model.bean.Distrito;
import pe.bhintranet.model.bean.Parametro;
import pe.bhintranet.model.bean.Propiedad;
import pe.bhintranet.model.bean.PropiedadArchivo;
import pe.bhintranet.service.inf.DistritoService;
import pe.bhintranet.service.inf.ParametroService;
import pe.bhintranet.service.inf.PropiedadArchivoService;
import pe.bhintranet.service.inf.PropiedadService;

@Controller
@RequestMapping("propiedadArchivo")
public class PropiedadArchivoController {
    
    @Autowired
    PropiedadArchivoService service;
    @Autowired
    ParametroService parametroService;
    @Autowired
    DistritoService distritoService;
    
    //@RequestMapping(method = RequestMethod.GET)
    @RequestMapping("listar")
    public @ResponseBody Map<String, Object> listar(Model model,HttpServletRequest request) {
        System.out.println("listar:paso 1"); 
        ModelAndView view = null;
        Map<String, Object> respuesta = new HashMap<String, Object>();
        Map<String, Object> parm = new HashMap<String, Object>();
        String codpropiedad=request.getParameter("codpropiedad").trim();
        
        Collection<PropiedadArchivo> propiedadArchivos = new ArrayList<PropiedadArchivo>(); 
        PropiedadArchivo propiedadArchivo=new PropiedadArchivo();        
        propiedadArchivo.setCodpropiedad(Long.parseLong(codpropiedad));
  
        try {            
            propiedadArchivos=service.listarPorCodPropiedad(propiedadArchivo);
        } 
        catch (Exception ex) {                   
            ex.printStackTrace();
        }
        finally {                
        }
        
        respuesta.put("propiedadArchivos", propiedadArchivos);
        respuesta.put("estados",parametroService.listarPorCodParametro(new Parametro(2)));
        respuesta.put("flagEstadoPagina","C");//CONSULTA
        
        return respuesta;
    }
    
    @RequestMapping("guardar")
    public @ResponseBody Map<String, Object> guardar(PropiedadArchivo propiedadArchivo,HttpServletRequest request) {
        Long codNull=null;
        
        String flagEstadoPagina=request.getParameter("flagEstadoPagina").trim();
        Map<String, Object> respuesta = new HashMap<String, Object>();
        System.out.println("guardar:paso 1"); 
        System.out.println("codpropiedadarchivo:"+propiedadArchivo.getCodpropiedadarchivo()); 
        
        if (flagEstadoPagina.equals("A")){
            System.out.println("guardar:paso INSERTAR"); 
            propiedadArchivo.setCodpropiedadarchivo(codNull);
            propiedadArchivo.setCodfranquicia(1);
            service.insertar(propiedadArchivo);
        }else{
            System.out.println("guardar:paso ACTUALIZAR"); 
            service.actualizar(propiedadArchivo);
        }        
        respuesta.put("flagEstadoPagina","OK");
        return respuesta;
    }
    //
}