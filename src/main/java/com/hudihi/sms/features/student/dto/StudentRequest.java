package com.hudihi.sms.features.student.dto;

import com.hudihi.sms.common.ApiConstants;

import io.swagger.v3.oas.annotations.media.Schema;

public record StudentRequest(

    @Schema (description = ApiConstants.FIRST_STUDENT_NAME_DESCRIPTION, example = "John", requiredMode = Schema.RequiredMode.REQUIRED)
    String firstName,

    @Schema(description = ApiConstants.LAST_STUDENT_NAME_DESCRIPTION, example = "Issa", requiredMode = Schema.RequiredMode.REQUIRED)
    String lastName,

    @Schema(description = ApiConstants.STUDENT_AGE_DESCRIPTION, example = "20", requiredMode = Schema.RequiredMode.REQUIRED)
    int studentAge,

    @Schema (description = ApiConstants.STUDENT_EMAIL_DESCRIPTION, example = "issa@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
    String studentEmail
) {
}

