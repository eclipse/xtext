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
import com.google.inject.Singleton;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.progress.PendingUpdateAdapter;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.internal.XtextPluginImages;
import org.eclipse.xtext.ui.label.GlobalDescriptionLabelProvider;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Singleton
@SuppressWarnings("all")
public class HierarchyLabelProvider extends LabelProvider implements DelegatingStyledCellLabelProvider.IStyledLabelProvider {
  @Inject
  private GlobalDescriptionLabelProvider globalDescriptionProvider;
  
  @Override
  public Image getImage(final Object element) {
    if ((element instanceof PendingUpdateAdapter)) {
      return null;
    }
    final Image image = this.globalDescriptionProvider.getImage(this.getDescription(element));
    if ((image == null)) {
      return null;
    }
    boolean _matched = false;
    if (element instanceof IHierarchyNode) {
      boolean _isRecursive = ((IHierarchyNode)element).isRecursive();
      if (_isRecursive) {
        _matched=true;
        return this.decorateRecursive(image);
      }
    }
    return image;
  }
  
  protected Image decorateRecursive(final Image image) {
    return new DecorationOverlayIcon(image, XtextPluginImages.DESC_OVR_RECURSIVE, IDecoration.BOTTOM_LEFT).createImage();
  }
  
  @Override
  public String getText(final Object element) {
    if ((element instanceof PendingUpdateAdapter)) {
      return this.getPendingText();
    }
    return this.globalDescriptionProvider.getText(this.getDescription(element));
  }
  
  @Override
  public StyledString getStyledText(final Object element) {
    if ((element instanceof PendingUpdateAdapter)) {
      String _pendingText = this.getPendingText();
      return new StyledString(_pendingText);
    }
    return this.globalDescriptionProvider.getStyledText(this.getDescription(element));
  }
  
  protected IEObjectDescription getDescription(final Object element) {
    if ((element instanceof IHierarchyNode)) {
      return ((IHierarchyNode)element).getElement();
    }
    return null;
  }
  
  protected String getPendingText() {
    return "...";
  }
}
