package re.dgnl.it211_session14_hackathon.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import re.dgnl.it211_session14_hackathon.model.dto.PostRequest;
import re.dgnl.it211_session14_hackathon.model.dto.PostResponseDTO;
import re.dgnl.it211_session14_hackathon.exception.PostNotFoundException;
import re.dgnl.it211_session14_hackathon.model.entity.Post;
import re.dgnl.it211_session14_hackathon.repository.PostRepository;
import re.dgnl.it211_session14_hackathon.service.PostService;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public PostResponseDTO createPost(PostRequest dto) {
        Post post = new Post();
        post.setUsername(dto.getUsername());
        post.setContent(dto.getContent());
        post.setLikes(dto.getLikes());
        post.setStatus(dto.getStatus());
        return mapToResponseDTO(postRepository.save(post));
    }

    @Override
    public Page<PostResponseDTO> getAllPosts(Pageable pageable) {
        Page<Post> postPage = postRepository.findByIsDeletedFalse(pageable);
        return postPage.map(this::mapToResponseDTO);
    }

    @Override
    public PostResponseDTO updatePost(Long id, PostRequest dto) {
        Post post = postRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new PostNotFoundException("Không tìm thấy bài viết với ID " + id));

        post.setUsername(dto.getUsername());
        post.setContent(dto.getContent());
        post.setLikes(dto.getLikes());
        post.setStatus(dto.getStatus());
        return mapToResponseDTO(postRepository.save(post));
    }

    @Override
    public PostResponseDTO patchPost(Long id, PostRequest dto) {
        Post post = postRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new PostNotFoundException("Không tìm thấy bài viết với ID " + id));

        if (dto.getUsername() != null && !dto.getUsername().isBlank()) post.setUsername(dto.getUsername());
        if (dto.getContent() != null && !dto.getContent().isBlank()) post.setContent(dto.getContent());
        if (dto.getLikes() != null) post.setLikes(dto.getLikes());
        if (dto.getStatus() != null) post.setStatus(dto.getStatus());
        return mapToResponseDTO(postRepository.save(post));
    }

    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new PostNotFoundException("Không tìm thấy bài viết với ID " + id));

        post.setIsDeleted(true);
        postRepository.save(post);
    }

    private PostResponseDTO mapToResponseDTO(Post post) {
        PostResponseDTO dto = new PostResponseDTO();
        dto.setId(post.getId());
        dto.setUsername(post.getUsername());
        dto.setContent(post.getContent());
        dto.setLikes(post.getLikes());
        dto.setStatus(post.getStatus());
        return dto;
    }
}