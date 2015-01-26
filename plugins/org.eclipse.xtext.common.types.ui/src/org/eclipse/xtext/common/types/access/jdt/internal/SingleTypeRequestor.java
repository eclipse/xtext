/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt.internal;

import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IInitializer;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.internal.core.IJavaElementRequestor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SingleTypeRequestor implements IJavaElementRequestor {
	/**
	 * The single accepted element
	 */
	protected IType element = null;

	@Override
	public void acceptField(IField field) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void acceptInitializer(IInitializer initializer) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void acceptMemberType(IType type) {
		this.element = type;
	}

	@Override
	public void acceptMethod(IMethod method) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void acceptPackageFragment(IPackageFragment packageFragment) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void acceptType(IType type) {
		this.element = type;
	}

	public IType getType() {
		return this.element;
	}

	@Override
	public boolean isCanceled() {
		return this.element != null;
	}

	public void reset() {
		this.element = null;
	}
}
