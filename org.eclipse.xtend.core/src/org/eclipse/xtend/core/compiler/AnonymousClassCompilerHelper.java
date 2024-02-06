/*******************************************************************************
 * Copyright (c) 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.compiler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class AnonymousClassCompilerHelper {

	@Inject
	private IResourceScopeCache cache;

	@Inject
	private IJvmModelAssociations associations;

	/**
	 * Assumes that the passed type is anonymous.
	 */
	public boolean canCompileToJavaAnonymousClass(JvmType type) {
		return cache.get(Tuples.pair("anonymousJava", type), type.eResource(), () -> {
			EObject sourceElement = associations.getPrimarySourceElement(type);
			return sourceElement instanceof AnonymousClass &&
					canCompileToJavaAnonymousClass((AnonymousClass) sourceElement);
		});
	}

	public boolean canCompileToJavaAnonymousClass(AnonymousClass anonymousClass) {
		return cache.get(Tuples.pair("anonymousJava", anonymousClass), anonymousClass.eResource(), () -> {
			for(XtendMember member: anonymousClass.getMembers()) {
				if(member instanceof XtendField ||	
					(member instanceof XtendFunction && !((XtendFunction) member).isOverride())) 
					return false;
			}
			return true;
		});
	}
}
