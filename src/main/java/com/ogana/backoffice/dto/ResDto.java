package com.ogana.backoffice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResDto<T> {
    private List<T> updatedRows;
    private List<T> deletedRows;
}
