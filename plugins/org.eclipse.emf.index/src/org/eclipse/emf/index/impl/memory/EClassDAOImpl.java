/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl.memory;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.index.EClassDescriptor;
import org.eclipse.emf.index.EPackageDescriptor;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.impl.DefaultQueryTool;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EClassDAOImpl extends BasicCachingMemoryDAO<EClassDescriptor> implements EClassDescriptor.DAO {

	protected InverseReferenceCache<EPackageDescriptor, EClassDescriptor> ePackageScope;
	
	public EClassDAOImpl(IIndexStore indexStore) {
		super(indexStore);
		ePackageScope = new InverseReferenceCache<EPackageDescriptor, EClassDescriptor>(){
			@Override
			protected EPackageDescriptor target(EClassDescriptor source) {
				return source.getEPackageDescriptor();
			}
		};
	}
	
	@Override
	public void store(EClassDescriptor element) {
		super.store(element);
		ePackageScope.put(element);
	}
	
	@Override
	public void delete(EClassDescriptor element) {
		super.delete(element);
		ePackageScope.remove(element);
	}

	public EClassDescriptor.Query createQuery() {
		return new EClassQuery();
	}

	public EClassDescriptor.Query createQueryEClass(EClass eClass) {
		return DefaultQueryTool.createQueryEClass(this, eClass);
	}

	public IGenericQuery<EClassDescriptor> createQueryEClassesInPackage(EPackageDescriptor ePackageDescriptor) {
		return ePackageScope.createQuery(ePackageDescriptor);
	}
	
	protected class EClassQuery extends BasicCachingMemoryDAO<EClassDescriptor>.Query implements EClassDescriptor.Query {

		private String namePattern;
		private EPackageDescriptor ePackageDescriptor;
		private EPackageDescriptor.Query ePackageQuery;

		public EClassDescriptor.Query name(String pattern) {
			this.namePattern = pattern;
			return this;
		}

		public EClassQuery ePackage(EPackageDescriptor ePackageDescriptor) {
			if(ePackageQuery != null) {
				throw new IllegalStateException("EPackageScope already configured");
			}
			this.ePackageDescriptor = ePackageDescriptor;
			return this;
		}

		public EPackageDescriptor.Query ePackage() {
			if(ePackageDescriptor != null) {
				throw new IllegalStateException("EPackageScope already configured");
			}
			ePackageQuery = indexStore.ePackageDAO().createQuery();
			return ePackageQuery;
		}

		@Override
		protected boolean matches(EClassDescriptor typeDescriptor) {
			return (namePattern == null || namePattern.equals(typeDescriptor.getName()));
		}

		@Override
		protected Collection<EClassDescriptor> scope() {
			Collection<EClassDescriptor> eClassesByEPackage = ePackageScope.lookup(ePackageDescriptor, ePackageQuery);
			if(eClassesByEPackage == null) {
				return super.scope();
			}
			return eClassesByEPackage;
		}
	}
}
