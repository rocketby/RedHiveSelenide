package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetsMeta {
    private List<Tweet> data;
    private Meta meta;

    public String getOldestId() {
        return meta.getOldestId();
    }

    public String getNewestId() {
        return meta.getNewestId();
    }

    public int resultCount() {
        return meta.getResultCount();
    }
}
