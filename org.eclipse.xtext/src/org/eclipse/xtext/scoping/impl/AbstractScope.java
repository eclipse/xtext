/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Provider;

/**
 * <p>Base class for custom scope implementations. It supports nesting of scopes
 * into each other, appropriate shadowing semantics and case sensitive and insensitive 
 * lookup.</p>
 * 
 * <p>Implementors have to provide {@link #getAllLocalElements()}. However, it is recommended
 * to customize {@link #getLocalElementsByEObject(EObject, URI)} and {@link #getLocalElementsByName(QualifiedName)}
 * as well.</p> 
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public abstract class AbstractScope implements IScope {

	/**
	 * Lazy iterable with a reasonable {@link #toString()} implementation that supports
	 * shadowing of parents elements by means of filtering. 
	 */
	protected static class ParentIterable implements Iterable<IEObjectDescription>, Predicate<IEObjectDescription> {

		private final AbstractScope scope;
		private final Provider<Iterable<IEObjectDescription>> provider;
		private Iterable<IEObjectDescription> parentElements;

		protected ParentIterable(AbstractScope scope, Provider<Iterable<IEObjectDescription>> provider) {
			this.scope = scope;
			this.provider = provider;
		}

		@Override
		public Iterator<IEObjectDescription> iterator() {
			if (parentElements == null) {
				parentElements = provider.get();
			}
			Iterator<IEObjectDescription> parentIterator = parentElements.iterator();
			Iterator<IEObjectDescription> filteredIterator = Iterators.filter(parentIterator, this);
			return filteredIterator;
		}

		@Override
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

	/**
	 * Creates a new scope with a given parent. 
	 * @param parent the parent scope. May not be <code>null</code>. Use {@link IScope#NULLSCOPE NULLSCOPE} instead.
	 * @param ignoreCase whether name lookup and shadowing should be case insensitive or not. 
	 */
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
	
	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		IEObjectDescription result = getSingleLocalElementByName(name);
		if (result != null)
			return result;
		return getParent().getSingleElement(name);
	}
	
	protected IEObjectDescription getSingleLocalElementByName(QualifiedName name) {
		Iterable<IEObjectDescription> result = getLocalElementsByName(name);
		Iterator<IEObjectDescription> iterator = result.iterator();
		if (iterator.hasNext())
			return iterator.next();
		return null;
	}

	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		Iterable<IEObjectDescription> localElements = getAllLocalElements();
		Iterable<IEObjectDescription> parentElements = getParentElements(new Provider<Iterable<IEObjectDescription>>() {
			@Override
			public Iterable<IEObjectDescription> get() {
				return getParent().getAllElements();
			}
		});
		Iterable<IEObjectDescription> result = Iterables.concat(localElements, parentElements);
		return result;
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(final QualifiedName name) {
		Iterable<IEObjectDescription> localElements = getLocalElementsByName(name);
		if (localElements instanceof Collection) {
			if (((Collection<?>) localElements).isEmpty())
				return getParent().getElements(name);
		}
		Iterable<IEObjectDescription> parentElements = getParentElements(new Provider<Iterable<IEObjectDescription>>() {
			@Override
			public Iterable<IEObjectDescription> get() {
				return getParent().getElements(name);
			}
		});
		Iterable<IEObjectDescription> result = Iterables.concat(localElements, parentElements);
		return result;
	}
	
	@Override
	public IEObjectDescription getSingleElement(EObject object) {
		Iterable<IEObjectDescription> elements = getElements(object);
		Iterator<IEObjectDescription> iterator = elements.iterator();
		if (iterator.hasNext()) {
			IEObjectDescription result = iterator.next();
			return result;
		}
		return null;
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(final EObject object) {
		final URI uri = EcoreUtil2.getPlatformResourceOrNormalizedURI(object);
		Iterable<IEObjectDescription> localElements = getLocalElementsByEObject(object, uri);
		Iterable<IEObjectDescription> parentElements = getParentElements(new Provider<Iterable<IEObjectDescription>>() {
			@Override
			public Iterable<IEObjectDescription> get() {
				return getParent().getElements(object);
			}
		});
		Iterable<IEObjectDescription> result = Iterables.concat(localElements, parentElements);
		return result;
	}
	
	protected abstract Iterable<IEObjectDescription> getAllLocalElements();
	
	protected Iterable<IEObjectDescription> getLocalElementsByName(final QualifiedName name) {
		Iterable<IEObjectDescription> localElements = getAllLocalElements();
		Iterable<IEObjectDescription> result = Iterables.filter(localElements, new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription input) {
				if (isIgnoreCase()) {
					return name.equalsIgnoreCase(input.getName());
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
			@Override
			public boolean apply(IEObjectDescription input) {
				if (input.getEObjectOrProxy() == object)
					return canBeFoundByName(input);
				if (uri.equals(input.getEObjectURI())) {
					return canBeFoundByName(input);
				}
				return false;
			}
			
			public boolean canBeFoundByName(IEObjectDescription input) {
				IEObjectDescription lookUp = getSingleLocalElementByName(input.getName());
				if (lookUp != null) {
					if (lookUp == input)
						return true;
					if (lookUp.getEObjectOrProxy() == object)
						return true;
					if (uri.equals(lookUp.getEObjectURI()))
						return true;
				}
				return false;
			}
		});
		return result;
	}
	
	protected Iterable<IEObjectDescription> getParentElements(Provider<Iterable<IEObjectDescription>> provider) {
		if (getParent() == IScope.NULLSCOPE)
			return Collections.emptyList();
		return new ParentIterable(this, provider);
	}
	
	/**
	 * Returns <code>true</code> if the given description {@code input} from the parent scope is
	 * shadowed by local elements.
	 * @return <code>true</code> if the given description {@code input} from the parent scope is
	 * shadowed by local elements.
	 */
	protected boolean isShadowed(IEObjectDescription input) {
		final Iterable<IEObjectDescription> localElements = getLocalElementsByName(input.getName());
		final boolean isEmpty = isEmpty(localElements);
		return !isEmpty;
	}
	
	@Override
	public String toString() {
		String parentString = null;
		try {
			final IScope parent = getParent();
			parentString = parent.toString();
		} catch (Throwable t) {
			parentString = t.getClass().getSimpleName() + " : " + t.getMessage();
		}
		return getClass().getSimpleName() + (ignoreCase? "[ignore case]":"") + getAllLocalElements() + " -> " + parentString;
	}

}
