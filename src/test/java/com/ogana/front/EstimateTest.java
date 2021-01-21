package com.ogana.front;

import com.ogana.front.domain.CustomerInfo;
import com.ogana.front.domain.Estimate;
import com.ogana.front.domain.FaceSectionDetailDto;
import com.ogana.front.domain.FaceSectionDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstimateTest {
    private List<FaceSectionDto> list;

    @BeforeEach
    void bf() {
        FaceSectionDetailDto f1 = new FaceSectionDetailDto("a", new BigDecimal(100));
        FaceSectionDetailDto f2 = new FaceSectionDetailDto("a", new BigDecimal(10));
        FaceSectionDetailDto f3 = new FaceSectionDetailDto("a", new BigDecimal(10));
        FaceSectionDetailDto f4 = new FaceSectionDetailDto("a", new BigDecimal(10));
        FaceSectionDetailDto f5 = new FaceSectionDetailDto("a", new BigDecimal(10));
        FaceSectionDetailDto f6 = new FaceSectionDetailDto("a", new BigDecimal(50));
        FaceSectionDto fs1 = new FaceSectionDto("A", List.of(f1, f2));
        FaceSectionDto fs2 = new FaceSectionDto("A", List.of(f3, f4));
        FaceSectionDto fs3 = new FaceSectionDto("A", List.of(f5));
        FaceSectionDto fs4 = new FaceSectionDto("A", List.of(f6));

        list = List.of(fs1, fs2, fs3, fs4);
    }

    @Test
    @DisplayName("총 시술부위 개수 가져오기")
    void get_total_faceDetail_count() {
        Estimate estimate = new Estimate(new CustomerInfo(), list);
        assertEquals(6 , estimate.totalFaceDetailSectionCount());
    }

    @Test
    @DisplayName("총 가격 가져오기")
    void get_total_price() {
        Estimate estimate = new Estimate(new CustomerInfo(), list);
        assertEquals(new BigDecimal(190) , estimate.getTotalPrice());

    }
}