package com.samuel.repository;

import java.util.List;

public interface DbServiceInt<T> {
	void save(T p);
	void delete(int id);
	void update(T p);
	List<T> getAll();
}