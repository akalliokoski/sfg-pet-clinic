package guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<Type, ID> {

    Set<Type> findAll();

    Type findById(ID id);

    Type save(Type object);

    void delete(Type object);

    void deleteById(ID id);
}
