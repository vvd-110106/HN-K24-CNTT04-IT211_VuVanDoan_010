package re.dgnl.it211_session14_hackathon.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.dgnl.it211_session14_hackathon.model.dto.PostRequest;
import re.dgnl.it211_session14_hackathon.model.dto.PostResponseDTO;
import re.dgnl.it211_session14_hackathon.service.PostService;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostResponseDTO> createPost(@Valid @RequestBody PostRequest requestDTO) {
        return new ResponseEntity<>(postService.createPost(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<PostResponseDTO>> getAllPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(postService.getAllPosts(pageable), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDTO> updatePost(
            @PathVariable Long id,
            @Valid @RequestBody PostRequest requestDTO) {
        return new ResponseEntity<>(postService.updatePost(id, requestDTO), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PostResponseDTO> patchPost(
            @PathVariable Long id,
            @RequestBody PostRequest requestDTO) {
        return new ResponseEntity<>(postService.patchPost(id, requestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}