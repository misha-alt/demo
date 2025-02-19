package com.example.demo.services;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.mapper.RolesOfUsersMapper;
import com.example.demo.model.Product;
import com.example.demo.model.RolesOfUsers;
import com.example.demo.productDTO.ProductDto;
import com.example.demo.productDTO.RolesOfUsersDto;
import com.example.demo.repository.RolesOfUsersRepo;
import exeptions.ResurceNotFoundExeption;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RolesOfUsersServiceImpl implements RolesOfUsersService{
    @Autowired
    private RolesOfUsersRepo rolesOfUsersRepo;
    @Override
    public RolesOfUsers createRole(RolesOfUsers rolesOfUsers) {
        // RolesOfUsers rolesOfUsers = RolesOfUsersMapper.mapToRolesOfUsers(rolesOfUsersDto);

        RolesOfUsers savedRolesOfUsers = rolesOfUsersRepo.save(rolesOfUsers);
        return savedRolesOfUsers;
    }

    @Override
    public RolesOfUsers getById(Long id) {
        RolesOfUsers rolesOfUsers =rolesOfUsersRepo.findById(id).orElseThrow(()->
                new ResurceNotFoundExeption("Role is not exist with" + id));
        return rolesOfUsers;
    }

    @Override
    public List<RolesOfUsers> getallRoles() {
        List<RolesOfUsers> list = rolesOfUsersRepo.findAll();


        return list;


    }

    @Override
    public RolesOfUsers updateRole(RolesOfUsers roles) {

            List <RolesOfUsers> rolesOfUserslist = findRoleNam(roles.getRolename());
        RolesOfUsers rolesOfUsersDB = rolesOfUserslist.get(0);

        rolesOfUsersDB.setRolename(roles.getRolename());

        rolesOfUsersDB.setUserSet(roles.getUserSet());
       RolesOfUsers savedRoleInDB = rolesOfUsersRepo.save(rolesOfUsersDB);


            return savedRoleInDB;

    }

    @Override
    public List<RolesOfUsers> findRoleNam(String rolNam) {
        return  rolesOfUsersRepo.findByRolename(rolNam);
    }
}
