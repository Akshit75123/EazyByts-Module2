package trading.stock.dao;

import java.util.Optional;

import trading.stock.dto.Portfolio;
import trading.stock.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PortfolioDao {
	@Autowired
	private PortfolioRepository pRepo;
	
	public Portfolio savePortfolio(Portfolio p) {
		return pRepo.save(p);
	}
	
	public Portfolio updatePortfolio(Portfolio p) {
		return pRepo.save(p);
	}
	
	public Optional<Portfolio> findPortfolioById(int portfolioID) {
		return pRepo.findById(portfolioID);
	}
	
	public boolean deletePortfolio(int portfolioID) {
		Optional<Portfolio> recPort = findPortfolioById(portfolioID);
		if(recPort.isPresent()) {
			pRepo.delete(recPort.get());
			return true;
		}
		return false;
		
	}
	
}
