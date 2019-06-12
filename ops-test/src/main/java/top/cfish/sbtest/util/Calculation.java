package top.cfish.sbtest.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: isisiwish
 * @date: 2019/5/27
 * @time: 10:46
 */
@Component
public class Calculation
{
    public int add(int a, int b)
    {
        return a + b;
    }
    
    public int sub(int a, int b)
    {
        return a - b;
    }
    
    public double div(double a, double b)
    {
        return a / b;
    }
    
    public String getName(String name)
    {
        return name;
    }
    
    public List<String> getList(String item)
    {
        List<String> list = new ArrayList<String>();
        list.add(item);
        return list;
    }
    
    public Map<String, String> getMap(String key, String value)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put(key, value);
        return map;
    }
}
