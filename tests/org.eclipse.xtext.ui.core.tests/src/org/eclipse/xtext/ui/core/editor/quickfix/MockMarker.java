/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.quickfix;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.validation.Issue;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
final class MockMarker implements IMarker {

	private String type;
	private IResource resource;
	private EObject context;
	private Map<String, ?> attributes;

	public static MockMarker newFastErrorMarker(IResource resource, EObject context, Integer code) {
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
		if (context != null)
			attributes.put(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(context).toString());
		attributes.put(Issue.CODE_KEY, code);
		return new MockMarker(EValidator.MARKER, resource, context, attributes);
	}

	public MockMarker(String type, IResource resource, EObject context, Map<String, ?> attributes) {
		this.type = type;
		this.resource = resource;
		this.context = context;
		this.attributes = attributes;
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		return null;
	}

	public void setAttributes(String[] attributeNames, Object[] values) throws CoreException {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	public void setAttributes(Map attributes) throws CoreException {
		throw new UnsupportedOperationException();
	}

	public void setAttribute(String attributeName, boolean value) throws CoreException {
		throw new UnsupportedOperationException();
	}

	public void setAttribute(String attributeName, Object value) throws CoreException {
		throw new UnsupportedOperationException();
	}

	public void setAttribute(String attributeName, int value) throws CoreException {
		throw new UnsupportedOperationException();
	}

	public boolean isSubtypeOf(String superType) throws CoreException {
		return true;
	}

	public String getType() throws CoreException {
		return type;
	}

	public IResource getResource() {
		return resource;
	}

	public EObject getContext() {
		return context;
	}

	public long getId() {
		return 0;
	}

	public long getCreationTime() throws CoreException {
		return 0;
	}

	public Object[] getAttributes(String[] attributeNames) throws CoreException {
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map getAttributes() throws CoreException {
		return attributes;
	}

	public boolean getAttribute(String attributeName, boolean defaultValue) {
		Object result = attributes.get(attributeName);
		return result == null ? defaultValue : (Boolean) result;
	}

	public String getAttribute(String attributeName, String defaultValue) {
		Object result = attributes.get(attributeName);
		return result == null ? defaultValue : (String) result;
	}

	public int getAttribute(String attributeName, int defaultValue) {
		Object result = attributes.get(attributeName);
		return result == null ? defaultValue : (Integer) result;
	}

	public Object getAttribute(String attributeName) throws CoreException {
		return attributes.get(attributeName);
	}

	public boolean exists() {
		return true;
	}

	public void delete() throws CoreException {
		throw new UnsupportedOperationException();
	}

}