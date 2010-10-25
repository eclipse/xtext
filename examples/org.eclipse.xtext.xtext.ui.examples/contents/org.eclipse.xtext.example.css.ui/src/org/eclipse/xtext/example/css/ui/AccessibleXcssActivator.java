/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.css.ui;

import org.eclipse.xtext.example.css.ui.internal.XcssActivator;
import org.eclipse.xtext.validation.IResourceValidator;

/**
 * @author Sebastian Zarnekow
 */
public class AccessibleXcssActivator extends XcssActivator {

	private static final String LANGUAGE_ID = "org.eclipse.xtext.example.css.Xcss";
	
	private JdtAwareRenderingHelper renderer;
	
	public static AccessibleXcssActivator getInstance() {
		return (AccessibleXcssActivator) XcssActivator.getInstance();
	}
	
	public JdtAwareRenderingHelper getRenderer() {
		if (renderer == null)
			renderer = getInjector(LANGUAGE_ID).getInstance(JdtAwareRenderingHelper.class);
		return renderer;
	}
	
	public IResourceValidator getValidator() {
		IResourceValidator result = getInjector(LANGUAGE_ID).getInstance(IResourceValidator.class);
		return result;
	}
	
}
