package DaoImpl;

import entity.Unit;
import dao.UnitDao;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@ApplicationScoped
public class UnitDaoImpl implements UnitDao{
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Unit> getAll() {
        Query query = em.createNamedQuery("Unit.findAll", Unit.class);
        return query.getResultList();
    }
    
    @Override
    public Unit getById(int id){
        return em.find(Unit.class, id);
    }

    @Override
    public Unit create(Unit unit) {
        em.persist(unit);
        return unit;
    }

    @Override
    public Unit edit(int id, Unit unit) {
        em.find(Unit.class, id);
        em.merge(unit);
        return unit;
    }

    @Override
    public void delete(int id) {
        Unit u = em.find(Unit.class, id);
        em.remove(u);
    }
    
}
