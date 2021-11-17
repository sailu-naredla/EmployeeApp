/**
 * 
 */
package com.employee.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import com.employee.dto.EmployeeRequest;
import com.employee.dto.EmployeeResponse;
import com.employee.helpers.ResourceLoader;
import com.employee.service.impl.EmployeeServiceImpl;

/**
 * @author snaredl
 *
 */
@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({ EmployeeServiceImpl.class })
public class EmployeeServiceImplTest {
	
	@InjectMocks
    private EmployeeServiceImpl employeeServiceSpy;

    private static final String EMPLOYEE_REQUEST_FILE = "responses/UserAuthResponse.json";
    
    private static final String EMPLOYEE_RESPONSE_FILE = "responses/UserAuthResponse.json";
	 
	
	@Test
    public void testGetEmployeesByProject() throws Exception {
     
	 EmployeeResponse responses = ResourceLoader.readAndGetObject(EMPLOYEE_RESPONSE_FILE,
			 EmployeeResponse.class);
       
        assertNotNull("response of getEmployeesByProject should not be null", responses);
        assertEquals("response of getEmployeesByProject should be equal", responses);
       
    }
	
	@Test
    public void testDissociateEmployeeFromProject() throws Exception {
     
    EmployeeRequest request = ResourceLoader.readAndGetObject(EMPLOYEE_REQUEST_FILE,
    		EmployeeRequest.class);
	 EmployeeResponse response = ResourceLoader.readAndGetObject(EMPLOYEE_RESPONSE_FILE,
			 EmployeeResponse.class);
	 
	 assertNotNull("request of getEmployeesByProject should not be null", request);
     assertEquals("request of getEmployeesByProject should be equal", request);
       
        assertNotNull("response of getEmployeesByProject should not be null", response);
        assertEquals("response of getEmployeesByProject should be equal", response);
       
        		
    }

}
