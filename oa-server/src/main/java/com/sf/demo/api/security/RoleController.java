package com.sf.demo.api.security;

import com.sf.demo.common.page.PageVo;
import com.sf.demo.common.vo.R;
import com.sf.demo.dto.RoleDto;
import com.sf.demo.dto.RoleQueryDto;
import com.sf.demo.model.Role;
import com.sf.demo.service.security.RoleService;
import com.sf.demo.vo.MenuVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Title: RoleController
 * @Author 殇枫
 * @Package com.sf.demo.api.security
 * @Date 2025/8/7
 * @description:
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/security/role")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("")
    public R<PageVo<Role>> roleList(RoleQueryDto roleQueryDto){
        PageVo<Role> page = roleService.getRolePage(roleQueryDto);
        return R.OK(page);
    }

    @PostMapping("")
    public R<?> execAdd(@RequestBody RoleDto roleDto){
        roleService.addRole(roleDto);
        return R.OK();
    }
    @PutMapping("")
    public R<?> execUpd(@RequestBody RoleDto roleDto){
        roleService.updateRole(roleDto);
        return R.OK();
    }

    @DeleteMapping("/{id}")
    public R<?> execDel(@PathVariable Integer id){
        roleService.removeRole(id);
        return R.OK();
    }

    @DeleteMapping("")
    public R<?> execDel(@RequestBody Integer[] ids){
        roleService.removeRole(ids);
        return R.OK();
    }

    @GetMapping("/fun")
    public R<List<MenuVo>> allFunList(){
        List<MenuVo> funList = roleService.getFunList();
        return R.OK(funList);
    }

    @GetMapping("/fun/{roleId}")
    public R<List<Integer>> getRoleFunIdList(@PathVariable Integer roleId){
        List<Integer> funIdList = roleService.getRoleFunIdList(roleId);
        return R.OK(funIdList);
    }

    @PutMapping("/fun")
    public R<?> execUpdateRoleFunIds(@RequestBody Map<String,Object> map){
        roleService.updateRoleFun(map);
        return R.OK();
    }

}
