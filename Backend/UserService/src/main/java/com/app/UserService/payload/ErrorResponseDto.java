package com.app.UserService.payload;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
public class ErrorResponseDto {
    private Date timestamp;
    private  String message;
    private String description;

    public ErrorResponseDto(Date timestamp, String message, String description) {
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }
}
