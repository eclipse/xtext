package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.xbase.formatting.CommentInfo;
import org.eclipse.xtext.xbase.formatting.HiddenLeafs;
import org.eclipse.xtext.xbase.formatting.LeafInfo;
import org.eclipse.xtext.xbase.lib.Pure;

@Deprecated
@Data
@SuppressWarnings("all")
public class WhitespaceInfo extends LeafInfo {
  private final int offset;
  
  public int getLength() {
    ILeafNode _node = this.getNode();
    int _length = 0;
    if (_node!=null) {
      _length=_node.getLength();
    }
    return _length;
  }
  
  public CommentInfo leadingComment() {
    CommentInfo _xblockexpression = null;
    {
      int _indexOf = this.getContainer().getLeafs().indexOf(this);
      final int i = (_indexOf - 1);
      CommentInfo _xifexpression = null;
      if ((i >= 0)) {
        LeafInfo _get = this.getContainer().getLeafs().get(i);
        _xifexpression = ((CommentInfo) _get);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CommentInfo trailingComment() {
    CommentInfo _xblockexpression = null;
    {
      int _indexOf = this.getContainer().getLeafs().indexOf(this);
      final int i = (_indexOf + 1);
      CommentInfo _xifexpression = null;
      int _size = this.getContainer().getLeafs().size();
      boolean _lessThan = (i < _size);
      if (_lessThan) {
        LeafInfo _get = this.getContainer().getLeafs().get(i);
        _xifexpression = ((CommentInfo) _get);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("WS: \"");
    ILeafNode _node = this.getNode();
    String _text = null;
    if (_node!=null) {
      _text=_node.getText();
    }
    _builder.append(_text);
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public WhitespaceInfo(final HiddenLeafs container, final ILeafNode node, final int newLines, final int offset) {
    super(container, node, newLines);
    this.offset = offset;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * super.hashCode() + this.offset;
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
    if (!super.equals(obj))
      return false;
    WhitespaceInfo other = (WhitespaceInfo) obj;
    if (other.offset != this.offset)
      return false;
    return true;
  }
  
  @Pure
  public int getOffset() {
    return this.offset;
  }
}
