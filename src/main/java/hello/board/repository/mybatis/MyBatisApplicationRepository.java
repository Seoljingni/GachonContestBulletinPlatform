package hello.board.repository.mybatis;

import hello.board.domain.post.Post;
import hello.board.repository.ApplicationRepository;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MyBatisApplicationRepository extends ApplicationRepository {

    @Insert("INSERT INTO contest_application (post_id, member_id) VALUES (#{postId}, #{memberId})")
    void save(@Param("postId") Long postId, @Param("memberId") Long memberId);

    @Delete("DELETE FROM contest_application WHERE post_id = #{postId} AND member_id = #{memberId}")
    void delete(@Param("postId") Long postId, @Param("memberId") Long memberId);

    @Select("SELECT p.* FROM post p JOIN contest_application ca ON p.id = ca.post_id WHERE ca.member_id = #{memberId}")
    List<Post> findPostsByMemberId(@Param("memberId") Long memberId);

    @Select("SELECT COUNT(*) FROM contest_application WHERE post_id = #{postId} AND member_id = #{memberId}")
    int existsCount(@Param("postId") Long postId, @Param("memberId") Long memberId);  // ⚠ 이름 변경

    @Override
    default boolean exists(Long postId, Long memberId) {
        return existsCount(postId, memberId) > 0;
    }
}

