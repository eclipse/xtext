/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Delegating implementation of an {@link org.eclipse.emf.ecore.EStructuralFeature.Setting} to be independent
 * of other's {@code hashCode()} and {@code equals(Object)} implementation.
 * The criteria is here: The settings's eObject and eStructuralFeature have to be equal.
 * 
 * @author Sebastian Zarnekow 
 */
public class SettingDelegate implements EStructuralFeature.Setting {

	private EStructuralFeature.Setting delegate;

	public SettingDelegate(EStructuralFeature.Setting delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object get(boolean resolve) {
		return delegate.get(resolve);
	}

	@Override
	public EObject getEObject() {
		return delegate.getEObject();
	}

	@Override
	public EStructuralFeature getEStructuralFeature() {
		return delegate.getEStructuralFeature();
	}

	@Override
	public boolean isSet() {
		return delegate.isSet();
	}

	@Override
	public void set(Object newValue) {
		delegate.set(newValue);
	}

	@Override
	public void unset() {
		delegate.unset();
	}
	
	@Override
	public int hashCode() {
		return delegate.getEObject().hashCode() ^ delegate.getEStructuralFeature().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SettingDelegate))
			return false;
		SettingDelegate other = (SettingDelegate) obj;
		return delegate == other.delegate || 
			(delegate.getEObject().equals(other.getEObject()) && 
					delegate.getEStructuralFeature().equals(other.getEStructuralFeature()));
	}
	
}
