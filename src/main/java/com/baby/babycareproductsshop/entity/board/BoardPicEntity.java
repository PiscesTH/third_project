package com.baby.babycareproductsshop.entity.board;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_board_pics")
public class BoardPicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iboard_pic")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "iboard", nullable = false)
    private BoardEntity boardEntity;

    @Column(name = "board_pic", nullable = false, length = 2500)
    private String pictureUrl;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
