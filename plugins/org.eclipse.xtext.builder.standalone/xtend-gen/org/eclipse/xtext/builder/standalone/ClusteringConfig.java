/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone;

import org.eclipse.xtend.lib.ValueObject;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Holger Schill - Initial contribution and API
 */
@ValueObject
@SuppressWarnings("all")
public final class ClusteringConfig {
  /**
   * Minimum free memory in MB.
   */
  private final long minimumFreeMemory;
  
  /**
   * Minimum cluster size. To force garbage collector to kick in.
   */
  private final int minimumClusterSize;
  
  /**
   * Minimum percentage of memory that must be free before trying to load another resource.
   */
  private final long minimumPercentFreeMemory;
  
  public ClusteringConfig(final long minimumFreeMemory, final int minimumClusterSize, final long minimumPercentFreeMemory) {
    this.minimumFreeMemory = minimumFreeMemory;
    this.minimumClusterSize = minimumClusterSize;
    this.minimumPercentFreeMemory = minimumPercentFreeMemory;
  }
  
  @Override
  @Pure
  public String toString() {
    StringBuilder b = new StringBuilder("ClusteringConfig");
    b.append("{");
    b.append("minimumFreeMemory=");
    b.append(this.minimumFreeMemory);
    b.append(", ");
    b.append("minimumClusterSize=");
    b.append(this.minimumClusterSize);
    b.append(", ");
    b.append("minimumPercentFreeMemory=");
    b.append(this.minimumPercentFreeMemory);
    b.append("}");
    return b.toString();
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
    ClusteringConfig other = (ClusteringConfig) obj;
    if (other.minimumFreeMemory != this.minimumFreeMemory)
      return false;
    if (other.minimumClusterSize != this.minimumClusterSize)
      return false;
    if (other.minimumPercentFreeMemory != this.minimumPercentFreeMemory)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (this.minimumFreeMemory ^ (this.minimumFreeMemory >>> 32));
    result = prime * result + this.minimumClusterSize;
    result = prime * result + (int) (this.minimumPercentFreeMemory ^ (this.minimumPercentFreeMemory >>> 32));
    return result;
  }
  
  @Pure
  public long getMinimumFreeMemory() {
    return this.minimumFreeMemory;
  }
  
  @Pure
  public int getMinimumClusterSize() {
    return this.minimumClusterSize;
  }
  
  @Pure
  public long getMinimumPercentFreeMemory() {
    return this.minimumPercentFreeMemory;
  }
}
