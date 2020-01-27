/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
