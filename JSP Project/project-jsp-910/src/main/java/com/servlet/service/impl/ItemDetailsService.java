package com.servlet.service.impl;

import com.servlet.model.Item;
import com.servlet.model.ItemDetails;

public interface ItemDetailsService {
	Item getItemDetailsByItemId(int id);

	Boolean saveItemDetails(ItemDetails itemDetails);
	
	Boolean updateItemDetails(ItemDetails itemDetails);
	
}
