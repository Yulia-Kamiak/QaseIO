package models;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {
    @Expose
    private String title;
    @Expose
    private String code;
    @Expose
    private String description;
    @Expose
    private String access;
    @Expose
    private Object group;
}
