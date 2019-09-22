/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.search;

import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.search.IXtextSearchFilter;

public class DomainmodelSearchFilter implements IXtextSearchFilter {

	@Override
	public boolean reject(IEObjectDescription input) {
		return TypesPackage.Literals.JVM_FORMAL_PARAMETER.equals(input.getEClass());
	}

}
