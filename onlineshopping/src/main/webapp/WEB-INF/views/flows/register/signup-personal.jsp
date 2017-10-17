<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>

<div class="container">
	<div class="row">

		<div class="col-md-6 col-md-offset-3">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Sign Up - Personal</h4>
				</div>

				<div class="panel-body">

					<sf:form method="POST" class="form-horizontal" id="registerForm"
						modelAttribute="user">


						<div class="form-group">
							<label class="control-label col-md-4">First Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="firstName" class="form-control"
									placeholder="First Name" onkeyup="lettersOnly(this)" />
								<sf:errors path="firstName" cssClass="help-block" element="em" />
							</div>
						</div>
						<script>
							function lettersOnly(input) {
								var regex = /[^a-z]/gi;
								input.value = input.value.replace(regex, "");
							}
						</script>

						<div class="form-group">
							<label class="control-label col-md-4">Last Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="lastName" class="form-control"
									placeholder="Last Name" onkeyup="lettersOnly(this)" />
								<sf:errors path="lastName" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Email</label>
							<div class="col-md-8">
								<sf:input type="text" path="email" class="form-control"
									placeholder="abc@zyx.com" />
								<sf:errors path="email" cssClass="help-block" element="em" />
							</div>
						</div>

						<script>
							function numbersOnly(input) {
								var regex = /[^0-9]/gi;
								input.value = input.value.replace(regex, "");
							}
						</script>

						<div class="form-group">
							<label class="control-label col-md-4">Contact Number</label>
							<div class="col-md-8">
								<sf:input type="text" path="contactNumber" class="form-control"
									placeholder="XXXXXXXXXX" maxlength="10"
									onkeyup="numbersOnly(this)" />
								<sf:errors path="contactNumber" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="password" class="form-control"
									placeholder="Password" maxlength="8" />
								<font color="green">Password must be atleast 8 characters
									long!</font>
								<sf:errors path="password" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Confirm Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="confirmPassword"
									class="form-control" placeholder="Re-enter Password"
									maxlength="8" />
								<sf:errors path="confirmPassword" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<!-- radio button using bootstrap class of radio-inline -->
						<div class="form-group">
							<label class="control-label col-md-4">Select Role</label>
							<div class="col-md-8">
								<label class="radio-inline"> <sf:radiobutton path="role"
										value="USER" checked="checked" /> User
								</label> <label class="radio-inline"> <sf:radiobutton
										path="role" value="SUPPLIER" /> Supplier
								</label>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<!-- submit button inside the form -->
								<button type="submit" class="btn btn-primary"
									name="_eventId_billing">
									Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
								</button>
							</div>
						</div>

					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="../shared/flows-footer.jsp"%>