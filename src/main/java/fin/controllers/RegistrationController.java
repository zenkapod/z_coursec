package fin.controllers;

import fin.dto.UserRegistrationDto;
import fin.security.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/registration")
public class RegistrationController {
   private UserService userService;

   public RegistrationController(UserService userService) {
      super();
      this.userService = userService;
   }

   @ModelAttribute("user")
   public UserRegistrationDto userRegistrationDto() {
      return new UserRegistrationDto();
   }

   @GetMapping
   public String showRegistrationForm() {
      return "registration";
   }

   @PostMapping
   public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto registrationDto, BindingResult result) {
      if (result.hasErrors()) {
         return "registration";
      }
      try {
         userService.save(registrationDto);
      } catch (Exception e) {
         System.out.println(e);
         return "redirect:/registration?email_invalid";
      }
      return "redirect:/login";
   }
}