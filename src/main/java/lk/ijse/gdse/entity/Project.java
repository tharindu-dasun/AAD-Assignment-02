package lk.ijse.gdse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Project {
    @Id
    private String projectId;
    private String projectName;
    private String projectDescription;
    private String projectDeadline;
    @ManyToOne
    private TechLead techLeadId;
}
