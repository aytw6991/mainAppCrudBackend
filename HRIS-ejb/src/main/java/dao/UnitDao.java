package dao;

import entity.Unit;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UnitDao {
   public List<Unit> getAll();
   public Unit getById(int id);
   public Unit create(Unit unit);
   public Unit edit(int id, Unit unit);
   public void delete(int id);
}
