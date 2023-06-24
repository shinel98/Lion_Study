package com.likelion.backend.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.likelion.backend.domain.entity.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE reserve_record SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class ReserveRecord extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
