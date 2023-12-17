package Controller;

import Repository.Modal.Labor;
import Service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class FarmerController {


    private FarmerService farmerService;
    @Autowired
    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @RequestMapping(path = "/")
    public String index(){
        return "edit";
    }

    //redirect to the labor form with an instance of labor object
    @GetMapping(path = "/labor/add")
    public String createLabor(Model model){
        /* Student studentInstance=new Student(); */
        model.addAttribute("laborInstance",new Labor());
        return "edit";
    }

    @RequestMapping(path = "/labors",method = RequestMethod.POST)
   public String saveLabor(Labor labor){
        farmerService.saveLabor(labor);
        return "redirect:/";
    }

    @GetMapping(path = "/labors")
    public String getAllLabor(Model model){
        model.addAttribute("labors",farmerService.getAllLabor());
        return "laborList";
    }


    //delete Labors without confirmation

    @RequestMapping(path="/labors/delete/{id})",method = RequestMethod.GET)
    public String deleteLabor(@PathVariable(value = "id") String id){
        farmerService.deleteLabor(id);
        return "redirect:/labors";
    }

    // Show the update form for a specific labor
    @GetMapping(path = "/labors/update/{id}")
    public String showUpdateForm(@PathVariable(value = "id") String id, Model model) {
        // Retrieve the existing labor by ID
        Optional<Labor> existingLabor = farmerService.findLabour(id);
        if (existingLabor != null) {
            // Add the existing labor to the model
            model.addAttribute("laborInstance", existingLabor);
            return "edit";  // Assuming you have an 'edit' template for updating
        } else {
            // Labor not found, redirect to labors list or handle appropriately
            return "redirect:/labors";
        }
    }

    // Process the update form submission
    @PostMapping(path = "/labors/update/{id}")
    public String updateLabor(@PathVariable(value = "id") String id, Labor updatedLabor) {
        // Call the service to update the labor
        farmerService.updateLabor(id, updatedLabor);

        return "redirect:/labors";
    }

}
