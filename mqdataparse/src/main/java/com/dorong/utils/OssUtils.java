package com.dorong.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;

/**
 * Created by ljy on 2017/3/17.
 */
public class OssUtils {

    private static Log log = LogFactory.getLog(OssUtils.class);

    // endpoint以杭州为例，其它region请按实际情况填写
    private static final String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    // accessKey请登录https://ak-console.aliyun.com/#/查看
    private static final String accessKeyId = "LTAI0rmn1gfSwPWo";
    private static final String accessKeySecret = "ZlUzJsNez3e4h8Jx1wohK0fIBDS88W";
    private static final String bucketname = "jlmdata";

    private OSSClient ossClient;

    private static OssUtils ossUtils;

    private OssUtils(OSSClient ossClient){
        this.ossClient = ossClient;
    }

    public static OssUtils getCllientInstance(){
        if(ossUtils ==null){
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            ossUtils = new OssUtils(ossClient);
        }
        return ossUtils;
    }

    /**
     * 上传文件
     * @param fileKey oss端文件名
     * @param file2put 本地要上传的文件
     */
    public void putObject(String fileKey,File file2put){
        // 上传文件
        ossClient.putObject(bucketname, fileKey, file2put);
        // 关闭client
//        ossClient.shutdown();
    }

    /**
     * 获取文件内容
     * @param fileKey oss对于的文件名
     * @return 文件内容
     */
    public String getObjectContent(String fileKey){
//    	return "place holder";
        //下载文件
        StringBuilder sb = new StringBuilder();
        try {
            OSSObject object = ossClient.getObject(bucketname, fileKey);
            InputStream is = object.getObjectContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine())!=null){
                sb.append(line);
            }
        } catch (OSSException e) {
            log.error(e.getMessage(),e);
            return "";
        }
        catch (ClientException | IOException e) {
            log.error(e.getMessage(),e);
            return "";
        }
        return sb.toString();
    }

    public String getObjectContentUTF8(String fileKey){
//    	return "place holder";
        //下载文件
        StringBuilder sb = new StringBuilder();
        try {
            OSSObject object = ossClient.getObject(bucketname, fileKey);
            InputStream is = object.getObjectContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
            String line = null;
            while ((line = br.readLine())!=null){
                sb.append(line);
            }
        } catch (OSSException e) {
            log.error(e.getMessage(),e);
            return "";
        } 
        catch (ClientException | IOException e) {
            log.error(e.getMessage(),e);
            return "";
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String key = "dataSource/yys/mx/20170522/404833-15868835196.txt";
//        OssUtils.getCllientInstance().putObject(key, new File("D:\\gjjinfo-259365-1489370936103.txt"));
        String rs = OssUtils.getCllientInstance().getObjectContentUTF8(key);
        log.info(rs);
//        log.info(OssUtils.getCllientInstance()==OssUtils.getCllientInstance());
    }

}
