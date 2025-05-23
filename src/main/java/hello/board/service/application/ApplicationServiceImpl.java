package hello.board.service.application;

import hello.board.domain.post.Post;
import hello.board.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public void apply(Long postId, Long memberId) {
        if (!applicationRepository.exists(postId, memberId)) {
            applicationRepository.save(postId, memberId);
        }
    }

    @Override
    public void cancel(Long postId, Long memberId) {
        applicationRepository.delete(postId, memberId);
    }

    @Override
    public List<Post> findAppliedContests(Long memberId) {
        return applicationRepository.findPostsByMemberId(memberId);
    }
}
