package id.liostech.springpus.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidationUtil {
    @Autowired
    Validator validator;

    public void validate(Object any){
        Set<ConstraintViolation<Object>> result = validator.validate(any);
        if(result.size() != 0){
            throw new ConstraintViolationException(result);
        }
    }
}
