package lk.ijse.gdse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class TechLead {
    @Id
    private String techLeadId;
    private String techLeadName;
    private String techLeadEmail;
    private String techLeadAddress;
    @OneToMany(mappedBy = "techLeadId" ,targetEntity = Project.class,cascade = CascadeType.ALL)
    private List<Project> projectsList = new ArrayList<>();
}
