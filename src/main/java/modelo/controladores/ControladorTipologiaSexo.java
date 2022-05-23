package modelo.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Curso;
import modelo.TipologiaSexo;

public class ControladorTipologiaSexo extends SuperControlador {
	/**
	 * Obtener el primer registro
	 * 
	 * @return
	 */
	public static TipologiaSexo obtenerPrimero() {
		return obtencionDesdeSQL("SELECT * FROM tipologiasexo order by id limit 1");
	}

	/**
	 * Obtener el último registro
	 * 
	 * @return
	 */
	public static TipologiaSexo obtenerUltimo() {
		return obtencionDesdeSQL("SELECT * FROM tipologiasexo order by id desc limit 1 ");
	}

	/**
	 * Obtener el registro siguiente
	 * 
	 * @param idActual
	 * @return
	 */
	public static TipologiaSexo obtenerSiguiente(int idActual) {
		return obtencionDesdeSQL("SELECT * FROM tipologiasexo where id > " + idActual + " order by id desc limit 1 ");
	}

	/**
	 * Obtener el registro anterior
	 * 
	 * @param idActual
	 * @return
	 */
	public static TipologiaSexo obtenerAnterior(int idActual) {
		return obtencionDesdeSQL("SELECT * FROM tipologiasexo where id < " + idActual + " order by id desc limit 1 ");
	}

	/**
	 * El findAll de la entidad Curso
	 */
	private static TipologiaSexo obtencionDesdeSQL(String sql) {
		EntityManager em = createEntityManager();

		Query q = em.createNativeQuery(sql, TipologiaSexo.class);
		TipologiaSexo tipo = (TipologiaSexo) q.getSingleResult();

		em.close();
		return tipo;
	}

	
	public List<TipologiaSexo> findAll(){
		List<TipologiaSexo> lista = new ArrayList<TipologiaSexo>();
		EntityManager em = createEntityManager();

		Query q = em.createNativeQuery("select * from tipologiasexo", TipologiaSexo.class);
		lista.addAll((List<TipologiaSexo>) q.getResultList());
	
		em.close();
		return lista;
	}
	
}
