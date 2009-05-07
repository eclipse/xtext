/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl.memory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;
import org.eclipse.emf.index.impl.DefaultQueryTool;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EClassDAOImpl extends BasicMemoryDAOImpl<EClassDescriptor> implements EClassDescriptor.DAO {

	private static final long serialVersionUID = -1180283728678782547L;

	protected transient InverseReferenceCache<EPackageDescriptor, EClassDescriptor> ePackageScope;
	protected transient InverseReferenceCache<EClassDescriptor, EClassDescriptor> superClassScope;

	@Override
	public void store(EClassDescriptor element) {
		super.store(element);
		ePackageScope.put(element);
		superClassScope.put(element);
	}

	@Override
	public void delete(EClassDescriptor element) {
		super.delete(element);
		ePackageScope.remove(element);
		superClassScope.remove(element);
	}

	@Override
	protected boolean doModify(EClassDescriptor element, EClassDescriptor newValues) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void initialize(IndexStore indexStore) {
		super.initialize(indexStore);
		ePackageScope = new InverseReferenceCache<EPackageDescriptor, EClassDescriptor>() {
			@Override
			protected List<EPackageDescriptor> targets(EClassDescriptor source) {
				return Collections.singletonList(source.getEPackageDescriptor());
			}
		};
		superClassScope = new InverseReferenceCache<EClassDescriptor, EClassDescriptor>() {
			@Override
			protected List<EClassDescriptor> targets(EClassDescriptor source) {
				return source.getSuperClasses() != null ? Arrays.asList(source.getSuperClasses())
						: new ArrayList<EClassDescriptor>(0);
			}
		};
		for(EClassDescriptor eClassDescriptor:store) {
			ePackageScope.put(eClassDescriptor);
			superClassScope.put(eClassDescriptor);
		}
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

	protected class EClassQuery extends BasicMemoryDAOImpl<EClassDescriptor>.Query implements EClassDescriptor.Query {

		private String namePattern;
		private EPackageDescriptor ePackageDescriptor;
		private EPackageDescriptor.Query ePackageQuery;
		private EClassDescriptor superClassDescriptor;
		private EClassDescriptor.Query superClassQuery;

		public EClassDescriptor.Query name(String pattern) {
			this.namePattern = pattern;
			return this;
		}

		public EClassQuery ePackage(EPackageDescriptor ePackageDescriptor) {
			if (ePackageQuery != null) {
				throw new IllegalStateException("EPackageScope already configured");
			}
			this.ePackageDescriptor = ePackageDescriptor;
			return this;
		}

		public EPackageDescriptor.Query ePackage() {
			if (ePackageDescriptor != null) {
				throw new IllegalStateException("EPackageScope already configured");
			}
			ePackageQuery = indexStore.ePackageDAO().createQuery();
			return ePackageQuery;
		}

		public EClassDescriptor.Query superClass() {
			if (superClassDescriptor != null) {
				throw new IllegalStateException("ESuperClassScope already configured");
			}
			superClassQuery = indexStore.eClassDAO().createQuery();
			return superClassQuery;
		}

		public EClassDescriptor.Query superClass(EClassDescriptor eClassDescriptor) {
			if (superClassQuery != null) {
				throw new IllegalStateException("ESuperClassScope already configured");
			}
			superClassDescriptor = eClassDescriptor;
			return this;
		}

		@Override
		protected boolean matches(EClassDescriptor typeDescriptor) {
			return matchesGlobbing(typeDescriptor.getName(), namePattern);
		}

		@Override
		protected Collection<EClassDescriptor> scope() {
			Collection<EClassDescriptor> eClassesByEPackage = ePackageScope.lookup(ePackageDescriptor, ePackageQuery);
			Collection<EClassDescriptor> eClassesBySuperClass = superClassScope.lookup(superClassDescriptor,
					superClassQuery);
			Collection<EClassDescriptor> mergedScopes = mergeScopes(eClassesByEPackage, eClassesBySuperClass);
			return (mergedScopes == null) ? super.scope() : mergedScopes;
		}
	}
	
}
