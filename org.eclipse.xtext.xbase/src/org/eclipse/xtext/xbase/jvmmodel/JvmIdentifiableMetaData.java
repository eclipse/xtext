/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noreference This class is not intended to be referenced by clients.
 * 
 * @since 2.7
 */
public class JvmIdentifiableMetaData extends AdapterImpl {
	private boolean synthetic;

	/**
	 * @since 2.23
	 */
	public JvmIdentifiableMetaData(boolean synthetic) {
		this.synthetic = synthetic;
	}
	
	public JvmIdentifiableMetaData() {
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return JvmIdentifiableMetaData.class == type;
	}

	public boolean isSynthetic() {
		return synthetic;
	}

	public void setSynthetic(boolean synthetic) {
		this.synthetic = synthetic;
	}
}
