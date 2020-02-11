/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.launching;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.ui.launching.JavaElementDelegateJunitLaunch;

import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 */
public class XtendJavaElementDelegateJunitLaunch extends JavaElementDelegateJunitLaunch {

	@Inject
	private IJavaElementFinder elementFinder;

	@Override
	protected IJavaElement findJavaElement(XtextResource resource, int offset) {
		IJavaElement javaElement = super.findJavaElement(resource, offset);
		if (javaElement == null) {
			javaElement = getXtendClass(resource);
		}

		return javaElement;
	}

	/**
	 * @param resource the Xtext resource to parse
	 * @return if the resource contains exactly one class, returns the IJavaElement associated with that class,
	 *			otherwise returns null
	 */
	private IJavaElement getXtendClass(XtextResource resource) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult == null) {
			return null;
		}
		EObject root = parseResult.getRootASTElement();
		if (root instanceof XtendFile) {
			XtendFile xtendFile = (XtendFile) root;
			EList<XtendTypeDeclaration> xtendTypes = xtendFile.getXtendTypes();
			if (xtendTypes.size() == 1) {
				XtendTypeDeclaration element = xtendTypes.get(0);
				JvmIdentifiableElement jvmElement = findAssociatedJvmElement(element);
				if (jvmElement == null) {
					return null;
				}
				IJavaElement javaElement = elementFinder.findElementFor(jvmElement);
				return javaElement;
			}
		}
		return null;
	}
}