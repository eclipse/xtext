/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.adapter;

import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * @since 2.9
 */
@Deprecated(forRemoval = true)
public class StringConcatOutputImpl extends OutputImpl {
	public static final String STRING_OUTLET = "StringConcatOutputImpl.StringOutlet";

	private StringConcatenation stringOutlet;

	@Override
	public void openFile(String path, String outletName) {
		if (StringConcatOutputImpl.STRING_OUTLET.equals(outletName)) {
			stringOutlet = new StringConcatenation();
		} else {
			super.openFile(path, outletName);
		}
	}

	@Override
	public void closeFile() {
		if (stringOutlet != null) {
			stringOutlet = null;
		} else {
			super.closeFile();
		}
	}

	@Override
	public void write(String bytes) {
		if (stringOutlet != null) {
			stringOutlet.append(bytes);
		} else {
			super.write(bytes);
		}
	}

	public StringConcatenation getStringOutlet() {
		return stringOutlet;
	}
}
