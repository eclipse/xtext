package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.xbase.formatting.HiddenLeafs;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public abstract class LeafInfo {
  private final HiddenLeafs _container;
  
  public HiddenLeafs getContainer() {
    return this._container;
  }
  
  private final ILeafNode _node;
  
  public ILeafNode getNode() {
    return this._node;
  }
  
  private final int _newLines;
  
  public int getNewLines() {
    return this._newLines;
  }
  
  public LeafInfo(final HiddenLeafs container, final ILeafNode node, final int newLines) {
    super();
    this._container = container;
    this._node = node;
    this._newLines = newLines;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._container== null) ? 0 : this._container.hashCode());
    result = prime * result + ((this._node== null) ? 0 : this._node.hashCode());
    result = prime * result + this._newLines;
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
    LeafInfo other = (LeafInfo) obj;
    if (this._container == null) {
      if (other._container != null)
        return false;
    } else if (!this._container.equals(other._container))
      return false;
    if (this._node == null) {
      if (other._node != null)
        return false;
    } else if (!this._node.equals(other._node))
      return false;
    if (other._newLines != this._newLines)
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
