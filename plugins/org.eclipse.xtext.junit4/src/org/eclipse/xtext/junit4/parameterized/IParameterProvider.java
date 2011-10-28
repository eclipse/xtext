/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.parameterized;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Strings;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(XpectParameterProvider.class)
public interface IParameterProvider {

	public interface IExpectation {
		public class Util {
			public static String replace(XtextResource res, IExpectation exp, String value) {
				String indented;
				if (!Strings.isEmpty(exp.getIndentation()))
					indented = exp.getIndentation() + value.replace("\n", "\n" + exp.getIndentation());
				else
					indented = value;
				String document = res.getParseResult().getRootNode().getText();
				String before = document.substring(0, exp.getOffset());
				String after = document.substring(exp.getOffset() + exp.getLength(), document.length());
				return before + indented + after;
			}
		}

		String getExpectation();

		String getIndentation();

		int getLength();

		int getOffset();
	}

	public interface IParameterAcceptor {
		void acceptImportURI(URI uri);

		void acceptTest(String title, String method, Object[][] params, IExpectation expectation, boolean ignore);

		//		void acceptTestClass(Class<?> clazz);
	}

	void collectParameters(Class<?> testClass, XtextResource resource, IParameterAcceptor acceptor);

}
