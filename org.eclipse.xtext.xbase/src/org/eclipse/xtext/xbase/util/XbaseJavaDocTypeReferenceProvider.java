/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.documentation.impl.MultiLineJavaDocTypeReferenceProvider;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author miklossy - Initial contribution and API
 * 
 * @since 2.16
 */
public class XbaseJavaDocTypeReferenceProvider extends MultiLineJavaDocTypeReferenceProvider {
	
	@Override
	protected EReference getEReference(EObject eObject, INode node, int offset) {
		return TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE;
	}
}
