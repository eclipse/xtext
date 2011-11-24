/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.scoping.XbaseQualifiedNameProvider;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendConstructor;
import org.eclipse.xtext.xtend2.xtend2.XtendField;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class Xtend2QualifiedNameProvider extends XbaseQualifiedNameProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof XtendClass) {
			XtendClass xtendClass = (XtendClass) obj;
			final String qualifiedName = (xtendClass.getPackageName() != null ? xtendClass.getPackageName() + "." : "")
					+ xtendClass.getName();
			return qualifiedNameConverter.toQualifiedName(qualifiedName);
		}
		if(obj instanceof XtendConstructor) {
			return getFullyQualifiedName(obj.eContainer());
		}
		if (obj instanceof JvmGenericType
			|| obj instanceof JvmOperation
			|| obj instanceof JvmConstructor
			|| obj instanceof JvmField
			|| obj instanceof XtendField
			|| obj instanceof XtendFunction) {
			return super.getFullyQualifiedName(obj);
		}
		return null;
	}

}
