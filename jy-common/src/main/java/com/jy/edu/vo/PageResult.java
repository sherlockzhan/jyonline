package com.jy.edu.vo;

import com.jy.edu.util.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 炘爷
 * @create 2020-02-22 15:56
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "全局统一返回结果")
public class PageResult {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();

    public static PageResult ok() {
        PageResult pr = new PageResult();
        pr.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        pr.setCode(ResultCodeEnum.SUCCESS.getCode());
        pr.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return pr;
    }

    public static PageResult error() {
        PageResult pr = new PageResult();
        pr.setSuccess(ResultCodeEnum.FAIL.getSuccess());
        pr.setCode(ResultCodeEnum.FAIL.getCode());
        pr.setMessage(ResultCodeEnum.FAIL.getMessage());
        return pr;
    }

    public static PageResult setPageResult(ResultCodeEnum resultCodeEnum) {
        PageResult pr = new PageResult();
        pr.setSuccess(resultCodeEnum.getSuccess());
        pr.setCode(resultCodeEnum.getCode());
        pr.setMessage(resultCodeEnum.getMessage());
        return pr;
    }

    public PageResult setData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

}
