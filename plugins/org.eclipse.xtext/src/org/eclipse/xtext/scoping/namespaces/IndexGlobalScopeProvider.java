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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.query.ContainerDescriptorQuery;
import org.eclipse.emf.emfindex.query.EObjectDescriptorQuery;
import org.eclipse.emf.emfindex.query.QueryCommand;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.query.QueryResult;
import org.eclipse.emf.emfindex.query.ResourceDescriptorQuery;
import org.eclipse.xtext.index.IXtextIndex;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IndexGlobalScopeProvider extends AbstractScopeProvider implements IGlobalScopeProvider {
	
	public static Logger log = Logger.getLogger(IndexGlobalScopeProvider.class);

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

	public IScope getScope(final EObject context, EReference reference) {
		IScope parent = IScope.NULLSCOPE;
		for (String dependentContainerName : Iterables.reverse(containerDependencyProvider
				.getReferencedContainers(context))) {
			parent = createIndexScope(parent, dependentContainerName, context, reference);
		}
		String container = containerDependencyProvider.getContainer(context);
		return createIndexScope(parent, container, context, reference);
	}

	protected SimpleScope createIndexScope(IScope parent, final String project, final EObject context, final EReference reference) {
		return new SimpleScope(parent, null) {

			@Override
			public Iterable<IEObjectDescription> internalGetContents() {
				return getIndexStore().executeQueryCommand(new ConvertAll(project, context, reference));
			}

			@Override
			public IEObjectDescription getContentByName(String name) {
				EObjectDescriptor desc = getIndexStore().executeFindEObjectByName(context, project, reference.getEReferenceType(), name);
				if(desc!=null) {
					EObject proxy = desc.createProxy();
					return EObjectDescription.create(desc.getName(), proxy);
				}
				return getOuterScope().getContentByName(name);
			}

			@Override
			public IEObjectDescription getContentByEObject(EObject object) {
				IEObjectDescription local = getIndexStore().executeQueryCommand(new FindByEObject(project, context, reference, object));
				if (local != null)
					return local;
				return getOuterScope().getContentByEObject(object);
			}
		};
	}

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	static final class FindByEObject extends AbstractIndexQuery implements QueryCommand<IEObjectDescription> {

		private EObject object;

		public FindByEObject(String project, EObject context, final EReference reference, EObject object) {
			super(project, context, reference);
			this.object = object;
		}

		public IEObjectDescription execute(QueryExecutor queryExecutor) {
			EObjectDescriptorQuery query = createQuery();

			ResourceDescriptorQuery resourceQuery = new ResourceDescriptorQuery();
			resourceQuery.setURI(object.eResource().getURI());
			query.setResourceQuery(resourceQuery);
			query.setFragment(EcoreUtil.getURI(object).fragment());

			QueryResult<EObjectDescriptor> result = queryExecutor.execute(query);
			for (EObjectDescriptor desc : result) {
				EObject proxy = desc.createProxy();
				return EObjectDescription.create(desc.getName(), proxy);
			}
			return null;
		}
	}

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	static final class ConvertAll extends AbstractIndexQuery implements QueryCommand<Iterable<IEObjectDescription>> {

		public ConvertAll(String project, EObject context, final EReference reference) {
			super(project, context, reference);
		}

		public Iterable<IEObjectDescription> execute(QueryExecutor queryExecutor) {
			QueryResult<EObjectDescriptor> result = queryExecutor.execute(createQuery());
			ArrayList<IEObjectDescription> elements = new ArrayList<IEObjectDescription>();
			for (EObjectDescriptor desc : result) {
				EObject proxy = desc.createProxy();
				IEObjectDescription element = EObjectDescription.create(desc.getName(), proxy);
				elements.add(element);
			}
			return elements;
		}
	}

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	abstract static class AbstractIndexQuery {

		private EReference reference;
		private EObject context;
		private String project;

		public AbstractIndexQuery(String project, EObject context, final EReference reference) {
			this.context = context;
			this.reference = reference;
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
			query.setIsInstanceOf(reference.getEReferenceType());

			return query;
		}
	}

}
