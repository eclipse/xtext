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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;
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
	 * @author Sven Efftinge - Initial contribution and API
	 */
	public class WrappingScope implements IScope {
		
		private IScope delegate;
		public WrappingScope(IScope scope) {
			this.delegate = scope;
		}
		
		public Iterable<IEObjectDescription> getElements(final ISelector selector) {
			if (selector instanceof ISelector.SelectByName) {
				final QualifiedName name = ((ISelector.SelectByName) selector).getName().toLowerCase();
				final Iterable<IEObjectDescription> elements = delegate.getElements(selector);
				return new Iterable<IEObjectDescription>() {
					public Iterator<IEObjectDescription> iterator() {
						importedNames.add(name);
						return elements.iterator();
					}
				};
			} else {
				handleNoSelectNameQuery(selector);
			}
			return delegate.getElements(selector);
		}

		protected void handleNoSelectNameQuery(ISelector selector) {
			if (log.isInfoEnabled())
				log.info("getElements should be called without a SelectByName selector during linking.");
		}
		
		public IEObjectDescription getSingleElement(ISelector selector) {
			if (selector instanceof ISelector.SelectByName) {
				final QualifiedName name = ((ISelector.SelectByName) selector).getName().toLowerCase();
				importedNames.add(name);
			} else {
				handleNoSelectNameQuery(selector);
			}
			return delegate.getSingleElement(selector);
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
