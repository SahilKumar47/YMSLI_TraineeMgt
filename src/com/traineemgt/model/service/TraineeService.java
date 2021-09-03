package com.traineemgt.model.service;

import java.util.List;

import com.traineemgt.model.dao.trainee.Trainee;

public interface TraineeService {
	public Trainee addTrainee(Trainee trainee);
	public List<Trainee> getAllTrainees();
}

