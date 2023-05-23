package fa.training.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.entities.Phim;
import fa.training.page.PageAble;

@Repository
public class PhimRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Phim> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT c FROM Phim c", Phim.class).getResultList();
	}
	
	public void saveOrUpdate(Phim Phim) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(Phim);
	}
	
	public void delete(Phim Phim) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(Phim);
	}
	
	public Phim findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Phim.class, id);
	}
	
	public List<Phim> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT c FROM Phim c", Phim.class)
				.setFirstResult(pageAble.getOffset())
				.setMaxResults(pageAble.getSize())
				.getResultList();
	}
	
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM Phim", Long.class).getSingleResult();
	}
	
	public List<Phim> search(String searchKey) {
		Session session = sessionFactory.getCurrentSession();
		Query<Phim> query = session.createQuery("SELECT c FROM Phim c WHERE c.maPhim LIKE :searchKey", Phim.class);
		query.setParameter("searchKey", "%" + searchKey + "%");
		return query.getResultList();
	}
	
	public boolean existInDB(String s) {
		Session session = sessionFactory.getCurrentSession();
		Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Phim c WHERE c.maPhim = :s", Long.class);
		query.setParameter("s", s);
		return query.getSingleResult() > 0;
	}
}
