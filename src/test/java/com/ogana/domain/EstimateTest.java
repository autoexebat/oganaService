package com.ogana.domain;

import com.ogana.domain.face.FaceDetailSection;
import com.ogana.domain.face.FaceSection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstimateTest {
    private List<FaceSection> list;

    @BeforeEach
    void bf() {
        FaceDetailSection f1 = new FaceDetailSection("a", new BigDecimal(100));
        FaceDetailSection f2 = new FaceDetailSection("a", new BigDecimal(10));
        FaceDetailSection f3 = new FaceDetailSection("a", new BigDecimal(10));
        FaceDetailSection f4 = new FaceDetailSection("a", new BigDecimal(10));
        FaceDetailSection f5 = new FaceDetailSection("a", new BigDecimal(10));
        FaceDetailSection f6 = new FaceDetailSection("a", new BigDecimal(50));
        FaceSection fs1 = new FaceSection("A", List.of(f1, f2));
        FaceSection fs2 = new FaceSection("A", List.of(f3, f4));
        FaceSection fs3 = new FaceSection("A", List.of(f5));
        FaceSection fs4 = new FaceSection("A", List.of(f6));

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