package lk.ijse.gdse.endpoints;

import lk.ijse.gdse.service.TechLeadService;

import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/techLead")
@CrossOrigin
public class TechLeadController {
    @Autowired
    private TechLeadService techLeadService;

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody TechLeadDTO techLead_dto) {
        return techLeadService.save(techLead_dto);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody TechLeadDTO techLead_dto) {
        return techLeadService.update(techLead_dto);
    }

    @GetMapping(path = "/search", params = "techLeadId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("techLeadId") String techLeadId) {
        return techLeadService.search(techLeadId);
    }

    @DeleteMapping(path = "/delete", params = "techLeadId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("techLeadId") String techLeadId) {
        return techLeadService.delete(techLeadId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return techLeadService.getAll();
    }
}
