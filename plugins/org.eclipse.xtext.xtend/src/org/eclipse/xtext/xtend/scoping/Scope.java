/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtend.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopedElement;
import org.eclipse.xtext.scoping.impl.AbstractScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Scope extends AbstractScope {
	
	private List<IScopedElement> elements;

	public void setElements(List<IScopedElement> elements) {
		this.elements = elements;
	}

	public Iterable<IScopedElement> getContents() {
		return Collections2.filter(elements, new Predicate<IScopedElement>(){

			public boolean apply(IScopedElement param) {
				if (filterOnType==null)
					return true;
				return filterOnType.isInstance(param.element());
			}});
	}
	
	private EClassifier filterOnType = null;
	
	public void setFilterOnType(EClassifier filterOnType) {
		this.filterOnType = filterOnType;
	}
	
	private IScope outer;
	
	public void setOuterScope(IScope outer) {
		this.outer = outer;
	}

	public IScope getOuterScope() {
		return outer;
	}


}
