import com.blue.utils.FastDFSClient;
import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * @author gzk
 * @version 1.0
 * @description PACKAGE_NAME
 * @date 2018/1/29
 */
public class FastDFSTest {

    @Test
    public void testUplodFile()throws Exception{

        //1.创建一个配置文件,连接tracker-server
        //2.加载配置文件
        ClientGlobal.init("C:\\workspace\\taotao_parent\\taotao_manager_web\\src\\main\\resources\\resources\\fastdfs.conf");

        //3.构建trackerClient对象
        TrackerClient trackerClient = new TrackerClient();

        //4.构架trackerserver
        TrackerServer trackerServer = trackerClient.getConnection();

        //5.创建一个storage server对象
        StorageServer storageServer = null;

        //6.构建一个storage client对象
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);

        //7.使用storage client上传图片测试
        //第一个参数:要上传的图片的本地路径
        //第二个参数:图片的扩展名 不带 点
        //第三个参数:图片 高 宽 像素 时间戳等
        String[] jpgs = storageClient.upload_file("F:\\皮克奇叶儿\\02b4c6b07a4e6c04c4be050fe37fc83b.jpg", "jpg", null);
        for (String jpg : jpgs) {
            System.out.println(jpg);
        }
    }

    @Test
    public void fun01() throws Exception{
        FastDFSClient fastDFSClient = new FastDFSClient("C:\\workspace\\taotao_parent\\taotao_manager_web\\src\\main\\resources\\resources\\fastdfs.conf");

        String filepath = fastDFSClient.uploadFile("F:\\皮克奇叶儿\\02b4c6b07a4e6c04c4be050fe37fc83b.jpg", "jpg");

        System.out.println(filepath);

    }

}
