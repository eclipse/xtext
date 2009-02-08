/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.crossref.impl.AbstractNestedScope;
import org.eclipse.xtext.util.CollectionUtils;
import org.eclipse.xtext.util.Function;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class StringScope extends AbstractNestedScope {

	private static class StringScopeElement implements IScopedElement {
		
		private final String name;
		
		public StringScopeElement(String name) {
			this.name = name;
		}

		public Object additionalInformation() {
			return null;
		}

		public EObject element() {
			return null;
		}

		public String name() {
			return name;
		}
		
	}
	
	public StringScope(Iterable<? extends Object> content, final IValueConverterService valueConverterService) {
		super(IScope.NULLSCOPE, CollectionUtils.map(content, new Function<Object, IScopedElement>() {
			public IScopedElement exec(Object param) {
				// TODO use value converter that produces double quotes
//				return new StringScopeElement(valueConverterService.toString(param, "STRING"));
				return new StringScopeElement('"' + param.toString() + '"');
			}
		}));
	}

}
