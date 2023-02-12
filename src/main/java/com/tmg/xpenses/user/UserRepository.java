package com.tmg.xpenses.user;

import com.tmg.xpenses.model.User;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface UserRepository extends Repository<User, Integer> {
}
