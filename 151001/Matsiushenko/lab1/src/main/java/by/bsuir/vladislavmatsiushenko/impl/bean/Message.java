package by.bsuir.vladislavmatsiushenko.impl.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message {
    private long id;
    private String content;
    private long issueId;
}

