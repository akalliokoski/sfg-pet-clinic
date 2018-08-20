package guru.springframework.sfgpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<Type, ID> {

    protected Map<ID, Type> map = new HashMap<>();

    Set<Type> findAll() {
        return new HashSet<>(map.values());
    }

    Type findById(ID id) {
        return map.get(id);
    }

    Type save(ID id, Type object) {
        return map.put(id, object);
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(Type object) {
        map.entrySet().removeIf(
                entry -> entry.getValue().equals(object));
    }
}
