package hello.board.service.application;

import hello.board.domain.post.Post;
import java.util.List;

public interface ApplicationService {

    void apply(Long postId, Long memberId);

    void cancel(Long postId, Long memberId);

    List<Post> findAppliedContests(Long memberId);
}
