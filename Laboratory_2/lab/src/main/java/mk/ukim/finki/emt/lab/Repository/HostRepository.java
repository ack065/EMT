package mk.ukim.finki.emt.lab.Repository;

import mk.ukim.finki.emt.lab.Model.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository  extends JpaRepository<Host,Long> {
}
