create database university;

# TODO Set dependencies

create table instructors (instructor_id int(11), first_name varchar(20),
last_name varchar(20), dob date, status_id int(11), faculty_id int(11),
course_id int(11));

create table statuses (status_id int(11), title varchar(20));

create table faculties (faculty_id int(11), title varchar(20));

create table courses (course_id int(11), title varchar(20),
instructor_id int(11), faculty_id int(11));

create table exams (exam_id int(11), course_id int(11),
instructor_id int(11), date_held date);

create table grades (grade_id int(11), student_id int(11),
exam_id int(11), instructor_id int(11), date_assigned date, grade float);

create table students (student_id int(11), first_name varchar(20),
last_name varchar(20), dob date, country varchar(20),
current_year int(4), entry_year int(4),
faculty_id int(11), course_id int(11));

# TODO Populate a bit