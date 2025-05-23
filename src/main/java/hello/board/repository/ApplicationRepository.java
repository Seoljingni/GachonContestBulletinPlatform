package hello.board.repository;

import hello.board.domain.post.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ApplicationRepository {
    void save(Long postId, Long memberId);
    void delete(Long postId, Long memberId);
    List<Post> findPostsByMemberId(Long memberId);
    boolean exists(Long postId, Long memberId);
}