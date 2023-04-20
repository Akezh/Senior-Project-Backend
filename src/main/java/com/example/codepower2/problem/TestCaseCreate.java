package com.example.codepower2.problem;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class TestCaseCreate implements Serializable {
    private String input;
    private String output;
}
