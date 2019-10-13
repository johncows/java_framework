package com.kk.repositry;


import com.kk.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository  extends ElasticsearchRepository<User,Integer> {
     List<User> findUserByNameLike(String userName);
     List<User> findUserByNameAndId(String name,Integer id);
}
