/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeResource extends ResourceImpl {

	private IMirror mirror;
	
	public TypeResource() {
		super();
	}

	public TypeResource(URI uri) {
		super(uri);
	}

	@Override
	public EObject getEObject(String uriFragment) {
		if (mirror != null) {
			EObject result = mirror.getEObject(this, uriFragment);
			if (result != null)
				return result;
		}
		return super.getEObject(uriFragment);
	}
	
	@Override
	public String getURIFragment(EObject eObject) {
		if (mirror != null) {
			String result = mirror.getFragment(eObject);
			if (result != null)
				return result;
		}
		return super.getURIFragment(eObject);
	}

	public void setMirror(IMirror mirror) {
		this.mirror = mirror;
	}

	public IMirror getMirror() {
		return mirror;
	}
	
	@Override
	public void load(Map<?, ?> options) throws IOException {
		if (!isLoaded) {
			load(null, options);
		}
	}
	
	@Override
	public void save(Map<?, ?> options) throws IOException {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		if (getURI() != null && mirror != null) {
			mirror.initialize(this);
		}
	}
	
}
