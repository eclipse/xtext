/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.fileAware.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwarePackage;

import com.google.inject.Inject;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class FileAwareTestLanguageScopeProvider extends AbstractFileAwareTestLanguageScopeProvider {

	@Inject IGlobalScopeProvider global;

	public IScope getScope(EObject context, EReference reference) {
		if (reference == FileAwarePackage.Literals.IMPORT__ELEMENT) {
			return global.getScope(context.eResource(), reference, null);
		}
		return super.getScope(context, reference);
	}

}
