/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.util.List;

import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;

import com.google.inject.ImplementedBy;

/**
 * A {@link ISyntaxErrorMessageProvider} can be used to customize the error messages
 * that the parser attaches to syntax errors.
 * 
 * Implementors should extends the {@link SyntaxErrorMessageProvider} rather than implementing
 * the interface directly.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 */
@ImplementedBy(SyntaxErrorMessageProvider.class)
public interface ISyntaxErrorMessageProvider {

	/**
	 * Provide the error message for a syntax error.
	 * @see IParserErrorContext
	 * @see IUnorderedGroupErrorContext
	 * @return a {@link SyntaxErrorMessage}.
	 */
	SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context);

	/**
	 * Provide the error message for a value conversion error.
	 * @see IValueConverterErrorContext
	 * @return a {@link SyntaxErrorMessage}.
	 */
	SyntaxErrorMessage getSyntaxErrorMessage(IValueConverterErrorContext context);

	/**
	 * The error context provides some information about the internal state
	 * of the parser when a syntax error occurred.
	 * @noimplement This interface is not intended to be implemented by clients.
	 */
	interface IErrorContext {
		
		/**
		 * Provides the default error message as it is produced by the parser.
		 * @return the default message.
		 */
		String getDefaultMessage();

		/**
		 * Returns the last produced instance or <code>null</code> if the parser did not yet create something.
		 * @return the current context object or <code>null</code>.
		 */
		EObject getCurrentContext();

		/**
		 * Returns the recently produced node or <code>null</code> if the parser did not yet create something.
		 * @return the current node or <code>null</code>.
		 */
		INode getCurrentNode();
	}

	/**
	 * The error context for parser and lexer errors.
	 * @noimplement This interface is not intended to be implemented by clients.
	 */
	interface IParserErrorContext extends IErrorContext {
		/**
		 * Returns the recognition exception or <code>null</code> in case of lexer errors.
		 * @return the recognition exception in the parser. May be <code>null</code> in 
		 * case of lexer errors.
		 */
		RecognitionException getRecognitionException();
	
		/**
		 * Returns the names of the tokens in as they are used by the parser.
		 * @return the token names.
		 */
		String[] getTokenNames();
	}
	
	/**
	 * In case of failed unordered group constraints, an {@link IUnorderedGroupErrorContext} is
	 * used.
	 * @noimplement This interface is not intended to be implemented by clients.
	 */
	interface IUnorderedGroupErrorContext extends IParserErrorContext {
		
		/**
		 * Returns the list of mandatory elements that have not been recognized.
		 * @return the list of missing mandatory elements.
		 */
		List<AbstractElement> getMissingMandatoryElements();
		
		/**
		 * Returns the failed predicate exception caused by a specific unordered group.
		 * @return the failed predicate exception caused by a specific unordered group. Never <code>null</code>.
		 */
		@Override
		FailedPredicateException getRecognitionException();
	}
	
	/**
	 * The error context for a particular value conversion issue. 
	 * @noimplement This interface is not intended to be implemented by clients.
	 */
	interface IValueConverterErrorContext extends IErrorContext {

		/**
		 * Returns the thrown {@link ValueConverterException}.
		 * @return the {@link ValueConverterException}.
		 */
		ValueConverterException getValueConverterException();
	}

}
