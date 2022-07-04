package com.example.blog.repository;

import com.example.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post , Long> {
    @Query(value = "select * from posts P join user_table U  on P.user_id = U.id where U.username like :name" , nativeQuery = true)
    Iterable<Post> findAllByNameUser(@Param("name") String name);
}
