package dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T extends Serializable>{

	T findById(long id);
	List<T> findAll();
	T add(T o);
	void delete(T o);
}
