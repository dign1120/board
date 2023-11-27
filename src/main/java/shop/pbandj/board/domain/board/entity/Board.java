package shop.pbandj.board.domain.board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.pbandj.board.domain.board.constants.BoardCategory;
import shop.pbandj.board.domain.comment.entity.Comment;
import shop.pbandj.board.domain.likes.entity.Likes;
import shop.pbandj.board.domain.uploadImage.entity.UploadImage;
import shop.pbandj.board.domain.user.entity.User;
import shop.pbandj.board.global.entity.BaseEntity;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;   // 제목
    private String body;    // 본문

    @Enumerated(EnumType.STRING)
    private BoardCategory category; // 카테고리

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;      // 작성자

    @OneToMany(mappedBy = "board", orphanRemoval = true)
    private List<Likes> likes;       // 좋아요
    private Integer likeCnt;        // 좋아요 수

    @OneToMany(mappedBy = "board", orphanRemoval = true)
    private List<Comment> comments; // 댓글
    private Integer commentCnt;     // 댓글 수

    @OneToOne(fetch = FetchType.LAZY)
    private UploadImage uploadImage;

    //public void update(BoardDto dto) {
    //    this.title = dto.getTitle();
    //    this.body = dto.getBody();
    //}

    public void likeChange(Integer likeCnt) {
        this.likeCnt = likeCnt;
    }

    public void commentChange(Integer commentCnt) {
        this.commentCnt = commentCnt;
    }

    public void setUploadImage(UploadImage uploadImage) {
        this.uploadImage = uploadImage;
    }

}