package com.glf.test.glftest.repository;

import com.glf.test.glftest.domain.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 14:56
 */
@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long>{
    //Receipt findById(Long id);

    @Query(value = "SELECT rec FROM tb_reecipt rec limit ?1 offset ?2", nativeQuery = true)
    List<Receipt> getListReceiptWithPagination(int limit, int offset);
}
