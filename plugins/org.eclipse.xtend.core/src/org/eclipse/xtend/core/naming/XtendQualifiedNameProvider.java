/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnumLiteral;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.scoping.XbaseQualifiedNameProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class XtendQualifiedNameProvider extends XbaseQualifiedNameProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof XtendTypeDeclaration) {
			XtendTypeDeclaration typeDecl = (XtendTypeDeclaration) obj;
			if (typeDecl.getName() == null)
				return null;
			XtendFile file = (XtendFile) typeDecl.eContainer();
			final String qualifiedName = (file.getPackage() != null ? file.getPackage() + "." : "")
					+ typeDecl.getName();
			return qualifiedNameConverter.toQualifiedName(qualifiedName);
		}
		if(obj instanceof XtendConstructor) {
			return getFullyQualifiedName(obj.eContainer());
		}
		if (obj instanceof JvmIdentifiableElement) {
			return getFullyQualifiedName((JvmIdentifiableElement) obj);
		}
		if (obj instanceof XtendField) {
			return getFullyQualifiedName(obj.eContainer()).append(((XtendField)obj).getName());
		}
		if (obj instanceof XtendFunction) {
			return getFullyQualifiedName(obj.eContainer()).append(((XtendFunction)obj).getName());
		}
		if (obj instanceof XtendEnumLiteral) {
			return getFullyQualifiedName(obj.eContainer()).append(((XtendEnumLiteral)obj).getName());
		}
		return null;
	}

}
