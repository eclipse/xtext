/*******************************************************************************
 * Copyright (c) 2009, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.validation;

import static org.eclipse.emf.common.util.Diagnostic.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.xtext.validation.AbstractValidationDiagnostic;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 */
@Deprecated(forRemoval = true, since = "2.30")
public class AssertableDiagnostics {

	public interface DiagnosticPredicate extends Predicate<Diagnostic> {

	}

	protected class DiagnosticTreeIterator implements Iterable<Diagnostic>, Iterator<Diagnostic> {

		private ArrayList<Iterator<Diagnostic>> iteratorStack = new ArrayList<Iterator<Diagnostic>>();
		private final Diagnostic root;

		public DiagnosticTreeIterator(Diagnostic root) {
			super();
			this.root = root;
			iteratorStack.add(root.getChildren().iterator());
		}

		@Override
		public boolean hasNext() {
			while (iteratorStack.size() > 0 && !iteratorStack.get(iteratorStack.size() - 1).hasNext())
				iteratorStack.remove(iteratorStack.size() - 1);
			return iteratorStack.size() != 0;
		}

		@Override
		public Iterator<Diagnostic> iterator() {
			return new DiagnosticTreeIterator(root);
		}

		@Override
		public Diagnostic next() {
			Diagnostic d = iteratorStack.get(iteratorStack.size() - 1).next();
			if (d.getChildren().size() > 0)
				iteratorStack.add(d.getChildren().iterator());
			return d;
		}

		@Override
		public void remove() {
			throw new RuntimeException("operation not supported");
		}

	}

	/**
	 * @since 2.3
	 */
	public static class Pred implements DiagnosticPredicate {
		protected String issueCode;
		protected String msg;
		protected Integer severity;
		protected Integer code;

		public Pred(Integer severity, Integer code, String issueCode, String msg) {
			super();
			this.severity = severity;
			this.code = code;
			this.issueCode = issueCode;
			this.msg = msg;
		}

		@Override
		public boolean apply(Diagnostic d) {
			if (severity != null && d.getSeverity() != severity)
				return false;
			if (code != null && !code.equals(d.getCode()))
				return false;
			if (issueCode != null && d instanceof AbstractValidationDiagnostic
					&& !((AbstractValidationDiagnostic) d).getIssueCode().equals(issueCode))
				return false;
			if (msg != null && d.getMessage() != null && !d.getMessage().contains(msg))
				return false;
			return true;
		}

		@Override
		public String toString() {
			List<String> r = new ArrayList<String>();
			if (severity != null)
				r.add(AbstractValidationDiagnostic.severityToStr(severity));
			if (issueCode != null)
				r.add("issueCode=" + issueCode);
			if (code != null)
				r.add("code=" + code);
			if (msg != null)
				r.add("msgFragment='" + msg + "'");
			return "(" + Joiner.on(" ").join(r) + ")";
		}
	}

	public static Pred diagnostic(Integer severity, String issueCode, String messageFragment) {
		return new Pred(severity, null, issueCode, messageFragment);
	}

	public static Pred diagnostic(Integer severity, Integer code, String messageFragment) {
		return new Pred(severity, code, null, messageFragment);
	}

	public static Pred diagnostic(Integer severity, Integer code, String issueCode, String messageFragment) {
		return new Pred(severity, code, issueCode, messageFragment);
	}

	public static Pred errorCode(String code) {
		return new Pred(ERROR, null, code, null);
	}

	public static Pred errorCode(int code) {
		return new Pred(ERROR, code, null, null);
	}

	public static Pred error(String code, String messageFragment) {
		return new Pred(ERROR, null, code, messageFragment);
	}

	public static Pred error(int code, String messageFragment) {
		return new Pred(ERROR, code, null, messageFragment);
	}

	public static Pred errorMsg(String messageFragment) {
		return new Pred(ERROR, null, null, messageFragment);
	}

	public static Pred warningCode(String code) {
		return new Pred(WARNING, null, code, null);
	}

	public static Pred warningCode(int code) {
		return new Pred(WARNING, code, null, null);
	}

	public static Pred warning(String code, String messageFragment) {
		return new Pred(WARNING, null, code, messageFragment);
	}

	public static Pred warning(int code, String messageFragment) {
		return new Pred(WARNING, code, null, messageFragment);
	}

	public static Pred warningMsg(String messageFragment) {
		return new Pred(WARNING, null, null, messageFragment);
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

	public AssertableDiagnostics assertAny(DiagnosticPredicate... predicates) {
		for (DiagnosticPredicate predicate : predicates)
			if (Iterables.any(getAllDiagnostics(), predicate))
				return this;
		fail("predicate not found");
		return this;
	}

	public void assertDiagnostic(Integer severity, String issueCode, String messageFragment) {
		assertAll(diagnostic(severity, issueCode, messageFragment));
	}

	public void assertDiagnostic(Integer severity, int code, String issueCode, String messageFragment) {
		assertAll(diagnostic(severity, code, issueCode, messageFragment));
	}

	public void assertDiagnostic(Integer severity, int code, String messageFragment) {
		assertAll(diagnostic(severity, code, messageFragment));
	}

	public AssertableDiagnostics assertDiagnosticsCount(int size) {
		int count = Iterables.size(getAllDiagnostics());
		if (count == size)
			return this;
		fail("There are " + count + " diagnostics, but " + size + " are expected.");
		return this;
	}

	public void assertError(String issueCode) {
		assertAll(errorCode(issueCode));
	}

	public void assertError(int code) {
		assertAll(errorCode(code));
	}

	public void assertError(String issueCode, String messageFragment) {
		assertAll(error(issueCode, messageFragment));
	}

	public void assertError(int code, String messageFragment) {
		assertAll(error(code, messageFragment));
	}

	public void assertErrorContains(String messageFragment) {
		assertAll(errorMsg(messageFragment));
	}

	public void assertOK() {
		if (diag.getChildren().size() != 0)
			fail("There are expected to be no diagnostics.");
	}

	public void assertWarning(String issueCode) {
		assertAll(warningCode(issueCode));
	}

	public void assertWarning(int code) {
		assertAll(warningCode(code));
	}

	public void assertWarning(String code, String messageFragment) {
		assertAll(warning(code, messageFragment));
	}

	public void assertWarning(int code, String messageFragment) {
		assertAll(warning(code, messageFragment));
	}

	public void assertWarningContains(String messageFragment) {
		assertAll(warningMsg(messageFragment));
	}

	public void fail(String message) {
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
		} else
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
