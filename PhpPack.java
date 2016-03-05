/**
 * 实现描述：实现PHP中的pack函数功能
 *
 * @author jin.xu
 * @version v0.0.0
 * @see
 * @since 15-12-07 下午23:38
 */
public class PhpPack {

    /**
     * PHP中的pack函数，将16进制的字符串，转化为ascii码字符串
     *
     * @param str
     * @return
     */
    public static byte[] pack(String str) {
        int nibbleshift = 4;
        int position = 0;
        int len = str.length() / 2 + str.length() % 2;
        byte[] output = new byte[len];
        for (char v : str.toCharArray()) {
            byte n = (byte) v;
            if (n >= '0' && n <= '9') {
                n -= '0';
            } else if (n >= 'A' && n <= 'F') {
                n -= ('A' - 10);
            } else if (n >= 'a' && n <= 'f') {
                n -= ('a' - 10);
            } else {
                continue;
            }
            output[position] |= (n << nibbleshift);

            if (nibbleshift == 0) {
                position++;
            }
            nibbleshift = (nibbleshift + 4) & 7;
        }
        return output;
    }
}
