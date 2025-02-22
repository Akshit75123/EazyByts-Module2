package trading.stock.repository;

import trading.stock.dto.Security;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRepository extends JpaRepository<Security, Integer> {

}
