/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;

import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class DefaultConstructorDescriptionProvider extends DefaultJvmFeatureDescriptionProvider {

	@Override
	protected JvmFeatureDescription createJvmFeatureDescription(JvmFeature jvmFeature,
			ITypeArgumentContext rawTypeContext, Provider<String> shadowingStringProvider, boolean isValid,
			boolean isValidStaticState) {
		JvmDeclaredType declaredType = jvmFeature.getDeclaringType();
		QualifiedName thisOrSuper = XbaseScopeProvider.THIS;
		if (contextType != declaredType) {
			thisOrSuper = XbaseScopeProvider.SUPER;
		}
		return createJvmFeatureDescription(
				thisOrSuper, jvmFeature, rawTypeContext, shadowingStringProvider, isValid, isValidStaticState);
	}
	
}
