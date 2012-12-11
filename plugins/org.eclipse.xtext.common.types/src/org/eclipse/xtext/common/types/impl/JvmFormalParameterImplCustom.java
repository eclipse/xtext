/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmFormalParameterImplCustom extends JvmFormalParameterImpl {
	
	@Override
	public String getName() {
		if (name == null && eContainer() instanceof JvmExecutableImplCustom) {
			JvmExecutableImplCustom jvmExecutableImplCustom = (JvmExecutableImplCustom) eContainer();
			jvmExecutableImplCustom.runInitializer();
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
