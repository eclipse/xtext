/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.JvmType;

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
	
}
