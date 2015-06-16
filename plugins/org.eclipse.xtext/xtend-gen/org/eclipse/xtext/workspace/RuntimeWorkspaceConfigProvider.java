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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider;
import org.eclipse.xtext.workspace.NullWorkspaceConfig;
import org.eclipse.xtext.workspace.WorkspaceConfigAdapter;

@SuppressWarnings("all")
public class RuntimeWorkspaceConfigProvider implements IWorkspaceConfigProvider {
  @Override
  public IWorkspaceConfig getWorkspaceConfig(final ResourceSet context) {
    IWorkspaceConfig _xblockexpression = null;
    {
      final EList<Adapter> adapters = context.eAdapters();
      Adapter _adapter = EcoreUtil.getAdapter(adapters, WorkspaceConfigAdapter.class);
      final WorkspaceConfigAdapter adapter = ((WorkspaceConfigAdapter) _adapter);
      IWorkspaceConfig _elvis = null;
      IWorkspaceConfig _workspaceConfig = null;
      if (adapter!=null) {
        _workspaceConfig=adapter.getWorkspaceConfig();
      }
      if (_workspaceConfig != null) {
        _elvis = _workspaceConfig;
      } else {
        NullWorkspaceConfig _nullWorkspaceConfig = new NullWorkspaceConfig();
        _elvis = _nullWorkspaceConfig;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
}
