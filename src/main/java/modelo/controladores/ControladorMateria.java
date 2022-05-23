package modelo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Curso;
import modelo.Materia;

public class ControladorMateria extends SuperControlador {
	/**
	 * Obtener el primer registro
	 * 
	 * @return
	 */
	public static Materia obtenerPrimero() {
		return obtencionDesdeSQL("SELECT * FROM materia order by id limit 1");
	}

	/**
	 * Obtener el último registro
	 * 
	 * @return
	 */
	public static Materia obtenerUltimo() {
		return obtencionDesdeSQL("SELECT * FROM materia order by id desc limit 1 ");
	}

	/**
	 * Obtener el registro siguiente
	 * 
	 * @param idActual
	 * @return
	 */
	public static Materia obtenerSiguiente(int idActual) {
		return obtencionDesdeSQL("SELECT * FROM materia where id > " + idActual + " order by id desc limit 1 ");
	}

	/**
	 * Obtener el registro anterior
	 * 
	 * @param idActual
	 * @return
	 */
	public static Materia obtenerAnterior(int idActual) {
		return obtencionDesdeSQL("SELECT * FROM materia where id < " + idActual + " order by id desc limit 1 ");
	}

	/**
	 * El findAll de la entidad Curso
	 */
	private static Materia obtencionDesdeSQL(String sql) {
		EntityManager em = createEntityManager();

		Query q = em.createNativeQuery(sql, Curso.class);
		Materia m = (Materia) q.getSingleResult();

		em.close();
		return m;
	}
}
