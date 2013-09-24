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
import org.eclipse.xtext.builder.impl.javasupport.UnsubmittedResourceDescriptionDelta;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

/**
 * <p>
 * Instances of this delta type could be rejected during confirmation of structural changes.
 * </p>
 */
@SuppressWarnings("all")
public class UnconfirmedStructuralChangesDelta extends UnsubmittedResourceDescriptionDelta {
  private int buildNumber = new Function0<Integer>() {
    public Integer apply() {
      int _minus = (-1);
      return _minus;
    }
  }.apply();
  
  private final IProject project;
  
  public UnconfirmedStructuralChangesDelta(final IProject project, final String primaryTypeName, final IResourceDescription old, final IResourceDescription _new) {
    super(primaryTypeName, old, _new);
    Preconditions.<IProject>checkNotNull(project);
    Preconditions.<IResourceDescription>checkNotNull(old);
    Preconditions.<IResourceDescription>checkNotNull(_new);
    this.project = project;
  }
  
  public int getBuildNumber() {
    return this.buildNumber;
  }
  
  public int setBuildNumber(final int buildNumber) {
    int _buildNumber = this.buildNumber = buildNumber;
    return _buildNumber;
  }
  
  public IProject getProject() {
    return this.project;
  }
}
