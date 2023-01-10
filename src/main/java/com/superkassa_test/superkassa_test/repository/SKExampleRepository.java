package com.superkassa_test.superkassa_test.repository;

import com.superkassa_test.superkassa_test.entity.SkExampleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SKExampleRepository extends JpaRepository<SkExampleTable, Long> {

    @Query(value = """
    UPDATE sk_example_table 
    SET obj = obj || jsonb_build_object('current', (obj ->> 'current') \\:\\: numeric + :add) RETURNING obj->>'current'
    """, nativeQuery = true)
    int incrementCurrent(int add);

}
