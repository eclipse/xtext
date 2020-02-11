/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SyntaxFilteredScope implements IScope {

	private IScope parent;
	private Set<QualifiedName> values;

	@SuppressWarnings("serial")
	public SyntaxFilteredScope(IScope parent, List<String> values) {
		this.parent = parent;
		this.values = new HashSet<QualifiedName>() {
			@Override
			public boolean contains(Object o) {
				if (o instanceof IEObjectDescription) {
					return super.contains(((IEObjectDescription) o).getName());
				}
				return super.contains(o);
			}
		};
		for(String value: values) {
			this.values.add(QualifiedName.create(value));
		}
	}

	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		if (values.contains(name)) {
			return parent.getSingleElement(name);
		}
		return null;
	}

	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		if (values.contains(name)) {
			return parent.getElements(name);
		}
		return Collections.emptyList();
	}

	@Override
	public IEObjectDescription getSingleElement(EObject object) {
		return Iterables.getFirst(getElements(object), null);
	}

	@Override
	public Iterable<IEObjectDescription> getElements(EObject object) {
		return Iterables.filter(parent.getElements(object), Predicates.<Object>in(values));
	}

	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		return Iterables.concat(Iterables.transform(values, new Function<QualifiedName, Iterable<IEObjectDescription>>() {
			@Override
			public Iterable<IEObjectDescription> apply(QualifiedName input) {
				return parent.getElements(input);
			}
		}));
	}

}
