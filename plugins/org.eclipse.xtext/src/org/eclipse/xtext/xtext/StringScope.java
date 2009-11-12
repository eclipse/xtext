/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class StringScope extends SimpleScope {

	public StringScope(IScope parentScope, Iterable<? extends String> content) {
		super(parentScope, Iterables.transform(content, new Function<String, IEObjectDescription>() {
			public IEObjectDescription apply(String param) {
				return new StringScopeElement(param);
			}
		}));
	}

	public StringScope(Iterable<? extends String> content) {
		this(IScope.NULLSCOPE, content);
	}

}
