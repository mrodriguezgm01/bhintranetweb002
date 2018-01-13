package pe.bhintranet.model.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import pe.bhintranet.model.bean.Departamento;
import pe.bhintranet.model.dao.DepartamentoDAO;

public class DepartamentoDAOImpl extends SqlMapClientDaoSupport implements DepartamentoDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table departamento
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public DepartamentoDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table departamento
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public int deleteByPrimaryKey(Integer coddepartamento) {
        Departamento key = new Departamento();
        key.setCoddepartamento(coddepartamento);
        int rows = getSqlMapClientTemplate().delete("departamento.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table departamento
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public void insert(Departamento record) {
        getSqlMapClientTemplate().insert("departamento.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table departamento
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public void insertSelective(Departamento record) {
        getSqlMapClientTemplate().insert("departamento.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table departamento
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public Departamento selectByPrimaryKey(Integer coddepartamento) {
        Departamento key = new Departamento();
        key.setCoddepartamento(coddepartamento);
        Departamento record = (Departamento) getSqlMapClientTemplate().queryForObject("departamento.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table departamento
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public int updateByPrimaryKeySelective(Departamento record) {
        int rows = getSqlMapClientTemplate().update("departamento.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table departamento
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    public int updateByPrimaryKey(Departamento record) {
        int rows = getSqlMapClientTemplate().update("departamento.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }
}