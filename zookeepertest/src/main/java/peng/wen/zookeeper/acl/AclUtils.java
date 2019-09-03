package peng.wen.zookeeper.acl;

import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.security.NoSuchAlgorithmException;

public class AclUtils {

    /**
     * 生成加密信息
     * @param id 需要加密deid
     * @return String
     * @throws NoSuchAlgorithmException
     */
    public static String getDigestUserPwd(String id) throws NoSuchAlgorithmException {
        return DigestAuthenticationProvider.generateDigest(id);
    }

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String id = "liwpb1:123456";
        String idDigested = getDigestUserPwd(id);
        System.out.println(idDigested);
    }
}
