package mk.ukim.finki.emt.lab.Repository;

import mk.ukim.finki.emt.lab.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
