package com.cgx.test.infrastructure.persistence.demo.mapper;

import com.cgx.test.infrastructure.persistence.demo.model.TransferFlowDO;
import com.cgx.test.infrastructure.persistence.demo.model.TransferFlowDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransferFlowMapper {

    int countByExample(TransferFlowDOExample example);

    int deleteByExample(TransferFlowDOExample example);

    int deleteByPrimaryKey(Long id);

    /**
     * 新增流水
     */
    int insert(TransferFlowDO record);

    int insertSelective(TransferFlowDO record);

    List<TransferFlowDO> selectByExample(TransferFlowDOExample example);

    TransferFlowDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransferFlowDO record,
                                 @Param("example") TransferFlowDOExample example);

    int updateByExample(@Param("record") TransferFlowDO record, @Param("example") TransferFlowDOExample example);

    int updateByPrimaryKeySelective(TransferFlowDO record);

    int updateByPrimaryKey(TransferFlowDO record);

    /**
     * 更新状态
     */
    void updateState(@Param("transactionNo") String transactionNo, @Param("state") int state);

}