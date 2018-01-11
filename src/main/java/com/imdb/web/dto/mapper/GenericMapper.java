package com.imdb.web.dto.mapper;

import java.text.SimpleDateFormat;
import java.util.List;

public interface GenericMapper<T,V> {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
	
	V map(T source);
	
	List<V> mapMultiple(List<T> sourceList);
	
	T mapReverse(V source);
}
