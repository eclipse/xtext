/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.diagnostic;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

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

		protected Grammar grammar;

		public ExceptionDiagnostic(Grammar grammar, Throwable exception) {
			this.exception = exception;
			this.grammar = grammar;
		}

		@Override
		public boolean breaksSyntax() {
			return false;
		}

		@Override
		public Throwable getException() {
			return exception;
		}

		@Override
		public String getMessage() {
			return exception.getMessage();
		}

		@Override
		public EObject getSemanticObject() {
			return null;
		}

		@Override
		@Deprecated
		public EObject getContext() {
			return null;
		}

		@Override
		public Grammar getGrammar() {
			return grammar;
		}

		@Override
		public String getId() {
			return EXCEPTION_DIAGNOSTIC;
		}

		@Override
		public EStructuralFeature getEStructuralFeature() {
			return null;
		}

		@Override
		public ISerializationContext getIContext() {
			return null;
		}
	}

	public class ToString {
		public String toString(ISerializationDiagnostic diagnostic) {
			List<String> result = Lists.newArrayList();
			String msg = diagnostic.getMessage();
			EObject eObject = diagnostic.getSemanticObject();
			Throwable exception = diagnostic.getException();
			if (!Strings.isNullOrEmpty(msg))
				result.add(msg);
			if (exception != null && exception.getMessage() != null && !exception.getMessage().equals(msg))
				result.add("Caused By: " + exception.getClass().getName() + ": " + exception.getMessage());
			if (eObject != null) {
				result.add("Semantic Object: " + EmfFormatter.objPath(eObject));
				if (eObject.eResource() != null && eObject.eResource().getURI() != null)
					result.add("URI: " + eObject.eResource().getURI());
			}
			ISerializationContext context = diagnostic.getIContext();
			if (context != null)
				result.add("Context: " + context);
			if (diagnostic.getEStructuralFeature() != null) {
				EStructuralFeature feature = diagnostic.getEStructuralFeature();
				EClass eClass = feature.getEContainingClass();
				String nsPrefix = eClass.getEPackage().getNsPrefix();
				result.add("EStructuralFeature: " + nsPrefix + "::" + eClass.getName() + "." + feature.getName());
			}
			return Joiner.on("\n").join(result);
		}
	}

	public class ExceptionThrowingAcceptor implements Acceptor {
		@Override
		public void accept(ISerializationDiagnostic diagnostic) {
			if (diagnostic == null)
				throw new RuntimeException("Something went wrong during serialization");
			else {
				String msg = new ToString().toString(diagnostic);
				Throwable exception = diagnostic.getException();
				if (exception != null)
					throw new RuntimeException(msg, exception);
				else
					throw new RuntimeException(msg);
			}
		}
	}

	public class StdErrAcceptor implements Acceptor {
		@Override
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

	/**
	 * @deprecated use {@link #getIContext()}
	 */
	@Deprecated
	EObject getContext();

	ISerializationContext getIContext();

	Grammar getGrammar();

	String getId();

	EStructuralFeature getEStructuralFeature();
}
