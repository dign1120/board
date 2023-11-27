package shop.pbandj.board.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.pbandj.board.domain.user.entity.User;

public interface MemberRepository extends JpaRepository<User, Long> {
}
