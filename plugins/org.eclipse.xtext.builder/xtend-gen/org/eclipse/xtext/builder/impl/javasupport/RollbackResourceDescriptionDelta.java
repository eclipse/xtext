/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.impl.javasupport;

import com.google.common.base.Preconditions;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

/**
 * <p>
 * Intances of this delta type are used to rollback unsubmitted deltas for the given primary type.
 * </p>
 */
@SuppressWarnings("all")
public class RollbackResourceDescriptionDelta implements Delta {
  private IType primaryType;
  
  public RollbackResourceDescriptionDelta(final IType primaryType) {
    Preconditions.<IType>checkNotNull(primaryType);
    this.primaryType = primaryType;
  }
  
  public String getPrimaryTypeName() {
    String _fullyQualifiedName = this.primaryType.getFullyQualifiedName();
    return _fullyQualifiedName;
  }
  
  public IResourceDescription getNew() {
    return null;
  }
  
  public IResourceDescription getOld() {
    return null;
  }
  
  public URI getUri() {
    return null;
  }
  
  public boolean haveEObjectDescriptionsChanged() {
    return false;
  }
}
