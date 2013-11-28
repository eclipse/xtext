package org.eclipse.xtend.core.formatting;

import java.util.List;
import org.eclipse.xtend.core.formatting.Chunk;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Line {
  private final int _offset;
  
  public int getOffset() {
    return this._offset;
  }
  
  private final boolean _leadingSemanticNewLine;
  
  public boolean isLeadingSemanticNewLine() {
    return this._leadingSemanticNewLine;
  }
  
  private final int _newLineCharCount;
  
  public int getNewLineCharCount() {
    return this._newLineCharCount;
  }
  
  private final List<Chunk> _chunks = CollectionLiterals.<Chunk>newArrayList();
  
  public List<Chunk> getChunks() {
    return this._chunks;
  }
  
  private String _content;
  
  public String getContent() {
    return this._content;
  }
  
  public void setContent(final String content) {
    this._content = content;
  }
  
  private int _indentLength;
  
  public int getIndentLength() {
    return this._indentLength;
  }
  
  public void setIndentLength(final int indentLength) {
    this._indentLength = indentLength;
  }
  
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
    String _plus_2 = (_plus_1 + _content);
    return _plus_2;
  }
}
