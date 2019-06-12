package top.cfish.webswagger.comm;

/**
 * @author: isisiwish
 * @date: 2019/5/23
 * @time: 16:34
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 通用响应对象
 */
@Getter
@Setter
@ApiModel(description = "响应对象")
public class BaseResult<T>
{
    private static final int SUCCESS_CODE = 0;
    private static final String SUCCESS_MESSAGE = "成功";
    
    @ApiModelProperty(value = "响应码", name = "code", required = true, example = "" + SUCCESS_CODE)
    private int code;
    
    @ApiModelProperty(value = "响应消息", name = "msg", required = true, example = SUCCESS_MESSAGE)
    private String msg;
    
    @ApiModelProperty(value = "响应数据", name = "data")
    private T data;
    
    private BaseResult(int code, String msg, T data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    
    private BaseResult()
    {
        this(SUCCESS_CODE, SUCCESS_MESSAGE);
    }
    
    private BaseResult(int code, String msg)
    {
        this(code, msg, null);
    }
    
    private BaseResult(T data)
    {
        this(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }
    
    public static <T> BaseResult<T> success()
    {
        return new BaseResult<>();
    }
    
    public static <T> BaseResult<T> successWithData(T data)
    {
        return new BaseResult<>(data);
    }
    
    public static <T> BaseResult<T> failWithCodeAndMsg(int code, String msg)
    {
        return new BaseResult<>(code, msg, null);
    }
    
    public static <T> BaseResult<T> buildWithParam(ResponseParam param)
    {
        return new BaseResult<>(param.getCode(), param.getMsg(), null);
    }
    
    @Getter
    @Setter
    public static class ResponseParam
    {
        private int code;
        private String msg;
        
        private ResponseParam(int code, String msg)
        {
            this.code = code;
            this.msg = msg;
        }
        
        public static ResponseParam buildParam(int code, String msg)
        {
            return new ResponseParam(code, msg);
        }
    }
}
