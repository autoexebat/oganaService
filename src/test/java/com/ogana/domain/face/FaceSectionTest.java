package com.ogana.domain.face;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FaceSectionTest {
    @Test
    @DisplayName("부위별 가격 총합계 구하기")
    void face_section_total_price() {
        FaceDetailSection fs1 = new FaceDetailSection("aa", new BigDecimal(10));
        FaceDetailSection fs2 = new FaceDetailSection("bb", new BigDecimal(30));
        FaceDetailSection fs3 = new FaceDetailSection("cc", new BigDecimal(20));

        FaceSection faceSection = new FaceSection("AA", List.of(fs1, fs2, fs3));

        assertEquals(faceSection.getTotalPrice(), new BigDecimal(60));
    }
}