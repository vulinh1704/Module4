package repository;

import model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
//    Page<Post> findAllByTitle(String title , Pageable pageable);

//    @Query(value = "select * from Post order by likes" , nativeQuery = true)
//    Iterable<Post> findAllByLikes();
//
//    @Query(value = "select * from Post order by id desc limit 4" , nativeQuery = true)
//    Iterable<Post> findTop4();
//
    @Query(value = "select * from posts where title like :title" , nativeQuery = true)
    Page<Post> findByTitle1(@Param("title") String title , Pageable pageable);

    @Query(value = "select * from posts  where title like :title" , nativeQuery = true)
    List<Post> findByT(@Param("title") String title);
}
