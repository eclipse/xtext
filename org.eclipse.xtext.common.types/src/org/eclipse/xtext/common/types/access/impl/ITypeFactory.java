/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.util.Map;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.TypeResource;

/**
 * SPI to implement a custom type provider that produces
 * {@link JvmType}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
public interface ITypeFactory<TypeData, Type extends JvmType> {

	/**
	 * Produce a JvmType for the given source, e.g. a {@code java.lang.Class<?>},
	 * {@code byte[]} or {@code org.eclipse.jdt.core.IType}.
	 */
	Type createType(TypeData arg);
	
	/**
	 * A type factory that wants to explore additional information of the resource
	 * or the options map may implement this extension interface.
	 * 
	 * @author Sebastian Zarnekow - Initial contribution and API
	 * @since 2.7
	 */
	interface OptionsAware<TypeData, Type extends JvmType> extends ITypeFactory<TypeData, Type> {
		Type createType(TypeData arg, TypeResource resource, Map<?, ?> options);
	}
	
}
