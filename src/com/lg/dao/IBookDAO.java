package com.lg.dao;

import java.util.List;

import com.lg.entity.Book;

public interface IBookDAO {
	List<Book>  findAllBookInfo(int acid);
	List<Book>  findAllGoodsInfo(int acid);
	boolean addbook(Book book);
	boolean addSubBook(Book sub);
	int getLastBookId(String guest);
}
