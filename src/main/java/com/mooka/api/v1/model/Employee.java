package com.mooka.api.v1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mooka.msr.IMsrModel;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements IMsrModel<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Field name cannot be null.")
    private String name;
    @NotNull(message = "Field birthday cannot be null.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthday;

    public Integer getId() {
        return id;
    }
}
