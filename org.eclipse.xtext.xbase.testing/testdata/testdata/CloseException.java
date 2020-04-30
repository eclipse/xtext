/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package testdata;

public class CloseException extends Exception {
	private static final long serialVersionUID = -1653160717226140056L;
	private static final String TEXT = "Exception on close";

	public String getText() {
		return TEXT;
	}
}
