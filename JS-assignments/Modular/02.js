function Employee (id,aname,sal,dno) {
	this.empid=id;
	this.ename=aname ;
	this.empsalary= sal;
	this.detpno= dno;
}


var EmployeeList = (function(){
	var Employees = [];
	return{
		addemp: function(empl){
			Employees.push(empl);
		},

		getemp: function() { return Employees; },

		sort: function() {
			Employees.sort(function(a, b){return a.empid-b.empid});
				}
	}
})();


var emp1 = new Employee(21,'Hello',24000,9);
EmployeeList.addemp(emp1);
var emp2 = new Employee(23,'Myemp',212000,8);
EmployeeList.addemp(emp2);
EmployeeList.sort();
var x = EmployeeList.getemp();
console.log(x);