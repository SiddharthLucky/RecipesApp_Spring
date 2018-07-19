package lucky.recipespringapp.com.recipespringapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controllers
{
    @RequestMapping({"","/","/index"})
    public String getIndexPage()
    {
        return "index";
    }
}
