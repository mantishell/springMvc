package com.mantishell;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUpload {

    @RequestMapping("/demo")
    public String testParam() {
        System.out.println("ok");
        return "success";
    }

    @RequestMapping("fileUpload3")
    public String fileUpload3(MultipartFile upload) throws Exception{
        //定义上传文件服务器路径
        String path = "http://localhost:9090/uploads";
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_" + filename;
        //创建客户端的对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource webResource = client.resource(path + filename);
        //上传文件
        webResource.put(upload.getBytes());

        return "success";
    }
    /**
     * springMVC文件上传
     * @param request
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception{
        System.out.println("springmvc文件上传...");

        //使用fileupload组件完成文件上传
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_"+filename;
        //完成文件上传
        upload.transferTo(new File(path,filename));
        return "success";
    }
    /**
     * 普通文件上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileUpload1")
    public String fileUpload(HttpServletRequest request) throws Exception{
        //先获取到要上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        //创建File对象
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //创建磁盘文件项工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        //解析request对象
        List<FileItem> list = fileUpload.parseRequest(request);
        //遍历
        for (FileItem fileItem : list) {
            //判断文件项是普通字段，还是上传的文件
            if(fileItem.isFormField()){
                //普通表单
            }else{
                //上传文件
                String filename = fileItem.getName();
                //把文件的名称设置唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-","");
                filename=uuid+"_"+filename;
                fileItem.write(new File(path, filename));//上传文件
                fileItem.delete();//删除临时文件
            }
        }
        return "success";
    }
}
