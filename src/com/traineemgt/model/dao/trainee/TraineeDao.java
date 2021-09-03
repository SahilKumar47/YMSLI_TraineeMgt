package com.traineemgt.model.dao.trainee;

import java.util.List;


public interface TraineeDao {
	public List<Trainee> getAllTrainees();
	public Trainee addTrainee(Trainee trainee);
}
