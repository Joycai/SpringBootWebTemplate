package joycai.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 自定义repo的样例
 */
@Repository
public class MyRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MyRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void testConn() {
        String testQuery = "SELECT count(*) FROM table";
        jdbcTemplate.queryForObject(testQuery, Long.class);
    }
}
