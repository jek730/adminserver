package com.jmt.config.controllers;

import com.jmt.config.service.ConfigInfoService;
import com.jmt.config.service.ConfigSaveService;
import com.jmt.global.exceptions.ExceptionProcessor;
import com.jmt.menus.Menu;
import com.jmt.menus.MenuDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/config")
@RequiredArgsConstructor
public class BasicConfigController implements ExceptionProcessor {

    private final ConfigSaveService saveService;
    private final ConfigInfoService infoService;

    @ModelAttribute("menuCode")
    public String getMenuCode() {
        return "config";
    }

    @ModelAttribute("subMenuCode")
    public String getSubMenuCode() {
        return "basic";
    }

    @ModelAttribute("subMenus")
    public List<MenuDetail> getSubMenus() {
        return Menu.getMenus("config");
    }

    @ModelAttribute("pageTitle")
    public String getPageTitle() {
        return "기본설정";
    }

    @GetMapping
    public String index(Model model) {

        com.jmt.config.controllers.BasicConfig config = infoService.get("basic", com.jmt.config.controllers.BasicConfig.class).orElseGet(BasicConfig::new);

        model.addAttribute("basicConfig", config);

        return "config/basic";
    }

    @PostMapping
    public String save(com.jmt.config.controllers.BasicConfig config, Model model) {

        saveService.save("basic", config);

        model.addAttribute("message", "저장되었습니다.");

        return "config/basic";
    }
}