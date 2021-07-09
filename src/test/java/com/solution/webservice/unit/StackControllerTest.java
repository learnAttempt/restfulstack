package com.solution.webservice.unit;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.solution.webservice.controller.StackController;
import com.solution.webservice.model.StackCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(StackController.class)
public class StackControllerTest  {

  private static String PATH="/api/v1/stack";
  @Autowired
  private MockMvc mvc;

  @MockBean
  private StackController stackController;

  @Test
  public void get() throws Exception {
    StackCustom st = new StackCustom(10);
    int element = 12;
    st.push(element);
    Mockito.when(stackController.top()).thenReturn(element);
    mvc.perform(MockMvcRequestBuilders.get(PATH))
        .andExpect(status().isOk())
        //.andExpect(jsonPath("$", hasSize(5)))
        .andExpect(jsonPath("$", is(element)));
    }


  @Test
  public void push() throws Exception {
    StackCustom st = new StackCustom(10);
    int element = 5;
    st.push(element);
    Mockito.when(stackController.push(element)).thenReturn(element);
    mvc.perform(MockMvcRequestBuilders.post(PATH+"/"+element)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", notNullValue()))
        .andExpect(jsonPath("$", is(element)));
  }

  @Test
  public void pop() throws Exception {
    StackCustom st = new StackCustom(10);
    int element = 5;
    st.push(element);
    Mockito.when(stackController.pop()).thenReturn(element);
    mvc.perform(MockMvcRequestBuilders.post(PATH)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", notNullValue()))
        .andExpect(jsonPath("$", is(element)));
  }
}
