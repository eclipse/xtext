/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.editor.hierarchy.ICallHierarchyBuilder;
import org.eclipse.xtext.ui.editor.hierarchy.AbstractCallHierarchyViewPart;
import org.eclipse.xtext.ui.internal.XtextPluginImages;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class SetHierarchyTypeAction extends Action {
  @Accessors
  private final ICallHierarchyBuilder.CallHierarchyType hierarchyType;
  
  private final AbstractCallHierarchyViewPart callHierarchyViewPart;
  
  public SetHierarchyTypeAction(final ICallHierarchyBuilder.CallHierarchyType hierarchyType, final AbstractCallHierarchyViewPart callHierarchyViewPart) {
    super("", IAction.AS_RADIO_BUTTON);
    this.hierarchyType = hierarchyType;
    this.callHierarchyViewPart = callHierarchyViewPart;
    if (hierarchyType != null) {
      switch (hierarchyType) {
        case CALLEE:
          this.setText("Show Callee Hierarchy");
          this.setToolTipText("Show Callee Hierarchy");
          this.setImageDescriptor(XtextPluginImages.DESC_CH_CALLEES);
          this.setHoverImageDescriptor(XtextPluginImages.DESC_CH_CALLEES);
          break;
        default:
          {
            this.setText("Show Caller Hierarchy");
            this.setToolTipText("Show Caller Hierarchy");
            this.setImageDescriptor(XtextPluginImages.DESC_CH_CALLERS);
            this.setHoverImageDescriptor(XtextPluginImages.DESC_CH_CALLERS);
          }
          break;
      }
    } else {
      {
        this.setText("Show Caller Hierarchy");
        this.setToolTipText("Show Caller Hierarchy");
        this.setImageDescriptor(XtextPluginImages.DESC_CH_CALLERS);
        this.setHoverImageDescriptor(XtextPluginImages.DESC_CH_CALLERS);
      }
    }
  }
  
  @Override
  public void run() {
    this.callHierarchyViewPart.setCallHierarchyType(this.hierarchyType);
  }
  
  @Pure
  public ICallHierarchyBuilder.CallHierarchyType getHierarchyType() {
    return this.hierarchyType;
  }
}
