package br.edu.uniacademia.AulaExemplo.controller.page;


import br.edu.uniacademia.AulaExemplo.model.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

    @GetMapping("")
    public String home(Model model){
        Aluno alu = new Aluno("Jefin", 9 , 7);
        model.addAttribute("aluno", alu);
        return "home";
    }

}
