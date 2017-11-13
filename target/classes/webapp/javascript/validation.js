$(document)
		.ready(
				function() {

					$('#Name')
							.blur(
									function() {
										var name = $('#Name').val();
										var regex = /^[a-zA-Z ]{4,30}$/;
										if (!(name.match(regex))) {
											$("#Name").css("border",
													"1px solid red");
											$('#error1')
													.text(
															"Enter valid name and length should grater than 0");

										} else {
											$("#Name").css("border",
													"1px solid green");
											$('#error1').text("");

										}

									});

					$('#mail')
							.blur(
									function(e) {
										var mobileNum = $("#mail").val();
										var regx = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
										if (!mobileNum.match(regx)) {
											$("#mail").css("border",
													"1px solid red");
											$('#error2').text(
													"Invalid Mail address");
										} else {
											$("#mail").css("border",
													"1px solid green");
											$('#error2').text("");
										}
									});

					$('#pass')
							.blur(
									function(e) {
										var password = $('#pass').val();

										if (password.length < 8
												|| password.length > 16) {
											$("#pass").css("border",
													"1px solid red");
											$('#error3')
													.text(
															"password Length should be between 8 to 16 charcter")
										} else {
											$("#pass").css("border",
													"1px solid green");
											$('#error3').text("");
										}
									});

					$('#cPass').blur(function(e) {
						var confirmPassword = $('#cPass').val();
						var password = $('#pass').val();
						if (confirmPassword != password) {
							$("#cPass").css("border", "1px solid red");
							$('#error4').text("password Not matched")
						} else {
							$("#cPass").css("border", "1px solid green");
							$('#error4').text("");
						}
					});

					$('#mn')
							.blur(
									function() {
										var mobileNum = $("#mn").val();
										 var pattern = /^\d{10}$/;
										if ((isNaN(mobileNum) || (!pattern.test(mobileNum)))
												) {
											$("#mn").css("border","1px solid red");
											$('#error5').text("Enter valid Mobile Number");
										}else {
											$('#error5').text("");
											$("#mn").css("border","1px solid green");
										}
									});

				});