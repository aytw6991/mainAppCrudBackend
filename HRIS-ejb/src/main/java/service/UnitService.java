package service;

import DaoImpl.UnitDaoImpl;
import dto.UnitCreateRequest;
import dto.UnitEditRequest;
import entity.Unit;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class UnitService {
    @Inject UnitDaoImpl unitDaoImpl;
    
    public List<Unit> getAll(){
        return unitDaoImpl.getAll();
    }
    
    public Unit getById(int id){
        Unit unit = unitDaoImpl.getById(id);
        return unit;
    }
    
    public Unit create(UnitCreateRequest unitCreateRequest){
        Unit unit = new Unit();
        unit.setName(unitCreateRequest.getName());
        return unitDaoImpl.create(unit);
    }
    
    public Unit edit(int id, UnitEditRequest unitEditRequest){
        Unit unit = unitDaoImpl.getById(id);
        unit.setName(unitEditRequest.getName());
        return unitDaoImpl.edit(id, unit);
    }
    
    public void delete(int id){
        unitDaoImpl.delete(id);
    }
}