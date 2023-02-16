package tech.codingclub.helix.controller;

import org.apache.log4j.Logger;
import org.jooq.Condition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import tech.codingclub.helix.database.GenericDB;
import tech.codingclub.helix.entity.LoginResponse;
import tech.codingclub.helix.entity.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * User: rishabh
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public String userLogin(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "userlogin";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin")
    public String adminLogin(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "adminlogin";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public String welcome(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "welcomelogin";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/welcome")
    public
    @ResponseBody
    LoginResponse handlelogin(@RequestBody Member member, HttpServletRequest request, HttpServletResponse response)
    {

        Condition condition = tech.codingclub.helix.tables.Member.MEMBER.EMAIL.eq(member.email).and(tech.codingclub.helix.tables.Member.MEMBER.PASSWORD.eq(member.password));

        List<Member> x = (List<Member>) GenericDB.getRows(tech.codingclub.helix.tables.Member.MEMBER,Member.class, condition ,1 );

        if(x!=null && x.size()>0)
        {
            // user exists condition is not null and email and password is correct
            Member memberTemp = x.get(0);
            memberTemp.role="cm";
            ControllerUtils.setUserSession(request,memberTemp);
            return new LoginResponse(memberTemp.id,true,"Logined succesfully !");
        }
        else
        {
            // user does not exists or wrong combinations
            return new LoginResponse(null,false,"Wrong Credentials !");
        }


    }




}