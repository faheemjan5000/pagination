package faheem.microservices.pagination.repository;

import faheem.microservices.pagination.entity.Palazzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalazzoRepository extends JpaRepository<Palazzo,Integer> {
}
