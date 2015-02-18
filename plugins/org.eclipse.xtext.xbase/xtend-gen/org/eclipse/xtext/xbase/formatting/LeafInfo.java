package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.xbase.formatting.HiddenLeafs;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Deprecated
@Data
@SuppressWarnings("all")
public abstract class LeafInfo {
  private final HiddenLeafs container;
  
  private final ILeafNode node;
  
  private final int newLines;
  
  public LeafInfo(final HiddenLeafs container, final ILeafNode node, final int newLines) {
    super();
    this.container = container;
    this.node = node;
    this.newLines = newLines;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.container== null) ? 0 : this.container.hashCode());
    result = prime * result + ((this.node== null) ? 0 : this.node.hashCode());
    result = prime * result + this.newLines;
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
    LeafInfo other = (LeafInfo) obj;
    if (this.container == null) {
      if (other.container != null)
        return false;
    } else if (!this.container.equals(other.container))
      return false;
    if (this.node == null) {
      if (other.node != null)
        return false;
    } else if (!this.node.equals(other.node))
      return false;
    if (other.newLines != this.newLines)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("container", this.container);
    b.add("node", this.node);
    b.add("newLines", this.newLines);
    return b.toString();
  }
  
  @Pure
  public HiddenLeafs getContainer() {
    return this.container;
  }
  
  @Pure
  public ILeafNode getNode() {
    return this.node;
  }
  
  @Pure
  public int getNewLines() {
    return this.newLines;
  }
}
