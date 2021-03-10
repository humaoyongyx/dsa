package issac.study.dsa.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author issac.hu
 */
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = null;
        try {
            data = loadByte(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadByte(String name) throws IOException {
        File file = new File("/Users/admin/test/" + name);
        FileInputStream fi = new FileInputStream(file);
        int len = fi.available();
        byte[] b = new byte[len];
        fi.read(b);
        return b;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
