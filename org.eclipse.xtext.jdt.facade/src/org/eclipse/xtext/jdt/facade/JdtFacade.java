/*******************************************************************************
 * Copyright (c) 2024 Lorenzo Bettini and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.jdt.facade;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;

/**
 * A facade for JDT internal API that we use in Xtext.
 * 
 * This is not meant to be used by clients.
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 *
 */
public class JdtFacade {
	private final static MethodHandle INLINE_JSR_BYTECODE = findInlineJsrBytecode();
	private static MethodHandle findInlineJsrBytecode() {
		try {
			return MethodHandles.lookup().findSetter(CompilerOptions.class, "inlineJsrBytecode", boolean.class);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * If still present in JDT compiler options, set inlineJsrBytecode.
	 * 
	 * @param compilerOptions
	 * @param inlineJsrBytecode
	 */
	public static void setInlineJsrBytecode(CompilerOptions compilerOptions, boolean inlineJsrBytecode) {
		if (INLINE_JSR_BYTECODE != null) {
			try {
				INLINE_JSR_BYTECODE.invoke(compilerOptions, true);
			} catch (Throwable e) {
				// ignore
			}
		}
	}
}
