package com.ogana.backoffice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class GridDto<T>{
    @JsonIgnore
    private int page;
    @JsonIgnore
    private int totalCount;
    @JsonIgnore
    private List<T> resultList;

    private boolean result;
    private GridData<T> data;

    @AllArgsConstructor
    @Getter
    static class GridData<T>{
        private List<T> contents;
        private Pagination pagination;
    }

    @AllArgsConstructor
    @Getter
    static class Pagination{
        private int page;
        private int totalCount;
    }


    public GridDto(int page, int totalCount, boolean result, List<T> resultList) {
        this.page = page;
        this.totalCount = totalCount;
        this.result = result;
        this.resultList = resultList;

        Pagination pagination = new Pagination(page, totalCount);
        GridData gridData = new GridData(resultList, pagination);
        this.data = gridData;
    }

}
