package pl.kruchyxe.hellhealth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kruchyxe.hellhealth.model.GroceryList;

public interface GroceryListRepository
        extends JpaRepository<GroceryList, Integer> {

}
