/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

class FeatureScopeSessionToResolvedTypes {
	private final IFeatureScopeSession session;
	private final IResolvedTypes types;
	
	FeatureScopeSessionToResolvedTypes(IFeatureScopeSession session, IResolvedTypes types) {
		this.session = session;
		this.types = types;
	}
	
	IFeatureScopeSession getSession() {
		return session;
	}
	
	IResolvedTypes getTypes() {
		return types;
	}
}