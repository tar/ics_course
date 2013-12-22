package ru.spbstu.it.service;
 
import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 

import ru.spbstu.it.dao.ITWorkDAO;
import ru.spbstu.it.domain.ITWork;

@Service
public class ITWorkServiceImpl implements ITWorkService {
	
	@Autowired
	private ITWorkDAO itworkDAO;
	
	@Transactional
	public void addITWork(ITWork itwork){
		itworkDAO.addITWork(itwork);
	}
	
	@Transactional
	public List<ITWork> listITWork(){
		return itworkDAO.listITWork();
	}
	
	@Transactional
	public void completeITWork(Integer id){
		itworkDAO.completeITWork(id);
	}
}



