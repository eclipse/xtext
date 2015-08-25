package org.eclipse.xtext.xtext.wizard;

import com.google.common.base.Splitter;
import java.util.Iterator;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@Accessors
@SuppressWarnings("all")
public class LanguageDescriptor {
  @FinalFieldsConstructor
  public static class FileExtensions implements Iterable<String> {
    public static LanguageDescriptor.FileExtensions fromString(final String fileExtensions) {
      LanguageDescriptor.FileExtensions _xblockexpression = null;
      {
        Splitter _on = Splitter.on(",");
        Splitter _trimResults = _on.trimResults();
        Splitter _omitEmptyStrings = _trimResults.omitEmptyStrings();
        final Iterable<String> splitFileExtensions = _omitEmptyStrings.split(fileExtensions);
        _xblockexpression = new LanguageDescriptor.FileExtensions(splitFileExtensions);
      }
      return _xblockexpression;
    }
    
    private final Iterable<String> fileExtensions;
    
    @Override
    public Iterator<String> iterator() {
      return this.fileExtensions.iterator();
    }
    
    @Override
    public String toString() {
      return IterableExtensions.join(this.fileExtensions, ",");
    }
    
    public FileExtensions(final Iterable<String> fileExtensions) {
      super();
      this.fileExtensions = fileExtensions;
    }
  }
  
  private String name;
  
  private LanguageDescriptor.FileExtensions fileExtensions;
  
  public String getBasePackage() {
    String _xblockexpression = null;
    {
      final int i = this.name.lastIndexOf(".");
      int _xifexpression = (int) 0;
      if ((i == (-1))) {
        _xifexpression = this.name.length();
      } else {
        _xifexpression = i;
      }
      _xblockexpression = this.name.substring(0, _xifexpression);
    }
    return _xblockexpression;
  }
  
  public String getBasePackagePath() {
    String _basePackage = this.getBasePackage();
    return _basePackage.replaceAll("\\.", "/");
  }
  
  public String getSimpleName() {
    final String[] segments = this.name.split("\\.");
    String _last = IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(segments)));
    return StringExtensions.toFirstUpper(_last);
  }
  
  public String getNsURI() {
    final String[] strings = this.name.split("\\.");
    int _length = strings.length;
    boolean _lessThan = (_length < 2);
    if (_lessThan) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("http://www.");
      _builder.append(this.name, "");
      return _builder.toString();
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("http://www.");
    String _get = strings[1];
    _builder_1.append(_get, "");
    _builder_1.append(".");
    String _get_1 = strings[0];
    _builder_1.append(_get_1, "");
    String s = _builder_1.toString();
    for (int i = 2; (i < strings.length); i++) {
      String _s = s;
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("/");
      String _get_2 = strings[i];
      _builder_2.append(_get_2, "");
      s = (_s + _builder_2);
    }
    return s;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public LanguageDescriptor.FileExtensions getFileExtensions() {
    return this.fileExtensions;
  }
  
  public void setFileExtensions(final LanguageDescriptor.FileExtensions fileExtensions) {
    this.fileExtensions = fileExtensions;
  }
}
