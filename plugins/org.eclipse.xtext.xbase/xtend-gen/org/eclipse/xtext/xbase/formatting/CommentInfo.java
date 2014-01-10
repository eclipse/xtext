package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.xbase.formatting.HiddenLeafs;
import org.eclipse.xtext.xbase.formatting.LeafInfo;

@Data
@SuppressWarnings("all")
public class CommentInfo extends LeafInfo {
  private final boolean _trailing;
  
  public boolean isTrailing() {
    return this._trailing;
  }
  
  public boolean endsWithNewLine() {
    ILeafNode _node = this.getNode();
    String _text = _node.getText();
    return _text.endsWith("\n");
  }
  
  public boolean isMultiline() {
    boolean _and = false;
    boolean _endsWithNewLine = this.endsWithNewLine();
    boolean _not = (!_endsWithNewLine);
    if (!_not) {
      _and = false;
    } else {
      ILeafNode _node = this.getNode();
      String _text = _node.getText();
      boolean _contains = _text.contains("\n");
      _and = _contains;
    }
    return _and;
  }
  
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Comment: \"");
    ILeafNode _node = this.getNode();
    String _text = _node.getText();
    _builder.append(_text, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public CommentInfo(final HiddenLeafs container, final ILeafNode node, final int newLines, final boolean trailing) {
    super(container, node, newLines);
    this._trailing = trailing;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + (_trailing ? 1231 : 1237);
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
    CommentInfo other = (CommentInfo) obj;
    if (other._trailing != _trailing)
      return false;
    return true;
  }
}
