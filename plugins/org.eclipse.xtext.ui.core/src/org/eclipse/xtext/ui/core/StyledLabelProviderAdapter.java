/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * An abstract adapter class for creating styled labels consisting of empty methods. This class is used as a convenience
 * super class for creating styled label providers.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public abstract class StyledLabelProviderAdapter implements IStyledLabelProvider {

	/**
	 * @see IStyledLabelProvider#getImage(Object)
	 */
	public Image getImage(Object element) {
		return null;
	}

	/**
	 * @see IStyledLabelProvider#getStyledText(Object)
	 */
	public StyledString getStyledText(Object element) {
		return null;
	}

	/**
	 * @see IBaseLabelProvider#addListener(ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
	}

	/**
	 * @see IBaseLabelProvider#dispose()
	 */
	public void dispose() {
	}

	/**
	 * @see IBaseLabelProvider#isLabelProperty(Object, String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * @see IBaseLabelProvider#removeListener(ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
	}
}
