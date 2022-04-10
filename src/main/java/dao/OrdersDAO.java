package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;

public class OrdersDAO {
	public void insertOrder(Orders o, Cart c) throws Exception {
		List<Product> items;
		LocalDate currentdate = LocalDate.now();
		try {
			Connection conn = new DBContext().getConnection();
			String sqla = " insert into ShoppingDB.dbo.Orders (user_mail, order_status, order_date, order_discount_code, order_address)"
					+ "values ('" + o.getUserMail() + "'," + o.getStatus() + ",'" + currentdate + "','"
					+ o.getDiscount() + "','" + o.getAddress() + "') ";

			String sqlb = "";
			double total = c.getAmount();
			items = c.getItems();
			int size = items.size();
			 for(int j = 0; j < size; j++){
	                Product i = items.get(j);
	                if(j==0){
	                    sqlb +=" insert into ShoppingDB.dbo.Orders_detail (order_id, product_id, amount_product, price_product, number_product)"
	                        + "values (scope_identity(),"+i.getId()+","+total+","+i.getPrice()+ "," + i.getNumber() + ") ";
	                } else {
	                    sqlb += ",(scope_identity(),"+i.getId()+","+total+","+i.getPrice()+ "," + i.getNumber() + ")";
	                }
	            }
			String sqlc = sqla + sqlb;
			PreparedStatement ps = conn.prepareStatement(sqlc);
			ps.execute();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
