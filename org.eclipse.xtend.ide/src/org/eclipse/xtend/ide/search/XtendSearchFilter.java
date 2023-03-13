/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
