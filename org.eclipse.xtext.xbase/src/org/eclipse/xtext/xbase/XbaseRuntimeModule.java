/** 
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase;

/** 
 * Use this class to register components to be used without the IDE.
 * @noreference This class is not intended to be referenced by clients.
 * @since 2.7
 */
public class XbaseRuntimeModule extends AbstractXbaseRuntimeModule {

	@Override
	@Deprecated public Class<? extends org.eclipse.xtext.formatting.IFormatter> bindIFormatter() {
		// this binding can be removed once 
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=453440
		// is fixed. 
		// without the binding, org.eclipse.xtext.xbase.tests.serializer.SerializerTest fails
		return org.eclipse.xtext.xbase.formatting.XbaseFormatter.class;
	}
}
