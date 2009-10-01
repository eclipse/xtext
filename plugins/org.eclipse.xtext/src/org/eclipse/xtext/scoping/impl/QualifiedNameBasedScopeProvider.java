/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;


/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class QualifiedNameBasedScopeProvider { //extends AbstractScopeProvider {

//	/**
//	 * @author Sven Efftinge - Initial contribution and API
//	 * 
//	 */
//	public static class ImportNormalizer {
//		private final List<String> elements;
//		private IQualifiedNameProvider nameProvider;
//		private boolean isWildCard;
//
//		public ImportNormalizer(List<String> importedNamespace, IQualifiedNameProvider nameProvider) {
//			this.elements = importedNamespace;
//			this.isWildCard = nameProvider.getWildcard().equals(lastElement(importedNamespace));
//			this.nameProvider = nameProvider;
//		}
//
//		private String lastElement(List<String> importedNamespace) {
//			return importedNamespace.get(importedNamespace.size() - 1);
//		}
//
//		public String shortToLongName(String shortName) {
//			if (!isWildCard) {
//				if (elements.get(elements.size() - 1).equals(shortName)) {
//					return Strings.concat(nameProvider.getDelimiter(), elements);
//				}
//			} else {
//				List<String> withoutWildCard = elements.subList(0, elements.size()-1);
//				ArrayList<String> concatenated = new ArrayList<String>(withoutWildCard);
//				concatenated.add(shortName);
//				return Strings.concat(nameProvider.getDelimiter(), concatenated);
//			}
//			return null;
//		}
//
//		public String longToShortName(String from) {
//			if (!isWildCard) {
//				if (lastElement(elements).equals(from)) {
//					return Strings.concat(nameProvider.getDelimiter(), elements);
//				}
//			}
//			List<String> split = Strings.split(from, nameProvider.getDelimiter());
//			if (split.size() >= elements.size()) {
//				Iterator<String> i1 = elements.iterator(), i2 = split.iterator();
//				boolean proceed = i1.hasNext() && i2.hasNext();
//				while (proceed) {
//					String s1 = i1.next();
//					String s2 = i2.next();
//					if (!s1.equals(s2)) {
//						if (!s1.equals(nameProvider.getWildcard())) {
//							break;
//						}
//						else {
//							StringBuffer result = new StringBuffer(s2);
//							while (i2.hasNext()) {
//								result.append(nameProvider.getDelimiter());
//								result.append(i2.next());
//							}
//							return result.toString();
//						}
//					}
//					else if (!i1.hasNext() && !i2.hasNext()) {
//						return s2;
//					}
//				}
//			}
//			return null;
//		}
//	}
//
//	@Inject
//	private IQualifiedNameProvider nameProvider;
//
//	public void setNameProvider(IQualifiedNameProvider nameProvider) {
//		this.nameProvider = nameProvider;
//	}
//
//	public IQualifiedNameProvider getNameProvider() {
//		return nameProvider;
//	}
//
//	private Index indexStore;
//
//	@Inject(optional = true)
//	public void setIndexStore(Index indexStore) {
//		this.indexStore = indexStore;
//	}
//
//	public Index getIndexStore() {
//		return indexStore;
//	}
//
//	public IScope getScope(EObject context, EReference reference) {
//		return getScope(context, reference.getEReferenceType());
//	}
//
//	public IScope getScope(final EObject context, final EClass type) {
//		if (context == null)
//			return getGlobalScope(null, type);
//		IScope result = null;
//		if (context.eContainer() == null) {
//			// global scope
//			result = getGlobalScope(context, type);
//			result = getResourceSetScope(result, context, type);
//			result = getResourceScope(result, context, type);
//		}
//		else {
//			// outer scope
//			result = getScope(context.eContainer(), type);
//		}
//
//		// local scope used by the import scope
//		if (hasImports(context)) {
//			IScope localElements = getLocalElements(result, context, type);
//			// imports
//			result = getImportedElements(result, localElements, context, type);
//		}
//		// local scope
//		if (nameProvider.getQualifiedName(context) != null) {
//			result = getLocalElements(result, context, type);
//		}
//		return result;
//	}
//
//	protected boolean hasImports(final EObject context) {
//		return !getImportNormalizer(context).isEmpty();
//	}
//
//	protected IScope getResourceSetScope(final IScope parent, final EObject context, final EClass type) {
//		if (context.eResource() == null || context.eResource().getResourceSet() == null)
//			return parent;
//		Iterable<EObject> contents = new Iterable<EObject>() {
//			public Iterator<EObject> iterator() {
//				return EcoreUtil.getAllProperContents(context.eResource().getResourceSet(), true);
//			}
//		};
//		Iterable<EObject> filtered = Iterables.filter(contents, EObject.class);
//		return createScopeWithQualifiedNames(parent, type, filtered);
//	}
//
//	protected IScope getResourceScope(IScope parent, final EObject context, final EClass type) {
//		if (context.eResource() == null)
//			return parent;
//		Iterable<EObject> contents = new Iterable<EObject>() {
//			public Iterator<EObject> iterator() {
//				return EcoreUtil.getAllProperContents(context.eResource(), true);
//			}
//		};
//		return createScopeWithQualifiedNames(parent, type, contents);
//	}
//
//	protected IScope getLocalElements(IScope parent, final EObject context, final EClass type) {
//		final String commonPrefix = nameProvider.getQualifiedName(context) + nameProvider.getDelimiter();
//
//		Iterable<EObject> contents = new Iterable<EObject>() {
//			public Iterator<EObject> iterator() {
//				return EcoreUtil.getAllProperContents(context, true);
//			}
//		};
//		// filter by type
//		contents = filter(contents, typeFilter(type));
//		// transform to IScopedElements
//		Iterable<IScopedElement> scopedElements = Scopes.scopedElementsFor(contents, new Function<EObject, String>() {
//			public String apply(EObject from) {
//				String name = nameProvider.getQualifiedName(from);
//				if (name != null && name.startsWith(commonPrefix))
//					return name.substring(commonPrefix.length());
//				return null;
//			}
//		});
//		// filter null values;
//		return new SimpleScope(parent, filter(scopedElements, Predicates.notNull()));
//	}
//
//	protected IScope createScopeWithQualifiedNames(final IScope parent, final EClass type, Iterable<EObject> eObjects) {
//
//		eObjects = filter(eObjects, typeFilter(type));
//
//		Iterable<IScopedElement> result = transform(eObjects, new Function<EObject, IScopedElement>() {
//
//			public IScopedElement apply(EObject from) {
//				String qualifiedName = nameProvider.getQualifiedName(from);
//				if (qualifiedName != null) {
//					return ScopedElement.create(qualifiedName, from);
//				}
//				return null;
//			}
//		});
//		return new SimpleScope(parent, filter(result, Predicates.notNull()));
//	}
//
//	protected Predicate<EObject> typeFilter(final EClass type) {
//		return new Predicate<EObject>() {
//
//			public boolean apply(EObject input) {
//				return type.isInstance(input);
//			}
//		};
//	}
//
//	protected Set<ImportNormalizer> getImportNormalizer(EObject context) {
//		Set<ImportNormalizer> namespaceImports = new HashSet<ImportNormalizer>();
//		SimpleAttributeResolver<EObject, String> importResolver = SimpleAttributeResolver.newResolver(String.class,
//				"importedNamespace");
//		for (EObject child : context.eContents()) {
//			String value = importResolver.getValue(child);
//			if (value != null) {
//				final List<String> elements = org.eclipse.xtext.util.Strings.split(value, nameProvider.getDelimiter());
//				namespaceImports.add(createImportNormalizer(elements));
//			}
//		}
//		return namespaceImports;
//	}
//
//	protected ImportNormalizer createImportNormalizer(final List<String> elements) {
//		return new ImportNormalizer(elements, nameProvider);
//	}
//
//	protected IScope getImportedElements(IScope parent, final IScope localElements, final EObject context, final EClass type) {
//		final Set<ImportNormalizer> normalizers = getImportNormalizer(context);
//
//		Iterable<IScopedElement> transformed = transform(localElements.getAllContents(),
//				new Function<IScopedElement, IScopedElement>() {
//
//					public IScopedElement apply(final IScopedElement input) {
//						for (ImportNormalizer normalizer : normalizers) {
//							final String newName = normalizer.longToShortName(input.name());
//							if (newName != null) {
//								return new AliasedScopedElement(newName, input);
//							}
//						}
//						return null;
//					}
//				});
//		return new SimpleScope(parent, filter(transformed, Predicates.notNull())) {
//
//			@Override
//			public IScopedElement getContentByName(String name) {
//				for (ImportNormalizer normalizer : normalizers) {
//					IScopedElement element = localElements.getContentByName(normalizer.shortToLongName(name));
//					if (element!=null)
//						return element;
//				}
//				return null; 
//			}
//		};
//	}
//
//	protected EObject createProxy(EObjectDescriptor from) {
//		EClass eClass = from.getEClass();
//		EObject proxy = eClass.getEPackage().getEFactoryInstance().create(eClass);
//		((InternalEObject) proxy).eSetProxyURI(from.getFragmentURI());
//		return proxy;
//	}
//
//	protected IScope getGlobalScope(final EObject context, final EClass type) {
//		if (getIndexStore() == null)
//			return IScope.NULLSCOPE;
//		return new SimpleScope(null) {
//
//			@Override
//			public Iterable<IScopedElement> getContents() {
//				return getIndexStore().executeQueryCommand(new ConvertAll(context, type));
//			}
//
//			@Override
//			public IScopedElement getContentByName(String name) {
//				return getIndexStore().executeQueryCommand(new FindByName(context, type, name));
//			}
//
//			@Override
//			public IScopedElement getContentByEObject(EObject object) {
//				return getIndexStore().executeQueryCommand(new FindByEObject(context, type, object));
//			}
//		};
//	}
//
//	/**
//	 * @author Sven Efftinge - Initial contribution and API
//	 */
//	private static final class FindByEObject extends AbstractIndexQuery implements QueryCommand<IScopedElement> {
//
//		private EObject object;
//
//		public FindByEObject(EObject context, EClass type, EObject object) {
//			super(context, type);
//			this.object = object;
//		}
//
//		public IScopedElement execute(QueryExecutor queryExecutor) {
//			EObjectDescriptorQuery query = createQuery();
//
//			ResourceDescriptorQuery resourceQuery = new ResourceDescriptorQuery();
//			resourceQuery.setURI(object.eResource().getURI());
//			query.setResourceQuery(resourceQuery);
//			query.setFragment(EcoreUtil.getURI(object).fragment());
//
//			QueryResult<EObjectDescriptor> result = queryExecutor.execute(query);
//			for (EObjectDescriptor desc : result) {
//				EObject proxy = Descriptors.createProxy(desc);
//				return ScopedElement.create(desc.getName(), proxy);
//			}
//			return null;
//		}
//	}
//
//	/**
//	 * @author Sven Efftinge - Initial contribution and API
//	 */
//	private final static class FindByName extends AbstractIndexQuery implements QueryCommand<IScopedElement> {
//
//		private String name;
//
//		public FindByName(EObject context, EClass type, String name) {
//			super(context, type);
//			this.name = name;
//		}
//
//		public IScopedElement execute(QueryExecutor queryExecutor) {
//			EObjectDescriptorQuery query = createQuery();
//			query.setNameEquals(name);
//			QueryResult<EObjectDescriptor> result = queryExecutor.execute(query);
//			for (EObjectDescriptor desc : result) {
//				EObject proxy = Descriptors.createProxy(desc);
//				return ScopedElement.create(desc.getName(), proxy);
//			}
//			return null;
//		}
//
//	}
//
//	/**
//	 * @author Sven Efftinge - Initial contribution and API
//	 */
//	private static final class ConvertAll extends AbstractIndexQuery implements QueryCommand<Iterable<IScopedElement>> {
//
//		public ConvertAll(EObject context, EClass type) {
//			super(context, type);
//		}
//
//		public Iterable<IScopedElement> execute(QueryExecutor queryExecutor) {
//			QueryResult<EObjectDescriptor> result = queryExecutor.execute(createQuery());
//			ArrayList<IScopedElement> elements = new ArrayList<IScopedElement>();
//			for (EObjectDescriptor desc : result) {
//				EObject proxy = Descriptors.createProxy(desc);
//				IScopedElement element = ScopedElement.create(desc.getName(), proxy);
//				elements.add(element);
//			}
//			return elements;
//		}
//	}
//
//	/**
//	 * @author Sven Efftinge - Initial contribution and API
//	 */
//	abstract static class AbstractIndexQuery {
//
//		private EClass type;
//		private EObject context;
//
//		public AbstractIndexQuery(EObject context, EClass type) {
//			this.context = context;
//			this.type = type;
//		}
//
//		public EObjectDescriptorQuery createQuery() {
//
//			EObjectDescriptorQuery query = new EObjectDescriptorQuery();
//			query.setIsInstanceOf(type);
//
//			if (context != null) {
//				URI resourceURI = context.eResource().getURI();
//				ResourceDescriptorQuery resourceQuery = new ResourceDescriptorQuery();
//				resourceQuery.getURINotIn().add(resourceURI);
//				query.setResourceQuery(resourceQuery);
//			}
//
//			return query;
//		}
//	}

}
