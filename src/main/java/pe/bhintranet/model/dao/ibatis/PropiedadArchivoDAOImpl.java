package pe.bhintranet.model.dao.ibatis;

import java.util.Collection;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import pe.bhintranet.model.bean.PropiedadArchivo;
import pe.bhintranet.model.dao.PropiedadArchivoDAO;

public class PropiedadArchivoDAOImpl extends SqlMapClientDaoSupport implements PropiedadArchivoDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadarchivo
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public PropiedadArchivoDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadarchivo
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public int deleteByPrimaryKey(Long codpropiedadarchivo) {
        PropiedadArchivo key = new PropiedadArchivo();
        key.setCodpropiedadarchivo(codpropiedadarchivo);
        int rows = getSqlMapClientTemplate().delete("propiedadarchivo.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadarchivo
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public void insert(PropiedadArchivo record) {
        getSqlMapClientTemplate().insert("propiedadarchivo.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadarchivo
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public void insertSelective(PropiedadArchivo record) {
        getSqlMapClientTemplate().insert("propiedadarchivo.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadarchivo
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public PropiedadArchivo selectByPrimaryKey(Long codpropiedadarchivo) {
        PropiedadArchivo key = new PropiedadArchivo();
        key.setCodpropiedadarchivo(codpropiedadarchivo);
        PropiedadArchivo record = (PropiedadArchivo) getSqlMapClientTemplate().queryForObject("propiedadarchivo.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadarchivo
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public int updateByPrimaryKeySelective(PropiedadArchivo record) {
        int rows = getSqlMapClientTemplate().update("propiedadarchivo.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadarchivo
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public int updateByPrimaryKey(PropiedadArchivo record) {
        int rows = getSqlMapClientTemplate().update("propiedadarchivo.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }
        //personalizado
    @Override
    public Collection listarPorCodPropiedad(PropiedadArchivo record) {

            return  getSqlMapClientTemplate().queryForList("propiedadarchivo.ibatorgenerated_selectByCodPropiedad", record);
    }
    // 
}