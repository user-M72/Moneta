package Moneta.cashflow.entity;

import Moneta.cashflow.entity.baseDomain.BaseDomain;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends BaseDomain {

    private String name;

    private String description;

}
