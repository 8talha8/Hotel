package hotelrooms.repositories;

import org.springframework.data.repository.CrudRepository;

import hotelrooms.models.Role;

public interface RoleRepository extends CrudRepository<Role, String> {

    Role findByRole(String role);


}
