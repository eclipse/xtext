/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.labels;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.ide.labels.IImageDescription;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class SimpleImageDescription implements IImageDescription {
  private final String imageID;
  
  public SimpleImageDescription(final String imageID) {
    super();
    this.imageID = imageID;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.imageID== null) ? 0 : this.imageID.hashCode());
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
    SimpleImageDescription other = (SimpleImageDescription) obj;
    if (this.imageID == null) {
      if (other.imageID != null)
        return false;
    } else if (!this.imageID.equals(other.imageID))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("imageID", this.imageID);
    return b.toString();
  }
  
  @Pure
  public String getImageID() {
    return this.imageID;
  }
}
