/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.launching;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IJavaElement;
import org.junit.runner.Description;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class JUnitJavaElementDelegate implements IAdaptable {

	private Description description = null;
	private IJavaElement javaElement = null;
	private String name = null;
	private IResource resource = null;

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (getClass().equals(adapter))
			return this;
		if (IJavaElement.class.equals(adapter))
			return javaElement;
		if (Description.class.equals(adapter))
			return description;
		return null;
	}

	public Description getDescription() {
		return description;
	}

	public IJavaElement getJavaElement() {
		return javaElement;
	}

	public String getName() {
		return name;
	}

	public IResource getResource() {
		return resource;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public void setJavaElement(IJavaElement javaElement) {
		this.javaElement = javaElement;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setResource(IResource resource) {
		this.resource = resource;
	}

}
