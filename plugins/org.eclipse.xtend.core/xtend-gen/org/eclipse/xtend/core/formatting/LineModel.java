package org.eclipse.xtend.core.formatting;

import java.util.List;
import org.eclipse.xtend.core.formatting.Line;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class LineModel {
  @Property
  private String _leadingText;
  
  @Property
  private int _rootIndentLenght = (-1);
  
  @Property
  private final List<Line> _lines = CollectionLiterals.<Line>newArrayList();
  
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rootIndentLenght=");
    int _rootIndentLenght = this.getRootIndentLenght();
    _builder.append(_rootIndentLenght, "");
    _builder.newLineIfNotEmpty();
    String _leadingText = this.getLeadingText();
    _builder.append(_leadingText, "");
    List<Line> _lines = this.getLines();
    String _join = IterableExtensions.join(_lines);
    _builder.append(_join, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  @Pure
  public String getLeadingText() {
    return this._leadingText;
  }
  
  public void setLeadingText(final String leadingText) {
    this._leadingText = leadingText;
  }
  
  @Pure
  public int getRootIndentLenght() {
    return this._rootIndentLenght;
  }
  
  public void setRootIndentLenght(final int rootIndentLenght) {
    this._rootIndentLenght = rootIndentLenght;
  }
  
  @Pure
  public List<Line> getLines() {
    return this._lines;
  }
}
