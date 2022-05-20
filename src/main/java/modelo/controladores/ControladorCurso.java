package modelo.controladores;

import javax.persistence.EntityManager;

import javax.persistence.Query;

import modelo.Curso;

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

}
