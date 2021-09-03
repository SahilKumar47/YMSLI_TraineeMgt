package com.traineemgt.model.dao.trainee;

public class Trainee {
	private int trainee_id;
	private String trainee_name;
	private String branch;
	private double percentage;

	public Trainee() {

	}

	public Trainee(int trainee_id, String trainee_name, String branch, double percentage) {
		this.trainee_id = trainee_id;
		this.trainee_name = trainee_name;
		this.branch = branch;
		this.percentage = percentage;
	}

	public Trainee(String trainee_name, String branch, double percentage) {
		this.trainee_name = trainee_name;
		this.branch = branch;
		this.percentage = percentage;
	}


	public int getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(int trainee_id) {
		this.trainee_id = trainee_id;
	}

	public String getTrainee_name() {
		return trainee_name;
	}

	public void setTrainee_name(String trainee_name) {
		this.trainee_name = trainee_name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trainee [trainee_id=");
		builder.append(trainee_id);
		builder.append(", trainee_name=");
		builder.append(trainee_name);
		builder.append(", branch=");
		builder.append(branch);
		builder.append(", percentage=");
		builder.append(percentage);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		long temp;
		temp = Double.doubleToLongBits(percentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + trainee_id;
		result = prime * result + ((trainee_name == null) ? 0 : trainee_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainee other = (Trainee) obj;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (Double.doubleToLongBits(percentage) != Double.doubleToLongBits(other.percentage))
			return false;
		if (trainee_id != other.trainee_id)
			return false;
		if (trainee_name == null) {
			if (other.trainee_name != null)
				return false;
		} else if (!trainee_name.equals(other.trainee_name))
			return false;
		return true;
	}


}
