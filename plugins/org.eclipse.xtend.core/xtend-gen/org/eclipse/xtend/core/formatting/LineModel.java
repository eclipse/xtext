package org.eclipse.xtend.core.formatting;

import java.util.List;
import org.eclipse.xtend.core.formatting.Line;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class LineModel {
  private String leadingText;
  
  private int rootIndentLenght = (-1);
  
  private final List<Line> lines = CollectionLiterals.<Line>newArrayList();
  
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("rootIndentLenght=");
    _builder.append(this.rootIndentLenght, "");
    _builder.newLineIfNotEmpty();
    _builder.append(this.leadingText, "");
    String _join = IterableExtensions.join(this.lines);
    _builder.append(_join, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  @Pure
  public String getLeadingText() {
    return this.leadingText;
  }
  
  public void setLeadingText(final String leadingText) {
    this.leadingText = leadingText;
  }
  
  @Pure
  public int getRootIndentLenght() {
    return this.rootIndentLenght;
  }
  
  public void setRootIndentLenght(final int rootIndentLenght) {
    this.rootIndentLenght = rootIndentLenght;
  }
  
  @Pure
  public List<Line> getLines() {
    return this.lines;
  }
}
