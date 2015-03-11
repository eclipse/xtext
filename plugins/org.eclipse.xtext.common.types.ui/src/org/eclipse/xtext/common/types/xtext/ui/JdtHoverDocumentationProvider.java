/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
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
				/**
				 * Since there is a incompatible change in the signature of the method we have to check at runtime
				 * which signature to use.
				 */
				Method methodToInvoke = null;
				try {
					// Old signature 
					// org.eclipse.jdt.internal.ui.text.javadoc.JavadocContentAccess2.getHTMLContent(IMember, boolean)
					methodToInvoke = JavadocContentAccess2.class.getDeclaredMethod("getHTMLContent",  new Class[] { IMember.class, boolean.class });
				} catch (SecurityException e) {
					// Ignore since we know that it is public
				} catch (NoSuchMethodException e) {
					try {
						// New signature
						// org.eclipse.jdt.internal.ui.text.javadoc.JavadocContentAccess2.getHTMLContent(IJavaElement, boolean)
						methodToInvoke = JavadocContentAccess2.class.getDeclaredMethod("getHTMLContent",  new Class[] { IJavaElement.class, boolean.class });
					} catch (SecurityException e1) {
						// Ignore since we know that it is public
					} catch (NoSuchMethodException e1) {
						log.error(e.getMessage(), e);
					}
				}
				if(methodToInvoke != null){
					try {
						return (String) methodToInvoke.invoke(null, element,true);
					} catch (IllegalArgumentException e) {
						log.error(e.getMessage(), e);
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						log.error(e.getMessage(), e);
					}
				}
			}			
		}  
		return "";
		
	}

}
