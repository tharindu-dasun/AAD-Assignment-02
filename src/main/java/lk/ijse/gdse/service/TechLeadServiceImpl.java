package lk.ijse.gdse.service;

import lk.ijse.gdse.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TechLeadServiceImpl implements TechLeadService{
    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TechLeadRepo techLeadRepo;

    @Override
    public Response save(TechLeadDTO techLeadDTO) {
        if (search(techLeadDTO.getTechLeadId()).getData() == null) {
            techLeadRepo.save(modelMapper.map(techLeadDTO, TechLead.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Employee Successfully saved!", null);
        }
        throw new RuntimeException("Employee already exists!");
    }

    @Override
    public Response update(TechLeadDTO techLeadDTO) {
        if (search(techLeadDTO.getTechLeadId()).getData() != null) {
            techLeadRepo.save(modelMapper.map(techLeadDTO, TechLead.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Employee Successfully updated!", null);
        }
        throw new RuntimeException("Employee does not exists!");
    }

    @Override
    public Response delete(String s) {
        if (search(s).getData() != null) {
            techLeadRepo.deleteById(s);
            return createAndSendResponse(HttpStatus.OK.value(), "Employee Successfully deleted!", null);
        }
        throw new RuntimeException("Employee does not exists!");
    }

    @Override
    public Response search(String s) {
        Optional<TechLead> techLead = techLeadRepo.findById(s);
        if (techLead.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "Employee Successfully retrieved!", modelMapper.map(techLead.get(), TechLeadDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Employee doe not exists!", null);
    }

    @Override
    public Response getAll() {
        List<TechLead> techLeads = techLeadRepo.findAll();
        if (!techLeads.isEmpty()) {
            ArrayList<TechLeadDTO> techLead_dtos = new ArrayList<>();
            techLeads.forEach((techLead) -> {
                techLead_dtos.add(modelMapper.map(techLead, TechLeadDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Employees Successfully retrieved!", techLead_dtos);
        }
        throw new RuntimeException("No employees found in the database!");

    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
