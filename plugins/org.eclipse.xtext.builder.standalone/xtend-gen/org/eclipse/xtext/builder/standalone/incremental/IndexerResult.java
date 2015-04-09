/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.9
 */
@Data
@SuppressWarnings("all")
public class IndexerResult {
  private final List<URI> changedResources;
  
  private final List<URI> deletedResources;
  
  private final ResourceDescriptionsData newIndex;
  
  public IndexerResult(final List<URI> changedResources, final List<URI> deletedResources, final ResourceDescriptionsData newIndex) {
    super();
    this.changedResources = changedResources;
    this.deletedResources = deletedResources;
    this.newIndex = newIndex;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.changedResources== null) ? 0 : this.changedResources.hashCode());
    result = prime * result + ((this.deletedResources== null) ? 0 : this.deletedResources.hashCode());
    result = prime * result + ((this.newIndex== null) ? 0 : this.newIndex.hashCode());
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
    IndexerResult other = (IndexerResult) obj;
    if (this.changedResources == null) {
      if (other.changedResources != null)
        return false;
    } else if (!this.changedResources.equals(other.changedResources))
      return false;
    if (this.deletedResources == null) {
      if (other.deletedResources != null)
        return false;
    } else if (!this.deletedResources.equals(other.deletedResources))
      return false;
    if (this.newIndex == null) {
      if (other.newIndex != null)
        return false;
    } else if (!this.newIndex.equals(other.newIndex))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("changedResources", this.changedResources);
    b.add("deletedResources", this.deletedResources);
    b.add("newIndex", this.newIndex);
    return b.toString();
  }
  
  @Pure
  public List<URI> getChangedResources() {
    return this.changedResources;
  }
  
  @Pure
  public List<URI> getDeletedResources() {
    return this.deletedResources;
  }
  
  @Pure
  public ResourceDescriptionsData getNewIndex() {
    return this.newIndex;
  }
}
