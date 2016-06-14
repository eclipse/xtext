/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ide.contentassist

import com.google.common.base.Predicate
import org.eclipse.xtext.xbase.ide.types.ITypeDescriptor

import static org.objectweb.asm.Opcodes.*

final package class TypeFilters {
	
	public static val Predicate<ITypeDescriptor> NON_ABSTRACT = [ typeDesc |
		!typeDesc.accessFlags.contains(ACC_ABSTRACT) && !typeDesc.accessFlags.contains(ACC_INTERFACE)
	]
	
	private static def contains(int flags, int code) {
		flags.bitwiseAnd(code) != 0
	}
	
}
