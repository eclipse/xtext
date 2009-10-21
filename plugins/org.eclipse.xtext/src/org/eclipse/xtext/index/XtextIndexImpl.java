/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.index;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.query.ContainerDescriptorQuery;
import org.eclipse.emf.emfindex.query.EObjectDescriptorQuery;
import org.eclipse.emf.emfindex.query.QueryCommand;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.query.QueryResult;
import org.eclipse.emf.emfindex.query.ResourceDescriptorQuery;
import org.eclipse.emf.emfindex.store.UpdateableIndex;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextIndexImpl extends IndexDelegator implements IXtextIndex {
	
	@Inject
	public XtextIndexImpl(@Named("org.eclipse.xtext.index.IXtextIndex.delegate")UpdateableIndex delegate) {
		super(delegate);
	}

	public EObjectDescriptor executeFindEObjectByName(EObject context, String containerName, EClass type, String name) {
		FindByName findByName = new FindByName(containerName, context, type, name);
		return delegate.executeQueryCommand(findByName);
	}

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	final static class FindByName implements QueryCommand<EObjectDescriptor> {

		private String name;
		private EClass type;
		private EObject context;
		private String project;

		public FindByName(String project, EObject context, EClass type, String name) {
			this.context = context;
			this.type = type;
			this.project = project;
			this.name = name;
		}

		public EObjectDescriptor execute(QueryExecutor queryExecutor) {
			EObjectDescriptorQuery query = createQuery();
			query.setNameEquals(name);
			QueryResult<EObjectDescriptor> result = queryExecutor.execute(query);
			for (EObjectDescriptor desc : result) {
				return desc;
			}
			return null;
		}

		private EObjectDescriptorQuery createQuery() {
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

	public Iterable<URI> getPotentiallyInterestedResources(Set<String> names) {
		throw new UnsupportedOperationException();
	}
}
