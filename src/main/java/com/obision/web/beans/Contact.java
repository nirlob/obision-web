package com.obision.web.beans;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Contact {
    @NotEmpty(message = "Must enter an email")
    @Email(message = "Email not valid")
    String from;

    @NotEmpty(message = "Must enter a subject")
    String subject;

    @NotEmpty(message = "Must enter the body")
    String body;
}
