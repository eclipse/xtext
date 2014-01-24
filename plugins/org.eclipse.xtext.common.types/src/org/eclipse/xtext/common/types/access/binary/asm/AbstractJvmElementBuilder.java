/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.asm;

import java.util.Map;

import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractJvmElementBuilder {

	protected final Proxies proxies;
	
	protected AbstractJvmElementBuilder(Proxies proxies) {
		this.proxies = proxies;
	}

	protected JvmTypeReference createTypeReference(BinaryTypeSignature type, Map<String, JvmTypeParameter> typeParameters) {
		return proxies.createTypeReference(type, typeParameters);
	}

	protected JvmTypeReference createTypeArgument(BinaryTypeArgumentSignature actualTypeArgument,
			Map<String, JvmTypeParameter> typeParameters) {
		return proxies.createTypeArgument(actualTypeArgument, typeParameters);
	}

	protected JvmTypeReference createObjectTypeReference() {
		return proxies.createObjectTypeReference();
	}

	protected JvmType createProxy(BinaryTypeSignature type, Map<String, JvmTypeParameter> typeParameters) {
		return proxies.createProxy(type, typeParameters);
	}

	protected JvmAnnotationType createAnnotationProxy(BinaryTypeSignature type) {
		return proxies.createAnnotationProxy(type);
	}
	
}
