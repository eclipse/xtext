/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.css.ui;

import org.eclipse.xtext.example.css.ui.internal.XcssActivator;
import org.eclipse.xtext.example.css.ui.rendering.XcssRendererHelper;

/**
 * @author Sebastian Zarnekow
 */
public class AccessibleXcssActivator extends XcssActivator {

	private XcssRendererHelper renderer;
	
	public static AccessibleXcssActivator getInstance() {
		return (AccessibleXcssActivator) XcssActivator.getInstance();
	}
	
	public XcssRendererHelper getRenderer() {
		if (renderer == null)
			renderer = getInjector("org.eclipse.xtext.example.css.Xcss").getInstance(XcssRendererHelper.class);
		return renderer;
	}
	
}
