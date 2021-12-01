package com.aacademy.realestate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name ="floor")

public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    privete Long id;

    @NotNull
    @Column(unique = true, nullable = false)
    private Integer number;

}
