package joycai.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 自定义repo的样例
 */
@Repository
public class MyRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void testConn() {
        String testQuery = "SELECT count(*) FROM table";
        jdbcTemplate.queryForObject(testQuery, Long.class);
    }
}
