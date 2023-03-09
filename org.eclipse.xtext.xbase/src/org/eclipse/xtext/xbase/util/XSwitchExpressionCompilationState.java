/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.util;

/**
 * Utility class for compiling switch expressions into if statements avoiding useless if check for the first switch's case.
 * 
 * See https://bugs.eclipse.org/bugs/show_bug.cgi?id=470586
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class XSwitchExpressionCompilationState {

	private boolean firstCase = true;

	public void finishProcessingCase() {
		firstCase = false;
	}

	public boolean caseNeedsIfNotMatchedCheck() {
		return !firstCase;
	}
}
