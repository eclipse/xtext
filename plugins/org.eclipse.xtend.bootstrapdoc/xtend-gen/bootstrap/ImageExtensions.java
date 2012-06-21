package bootstrap;

import bootstrap.ImageDimension;
import java.io.File;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
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
      final ImageInputStream imgageStream = ImageIO.createImageInputStream(_file);
      Iterator<ImageReader> _imageReaders = ImageIO.getImageReaders(imgageStream);
      final ImageReader imageReader = _imageReaders.next();
      imageReader.setInput(imgageStream);
      try {
        int _minIndex = imageReader.getMinIndex();
        int _width = imageReader.getWidth(_minIndex);
        int _minIndex_1 = imageReader.getMinIndex();
        int _height = imageReader.getHeight(_minIndex_1);
        ImageDimension _imageDimension = new ImageDimension(_width, _height);
        return _imageDimension;
      } catch (Exception _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    } catch (Exception _e_1) {
      throw Exceptions.sneakyThrow(_e_1);
    }
  }
}
