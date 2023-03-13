/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.imports;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend.core.jvmmodel.AnonymousClassUtil;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.imports.ImportedTypesCollector;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtendImportedTypesUsageCollector extends ImportedTypesCollector {
	@Inject
	private AnonymousClassUtil anonymousClassUtil;
	
	@Override
	protected JvmIdentifiableElement getReferencedElement(EObject owner, EReference reference) {
		if (reference == XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR && owner.eContainer() instanceof AnonymousClass) {
			return anonymousClassUtil.getSuperType((AnonymousClass) owner.eContainer());
		}
		return super.getReferencedElement(owner, reference);
	}
}
