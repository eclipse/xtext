/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.List;

import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.AbstractNode;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(SyntaxErrorMessageProvider.class)
public interface ISyntaxErrorMessageProvider {

	SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context);

	SyntaxErrorMessage getSyntaxErrorMessage(IValueConverterErrorContext context);

	interface IErrorContext {
		String getDefaultMessage();

		EObject getCurrentContext();

		AbstractNode getCurrentNode();
	}

	interface IParserErrorContext extends IErrorContext {
		RecognitionException getRecognitionException();
	
		String[] getTokenNames();
	}
	
	interface IUnorderedGroupErrorContext extends IParserErrorContext {
		List<AbstractElement> getMissingMandatoryElements();
		
		FailedPredicateException getRecognitionException();
	}
	
	interface IValueConverterErrorContext extends IErrorContext {
		String getDefaultMessage();

		ValueConverterException getValueConverterException();
	}

}
