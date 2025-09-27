package com.suicollect.dto.response;

import com.suicollect.data.model.Creator;
import lombok.Data;

@Data
public class GetCreatorResponse {
    private Creator creator;
    private String message;
}
