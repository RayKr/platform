package com.boya.platform.forum.controller;

import com.boya.platform.forum.model.dto.ResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/18 9:24
 */
@RestController
@RequestMapping(value = "/api")
public class SysController extends AbstractController {

    @RequestMapping(value="/upload",method= RequestMethod.POST )
    public Object addAdmin(MultipartFile file)throws Exception{
        return saveFile(file, "upload");
    }

    @RequestMapping(value="/upload/portrait",method= RequestMethod.POST )
    public Object changePortrait(MultipartFile file)throws Exception{
        return saveFile(file, "upload/portrait");
    }

    /**
     * 保存文件到指定路径
     * @param file
     * @param realPath
     * @return
     * @throws IOException
     */
    private ResponseDTO saveFile(MultipartFile file, String realPath) throws IOException {
        ResponseDTO res = new ResponseDTO();
        if (file.getSize() > 1024 * 1024 * 2) {
            res.setResult(false);
            res.setMsg("文件不得大于2M！");
            return res;
        }

        String path = request.getSession().getServletContext().getRealPath(realPath);
        String originalFilename = file.getOriginalFilename();
        // 文件名追加随机数，防止重复
        String[] fileItems = originalFilename.split("\\.");
        String s = fileItems[0] + (int)Math.floor(Math.random() * 1000000);
        String fileName = s + "." + fileItems[1];
        File dir = new File(path,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);

        res.setResult(true);
        res.setData("/" + realPath + "/" + fileName);
        return res;
    }

    /**
     * 文件下载功能
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/down")
    public void down(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //模拟文件，myfile.txt为需要下载的文件
        String fileName = request.getSession().getServletContext().getRealPath("upload")+"/myfile.txt";
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        //假如以中文名下载的话
        String filename = "下载文件.txt";
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }
}
