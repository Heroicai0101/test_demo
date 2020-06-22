package com.cgx.test.infrastructure.persistence.demo.mapper;

import com.cgx.test.infrastructure.persistence.demo.model.TransferEventDO;
import com.cgx.test.infrastructure.persistence.demo.model.TransferEventDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransferEventMapper {

    int countByExample(TransferEventDOExample example);

    int deleteByExample(TransferEventDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransferEventDO record);

    int insertSelective(TransferEventDO record);

    List<TransferEventDO> selectByExample(TransferEventDOExample example);

    TransferEventDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransferEventDO record,
                                 @Param("example") TransferEventDOExample example);

    int updateByExample(@Param("record") TransferEventDO record, @Param("example") TransferEventDOExample example);

    int updateByPrimaryKeySelective(TransferEventDO record);

    int updateByPrimaryKey(TransferEventDO record);

}