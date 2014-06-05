package bootstrap;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class ImageDimension {
  private final int _width;
  
  public int getWidth() {
    return this._width;
  }
  
  private final int _height;
  
  public int getHeight() {
    return this._height;
  }
  
  public ImageDimension(final int width, final int height) {
    super();
    this._width = width;
    this._height = height;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this._width;
    result = prime * result + this._height;
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ImageDimension other = (ImageDimension) obj;
    if (other._width != this._width)
      return false;
    if (other._height != this._height)
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
