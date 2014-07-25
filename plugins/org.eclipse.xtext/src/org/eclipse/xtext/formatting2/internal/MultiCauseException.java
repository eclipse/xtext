/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 *
 */

// TODO: use java.lang.Throwable.addSuppressed(Throwable) instead?
public class MultiCauseException extends RuntimeException {

	private static final long serialVersionUID = -2486348802086328170L;
	private final Throwable[] causes;

	public MultiCauseException(Throwable[] causes) {
		super("This exceptions has " + causes.length + " causes. See stack trace.");
		this.causes = causes;
	}

	public Throwable[] getCauses() {
		return causes;
	}

	@Override
	public void printStackTrace(PrintStream s) {
		s.append(getClass().getName() + ": " + getMessage() + "\n");
		s.append(visualizeMultipleStackTraces(causes));
	}

	@Override
	public void printStackTrace(PrintWriter s) {
		s.append(getClass().getName() + ": " + getMessage() + "\n");
		s.append(visualizeMultipleStackTraces(causes));
	}

	protected String visualizeMultipleStackTraces(Throwable... throwables) {
		StackTraceElement[][] traces = new StackTraceElement[throwables.length][];
		for (int i = 0; i < throwables.length; i++)
			traces[i] = throwables[i].getStackTrace();
		int commenElement = Integer.MAX_VALUE;
		StackTraceElement[] first = traces[0];
		for (int i = 1; i < traces.length; i++) {
			StackTraceElement[] trace = traces[i];
			for (int e = 1; e < first.length && e < trace.length && e < commenElement; e++)
				if (!first[first.length - e].equals(trace[trace.length - e])) {
					commenElement = e;
					break;
				}
		}
		if (commenElement == Integer.MAX_VALUE)
			commenElement = 1;
		List<String> lines = Lists.newArrayList();
		for (int i = 0; i < traces.length; i++) {
			String message = throwables[i].getMessage();
			if (!Strings.isNullOrEmpty(message))
				lines.add((i == 0 ? "   " : "|  ") + throwables[i].getClass().getName() + ": " + message);
			StackTraceElement[] trace = traces[i];
			int max = trace.length - commenElement;
			for (int e = 0; e <= max; e++) {
				String prefix = i == 0 ? (e == max ? ",- " : "   ") : (e == max ? "|- " : "|  ");
				lines.add(prefix + trace[e].toString());
			}
		}
		int min = first.length - commenElement + 1;
		int max = first.length - Math.max(0, commenElement - 10);
		for (int i = min; i < max; i++)
			lines.add(first[i].toString());
		return Joiner.on('\n').join(lines);
	}
}
