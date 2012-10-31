/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.setup;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FileCtx {

	private ResourceSet resourceSet = null;

	private AssertingValidator validate;

	public AssertingValidator getValidate() {
		if (validate == null)
			validate = new AssertingValidator();
		return validate;
	}

	public void setValidate(AssertingValidator validate) {
		this.validate = validate;
	}

	public void add(ResourceSet resourceSet) {
		if (this.resourceSet != null)
			throw new IllegalStateException("Only one ResourceSet per test is supported.");
		this.resourceSet = resourceSet;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

}