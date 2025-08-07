package com.sf.demo.api.security;

import com.sf.demo.common.page.PageVo;
import com.sf.demo.common.vo.R;
import com.sf.demo.dto.UserDto;
import com.sf.demo.dto.UserQueryDto;
import com.sf.demo.model.Role;
import com.sf.demo.service.security.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Title: UserController
 * @Author 殇枫
 * @Package com.sf.demo.api.security
 * @Date 2025/8/7
 * @description:
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/security/user")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public R<PageVo<User>> userList(UserQueryDto userQueryDto){
        PageVo<User> page = userService.getUserPage(userQueryDto);
        return R.OK(page);
    }

    @PostMapping("")
    public R<?> execAdd(@RequestBody UserDto userDto){
        userService.addUser(userDto);
        return R.OK();
    }
    @PutMapping("")
    public R<?> execUpd(@RequestBody UserDto userDto){
        userService.updateUser(userDto);
        return R.OK();
    }

    @DeleteMapping("/{id}")
    public R<?> execDel(@PathVariable String id){
        userService.removeUser(id);
        return R.OK();
    }

    @DeleteMapping("")
    public R<?> execDel(@RequestBody String[] ids){
        userService.removeUser(ids);
        return R.OK();
    }

    @GetMapping("/role")
    public R<List<Role>> allRoleList(){
        List<Role> roleList = userService.getRoleList();
        return R.OK(roleList);
    }

    @GetMapping("/role/{userId}")
    public R<List<Integer>> getUserRoleIdList(@PathVariable String userId){
        List<Integer> roleIdList = userService.getUserRoleIdList(userId);
        return R.OK(roleIdList);
    }

    @PutMapping("/role")
    public R<?> execUpdateUserRoleIds(@RequestBody Map<String,Object> map){
        userService.updateUserRole(map);
        return R.OK();
    }

}