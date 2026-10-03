package com.hudihi.sms.features.course.dto;

import java.time.Instant;

import com.hudihi.sms.common.ApiConstants;

import io.swagger.v3.oas.annotations.media.Schema;

public record CourseResponse(

    @Schema (description = ApiConstants.COURSE_ID_DESCRIPTION, example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    Long courseId,

    @Schema (description = ApiConstants.COURSE_NAME_DESCRIPTION, example = "Introduction to Programming", requiredMode = Schema.RequiredMode.REQUIRED)
    String courseName,

    @Schema (description = ApiConstants.COURSE_CODE_DESCRIPTION, example = "CS101", requiredMode = Schema.RequiredMode.REQUIRED)
    String courseCode,

    @Schema (description = ApiConstants.COURSE_CONTENT_DESCRIPTION, example = "This course covers the basics of programming using Python.", requiredMode = Schema.RequiredMode.REQUIRED)
    String courseContent,

    @Schema (description = ApiConstants.COURSE_CREDITS_DESCRIPTION, example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
    int courseCredits,

    @Schema (description = ApiConstants.COURSE_DURATION_DESCRIPTION, example = "40", requiredMode = Schema.RequiredMode.REQUIRED)
    int courseDuration,

    @Schema (description = ApiConstants.COURSE_DELIVERY_MODE_DESCRIPTION, example = "Online", requiredMode = Schema.RequiredMode.REQUIRED)
    String courseDeliveryMode,

    @Schema (description = "Timestamp when the course was created.", example = "2023-10-01T12:00:00Z", requiredMode = Schema.RequiredMode.REQUIRED)
    Instant createdAt,

    @Schema (description = "Timestamp when the course was last updated.", example = "2023-10-02T15:30:00Z", requiredMode = Schema.RequiredMode.REQUIRED)
    Instant updatedAt
) {
    
}
