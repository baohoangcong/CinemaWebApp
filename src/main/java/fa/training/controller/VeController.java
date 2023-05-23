package fa.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.entities.Ve;
import fa.training.page.PageAble;
import fa.training.service.VeService;

@Controller
public class VeController {
	
	@Autowired
	private VeService VeService;
	
	@GetMapping("/list")
	public String getAllWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<Ve> Ves = VeService.findWithPageAble(pageAble);
		model.addAttribute("Ves", Ves);
		model.addAttribute("totalPages", VeService.totalPages(pageAble));
		model.addAttribute("currentPage", page);
		return "/Ve/list";
	}
	
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("VeForm", new Ve());
		return "/Ve/new";
	}
	
	@PostMapping("/save")
	public String addNewRecord(Model model, @ModelAttribute("VeForm") @Valid Ve Ve, BindingResult result) {
		if (result.hasErrors()) {
			return "/Ve/new";
		}
		
		VeService.saveOrUpdate(Ve);
		return "redirect:/Ve/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		VeService.delete(id);
		return "redirect:/Ve/list";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") int id, Model model) {
		Ve Ve = VeService.findById(id);
		model.addAttribute("VeForm", Ve);
		return "/Ve/update";
	}
	
//	@GetMapping("/search")
//	public String search(@RequestParam("searchKey") String searchKey, Model model) {
//		List<Ve> Ves = VeService.search(searchKey);
//		model.addAttribute("Ves", Ves);
//		return "/Ve/search";
//	}
}
