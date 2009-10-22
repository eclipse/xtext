/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.namespaces;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.query.ContainerDescriptorQuery;
import org.eclipse.emf.emfindex.query.EObjectDescriptorQuery;
import org.eclipse.emf.emfindex.query.QueryCommand;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.query.QueryResult;
import org.eclipse.emf.emfindex.query.ResourceDescriptorQuery;
import org.eclipse.xtext.index.IXtextIndex;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopedElement;
import org.eclipse.xtext.scoping.impl.ScopedElement;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IndexBasedQualifiedNameScopeProvider extends QualifiedNameBasedScopeProvider {
	
	static class Descriptors {

		public static EObject createProxy(EObjectDescriptor desc) {
			EObject object = desc.getEClass().getEPackage().getEFactoryInstance().create(desc.getEClass());
			((InternalEObject)object).eSetProxyURI(desc.getFragmentURI());
			return object;
		}
		
	}

	public static Logger log = Logger.getLogger(IndexBasedQualifiedNameScopeProvider.class);

	private IXtextIndex indexStore;

	@Inject(optional = true)
	public void setIndexStore(IXtextIndex indexStore) {
		this.indexStore = indexStore;
	}

	public IXtextIndex getIndexStore() {
		return indexStore;
	}

	private IContainerDependencyProvider containerDependencyProvider = new IContainerDependencyProvider.Null();

	@Inject
	public void setDependenciesProvider(IContainerDependencyProvider containerDependencyProvider) {
		this.containerDependencyProvider = containerDependencyProvider;
	}

	@Override
	protected IScope getGlobalScope(final EObject context, EClass type) {
		IScope parent = IScope.NULLSCOPE;
		for (String dependentContainerName : Iterables.reverse(containerDependencyProvider
				.getReferencedContainers(context))) {
			parent = createIndexScope(parent, dependentContainerName, context, type);
		}
		String container = containerDependencyProvider.getContainer(context);
		return createIndexScope(parent, container, context, type);
	}

	protected SimpleScope createIndexScope(IScope parent, final String project, final EObject context, final EClass type) {
		return new SimpleScope(parent, null) {

			@Override
			public Iterable<IScopedElement> getContents() {
				return getIndexStore().executeQueryCommand(new ConvertAll(project, context, type));
			}

			@Override
			public IScopedElement getContentByName(String name) {
				EObjectDescriptor desc = getIndexStore().executeFindEObjectByName(context, project, type, name);
				if(desc!=null) {
					EObject proxy = Descriptors.createProxy(desc);
					return ScopedElement.create(desc.getName(), proxy);
				}
				return getOuterScope().getContentByName(name);
			}

			@Override
			public IScopedElement getContentByEObject(EObject object) {
				IScopedElement local = getIndexStore().executeQueryCommand(new FindByEObject(project, context, type, object));
				if (local != null)
					return local;
				return getOuterScope().getContentByEObject(object);
			}
		};
	}

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	static final class FindByEObject extends AbstractIndexQuery implements QueryCommand<IScopedElement> {

		private EObject object;

		public FindByEObject(String project, EObject context, EClass type, EObject object) {
			super(project, context, type);
			this.object = object;
		}

		public IScopedElement execute(QueryExecutor queryExecutor) {
			EObjectDescriptorQuery query = createQuery();

			ResourceDescriptorQuery resourceQuery = new ResourceDescriptorQuery();
			resourceQuery.setURI(object.eResource().getURI());
			query.setResourceQuery(resourceQuery);
			query.setFragment(EcoreUtil.getURI(object).fragment());

			QueryResult<EObjectDescriptor> result = queryExecutor.execute(query);
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
	static final class ConvertAll extends AbstractIndexQuery implements QueryCommand<Iterable<IScopedElement>> {

		public ConvertAll(String project, EObject context, EClass type) {
			super(project, context, type);
		}

		public Iterable<IScopedElement> execute(QueryExecutor queryExecutor) {
			QueryResult<EObjectDescriptor> result = queryExecutor.execute(createQuery());
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
		private String project;

		public AbstractIndexQuery(String project, EObject context, EClass type) {
			this.context = context;
			this.type = type;
			this.project = project;
		}

		public EObjectDescriptorQuery createQuery() {
			ResourceDescriptorQuery resourceQuery = new ResourceDescriptorQuery();
			if (project != null) {
				ContainerDescriptorQuery containerQuery = new ContainerDescriptorQuery();
				containerQuery.setName(project);
				resourceQuery.setContainerQuery(containerQuery);
			}
			resourceQuery.getURINotIn().add(context.eResource().getURI());

			EObjectDescriptorQuery query = new EObjectDescriptorQuery();
			query.setResourceQuery(resourceQuery);
			query.setIsInstanceOf(type);

			return query;
		}
	}
}
