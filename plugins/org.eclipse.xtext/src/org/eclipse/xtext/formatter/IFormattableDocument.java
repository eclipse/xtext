/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatter;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatter.IFormatter.Request;
import org.eclipse.xtext.formatter.ITokenAccess.IToken;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * A FormattableDocument is a stateful object that maps {@link ITextRegion}s to {@link ITextReplacer}s. The document can
 * be populated with TextReplacers in any order. However, it is not possible and not intended to register two or more
 * TextReplacers for the same TextRegion.
 * 
 * Eventually, all TextReplacers will be invoked in order of their region's offset. The TextReplacers are producing
 * {@link ITextReplacement}s.
 * 
 * Besides this, a FormattableDocument
 * <ul>
 * <li>offers convenience API to defined formatting for gaps. See {@link ITokenAccess} for a definition of gaps and
 * {@link IGapFormatting} for how they can be formatted.</li>
 * <li>supports conditional formatting. For example, it can try to format a region into the current line and if that
 * doesn't work apply an alternative strategy.</li>
 * </ul>
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 2.7
 */
public interface IFormattableDocument {

	@SuppressWarnings("serial")
	public class FormattingNotApplicableException extends RuntimeException {
	}

	public interface IFormattableSubDocument extends IFormattableDocument {
		IFormattableSubDocument requireFitsInLine();

		//		IFormattableSubDocument requireSingleLine();

		//		IFormattableSubDocument requireFitsInLine(int maxLineWidth);

		//		IFormattableSubDocument requireFitsInLine(int offset, int length);

		IFormattableSubDocument requireFitsInLine(int offset, int length, int maxLineWidth);
	}

	public interface ISubFormatter {
		void format(IFormattableSubDocument document) throws FormattingNotApplicableException;
	}

	IToken append(IToken token, Procedure1<IGapFormatting> after);

	<T extends EObject> T append(T token, Procedure1<IGapFormatting> after);

	void formatConditionally(EObject owner, ISubFormatter... formatters) throws FormattingNotApplicableException;

	void formatConditionally(int offset, int length, ISubFormatter... formatters)
			throws FormattingNotApplicableException;

	//	int getInitalIndentation();

	Request getRequest();

	IToken prepend(IToken token, Procedure1<IGapFormatting> before);

	<T extends EObject> T prepend(T token, Procedure1<IGapFormatting> before);

	//	String renderToString();

	//	String renderToString(int start, int lenght);

	List<ITextReplacement> renderToTextReplacements();

	//	List<ITextReplacement> renderToTextReplacements(int start, int lenght, boolean allowIdentityEdits);

	ITextRegion setReplacer(ITextRegion region, ITextReplacer replacer);

	void setReplacer(int offset, int length, ITextReplacer replacer);

	IToken surround(IToken token, Procedure1<IGapFormatting> beforeAndAfter);

	<T extends EObject> T surround(T owner, Procedure1<IGapFormatting> beforeAndAfter);

}
