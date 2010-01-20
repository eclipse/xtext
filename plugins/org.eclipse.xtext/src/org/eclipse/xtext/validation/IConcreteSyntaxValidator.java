/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IConcreteSyntaxValidator {

	public class DiagnosticChainAcceptor implements IDiagnosticAcceptor {

		private DiagnosticChain chain;

		public DiagnosticChainAcceptor(DiagnosticChain chain) {
			this.chain = chain;
		}

		public void accept(IConcreteSyntaxDiagnostic diag) {
			chain.add(diag);
		}

	}

	public class DiagnosticListAcceptor implements IDiagnosticAcceptor {

		private List<Diagnostic> chain;

		public DiagnosticListAcceptor(List<Diagnostic> chain) {
			this.chain = chain;
		}

		public void accept(IConcreteSyntaxDiagnostic diag) {
			chain.add(diag);
		}

	}

	public interface IConcreteSyntaxDiagnostic extends Diagnostic {
	}

	public interface IDiagnosticAcceptor {
		public void accept(IConcreteSyntaxDiagnostic diag);
	}

	public boolean validateObject(EObject obj, IDiagnosticAcceptor acceptor, Map<Object, Object> context);

	public boolean validateRecursive(EObject obj, IDiagnosticAcceptor acceptor, Map<Object, Object> context);

}
