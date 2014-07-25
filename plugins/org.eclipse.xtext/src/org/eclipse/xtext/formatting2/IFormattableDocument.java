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
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * A FormattableDocument is a stateful object that maps {@link ITextSegment}s to {@link ITextReplacer}s. The document
 * can be populated with TextReplacers in any order. However, it is not possible and not intended to register two or
 * more TextReplacers for the same TextRegion.
 * 
 * Eventually, all TextReplacers will be invoked in order of their region's offset. The TextReplacers are producing
 * {@link ITextReplacement}s.
 * 
 * Besides this, a FormattableDocument
 * <ul>
 * <li>offers convenience API to defined formatting for HiddenRegions. See {@link ITextRegionAccess} for a definition of
 * HiddenRegions and {@link IHiddenRegionFormatter} for how they can be formatted.</li>
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

	ITextSegment getRegion();

	void addReplacer(ITextReplacer replacer);

	ISemanticRegion append(ISemanticRegion semanticRegion, Procedure1<IHiddenRegionFormatter> after);

	<T extends EObject> T append(T semanticRegion, Procedure1<IHiddenRegionFormatter> after);

	void formatConditionally(EObject owner, ISubFormatter... formatters) throws FormattingNotApplicableException;

	//	int getInitalIndentation();

	void formatConditionally(int offset, int length, ISubFormatter... formatters)
			throws FormattingNotApplicableException;

	AbstractFormatter2 getFormatter();

	FormatterRequest getRequest();

	Throwable getTrace(ITextReplacer replacer);

	//	String renderToString();

	//	String renderToString(int start, int lenght);

	ISemanticRegion prepend(ISemanticRegion semanticRegion, Procedure1<IHiddenRegionFormatter> before);

	//	List<ITextReplacement> renderToTextReplacements(int start, int lenght, boolean allowIdentityEdits);

	<T extends EObject> T prepend(T semanticRegion, Procedure1<IHiddenRegionFormatter> before);

	List<ITextReplacement> renderToTextReplacements();

	IHiddenRegion set(IHiddenRegion hiddenRegion, Procedure1<IHiddenRegionFormatter> init);

	ISemanticRegion surround(ISemanticRegion semanticRegion, Procedure1<IHiddenRegionFormatter> beforeAndAfter);

	<T extends EObject> T surround(T owner, Procedure1<IHiddenRegionFormatter> beforeAndAfter);

	ITypedPreferenceValues getPreferences();

}
