/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author dhuebner - Initial contribution and API
 */
public class TestableStandaloneBuilder extends StandaloneBuilder {
	private int validateCalled = 0;
	private int generateCalled = 0;
	private boolean mockGeneration = false;

	@Override
	protected boolean validate(Resource resource) {
		boolean validated = super.validate(resource);
		validateCalled++;
		return validated;
	}

	public void resetTestSetup() {
		mockGeneration = false;
	}

	@Override
	protected void generate(List<Resource> sourceResources) {
		if (!mockGeneration) {
			super.generate(sourceResources);
		}
		generateCalled++;
	}

	public void setMockGeneration(boolean mockGeneration) {
		this.mockGeneration = mockGeneration;
	}

	public void resetCallStatistic() {
		validateCalled = 0;
		generateCalled = 0;
	}

	public int getValidateCalled() {
		return validateCalled;
	}

	public int getGenerateCalled() {
		return generateCalled;
	}

}
