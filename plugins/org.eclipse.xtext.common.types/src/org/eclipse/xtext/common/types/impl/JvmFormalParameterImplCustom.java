/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmFormalParameterImplCustom extends JvmFormalParameterImpl {
	
	private Provider<String> nameProvider;
	
	public void setNameProvider(Provider<String> nameProvider) {
		if (this.name != null)
			throw new IllegalStateException("Name has already been set.");
		this.nameProvider = nameProvider;
	}
	
	@Override
	public String getName() {
		if (nameProvider != null) {
			setName(nameProvider.get());
			nameProvider = null;
		}
		return super.getName();
	}

	@Override
	public String getIdentifier() {
		return getName();
	}
	
	@Override
	public String getSimpleName() {
		return getName();
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return getName();
	}

}
