package pe.bhintranet.fe.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import pe.bhintranet.fe.service.inf.PropiedadFeService;
import pe.bhintranet.model.bean.Propiedad;
import pe.bhintranet.model.bean.Usuario;



@Controller
@RequestMapping("/propiedadfe")
public class PropiedadFeController {
	
    @Autowired
    PropiedadFeService propiedadFeService; 
    private static final Log LOG = LogFactory.getLog(PropiedadFeController.class);


    @ResponseBody
    @RequestMapping(value = "listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> listar( Model model,HttpServletRequest request) {
        LOG.info("METHOD 'listar'");
        //ModelAndView mav = new ModelAndView(ViewConstant.VIEW_HOTELES);
        Usuario usuario=(Usuario)request.getSession().getAttribute("USUARIO_AUTENTICADO");
        Map<String, Object> resultado = new HashMap();
        //String token=userSession.getToken();		
        String token="token123";
        resultado.put("propiedades", propiedadFeService.listarPropiedad(token));
        return resultado;
    }


    @ResponseBody
    @RequestMapping(value = "consultar/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)        
    public Map<String, Object> consultarForm(@PathVariable("id") Long id,
                    Model model,HttpServletRequest request) {
        LOG.info("METHOD 'hotelform'-- PARAMS:' " + id );
        Usuario usuario=(Usuario)request.getSession().getAttribute("USUARIO_AUTENTICADO");
        //String token=userSession.getToken();
        String token="tocken123";
        Map<String, Object> resultado = new HashMap();
        Propiedad propiedad = new Propiedad();
        //TODO CAMBIAR PARA OBTENER LA EMPRESA  DE SESION
        //hotelModel.setIdEmpresa(userSession.getIdEmpresa() );
        //hotelModel.setIdEmpresa(1);
        LOG.debug("id " +  id);
        if (null!=id){
                propiedad =propiedadFeService.findPropiedadById(id,token);
        }
        resultado.put("propiedad", propiedad);

        LOG.info("METHOD 'consultarForm':' Fin");
        return resultado;
    }
	
	
}
