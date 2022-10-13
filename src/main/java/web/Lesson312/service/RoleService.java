package web.Lesson312.service;

import web.Lesson312.model.Role;
import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getAllRoles ();
    void addRole(Role role);
    Role findById(long id);
    Set<Role> findByIdRoles(List<Long>roles);

    void addDefaultRole();
}