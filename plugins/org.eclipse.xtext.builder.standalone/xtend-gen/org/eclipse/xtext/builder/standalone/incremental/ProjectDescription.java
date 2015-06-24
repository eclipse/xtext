/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
@EmfAdaptable
@SuppressWarnings("all")
public class ProjectDescription {
  public static class ProjectDescriptionAdapter extends AdapterImpl {
    private ProjectDescription element;
    
    public ProjectDescriptionAdapter(final ProjectDescription element) {
      this.element = element;
    }
    
    public ProjectDescription get() {
      return this.element;
    }
    
    public boolean isAdapterForType(final Object object) {
      return object == ProjectDescription.class;
    }
  }
  
  /**
   * A unique name for this project
   */
  @Accessors
  private String name;
  
  /**
   * list of logical names of upstream dependencies
   */
  @Accessors
  private List<String> dependencies;
  
  public static ProjectDescription findInEmfObject(final Notifier emfObject) {
    for (Adapter adapter : emfObject.eAdapters()) {
    	if (adapter instanceof org.eclipse.xtext.builder.standalone.incremental.ProjectDescription.ProjectDescriptionAdapter) {
    		return ((org.eclipse.xtext.builder.standalone.incremental.ProjectDescription.ProjectDescriptionAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public void attachToEmfObject(final Notifier emfObject) {
    ProjectDescription result = findInEmfObject(emfObject);
    if (result != null)
    	throw new IllegalStateException("The given EMF object already contains an adapter for ProjectDescription");
    org.eclipse.xtext.builder.standalone.incremental.ProjectDescription.ProjectDescriptionAdapter adapter = new org.eclipse.xtext.builder.standalone.incremental.ProjectDescription.ProjectDescriptionAdapter(this);
    emfObject.eAdapters().add(adapter);
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public List<String> getDependencies() {
    return this.dependencies;
  }
  
  public void setDependencies(final List<String> dependencies) {
    this.dependencies = dependencies;
  }
}
