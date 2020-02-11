/*******************************************************************************

 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import java.util.List;

import org.eclipse.xtext.common.types.JvmType;

public class StringBuilderBasedAppendable extends AbstractStringBuilderBasedAppendable {

	private ImportManager importManager;

	public StringBuilderBasedAppendable(ImportManager importManager, String indentation, String lineSeparator) {
		super(indentation, lineSeparator, true);
		this.importManager = importManager;
		
	}

	public StringBuilderBasedAppendable(ImportManager importManager) {
		super(true);
		this.importManager = importManager;
	}

	public StringBuilderBasedAppendable() {
		this(new ImportManager(false));
	}

	@Override
	protected void appendType(final JvmType type, StringBuilder builder) {
		importManager.appendType(type, builder);
	}
	
	@Override
	protected void appendType(final Class<?> type, StringBuilder builder) {
		importManager.appendType(type, builder);
	}

	@Deprecated
	@Override
	public List<String> getImports() {
		return importManager.getImports();
	}

	protected ImportManager getImportManager() {
		return importManager;
	}

}