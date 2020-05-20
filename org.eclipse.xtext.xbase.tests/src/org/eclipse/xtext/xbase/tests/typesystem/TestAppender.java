/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.List;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.compiler.AbstractStringBuilderBasedAppendable;

public class TestAppender extends AbstractStringBuilderBasedAppendable {
	public TestAppender(boolean isJava) {
		super("\t", "\n", isJava);
	}

	@Override
	protected void appendType(JvmType type, StringBuilder builder) {
		builder.append(type.getIdentifier());
	}

	@Override
	protected void appendType(Class<?> type, StringBuilder builder) {
		builder.append(type.getName());
	}

	@Deprecated
	@Override
	public List<String> getImports() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub");
	}
}
