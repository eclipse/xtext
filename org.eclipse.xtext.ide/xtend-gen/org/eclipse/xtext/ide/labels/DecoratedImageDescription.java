/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
public class DecoratedImageDescription implements IImageDescription {
  private final IImageDescription baseImage;
  
  private final List<IImageDescription> decorators;
  
  public DecoratedImageDescription(final IImageDescription baseImage, final IImageDescription... decorators) {
    this.baseImage = baseImage;
    this.decorators = ImmutableList.<IImageDescription>copyOf(decorators);
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.baseImage== null) ? 0 : this.baseImage.hashCode());
    return prime * result + ((this.decorators== null) ? 0 : this.decorators.hashCode());
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
    DecoratedImageDescription other = (DecoratedImageDescription) obj;
    if (this.baseImage == null) {
      if (other.baseImage != null)
        return false;
    } else if (!this.baseImage.equals(other.baseImage))
      return false;
    if (this.decorators == null) {
      if (other.decorators != null)
        return false;
    } else if (!this.decorators.equals(other.decorators))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("baseImage", this.baseImage);
    b.add("decorators", this.decorators);
    return b.toString();
  }
  
  @Pure
  public IImageDescription getBaseImage() {
    return this.baseImage;
  }
  
  @Pure
  public List<IImageDescription> getDecorators() {
    return this.decorators;
  }
}
