package fa.training.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.entities.Ve;
import fa.training.page.PageAble;

@Repository
public class VeRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Ve> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT c FROM Ve c", Ve.class).getResultList();
	}
	
	public void saveOrUpdate(Ve Ve) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(Ve);
	}
	
	public void delete(Ve Ve) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(Ve);
	}
	
	public Ve findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Ve.class, id);
	}
	
	public List<Ve> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT c FROM Ve c", Ve.class)
				.setFirstResult(pageAble.getOffset())
				.setMaxResults(pageAble.getSize())
				.getResultList();
	}
	
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM Ve", Long.class).getSingleResult();
	}
	
	public List<Ve> getListBySuatChieu(int searchKey) {
		Session session = sessionFactory.getCurrentSession();
		Query<Ve> query = session.createQuery("SELECT c FROM Ve c WHERE c.suatChieu.maSuatChieu = :searchKey", Ve.class);
		query.setParameter("searchKey", searchKey);
		return query.getResultList();
	}
	
	public boolean existInDB(int s) {
		Session session = sessionFactory.getCurrentSession();
		Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Ve c WHERE c.maSuatChieu = :s", Long.class);
		query.setParameter("s", s);
		return query.getSingleResult() > 0;
	}
}
