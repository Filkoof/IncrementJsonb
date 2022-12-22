package com.superkassa_test.superkassa_test.entity;

import com.superkassa_test.superkassa_test.dto.MyJson;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Getter
@Setter
@Table(name = "sk_example_table")
public class SkExampleTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JdbcTypeCode(SqlTypes.JSON)
    private MyJson obj;
}
