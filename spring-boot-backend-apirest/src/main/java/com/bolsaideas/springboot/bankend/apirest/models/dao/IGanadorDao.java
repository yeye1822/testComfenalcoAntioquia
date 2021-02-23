package com.bolsaideas.springboot.bankend.apirest.models.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bolsaideas.springboot.bankend.apirest.models.entity.Ganador;
import com.bolsaideas.springboot.bankend.apirest.models.entity.Premio;

@Transactional
public interface IGanadorDao extends CrudRepository<Ganador, Long>{

	public Ganador findByIdganador(String idganador);
	
	@Query(value="select * from premio where cantidad > 0 order by RAND() LIMIT 1 ", nativeQuery=true)
	public Premio premioAsignar();
	
/*	@Query(value="SELECT clientes.tipo, clientes.documento, clientes.nombre , clientes.apellido, premio.descripcion  \r\n" + 
				"FROM ganador inner join clientes on ganador.idganador=clientes.id \r\n" + 
				"			   inner join premio on ganador.idpremio=premio.id; ", nativeQuery=true)
	public Iterable<Premio> ganadoresvsPremios();
	*/
}
