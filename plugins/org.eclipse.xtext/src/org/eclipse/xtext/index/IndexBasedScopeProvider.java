/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.transform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.Index;
import org.eclipse.emf.emfindex.query.EObjectDescriptorQuery;
import org.eclipse.emf.emfindex.query.QueryCommand;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.query.QueryResult;
import org.eclipse.emf.emfindex.query.ResourceDescriptorQuery;
import org.eclipse.emf.emfindex.util.Descriptors;
import org.eclipse.xtext.linking.impl.SimpleAttributeResolver;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopedElement;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractScopeProvider;
import org.eclipse.xtext.scoping.impl.AliasedScopedElement;
import org.eclipse.xtext.scoping.impl.ScopedElement;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class IndexBasedScopeProvider extends AbstractScopeProvider {

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 * 
	 */
	public static class DefaultImportNormalizer implements Function<String, String> {
		private final List<String> elements;
		private IQualifiedNameProvider nameProvider;
		private boolean isWildCard;

		public DefaultImportNormalizer(List<String> importedNamespace, IQualifiedNameProvider nameProvider) {
			this.elements = importedNamespace;
			this.isWildCard = nameProvider.getWildcard().equals(lastElement(importedNamespace));
			this.nameProvider = nameProvider;
		}

		private String lastElement(List<String> importedNamespace) {
			return importedNamespace.get(importedNamespace.size() - 1);
		}

		public String apply(String from) {
			if (!isWildCard) {
				if (lastElement(elements).equals(from)) {
					return Strings.concat(nameProvider.getDelimiter(), elements);
				}
			}
			List<String> split = Strings.split(from, nameProvider.getDelimiter());
			if (split.size() >= elements.size()) {
				Iterator<String> i1 = elements.iterator(), i2 = split.iterator();
				boolean proceed = i1.hasNext() && i2.hasNext();
				while (proceed) {
					String s1 = i1.next();
					String s2 = i2.next();
					if (!s1.equals(s2)) {
						if (!s1.equals(nameProvider.getWildcard())) {
							break;
						}
						else {
							StringBuffer result = new StringBuffer(s2);
							while (i2.hasNext()) {
								result.append(nameProvider.getDelimiter());
								result.append(i2.next());
							}
							return result.toString();
						}
					}
					else if (!i1.hasNext() && !i2.hasNext()) {
						return s2;
					}
				}
			}
			return null;
		}
	}

	@Inject
	private IQualifiedNameProvider nameProvider;

	public void setNameProvider(IQualifiedNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}
	
	public IQualifiedNameProvider getNameProvider() {
		return nameProvider;
	}

	@Inject
	private Index indexStore;

	public void setIndexStore(Index indexStore) {
		this.indexStore = indexStore;
	}
	
	public Index getIndexStore() {
		return indexStore;
	}

	public IScope getScope(EObject context, EReference reference) {
		return getScope(context, reference.getEReferenceType());
	}

	public IScope getScope(final EObject context, final EClass type) {
		if (context == null)
			return getGlobalScope(null, type);
		IScope result = null;
		if (context.eContainer() == null) {
			// global scope
			result = getGlobalScope(context, type);
			result = getResourceSetScope(result,context, type);
			result = getResourceScope(result, context, type);
		} else {
			// outer scope
			result = getScope(context.eContainer(), type);
		}

		IScope importScopeConfiguration = result;
		// local scope used by the import scope
		if (nameProvider.getQualifiedName(context) != null) {
			importScopeConfiguration = getLocalElements(result, context, type);
		}
		// imports
		Iterable<IScopedElement> importedElements = getImportedElements(importScopeConfiguration, context, type);
		if (importedElements != null) {
			result = new SimpleScope(result, importedElements);
		}
		// local scope
		if (nameProvider.getQualifiedName(context) != null) {
			result = getLocalElements(result, context, type);
		}
		return result;
	}

	protected IScope getResourceSetScope(final IScope parent, final EObject context, final EClass type) {
		if (context.eResource()==null || context.eResource().getResourceSet()==null)
			return parent;
		Iterable<EObject> contents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return EcoreUtil.getAllProperContents(context.eResource().getResourceSet(), true);
			}
		};
		Iterable<EObject> filtered = Iterables.filter(contents, EObject.class);
		return createScopeWithQualifiedNames(parent, type, filtered);
	}
	
	protected IScope getResourceScope(IScope parent, final EObject context, final EClass type) {
		if (context.eResource()==null)
			return parent;
		Iterable<EObject> contents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return EcoreUtil.getAllProperContents(context.eResource(), true);
			}
		};
		return createScopeWithQualifiedNames(parent, type, contents);
	}
	
	protected IScope getLocalElements(IScope parent, final EObject context, final EClass type) {
		final String commonPrefix = nameProvider.getQualifiedName(context) + nameProvider.getDelimiter();
		
		Iterable<EObject> contents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return EcoreUtil.getAllProperContents(context, true);
			}
		};
		// filter by type
		contents = filter(contents, typeFilter(type));
		// transform to IScopedElements
		Iterable<IScopedElement> scopedElements = Scopes.scopedElementsFor(contents,new Function<EObject, String>() {
			public String apply(EObject from) {
				String name = nameProvider.getQualifiedName(from);
				if (name != null && name.startsWith(commonPrefix))
					return name.substring(commonPrefix.length());
				return null;
			}
		});
		// filter null values;
		return new SimpleScope(parent,filter(scopedElements, Predicates.notNull()));
	}


	protected IScope createScopeWithQualifiedNames(final IScope parent, final EClass type,
			Iterable<EObject> eObjects) {
		
		eObjects = filter(eObjects, typeFilter(type));

		Iterable<IScopedElement> result = transform(eObjects, new Function<EObject, IScopedElement>() {

			public IScopedElement apply(EObject from) {
				String qualifiedName = nameProvider.getQualifiedName(from);
				if (qualifiedName != null) {
					return ScopedElement.create(qualifiedName, from);
				}
				return null;
			}
		});
		return new SimpleScope(parent, filter(result, Predicates.notNull()));
	}

	protected Predicate<EObject> typeFilter(final EClass type) {
		return new Predicate<EObject>() {

			public boolean apply(EObject input) {
				return type.isInstance(input);
			}
		};
	}

	protected Set<Function<String, String>> getImportNormalizer(EObject context) {
		Set<Function<String, String>> namespaceImports = new HashSet<Function<String, String>>();
		SimpleAttributeResolver<EObject, String> importResolver = SimpleAttributeResolver.newResolver(String.class,
				"importedNamespace");
		for (EObject child : context.eContents()) {
			String value = importResolver.getValue(child);
			if (value != null) {
				final List<String> elements = org.eclipse.xtext.util.Strings.split(value, nameProvider.getDelimiter());
				namespaceImports.add(createImportNormalizer(elements));
			}
		}
		return namespaceImports;
	}

	protected DefaultImportNormalizer createImportNormalizer(final List<String> elements) {
		return new DefaultImportNormalizer(elements, nameProvider);
	}

	protected Iterable<IScopedElement> getImportedElements(IScope local, final EObject context, final EClass type) {
		final Set<Function<String, String>> normalizers = getImportNormalizer(context);
		if (normalizers.isEmpty())
			return null;
		Iterable<IScopedElement> transformed = transform(local.getAllContents(),
				new Function<IScopedElement, IScopedElement>() {

					public IScopedElement apply(final IScopedElement input) {
						for (Function<String, String> normalizer : normalizers) {
							final String newName = normalizer.apply(input.name());
							if (newName != null) {
								return new AliasedScopedElement(newName, input);
							}
						}
						return null;
					}
				});
		return filter(transformed, Predicates.notNull());
	}

	protected EObject createProxy(EObjectDescriptor from) {
		EClass eClass = from.getEClass();
		EObject proxy = eClass.getEPackage().getEFactoryInstance().create(eClass);
		((InternalEObject) proxy).eSetProxyURI(from.getFragmentURI());
		return proxy;
	}

	protected IScope getGlobalScope(final EObject context, final EClass type) {
		return new SimpleScope(null) {

			@Override
			public Iterable<IScopedElement> getContents() {
				return indexStore.executeQueryCommand(new ConvertAll(context, type));
			}

			@Override
			public IScopedElement getContentByName(String name) {
				return indexStore.executeQueryCommand(new FindByName(context, type, name));
			}

			@Override
			public IScopedElement getContentByEObject(EObject object) {
				return indexStore.executeQueryCommand(new FindByEObject(context, type, object));
			}
		};
	}

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	private static final class FindByEObject extends AbstractIndexQuery implements QueryCommand<IScopedElement> {

		private EObject object;

		public FindByEObject(EObject context, EClass type, EObject object) {
			super(context, type);
			this.object = object;
		}

		public IScopedElement execute(QueryExecutor queryExecutor, Index index) {
			EObjectDescriptorQuery query = createQuery();

			ResourceDescriptorQuery resourceQuery = new ResourceDescriptorQuery();
			resourceQuery.setURI(object.eResource().getURI());
			query.setResourceQuery(resourceQuery);
			query.setFragment(EcoreUtil.getURI(object).fragment());

			QueryResult<EObjectDescriptor> result = queryExecutor.execute(query, index);
			for (EObjectDescriptor desc : result) {
				EObject proxy = Descriptors.createProxy(desc);
				return ScopedElement.create(desc.getName(), proxy);
			}
			return null;
		}
	}

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	private final static class FindByName extends AbstractIndexQuery implements QueryCommand<IScopedElement> {

		private String name;

		public FindByName(EObject context, EClass type, String name) {
			super(context, type);
			this.name = name;
		}

		public IScopedElement execute(QueryExecutor queryExecutor, Index index) {
			EObjectDescriptorQuery query = createQuery();
			query.setNameEquals(name);
			QueryResult<EObjectDescriptor> result = queryExecutor.execute(query, index);
			for (EObjectDescriptor desc : result) {
				EObject proxy = Descriptors.createProxy(desc);
				return ScopedElement.create(desc.getName(), proxy);
			}
			return null;
		}

	}

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	private static final class ConvertAll extends AbstractIndexQuery implements QueryCommand<Iterable<IScopedElement>> {

		public ConvertAll(EObject context, EClass type) {
			super(context, type);
		}

		public Iterable<IScopedElement> execute(QueryExecutor queryExecutor, Index index) {
			QueryResult<EObjectDescriptor> result = queryExecutor.execute(createQuery(), index);
			ArrayList<IScopedElement> elements = new ArrayList<IScopedElement>();
			for (EObjectDescriptor desc : result) {
				EObject proxy = Descriptors.createProxy(desc);
				IScopedElement element = ScopedElement.create(desc.getName(), proxy);
				elements.add(element);
			}
			return elements;
		}
	}

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	abstract static class AbstractIndexQuery {

		private EClass type;
		private EObject context;

		public AbstractIndexQuery(EObject context, EClass type) {
			this.context = context;
			this.type = type;
		}

		public EObjectDescriptorQuery createQuery() {

			EObjectDescriptorQuery query = new EObjectDescriptorQuery();
			query.setIsInstanceOf(type);

			if (context != null) {
				URI resourceURI = context.eResource().getURI();
				ResourceDescriptorQuery resourceQuery = new ResourceDescriptorQuery();
				resourceQuery.getURINotIn().add(resourceURI);
				query.setResourceQuery(resourceQuery);
			}

			return query;
		}
	}

}
