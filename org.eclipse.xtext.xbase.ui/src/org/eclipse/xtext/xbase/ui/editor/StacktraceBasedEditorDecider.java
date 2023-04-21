/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor;

/**
 * Inspects the caller stack to decide whether it is ok to use an Xbase editor to edit a java file or whether the user
 * really expects the Java editor, e.g. by selecting a generated Java file explicitly in the package explorer.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @since 2.3
 */
public class StacktraceBasedEditorDecider extends org.eclipse.xtext.common.types.shared.jdt38.StacktraceBasedEditorDecider {

	@Override
	protected boolean isLineBasedOpenEditorAction() {
		return super.isLineBasedOpenEditorAction();
	}	
	
}
