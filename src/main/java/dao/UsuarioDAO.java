package dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Usuario;

public class UsuarioDAO extends DAO<Usuario, Integer> {

	public Usuario login(Usuario usuario){
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.login",Usuario.class);
		query.setParameter("email", usuario.getEmail());
		query.setParameter("senha", usuario.getSenha());
		
		try{
			return query.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}
	
}
