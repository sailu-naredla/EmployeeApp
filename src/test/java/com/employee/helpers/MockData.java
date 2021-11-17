/**
 * 
 */
package com.employee.helpers;

/**
 * @author snaredl
 *
 */
public enum MockData {

	SUCCESS("Success"),

    FAILURE("Failure"),
    
    UTF_8("UTF-8"),

    PROJECT_CODE("P1001"),

    EMPLOYEE_CODE("E10001");

    private String data;

    private MockData(String data) {
        this.data = data;
    }

    public String getString() {
        return data;
    }

}
