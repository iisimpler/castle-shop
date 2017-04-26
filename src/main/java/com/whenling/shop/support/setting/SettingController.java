package com.whenling.shop.support.setting;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whenling.castle.repo.domain.Result;
import com.whenling.shop.support.mvc.BaseController;

@Controller
@RequestMapping("/setting")
public class SettingController extends BaseController {

	@RequestMapping(value = { "", "/", "/index" }, method = RequestMethod.GET)
	public String show(Model model) {
		return "/setting";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Result doSave(@ModelAttribute @Valid Setting setting, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return Result.validateError().addProperties("data", bindingResult.getAllErrors());
		}

		SettingUtils.set(setting);

		return Result.success();
	}

}
