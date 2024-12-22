package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Init {

    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public Init(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    private void init() {
        roleService.saveRole(new Role(1L, "ROLE_ADMIN"));
        roleService.saveRole(new Role(2L, "ROLE_USER"));

        // Получаем роли с использованием streamAllRoles
        List<Role> adminRole = roleService.streamAllRoles()
                .filter(role -> role.getName().equals("ROLE_ADMIN"))
                .toList();
        List<Role> userRole = roleService.streamAllRoles()
                .filter(role -> role.getName().equals("ROLE_USER"))
                .toList();

        userService.saveUser (new User("Наталья", "Михалева", 35,
                "admin@gmail.com", "admin", adminRole));

        userService.saveUser (new User("Ivanov", "Ivan", 30,
                "user@mail.ru", "user", userRole));
    }
}
