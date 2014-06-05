package org.eclipse.xtext.xbase.formatting;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.xbase.formatting.CommentInfo;
import org.eclipse.xtext.xbase.formatting.LeafInfo;
import org.eclipse.xtext.xbase.formatting.WhitespaceInfo;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class HiddenLeafs {
  private final int _offset;
  
  public int getOffset() {
    return this._offset;
  }
  
  private final List<LeafInfo> _leafs = CollectionLiterals.<LeafInfo>newArrayList();
  
  public List<LeafInfo> getLeafs() {
    return this._leafs;
  }
  
  public boolean isSingleWhitespace() {
    boolean _or = false;
    List<LeafInfo> _leafs = this.getLeafs();
    boolean _isEmpty = _leafs.isEmpty();
    if (_isEmpty) {
      _or = true;
    } else {
      boolean _and = false;
      List<LeafInfo> _leafs_1 = this.getLeafs();
      int _size = _leafs_1.size();
      boolean _equals = (_size == 1);
      if (!_equals) {
        _and = false;
      } else {
        List<LeafInfo> _leafs_2 = this.getLeafs();
        LeafInfo _head = IterableExtensions.<LeafInfo>head(_leafs_2);
        _and = (_head instanceof WhitespaceInfo);
      }
      _or = _and;
    }
    return _or;
  }
  
  public int getLenght() {
    List<LeafInfo> _leafs = this.getLeafs();
    final Function2<Integer, LeafInfo, Integer> _function = new Function2<Integer, LeafInfo, Integer>() {
      public Integer apply(final Integer x, final LeafInfo i) {
        ILeafNode _node = i.getNode();
        int _length = 0;
        if (_node!=null) {
          _length=_node.getLength();
        }
        return Integer.valueOf(((x).intValue() + _length));
      }
    };
    return (int) IterableExtensions.<LeafInfo, Integer>fold(_leafs, Integer.valueOf(0), _function);
  }
  
  public int getNewLines() {
    List<LeafInfo> _leafs = this.getLeafs();
    final Function2<Integer, LeafInfo, Integer> _function = new Function2<Integer, LeafInfo, Integer>() {
      public Integer apply(final Integer x, final LeafInfo i) {
        int _newLines = i.getNewLines();
        return Integer.valueOf(((x).intValue() + _newLines));
      }
    };
    return (int) IterableExtensions.<LeafInfo, Integer>fold(_leafs, Integer.valueOf(0), _function);
  }
  
  public int getNewLinesInComments() {
    List<LeafInfo> _leafs = this.getLeafs();
    Iterable<CommentInfo> _filter = Iterables.<CommentInfo>filter(_leafs, CommentInfo.class);
    final Function2<Integer, CommentInfo, Integer> _function = new Function2<Integer, CommentInfo, Integer>() {
      public Integer apply(final Integer x, final CommentInfo i) {
        int _newLines = i.getNewLines();
        return Integer.valueOf(((x).intValue() + _newLines));
      }
    };
    return (int) IterableExtensions.<CommentInfo, Integer>fold(_filter, Integer.valueOf(0), _function);
  }
  
  public boolean containsComment() {
    List<LeafInfo> _leafs = this.getLeafs();
    Iterable<CommentInfo> _filter = Iterables.<CommentInfo>filter(_leafs, CommentInfo.class);
    int _size = IterableExtensions.size(_filter);
    return (_size > 0);
  }
  
  public HiddenLeafs(final int offset) {
    super();
    this._offset = offset;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this._offset;
    result = prime * result + ((this._leafs== null) ? 0 : this._leafs.hashCode());
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
    HiddenLeafs other = (HiddenLeafs) obj;
    if (other._offset != this._offset)
      return false;
    if (this._leafs == null) {
      if (other._leafs != null)
        return false;
    } else if (!this._leafs.equals(other._leafs))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
