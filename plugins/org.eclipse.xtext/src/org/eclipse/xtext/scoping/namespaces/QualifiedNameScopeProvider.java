/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.namespaces;

import static com.google.common.collect.Iterables.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.impl.SimpleAttributeResolver;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopedElement;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.scoping.impl.AbstractScopeProvider;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class QualifiedNameScopeProvider extends AbstractScopeProvider {
	
	/**
	 * @author Sven Efftinge - Initial contribution and API
	 * 
	 */
	public static class ImportNormalizer {
		private final QualifiedName name;

		public ImportNormalizer(QualifiedName importedNamespace) {
			this.name = importedNamespace;
		}

		public String shortToLongName(String shortName) {
			if (!name.hasWildCard()) {
				if (name.lastSegment().equals(shortName)) {
					return name.toString();
				}
			}
			else {
				return name.replaceWildcard(shortName).toString();
			}
			return null;
		}

		public String longToShortName(String from) {
			if (!name.hasWildCard()) {
				if (name.toString().equals(from)) {
					return name.lastSegment();
				}
			} else {
				QualifiedName fromName = new QualifiedName(from);
				List<String> fromSegments = fromName.segments();
				List<String> importSegments = name.segments();
				if (importSegments.size()<fromSegments.size()) {
					if (importSegments.equals(fromSegments.subList(0, importSegments.size()))) {
						return new QualifiedName(fromSegments.subList(importSegments.size(), fromSegments.size())).toString();
					}
				}
			}
			return null;
		}
	}

	private IQualifiedNameProvider nameProvider;

	@Inject
	public void setNameProvider(IQualifiedNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}

	public IQualifiedNameProvider getNameProvider() {
		return nameProvider;
	}
	
	private IGlobalScopeProvider globalScopeProvider;
	
	@Inject
	public void setGlobalScopeProvider(IGlobalScopeProvider globalScopeProvider) {
		this.globalScopeProvider = globalScopeProvider;
	}
	
	public IGlobalScopeProvider getGlobalScopeProvider() {
		return globalScopeProvider;
	}

	public IScope getScope(EObject context, EReference reference) {
		if (context == null)
			return getGlobalScope(null, reference);
		IScope result = null;
		if (context.eContainer() == null) {
			// global scope
			result = getGlobalScope(context, reference);
			result = getResourceScope(result, context, reference);
		}
		else {
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
		if (nameProvider.getQualifiedName(context) != null) {
			result = getLocalElements(result, context, reference);
		}
		return result;
	}

	protected boolean hasImports(final EObject context) {
		return !getImportNormalizer(context).isEmpty();
	}

	protected IScope getGlobalScope(final EObject context, final EReference reference) {
		return globalScopeProvider.getScope(context, reference);
	}

	protected IScope getResourceScope(IScope parent, final EObject context, final EReference reference) {
		if (context.eResource() == null)
			return parent;
		Iterable<EObject> contents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return EcoreUtil.getAllProperContents(context.eResource(), true);
			}
		};
		contents = Iterables.filter(contents, typeFilter(reference.getEReferenceType()));
		return Scopes.scopeFor(contents, nameProvider, parent);
	}

	private IScope getLocalElements(IScope parent, final EObject context, final EReference reference) {
		final String commonPrefix = nameProvider.getQualifiedName(context) + ".";

		Iterable<EObject> contents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return EcoreUtil.getAllProperContents(context, true);
			}
		};
		// filter by type
		contents = filter(contents, typeFilter(reference.getEReferenceType()));
		// transform to IScopedElements
		Function<EObject, String> nameComputation = new Function<EObject, String>() {
			public String apply(EObject from) {
				String name = nameProvider.getQualifiedName(from);
				if (name != null && name.startsWith(commonPrefix))
					return name.substring(commonPrefix.length());
				return null;
			}};
			
		return Scopes.scopeFor(contents, nameComputation, parent);
	}

	private Predicate<EObject> typeFilter(final EClass type) {
		return new Predicate<EObject>() {

			public boolean apply(EObject input) {
				return type.isInstance(input);
			}
		};
	}

	protected Set<ImportNormalizer> getImportNormalizer(EObject context) {
		Set<ImportNormalizer> namespaceImports = new HashSet<ImportNormalizer>();
		SimpleAttributeResolver<EObject, String> importResolver = SimpleAttributeResolver.newResolver(String.class,
				"importedNamespace");
		for (EObject child : context.eContents()) {
			String value = importResolver.getValue(child);
			if (value != null) {
				namespaceImports.add(createImportNormalizer(value));
			}
		}
		return namespaceImports;
	}

	protected ImportNormalizer createImportNormalizer(final String name) {
		return new ImportNormalizer(new QualifiedName(name));
	}

	protected IScope getImportedElements(final IScope parent, final IScope localElements, final EObject context,
			final EReference reference) {
		final Set<ImportNormalizer> normalizers = getImportNormalizer(context);

		return new AbstractScope() {
			
			@Override
			public IScopedElement getContentByName(String name) {
				for (ImportNormalizer normalizer : normalizers) {
					String shortToLongName = normalizer.shortToLongName(name);
					if (shortToLongName != null) {
						IScopedElement element = localElements.getContentByName(shortToLongName);
						if (element != null)
							return element;
					}
				}
				return getOuterScope().getContentByName(name);
			}
			
			public Iterable<IScopedElement> getContents() {
				return filter(transform(localElements.getAllContents(),
				new Function<IScopedElement, IScopedElement>() {

					public IScopedElement apply(final IScopedElement input) {
						for (ImportNormalizer normalizer : normalizers) {
							final String newName = normalizer.longToShortName(input.name());
							if (newName != null) {
								return new AliasedScopedElement(newName, input);
							}
						}
						return null;
					}
				}),Predicates.notNull());
			}

			public IScope getOuterScope() {
				return parent;
			}
		};
	}


}
