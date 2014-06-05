package org.eclipse.xtext.xbase.formatting;

import java.util.List;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.xbase.formatting.CommentInfo;
import org.eclipse.xtext.xbase.formatting.HiddenLeafs;
import org.eclipse.xtext.xbase.formatting.LeafInfo;

@Data
@SuppressWarnings("all")
public class WhitespaceInfo extends LeafInfo {
  private final int _offset;
  
  public int getOffset() {
    return this._offset;
  }
  
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
      HiddenLeafs _container = this.getContainer();
      List<LeafInfo> _leafs = _container.getLeafs();
      int _indexOf = _leafs.indexOf(this);
      final int i = (_indexOf - 1);
      CommentInfo _xifexpression = null;
      if ((i >= 0)) {
        HiddenLeafs _container_1 = this.getContainer();
        List<LeafInfo> _leafs_1 = _container_1.getLeafs();
        LeafInfo _get = _leafs_1.get(i);
        _xifexpression = ((CommentInfo) _get);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CommentInfo trailingComment() {
    CommentInfo _xblockexpression = null;
    {
      HiddenLeafs _container = this.getContainer();
      List<LeafInfo> _leafs = _container.getLeafs();
      int _indexOf = _leafs.indexOf(this);
      final int i = (_indexOf + 1);
      CommentInfo _xifexpression = null;
      HiddenLeafs _container_1 = this.getContainer();
      List<LeafInfo> _leafs_1 = _container_1.getLeafs();
      int _size = _leafs_1.size();
      boolean _lessThan = (i < _size);
      if (_lessThan) {
        HiddenLeafs _container_2 = this.getContainer();
        List<LeafInfo> _leafs_2 = _container_2.getLeafs();
        LeafInfo _get = _leafs_2.get(i);
        _xifexpression = ((CommentInfo) _get);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("WS: \"");
    ILeafNode _node = this.getNode();
    String _text = null;
    if (_node!=null) {
      _text=_node.getText();
    }
    _builder.append(_text, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public WhitespaceInfo(final HiddenLeafs container, final ILeafNode node, final int newLines, final int offset) {
    super(container, node, newLines);
    this._offset = offset;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + this._offset;
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
    if (!super.equals(obj))
      return false;
    WhitespaceInfo other = (WhitespaceInfo) obj;
    if (other._offset != this._offset)
      return false;
    return true;
  }
}
