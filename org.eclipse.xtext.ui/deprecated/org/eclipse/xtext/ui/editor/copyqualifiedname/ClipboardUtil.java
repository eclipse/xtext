/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.copyqualifiedname;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.4
 * @deprecated Use {@link org.eclipse.xtext.ui.util.ClipboardUtil} instead
 */
@Deprecated
public class ClipboardUtil {

	/**
	 * @deprecated Use {@link org.eclipse.xtext.ui.util.ClipboardUtil#copy(String)} instead
	 */
	@Deprecated
	public static Object copy(String data) {
		return org.eclipse.xtext.ui.util.ClipboardUtil.copy(data);
	}
}
