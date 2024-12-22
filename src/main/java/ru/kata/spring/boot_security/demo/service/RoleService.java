package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.stream.Stream;

public interface RoleService {

    // Получение всех ролей
    List<Role> findAllRoles();

    // Получение роли по ID
    Role findRoleById(Long id);

    // Создание новой роли
    Role saveRole(Role role);

    // Обновление существующей роли
    Role updateRole(Long id, Role role);

    // Удаление роли
    void deleteRole(Long id);

    Stream<Role> streamAllRoles();
}
