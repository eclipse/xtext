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
      final File imageFile = new File(_fileString);
      final FileInputStream stream = new FileInputStream(imageFile);
      try {
        final BufferedImage image = ImageIO.read(stream);
        int _width = image.getWidth();
        int _height = image.getHeight();
        return new ImageDimension(_width, _height);
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
