package re.dgnl.it211_session14_hackathon.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import re.dgnl.it211_session14_hackathon.model.dto.PostRequest;
import re.dgnl.it211_session14_hackathon.model.dto.PostResponseDTO;

public interface PostService {
    PostResponseDTO createPost(PostRequest request);
    Page<PostResponseDTO> getAllPosts(Pageable pageable);
    PostResponseDTO updatePost(Long id, PostRequest request);
    PostResponseDTO patchPost(Long id, PostRequest request);
    void deletePost(Long id);
}