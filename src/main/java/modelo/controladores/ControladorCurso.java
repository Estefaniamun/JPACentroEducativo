package modelo.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.Query;

import modelo.Curso;
import modelo.TipologiaSexo;

public class ControladorCurso extends SuperControlador {

	/**
	 * Obtener el primer registro
	 * 
	 * @return
	 */
	public static Curso obtenerPrimero() {
		return obtencionDesdeSQL("SELECT * FROM curso order by id limit 1");
	}

	/**
	 * Obtener el último registro
	 * 
	 * @return
	 */
	public static Curso obtenerUltimo() {
		return obtencionDesdeSQL("SELECT * FROM curso order by id desc limit 1 ");
	}

	/**
	 * Obtener el registro siguiente
	 * 
	 * @param idActual
	 * @return
	 */
	public static Curso obtenerSiguiente(int idActual) {
		return obtencionDesdeSQL("SELECT * FROM curso where id > " + idActual + " order by id desc limit 1 ");
	}

	/**
	 * Obtener el registro anterior
	 * 
	 * @param idActual
	 * @return
	 */
	public static Curso obtenerAnterior(int idActual) {
		return obtencionDesdeSQL("SELECT * FROM curso where id < " + idActual + " order by id desc limit 1 ");
	}

	/**
	 * El findAll de la entidad Curso
	 */
	private static Curso obtencionDesdeSQL(String sql) {
		EntityManager em = createEntityManager();

		Query q = em.createNativeQuery(sql, Curso.class);
		Curso c = (Curso) q.getSingleResult();

		em.close();
		return c;
	}
	
	public List<Curso> findAll(){
		List<Curso> lista = new ArrayList<Curso>();
		EntityManager em = createEntityManager();

		Query q = em.createNativeQuery("select * from curso", Curso.class);
		lista.addAll((List<Curso>) q.getResultList());
	
		em.close();
		return lista;
	}

}
