/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureScopeSessionWithDynamicExtensions extends FeatureScopeSession {

	private final List<XExpression> extensionProviders;
	private final JvmIdentifiableElement baseElement;

	public FeatureScopeSessionWithDynamicExtensions(AbstractFeatureScopeSession parent,
			FeatureScopeProvider featureScopeProvider, JvmIdentifiableElement baseElement, List<XExpression> extensionProviders) {
		super(parent, featureScopeProvider);
		this.baseElement = baseElement;
		this.extensionProviders = extensionProviders;
	}

}
