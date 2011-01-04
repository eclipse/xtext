/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.scoping.Selectors;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public abstract class AbstractScope implements IScope {

	protected static class ParentIterable implements Iterable<IEObjectDescription>, Predicate<IEObjectDescription> {

		private final AbstractScope scope;
		private final ISelector selector;
		private Iterable<IEObjectDescription> parentElements;

		protected ParentIterable(AbstractScope scope, ISelector selector) {
			this.scope = scope;
			this.selector = selector;
		}

		public Iterator<IEObjectDescription> iterator() {
			if (parentElements == null) {
				parentElements = scope.getParent().getElements(selector);
			}
			Iterator<IEObjectDescription> parentIterator = parentElements.iterator();
			Iterator<IEObjectDescription> filteredIterator = Iterators.filter(parentIterator, this);
			return filteredIterator;
		}

		public boolean apply(IEObjectDescription input) {
			return !scope.isShadowed(input);
		}
		
		@Override
		public String toString() {
			return Iterables.toString(this);
		}
		
	}
	
	private final boolean ignoreCase;
	
	private final IScope parent;

	protected AbstractScope(IScope parent, boolean ignoreCase) {
		if (parent == null)
			throw new IllegalArgumentException("parent may not be null. Use IScope.NULLSCOPE instead.");
		this.parent = parent;
		this.ignoreCase = ignoreCase;
	}

	public IScope getParent() {
		return parent;
	}
	
	public boolean isIgnoreCase() {
		return ignoreCase;
	}

	public IEObjectDescription getSingleElement(ISelector selector) {
		if (selector == null)
			throw new IllegalArgumentException("selector may not be null");
		if (selector instanceof ISelector.SelectByName) {
			return getSingleElementByName((ISelector.SelectByName) selector);
		} else {
			Iterable<IEObjectDescription> elements = getElements(selector);
			final Iterator<IEObjectDescription> iterator = elements.iterator();
			if (iterator.hasNext())
				return iterator.next();
			return null;
		}
	}

	protected IEObjectDescription getSingleElementByName(ISelector.SelectByName selector) {
		IEObjectDescription result = getSingleLocalElementByName(selector.getName());
		if (result != null)
			return result;
		return getParent().getSingleElement(selector);
	}
	
	protected IEObjectDescription getSingleLocalElementByName(QualifiedName name) {
		Iterable<IEObjectDescription> result = getLocalElementsByName(name);
		Iterator<IEObjectDescription> iterator = result.iterator();
		if (iterator.hasNext())
			return iterator.next();
		return null;
	}

	public Iterable<IEObjectDescription> getElements(ISelector selector) {
		if (selector == null)
			throw new IllegalArgumentException("selector may not be null");
		if (selector instanceof ISelector.SelectByName) {
			Iterable<IEObjectDescription> result = getElementsByName((ISelector.SelectByName) selector);
			return result;
		} else if (selector instanceof ISelector.SelectByEObject) {
			Iterable<IEObjectDescription> result = getElementsByEObject((ISelector.SelectByEObject) selector);
			return result;
		} else {
			Iterable<IEObjectDescription> result = getAllElements();
			return result;
		}
	}

	protected Iterable<IEObjectDescription> getAllElements() {
		Iterable<IEObjectDescription> localElements = getAllLocalElements();
		Iterable<IEObjectDescription> parentElements = getParentElements(Selectors.selectAll());
		Iterable<IEObjectDescription> result = Iterables.concat(localElements, parentElements);
		return result;
	}
	
	protected Iterable<IEObjectDescription> getElementsByName(ISelector.SelectByName selector) {
		Iterable<IEObjectDescription> localElements = getLocalElementsByName(selector.getName());
		Iterable<IEObjectDescription> parentElements = getParentElements(selector);
		Iterable<IEObjectDescription> result = Iterables.concat(localElements, parentElements);
		return result;
	}
	
	protected Iterable<IEObjectDescription> getElementsByEObject(final ISelector.SelectByEObject selector) {
		Iterable<IEObjectDescription> localElements = getLocalElementsByEObject(selector.getEObject(), selector.getUri());
		Iterable<IEObjectDescription> parentElements = getParentElements(selector);
		Iterable<IEObjectDescription> unfilteredResult = Iterables.concat(localElements, parentElements);
		Iterable<IEObjectDescription> result = Iterables.filter(unfilteredResult, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				Iterable<IEObjectDescription> localByName = getLocalElementsByName(input.getName());
				for(IEObjectDescription local: localByName) {
					if (!local.getEObjectURI().equals(selector.getUri())) {
						return false;
					}
				}
				return true;
			}
		});
		return result;
	}
	
	protected abstract Iterable<IEObjectDescription> getAllLocalElements();
	
	protected Iterable<IEObjectDescription> getLocalElementsByName(final QualifiedName name) {
		Iterable<IEObjectDescription> localElements = getAllLocalElements();
		Iterable<IEObjectDescription> result = Iterables.filter(localElements, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				if (isIgnoreCase()) {
					QualifiedName lowerCase = name.toLowerCase();
					QualifiedName inputLowerCase = input.getName().toLowerCase();
					return lowerCase.equals(inputLowerCase);
				} else {
					return name.equals(input.getName());
				}
			}
		});
		return result;
	}
	
	protected Iterable<IEObjectDescription> getLocalElementsByEObject(final EObject object, final URI uri) {
		Iterable<IEObjectDescription> localElements = getAllLocalElements();
		Iterable<IEObjectDescription> result = Iterables.filter(localElements, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				if (input.getEObjectOrProxy() == object)
					return true;
				if (uri.equals(input.getEObjectURI())) {
					return true;
				}
				return false;
			}
		});
		return result;
	}
	
	protected Iterable<IEObjectDescription> getParentElements(ISelector selector) {
		if (getParent() == IScope.NULLSCOPE)
			return Collections.emptyList();
		return new ParentIterable(this, selector);
	}
	
	protected boolean isShadowed(IEObjectDescription input) {
		final Iterable<IEObjectDescription> localElements = getLocalElementsByName(input.getName());
		final boolean isEmpty = isEmpty(localElements);
		return !isEmpty;
	}
	
	@Override
	public String toString() {
		String parentString = null;
		try {
			final IScope parent2 = getParent();
			parentString = parent2.toString();
		} catch (Throwable t) {
			parentString = t.getClass().getSimpleName() + " : " + t.getMessage();
		}
		return getClass().getSimpleName() + (ignoreCase? "[ignore case]":"") + getAllLocalElements() + " -> " + parentString;
	}

}
