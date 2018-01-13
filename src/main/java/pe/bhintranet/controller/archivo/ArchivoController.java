package pe.bhintranet.controller.archivo;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.bhintranet.model.bean.PropiedadArchivo;
import pe.bhintranet.model.bean.Usuario;
import pe.bhintranet.service.inf.PropiedadArchivoService;
import pe.bhintranet.service.inf.UsuarioService;

@Controller
@RequestMapping("archivos")
public class ArchivoController {

    @Autowired
    ArchivoService service;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    PropiedadArchivoService propiedadArchivoService;
        
    
    //@RequestMapping(method = RequestMethod.GET)
    @RequestMapping(value = "file1",method = RequestMethod.GET)    
    public String list(Model model,HttpServletRequest request,@RequestParam Long id,@RequestParam String idEntidad) {
        model.addAttribute("archivos", service.list(request,id,idEntidad));
        model.addAttribute("id",id);
        model.addAttribute("idEntidad",idEntidad);
        return "archivos/index";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes,@RequestParam("id") Long id,
            @RequestParam("idEntidad") String idEntidad) {

        service.upload(file);
        //return "redirect:/archivos";
        return "redirect:/archivos/file1?id="+id+"&idEntidad="+idEntidad;
    }

    @RequestMapping(value = "uploadSimple", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> uploadSimple(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes,
            @RequestParam("id") Long id,
            @RequestParam("iditem") Long iditem,
            @RequestParam("idEntidad") String idEntidad,
            @RequestParam("flagEstadoPagina") String flagEstadoPagina) {
        
        
        Map<String, Object> respuesta = new HashMap<String, Object>();
        String nombreArchivo;
        //System.out.println("nombreArchivo:"+id+","+idEntidad);
        nombreArchivo=service.uploadSimple(file,id,idEntidad);
        if (nombreArchivo!=null){
            if(idEntidad.equals("ase")){
                System.out.println("guardar:paso ACTUALIZAR"); 
                Usuario usuario=new Usuario();
                usuario.setCodusuario(id);
                usuario.setNombrearchivofoto(nombreArchivo);
                usuarioService.actualizar(usuario);                
            }else{ //pro:propiedades
                PropiedadArchivo propiedadArchivo=new PropiedadArchivo();
                if(flagEstadoPagina.equals("A")){ 
                    System.out.println("guardar:paso INSERTAR"); 
                    propiedadArchivo.setCodpropiedad(id);
                    propiedadArchivo.setCodfranquicia(1);
                    propiedadArchivo.setNombrearchivo(nombreArchivo);
                    propiedadArchivo.setRutaarchivo(nombreArchivo);
                    propiedadArchivo.setDescripcionarchivo(nombreArchivo);
                    propiedadArchivo.setCodgrupoarchivo("PRO");
                    propiedadArchivo.setCodtipoarchivo("IMG");
                    propiedadArchivo.setCodextensionarchivo("JPG");                
                    propiedadArchivoService.insertar(propiedadArchivo);
                }else{
                    System.out.println("guardar:paso ACTUALIZAR"); 
                    propiedadArchivo.setCodpropiedadarchivo(iditem);
                    propiedadArchivo.setNombrearchivo(nombreArchivo);
                    propiedadArchivo.setRutaarchivo(nombreArchivo);
                    propiedadArchivo.setDescripcionarchivo(nombreArchivo);              
                    propiedadArchivoService.actualizar(propiedadArchivo);                    
                }
            }


            respuesta.put("flagEstadoPagina","OK");
        }else{
            respuesta.put("flagEstadoPagina","ERROR");
        }
        
        return respuesta;
    }    

    
    @RequestMapping("download/{file:.*}")
    public void download(@PathVariable("file") String file, HttpServletResponse response) throws Exception {

        service.download(response, file);

    }
    
    @RequestMapping(value = "regresar", method = RequestMethod.POST)
    public String regresar() {
        return "redirect:/usuario";
    }

//
}
