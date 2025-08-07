package com.sf.demo.api.info;

import com.sf.demo.common.page.PageVo;
import com.sf.demo.common.vo.R;
import com.sf.demo.dto.DepDto;
import com.sf.demo.dto.DepQueryDto;
import com.sf.demo.model.Dep;
import com.sf.demo.service.info.DepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: DepController
 * @Author 殇枫
 * @Package com.sf.demo.api.info
 * @Date 2025/8/7
 * @description:
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/info/dep")
public class DepController {

    private final DepService depService;

    @GetMapping("")
    public R<PageVo<Dep>> depList(DepQueryDto depQueryDto){
        PageVo<Dep> page = depService.getDepPage(depQueryDto);
        return R.OK(page);
    }

    @PostMapping("")
    public R<?> execAdd(@RequestBody DepDto depDto){
        depService.addDep(depDto);
        return R.OK();
    }
    @PutMapping("")
    public R<?> execUpd(@RequestBody DepDto depDto){
        depService.updateDep(depDto);
        return R.OK();
    }

    @DeleteMapping("/{id}")
    public R<?> execDel(@PathVariable Integer id){
        depService.removeDep(id);
        return R.OK();
    }

    @DeleteMapping("")
    public R<?> execDel(@RequestBody Integer[] ids){
        depService.removeDep(ids);
        return R.OK();
    }

    @PutMapping("/{id}/{status}")
    public R<?> changeStatus(@PathVariable Integer id,@PathVariable Integer status){
        depService.changeStatus(id,status);
        return R.OK();
    }

}
