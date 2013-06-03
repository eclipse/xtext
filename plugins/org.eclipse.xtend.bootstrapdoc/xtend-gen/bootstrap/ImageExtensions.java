package bootstrap;

import bootstrap.ImageDimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xdoc.xdoc.ImageRef;

@SuppressWarnings("all")
public class ImageExtensions {
  public ImageDimension getDimension(final ImageRef imageRef) {
    try {
      Resource _eResource = imageRef.eResource();
      final URI resourceURI = _eResource.getURI();
      String _path = imageRef.getPath();
      URI _createURI = URI.createURI(_path);
      final URI imageURI = _createURI.resolve(resourceURI);
      String _fileString = imageURI.toFileString();
      File _file = new File(_fileString);
      final File imageFile = _file;
      FileInputStream _fileInputStream = new FileInputStream(imageFile);
      final FileInputStream stream = _fileInputStream;
      try {
        final BufferedImage image = ImageIO.read(stream);
        int _width = image.getWidth();
        int _height = image.getHeight();
        ImageDimension _imageDimension = new ImageDimension(_width, _height);
        return _imageDimension;
      } finally {
        if (stream!=null) {
          stream.close();
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
