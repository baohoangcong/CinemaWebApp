package fa.training.controller.admin;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.entities.PhongChieu;
import fa.training.page.PageAble;
import fa.training.service.PhongchieuServiceImpl;

@Controller
@RequestMapping("/phongchieu")
public class PhongchieuController {
	
	@Autowired
	private PhongchieuServiceImpl phongchieuServiceImpl;
	
	@GetMapping("/list")
	public String getAllWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<PhongChieu> phongchieus = phongchieuServiceImpl.findWithPageAble(pageAble);
		model.addAttribute("phongchieus", phongchieus);
		model.addAttribute("totalPages", phongchieuServiceImpl.totalPages(pageAble));
		model.addAttribute("currentPage", page);
		return "/phongchieu/list";
	}
	
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("PhongchieuForm", new PhongChieu());
		return "/phongchieu/new";
	}
	
	@PostMapping("/save")
	public String addNewRecord(Model model, @ModelAttribute("PhongchieuForm") @Valid PhongChieu phongchieu, BindingResult result) {
		if (result.hasErrors()) {
			return "/phongchieu/new";
		}
		
		phongchieuServiceImpl.saveOrUpdate(phongchieu);
		return "redirect:/phongchieu/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") String id) {
		phongchieuServiceImpl.delete(id);
		return "redirect:/phongchieu/list";
	}
	
	@GetMapping("/update{id}")
	public String update(@PathVariable("id") String id, Model model) {
		PhongChieu phongchieu = phongchieuServiceImpl.findById(id);
		model.addAttribute("PhongchieuForm", phongchieu);
		return "/phongchieu/update";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("searchKey") String searchKey, Model model) {
		List<PhongChieu> phongchieus = phongchieuServiceImpl.search(searchKey);
		model.addAttribute("phongchieus", phongchieus);
		return "/phongchieu/search";
	}
}
