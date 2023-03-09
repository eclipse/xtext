/*******************************************************************************
 * Copyright (c) 2012, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
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
	
	@Override
	public String getDocumentation(EObject object) {
		if(object instanceof JvmIdentifiableElement){
			IJavaElement element = javaElementFinder.findElementFor((JvmIdentifiableElement) object);
			if(element instanceof IMember && element.exists()){
				try {
					return JavadocContentAccess2.getHTMLContent(element, true);
				} catch (CoreException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		return "";
		
	}

}
