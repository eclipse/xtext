/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
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
