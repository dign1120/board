package shop.pbandj.board.domain.likes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.pbandj.board.domain.board.entity.Board;
import shop.pbandj.board.domain.user.entity.User;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;      // 좋아요를 누른 유저

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;    // 좋아요가 추가된 게시글
}
