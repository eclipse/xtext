package org.eclipse.xtend.core.formatting;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.core.formatting.Chunk;
import org.eclipse.xtend.core.formatting.Line;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@Data
@SuppressWarnings("all")
public class LineModel {
  private final RichString _richString;
  
  public RichString getRichString() {
    return this._richString;
  }
  
  private final List<Chunk> _firstLine = new Function0<List<Chunk>>() {
    public List<Chunk> apply() {
      ArrayList<Chunk> _newArrayList = CollectionLiterals.<Chunk>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public List<Chunk> getFirstLine() {
    return this._firstLine;
  }
  
  private final List<Line> _otherLines = new Function0<List<Line>>() {
    public List<Line> apply() {
      ArrayList<Line> _newArrayList = CollectionLiterals.<Line>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public List<Line> getOtherLines() {
    return this._otherLines;
  }
  
  public String toString() {
    List<Chunk> _firstLine = this.getFirstLine();
    String _join = IterableExtensions.join(_firstLine);
    List<Line> _otherLines = this.getOtherLines();
    final Function1<Line,String> _function = new Function1<Line,String>() {
        public String apply(final Line it) {
          String _plus = ("\n" + it);
          return _plus;
        }
      };
    List<String> _map = ListExtensions.<Line, String>map(_otherLines, _function);
    String _join_1 = IterableExtensions.join(_map);
    String _plus = (_join + _join_1);
    return _plus;
  }
  
  public LineModel(final RichString richString) {
    super();
    this._richString = richString;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_richString== null) ? 0 : _richString.hashCode());
    result = prime * result + ((_firstLine== null) ? 0 : _firstLine.hashCode());
    result = prime * result + ((_otherLines== null) ? 0 : _otherLines.hashCode());
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
    LineModel other = (LineModel) obj;
    if (_richString == null) {
      if (other._richString != null)
        return false;
    } else if (!_richString.equals(other._richString))
      return false;
    if (_firstLine == null) {
      if (other._firstLine != null)
        return false;
    } else if (!_firstLine.equals(other._firstLine))
      return false;
    if (_otherLines == null) {
      if (other._otherLines != null)
        return false;
    } else if (!_otherLines.equals(other._otherLines))
      return false;
    return true;
  }
}
