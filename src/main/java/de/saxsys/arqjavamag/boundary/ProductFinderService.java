package de.saxsys.arqjavamag.boundary;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.saxsys.arqjavamag.entity.Product;

@Stateless
public class ProductFinderService {

	@PersistenceContext
	private EntityManager em;

	public Product findProductByCode(String code) {
		TypedQuery<Product> query = em.createNamedQuery("Product.byCode",
				Product.class);
		query.setParameter("code", code);

		return query.getSingleResult();
	}

}
