package it.pkg.web.controller;

import it.pkg.web.common.Router;
import it.pkg.web.common.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * author: excalibur
 * Date: 13-4-28
 * Time: 下午1:24
 * 默认控制器
 * 包括了默认页面
 */
@Controller
public class AppController extends BaseWebAppController{

    @RequestMapping(value = Router.index,method = RequestMethod.GET)
    public String index(){
        System.out.println("********");
        System.out.println("进入主页");
        System.out.println(View.index);
        return View.index;
    }
}
