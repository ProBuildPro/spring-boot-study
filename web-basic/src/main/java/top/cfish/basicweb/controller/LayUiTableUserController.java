package top.cfish.basicweb.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.cfish.basicweb.domain.BaseResult;
import top.cfish.basicweb.domain.LayUiTableUser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/6/25
 * @time: 14:45
 */
@RestController("/table")
@CrossOrigin
public class LayUiTableUserController
{
    @GetMapping(name = "/user")
    public BaseResult<LayUiTableUser> tableUser()
    {
        List<LayUiTableUser> list = new ArrayList<>();
        list.add(new LayUiTableUser(1L, "刘备", "男", "成都", "白帝城托孤", 100, 0.6, "主公", 100));
        list.add(new LayUiTableUser(2L, "关羽", "男", "成都", "过五关斩六将", 100, 0.6, "主公", 100));
        list.add(new LayUiTableUser(3L, "张飞", "http://www.qq.com", "成都", "当阳桥一声吼", 100, 0.6, "主公", 100));
        BaseResult request = new BaseResult(0, "", 3, list);
        
        return request;
    }
}
