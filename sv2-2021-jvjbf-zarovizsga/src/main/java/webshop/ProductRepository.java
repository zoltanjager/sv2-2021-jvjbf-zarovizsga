package webshop;

import org.mariadb.jdbc.Statement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ProductRepository {

    private JdbcTemplate jdbcTemplate;

    public ProductRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    long insertProduct(String productName, int price, int stock) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement("INSERT INTO products (product_name, price, stock) VALUES (?, ?, ?);",
                                    Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, productName);
                    ps.setInt(2, price);
                    ps.setInt(3, stock);
                    return ps;
                }, keyHolder
        );
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public Product findProductById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM products where id = ?",
                this::mapRowToProduct,
                id);
    }

    public void updateProductStock(long id, int amount) {
        jdbcTemplate.update("UPDATE products SET stock = stock - ? WHERE id = ?", amount, id);
    }


    private Product mapRowToProduct(ResultSet row, int rowNum) throws SQLException {
        return new Product(row.getLong("id"),
                row.getString("product_name"),
                row.getInt("price"),
                row.getInt("stock"));
    }

}
