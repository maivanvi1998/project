<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.11.0/mdb.min.css"
	rel="stylesheet" />
</head>
<body>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.11.0/mdb.min.js"></script>


<c:import url="header.jsp"></c:import>
	<!--Section: Products v.3-->
	<section class="text-center mb-4">

		<!--Grid row-->
		<div class="row wow fadeIn" style="margin-top: 30px;">

			<div class="col-lg-12 col-md-12 mb-12">
				<div class="card">


					<!--Card content-->
					<div class="card-body text-center">
						<!--Category & Title-->
						<h5>${listProducts}</h5>
					</div>
				</div>
			</div>
		</div>
		<!--Grid row-->


	</section>
	<!--Section: Products v.3-->

	<!--Pagination-->
	<nav class="d-flex justify-content-center wow fadeIn">
		<ul class="pagination pg-blue">

			<!--Arrow left-->
			<li class="page-item disabled"><a class="page-link" href="#"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span
					class="sr-only">Previous</span>
			</a></li>

			<li class="page-item active"><a class="page-link" href="#">1
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">4</a></li>
			<li class="page-item"><a class="page-link" href="#">5</a></li>

			<li class="page-item"><a class="page-link" href="#"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
					class="sr-only">Next</span>
			</a></li>
		</ul>
	</nav>
	<!--Pagination-->

	</div>
	</main>
	<!--Main layout-->
<c:import url="footer.jsp"></c:import>
</body>
</html>