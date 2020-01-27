package com.cafeteriainventoryappexample.models.data;

import com.cafeteriainventoryappexample.models.CountSheet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public interface CountSheetDao extends CrudRepository<CountSheet, Integer> {
    @Query(value = "SELECT * FROM COUNT_SHEET a WHERE INV_DATE IN (SELECT MAX(INV_DATE) FROM COUNT_SHEET WHERE PRODUCT_ID=a.PRODUCT_ID)", nativeQuery = true)
    ArrayList<CountSheet> findAllByOrderByInvDateDesc();
}
