/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package example4;

import java.util.ArrayList;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class Node {
  private final ArrayList<Node> contents = CollectionLiterals.<Node>newArrayList();
  
  public String tagName() {
    return this.getClass().getSimpleName().toLowerCase();
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.contents== null) ? 0 : this.contents.hashCode());
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
    Node other = (Node) obj;
    if (this.contents == null) {
      if (other.contents != null)
        return false;
    } else if (!this.contents.equals(other.contents))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("contents", this.contents);
    return b.toString();
  }
  
  @Pure
  public ArrayList<Node> getContents() {
    return this.contents;
  }
}
