package net.quantiful.dataprocess.controller;

import net.quantiful.dataprocess.model.*;
import net.quantiful.dataprocess.repository.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rogersong on 20/08/17.
 */

@RestController
@RequestMapping(value = "/customer")
public class NameDetails {

    @Autowired
    CommentMapper commentMapper;

    /*
     * Http get
     * get customer's details by customer's name
     */
    @RequestMapping(value = "/details/{name}", method = RequestMethod.GET)
    CustomerRes getCustomer(@PathVariable("name") String name) {
        int male = 0;
        int female = 0;
        int likes = 0;

        CustomerRes customerRes = new CustomerRes();
        List<Customer> dataRes = commentMapper.getCustomers(name);

        customerRes.setName(name);
        customerRes.setCommentNum(dataRes.size());
        for(int i = 0; i < dataRes.size(); i++){
            if(dataRes.get(i).getGender().toLowerCase().equals("male")){
                male++;
            } else if (dataRes.get(i).getGender().toLowerCase().equals("female")){
                female++;
            }

            likes += dataRes.get(i).getLikes();
        }
        customerRes.setFemale(female);
        customerRes.setMale(male);
        customerRes.setLikes(likes);

        return customerRes;
    }

    /*
     * get top hot topics
     *  Http Get request
     */
    @RequestMapping(value = "/posts/frequence/{num}", method = RequestMethod.GET)
    List<String> getTop5(@PathVariable("num") int num) {

        CustomerRes customerRes = new CustomerRes();
        List<String> res = commentMapper.getTopN(num);

        return res;
    }

    /*
     * Get post details by post id
     * Http Get request
     */
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    PostRes getPostInfo(@PathVariable("id") String id) {
        int male = 0;
        int female = 0;
        int unknow = 0;
        int likes = 0;
        int dislikes = 0;

        PostRes postRes = new PostRes();
        List<PostInfo> postInfo = commentMapper.getPostInfo(id);

        postRes.setStatus_id(id);
        postRes.setNum_comments(postInfo.size());

        if(postInfo.size() > 0){
            likes += postInfo.get(0).getNum_loves();
            likes += postInfo.get(0).getNum_likes();
            dislikes += postInfo.get(0).getNum_sads();
            dislikes += postInfo.get(0).getNum_angrys();

            for(int i = 0; i < postInfo.size(); i++){
                if(postInfo.get(i).getGender().toLowerCase().equals("male")){
                    male++;
                } else if (postInfo.get(i).getGender().toLowerCase().equals("female")){
                    female++;
                } else {
                    unknow++;
                }
            }

            postRes.setNum_dislikes(dislikes);
            postRes.setNum_likes(likes);
            postRes.setNum_female(female);
            postRes.setNum_male(male);
            postRes.setNum_unknown(unknow);
        }

        return postRes;
    }

    /*
     * Http Post request
     * add new comments here
     */
    @RequestMapping(value = "/addname", method = RequestMethod.POST)
    ResponseEntity<?> addUserInfo(@RequestBody CommentObj input) {
        int male = 0;
        int female = 0;
        int likes = 0;

        CommentObj commentObj = new CommentObj();
        commentObj.setCommentId(input.getCommentId());
        commentObj.setGender(input.getGender());
        commentObj.setCommentAuthor(input.getCommentAuthor());
        commentObj.setCommentLikes(input.getCommentLikes());

        int res = commentMapper.insert(commentObj);
        if(res == 1){
            return new ResponseEntity("success", HttpStatus.OK);
        }

        return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
    }
}
