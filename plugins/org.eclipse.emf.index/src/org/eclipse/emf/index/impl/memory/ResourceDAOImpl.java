/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl.memory;

import java.util.Date;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.impl.DefaultQueryTool;
import org.eclipse.emf.index.impl.ResourceDescriptorImpl;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ResourceDAOImpl extends BasicMemoryDAOImpl<ResourceDescriptor> implements ResourceDescriptor.DAO {

	private static final long serialVersionUID = -1273324973049478671L;

	@Override
	protected boolean doModify(ResourceDescriptor element, ResourceDescriptor newValues) {
		return ((ResourceDescriptorImpl) element).copyDetails(newValues);
	}

	public ResourceDescriptor.Query createQuery() {
		return new ResourceQuery();
	}

	public ResourceDescriptor.Query createQueryResource(Resource resource) {
		return DefaultQueryTool.createQueryResource(this, resource);
	}

	private class ResourceQuery extends BasicMemoryDAOImpl<ResourceDescriptor>.Query implements
			ResourceDescriptor.Query {

		private static final long UNSET_DATE = Long.MIN_VALUE;
		private String uriPattern;
		private long indexingDate = UNSET_DATE;

		public ResourceDescriptor.Query uri(String pattern) {
			this.uriPattern = pattern;
			return this;
		}

		public ResourceDescriptor.Query indexingDate(long date) {
			this.indexingDate = date;
			return this;
		}

		public ResourceDescriptor.Query indexingDate(Date date) {
			this.indexingDate = date.getTime();
			return this;
		}

		protected boolean matches(ResourceDescriptor resourceDescriptor) {
			return matchesGlobbing(resourceDescriptor.getURI(), uriPattern)
					&& (indexingDate == UNSET_DATE || indexingDate == resourceDescriptor.getIndexingDate());
		}
	}

}
