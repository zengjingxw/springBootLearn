package cn.smile.core.dao;

import cn.smile.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/11
 */

public interface UserRepository extends JpaRepository<User,Integer> {
}
