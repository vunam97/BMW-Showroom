package com.vti.testing.form.news;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class NewsCreateForm {
    private String title;
    private String description;
    private String image;
}
