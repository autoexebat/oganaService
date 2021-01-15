package com.ogana.front.face;

import com.ogana.front.domain.FaceDetailSectionDto;
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
        FaceDetailSectionDto fs1 = new FaceDetailSectionDto("aa", new BigDecimal(10));
        FaceDetailSectionDto fs2 = new FaceDetailSectionDto("bb", new BigDecimal(30));
        FaceDetailSectionDto fs3 = new FaceDetailSectionDto("cc", new BigDecimal(20));

        FaceSectionDto faceSectionDto = new FaceSectionDto("AA", List.of(fs1, fs2, fs3));

        assertEquals(faceSectionDto.getTotalPrice(), new BigDecimal(60));
    }
}