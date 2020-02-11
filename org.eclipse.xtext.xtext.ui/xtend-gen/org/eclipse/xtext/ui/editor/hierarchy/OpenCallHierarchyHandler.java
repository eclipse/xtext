/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.findrefs.EditorResourceAccess;
import org.eclipse.xtext.ui.editor.hierarchy.AbstractOpenHierarchyHandler;
import org.eclipse.xtext.ui.editor.hierarchy.DeferredHierarchyBuilder;
import org.eclipse.xtext.ui.editor.hierarchy.XtextCallHierarchyBuilder;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public class OpenCallHierarchyHandler extends AbstractOpenHierarchyHandler {
  public static final String HIERARCHY_VIEW_PART_ID = "org.eclipse.xtext.ui.XtextCallHierarchy";
  
  @Inject
  @Extension
  private IGlobalServiceProvider _iGlobalServiceProvider;
  
  @Inject
  private EditorResourceAccess resourceAccess;
  
  @Override
  protected String getHierarchyViewPartID() {
    return OpenCallHierarchyHandler.HIERARCHY_VIEW_PART_ID;
  }
  
  @Override
  protected IHierarchyBuilder createHierarchyBuilder(final EObject target) {
    final XtextCallHierarchyBuilder xtextCallHierarchyBuilder = this._iGlobalServiceProvider.<XtextCallHierarchyBuilder>findService(target, XtextCallHierarchyBuilder.class);
    xtextCallHierarchyBuilder.setResourceAccess(this.resourceAccess);
    xtextCallHierarchyBuilder.setIndexData(this._iGlobalServiceProvider.<IResourceDescriptions>findService(target, IResourceDescriptions.class));
    final DeferredHierarchyBuilder deferredHierarchyBuilder = this._iGlobalServiceProvider.<DeferredHierarchyBuilder>findService(target, DeferredHierarchyBuilder.class);
    deferredHierarchyBuilder.setHierarchyBuilder(xtextCallHierarchyBuilder);
    return deferredHierarchyBuilder;
  }
}
