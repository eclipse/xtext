/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typing;

import org.eclipse.xtend.core.typing.XtendTypeProvider;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("deprecation")
@Singleton
public class MockedXtendTypeProvider extends XtendTypeProvider {

	@Inject
	private TypeReferences typeReferences;

	@Override
	public JvmTypeReference getExpectedType(XExpression expression, boolean rawType) {
		return typeReferences.createDelegateTypeReference(typeReferences.getTypeForName(String.class, expression));
	}
}
