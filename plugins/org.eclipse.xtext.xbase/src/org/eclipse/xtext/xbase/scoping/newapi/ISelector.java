/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.newapi;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface ISelector extends Predicate<IEObjectDescription> {
	
	public final static ISelector SELECT_ALL = new ISelector(){
		public boolean apply(IEObjectDescription input) {
			return true;
		}};
	
	static class SelectByName implements ISelector {

		private String name;

		public boolean apply(IEObjectDescription input) {
			return name.equals(input.getName());
		}
		
		public SelectByName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}
	
	static class SelectByEObject implements ISelector {
		
		private EObject eObject;
		private URI uri;
		
		public SelectByEObject(EObject eObject) {
			this.eObject = eObject;
			this.uri = EcoreUtil.getURI(eObject);
		}
		
		public boolean apply(IEObjectDescription input) {
			return uri.equals(input.getEObjectURI());
		}
		
		public EObject getEObject() {
			return eObject;
		}
		
		public URI getUri() {
			return uri;
		}
	}
}
