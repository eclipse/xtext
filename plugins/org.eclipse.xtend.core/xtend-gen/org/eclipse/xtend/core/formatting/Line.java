package org.eclipse.xtend.core.formatting;

import java.util.List;
import org.eclipse.xtend.core.formatting.Chunk;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Line {
  @Property
  private final int _offset;
  
  @Property
  private final boolean _leadingSemanticNewLine;
  
  @Property
  private final int _newLineCharCount;
  
  @Property
  private final List<Chunk> _chunks = CollectionLiterals.<Chunk>newArrayList();
  
  @Property
  private String _content;
  
  @Property
  private int _indentLength;
  
  public Line(final int offset, final boolean leadingSemanticNewLine, final int newLineCharCount) {
    this._offset = offset;
    this._leadingSemanticNewLine = leadingSemanticNewLine;
    this._newLineCharCount = newLineCharCount;
  }
  
  public String toString() {
    String _xifexpression = null;
    boolean _isLeadingSemanticNewLine = this.isLeadingSemanticNewLine();
    if (_isLeadingSemanticNewLine) {
      _xifexpression = "SN";
    } else {
      _xifexpression = "";
    }
    String _plus = (_xifexpression + "\n");
    List<Chunk> _chunks = this.getChunks();
    String _join = IterableExtensions.join(_chunks);
    String _plus_1 = (_plus + _join);
    String _content = this.getContent();
    return (_plus_1 + _content);
  }
  
  @Pure
  public int getOffset() {
    return this._offset;
  }
  
  @Pure
  public boolean isLeadingSemanticNewLine() {
    return this._leadingSemanticNewLine;
  }
  
  @Pure
  public int getNewLineCharCount() {
    return this._newLineCharCount;
  }
  
  @Pure
  public List<Chunk> getChunks() {
    return this._chunks;
  }
  
  @Pure
  public String getContent() {
    return this._content;
  }
  
  public void setContent(final String content) {
    this._content = content;
  }
  
  @Pure
  public int getIndentLength() {
    return this._indentLength;
  }
  
  public void setIndentLength(final int indentLength) {
    this._indentLength = indentLength;
  }
}
