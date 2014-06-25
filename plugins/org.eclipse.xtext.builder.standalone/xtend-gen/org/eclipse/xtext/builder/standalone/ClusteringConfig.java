/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

/**
 * @author Holger Schill - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class ClusteringConfig {
  /**
   * Minimum free memory in MB.
   */
  private final long _minimumFreeMemory;
  
  /**
   * Minimum cluster size. To force garbage collector to kick in.
   */
  private final int _minimumClusterSize;
  
  /**
   * Minimum percentage of memory that must be free before trying to load another resource.
   */
  private final long _minimumPercentFreeMemory;
  
  public ClusteringConfig(final long minimumFreeMemory, final int minimumClusterSize, final long minimumPercentFreeMemory) {
    super();
    this._minimumFreeMemory = minimumFreeMemory;
    this._minimumClusterSize = minimumClusterSize;
    this._minimumPercentFreeMemory = minimumPercentFreeMemory;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (this._minimumFreeMemory ^ (this._minimumFreeMemory >>> 32));
    result = prime * result + this._minimumClusterSize;
    result = prime * result + (int) (this._minimumPercentFreeMemory ^ (this._minimumPercentFreeMemory >>> 32));
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
    ClusteringConfig other = (ClusteringConfig) obj;
    if (other._minimumFreeMemory != this._minimumFreeMemory)
      return false;
    if (other._minimumClusterSize != this._minimumClusterSize)
      return false;
    if (other._minimumPercentFreeMemory != this._minimumPercentFreeMemory)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
  
  @Pure
  public long getMinimumFreeMemory() {
    return this._minimumFreeMemory;
  }
  
  @Pure
  public int getMinimumClusterSize() {
    return this._minimumClusterSize;
  }
  
  @Pure
  public long getMinimumPercentFreeMemory() {
    return this._minimumPercentFreeMemory;
  }
}
