/** 
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase

/** 
 * Use this class to register components to be used without the IDE.
 * @noreference This class is not intended to be referenced by clients.
 * @since 2.7
 */
class XbaseRuntimeModule extends AbstractXbaseRuntimeModule {

	@SuppressWarnings("deprecation") override Class<? extends org.eclipse.xtext.formatting.IFormatter> bindIFormatter() {
		// this binding can be removed once 
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=453440
		// is fixed. 
		// without the binding, org.eclipse.xtext.xbase.tests.serializer.SerializerTest fails
		return org.eclipse.xtext.xbase.formatting.XbaseFormatter
	}
}
