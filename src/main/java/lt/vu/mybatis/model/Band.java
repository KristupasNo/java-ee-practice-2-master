package lt.vu.mybatis.model;

public class Band {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BAND.ID
     *
     * @mbg.generated Mon May 15 23:12:50 EEST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BAND.NAME
     *
     * @mbg.generated Mon May 15 23:12:50 EEST 2023
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BAND.HOMECONCERTHALL_ID
     *
     * @mbg.generated Mon May 15 23:12:50 EEST 2023
     */
    private Long homeconcerthallId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BAND.ID
     *
     * @return the value of PUBLIC.BAND.ID
     *
     * @mbg.generated Mon May 15 23:12:50 EEST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BAND.ID
     *
     * @param id the value for PUBLIC.BAND.ID
     *
     * @mbg.generated Mon May 15 23:12:50 EEST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BAND.NAME
     *
     * @return the value of PUBLIC.BAND.NAME
     *
     * @mbg.generated Mon May 15 23:12:50 EEST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BAND.NAME
     *
     * @param name the value for PUBLIC.BAND.NAME
     *
     * @mbg.generated Mon May 15 23:12:50 EEST 2023
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BAND.HOMECONCERTHALL_ID
     *
     * @return the value of PUBLIC.BAND.HOMECONCERTHALL_ID
     *
     * @mbg.generated Mon May 15 23:12:50 EEST 2023
     */
    public Long getHomeconcerthallId() {
        return homeconcerthallId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BAND.HOMECONCERTHALL_ID
     *
     * @param homeconcerthallId the value for PUBLIC.BAND.HOMECONCERTHALL_ID
     *
     * @mbg.generated Mon May 15 23:12:50 EEST 2023
     */
    public void setHomeconcerthallId(Long homeconcerthallId) {
        this.homeconcerthallId = homeconcerthallId;
    }
}