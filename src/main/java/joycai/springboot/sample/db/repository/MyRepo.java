package joycai.springboot.sample.db.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 自定义repo的样例
 */
//@Repository
public class MyRepo {

    private final JdbcTemplate jdbcTemplate;
    private final DataSourceTransactionManager transactionManager;

    public MyRepo(JdbcTemplate jdbcTemplate, DataSourceTransactionManager transactionManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.transactionManager = transactionManager;
    }


    public void testConn() {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus trans = transactionManager.getTransaction(definition);

        String testQuery = "SELECT count(*) FROM table";
        jdbcTemplate.queryForObject(testQuery, Long.class);

        transactionManager.commit(trans);
    }
}
