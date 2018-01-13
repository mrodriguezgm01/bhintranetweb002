package pe.bhintranet.controller.propiedad;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
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
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import pe.bhintranet.client.Conexion;
import pe.bhintranet.model.bean.Distrito;
import pe.bhintranet.model.bean.Parametro;
import pe.bhintranet.model.bean.Propiedad;
import pe.bhintranet.service.inf.DistritoService;
import pe.bhintranet.service.inf.ParametroService;
import pe.bhintranet.service.inf.PropiedadService;

@Controller
@RequestMapping("propiedad")
public class PropiedadController {
    
    @Autowired
    PropiedadService service;
    @Autowired
    ParametroService parametroService;
    @Autowired
    DistritoService distritoService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String abrir(Model model) {
        System.out.println("abrir:paso 1"); 
        Date fechaHasta=new Date();
        Date fechaDesde=new Date();        
        Collection<Propiedad> propiedades = new ArrayList<Propiedad>(); 
        Propiedad propiedad=new Propiedad();
        propiedad.setCodfranquicia(1);
  
        try {            
            propiedades=service.listarPorFiltro(propiedad);
        } 
        catch (Exception ex) {                   
            ex.printStackTrace();
        }
        finally {                
        }
        
       
        //String fechaDesde =  FormatoConstantes.CADENA_VACIA;
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        model.addAttribute("propiedades", propiedades);
        model.addAttribute("fechaDesde", sdf.format(fechaDesde));
        model.addAttribute("fechaHasta", sdf.format(fechaHasta));
        model.addAttribute("estados",parametroService.listarPorCodParametro(new Parametro(2)));
        model.addAttribute("flagEstadoPagina","C");//CONSULTA
        return "propiedad/formPropiedadBandeja";
    }

    @RequestMapping("listar")
    public @ResponseBody Map<String, Object> listar(Model model,HttpServletRequest request) {
        System.out.println("listar:paso 1"); 
        ModelAndView view = null;
        Map<String, Object> respuesta = new HashMap<String, Object>();
        Map<String, Object> parm = new HashMap<String, Object>();
       
        Date fechaHasta=new Date();
        Date fechaDesde=new Date();        
        Collection<Propiedad> propiedades = new ArrayList<Propiedad>(); 
        Propiedad propiedad=new Propiedad();
        propiedad.setCodfranquicia(1);
  
        try {            
            propiedades=service.listarPorFiltro(propiedad);
        } 
        catch (Exception ex) {                   
            ex.printStackTrace();
        }
        finally {                
        }
        
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        respuesta.put("propiedades", propiedades);
        respuesta.put("fechaDesde", sdf.format(fechaDesde));
        respuesta.put("fechaHasta", sdf.format(fechaHasta));
        respuesta.put("estados",parametroService.listarPorCodParametro(new Parametro(2)));
        respuesta.put("flagEstadoPagina","C");//CONSULTA
        
        return respuesta;
    }
    
    @RequestMapping("agregar")
    public @ResponseBody Map<String, Object> agregar(Model model,HttpServletRequest request) {
        System.out.println("agregar:paso 1"); 
        ModelAndView view = null;
        Map<String, Object> respuesta = new HashMap<String, Object>();
        
        Usuario usuario=(Usuario)request.getSession().getAttribute("USUARIO_AUTENTICADO");
        
        Propiedad propiedad=new Propiedad();
        propiedad.setCodsituacionestado("PEN");
        propiedad.setUsuarioasesor(usuario.getLoginname());
        propiedad.setCodfranquicia(usuario.getCodfranquicia());
        propiedad.setCodusuarioasesor(usuario.getCodusuario());
        propiedad.setPreciomoneda("DOL");
        propiedad.setCodpais(1);
        propiedad.setCoddepartamento(1);
        propiedad.setCodprovincia(1);
        propiedad.setCoddistrito(1);
        
        respuesta.put("propiedad",propiedad);
        respuesta.put("codtipopropiedades",parametroService.listarPorCodParametro(new Parametro(7)));
        respuesta.put("codtipodirecciones",parametroService.listarPorCodParametro(new Parametro(3)));
        respuesta.put("codsituacionestados",parametroService.listarPorCodParametro(new Parametro(2)));
        respuesta.put("coddistritos",distritoService.listarPorCodProvincia(new Distrito(1)));        
        respuesta.put("flagEstadoPagina","A");//agregar
        return respuesta;
    }
    
    @RequestMapping("editar")
    public @ResponseBody Map<String, Object> editar(@RequestParam Long id, Model model,HttpServletRequest request) {
        System.out.println("editar:paso 1"); 
        ModelAndView view = null;
        Map<String, Object> respuesta = new HashMap<String, Object>();
        respuesta.put("propiedad", service.recuperar(id));    
        respuesta.put("codtipopropiedades",parametroService.listarPorCodParametro(new Parametro(7)));
        respuesta.put("codtipodirecciones",parametroService.listarPorCodParametro(new Parametro(3)));
        respuesta.put("codsituacionestados",parametroService.listarPorCodParametro(new Parametro(2)));
        respuesta.put("coddistritos",distritoService.listarPorCodProvincia(new Distrito(1)));       
        
        respuesta.put("flagEstadoPagina","E");//EDICION
        return respuesta;
    }
    
    @RequestMapping("guardar")
    public @ResponseBody Map<String, Object> guardar(Propiedad propiedad,HttpServletRequest request) {
        Long codNull=null;
        
        String flagEstadoPagina=request.getParameter("flagEstadoPagina").trim();
        Map<String, Object> respuesta = new HashMap<String, Object>();
        System.out.println("guardar:paso 1"); 
        System.out.println("codpropiedad:"+propiedad.getCodpropiedad()); 
        
        if (flagEstadoPagina.equals("A")){
            System.out.println("guardar:paso INSERTAR"); 
            propiedad.setCodpropiedad(codNull);
            propiedad.setCodfranquicia(1);
            service.insertar(propiedad);
        }else{
            System.out.println("guardar:paso ACTUALIZAR"); 
            service.actualizar(propiedad);
        }        
        respuesta.put("flagEstadoPagina","OK");
        return respuesta;
    }
    
  @RequestMapping(value = "reporte", method = RequestMethod.GET)
  @ResponseBody
  public void getRpt1(HttpServletResponse response) throws JRException, IOException, ClassNotFoundException {
    InputStream jasperStream = this.getClass().getResourceAsStream("/jasperreports/reporte002.jasper");
    Map<String,Object> params = new HashMap<>();
    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
    //JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
        try {
            Conexion conexion=new Conexion();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conexion.obtener());
            //conexion.cerrar();            
            response.setContentType("application/x-pdf");
            response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");

            final OutputStream outStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
        } catch (SQLException ex) {
            Logger.getLogger(PropiedadController.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    //
}