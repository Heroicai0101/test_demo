package com.cgx.test.infrastructure.persistence.demo.mapper;

import com.cgx.test.infrastructure.persistence.demo.model.AssertAccountDO;
import com.cgx.test.infrastructure.persistence.demo.model.AssertAccountDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssertAccountMapper {

    int countByExample(AssertAccountDOExample example);

    int deleteByExample(AssertAccountDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AssertAccountDO record);

    int insertSelective(AssertAccountDO record);

    List<AssertAccountDO> selectByExample(AssertAccountDOExample example);

    AssertAccountDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AssertAccountDO record,
                                 @Param("example") AssertAccountDOExample example);

    int updateByExample(@Param("record") AssertAccountDO record, @Param("example") AssertAccountDOExample example);

    int updateByPrimaryKeySelective(AssertAccountDO record);

    int updateByPrimaryKey(AssertAccountDO record);

    /** 按账户id查询 */
    AssertAccountDO selectByAccountId(@Param("accountId") Long accountId);

    /** 按账户id更新 */
    int updateByAccountId(AssertAccountDO record);

}