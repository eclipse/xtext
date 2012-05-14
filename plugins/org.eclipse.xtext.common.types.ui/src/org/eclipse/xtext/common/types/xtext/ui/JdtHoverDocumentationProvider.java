/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.text.javadoc.JavadocContentAccess2;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class JdtHoverDocumentationProvider implements IEObjectHoverDocumentationProvider {

	@Inject
	protected IJavaElementFinder javaElementFinder;
	
	private static Logger log = Logger.getLogger(JdtHoverDocumentationProvider.class);
	
	public String getDocumentation(EObject object) {
		if(object instanceof JvmIdentifiableElement){
			IJavaElement element = javaElementFinder.findElementFor((JvmIdentifiableElement) object);
			if(element instanceof IMember && element.exists())
				try {
					return JavadocContentAccess2.getHTMLContent((IMember) element, true);
				} catch (JavaModelException e) {
					log.error(e);
				}
		}  
		return "";
		
	}

}
