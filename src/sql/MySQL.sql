



create table sql3796868.Employees (EId int, Name varchar(255), DeptId int, salary int);
create table sql3796868.Department (DeptId int, DeptName varchar(255));
select * from sql3796868.Employees;
select * from sql3796868.Department;

# Inner Join or Join (default is inner join)
select e.Name, d.DeptName from sql3796868.Employees e inner join sql3796868.Department d on e.DeptId = d.DeptId;
# Left Join
    select e.Name, d.DeptName from sql3796868.Employees e left join sql3796868.Department d on e.DeptId = d.DeptId;
# Right Join
    select e.Name, d.DeptName from sql3796868.Employees e right join sql3796868.Department d on e.DeptId = d.DeptId;
# Full Outer Join - MySQL do not natively support full outer join - work around is left join union all right join
select e.Name, d.DeptName from sql3796868.Employees e left join sql3796868.Department d on e.DeptId = d.DeptId
union all
select e.Name, d.DeptName from sql3796868.Employees e right join sql3796868.Department d on e.DeptId = d.DeptId
WHERE e.EId IS NULL;

# Group By
select e.DeptId, SUM(Salary) from Employees e group by e.DeptId

    # Having Clause
select e.DeptId, SUM(Salary) from Employees e group by e.DeptId having SUM(Salary) > 1500

    # Views - A view is a virtual table based on a SQL query.
    create view EmpDetailsWithDept as
select e.EId, e.Name, e.DeptId, d.DeptName, e.Salary from sql3796868.Employees e inner join sql3796868.Department d on e.DeptId = d.DeptId;

select * from EmpDetailsWithDept


