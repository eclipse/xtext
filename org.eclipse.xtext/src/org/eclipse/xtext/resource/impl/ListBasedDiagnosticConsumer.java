/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ListBasedDiagnosticConsumer implements IDiagnosticConsumer {

	protected static class Internal {
	
		private final List<Diagnostic> diagnostics;
		
		private final Set<Pair<Integer, Integer>> coveredNodes;
	
		private boolean diagnosticsConsumed;
		
		public Internal() {
			this.diagnostics = new ArrayList<Diagnostic>();
			this.coveredNodes = new HashSet<Pair<Integer,Integer>>();
			this.diagnosticsConsumed = false;
		}
		
		public void consume(Diagnostic diagnostic) {
			final Pair<Integer, Integer> newRange = Tuples.create(diagnostic.getOffset(), diagnostic.getLength());
			if (coveredNodes.add(newRange)) {
				boolean changed = this.diagnostics.add(diagnostic);
				diagnosticsConsumed |= changed;
			}
		}
	
		public boolean hasConsumedDiagnostics() {
			return diagnosticsConsumed;
		}
		
		public List<Diagnostic> getResult() {
			return Collections.unmodifiableList(diagnostics);
		}
	}
	
	private Internal errors;
	private Internal warnings;

	@Override
	public void consume(Diagnostic diagnostic, Severity severity) {
		getInternal(severity).consume(diagnostic);
	}
	
	private Internal getInternal(Severity severity) {
		if (severity == null)
			throw new NullPointerException("Severity may not be null");
		switch(severity) {
			case ERROR: 
				if (errors == null) {
					errors = new Internal();
				}
				return errors;
			case WARNING:
				if (warnings == null) {
					warnings = new Internal();
				}
				return warnings;
			default:
				throw new IllegalArgumentException("Illegal severity: INFO. Diagnostics may either be warnings or errors");
		}
	}

	@Override
	public boolean hasConsumedDiagnostics(Severity severity) {
		if (severity == Severity.ERROR)
			return errors != null;
		if (severity == Severity.WARNING)
			return warnings != null;
		return getInternal(severity).hasConsumedDiagnostics();
	}
	
	public List<Diagnostic> getResult(Severity severity) {
		if (hasConsumedDiagnostics(severity))
			return getInternal(severity).getResult();
		return Collections.emptyList();
	}
}
