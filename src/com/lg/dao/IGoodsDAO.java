package com.lg.dao;

import java.util.List;

import com.lg.entity.Goods;
import com.lg.entity.Goods1;
import com.lg.entity.ShoppingInfo;

public interface IGoodsDAO {
	List<Goods1> findAllGoods();
	   Goods1 findGoodsByName(String gName);
	   Goods findGoodsStandardByName(String gName);
	List<Goods> getPriceClosedInfo(String gname);
	List<Goods> findGoodsByBrand(String brand);
	List<Goods> getSoldTopTen();
	List<Goods> findGoodsByLocation(String location);
	List<ShoppingInfo> addGoodToCart(ShoppingInfo si);
	List<ShoppingInfo> updataGoodToCart(ShoppingInfo si, int index);
	List<ShoppingInfo> deleteGoodfromCart(int index);
}
