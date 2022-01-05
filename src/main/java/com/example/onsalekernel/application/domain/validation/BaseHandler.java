package com.example.onsalekernel.application.domain.validation;

public abstract class BaseHandler implements ValidationHandler{

    protected ValidationHandler next;

    @Override
    public ValidationResult handle(ValidationMessage message) {
        ValidationResult result  = validate(message);

        if (result == null && next != null) next.handle(message);

        if (result != null && !result.isSucess() && next != null) return next.handle(message);

        return ValidationResult.getSucessResult();
    }

    protected abstract ValidationResult validate(ValidationMessage message);

    @Override
    public BaseHandler withNext(ValidationHandler validation) {
        this.next = validation;
        return this;
    }

}
