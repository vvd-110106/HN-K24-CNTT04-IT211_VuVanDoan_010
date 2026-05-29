package re.dgnl.it211_session14_hackathon.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import re.dgnl.it211_session14_hackathon.model.entity.StatusEnum;

@Data
public class PostRequest {

    @NotBlank(message = "Tên tài khoản (username) không được để trống")
    private String username;

    @NotBlank(message = "Nội dung bài viết (content) không được để trống")
    private String content;

    @NotNull(message = "Số lượng lượt thích không được để trống")
    @Min(value = 0, message = "Số lượng lượt thích phải lớn hơn hoặc bằng 0")
    private Integer likes;

    private StatusEnum status = StatusEnum.PUBLIC;
}