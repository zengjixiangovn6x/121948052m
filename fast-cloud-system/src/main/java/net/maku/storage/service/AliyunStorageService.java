package net.maku.storage.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import net.maku.framework.common.exception.FastException;
import net.maku.storage.properties.StorageProperties;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * 阿里云存储
 *
 * @author 阿沐 babamu@126.com
 */
public class AliyunStorageService implements StorageService {
    private final StorageProperties properties;

    public AliyunStorageService(StorageProperties properties) {
        this.properties = properties;
    }

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public String uploadSuffix(byte[] data, String suffix) {
        return upload(data, getPath(properties.getConfig().getPrefix(), suffix));
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        OSS client = new OSSClientBuilder().build(properties.getAliyun().getEndPoint(),
                properties.getAliyun().getAccessKeyId(), properties.getAliyun().getAccessKeySecret());
        try {
            client.putObject(properties.getAliyun().getBucketName(), path, inputStream);
        }catch (Exception e){
            throw new FastException("上传文件失败：", e);
        } finally {
            if (client != null) {
                client.shutdown();
            }
        }

        return properties.getConfig().getDomain() + "/" + path;
    }

    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {
        return upload(inputStream, getPath(properties.getConfig().getPrefix(), suffix));
    }
}
