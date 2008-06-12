/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.service.ILabelProvider;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextLabelProviderDelegator extends LabelProvider implements IStyledLabelProvider {

	private final ILabelProvider service;

	public XtextLabelProviderDelegator(ILabelProvider service) {
		this.service = service;
	}

	@Override
	public String getText(Object element) {
		return service.getLabel((EObject) element).getString();
	}

	@Override
	public Image getImage(Object element) {
		return service.getIcon((EObject) element);
	}

	public StyledString getStyledText(Object element) {
		return service.getLabel((EObject) element);
	}
}
