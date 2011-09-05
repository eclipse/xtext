/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XClosureImplCustom extends XClosureImpl {

	@Override
	public EList<JvmFormalParameter> getFormalParameters() {
		// is fully initialized / parsed?
		//TODO tell the serializer to skip this element
		if (expression != null && super.getFormalParameters().isEmpty() && !isExplicitSyntax()) {
			JvmFormalParameter parameter = TypesFactory.eINSTANCE.createJvmFormalParameter();
			parameter.setName(XbaseScopeProvider.IT.toString());
			super.getFormalParameters().add(parameter);
		}
		return super.getFormalParameters();
	}
}
