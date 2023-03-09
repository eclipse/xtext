/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.IConcreteSyntaxDiagnosticProvider.IConcreteSyntaxDiagnostic;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IConcreteSyntaxValidator {

	class DiagnosticChainAcceptor implements IDiagnosticAcceptor {

		private DiagnosticChain chain;

		public DiagnosticChainAcceptor(DiagnosticChain chain) {
			this.chain = chain;
		}

		@Override
		public void accept(IConcreteSyntaxDiagnostic diag) {
			chain.add(diag);
		}

	}

	public class DiagnosticListAcceptor implements IDiagnosticAcceptor {

		private List<Diagnostic> chain;

		public DiagnosticListAcceptor(List<Diagnostic> chain) {
			this.chain = chain;
		}

		@Override
		public void accept(IConcreteSyntaxDiagnostic diag) {
			chain.add(diag);
		}

	}

	class InvalidConcreteSyntaxException extends RuntimeException {

		private static final long serialVersionUID = -6599356530663272947L;

		private List<Diagnostic> diagnostics;

		public InvalidConcreteSyntaxException(String msg, List<Diagnostic> diagnostics) {
			super(msg);
			this.diagnostics = diagnostics;
		}

		@Override
		public String getMessage() {
			StringBuffer msg = new StringBuffer();
			msg.append(super.getMessage());
			msg.append("\n");
			for (Diagnostic d : diagnostics) {
				msg.append(d.getSource());
				msg.append(": ");
				msg.append(d.getMessage());
				msg.append("\n");
			}
			return msg.toString();
		}

	}

	interface IDiagnosticAcceptor {
		void accept(IConcreteSyntaxDiagnostic diag);
	}

	boolean validateObject(EObject obj, IDiagnosticAcceptor acceptor, Map<Object, Object> context);

	boolean validateRecursive(EObject obj, IDiagnosticAcceptor acceptor, Map<Object, Object> context);

}
