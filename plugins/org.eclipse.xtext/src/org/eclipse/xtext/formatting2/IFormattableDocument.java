/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
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
 * <li>offers convenience API to defined formatting for gaps. See {@link ITextRegionAccess} for a definition of gaps and
 * {@link IHiddenRegionFormatting} for how they can be formatted.</li>
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

	ISemanticRegion append(ISemanticRegion token, Procedure1<IHiddenRegionFormatting> after);

	<T extends EObject> T append(T token, Procedure1<IHiddenRegionFormatting> after);

	void formatConditionally(EObject owner, ISubFormatter... formatters) throws FormattingNotApplicableException;

	void formatConditionally(int offset, int length, ISubFormatter... formatters)
			throws FormattingNotApplicableException;

	//	int getInitalIndentation();

	IFormatterRequest getRequest();

	ISemanticRegion prepend(ISemanticRegion token, Procedure1<IHiddenRegionFormatting> before);

	<T extends EObject> T prepend(T token, Procedure1<IHiddenRegionFormatting> before);

	//	String renderToString();

	//	String renderToString(int start, int lenght);

	List<ITextReplacement> renderToTextReplacements();

	//	List<ITextReplacement> renderToTextReplacements(int start, int lenght, boolean allowIdentityEdits);

	ITextRegion setReplacer(ITextRegion region, ITextReplacer replacer);

	void setReplacer(int offset, int length, ITextReplacer replacer);

	ISemanticRegion surround(ISemanticRegion token, Procedure1<IHiddenRegionFormatting> beforeAndAfter);

	<T extends EObject> T surround(T owner, Procedure1<IHiddenRegionFormatting> beforeAndAfter);

}
