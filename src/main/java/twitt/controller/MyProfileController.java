package twitt.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import twitt.domain.ProfileForm;
import twitt.session.UserProfileSession;
import utils.ChinaLocalDateFormatter;

@Controller
@RequestMapping("profile")
public class MyProfileController {
	
	@Autowired
	private UserProfileSession userProfileSession;
	
	public ProfileForm getProfileForm() {
		return userProfileSession.toForm();
	}

	@RequestMapping("page")
	public String displayProfile(ProfileForm profileForm) {
		return "profile/profilePage";
	}
	
	@RequestMapping(value = "page", params = {"save"}, method=RequestMethod.POST)
	public String saveProfile(@Valid ProfileForm profileForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return "profile/profilePage";
		
		userProfileSession.saveForm(profileForm);
		return "redirect:page";
	}
	
	@ModelAttribute("dateFormat")
	public String localeFormat(Locale locale) {	
		return ChinaLocalDateFormatter.getPattern(locale);
	}
	
	@RequestMapping(value = "page", params = {"addTaste"}, method=RequestMethod.POST)
	public String addRow(ProfileForm p) {
		p.getTastes().add(null);
		return "profile/profilePage";
	}
	
	@RequestMapping(value = "page", params = {"removeTaste"}, method=RequestMethod.POST)
	public String removeRow(ProfileForm p, HttpServletRequest req) {
		int rowId = Integer.parseInt(req.getParameter("removeTaste"));
		p.getTastes().remove(rowId);
		return "profile/profilePage";
	}
}
