package re.dgnl.it211_session14_hackathon.model.dto;

import lombok.Data;
import re.dgnl.it211_session14_hackathon.model.entity.StatusEnum;

@Data
public class PostResponseDTO {
    private Long id;
    private String username;
    private String content;
    private Integer likes;
    private StatusEnum status;
}