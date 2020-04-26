/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.validation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.xtext.xbase.ui.validation.ProjectAwareUniqueClassNameValidator;

public class MockedProjectAwareUniqueClassNameValidator extends ProjectAwareUniqueClassNameValidator {
	private Map<Object, Object> context = new HashMap<>();

	@Override
	public Map<Object, Object> getContext() {
		return this.context;
	}

	@Override
	public boolean isDerived(IResource resource) {
		return super.isDerived(resource);
	}
}
