package br.com.llapi.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.llapi.config.HibernateUtil;
import br.com.llapi.entity.Product;

public abstract class WishListRepositoryCustom {

	public static List<Product> getWishList(long clientId) {
		
		try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
			
			Query<Product> query = session.createQuery("FROM product WHERE id IN (SELECT product_id FROM whish_list WHERE client_id = :id)");
			query.setParameter("id", clientId);
			return query.list();
		}
	}
	
//	@Override
//    public Usuario findByUsuario(Usuario usuario) {
//        Usuario model = null;
//        Session sesion;
//        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
//        String sql = "FROM usuario WHERE usuario ='" +usuario.getUsuario()+"'";
//        try {
//            sesion.beginTransaction();
//            model = (Usuario) sesion.createQuery(sql).uniqueResult();
//            sesion.beginTransaction().commit();
//        } catch (Exception e) {
//            sesion.beginTransaction().rollback();
//        }
//
//        return model;
//    }
	
}
