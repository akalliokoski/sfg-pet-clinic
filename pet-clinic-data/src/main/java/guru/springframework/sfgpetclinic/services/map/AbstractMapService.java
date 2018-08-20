package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<Type extends BaseEntity, ID extends Long> {

    protected Map<Long, Type> map = new HashMap<>();

    Set<Type> findAll() {
        return new HashSet<>(map.values());
    }

    Type findById(ID id) {
        return map.get(id);
    }

    Type save(Type object) {
        if (object == null) {
            throw new RuntimeException("Object cannot be null");
        }

        if (object.getId() == null) {
            object.setId(getNextId());
        }

        return map.put(object.getId(), object);
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(Type object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        return new Long(map.size() + 1);
    }
}
