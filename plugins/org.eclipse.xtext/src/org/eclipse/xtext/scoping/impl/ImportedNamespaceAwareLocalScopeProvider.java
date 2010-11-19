/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * A local scope provider that understands namespace imports.
 * 
 * It scans model elements for an EAttribute <code>importedNamespace</code>. The value of this attribute is interpreted
 * as qualified name to be imported. Wildcards are supported (see {@link #getWildCard()} for details).
 * 
 * Imports are valid for all elements in the same container and their children.
 * 
 * See http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping for details.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
public class ImportedNamespaceAwareLocalScopeProvider extends AbstractGlobalScopeDelegatingScopeProvider {

	@Inject
	private IResourceScopeCache cache = IResourceScopeCache.NullImpl.INSTANCE;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	public ImportedNamespaceAwareLocalScopeProvider() {
	}

	public ImportedNamespaceAwareLocalScopeProvider(IGlobalScopeProvider globalScopeProvider,
			IQualifiedNameProvider qualifiedNameProvider, IQualifiedNameConverter qualifiedNameConverter) {
		super(globalScopeProvider);
		this.qualifiedNameProvider = qualifiedNameProvider;
		this.qualifiedNameConverter = qualifiedNameConverter;
	}

	public IQualifiedNameProvider getQualifiedNameProvider() {
		return qualifiedNameProvider;
	}

	public IScope getScope(EObject context, EReference reference) {
		if (context == null)
			return getGlobalScope(context, reference);
		IScope result = null;
		if (context.eContainer() == null) {
			// global scope
			result = getGlobalScope(context, reference);
			result = getResourceScope(result, context, reference);
		} else {
			// outer scope
			result = getScope(context.eContainer(), reference);
		}
		return getLocalElementsScope(result, context, reference);
	}

	protected IScope getResourceScope(final IScope parent, final EObject context, final EReference reference) {
		if (context.eResource() == null)
			return parent;
		return getScope(getKey(context.eResource(), reference), context, parent,
				new Provider<Multimap<QualifiedName, IEObjectDescription>>() {
					public Multimap<QualifiedName, IEObjectDescription> get() {
						return internalGetResourceScopeMap(parent, context, reference);
					}
				});
	}

	protected Multimap<QualifiedName, IEObjectDescription> internalGetResourceScopeMap(IScope parent, final EObject context,
			final EReference reference) {
		Iterable<EObject> contents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				// context can be a proxy when the iterable will be queried
				if (context.eResource() == null)
					return Collections.<EObject> emptyList().iterator();
				return EcoreUtil.getAllProperContents(context.eResource(), true);
			}
		};
		contents = Iterables.filter(contents, typeFilter(reference.getEReferenceType()));
		return toMap(Scopes.scopedElementsFor(contents, qualifiedNameProvider));
	}

	protected Object getKey(Notifier context, EReference reference) {
		return Tuples.create(ImportedNamespaceAwareLocalScopeProvider.class, context, reference);
	}

	private Predicate<EObject> typeFilter(final EClass type) {
		return new Predicate<EObject>() {

			public boolean apply(EObject input) {
				return type.isInstance(input);
			}
		};
	}

	protected List<ImportNormalizer> getImportedNamespaceResolvers(final EObject context) {
		return cache.get(Tuples.pair(context, "imports"), context.eResource(), new Provider<List<ImportNormalizer>>() {
			public List<ImportNormalizer> get() {
				return internalGetImportedNamespaceResolvers(context);
			}
		});
	}

	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(final EObject context) {
		List<ImportNormalizer> importedNamespaceResolvers = Lists.newArrayList();
		SimpleAttributeResolver<EObject, String> importResolver = SimpleAttributeResolver.newResolver(String.class,
				"importedNamespace");
		EList<EObject> eContents = context.eContents();
		for (EObject child : eContents) {
			String value = importResolver.getValue(child);
			if (value != null) {
				importedNamespaceResolvers.add(createImportedNamespaceResolver(value));
			}
		}
		return importedNamespaceResolvers;
	}

	protected ImportNormalizer createImportedNamespaceResolver(final String namespace) {
		QualifiedName importedNamespace = qualifiedNameConverter.toQualifiedName(namespace);
		if (importedNamespace == null || importedNamespace.getSegmentCount() < 1) {
			throw new IllegalArgumentException("Imported namespace must not be null / empty");
		}
		boolean hasWildCard = importedNamespace.getLastSegment().equals(getWildCard());
		if (hasWildCard) {
			return new ImportNormalizer(importedNamespace.skipLast(1), true);
		} else {
			return new ImportNormalizer(importedNamespace, false);
		}
	}

	protected IScope getLocalElementsScope(IScope parent, final EObject context,
			final EReference reference) {
		final List<ImportNormalizer> namespaceResolvers = getImportedNamespaceResolvers(context);
		final IScope fqnScope = parent;
		if (isRelativeImport())
			parent = getImplicitImportOfLocalElements(context, parent);
		for (ImportNormalizer normalizer : namespaceResolvers) {
			parent = new ImportScope(normalizer, parent, fqnScope);
		}
		return getImplicitImportOfLocalElements(context, parent);
	}

	protected boolean isRelativeImport() {
		return true;
	}

	protected IScope getImplicitImportOfLocalElements(EObject context, IScope parent) {
		QualifiedName qualifiedName = qualifiedNameProvider.getFullyQualifiedName(context);
		if (qualifiedName==null)
			return parent;
		final ImportNormalizer localNamespaceResolver = new ImportNormalizer(qualifiedName,true);
		return new ImportScope(localNamespaceResolver, parent, parent);
	}

	protected IScope getScope(Object cacheKey, EObject eobject, IScope parentScope,
			Provider<Multimap<QualifiedName, IEObjectDescription>> mapProvider) {
		Multimap<QualifiedName, IEObjectDescription> map = cache.get(cacheKey, eobject.eResource(), mapProvider);
		return map.isEmpty() ? parentScope : createMapBasedScope(parentScope, map);
	}

	protected IScope createMapBasedScope(IScope parentScope, Multimap<QualifiedName, IEObjectDescription> map) {
		return new MultimapBasedScope(parentScope, map);
	}

	protected Multimap<QualifiedName, IEObjectDescription> toMap(Iterable<IEObjectDescription> scopedElementsFor) {
		Multimap<QualifiedName, IEObjectDescription> result = LinkedHashMultimap.create();
		for (IEObjectDescription ieObjectDescription : scopedElementsFor) {
			if (!result.containsKey(ieObjectDescription.getName()))
				result.put(ieObjectDescription.getName(), ieObjectDescription);
		}
		return result;
	}

	public String getWildCard() {
		return "*";
	}
}
