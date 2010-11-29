/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.text.java.hover.JavadocHover;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;

/**
 * @author Christoph Kulla - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JavadocHoverWrapper extends JavadocHover {

	IJavaElement currentElement;
	
	void setJavaElement (IJavaElement element) {
		currentElement = element;
	}
	
	@Override
	protected IJavaElement[] getJavaElementsAt(ITextViewer textViewer, IRegion hoverRegion) {
		// hack: return previously registered element
		// required as JavadocHover.getHoverInfo(IJavaElement[] elements,...) is private
		return new IJavaElement[] { currentElement };
	}	
	
}
