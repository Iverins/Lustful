package iv.utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class JarLoader {
    private String path;
    private Image icon;
    private URL toPathGetURL;
    private InputStream toPathGetStream;
    private byte[] data = new byte[1024];
    private File outFile;
    public JarLoader(String path){
        this.path = path;
    }
    public Image fromPathToGetIcon(){
        this.icon = new ImageIcon(this.getClass().getResource(path)).getImage();
        return this.icon;
    }
    public URL fromPathToGetURL(){
        this.toPathGetURL = this.getClass().getResource(path);
        return this.toPathGetURL;
    }
    public InputStream fromPathToGetStream(){
        this.toPathGetStream = this.getClass().getResourceAsStream(path);
        return this.toPathGetStream;
    }
    public File copyToOut() throws IOException {
        File parentFile = new File(System.getProperty("java.class.path")).getParentFile();
        outFile = new File(parentFile , "config.yml");
        if (!parentFile.exists()){
            parentFile.mkdirs();
            outFile.createNewFile();
        }
        if (!outFile.exists()){
            outFile.createNewFile();
        }
        int length = this.fromPathToGetStream().read(data);
        FileOutputStream writer = new FileOutputStream(outFile);
        writer.write(data , 0 , length);
        writer.close();
        return outFile;
    }
}
