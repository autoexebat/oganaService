package com.ogana.mybatis.mapper;

import com.ogana.backoffice.domain.FaceSectionDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FaceSectionDetailMapper {
    List<FaceSectionDetail> selectFSD();
    int deleteFSD(Long id);
    int mergeFSD(FaceSectionDetail fsd);
}
