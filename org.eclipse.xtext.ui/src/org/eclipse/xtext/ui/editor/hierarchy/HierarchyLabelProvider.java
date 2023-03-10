/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
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
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
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
public class HierarchyLabelProvider extends LabelProvider implements IStyledLabelProvider {

	@Inject
	private GlobalDescriptionLabelProvider globalDescriptionProvider;

	@Override
	public Image getImage(Object element) {
		if (element instanceof PendingUpdateAdapter) {
			return null;
		}

		Image image = globalDescriptionProvider.getImage(getDescription(element));
		if (image == null) {
			return null;
		}

		if (element instanceof IHierarchyNode) {
			if (((IHierarchyNode) element).isRecursive()) {
				return decorateRecursive(image);
			}
		}
		return image;
	}

	protected Image decorateRecursive(Image image) {
		return new DecorationOverlayIcon(image, XtextPluginImages.DESC_OVR_RECURSIVE, IDecoration.BOTTOM_LEFT).createImage();
	}

	@Override
	public String getText(Object element) {
		if (element instanceof PendingUpdateAdapter) {
			return getPendingText();
		}
		return globalDescriptionProvider.getText(getDescription(element));
	}

	@Override
	public StyledString getStyledText(Object element) {
		if (element instanceof PendingUpdateAdapter) {
			return new StyledString(getPendingText());
		}
		return globalDescriptionProvider.getStyledText(getDescription(element));
	}

	protected IEObjectDescription getDescription(Object element) {
		if (element instanceof IHierarchyNode) {
			return ((IHierarchyNode) element).getElement();
		}
		return null;
	}

	protected String getPendingText() {
		return "...";
	}
}
