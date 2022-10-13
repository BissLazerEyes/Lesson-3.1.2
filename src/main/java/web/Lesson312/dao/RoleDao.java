package web.Lesson312.dao;

import web.Lesson312.model.Role;
import java.util.List;
import java.util.Set;

public interface RoleDao {
    List<Role> getAllRoles ();
    void addRole(Role role);
    Role findById(long id);
    Set<Role> findByIdRoles(List<Long>roles);
}