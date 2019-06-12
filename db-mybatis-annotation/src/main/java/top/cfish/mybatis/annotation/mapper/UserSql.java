package top.cfish.mybatis.annotation.mapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import top.cfish.mybatis.annotation.param.PageParam;

import java.util.Map;

/**
 * @author: isisiwish
 * @date: 2019/5/14
 * @time: 14:49
 */
@Slf4j
public class UserSql
{
    // @SelectProvide方法必须接受Map<String, Object>做为参数
    // 如果参数使用了@Param注解，那么参数在Map中以@Param的值为key
    // 如果参数没有使用@Param注解，那么参数在Map中以参数的顺序为key
    public String getUser(Map<String, Object> param)
    {
        StringBuffer sql = new StringBuffer("select id,username,password,email,phone,question,answer,role,create_time as createTime,update_time as updateTime ");
        sql.append(" from user where 1=1 ");
        if (StringUtils.isNotBlank((String)param.get("username")))
        {
            sql.append(" and username = #{username} ");
        }
        if (StringUtils.isNotBlank((String)param.get("password")))
        {
            sql.append(" and password = #{password} ");
        }
        
        log.info("[getUser] SQL : " + sql.toString());
        return sql.toString();
    }
    
    public String getList(PageParam page)
    {
        StringBuffer sql = new StringBuffer("select id,username,password,email,phone,question,answer,role,create_time as createTime,update_time as updateTime ");
        sql.append(" from user ");
        sql.append(" order by id asc");
        if (page != null)
        {
            sql.append(" limit " + page.getPageNum() + "," + page.getPageSize());
        }
        
        log.info("[getList] SQL : " + sql.toString());
        return sql.toString();
    }
    
    public String getCount()
    {
        // 内部使用StringBuilder实现SQL拼接
        String sql = new SQL()
        {{
            SELECT("count(1)");
            FROM("user");
        }}.toString();
        
        log.info("[getCount] SQL : " + sql);
        return sql;
    }
}
