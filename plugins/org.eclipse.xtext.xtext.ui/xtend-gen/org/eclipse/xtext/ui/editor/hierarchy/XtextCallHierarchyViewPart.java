/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import com.google.inject.Inject;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.xtext.ui.editor.hierarchy.AbstractCallHierarchyViewPart;
import org.eclipse.xtext.ui.editor.hierarchy.LocationTableLabelProvider;
import org.eclipse.xtext.ui.editor.hierarchy.XtextCallHierarchyLabelProvider;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public class XtextCallHierarchyViewPart extends AbstractCallHierarchyViewPart {
  @Inject
  private LocationTableLabelProvider locationLabelProvider;
  
  @Inject
  private XtextCallHierarchyLabelProvider hierarchyLabelProvider;
  
  @Override
  protected IBaseLabelProvider createHierarchyLabelProvider() {
    return new DelegatingStyledCellLabelProvider(this.hierarchyLabelProvider);
  }
  
  @Override
  protected IBaseLabelProvider createLocationLabelProvider() {
    return this.locationLabelProvider;
  }
}
