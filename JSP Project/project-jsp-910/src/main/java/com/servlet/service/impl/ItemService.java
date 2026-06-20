package com.servlet.service.impl;
import java.util.List;

import com.servlet.model.Item;
public interface ItemService {
	List<Item> allItem();
	Boolean deleteItem(int id );
	Boolean addItem(Item item);
	Item getItemByID(int id);
	Boolean updateItem(Item item);
	List<Item> searchItem(String name);
}



