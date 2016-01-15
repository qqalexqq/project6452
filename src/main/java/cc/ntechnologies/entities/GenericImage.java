package cc.ntechnologies.entities;

import cc.ntechnologies.Config;
import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;
import com.google.appengine.repackaged.org.apache.commons.codec.binary.Base64;
import com.google.appengine.repackaged.org.apache.commons.codec.binary.StringUtils;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import org.primefaces.model.UploadedFile;

import java.io.Serializable;


public class GenericImage implements Serializable {
    private static final long serialVersionUID = 1L;

    private byte[] data;

    public byte[] getData() {
        return data;
    }
    public void setData(byte[] data) {
        this.data = data;
    }

    public void createImageFromFile(UploadedFile file) {
        byte[] imageBytes = file.getContents();

        ImagesService imagesService = ImagesServiceFactory.getImagesService();

        Image uploadImage = ImagesServiceFactory.makeImage(imageBytes);

        Transform resize = ImagesServiceFactory.makeResize(Config.RESIZE_IMAGE_WIDTH, Config.RESIZE_IMAGE_HEIGHT);

        Image newImage = imagesService.applyTransform(resize, uploadImage);

        this.data = newImage.getImageData();
    }

    public String getImageRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append("data:image/jpeg;base64,");
        sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(data)));

        return sb.toString();
    }

    public String getChangeTitle() {
        return "Click here to change image";
    }
}