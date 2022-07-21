package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Runs {
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("active")
    @Expose
    private Integer active;
}