package com.servlet.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.servlet.model.Item;

public class ItemServiceImpl implements ItemService {

private DataSource dataSource;
	
	public ItemServiceImpl(DataSource dataSource) {
		if (Objects.isNull(dataSource)) {
			throw new IllegalArgumentException("DataSource must not be null");
		}
		this.dataSource = dataSource;
	}
	
	private Item mapResultSetToItem(ResultSet resultSet) throws Exception {

	    return new Item(
	        resultSet.getInt("ITEM_ID"),
	        resultSet.getString("ITEM_NAME"),
	        resultSet.getDouble("ITEM_PRICE"),
	        resultSet.getInt("TOTAL_NUMBER_OF_ITEMS"),
	        null
	    );
	}

	private boolean executeUpdate(PreparedStatement ps) throws Exception {
	    return ps.executeUpdate() > 0;
	}
	
    @Override
    public List<Item> allItem() {

        List<Item> result = new ArrayList<>();

        String query = "SELECT * FROM ITEM";

        try (
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        ) {

            while (resultSet.next()) {

//                Item item = new Item(
//                    resultSet.getInt("ITEM_ID"),
//                    resultSet.getString("ITEM_NAME"),
//                    resultSet.getDouble("ITEM_PRICE"),
//                    resultSet.getInt("TOTAL_NUMBER_OF_ITEMS")
//                );

                result.add(mapResultSetToItem(resultSet));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Boolean deleteItem(int id) {
        String query = "DELETE FROM ITEM WHERE ITEM_ID = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

//            int rowsAffected = ps.executeUpdate(); // بيجيب عدد الصفوف المتاثرة واللى انا عملتلها مسح

//            return rowsAffected > 0;
            return executeUpdate(ps);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean addItem(Item item) {

        String query = "INSERT INTO ITEM (ITEM_NAME, ITEM_PRICE, TOTAL_NUMBER_OF_ITEMS) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, item.getName());
            ps.setDouble(2, item.getPrice());
            ps.setInt(3, item.getTotalNumberOfItems());

//            int rowsAffected = ps.executeUpdate();
//
//            return rowsAffected > 0;
            return executeUpdate(ps);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Item getItemByID(int id) {

        String query = "SELECT * FROM ITEM WHERE ITEM_ID = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {

                return mapResultSetToItem(resultSet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

	@Override
	public Boolean updateItem(Item item) {
		
		
		String query = "UPDATE ITEM SET ITEM_NAME = ? , ITEM_PRICE = ? , TOTAL_NUMBER_OF_ITEMS = ? WHERE ITEM_ID = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, item.getName());
            ps.setDouble(2, item.getPrice());
            ps.setInt(3, item.getTotalNumberOfItems());
            ps.setInt(4, item.getId());

//            int rowsAffected = ps.executeUpdate();
//
//            return rowsAffected > 0;
            return executeUpdate(ps);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
	}

	@Override
	public List<Item> searchItem(String name) {

	    List<Item> result = new ArrayList<>();

	    String query =
	            "SELECT * " +
	            "FROM ITEM " +
	            "WHERE UPPER(ITEM_NAME) LIKE UPPER('%' || ? || '%')";

	    try (
	        Connection connection = dataSource.getConnection();
	        PreparedStatement ps =
	                connection.prepareStatement(query)
	    ) {

	        ps.setString(1, name);

	        ResultSet resultSet = ps.executeQuery();

	        while (resultSet.next()) {

	            result.add(
	                mapResultSetToItem(resultSet)
	            );
	        }

	    } catch (Exception e) {

	        e.printStackTrace();
	    }

	    return result;
	}
}