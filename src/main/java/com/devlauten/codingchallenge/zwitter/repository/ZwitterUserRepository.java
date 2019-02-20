package com.devlauten.codingchallenge.zwitter.repository;

import com.devlauten.codingchallenge.zwitter.vo.ZwitterUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Database repository for <code>ZwitterUser</code> class
 *
 * @author Felipe Lautenschlager
 */
@Repository
public interface ZwitterUserRepository extends CrudRepository<ZwitterUser, Long> {

    /**
     * Finds the Zwitter user by it's zwitter handle name
     *
     * @param handle
     * @return Optional with ZwitterUser
     */
    Optional<ZwitterUser> findByHandle(String handle);

}
