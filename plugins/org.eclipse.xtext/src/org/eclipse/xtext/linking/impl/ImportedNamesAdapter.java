/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
	 * @author Sven Efftinge - Initial contribution and API
	 */
	public class WrappingScope implements IScope {
		
		private IScope delegate;
		public WrappingScope(IScope scope) {
			this.delegate = scope;
		}

		public IEObjectDescription getContentByName(String name) {
			importedNames.add(name);
			return delegate.getContentByName(name);
		}
		
		public IScope getOuterScope() {
			return delegate.getOuterScope();
		}

		public Iterable<IEObjectDescription> getAllContents() {
			log.error("getAllContents shouldn't be called on a global scope during linking.", new IllegalStateException());
			return delegate.getAllContents();
		}

		public IEObjectDescription getContentByEObject(EObject object) {
			log.error("getContentByEObject shouldn't be called on a global scope during linking.", new IllegalStateException());
			return delegate.getContentByEObject(object);
		}

		public Iterable<IEObjectDescription> getContents() {
			log.error("getContents shouldn't be called on a global scope during linking.", new IllegalStateException());
			return delegate.getContents();
		}

	}

	private Set<String> importedNames = new HashSet<String>();
	
	public Set<String> getImportedNames() {
		return importedNames;
	}

	public IScope wrap(IScope scope) {
		return new WrappingScope(scope);
	}
}
