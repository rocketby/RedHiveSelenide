package api.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Meta {
    private String oldest_id;
    private String newest_id;
    private int result_count;

    public String getOldestId() {
        return oldest_id;
    }

    public String getNewestId() {
        return newest_id;
    }

    public int getResultCount() {
        return result_count;
    }

}
