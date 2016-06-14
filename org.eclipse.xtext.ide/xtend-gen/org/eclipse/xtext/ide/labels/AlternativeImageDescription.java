/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.labels;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.ide.labels.IImageDescription;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class AlternativeImageDescription implements IImageDescription {
  private final List<String> imageIDs;
  
  public AlternativeImageDescription(final Iterable<String> imageIDs) {
    ImmutableList<String> _copyOf = ImmutableList.<String>copyOf(imageIDs);
    this.imageIDs = _copyOf;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.imageIDs== null) ? 0 : this.imageIDs.hashCode());
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
    AlternativeImageDescription other = (AlternativeImageDescription) obj;
    if (this.imageIDs == null) {
      if (other.imageIDs != null)
        return false;
    } else if (!this.imageIDs.equals(other.imageIDs))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("imageIDs", this.imageIDs);
    return b.toString();
  }
  
  @Pure
  public List<String> getImageIDs() {
    return this.imageIDs;
  }
}
