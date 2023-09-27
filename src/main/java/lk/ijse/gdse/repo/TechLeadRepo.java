package lk.ijse.gdse.repo;

import lk.ijse.gdse.entity.TechLead;

public class TechLeadRepo extends JpaRepository<TechLead, String> {

    @Query("select t from TechLead t where t.techLeadId = ?1")
    TechLead findTechLead(String techLeadId);
}
