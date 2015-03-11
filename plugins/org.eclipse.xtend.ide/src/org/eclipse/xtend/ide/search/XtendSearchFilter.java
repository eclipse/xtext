/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.search;

import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.search.IXtextSearchFilter;

import com.google.inject.Inject;

/**
 * Filters inferred JVM elements from open model element dialog.
 */
public class XtendSearchFilter implements IXtextSearchFilter {

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	@Override
	public boolean reject(IEObjectDescription element) {
		if (fileExtensionProvider.isValid(element.getEObjectURI().fileExtension())) {
			return element.getEClass() == TypesPackage.Literals.JVM_GENERIC_TYPE
				|| (TypesPackage.Literals.JVM_MEMBER.isSuperTypeOf(element.getEClass()));
		}
		return false;
	}

}
