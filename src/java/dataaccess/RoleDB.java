package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import models.Role;
import models.User;
/**
 *
 * @author Alex Tompkins - 821984
 */
public class RoleDB {
    public List<Role> getAll() throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try{
            List<Role> fullRoleeList = em.createNamedQuery("Role.findAll", Role.class).getResultList();
            return fullRoleList;
        } finally{
            em.close();
        }
    }
    
    public Role getRole(int roleId) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Role role = em.find(Role.class, roleId);
            return role;
        } finally {
            em.close();
        }
    }

}
