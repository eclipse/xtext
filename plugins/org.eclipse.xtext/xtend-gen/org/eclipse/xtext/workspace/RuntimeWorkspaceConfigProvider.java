/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.workspace;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider;
import org.eclipse.xtext.workspace.WorkspaceConfigAdapter;

@SuppressWarnings("all")
public class RuntimeWorkspaceConfigProvider implements IWorkspaceConfigProvider {
  @Override
  public IWorkspaceConfig getWorkspaceConfig(final Resource context) {
    IWorkspaceConfig _xblockexpression = null;
    {
      ResourceSet _resourceSet = context.getResourceSet();
      final EList<Adapter> adapters = _resourceSet.eAdapters();
      Adapter _adapter = EcoreUtil.getAdapter(adapters, WorkspaceConfigAdapter.class);
      final WorkspaceConfigAdapter adapter = ((WorkspaceConfigAdapter) _adapter);
      IWorkspaceConfig _workspaceConfig = null;
      if (adapter!=null) {
        _workspaceConfig=adapter.getWorkspaceConfig();
      }
      _xblockexpression = _workspaceConfig;
    }
    return _xblockexpression;
  }
}
