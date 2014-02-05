/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.jdt.annotation.NonNullByDefault;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ConstructorFeatureScopeSession extends AbstractNestedFeatureScopeSession {

	protected ConstructorFeatureScopeSession(AbstractFeatureScopeSession parent) {
		super(parent);
	}

	@Override
	public IFeatureScopeSession toConstructorContext() {
		return this;
	}

	@Override
	public boolean isConstructorContext() {
		return true;
	}

}
