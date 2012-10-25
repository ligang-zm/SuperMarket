package com.lg.dao;

import java.util.List;

import com.lg.entity.Goods;
import com.lg.entity.ShoppingInfo;
import com.lg.entity.Standard;

public interface IGoodDAO {
	boolean addGood(Goods gd);
	boolean deleteGood(int gid);
	boolean updateGood(Goods gd);
	Goods findGoodById(int gid);
	Goods findGoodByName(String gname);
	Standard getStandard(String gname);
	int GetGid(String pname);
	List<Goods> getLastAppear();
	List<Goods> getRandomInfo();
	List<Goods> getSoldTopTen();
	List<Goods> getLastDateFive();
	List<Goods> getPriceClosedInfo(String gname);
	List<Goods> conditionsSearch(String net,String brand,String price,String os);
	//List<Goods> findGoodsByConditions()
	List<Goods> findGoodsByBrand(String brand);
	List<Goods> findGoodsByLocation(String location);
	List<ShoppingInfo> addGoodToCart(ShoppingInfo si);
	List<ShoppingInfo> updataGoodToCart(ShoppingInfo si,int index);
	List<ShoppingInfo> deleteGoodfromCart(int index);
	
}
