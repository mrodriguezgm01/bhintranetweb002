package pe.bhintranet.model.dao;

import java.util.Collection;
import pe.bhintranet.model.bean.PropiedadArchivo;

public interface PropiedadArchivoDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadarchivo
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    int deleteByPrimaryKey(Long codpropiedadarchivo);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadarchivo
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    void insert(PropiedadArchivo record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadarchivo
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    void insertSelective(PropiedadArchivo record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadarchivo
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    PropiedadArchivo selectByPrimaryKey(Long codpropiedadarchivo);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadarchivo
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    int updateByPrimaryKeySelective(PropiedadArchivo record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadarchivo
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    int updateByPrimaryKey(PropiedadArchivo record);
    //personalizado
    public Collection listarPorCodPropiedad(PropiedadArchivo record);
}