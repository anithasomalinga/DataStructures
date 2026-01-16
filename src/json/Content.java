package json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Content {
    private String type;
    private String text;
    @JsonProperty("content")
    private List<Content> content;
    public Content() {
    }
    public List<Content> getChildren() {
        return content;
    }

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }
}
