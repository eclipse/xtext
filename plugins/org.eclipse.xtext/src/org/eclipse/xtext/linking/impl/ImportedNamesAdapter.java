/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.IScopeWrapper;

/**
 * Wraps global scopes and collects and holds all names for which global scopes have been asked.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class ImportedNamesAdapter extends AdapterImpl implements IScopeWrapper {
	
	private final static Logger log = Logger.getLogger(ImportedNamesAdapter.class);
	
	public static ImportedNamesAdapter find(Resource resource) {
		for (Adapter adapter : resource.eAdapters()) {
			if (adapter instanceof ImportedNamesAdapter) {
				return (ImportedNamesAdapter) adapter;
			}
		}
		return null;
	}
	
	/**
	 * @since 2.7
	 */
	public static ImportedNamesAdapter findOrInstall(Resource resource) {
		ImportedNamesAdapter adapter = find(resource);
		if (adapter!=null)
			return adapter;
		ImportedNamesAdapter importedNamesAdapter = new ImportedNamesAdapter();
		resource.eAdapters().add(importedNamesAdapter);
		return importedNamesAdapter;
	}

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	public class WrappingScope implements IScope {
		
		private final IScope delegate;
		
		public WrappingScope(IScope scope) {
			this.delegate = scope;
		}
		
		public IEObjectDescription getSingleElement(QualifiedName name) {
			final QualifiedName lowerCase = name.toLowerCase();
			importedNames.add(lowerCase);
			return delegate.getSingleElement(name);
		}
		
		public Iterable<IEObjectDescription> getElements(final QualifiedName name) {
			return new Iterable<IEObjectDescription>() {
				public Iterator<IEObjectDescription> iterator() {
					final QualifiedName lowerCase = name.toLowerCase();
					importedNames.add(lowerCase);
					final Iterable<IEObjectDescription> elements = delegate.getElements(name);
					return elements.iterator();
				}
			};
		}
		
		public Iterable<IEObjectDescription> getElements(EObject object) {
			handleNoNameQuery();
			return delegate.getElements(object);
		}
		
		public IEObjectDescription getSingleElement(EObject object) {
			handleNoNameQuery();
			return delegate.getSingleElement(object);
		}
		
		public Iterable<IEObjectDescription> getAllElements() {
			handleNoNameQuery();
			return delegate.getAllElements();
		}
		
		protected void handleNoNameQuery() {
			if (log.isInfoEnabled())
				log.info("getElements should be called with a QualifiedName during linking.");
		}
		
		@Override
		public String toString() {
			return getClass().getSimpleName()+" -> "+delegate;
		}
	}

	private Set<QualifiedName> importedNames = new HashSet<QualifiedName>();
	
	public Set<QualifiedName> getImportedNames() {
		return importedNames;
	}

	public IScope wrap(IScope scope) {
		return new WrappingScope(scope);
	}

	public void clear() {
		importedNames.clear();
	}
}
