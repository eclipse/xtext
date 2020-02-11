/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ide.contentassist;

import com.google.common.base.Predicate;
import java.lang.reflect.Modifier;
import org.eclipse.xtext.common.types.descriptions.ITypeDescriptor;

final class TypeFilters {

	public static final Predicate<ITypeDescriptor> NON_ABSTRACT = (
			typeDesc) -> !Modifier.isAbstract(typeDesc.getModifiers())
					&& !Modifier.isInterface(typeDesc.getModifiers());

}
