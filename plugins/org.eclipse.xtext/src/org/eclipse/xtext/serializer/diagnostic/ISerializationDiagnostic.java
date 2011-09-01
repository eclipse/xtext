/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.diagnostic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.util.EmfFormatter;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ISerializationDiagnostic {

	String EXCEPTION_DIAGNOSTIC = "exception diagnostic";
	
	public interface Acceptor {
		void accept(ISerializationDiagnostic diagnostic);
	}

	public class ExceptionDiagnostic implements ISerializationDiagnostic {

		protected Throwable exception;

		public ExceptionDiagnostic(Throwable exception) {
			this.exception = exception;
		}

		public boolean breaksSyntax() {
			return false;
		}

		public Throwable getException() {
			return exception;
		}

		public String getMessage() {
			return exception.getMessage();
		}

		public EObject getSemanticObject() {
			return null;
		}

		public EObject getContext() {
			return null;
		}

		public String getId() {
			return EXCEPTION_DIAGNOSTIC;
		}
	}

	public class ExceptionThrowingAcceptor implements Acceptor {
		public void accept(ISerializationDiagnostic diagnostic) {
			if (diagnostic == null || diagnostic.getMessage() == null)
				throw new RuntimeException("Something went wrong during serialization");
			else if (diagnostic.getException() != null)
				throw new RuntimeException(diagnostic.getException());
			else {
				String msg = diagnostic.getMessage();
				if (diagnostic.getSemanticObject() != null)
					msg += "\nSemantic Object: " + EmfFormatter.objPath(diagnostic.getSemanticObject());
				if (diagnostic.getContext() != null)
					msg += "\nContext: " + new Context2NameFunction().getContextName(diagnostic.getContext());
				throw new RuntimeException(msg);
			}
		}
	}

	public class StdErrAcceptor implements Acceptor {
		public void accept(ISerializationDiagnostic diagnostic) {
			if (diagnostic == null || diagnostic.getMessage() == null)
				System.err.println("error");
			else
				System.err.println("error " + diagnostic.getMessage());
		}
	}

	public Acceptor EXCEPTION_THROWING_ACCEPTOR = new ExceptionThrowingAcceptor();

	public Acceptor STDERR_ACCEPTOR = new StdErrAcceptor();

	boolean breaksSyntax();

	Throwable getException();

	String getMessage();

	EObject getSemanticObject();

	EObject getContext();
	
	String getId();
}
