package org.excalibur.join.framework.validation;


import java.util.List;
/**
 * author: excalibur
 * Date: 13-5-4
 * Time: 上午11:06
 * To change this template use File | Settings | File Templates.
 */
public class Validity {
    private boolean valid = false;
    private List<String> errors = null;

    public Validity(boolean valid, List<String> errors) {
        this.valid = valid;
        this.errors = errors;
    }

    public Validity(boolean valid) {
        this.valid = valid;
        this.errors = null;
    }

    public void addError(String error) {
        this.errors.add(error);
        this.valid = this.errors.isEmpty();
    }

    public Object errorMsgs() {
        if (errors.size() > 1)
            return errors;
        else
            return errors.get(0);
    }

    public String errors() {
        StringBuilder errorMsgs = new StringBuilder();
        for (String err : errors) {
            errorMsgs.append(err + " ");
        }
        return errorMsgs.toString();
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
