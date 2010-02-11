/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticSeverity;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ListBasedDiagnosticConsumer implements IDiagnosticConsumer {

	public class Internal {
	
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

	public void consume(Diagnostic diagnostic, DiagnosticSeverity severity) {
		getInternal(severity).consume(diagnostic);
	}
	
	private Internal getInternal(DiagnosticSeverity severity) {
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
		}
		throw new IllegalArgumentException("Unknown severity: " + severity);
	}

	public boolean hasConsumedDiagnostics(DiagnosticSeverity severity) {
		if (severity == DiagnosticSeverity.ERROR)
			return errors != null;
		if (severity == DiagnosticSeverity.WARNING)
			return warnings != null;
		return getInternal(severity).hasConsumedDiagnostics();
	}
	
	public List<Diagnostic> getResult(DiagnosticSeverity severity) {
		if (hasConsumedDiagnostics(severity))
			return getInternal(severity).getResult();
		return Collections.emptyList();
	}
}
