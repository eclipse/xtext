/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.typesystem;

import org.eclipse.xtend.core.jvmmodel.AnonymousClassUtil;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.HumanReadableTypeNames;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LocalClassAwareTypeNames extends HumanReadableTypeNames {

	@Inject
	private AnonymousClassUtil anonymousClassUtil;
	
	@Override
	protected void doVisitParameterizedTypeReference(ParameterizedTypeReference reference, StringBuilder param) {
		JvmType type = reference.getType();
		if (type instanceof JvmDeclaredType) {
			boolean local = ((JvmDeclaredType) type).isLocal();
			if (local) {
				param.append("new ");
				Iterables.getLast(reference.getSuperTypes()).accept(this, param);
				param.append("(){}");
				return;
			}
		}
		super.doVisitParameterizedTypeReference(reference, param);
	}
	
	public String getReadableName(XtendTypeDeclaration typeDeclaration) {
		if (typeDeclaration instanceof AnonymousClass) {
			JvmGenericType superType = anonymousClassUtil.getSuperType((AnonymousClass) typeDeclaration);
			return "new " + superType.getSimpleName() + "(){}";
		} else if (typeDeclaration.getName() == null) {
			return "<unnamed>";
		}
		return typeDeclaration.getName();
	}
	
}
