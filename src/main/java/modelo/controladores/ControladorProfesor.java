package modelo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Curso;
import modelo.Profesor;

public class ControladorProfesor extends SuperControlador {
	/**
	 * Obtener el primer registro
	 * 
	 * @return
	 */
	public static Profesor obtenerPrimero() {
		return obtencionDesdeSQL("SELECT * FROM profesor order by id limit 1");
	}

	/**
	 * Obtener el último registro
	 * 
	 * @return
	 */
	public static Profesor obtenerUltimo() {
		return obtencionDesdeSQL("SELECT * FROM profesor order by id desc limit 1 ");
	}

	/**
	 * Obtener el registro siguiente
	 * 
	 * @param idActual
	 * @return
	 */
	public static Profesor obtenerSiguiente(int idActual) {
		return obtencionDesdeSQL("SELECT * FROM profesor where id > " + idActual + " order by id  limit 1 ");
	}

	/**
	 * Obtener el registro anterior
	 * 
	 * @param idActual
	 * @return
	 */
	public static Profesor obtenerAnterior(int idActual) {
		return obtencionDesdeSQL("SELECT * FROM profesor where id < " + idActual + " order by id desc limit 1 ");
	}

	/**
	 * El findAll de la entidad Profesor
	 */
	private static Profesor obtencionDesdeSQL(String sql) {
		EntityManager em = createEntityManager();

		Query q = em.createNativeQuery(sql, Profesor.class);
		Profesor p = (Profesor) q.getSingleResult();

		em.close();
		return p;
	}

}
