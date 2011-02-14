/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ISerializationDiagnostic {

	public interface Acceptor {
		void accept(ISerializationDiagnostic diagnostic);
	}

	public class ExceptionThrowingAcceptor implements Acceptor {
		public void accept(ISerializationDiagnostic diagnostic) {
			if (diagnostic == null || diagnostic.getMessage() == null)
				System.err.println("error");
			else
				System.err.println("error " + diagnostic.getMessage());
		}
	}

	public Acceptor EXCEPTION_ACCEPTOR = new ExceptionThrowingAcceptor();

	boolean breaksSyntax();

	String getMessage();

	EObject getSemanitcObject();
}
