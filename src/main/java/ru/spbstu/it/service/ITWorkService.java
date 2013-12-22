package ru.spbstu.it.service;

import java.util.List;
import ru.spbstu.it.domain.ITWork;

public interface ITWorkService {
	
	public void addITWork(ITWork itwork);
	
	public List<ITWork> listITWork();
	
	public void completeITWork(Integer id);
	
}

