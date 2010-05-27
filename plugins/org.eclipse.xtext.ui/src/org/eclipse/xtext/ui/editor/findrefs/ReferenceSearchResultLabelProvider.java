/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.label.GlobalDescriptionLabelProvider;

import com.google.inject.Inject;

public class ReferenceSearchResultLabelProvider extends org.eclipse.jface.viewers.LabelProvider {

	@Inject
	private GlobalDescriptionLabelProvider globalDescriptionProvider; 
	
	@Override
	public String getText(Object element) {
		if (element instanceof ReferenceSearchViewTreeNode) {
			return globalDescriptionProvider.getText(((ReferenceSearchViewTreeNode) element).getLabelDescription());
		}
		return Messages.ReferenceSearchResultLabelProvider_invalid;
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof ReferenceSearchViewTreeNode) {
			return globalDescriptionProvider.getImage(((ReferenceSearchViewTreeNode) element).getLabelDescription());
		}
		return null;
	}
}