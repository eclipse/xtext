/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.Map;

import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.IApplicableCandidate;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;

/**
 * @author Sebastian Zarnekow
 */
public class RecordingRootResolvedTypes extends RootResolvedTypes {
	private Map<XExpression, IApplicableCandidate> resolvedProxies;

	public RecordingRootResolvedTypes(DefaultReentrantTypeResolver resolver, CancelIndicator monitor) {
		super(resolver, monitor);
	}

	@Override
	public void resolveProxies() {
		resolvedProxies = basicGetLinkingMap();
		super.resolveProxies();
	}

	public Map<XExpression, IApplicableCandidate> getResolvedProxies() {
		return resolvedProxies;
	}

	public void setResolvedProxies(Map<XExpression, IApplicableCandidate> resolvedProxies) {
		this.resolvedProxies = resolvedProxies;
	}
}
