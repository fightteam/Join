#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.controller;

import ${package}.common.Key;
import ${package}.common.Message;
import ${package}.common.Props;
import ${package}.framework.web.controller.BaseController;
import ${package}.web.common.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;


/**
 * author: excalibur
 * Date: 13-4-28
 * Time: 下午2:11
 * 基础控制类 细化
 * 定义了 一些通用相关操作 与异常操作
 */
public class BaseWebAppController extends BaseController {
    private Logger log = LoggerFactory.getLogger(BaseWebAppController.class);
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected Message message;

    /**
     * 系统错误处理 所有错误都集中在这处理
     * @param ex
     * @param locale
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception ex, Locale locale) {
        ModelAndView mav = new ModelAndView(View.error);
        StringBuilder stack = new StringBuilder();
        System.out.println("==================");
        log.error("[baseWebAppExceptionHandler] Response: " + ex.getMessage());
        mav.addObject("exception", ex.getMessage());
        for(StackTraceElement element : ex.getStackTrace()) {
            stack.append(element.toString());
            stack.append("${symbol_escape}n");
        }

        mav.addObject("stack", stack.toString());
        return mav;
    }

    // Helper methods
    public void setup(Model model) {
        model.addAttribute("error", false);
        model.addAttribute("success", false);
        model.addAttribute("alert", false);
        model.addAttribute("info", false);
        model.addAttribute("loggedIn", false);
    }

    public void addError(String message, Model model) {
        model.addAttribute("error", true);
        model.addAttribute("errorMessage", message);
    }

    public void addSuccess(String message, Model model) {
        model.addAttribute("success", true);
        model.addAttribute("successMessage", message);
    }

    public void addAlert(String message, Model model) {
        model.addAttribute("alert", true);
        model.addAttribute("alertMessage", message);
    }

    public void addInfo(String message, Model model) {
        model.addAttribute("info", true);
        model.addAttribute("infoMessage", message);
    }
    public void addInfoWithAction(String infoWithActionHeading, String infoWithActionContent,
                                  String infoWithActionPrimaryAction, String infoWithActionPrimaryActionLink,
                                  String infoWithActionSecAction, String infoWithActionSecActionLink,
                                  Model model) {
        model.addAttribute("infoWithAction", true);
        model.addAttribute("infoWithActionHeading", infoWithActionHeading);
        model.addAttribute("infoWithActionContent", infoWithActionContent);
        model.addAttribute("infoWithActionPrimaryAction", infoWithActionPrimaryAction);
        model.addAttribute("infoWithActionPrimaryActionLink", infoWithActionPrimaryActionLink);

        if(infoWithActionSecAction != null)
            model.addAttribute("infoWithActionSecAction", infoWithActionSecAction);

        if(infoWithActionSecActionLink != null)
            model.addAttribute("infoWithActionSecActionLink", infoWithActionSecActionLink);
    }
}
