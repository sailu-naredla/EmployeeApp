/**
 * 
 */
package com.employee.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.employee.controller.EmployeeController;
import com.employee.dto.EmployeeRequest;
import com.employee.helpers.MockData;
import com.employee.service.EmployeeService;
import com.employee.helpers.ResourceLoader;

/**
 * @author snaredl
 *
 */
@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({ EmployeeController.class })
public class EmployeeControllerTests {

	private MockMvc mockMvc;

    @Mock
    private EmployeeService employeeServiceSpy;

    @InjectMocks
    private EmployeeController employeeControllerSpy;
    
    
    @Test
    public void testGetEmployeesByProject() throws Exception {
        mockMvc.perform(get("/api/v1/employee"+MockData.PROJECT_CODE.getString()).contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk());
    }
    
    @Test
    public void testDissociateEmployeeFromProject() throws Exception {
        mockMvc.perform(post("/api/v1/employee").contentType(MediaType.APPLICATION_JSON)
                .content(ResourceLoader.asJsonString(new EmployeeRequest()))).andExpect(status().isOk());
    }

	    
}
