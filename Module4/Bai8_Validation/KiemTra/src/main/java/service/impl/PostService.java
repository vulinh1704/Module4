package service.impl;

import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.PostRepository;
import service.IPostService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class PostService implements IPostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

//    @Override
//    public Page<Post> findAllByTitle(String title , Pageable pageable) {
//        return postRepository.findAllByTitle(title , pageable);
//    }


    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Page<Post> findByTitle1(String title, Pageable pageable) {
        return postRepository.findByTitle1(title, pageable);
    }

    public HashMap<Integer , List<Post>> findByT(String title){
        List<Post> posts = postRepository.findByT(title);
        HashMap<Integer , List<Post>> postHashMap = new HashMap<>();
        for (int i = 0; i <= posts.size(); i = i + 2) {
            postHashMap.put(i+1 , find2Post(title , i));
        }
        return postHashMap;
    }

    public List<Post> find2Post(String title ,int index){
        List<Post> posts = postRepository.findByT(title);
        List<Post> postsPage = new ArrayList<>();
        for (int i = index ; i < index + 2 && index + 2 < posts.size(); i++) {
            postsPage.add(posts.get(i));
        }
        return postsPage;
    }
}
