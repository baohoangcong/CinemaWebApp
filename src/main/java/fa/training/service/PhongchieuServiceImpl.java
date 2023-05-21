package fa.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entities.PhongChieu;
import fa.training.page.PageAble;
import fa.training.repository.PhongchieuRepositoryImpl;

@Service
@Transactional
public class PhongchieuServiceImpl {
	
	@Autowired
	private PhongchieuRepositoryImpl phongchieuRepositoryImpl;
	
	public List<PhongChieu> findAll() {
		return phongchieuRepositoryImpl.findAll();
	}
	
	public void saveOrUpdate(PhongChieu PhongChieu) {
		phongchieuRepositoryImpl.saveOrUpdate(PhongChieu);
	}
	
	public void delete(String id) {
		PhongChieu PhongChieu = phongchieuRepositoryImpl.findById(id);
		if (PhongChieu != null) {
			phongchieuRepositoryImpl.delete(PhongChieu);
		}
	}
	
	public PhongChieu findById(String id) {
		return phongchieuRepositoryImpl.findById(id);
	}
	
	public List<PhongChieu> findWithPageAble(PageAble pageAble) {
		return phongchieuRepositoryImpl.findWithPageAble(pageAble);
	}
	
	public int totalPages(PageAble pageAble) {
		return (int) Math.ceil((double) phongchieuRepositoryImpl.count() / pageAble.getSize());
	}
	
	public List<PhongChieu> search(String searchKey) {
		return phongchieuRepositoryImpl.search(searchKey);
	}
	
	public boolean existInDB(String s) {
		return phongchieuRepositoryImpl.existInDB(s);
	}
}
