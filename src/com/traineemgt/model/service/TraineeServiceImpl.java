package com.traineemgt.model.service;

import java.util.List;

import com.traineemgt.model.dao.trainee.Trainee;
import com.traineemgt.model.dao.trainee.TraineeDao;
import com.traineemgt.model.dao.trainee.TraineeDaoImpl;

public class TraineeServiceImpl implements TraineeService{

	private TraineeDao traineeDao;
	
	public TraineeServiceImpl() {
		traineeDao = new TraineeDaoImpl();
	}
	@Override
	public Trainee addTrainee(Trainee trainee) {
		return traineeDao.addTrainee(trainee);
	}
	@Override
	public List<Trainee> getAllTrainees() {
		return traineeDao.getAllTrainees();
	}

}
