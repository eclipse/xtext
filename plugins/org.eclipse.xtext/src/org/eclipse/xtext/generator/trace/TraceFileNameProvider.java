/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.regex.Pattern;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TraceFileNameProvider {

	public static final String TRACE_FILE_EXTENSION = "._trace";
	
	private static final Pattern TRACE_FILE_NAME_PATTERN = Pattern.compile(".*/?\\..+\\._trace$");
	
	public boolean isTraceFileName(String traceFileName) {
		return TRACE_FILE_NAME_PATTERN.matcher(traceFileName).matches();
	}

	public String getTraceFromJava(String javaFileName) {
		int i = javaFileName.lastIndexOf('/');
		if (i < 0)
			return "." + javaFileName + TRACE_FILE_EXTENSION;
		else
			return javaFileName.substring(0, i + 1) + "." + javaFileName.substring(i + 1) + TRACE_FILE_EXTENSION;
	}

	public String getJavaFromTrace(String traceFileName) {
		int i = traceFileName.lastIndexOf('/');
		if (i < 0)
			return traceFileName.substring(1, traceFileName.length() - TRACE_FILE_EXTENSION.length());
		else
			return traceFileName.substring(0, i + 1)
					+ traceFileName.substring(i + 2, traceFileName.length() - TRACE_FILE_EXTENSION.length());
	}
}
