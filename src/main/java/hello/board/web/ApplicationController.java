package hello.board.web;

import hello.board.domain.member.Member;
import hello.board.domain.post.Post;
import hello.board.service.application.ApplicationService;
import hello.board.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping("/application/apply")
    public String applyToContest(@RequestParam Long postId,
                                 @SessionAttribute(SessionConst.LOGIN_MEMBER) Member loginMember) {
        applicationService.apply(postId, loginMember.getId());
        return "redirect:/board/post/" + postId;
    }

    @GetMapping("/member/applications")
    public String myApplications(@SessionAttribute(SessionConst.LOGIN_MEMBER) Member loginMember, Model model) {
        List<Post> appliedPosts = applicationService.findAppliedContests(loginMember.getId());
        model.addAttribute("appliedPosts", appliedPosts);
        return "member/myApplications";
    }

    @PostMapping("/application/cancel")
    public String cancelApplication(@RequestParam Long postId,
                                    @SessionAttribute(SessionConst.LOGIN_MEMBER) Member loginMember) {
        applicationService.cancel(postId, loginMember.getId());
        return "redirect:/member/applications";
    }

}
