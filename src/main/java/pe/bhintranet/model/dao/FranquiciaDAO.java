package pe.bhintranet.model.dao;

import pe.bhintranet.model.bean.Franquicia;

public interface FranquiciaDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table franquicia
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    int deleteByPrimaryKey(Integer codfranquicia);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table franquicia
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    void insert(Franquicia record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table franquicia
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    void insertSelective(Franquicia record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table franquicia
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    Franquicia selectByPrimaryKey(Integer codfranquicia);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table franquicia
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    int updateByPrimaryKeySelective(Franquicia record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table franquicia
     *
     * @ibatorgenerated Mon Dec 18 01:51:37 GMT 2017
     */
    int updateByPrimaryKey(Franquicia record);
}