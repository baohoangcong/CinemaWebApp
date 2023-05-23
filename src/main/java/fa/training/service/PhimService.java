package fa.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entities.Phim;
import fa.training.page.PageAble;
import fa.training.repository.PhimRepository;

@Service
@Transactional
public class PhimService {
	
	@Autowired
	private PhimRepository PhimRepository;
	
	public List<Phim> findAll() {
		return PhimRepository.findAll();
	}
	
	public void saveOrUpdate(Phim Phim) {
		PhimRepository.saveOrUpdate(Phim);
	}
	
	public void delete(String id) {
		Phim Phim = PhimRepository.findById(id);
		if (Phim != null) {
			PhimRepository.delete(Phim);
		}
	}
	
	public Phim findById(String id) {
		return PhimRepository.findById(id);
	}
	
	public List<Phim> findWithPageAble(PageAble pageAble) {
		return PhimRepository.findWithPageAble(pageAble);
	}
	
	public int totalPages(PageAble pageAble) {
		return (int) Math.ceil((double) PhimRepository.count() / pageAble.getSize());
	}
	
	public List<Phim> search(String searchKey) {
		return PhimRepository.search(searchKey);
	}
	
	public boolean existInDB(String s) {
		return PhimRepository.existInDB(s);
	}
}
