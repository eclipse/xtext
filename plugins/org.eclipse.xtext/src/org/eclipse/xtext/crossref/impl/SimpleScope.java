/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SimpleScope extends AbstractNestedScope {

	public SimpleScope(IScope parent, Iterable<IScopedElement> elements) {
		super(parent, elements);
	}

}
