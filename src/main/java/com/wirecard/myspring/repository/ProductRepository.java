package com.wirecard.myspring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wirecard.myspring.domain.Product;

@Repository
public class ProductRepository {

	private JdbcTemplate jdbcTemplate;
	
	public ProductRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Product> listAll(){
		String sql = "SELECT * FROM item";
		List<Product> listProduct = jdbcTemplate.query(sql, new ProducMapper());
		return listProduct;
	}
	
	public Product findByCode(String code){
		String sql = "SELECT * FROM item WHERE item_code = ?";
		Product product = jdbcTemplate.queryForObject(sql, new Object[] {code}, new ProducMapper());
		
		return product;
	}
	
	public int addProduct(Product p) {
		String sql = "INSERT INTO item VALUES(?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {p.getItemCode(), p.getPrice(), p.getDescription(), p.getType(), p.getTax()});
	}
	
	public int updateProduct(Product p) {
		String sql = "UPDATE item SET price=?, description=?, type=?, taxable=? WHERE item_code=?";
		return jdbcTemplate.update(sql, new Object[] {p.getPrice(), p.getDescription(), p.getType(), p.getTax(), p.getItemCode()});
	}
	
	private class ProducMapper implements RowMapper<Product>{

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Product product = new Product();
			product.setItemCode(rs.getString("item_code"));
			product.setDescription(rs.getString("description"));
			product.setPrice(rs.getInt("price"));
			product.setType(rs.getString("type"));
			product.setTax(rs.getInt("taxable"));
			return product;
		}
		
	}
}
