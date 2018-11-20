package com.smart.im.server.main.utils;

import javax.servlet.http.HttpServletResponse;

/**
 * @author : lichen
 * @date : 2018/11/9 下午2:35
 * @email : 1960003945@qq.com
 * @descriotion :
 */
public class HttpUtils {

    public static void responseBuildJson(HttpServletResponse response, Object jo){
//        String json = "";
//        if(jo instanceof JSONObject){
//            json = JSONUtils.valueToString(jo);
//        }else{
//            try {
//                ObjectMapper objectMapper = new ObjectMapper();
//                json = objectMapper.writeValueAsString(jo);
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        }
//        //response.setContentType("text/plain");
//        response.setContentType("application/json");
//        response.setHeader("Cache-Control", "no-cache");
//        response.setCharacterEncoding("UTF-8");
//        try {
//            PrintWriter writer;
//            writer = response.getWriter();
//            writer.print(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


//    public static void convertParams( HttpServletRequest request,Class className){
//        className.getFields()
//
//            int userId = Integer.parseInt(request.getParameter());
//
//    }
}
