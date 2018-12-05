create database university;

create table instructors (
    instructor_id int(11) not null auto_increment,
	first_name varchar(20) not null,
    last_name varchar(20) not null,
	dob date,
    status_id int(11),
	faculty_id int(11),
    course_id int(11),
    primary key (instructor_id),
    foreign key (status_id) references statuses(status_id),
    foreign key (faculty_id) references faculties(faculty_id)
);

create table statuses (
    status_id int(11) not null auto_increment,
    title varchar(20) not null,
    primary key (status_id)
);

create table faculties (
    faculty_id int(11) not null auto_increment,
    title varchar(20) not null,
    primary key (faculty_id)
);

create table courses (
    course_id int(11) not null auto_increment,
    title varchar(20) not null,
    instructor_id int(11),
    faculty_id int(11),
    primary key (course_id),
    foreign key (faculty_id) references faculties(faculty_id),
    foreign key (instructor_id) references instructors(instructor_id)
);

create table exams (
    exam_id int(11) not null auto_increment,
    course_id int(11) not null,
    instructor_id int(11),
    date_held date not null,
    primary key (exam_id),
    foreign key (course_id) references courses(course_id),
    foreign key (instructor_id) references instructors(instructor_id)
);

create table grades (
    grade_id int(11) not null auto_increment,
    student_id int(11) not null,
    exam_id int(11),
    instructor_id int(11),
    date_assigned date,
    grade float not null,
    primary key (grade_id),
    foreign key (instructor_id) references instructors(instructor_id),
    foreign key (student_id) references students(student_id),
    foreign key (exam_id) references exams(exam_id)
);

create table students (
    student_id int(11) not null auto_increment,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    dob date not null,
    country varchar(20),
	current_year int(4),
    entry_year int(4),
	faculty_id int(11),
    course_id int(11),
    primary key (student_id),
    foreign key (faculty_id) references faculties(faculty_id),
    foreign key (course_id) references courses(course_id)
);

# TODO Populate a bit
