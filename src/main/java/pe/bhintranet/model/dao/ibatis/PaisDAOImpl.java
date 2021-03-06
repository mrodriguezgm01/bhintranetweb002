package pe.bhintranet.model.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import pe.bhintranet.model.bean.Pais;
import pe.bhintranet.model.dao.PaisDAO;

public class PaisDAOImpl extends SqlMapClientDaoSupport implements PaisDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pais
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public PaisDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pais
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public int deleteByPrimaryKey(Integer codpais) {
        Pais key = new Pais();
        key.setCodpais(codpais);
        int rows = getSqlMapClientTemplate().delete("pais.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pais
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public void insert(Pais record) {
        getSqlMapClientTemplate().insert("pais.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pais
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public void insertSelective(Pais record) {
        getSqlMapClientTemplate().insert("pais.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pais
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public Pais selectByPrimaryKey(Integer codpais) {
        Pais key = new Pais();
        key.setCodpais(codpais);
        Pais record = (Pais) getSqlMapClientTemplate().queryForObject("pais.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pais
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public int updateByPrimaryKeySelective(Pais record) {
        int rows = getSqlMapClientTemplate().update("pais.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pais
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public int updateByPrimaryKey(Pais record) {
        int rows = getSqlMapClientTemplate().update("pais.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }
}