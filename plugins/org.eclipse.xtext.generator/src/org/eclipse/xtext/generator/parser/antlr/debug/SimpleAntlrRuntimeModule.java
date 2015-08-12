/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.debug;

import org.eclipse.xtext.parsetree.reconstr.impl.ValueSerializer;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class SimpleAntlrRuntimeModule extends org.eclipse.xtext.generator.parser.antlr.debug.AbstractSimpleAntlrRuntimeModule {

	public Class<? extends ValueSerializer> bindValueSerializer() {
		return EmptyValueSerializer.class;
	}
	
}
