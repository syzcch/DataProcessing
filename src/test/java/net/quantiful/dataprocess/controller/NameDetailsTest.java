package net.quantiful.dataprocess.controller;

import com.google.gson.Gson;
import net.quantiful.dataprocess.repository.CommentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by rogersong on 21/08/17.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NameDetailsTest {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    MockMvc mockMvc;


    @Test
    public void getCustomerTest() throws Exception {
        String name = "peter wei";

        mockMvc.perform(get("/customer/details/{name}", name))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().json("{'name':'peter wei'}"))
                .andReturn();
    }

    @Test
    public void getTop5Test() throws Exception {
        int num = 10;

        String responseString = mockMvc.perform(get("/customer/posts/frequence/{num}", num))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(responseString);

        Gson gson = new Gson();

        List<String> resposeBody = gson.fromJson(responseString, List.class);
        assertEquals(resposeBody.size(), 10);
    }

    @Test
    public void getPostInfoTest() throws Exception {
        String id = "102717559809000_1444165988997477";

        mockMvc.perform(get("/customer/posts/{id}", id))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().json("{'status_id':'102717559809000_1444165988997477'}"))
                .andReturn();
    }
}
