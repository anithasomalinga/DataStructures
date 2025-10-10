/*Student
SId     Name
1       Anitha
2       Joe

StudentCourse
SId     CId
1       1
1       2
1       3
2       3

Course - cId(pk)
    cId     CName          TId
    1       chemistry        100
    2       math               200
    3       physics            100

Teacher
TId     Name
100     sTeacher
200     mTeacher*/
create table Student (student_id int primary key,
                      first_name varchar(50),
                      last_name varchar(100),
                      email varchar(100) unique);

create table Teacher (teacher_id int primary key,
                      first_name varchar(50),
                      last_name varchar(100),
                      email varchar(100) unique);

create table Course (course_id int primary key,
                    course_name varchar(255),
                    teacher_id int,
                    foreign key (teacher_id) references Teacher);

create table Student_Course (student_id int,
                             course_id int,
                             primary key (student_id, course_id),
                             foreign key (student_id) references Student,
                             foreign key (course_id) references Course);

insert into Student (student_id, first_name, last_name, email) values (1, 'Anitha', 'Somalinga', 'anis@gmail.com');
select * from Student;

insert into Teacher (teacher_id, first_name, last_name, email) values (101, 'Gill', 'K', 'kgill@gmail.com');
insert into Teacher (teacher_id, first_name, last_name, email) values (102, 'Marnie', 'Hunter', 'mhunter@gmail.com');
insert into Teacher (teacher_id, first_name, last_name, email) values (103, 'Guru', 'Ji', 'guruji@gmail.com');
select * from Teacher;

insert into Course (course_id, course_name, teacher_id) values (201, 'Science', 101);
insert into Course (course_id, course_name, teacher_id) values (202, 'Social', 101);
insert into Course (course_id, course_name, teacher_id) values (203, 'English', 102);
insert into Course (course_id, course_name, teacher_id) values (204, 'Gita', 103);
select * from Course;

insert into Student_Course (student_id, course_id) values (3, 201);
insert into Student_Course (student_id, course_id) values (3, 202);
insert into Student_Course (student_id, course_id) values (3, 203);
select * from Student_Course;

-- select students by teacher id -101

select c.teacher_id, c.course_name, s.student_id, s.first_name, s.last_name from Course c
     join Student_Course sc on c.course_id = sc.course_id
     join Student s on s.student_id = sc.student_id
        where c.teacher_id=101;

