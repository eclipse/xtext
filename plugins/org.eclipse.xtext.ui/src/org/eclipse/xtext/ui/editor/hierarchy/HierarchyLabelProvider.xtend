/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.jface.viewers.DecorationOverlayIcon
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider
import org.eclipse.jface.viewers.IDecoration
import org.eclipse.jface.viewers.LabelProvider
import org.eclipse.jface.viewers.StyledString
import org.eclipse.swt.graphics.Image
import org.eclipse.ui.progress.PendingUpdateAdapter
import org.eclipse.xtext.ui.internal.XtextPluginImages
import org.eclipse.xtext.ui.label.GlobalDescriptionLabelProvider
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Singleton
class HierarchyLabelProvider extends LabelProvider implements IStyledLabelProvider {

	@Inject
	GlobalDescriptionLabelProvider globalDescriptionProvider

	override getImage(Object element) {
		if (element instanceof PendingUpdateAdapter)
			return null

		val image = globalDescriptionProvider.getImage(element.description)
		if(image === null) return null
		switch element {
			IHierarchyNode case element.recursive:
				return image.decorateRecursive
			default:
				return image
		}
	}

	protected def Image decorateRecursive(Image image) {
		new DecorationOverlayIcon(image, XtextPluginImages.DESC_OVR_RECURSIVE, IDecoration.BOTTOM_LEFT).createImage
	}

	override getText(Object element) {
		if (element instanceof PendingUpdateAdapter)
			return pendingText

		return globalDescriptionProvider.getText(element.description)
	}

	override getStyledText(Object element) {
		if (element instanceof PendingUpdateAdapter)
			return new StyledString(pendingText)

		return globalDescriptionProvider.getStyledText(element.description)
	}

	protected def getDescription(Object element) {
		if (element instanceof IHierarchyNode)
			return element.element
	}

	protected def String getPendingText() {
		'...'
	}

}
