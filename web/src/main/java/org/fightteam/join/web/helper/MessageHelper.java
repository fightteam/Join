package org.fightteam.join.web.helper;

import org.springframework.ui.Model;

/**
 * 信息提示辅助工具类
 *
 * @author faith
 * @since 0.0.1
 */
public class MessageHelper {

    // Helper methods
    public void setup(Model model) {
        model.addAttribute("error", false);
        model.addAttribute("success", false);
        model.addAttribute("alert", false);
        model.addAttribute("info", false);
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


}
