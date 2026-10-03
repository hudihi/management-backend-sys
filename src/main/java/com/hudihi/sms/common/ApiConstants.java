package com.hudihi.sms.common;


public class ApiConstants {

    /** Base URL prefix for all REST resources in this application. */
    public static final String API_BASE_PATH = "/api/v1/";

    // Generic Response
    /** HTTP status code for successful requests. */
    public static final String SUCCESS_200 = "200";
    /** HTTP status code for created resources. */
    public static final String CREATED_201 = "201";
    /** HTTP status code for invalid client requests. */
    public static final String BAD_REQUEST_400 = "400";
    /** HTTP status code for successful requests with no response body. */
    public static final String NO_CONTENT_204 = "204";
    /** HTTP status code when a resource cannot be found. */
    public static final String NOT_FOUND_404 = "404";

    /** Response description for successful retrieval of an existing resource. */
    public static final String FOUND_DESCRIPTION = "Resource found.";
    /** Response description for successful creation. */
    public static final String CREATED_DESCRIPTION = "Resource created successfully.";
    /** Response description for successful update. */
    public static final String UPDATED_DESCRIPTION = "Resource updated successfully.";
    /** Response description for successful deletion. */
    public static final String DELETED_DESCRIPTION = "Resource deleted successfully.";
    /** Response description when the requested resource does not exist. */
    public static final String NOT_FOUND_DESCRIPTION = "Resource not found.";
    /** Response description when the request payload or parameters are invalid. */
    public static final String BAD_REQUEST_DESCRIPTION = "Bad request. Please check the request parameters.";

    // Course DTO Description
    /** Unique identifier of the course record. */
    public static final String COURSE_ID_DESCRIPTION = "Unique identifier of the course.";
    /** Human-readable name of the course. */
    public static final String COURSE_NAME_DESCRIPTION = "Name of the course.";
    /** Official course code used to identify the subject. */
    public static final String COURSE_CODE_DESCRIPTION = "Unique code of the course.";
    /** Course description or educational content summary. */
    public static final String COURSE_CONTENT_DESCRIPTION = "Content of the course.";
    /** Duration of the course in hours. */
    public static final String COURSE_DURATION_DESCRIPTION = "Duration of the course in hours.";
    /** Number of academic credits awarded for the course. */
    public static final String COURSE_CREDITS_DESCRIPTION = "Number of credits for the course.";
    /** Delivery method used for the course, such as online or in-person. */
    public static final String COURSE_DELIVERY_MODE_DESCRIPTION = "Mode of delivery for the course (e.g., online, in-person).";

    // Student DTO Description
    /** First name of the student. */
    public static final String FIRST_STUDENT_NAME_DESCRIPTION = "First Name of the student.";
    /** Last name or family name of the student. */
    public static final String LAST_STUDENT_NAME_DESCRIPTION = "Last Name of the student.";
    /** Age of the student in years. */
    public static final String STUDENT_AGE_DESCRIPTION = "Age of the student.";
    /** Email address used to contact the student. */
    public static final String STUDENT_EMAIL_DESCRIPTION = "Email of the student.";

    // Controller Description
    /** API controller responsible for course management endpoints. */
    public static final String COURSE_CONTROLLER_DESCRIPTION = "Controller for managing courses.";
    /** API controller responsible for student management endpoints. */
    public static final String STUDENT_CONTROLLER_DESCRIPTION = "Controller for managing students.";

    // Course API Description
    /** Retrieves all available courses in the system. */
    public static final String GET_ALL_COURSES_DESCRIPTION = "Retrieve a list of all courses.";
    /** Retrieves a single course using its unique identifier. */
    public static final String GET_COURSE_BY_ID_DESCRIPTION = "Retrieve a course by its unique identifier.";
    /** Creates a new course record. */
    public static final String CREATE_COURSE_DESCRIPTION = "Create a new course.";
    /** Updates the details of an existing course. */
    public static final String UPDATE_COURSE_DESCRIPTION = "Update an existing course.";
    /** Deletes a course by its identifier. */
    public static final String DELETE_COURSE_DESCRIPTION = "Delete a course by its unique identifier.";

    // Student API Description
    /** Retrieves all registered students. */
    public static final String GET_ALL_STUDENTS_DESCRIPTION = "Retrieve a list of all students.";
    /** Retrieves one student using their unique identifier. */
    public static final String GET_STUDENT_BY_ID_DESCRIPTION = "Retrieve a student by their unique identifier.";
    /** Registers a new student in the system. */
    public static final String CREATE_STUDENT_DESCRIPTION = "Create a new student.";
    /** Updates the information of an existing student. */
    public static final String UPDATE_STUDENT_DESCRIPTION = "Update an existing student.";
    /** Removes a student from the system by ID. */
    public static final String DELETE_STUDENT_DESCRIPTION = "Delete a student by their unique identifier.";
    /** Associates a course with the student. */
    public static final String ADD_COURSE_TO_STUDENT_DESCRIPTION = "Add a course to a student's list of courses.";
    /** Enrolls a student in a course offering. */
    public static final String ENROLL_STUDENT_IN_COURSE_DESCRIPTION = "Enroll a student in a course.";
    /** Removes a course from the student's enrolled course list. */
    public static final String REMOVE_COURSE_FROM_STUDENT_DESCRIPTION = "Remove a course from a student's list of courses.";
    /** Replaces the full set of courses linked to a student. */
    public static final String UPDATE_STUDENT_COURSES_DESCRIPTION = "Update the courses a student is enrolled in.";

    // Path variables named as SEARCH
    /** Identifier used to locate a specific resource in a search or lookup operation. */
    public static final String SEARCH_ID_DESCRIPTION = "Unique identifier for searching the resource.";
    /** Request payload used to supply search criteria for a resource query. */
    public static final String SEARCH_REQUEST_DESCRIPTION = "Request body containing the data for searching the resource.";

    public static final String STUDENT_FIRST_NAME_DESCRIPTION = null;
}
