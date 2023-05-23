package fa.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entities.Ve;
import fa.training.page.PageAble;
import fa.training.repository.VeRepository;

@Service
@Transactional
public class VeService {
	
	@Autowired
	private VeRepository VeRepository;
	
	public List<Ve> findAll() {
		return VeRepository.findAll();
	}
	
	public void saveOrUpdate(Ve Ve) {
		VeRepository.saveOrUpdate(Ve);
	}
	
	public void delete(int id) {
		Ve Ve = VeRepository.findById(id);
		if (Ve != null) {
			VeRepository.delete(Ve);
		}
	}
	
	public Ve findById(int id) {
		return VeRepository.findById(id);
	}
	
	public List<Ve> findWithPageAble(PageAble pageAble) {
		return VeRepository.findWithPageAble(pageAble);
	}
	
	public int totalPages(PageAble pageAble) {
		return (int) Math.ceil((double) VeRepository.count() / pageAble.getSize());
	}
	
	public List<Ve> getListBySuatChieu(int searchKey) {
		return VeRepository.getListBySuatChieu(searchKey);
	}
	
	public boolean existInDB(int s) {
		return VeRepository.existInDB(s);
	}
}
