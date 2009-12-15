/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit.validation;

import static org.eclipse.emf.common.util.Diagnostic.ERROR;
import static org.eclipse.emf.common.util.Diagnostic.WARNING;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator.DiagnosticImpl;

import com.google.common.base.Join;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 *
 */
public class AssertableDiagnostics {

	public interface DiagnosticPredicate extends Predicate<Diagnostic> {

	}

	protected class DiagnosticTreeIterator implements Iterable<Diagnostic>, Iterator<Diagnostic> {

		private ArrayList<Iterator<Diagnostic>> iteratorStack = new ArrayList<Iterator<Diagnostic>>();

		public DiagnosticTreeIterator(Diagnostic root) {
			super();
			iteratorStack.add(root.getChildren().iterator());
		}

		public boolean hasNext() {
			while (iteratorStack.size() > 0 && !iteratorStack.get(iteratorStack.size() - 1).hasNext())
				iteratorStack.remove(iteratorStack.size() - 1);
			return iteratorStack.size() != 0;
		}

		public Iterator<Diagnostic> iterator() {
			return this;
		}

		public Diagnostic next() {
			Diagnostic d = iteratorStack.get(iteratorStack.size() - 1).next();
			if (d.getChildren().size() > 0)
				iteratorStack.add(d.getChildren().iterator());
			return d;
		}

		public void remove() {
			throw new RuntimeException("operation not supported");
		}

	}

	protected static class Pred implements DiagnosticPredicate {
		protected String code;
		protected String msg;
		protected Integer severity;

		public Pred(Integer severity, String code, String msg) {
			super();
			this.severity = severity;
			this.code = code;
			this.msg = msg;
		}

		public boolean apply(Diagnostic d) {
			if (severity != null && d.getSeverity() != severity)
				return false;
			if(d.getCode() != 0)
				return false;
			if(!(d instanceof DiagnosticImpl))
				return false;
			if (code != null && !((DiagnosticImpl)d).getIssueCode().equals(code) )
				return false;
			if (msg != null && d.getMessage() != null && !d.getMessage().contains(msg))
				return false;
			return true;
		}

		@Override
		public String toString() {
			List<String> r = new ArrayList<String>();
			if (severity != null)
				r.add(DiagnosticImpl.severityToStr(severity));
			if (code != null)
				r.add("code=" + code);
			if (msg != null)
				r.add("msgFragment='" + msg + "'");
			return "(" + Join.join(" ", r) + ")";
		}
	}

	public static final Logger log = Logger.getLogger(AssertableDiagnostics.class);

	public static Pred diagnostic(int severity, String code, String messageFragment) {
		return new Pred(severity, code, messageFragment);
	}

	public static Pred errorWithCode(String code) {
		return new Pred(ERROR, code, null);
	}

	public static Pred error(String code, String messageFragment) {
		return new Pred(ERROR, code, messageFragment);
	}

	public static Pred error(String messageFragment) {
		return new Pred(ERROR, null, messageFragment);
	}

	public static Pred warningWithCode(String code) {
		return new Pred(WARNING, code, null);
	}

	public static Pred warning(String code, String messageFragment) {
		return new Pred(WARNING, code, messageFragment);
	}

	public static Pred warning(String messageFragment) {
		return new Pred(WARNING, null, messageFragment);
	}

	protected Diagnostic diag;

	public AssertableDiagnostics(Diagnostic diag) {
		super();
		this.diag = diag;
	}

	public void assertAll(DiagnosticPredicate... predicates) {
		HashMap<DiagnosticPredicate, Boolean> consumed = new HashMap<DiagnosticPredicate, Boolean>();
		for (DiagnosticPredicate p : predicates)
			consumed.put(p, Boolean.FALSE);
		for (Diagnostic d : getAllDiagnostics()) {
			boolean found = false;
			for (Entry<DiagnosticPredicate, Boolean> e : consumed.entrySet())
				if (!e.getValue() && e.getKey().apply(d)) {
					consumed.put(e.getKey(), Boolean.TRUE);
					found = true;
					break;
				}
			if (!found) {
				if (predicates.length == 1)
					fail("Predicate " + predicates[0] + " does not match " + d);
				else
					fail("No predicate in " + Arrays.toString(predicates) + " matches " + d);
			}
		}
		ArrayList<DiagnosticPredicate> unconsumed = new ArrayList<DiagnosticPredicate>();
		for (Entry<DiagnosticPredicate, Boolean> e : consumed.entrySet())
			if (!e.getValue())
				unconsumed.add(e.getKey());
		if (unconsumed.size() != 0)
			fail("There are diagnostics missing for theses predicates: " + unconsumed);
	}

	public AssertableDiagnostics assertAny(DiagnosticPredicate predicate) {
		if (Iterables.any(getAllDiagnostics(), predicate))
			return this;
		fail("predicate not found");
		return this;
	}

	public void assertDiagnostic(Integer severity, String code, String messageFragment) {
		assertAll(new Pred(severity, code, messageFragment));
	}

	public AssertableDiagnostics assertDiagnosticsCount(int size) {
		int count = Iterables.size(getAllDiagnostics());
		if (count == size)
			return this;
		fail("There are " + count + " diagnostics, but " + size + " are expected.");
		return this;
	}

	public void assertError(String code) {
		assertAll(error(code));
	}

	public void assertError(String code, String messageFragment) {
		assertAll(error(code, messageFragment));
	}

	public void assertErrorContains(String messageFragment) {
		assertAll(error(messageFragment));
	}

	public void assertOK() {
		if (diag.getChildren().size() != 0)
			fail("There are exprected to be no diagnostics.");
	}

	public void assertWarning(String code) {
		assertAll(warning(code));
	}

	public void assertWarning(String code, String messageFragment) {
		assertAll(warning(code, messageFragment));
	}

	public void assertWarningContains(String messageFragment) {
		assertAll(warning(messageFragment));
	}

	public void fail(String message) {
		log.error(message + "\nCurrent Diagnostics:\n" + toString());
		throw new AssertionError(message);
	}

	public Iterable<Diagnostic> getAllDiagnostics() {
		return new DiagnosticTreeIterator(diag);
	}

	public Diagnostic getDiagnostic() {
		return this.diag;
	}

	protected void printDiagnostic(StringBuffer out, String prefix, Diagnostic d) {
		final String indent = "  ";
		out.append(prefix);
		out.append(d);
		if (d.getChildren().size() > 0 || d.getException() != null) {
			out.append(" {\n");
			String prefix2 = prefix + indent;
			if (d.getException() != null) {
				out.append(prefix2);
				ByteArrayOutputStream s = new ByteArrayOutputStream();
				PrintWriter pw = new PrintWriter(s);
				d.getException().printStackTrace(pw);
				pw.flush();
				out.append(s.toString());
				out.append("\n");
			}
			for (Diagnostic c : d.getChildren())
				printDiagnostic(out, prefix2, c);
			out.append(prefix);
			out.append("}\n");
		}
		else
			out.append("\n");
	}

	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		for (Diagnostic d : diag.getChildren())
			printDiagnostic(b, "", d);
		return b.toString();
	}
}
