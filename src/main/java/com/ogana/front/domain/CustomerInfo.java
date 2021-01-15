package com.ogana.front.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CustomerInfo {
    private Long id;
    private String name;
    private String gender;
    private String age;

}
