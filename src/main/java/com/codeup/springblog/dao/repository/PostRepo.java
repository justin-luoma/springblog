package com.codeup.springblog.dao.repository;

import com.codeup.springblog.dao.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

}
