package org.eclipse.xtend.core.formatting;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.core.formatting.Chunk;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Data
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
  
  private final List<Chunk> _chunks = new Function0<List<Chunk>>() {
    public List<Chunk> apply() {
      ArrayList<Chunk> _newArrayList = CollectionLiterals.<Chunk>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public List<Chunk> getChunks() {
    return this._chunks;
  }
  
  public String toString() {
    String _xifexpression = null;
    boolean _isLeadingSemanticNewLine = this.isLeadingSemanticNewLine();
    if (_isLeadingSemanticNewLine) {
      _xifexpression = "SN";
    } else {
      _xifexpression = "TN";
    }
    List<Chunk> _chunks = this.getChunks();
    String _join = IterableExtensions.join(_chunks);
    String _plus = (_xifexpression + _join);
    return _plus;
  }
  
  public Line(final int offset, final boolean leadingSemanticNewLine, final int newLineCharCount) {
    super();
    this._offset = offset;
    this._leadingSemanticNewLine = leadingSemanticNewLine;
    this._newLineCharCount = newLineCharCount;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + _offset;
    result = prime * result + (_leadingSemanticNewLine ? 1231 : 1237);
    result = prime * result + _newLineCharCount;
    result = prime * result + ((_chunks== null) ? 0 : _chunks.hashCode());
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
    Line other = (Line) obj;
    if (other._offset != _offset)
      return false;
    if (other._leadingSemanticNewLine != _leadingSemanticNewLine)
      return false;
    if (other._newLineCharCount != _newLineCharCount)
      return false;
    if (_chunks == null) {
      if (other._chunks != null)
        return false;
    } else if (!_chunks.equals(other._chunks))
      return false;
    return true;
  }
}
