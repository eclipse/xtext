/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
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

		// local scope used by the import scope
		if (hasImports(context)) {
			IScope localElements = getLocalElements(result, context, reference);
			// imports
			result = getImportedElements(result, localElements, context, reference);
		}
		// local scope
		if (qualifiedNameProvider.getFullyQualifiedName(context) != null) {
			result = getLocalElements(result, context, reference);
		}
		return result;
	}

	protected boolean hasImports(final EObject context) {
		return !getImportedNamespaceResolvers(context).isEmpty();
	}

	protected IScope getResourceScope(final IScope parent, final EObject context, final EReference reference) {
		if (context.eResource() == null)
			return parent;
		return getScope(getKey(context.eResource(), reference), context, parent,
				new Provider<Map<QualifiedName, IEObjectDescription>>() {
					public Map<QualifiedName, IEObjectDescription> get() {
						return internalGetResourceScopeMap(parent, context, reference);
					}
				});
	}

	protected Map<QualifiedName, IEObjectDescription> internalGetResourceScopeMap(IScope parent, final EObject context,
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

	protected IScope getLocalElements(final IScope parent, final EObject context, final EReference reference) {
		return getScope(getKey(context, reference), context, parent,
				new Provider<Map<QualifiedName, IEObjectDescription>>() {
					public Map<QualifiedName, IEObjectDescription> get() {
						return internalGetLocalElementsMap(parent, context, reference);
					}
				});
	}

	protected Map<QualifiedName, IEObjectDescription> internalGetLocalElementsMap(final IScope parent,
			final EObject context, final EReference reference) {
		QualifiedName qualifiedName = qualifiedNameProvider.getFullyQualifiedName(context);
		final ImportNormalizer localNamespaceResolver = (qualifiedName != null) ? new ImportNormalizer(qualifiedName,
				getWildCard()) : null;

		Iterable<EObject> contents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return EcoreUtil.getAllProperContents(context, true);
			}
		};
		// filter by type
		contents = filter(contents, typeFilter(reference.getEReferenceType()));
		// transform to IScopedElements
		Function<EObject, IEObjectDescription> descriptionComputation = new Function<EObject, IEObjectDescription>() {
			public IEObjectDescription apply(EObject from) {
				final QualifiedName fullyQualifiedName = qualifiedNameProvider.getFullyQualifiedName(from);
				if (fullyQualifiedName == null)
					return null;
				QualifiedName relativeName = localNamespaceResolver != null 
					? localNamespaceResolver.deresolve(fullyQualifiedName) 
					: fullyQualifiedName;
				if (relativeName == null)
					return null;
				return new EObjectDescription(relativeName, from, Collections.<String, String> emptyMap()) {
					@Override
					public QualifiedName getQualifiedName() {
						return fullyQualifiedName;
					}
				};
			}
		};
		Iterable<IEObjectDescription> elements = Iterables.filter(
				Iterables.transform(contents, descriptionComputation), Predicates.notNull());
		return toMap(elements);
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

	protected Set<ImportNormalizer> getImportedNamespaceResolvers(final EObject context) {
		return cache.get(Tuples.pair(context, "imports"), context.eResource(), new Provider<Set<ImportNormalizer>>() {
			public Set<ImportNormalizer> get() {
				return internalGetImportedNamespaceResolvers(context);
			}
		});
	}

	protected Set<ImportNormalizer> internalGetImportedNamespaceResolvers(final EObject context) {
		Set<ImportNormalizer> importedNamespaceResolvers = Sets.newLinkedHashSet();
		SimpleAttributeResolver<EObject, String> importResolver = SimpleAttributeResolver.newResolver(String.class,
				"importedNamespace");
		EList<EObject> eContents = context.eContents();
		// iterate over imports in reverse order see https://bugs.eclipse.org/bugs/show_bug.cgi?id=317971
		for (int i = eContents.size() - 1; i >= 0; i--) {
			EObject child = eContents.get(i);
			String value = importResolver.getValue(child);
			if (value != null) {
				importedNamespaceResolvers.add(createImportedNamespaceResolver(value));
			}

		}
		return importedNamespaceResolvers;
	}

	protected ImportNormalizer createImportedNamespaceResolver(final String namespace) {
		return new ImportNormalizer(qualifiedNameConverter.toQualifiedName(namespace), getWildCard());
	}

	protected IScope getImportedElements(final IScope parent, final IScope localElements, final EObject context,
			final EReference reference) {
		final Set<ImportNormalizer> namespaceResolvers = getImportedNamespaceResolvers(context);

		return new AbstractScope() {

			@Override
			public IEObjectDescription getContentByName(QualifiedName qualifiedName) {
				for (ImportNormalizer namespaceResolver : namespaceResolvers) {
					QualifiedName fqnCandidate = namespaceResolver.resolve(qualifiedName);
					if (fqnCandidate != null) {
						IEObjectDescription element = localElements.getContentByName(fqnCandidate);
						if (element != null)
							return new AliasedEObjectDescription(qualifiedName, element);
					}
				}
				return getOuterScope().getContentByName(qualifiedName);
			}

			@Override
			public IEObjectDescription getContentByEObject(EObject object) {
				IEObjectDescription candidate = localElements.getContentByEObject(object);
				if (candidate != null) {
					QualifiedName fullyQualifiedName = candidate.getQualifiedName();
					for (ImportNormalizer namespaceResolver : namespaceResolvers) {
						QualifiedName qualifiedName = namespaceResolver.deresolve(fullyQualifiedName);
						if (qualifiedName != null) {
							IEObjectDescription element = getContentByName(qualifiedName);
							if (element != null && element.getEObjectOrProxy() == object)
								return new AliasedEObjectDescription(qualifiedName, candidate);
						}
					}
				}
				return getOuterScope().getContentByEObject(object);
			}

			@Override
			protected Iterable<IEObjectDescription> internalGetContents() {
				List<IEObjectDescription> importedElements = Lists.newArrayList();
				for (IEObjectDescription desc : localElements.getAllContents()) {
					for (ImportNormalizer namespaceResolver : namespaceResolvers) {
						QualifiedName relativeName = namespaceResolver.deresolve(desc.getName());
						if (relativeName != null) {
							importedElements.add(new AliasedEObjectDescription(relativeName, desc));
						}
					}
				}
				return importedElements;
			}

			public IScope getOuterScope() {
				return parent;
			}

		};
	}

	protected IScope getScope(Object cacheKey, EObject eobject, IScope parentScope,
			Provider<Map<QualifiedName, IEObjectDescription>> mapProvider) {
		Map<QualifiedName, IEObjectDescription> map = cache.get(cacheKey, eobject.eResource(), mapProvider);
		return map.isEmpty() ? parentScope : createMapBasedScope(parentScope, map);
	}

	protected IScope createMapBasedScope(IScope parentScope, Map<QualifiedName, IEObjectDescription> map) {
		return new MapBasedScope(parentScope, map);
	}

	protected Map<QualifiedName, IEObjectDescription> toMap(Iterable<IEObjectDescription> scopedElementsFor) {
		Map<QualifiedName, IEObjectDescription> result = Maps.newLinkedHashMap();
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
