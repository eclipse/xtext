/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy.AssociationHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.findrefs.EditorResourceAccess;
import org.eclipse.xtext.ui.editor.hierarchy.AbstractOpenHierarchyHandler;
import org.eclipse.xtext.ui.editor.hierarchy.DeferredHierarchyBuilder;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class OpenAssociationHierarchyHandler extends AbstractOpenHierarchyHandler {
  private final static String HIERARCHY_VIEW_PART_ID = "org.eclipse.xtext.example.domainmodel.ui.editor.AssociationHierarchy";
  
  @Inject
  @Extension
  private IGlobalServiceProvider _iGlobalServiceProvider;
  
  @Inject
  private EditorResourceAccess resourceAccess;
  
  @Override
  protected String getHierarchyViewPartID() {
    return OpenAssociationHierarchyHandler.HIERARCHY_VIEW_PART_ID;
  }
  
  @Override
  protected IHierarchyBuilder createHierarchyBuilder(final EObject target) {
    final AssociationHierarchyBuilder xtextCallHierarchyBuilder = this._iGlobalServiceProvider.<AssociationHierarchyBuilder>findService(target, AssociationHierarchyBuilder.class);
    xtextCallHierarchyBuilder.setResourceAccess(this.resourceAccess);
    IResourceDescriptions _findService = this._iGlobalServiceProvider.<IResourceDescriptions>findService(target, IResourceDescriptions.class);
    xtextCallHierarchyBuilder.setIndexData(_findService);
    final DeferredHierarchyBuilder deferredHierarchyBuilder = this._iGlobalServiceProvider.<DeferredHierarchyBuilder>findService(target, DeferredHierarchyBuilder.class);
    deferredHierarchyBuilder.setHierarchyBuilder(xtextCallHierarchyBuilder);
    return deferredHierarchyBuilder;
  }
}
