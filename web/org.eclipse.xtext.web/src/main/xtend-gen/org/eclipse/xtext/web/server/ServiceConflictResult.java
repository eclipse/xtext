/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * A service result object indicating that a conflict has occurred an thus the original
 * request could not be completed. This result type is used to avoid responses with
 * error codes for conflict situations that can happen relatively often, e.g. when
 * multiple requests are sent within a short amount of time.
 */
@Data
@SuppressWarnings("all")
public class ServiceConflictResult implements IServiceResult {
  /**
   * A descriptor of the reason for the conflict. Commonly used values are "invalidStateId"
   * for cases when the <i>requiredStateId</i> parameter does not match the current document state,
   * and "canceled" when the service has been interrupted by another service request.
   */
  private final String conflict;
  
  public ServiceConflictResult(final String conflict) {
    super();
    this.conflict = conflict;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.conflict== null) ? 0 : this.conflict.hashCode());
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
    ServiceConflictResult other = (ServiceConflictResult) obj;
    if (this.conflict == null) {
      if (other.conflict != null)
        return false;
    } else if (!this.conflict.equals(other.conflict))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("conflict", this.conflict);
    return b.toString();
  }
  
  @Pure
  public String getConflict() {
    return this.conflict;
  }
}
