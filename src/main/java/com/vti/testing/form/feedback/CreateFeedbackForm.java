package com.vti.testing.form.feedback;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CreateFeedbackForm {
    private String fullName;
    private String messagesContent;
    private LocalDateTime sendDate;
}