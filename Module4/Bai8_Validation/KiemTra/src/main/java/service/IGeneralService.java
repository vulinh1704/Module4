package service;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface IGeneralService<T> {
    Iterable<T> findAll();


    void save(T t);

    void remove(Long id);

    Optional<T> findById(Long id);

}
