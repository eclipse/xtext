/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class LaunchArgs {
	private InputStream in;

	private OutputStream out;

	private PrintWriter trace;

	private boolean validate;

	public InputStream getIn() {
		return in;
	}

	public void setIn(InputStream in) {
		this.in = in;
	}

	public OutputStream getOut() {
		return out;
	}

	public void setOut(OutputStream out) {
		this.out = out;
	}

	public PrintWriter getTrace() {
		return trace;
	}

	public void setTrace(PrintWriter trace) {
		this.trace = trace;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}
}
