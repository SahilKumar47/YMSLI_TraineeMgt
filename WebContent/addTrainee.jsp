<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Trainee</title>
</head>
<body>

	<form name="addTraineeForm" method="post" action="TraineeController.do"
		onsubmit="return validateForm()">
		Enter name : <input type="text" name="name" /><label id="name"></label><br />
		Enter branch : <select name="branch">
			<option value="java" selected>Java</option>
			<option value="oracle">Oracle</option>
			<option value="php">PHP</option>
			<option value="dotnet">Dotnet</option>
		</select> <br /> Enter percentage : <input type="number" name="percentage" /><label
			id="percentage"></label><br /> <input type="submit"
			value="Add Trainee" />
	</form>
	<script>
		//form validation using javascript
		function validateForm() {
			let name = document.addTraineeForm.name.value;
			let branch = document.addTraineeForm.branch.value;
			let percentage = document.addTraineeForm.percentage.value;
			let labelName = document.getElementById("name");
			let labelPercentage = document.getElementById("percentage");

			if (name == null || name == "") {
				labelName.innerText = "Field can't be empty, Enter name";
				labelName.style.color = "red";
				return false;
			}
			if (percentage == 0) {
				labelPercentage.innerText = "Field can't be empty, Enter percentage";
				labelPercentage.style.color = "red";

				return false;
			}
			return true;
		}
	</script>
</body>
</html>