package lk.ijse.gdse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TechleadDTO implements Serializable, SuperDTO {
    private String techLeadId;
    private String techLeadName;
    private String techLeadEmail;
    private String techLeadAddress;
}
