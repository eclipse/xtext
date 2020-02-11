/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.regex.Pattern;

import com.google.common.base.CharMatcher;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TraceFileNameProvider {

	private static final CharMatcher SEPARATOR_MATCHER = CharMatcher.anyOf("/\\");

	public static final String TRACE_FILE_EXTENSION = "._trace";
	
	private static final Pattern TRACE_FILE_NAME_PATTERN = Pattern.compile(".*\\..+\\._trace$");
	
	public boolean isTraceFileName(String traceFileName) {
		return TRACE_FILE_NAME_PATTERN.matcher(traceFileName).matches();
	}

	public String getTraceFromJava(String javaFileName) {
		int i = SEPARATOR_MATCHER.lastIndexIn(javaFileName);
		if (i < 0)
			return "." + javaFileName + TRACE_FILE_EXTENSION;
		else
			return javaFileName.substring(0, i + 1) + "." + javaFileName.substring(i + 1) + TRACE_FILE_EXTENSION;
	}

	public String getJavaFromTrace(String traceFileName) {
		int i = SEPARATOR_MATCHER.lastIndexIn(traceFileName);
		if (i < 0)
			return traceFileName.substring(1, traceFileName.length() - TRACE_FILE_EXTENSION.length());
		else
			return traceFileName.substring(0, i + 1)
					+ traceFileName.substring(i + 2, traceFileName.length() - TRACE_FILE_EXTENSION.length());
	}
}
