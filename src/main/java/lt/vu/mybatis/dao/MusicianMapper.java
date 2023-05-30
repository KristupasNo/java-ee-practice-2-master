package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Musician;
import org.mybatis.cdi.Mapper;

@Mapper
public interface MusicianMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MUSICIAN
     *
     * @mbg.generated Mon May 15 23:12:50 EEST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MUSICIAN
     *
     * @mbg.generated Mon May 15 23:12:50 EEST 2023
     */
    int insert(Musician record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MUSICIAN
     *
     * @mbg.generated Mon May 15 23:12:50 EEST 2023
     */
    Musician selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MUSICIAN
     *
     * @mbg.generated Mon May 15 23:12:50 EEST 2023
     */
    List<Musician> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MUSICIAN
     *
     * @mbg.generated Mon May 15 23:12:50 EEST 2023
     */
    int updateByPrimaryKey(Musician record);
}