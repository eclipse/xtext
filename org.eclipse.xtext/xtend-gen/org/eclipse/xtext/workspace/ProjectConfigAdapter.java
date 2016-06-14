/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.workspace;

import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.xbase.lib.Pure;

@EmfAdaptable
@Accessors
@SuppressWarnings("all")
public class ProjectConfigAdapter {
  public static class ProjectConfigAdapterAdapter extends AdapterImpl {
    private ProjectConfigAdapter element;
    
    public ProjectConfigAdapterAdapter(final ProjectConfigAdapter element) {
      this.element = element;
    }
    
    public ProjectConfigAdapter get() {
      return this.element;
    }
    
    @Override
    public boolean isAdapterForType(final Object object) {
      return object == ProjectConfigAdapter.class;
    }
  }
  
  private final IProjectConfig projectConfig;
  
  protected ProjectConfigAdapter(final IProjectConfig projectConfig) {
    this.projectConfig = projectConfig;
  }
  
  public static void install(final ResourceSet resourceSet, final IProjectConfig config) {
    ProjectConfigAdapter _projectConfigAdapter = new ProjectConfigAdapter(config);
    _projectConfigAdapter.attachToEmfObject(resourceSet);
  }
  
  public static ProjectConfigAdapter findInEmfObject(final Notifier emfObject) {
    for (Adapter adapter : emfObject.eAdapters()) {
    	if (adapter instanceof ProjectConfigAdapter.ProjectConfigAdapterAdapter) {
    		return ((ProjectConfigAdapter.ProjectConfigAdapterAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public static ProjectConfigAdapter removeFromEmfObject(final Notifier emfObject) {
    List<Adapter> adapters = emfObject.eAdapters();
    for(int i = 0, max = adapters.size(); i < max; i++) {
    	Adapter adapter = adapters.get(i);
    	if (adapter instanceof ProjectConfigAdapter.ProjectConfigAdapterAdapter) {
    		emfObject.eAdapters().remove(i);
    		return ((ProjectConfigAdapter.ProjectConfigAdapterAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public void attachToEmfObject(final Notifier emfObject) {
    ProjectConfigAdapter result = findInEmfObject(emfObject);
    if (result != null)
    	throw new IllegalStateException("The given EMF object already contains an adapter for ProjectConfigAdapter");
    ProjectConfigAdapter.ProjectConfigAdapterAdapter adapter = new ProjectConfigAdapter.ProjectConfigAdapterAdapter(this);
    emfObject.eAdapters().add(adapter);
  }
  
  @Pure
  public IProjectConfig getProjectConfig() {
    return this.projectConfig;
  }
}
