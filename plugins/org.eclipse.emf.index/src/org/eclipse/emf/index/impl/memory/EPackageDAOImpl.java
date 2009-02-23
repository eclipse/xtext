/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl.memory;

import java.util.Date;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.index.EPackageDescriptor;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.impl.DefaultQueryTool;

public class EPackageDAOImpl extends BasicMemoryDAOImpl<EPackageDescriptor> implements EPackageDescriptor.DAO {

	public EPackageDAOImpl(IIndexStore indexStore) {
		super(indexStore);
	}

	public EPackageDescriptor.Query createQuery() {
		return new EPackageQuery();
	}

	public IGenericQuery<EPackageDescriptor> createQueryEPackage(EPackage ePackage) {
		return DefaultQueryTool.createQueryEPackage(this, ePackage);
	}

	private class EPackageQuery extends BasicMemoryDAOImpl<EPackageDescriptor>.Query implements
			EPackageDescriptor.Query {

		private static final long UNSET_DATE = Long.MIN_VALUE;
		private String nsURIPattern;
		private String namePattern;
		private long indexingDate = UNSET_DATE;

		public EPackageDescriptor.Query indexingDate(long date) {
			this.indexingDate = date;
			return this;
		}

		public EPackageDescriptor.Query indexingDate(Date date) {
			this.indexingDate = date.getTime();
			return this;
		}

		public EPackageDescriptor.Query name(String pattern) {
			this.namePattern = pattern;
			return this;
		}

		public EPackageDescriptor.Query nsURI(String pattern) {
			this.nsURIPattern = pattern;
			return this;
		}

		@Override
		protected boolean matches(EPackageDescriptor ePackageDescriptor) {
			return ((indexingDate == UNSET_DATE || indexingDate == ePackageDescriptor.getIndexingDate())
					&& matchesGlobbing(ePackageDescriptor.getName(), namePattern) && matchesGlobbing(ePackageDescriptor
					.getNsURI(), nsURIPattern));
		}

	}
}
