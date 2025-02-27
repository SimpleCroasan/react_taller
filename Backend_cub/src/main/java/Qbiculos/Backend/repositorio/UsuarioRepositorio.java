package Qbiculos.Backend.repositorio;


import Qbiculos.Backend.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	// JPQL: Se hace la consulta sobre la clase 
	@Query("select count(*) from Usuario as p where p.nombreUsuario= :nombreUsuario and p.password=:password")
	Integer findByNombreUsuarioAndPassword(@Param("nombreUsuario") String nombreUsuario,
			@Param("password") String password);

	
	@Query("select p from Usuario as p where p.nombreUsuario= :nombreUsuario and p.password=:password")
	Usuario findByNameAndPassword(@Param("nombreUsuario") String nombreUsuario,
			@Param("password") String password);
    
}
