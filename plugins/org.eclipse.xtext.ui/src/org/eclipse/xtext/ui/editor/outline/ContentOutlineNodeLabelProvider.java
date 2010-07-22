/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.label.AbstractLabelProvider;

/**
 * @author Jan Koehnlein
 */
public class ContentOutlineNodeLabelProvider extends AbstractLabelProvider {

	@Override
	protected Object doGetText(Object element) {
		if (element instanceof IContentOutlineNode) {
			IContentOutlineNode contentOutlineNode = (IContentOutlineNode) element;
			StyledString styledString = contentOutlineNode.getStyledString();
			if(styledString != null) {
				return styledString;
			} else {
				return contentOutlineNode.getClazz().getName();
			}
		}
		return null;
	}

	@Override
	protected Object doGetImage(Object element) {
		if (element instanceof IContentOutlineNode) {
			IContentOutlineNode contentOutlineNode = (IContentOutlineNode) element;
			return contentOutlineNode.getImage();
		}
		return null;
	}

	@Override
	protected Object getDefaultImage() {
		return Activator.getImageDescriptor("icons/defaultoutlinenode.gif"); //$NON-NLS-1$
	}
}