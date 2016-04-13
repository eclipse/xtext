/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.example.domainmodel.ui.editor.hierarchy.AssociationLocationTableViewer;
import org.eclipse.xtext.ui.editor.hierarchy.DefaultCallHierarchyViewPart;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class AssociationHierarchyViewPart extends DefaultCallHierarchyViewPart {
  @Override
  protected TableViewer createLocationViewer(final Composite parent) {
    final AssociationLocationTableViewer locationViewer = new AssociationLocationTableViewer(parent);
    IBaseLabelProvider _createLocationLabelProvider = this.createLocationLabelProvider();
    locationViewer.setLabelProvider(_createLocationLabelProvider);
    return locationViewer;
  }
}
