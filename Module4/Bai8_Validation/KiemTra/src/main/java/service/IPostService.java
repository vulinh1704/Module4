package service;

import model.Post;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;


@Service
public interface IPostService extends IGeneralService<Post> {
//    Page<Post> findAllByTitle(String title , Pageable pageable);
      Page<Post> findByTitle1(String title, Pageable pageable);
      Page<Post> findAll(Pageable pageable);
      public HashMap<Integer , List<Post>> findByT(String title);
}
