package com.servlet.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

import javax.sql.DataSource;

import com.servlet.model.Item;
import com.servlet.model.ItemDetails;

public class ItemDetailsServiceImpl implements ItemDetailsService {
	
private DataSource dataSource;
	
	public ItemDetailsServiceImpl(DataSource dataSource) {
		if (Objects.isNull(dataSource)) {
			throw new IllegalArgumentException("DataSource must not be null");
		}
		this.dataSource = dataSource;
	}
	

	private ItemDetails mapResultSetToItemDetails(ResultSet resultSet) throws Exception {

	    return new ItemDetails(
	        resultSet.getInt("DETAIL_ID"), resultSet.getInt("ITEM_ID"),resultSet.getString("DESCRIPTION") , resultSet.getString("CATEGORY"), resultSet.getString("BRAND"),
	        resultSet.getString("COLOR"),resultSet.getDouble("WEIGHT"), resultSet.getString("IMAGE_PATH"), resultSet.getDate("MANUFACTURE_DATE"), 
	        resultSet.getDate("EXPIRY_DATE"), resultSet.getString("STATUS")
	    );
	}
	
	
	private Item mapResultSetToItem(ResultSet resultSet) throws Exception {

	    return new Item(
	        resultSet.getInt("ITEM_ID"),
	        resultSet.getString("ITEM_NAME"),
	        resultSet.getDouble("ITEM_PRICE"),
	        resultSet.getInt("TOTAL_NUMBER_OF_ITEMS"),
	        mapResultSetToItemDetails(resultSet)
	    );
	}
	
	
	@Override
	public Item getItemDetailsByItemId(int id) {
		String query =
		        "SELECT * " +
		                "FROM ITEM i " +
		                "LEFT JOIN ITEM_DETAILS d " +
		                "ON i.ITEM_ID = d.ITEM_ID " +
		                "WHERE i.ITEM_ID = ?";

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
	public Boolean saveItemDetails(ItemDetails itemDetails) {

	    String query =
	            "INSERT INTO ITEM_DETAILS ("
	            + "ITEM_ID, "
	            + "DESCRIPTION, "
	            + "CATEGORY, "
	            + "BRAND, "
	            + "COLOR, "
	            + "WEIGHT, "
	            + "IMAGE_PATH, "
	            + "MANUFACTURE_DATE, "
	            + "EXPIRY_DATE, "
	            + "STATUS"
	            + ") "
	            + "VALUES (?,?,?,?,?,?,?,?,?,?)";

	    try (
	            Connection connection = dataSource.getConnection();
	            PreparedStatement ps = connection.prepareStatement(query)
	    ) {

	        ps.setInt(1, itemDetails.getItemId());
	        ps.setString(2, itemDetails.getDescription());
	        ps.setString(3, itemDetails.getCategory());
	        ps.setString(4, itemDetails.getBrand());
	        ps.setString(5, itemDetails.getColor());
	        ps.setDouble(6, itemDetails.getWeight());
	        ps.setString(7, itemDetails.getImagePath());

	        ps.setDate(
	        	    8,
	        	    new java.sql.Date(itemDetails.getManufactureDate().getTime())
	        	);

	        	ps.setDate(
	        	    9,
	        	    new java.sql.Date(itemDetails.getExpiryDate().getTime())
	        	);
	        ps.setString(10, itemDetails.getStatus());

	        return executeUpdate(ps);

	    } catch (Exception e) {

	        e.printStackTrace();

	    }

	    return false;
	}

	private boolean executeUpdate(PreparedStatement ps) throws Exception {

	    return ps.executeUpdate() > 0;

	}


	@Override
	public Boolean updateItemDetails(ItemDetails itemDetails) {
		String query =
		        "UPDATE ITEM_DETAILS SET "
		      + "DESCRIPTION = ?, "
		      + "CATEGORY = ?, "
		      + "BRAND = ?, "
		      + "COLOR = ?, "
		      + "WEIGHT = ?, "
		      + "IMAGE_PATH = ?, "
		      + "MANUFACTURE_DATE = ?, "
		      + "EXPIRY_DATE = ?, "
		      + "STATUS = ? "
		      + "WHERE ITEM_ID = ?";

		try (
		        Connection connection = dataSource.getConnection();
		        PreparedStatement ps = connection.prepareStatement(query)
		) {

		    ps.setString(1, itemDetails.getDescription());
		    ps.setString(2, itemDetails.getCategory());
		    ps.setString(3, itemDetails.getBrand());
		    ps.setString(4, itemDetails.getColor());
		    ps.setDouble(5, itemDetails.getWeight());
		    ps.setString(6, itemDetails.getImagePath());

		    ps.setDate(7,
		        new java.sql.Date(itemDetails.getManufactureDate().getTime())
		    );

		    ps.setDate(8,
		        new java.sql.Date(itemDetails.getExpiryDate().getTime())
		    );

		    ps.setString(9, itemDetails.getStatus());

		    // WHERE ITEM_ID
		    ps.setInt(10, itemDetails.getItemId());

		    return executeUpdate(ps);

		} catch (Exception e) {
		    e.printStackTrace();
		}

		return false;
	}

}
