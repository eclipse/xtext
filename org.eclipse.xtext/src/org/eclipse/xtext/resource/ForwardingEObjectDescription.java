/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;

import com.google.common.collect.ForwardingObject;

/**
 * An abstract implementation of {@link IEObjectDescription} that delegates all method invocations to another instance.
 * Suitable to override and specialize behavior.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
public abstract class ForwardingEObjectDescription extends ForwardingObject implements IEObjectDescription {
	private final IEObjectDescription delegate;

	public ForwardingEObjectDescription(IEObjectDescription delegate) {
		this.delegate = delegate;
	}

	@Override
	protected IEObjectDescription delegate() {
		return delegate;
	}

	@Override
	public String toString() {
		return "ForwardingEObjectDescription[" + delegate + "]";
	}

	@Override
	public EClass getEClass() {
		return delegate.getEClass();
	}

	@Override
	public EObject getEObjectOrProxy() {
		return delegate.getEObjectOrProxy();
	}

	@Override
	public URI getEObjectURI() {
		return delegate.getEObjectURI();
	}

	@Override
	public QualifiedName getName() {
		return delegate.getName();
	}

	@Override
	public QualifiedName getQualifiedName() {
		return delegate.getQualifiedName();
	}

	@Override
	public String getUserData(String key) {
		return delegate.getUserData(key);
	}

	@Override
	public String[] getUserDataKeys() {
		return delegate.getUserDataKeys();
	}
}
