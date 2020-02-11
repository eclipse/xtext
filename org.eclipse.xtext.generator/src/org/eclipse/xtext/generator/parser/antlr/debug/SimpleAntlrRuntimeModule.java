/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.debug;

import org.eclipse.xtext.parsetree.reconstr.impl.ValueSerializer;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@Deprecated
public class SimpleAntlrRuntimeModule extends org.eclipse.xtext.generator.parser.antlr.debug.AbstractSimpleAntlrRuntimeModule {

	public Class<? extends ValueSerializer> bindValueSerializer() {
		return EmptyValueSerializer.class;
	}
	
}
