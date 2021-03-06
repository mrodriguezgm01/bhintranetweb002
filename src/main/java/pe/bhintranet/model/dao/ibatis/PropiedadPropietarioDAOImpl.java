package pe.bhintranet.model.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import pe.bhintranet.model.bean.PropiedadPropietario;
import pe.bhintranet.model.dao.PropiedadPropietarioDAO;

public class PropiedadPropietarioDAOImpl extends SqlMapClientDaoSupport implements PropiedadPropietarioDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadpropietario
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public PropiedadPropietarioDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadpropietario
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public int deleteByPrimaryKey(Long codpropiedadpropietario) {
        PropiedadPropietario key = new PropiedadPropietario();
        key.setCodpropiedadpropietario(codpropiedadpropietario);
        int rows = getSqlMapClientTemplate().delete("propiedadpropietario.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadpropietario
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public void insert(PropiedadPropietario record) {
        getSqlMapClientTemplate().insert("propiedadpropietario.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadpropietario
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public void insertSelective(PropiedadPropietario record) {
        getSqlMapClientTemplate().insert("propiedadpropietario.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadpropietario
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public PropiedadPropietario selectByPrimaryKey(Long codpropiedadpropietario) {
        PropiedadPropietario key = new PropiedadPropietario();
        key.setCodpropiedadpropietario(codpropiedadpropietario);
        PropiedadPropietario record = (PropiedadPropietario) getSqlMapClientTemplate().queryForObject("propiedadpropietario.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadpropietario
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public int updateByPrimaryKeySelective(PropiedadPropietario record) {
        int rows = getSqlMapClientTemplate().update("propiedadpropietario.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table propiedadpropietario
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public int updateByPrimaryKey(PropiedadPropietario record) {
        int rows = getSqlMapClientTemplate().update("propiedadpropietario.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }
}