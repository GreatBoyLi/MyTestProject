package com.peng.wen.springbootstudy.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.List;

/**
 * title JsonResult
 * Package com.peng.wen.study.pojo
 *        自定义响应数据结构
 *              这个类是提供给用户，ISO，安卓，微信商城用的
 *              门户接收此类数据后需要使用本类的方法转换成对应的数据类型格式（类，或者List）
 *              其他自行处理
 *              200：表示成功
 *              500：表示错误，错误信息在msg字段中
 *              501：bean验证错误，不管多少个错误都已map形式返回
 *              502：拦截器拦截到用户token出错
 *              555：异常抛出信息
 * Copyright：
 * Company:
 *
 * @author liwpb
 * @version 1.0
 */

public class JsonResult {

    /**
     *定义jackson对象
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     *相应业务状态
     */
    @Setter
    @Getter
    private Integer status;

    /**
     * 相应消息
     */
    @Setter
    @Getter
    private String msg;

    /**
     * 相应的业务数据
     */
    @Setter
    @Getter
    private Object data;

    /**
     * 传入业务状态、业务信息、业务数据，返回JsonResult对象
     * @param status 业务状态
     * @param msg 业务信息
     * @param data 业务数据
     * @return JsonResult
     */
    public static JsonResult build(Integer status, String msg, Object data){
        return new JsonResult(status, msg, data);
    }

    /**
     * 传入业务数据，返回正确状态信息
     * @param data 业务数据
     * @return JsonResult
     */
    public static JsonResult success(Object data){
        return new JsonResult(data);
    }

    /**
     * 返回业务数据为空的成功状态的JsonResult对象
     * @return JsonResult
     */
    public static JsonResult success(){
        return new JsonResult(null);
    }

    /**
     * 返回错误信息的JsonResult对象
     * @param msg 错误信息
     * @return JsonResult
     */
    public static JsonResult errorMsg(String msg){
        return new JsonResult(501, msg, null);
    }

    /**
     * 返回错误信息的JsonResult对象
     * @param data 业务数据
     * @return JsonResult
     */
    public static JsonResult errorMap(Object data){
        return new JsonResult(501, "error",data);
    }

    /**
     * 返回用户token出错信息JsonResult对象
     * @param msg 错误信息
     * @return JsonResult
     */
    public static JsonResult errorTokenMsg(String msg){
        return new JsonResult(502, msg, null);
    }

    /**
     * 返回异常信息JsonResult
     * @param msg 异常信息
     * @return JsonResult
     */
    public static JsonResult errorException(String msg){
        return new JsonResult(555, msg, null);
    }

    /**
     *  将JSON结果集转化为JsonResult对象，
     *             需要转化的对象是一个类
     * @param jsonData JSON字符串
     * @param clazz 需要转化对应的Class类
     * @return JsonResult对象
     */
    public static JsonResult formatToPojo(String jsonData, Class<?> clazz){
        try {
            if (clazz == null){
                return MAPPER.readValue(jsonData,JsonResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object object = null;
            if (data.isObject()){
                object = MAPPER.readValue(data.traverse(),clazz);
            }else if (data.isTextual()){
                object = MAPPER.readValue(data.asText(),clazz);
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), object);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 没有Object对象的转化
     * @param json JSON字符串
     * @return JsonResult对象
     */
    public static JsonResult format(String json){
        try {
            return MAPPER.readValue(json, JsonResult.class);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     *  Object是集合转化
     *             需要转化的对象是一个List
     * @param jsonData JSON字符串
     * @param clazz 需要转化对象的Class类
     * @return JsonResult对象
     */
    public static JsonResult formatToList(String jsonData, Class<?> clazz){
        JsonNode jsonNode = null;
        try {
            jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object object = null;
            if (data.isArray() && data.size() > 0){
                object = MAPPER.readValue(data.traverse(),MAPPER.getTypeFactory().constructCollectionType(List.class,clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), object);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 判断JsonResult对象是否是成功状态，成功状态返回true，失败状态范湖false
     * @return Boolean
     */
    @JsonIgnore
    public Boolean isSuccess(){
        return this.status == 200;
    }

    /**
     * 传入状态、信息、业务数据的构造器
     * @param status 状态
     * @param msg 信息
     * @param data 业务数据
     */
    public JsonResult(Integer status, String msg, Object data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 传入业务数据的构造器
     * @param data 业务数据
     */
    public JsonResult(Object data){
        this.status = 200;
        this.msg = "SUCCESS";
        this.data = data;
    }
}
