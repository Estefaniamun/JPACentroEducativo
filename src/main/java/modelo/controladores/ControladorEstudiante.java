package modelo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Curso;
import modelo.Estudiante;

public class ControladorEstudiante extends SuperControlador {
	/**
	 * Obtener el primer registro
	 * 
	 * @return
	 */
	public static Estudiante obtenerPrimero() {
		return obtencionDesdeSQL("SELECT * FROM estudiante order by id limit 1");
	}

	/**
	 * Obtener el último registro
	 * 
	 * @return
	 */
	public static Estudiante obtenerUltimo() {
		return obtencionDesdeSQL("SELECT * FROM estudiante order by id desc limit 1 ");
	}

	/**
	 * Obtener el registro siguiente
	 * 
	 * @param idActual
	 * @return
	 */
	public static Estudiante obtenerSiguiente(int idActual) {
		return obtencionDesdeSQL("SELECT * FROM estudiante where id > " + idActual + " order by id desc limit 1 ");
	}

	/**
	 * Obtener el registro anterior
	 * 
	 * @param idActual
	 * @return
	 */
	public static Estudiante obtenerAnterior(int idActual) {
		return obtencionDesdeSQL("SELECT * FROM estudiante where id < " + idActual + " order by id desc limit 1 ");
	}

	/**
	 * El findAll de la entidad Estudiante
	 */
	private static Estudiante obtencionDesdeSQL(String sql) {
		EntityManager em = createEntityManager();

		Query q = em.createNativeQuery(sql, Estudiante.class);
		Estudiante e = (Estudiante) q.getSingleResult();

		em.close();
		return e;
	}

}
