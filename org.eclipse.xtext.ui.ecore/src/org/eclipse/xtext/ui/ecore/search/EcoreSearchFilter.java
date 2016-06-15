/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.ecore.search;

import org.eclipse.xtext.ecore.EcoreResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.search.IXtextSearchFilter;

public class EcoreSearchFilter implements IXtextSearchFilter {

	@Override
	public boolean reject(IEObjectDescription element) {
		return "true".equals(element.getUserData(EcoreResourceDescriptionStrategy.NS_URI_INDEX_ENTRY));
	}

}
