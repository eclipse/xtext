/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.List;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.typing.ITypeConformanceComputer;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(DefaultJvmTypeConformanceComputer.class)
public interface IJvmTypeConformanceComputer extends ITypeConformanceComputer<JvmTypeReference> {

	/**
	 * @return the common super type of the passed {@link JvmTypeReference}s
	 */
	public JvmTypeReference getCommonSuperType(final List<JvmTypeReference> types);
}
