package com.traineemgt.web.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.traineemgt.model.dao.trainee.Trainee;
import com.traineemgt.model.service.TraineeService;
import com.traineemgt.model.service.TraineeServiceImpl;

@WebServlet("/TraineeController.do")
public class TraineeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TraineeService traineeService = new TraineeServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if("showall".equals(action)) {
			List<Trainee> trainees = traineeService.getAllTrainees();
			request.setAttribute("trainees", trainees);
			RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
			rd.forward(request, response);
		}else if ("addtrainee".equals(action)) {
			request.getRequestDispatcher("addTrainee.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name= request.getParameter("name");
		String branch = request.getParameter("branch");
		String percentage = request.getParameter("percentage");
		
		Trainee trainee = new Trainee(name, branch, Double.parseDouble(percentage));
		traineeService.addTrainee(trainee);
		response.sendRedirect("TraineeController.do?action=showall");
	}

}
