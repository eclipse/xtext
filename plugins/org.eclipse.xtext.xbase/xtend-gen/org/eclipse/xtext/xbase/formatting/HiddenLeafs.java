package org.eclipse.xtext.xbase.formatting;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.xbase.formatting.CommentInfo;
import org.eclipse.xtext.xbase.formatting.LeafInfo;
import org.eclipse.xtext.xbase.formatting.WhitespaceInfo;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Deprecated
@Data
@SuppressWarnings("all")
public class HiddenLeafs {
  private final int offset;
  
  private final List<LeafInfo> leafs = CollectionLiterals.<LeafInfo>newArrayList();
  
  public boolean isSingleWhitespace() {
    return (this.leafs.isEmpty() || ((this.leafs.size() == 1) && (IterableExtensions.<LeafInfo>head(this.leafs) instanceof WhitespaceInfo)));
  }
  
  public int getLenght() {
    final Function2<Integer, LeafInfo, Integer> _function = new Function2<Integer, LeafInfo, Integer>() {
      @Override
      public Integer apply(final Integer x, final LeafInfo i) {
        ILeafNode _node = i.getNode();
        int _length = 0;
        if (_node!=null) {
          _length=_node.getLength();
        }
        return Integer.valueOf(((x).intValue() + _length));
      }
    };
    return (int) IterableExtensions.<LeafInfo, Integer>fold(this.leafs, Integer.valueOf(0), _function);
  }
  
  public int getNewLines() {
    final Function2<Integer, LeafInfo, Integer> _function = new Function2<Integer, LeafInfo, Integer>() {
      @Override
      public Integer apply(final Integer x, final LeafInfo i) {
        int _newLines = i.getNewLines();
        return Integer.valueOf(((x).intValue() + _newLines));
      }
    };
    return (int) IterableExtensions.<LeafInfo, Integer>fold(this.leafs, Integer.valueOf(0), _function);
  }
  
  public int getNewLinesInComments() {
    Iterable<CommentInfo> _filter = Iterables.<CommentInfo>filter(this.leafs, CommentInfo.class);
    final Function2<Integer, CommentInfo, Integer> _function = new Function2<Integer, CommentInfo, Integer>() {
      @Override
      public Integer apply(final Integer x, final CommentInfo i) {
        int _newLines = i.getNewLines();
        return Integer.valueOf(((x).intValue() + _newLines));
      }
    };
    return (int) IterableExtensions.<CommentInfo, Integer>fold(_filter, Integer.valueOf(0), _function);
  }
  
  public boolean containsComment() {
    Iterable<CommentInfo> _filter = Iterables.<CommentInfo>filter(this.leafs, CommentInfo.class);
    int _size = IterableExtensions.size(_filter);
    return (_size > 0);
  }
  
  public HiddenLeafs(final int offset) {
    super();
    this.offset = offset;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.offset;
    result = prime * result + ((this.leafs== null) ? 0 : this.leafs.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    HiddenLeafs other = (HiddenLeafs) obj;
    if (other.offset != this.offset)
      return false;
    if (this.leafs == null) {
      if (other.leafs != null)
        return false;
    } else if (!this.leafs.equals(other.leafs))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("offset", this.offset);
    b.add("leafs", this.leafs);
    return b.toString();
  }
  
  @Pure
  public int getOffset() {
    return this.offset;
  }
  
  @Pure
  public List<LeafInfo> getLeafs() {
    return this.leafs;
  }
}
