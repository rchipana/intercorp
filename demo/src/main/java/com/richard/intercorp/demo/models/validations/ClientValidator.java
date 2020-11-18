package com.richard.intercorp.demo.models.validations;

import com.richard.intercorp.demo.models.dto.ClienteDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ClientValidator  implements Validator {

    @Override
    public boolean supports(Class arg0) {
        return ClienteDto.class.equals(arg0);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
