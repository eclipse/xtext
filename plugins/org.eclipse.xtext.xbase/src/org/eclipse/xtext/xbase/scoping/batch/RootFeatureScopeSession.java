/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class RootFeatureScopeSession extends AbstractFeatureScopeSession {

	@Inject
	private FeatureScopeProvider featureScopeProvider;
	
	@Inject
	private IScopeProvider scopeProvider;

	@Override
	protected FeatureScopeProvider getFeatureScopeProvider() {
		return featureScopeProvider;
	}
	
	@Override
	protected IScopeProvider getScopeProvider() {
		return scopeProvider;
	}

	@Nullable
	public IEObjectDescription getLocalElement(QualifiedName name) {
		return null;
	}
	
	@Override
	public Collection<IEObjectDescription> getLocalElements() {
		return Collections.emptyList();
	}
	
	@Override
	protected int getId() {
		return 0;
	}
	
}
