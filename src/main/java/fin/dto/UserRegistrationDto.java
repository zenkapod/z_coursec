package fin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRegistrationDto {

   private String role;

   @NotBlank(message = "Имя не должно быть пустым")
   @Pattern(regexp = "[a-zA-Zа-яА-Я ]+", message = "Имя должно содержать только буквы")
   private String userName;

   @NotBlank(message = "Полное имя не должно быть пустым")
   @Pattern(regexp = "[a-zA-Zа-яА-Я ]+", message = "Полное имя должно содержать только буквы")
   private String fullName;

   @NotBlank(message = "Город не должен быть пустым")
   @Pattern(regexp = "[a-zA-Zа-яА-Я ]+", message = "Город должен содержать только буквы")
   private String city;

   @NotBlank(message = "Номер телефона не должен быть пустым")
   @Pattern(regexp = "\\d+", message = "Номер телефона должен содержать только цифры")
   private String phoneNumber;

   @NotBlank(message = "Пароль не должен быть пустым")
   private String password;
}

