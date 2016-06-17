/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.xtext.ui.editor.hierarchy.AbstractHierarchyViewPart;
import org.eclipse.xtext.ui.internal.XtextPluginImages;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public class RefreshHierarchyAction extends Action {
  private final AbstractHierarchyViewPart hierarchyViewPart;
  
  public RefreshHierarchyAction(final AbstractHierarchyViewPart hierarchyViewPart) {
    this.hierarchyViewPart = hierarchyViewPart;
    this.setText("Refresh");
    this.setToolTipText("Refresh");
    this.setImageDescriptor(XtextPluginImages.DESC_REFRESH);
    this.setHoverImageDescriptor(XtextPluginImages.DESC_REFRESH);
  }
  
  @Override
  public void run() {
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    this.hierarchyViewPart.refresh(_nullProgressMonitor);
  }
}
