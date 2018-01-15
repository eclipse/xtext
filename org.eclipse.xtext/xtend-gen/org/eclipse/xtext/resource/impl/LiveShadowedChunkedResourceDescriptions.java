/**
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.impl;

import com.google.inject.Inject;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.LiveShadowedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.14
 */
@SuppressWarnings("all")
public class LiveShadowedChunkedResourceDescriptions extends LiveShadowedResourceDescriptions {
  @Inject(optional = true)
  private IProjectConfigProvider projectConfigProvider;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IWorkspaceConfig workspaceConfig;
  
  @Override
  public void setContext(final Notifier ctx) {
    IResourceDescriptions _localDescriptions = this.getLocalDescriptions();
    final Procedure1<ResourceSetBasedResourceDescriptions> _function = (ResourceSetBasedResourceDescriptions it) -> {
      it.setContext(ctx);
      it.setData(null);
    };
    ObjectExtensions.<ResourceSetBasedResourceDescriptions>operator_doubleArrow(((ResourceSetBasedResourceDescriptions) _localDescriptions), _function);
    final ResourceSet resourceSet = EcoreUtil2.getResourceSet(ctx);
    this.setGlobalDescriptions(ChunkedResourceDescriptions.findInEmfObject(resourceSet));
    IProjectConfig _projectConfig = null;
    if (this.projectConfigProvider!=null) {
      _projectConfig=this.projectConfigProvider.getProjectConfig(resourceSet);
    }
    IWorkspaceConfig _workspaceConfig = null;
    if (_projectConfig!=null) {
      _workspaceConfig=_projectConfig.getWorkspaceConfig();
    }
    this.workspaceConfig = _workspaceConfig;
  }
  
  @Pure
  public IWorkspaceConfig getWorkspaceConfig() {
    return this.workspaceConfig;
  }
}
