package org.launchcode.WhatsSup.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.launchcode.WhatsSup.data.RecipeRepository;
import org.launchcode.WhatsSup.models.Recipe;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MyRecipeControllerTest {

    @InjectMocks
    MyRecipeController myRecipeController;

    @Mock
    RecipeRepository recipeRepository;

    @Test
    void findByRecipeAuthor() {
        Recipe recipe1 = new Recipe("Peanutbutter and Jelly", "Jake", 5, 10, 1, "A sandwich!", null, null, "Enjoy!");

    }

    @Test
    void findByIngredients() {
    }
}



//    @Test
//    public void onlyBracketsReturnsTrue() {
//        assertTrue(BalancedBrackets.hasBalancedBrackets("[]"));
//    }




//@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
//public class EmployeeControllerTest
//{
//    @InjectMocks
//    EmployeeController employeeController;
//
//    @Mock
//    EmployeeDAO employeeDAO;
//
//    @Test
//    public void testAddEmployee()
//    {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
//        when(employeeDAO.addEmployee(any(Employee.class))).thenReturn(true);
//
//        Employee employee = new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
//        ResponseEntity<Object> responseEntity = employeeController.addEmployee(employee);
//
//        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
//        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
//    }
