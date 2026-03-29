package Moneta.cashflow.entity.baseDomain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseDomain<T extends Serializable> implements Serializable{

    @Id
    @Generated
    private T id;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    protected UUID createdBy;

    @CreatedDate
    @Column(name = "created_date", updatable = false, nullable = false)
    protected Instant createdDate;

    @LastModifiedBy
    @Column(name = "updated_by")
    protected UUID updatedBy;

    @LastModifiedDate
    @Column(name = "updated_date")
    protected Instant updatedDate;
}
