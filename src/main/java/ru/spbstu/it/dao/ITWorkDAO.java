package ru.spbstu.it.dao;

import java.util.List;
import ru.spbstu.it.domain.ITWork;

public interface ITWorkDAO{
	
	public void addITWork(ITWork itwork);
	
	public List<ITWork> listITWork();
	
	public void completeITWork(Integer id);
	
}
