/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.impl.javasupport;

import com.google.common.base.Preconditions;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;

/**
 * <p>
 * Instances of this delta type could be rejected during confirmation of structural changes.
 * </p>
 */
@SuppressWarnings("all")
public class UnconfirmedStructuralChangesDelta extends ChangedResourceDescriptionDelta {
  private int buildNumber = (-1);
  
  private final IType type;
  
  public UnconfirmedStructuralChangesDelta(final IType type, final IResourceDescription old, final IResourceDescription _new) {
    super(old, _new);
    Preconditions.<IType>checkNotNull(type);
    Preconditions.<IResourceDescription>checkNotNull(old);
    Preconditions.<IResourceDescription>checkNotNull(_new);
    this.type = type;
  }
  
  public int getBuildNumber() {
    return this.buildNumber;
  }
  
  public int setBuildNumber(final int buildNumber) {
    return this.buildNumber = buildNumber;
  }
  
  public IProject getProject() {
    IJavaProject _javaProject = this.type.getJavaProject();
    return _javaProject.getProject();
  }
}
