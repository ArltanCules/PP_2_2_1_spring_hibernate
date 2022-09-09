package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Arltan", "Uleev", "au@mail.ru",
              new Car("Bmw",70)));
      userService.add(new User("Aldar", "Badmaev", "ab@mail.ru",
              new Car("Audi",80)));
      userService.add(new User("Savr", "Shalburov", "ssh@mail.ru",
              new Car("Mersedes",90)));
      userService.add(new User("Bair", "Tsedenov", "bts@mail.ru",
              new Car("Mazda",100)));



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("car_id = "+user.getUserCar());
         System.out.println();

         User userByCar = userService.getUserByCar("Audi", 80);
         System.out.println(userByCar);
      }

      context.close();
   }
}
