package com.wazn.application.controller;

import com.wazn.application.exception.UserException;
import com.wazn.application.gateway.UserGateway;
import com.wazn.application.hateoas.AccountHypermedia;
import com.wazn.application.request.AddUserRequest;
import com.wazn.application.request.UpdateUserRequest;
import com.wazn.application.response.AddUserResponse;
import com.wazn.application.response.ListUserResponse;
import com.wazn.application.response.UpdateUserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/wazn/users")
@Api(description = "Wazn Application API (Add User, Get Users, Update User).")
public class UserControllerImp implements UserController {

    @Autowired
    private UserGateway gateway;
    private AccountHypermedia hypermedia = new AccountHypermedia();
    private final Logger log = LoggerFactory.getLogger(AccountControllerImp.class.getClass());

    @Override
    @RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin()
    @ApiOperation(value = "Method to create new user.", notes = "This method used when you want to add user.")
    @ApiParam(value = "The parameter for this operation.", name = "addUserRequest")
    public Resource<AddUserResponse> addUser(@RequestBody AddUserRequest request) {
        AddUserResponse addUserResponse = null;
        try {
            addUserResponse = gateway.addUser(request);
            return hypermedia.getAccountResources(addUserResponse, "addUser");
        } catch (UserException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: UserControllerImp" + ", Method: addUser" + ", Exception: " + ex);
            throw new UserException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/listUsers", method = RequestMethod.GET, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin()
    @ApiOperation(value = "Method to list users.", notes = "This method used when you want to list users.")
    public List<Resource<ListUserResponse>> listUser() {
        List<Resource<ListUserResponse>> list = new ArrayList<>();
        try {
            gateway.listUser().forEach(e -> {
                list.add(hypermedia.getAccountResources(e, "listUsers"));
            });
            return list;
        } catch (UserException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: UserControllerImp" + ", Method: listUsers" + ", Exception: " + ex);
            throw new UserException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{userName}/updateUser", method = RequestMethod.POST, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin()
    @ApiOperation(value = "Method to update user.", notes = "This method used when you want to update user.")
    @ApiParam(value = "The parameter for this operation.", name = "userName, updateUserRequest")
    public Resource<UpdateUserResponse> updateUser(@PathVariable String userName, @RequestBody UpdateUserRequest request) {
        UpdateUserResponse updateUserResponse = null;
        try {
            updateUserResponse = gateway.updateUser(userName, request);
            return hypermedia.getAccountResources(updateUserResponse, "updateUser");
        } catch (UserException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: UserControllerImp" + ", Method: updateUser" + ", Exception: " + ex);
            throw new UserException(ex.getMessage());
        }
    }
}
