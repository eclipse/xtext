/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.PartInitException;
import org.eclipse.xtext.ui.common.editor.hyperlinking.AbstractHyperlink;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtHyperlink extends AbstractHyperlink {

	private static final Logger logger = Logger.getLogger(JdtHyperlink.class);
	
	private IJavaElement javaElement;

	public void open() {
		try {
			JavaUI.openInEditor(javaElement);
		}
		catch (PartInitException e) {
			logger.debug("PartInitException; javaElement: " + javaElement.toString(), e);
		}
		catch (JavaModelException e) {
			logger.debug("JavaModelException; javaElement: " + javaElement.toString(), e);
		}
	}

	public void setJavaElement(IJavaElement javaElement) {
		this.javaElement = javaElement;
	}

	public IJavaElement getJavaElement() {
		return javaElement;
	}

}
