package com.hsf.mapper;
import com.hsf.dto.UserRequestDTO;
import com.hsf.dto.UserResponseDTO;
import com.hsf.entity.User;
import com.hsf.entity.Group;
import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {
    
    public UserResponseDTO toUserResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAdresse(user.getAdresse());
        dto.setTelefon(user.getTelefon());
        dto.setFax(user.getFax());
        Set<String> groupNames = user.getGroups().stream()
                                     .map(Group::getName)
                                     .collect(Collectors.toSet());
        dto.setGroups(groupNames);
        return dto;
    }

    public User toUserEntity(UserRequestDTO dto) {
        User user = new User();
        user.setWinUser(dto.getWinUser());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAdresse(dto.getAdresse());
        user.setTelefon(dto.getTelefon());
        user.setFax(dto.getFax());
        // Note: Groups mapping is not handled here
        return user;
    }

}
