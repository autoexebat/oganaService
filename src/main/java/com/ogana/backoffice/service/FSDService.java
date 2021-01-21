package com.ogana.backoffice.service;

import com.ogana.backoffice.domain.FaceSectionDetail;
import com.ogana.backoffice.dto.FaceSectionDetailDto;
import com.ogana.mybatis.mapper.FaceSectionDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FSDService {
    private final FaceSectionDetailMapper mapper;

    public List<FaceSectionDetail> select() {
        return mapper.selectFSD();
    }

    @Transactional
    public List<FaceSectionDetail> test() {
        FaceSectionDetail f1 = new FaceSectionDetail("f1", new BigDecimal(100));
        FaceSectionDetail f2 = new FaceSectionDetail("f2", new BigDecimal(200));
        FaceSectionDetail f3 = new FaceSectionDetail("f3", new BigDecimal(300));
        FaceSectionDetail f4 = new FaceSectionDetail( "f4", new BigDecimal(400));

        List<FaceSectionDetail> list = List.of(f1, f2, f3, f4);

        mapper.mergeFSD(f1);
        mapper.mergeFSD(f2);
        mapper.mergeFSD(f3);
        mapper.mergeFSD(f4);

        return list;
    }

    @Transactional
    public void update(List<FaceSectionDetailDto> updatedRows) {
        for(FaceSectionDetailDto dto : updatedRows) {
            mapper.mergeFSD(dto.toEntity());
        }
    }

    @Transactional
    public void delete(List<FaceSectionDetailDto> deletedRows) {
        for(FaceSectionDetailDto dto : deletedRows) {
            mapper.deleteFSD(dto.getId());
        }
    }

}
