package com.ogana.front.face;

import com.ogana.front.domain.FaceSectionDetailDto;
import com.ogana.front.domain.FaceSectionDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FaceSectionDtoTest {
    @Test
    @DisplayName("부위별 가격 총합계 구하기")
    void face_section_total_price() {
        FaceSectionDetailDto fs1 = new FaceSectionDetailDto("aa", new BigDecimal(10));
        FaceSectionDetailDto fs2 = new FaceSectionDetailDto("bb", new BigDecimal(30));
        FaceSectionDetailDto fs3 = new FaceSectionDetailDto("cc", new BigDecimal(20));

        FaceSectionDto faceSectionDto = new FaceSectionDto("AA", List.of(fs1, fs2, fs3));

        assertEquals(faceSectionDto.getTotalPrice(), new BigDecimal(60));
    }
}