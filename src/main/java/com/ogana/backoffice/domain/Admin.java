package com.ogana.backoffice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "userId")
public class Admin {
    @Id
    private String userId;
    private String password;
}
