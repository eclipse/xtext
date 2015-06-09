/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.google.common.base.Objects;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.idea.build.XtextCompilerComponent;
import org.eclipse.xtext.idea.resource.ModuleProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

@SuppressWarnings("all")
public class IdeaResourceDescriptionsProvider extends ResourceDescriptionsProvider {
  @Override
  public IResourceDescriptions getResourceDescriptions(final Resource resource) {
    ResourceSet _resourceSet = resource.getResourceSet();
    return this.getResourceDescriptions(_resourceSet);
  }
  
  @Override
  public IResourceDescriptions getResourceDescriptions(final ResourceSet resourceSet) {
    final ResourceDescriptionsData installedData = ResourceDescriptionsData.ResourceSetAdapter.findResourceDescriptionsData(resourceSet);
    boolean _notEquals = (!Objects.equal(installedData, null));
    if (_notEquals) {
      return installedData;
    }
    final Module module = ModuleProvider.findModule(resourceSet);
    Project _project = module.getProject();
    final XtextCompilerComponent compiler = _project.<XtextCompilerComponent>getComponent(XtextCompilerComponent.class);
    return compiler.getResourceDescriptions();
  }
}
