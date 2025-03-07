package com.sridhar.cartcraftapi.service.user;

import com.sridhar.cartcraftapi.dto.UserDto;
import com.sridhar.cartcraftapi.model.User;
import com.sridhar.cartcraftapi.request.CreateUserRequest;
import com.sridhar.cartcraftapi.request.UserUpdateRequest;

public interface IUserService {

    User getUserById(Long userId);

    User createUser(CreateUserRequest request);

    User updateUser(UserUpdateRequest request, Long userId);

    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);
}
