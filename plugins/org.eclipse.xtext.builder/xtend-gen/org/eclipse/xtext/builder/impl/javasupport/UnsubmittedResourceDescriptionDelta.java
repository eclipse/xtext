/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.impl.javasupport;

import com.google.common.base.Preconditions;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;

/**
 * <p>
 * Instances of this delta type are collected for the given primary type during reconcilation.
 * </p>
 */
@SuppressWarnings("all")
public class UnsubmittedResourceDescriptionDelta extends DefaultResourceDescriptionDelta {
  private final String primaryTypeName;
  
  public UnsubmittedResourceDescriptionDelta(final String primaryTypeName, final IResourceDescription old, final IResourceDescription _new) {
    super(old, _new);
    Preconditions.<String>checkNotNull(primaryTypeName);
    this.primaryTypeName = primaryTypeName;
  }
  
  public String getPrimaryTypeName() {
    return this.primaryTypeName;
  }
}
