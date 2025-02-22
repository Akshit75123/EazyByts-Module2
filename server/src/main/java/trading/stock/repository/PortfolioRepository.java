package trading.stock.repository;

import trading.stock.dto.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository  extends JpaRepository<Portfolio, Integer> {

}
