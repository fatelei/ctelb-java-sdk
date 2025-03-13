package cn.ctyun.sdk;

public class Credential {

    public final String ak;
    public final String sk;

    public Credential(String ak, String sk) {
        if (ak == null || ak.isEmpty()) {
            throw new IllegalArgumentException("ak can not be null or empty");
        }
        if (sk == null || sk.isEmpty()) {
            throw new IllegalArgumentException("sk can not be null or empty");
        }
        this.ak = ak;
        this.sk = sk;
    }

    /**
     * 读取环境变量中的ak、sk
     *
     * @return 用户信息
     */
    public static Credential credentialFromEnv() {
        String ctyunAk = System.getenv("CTYUN_AK");
        String ctyunSk = System.getenv("CTYUN_SK");
        return new Credential(ctyunAk, ctyunSk);
    }
}
