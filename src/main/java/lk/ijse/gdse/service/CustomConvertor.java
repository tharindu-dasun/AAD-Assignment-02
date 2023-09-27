package lk.ijse.gdse.service;

import lk.ijse.gdse.dto.ProjectDTO;
import lk.ijse.gdse.entity.Project;

public class CustomConvertor {
    public static ProjectDTO toProjectsDTO(Project project){
        return new ProjectDTO(project.getProjectId(),project.getProjectName(),project.getProjectDescription(),project.getProjectDeadline(),project.getTechLeadId().getTechLeadId());
    }
}
