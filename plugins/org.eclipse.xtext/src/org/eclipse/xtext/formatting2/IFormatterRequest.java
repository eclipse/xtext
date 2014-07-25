/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

import java.util.Collection;

import org.eclipse.xtext.formatting2.impl.FormatterRequest;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;

/**
 * A Request tells the formatter what and how to format. Don't implement or extend this interface. Use
 * {@link FormatterRequest} instead.
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface IFormatterRequest {

	/**
	 * Allow the formatter to produce {@link ITextReplacement}s that replace regions with text equal to the text of the
	 * region. Since these TextReplacements don't change anything, one usually doens't want to have them in a production
	 * environment. However, they're useful to test of a formatter considers all significant regions, e.g. all
	 * HiddenRegions.
	 */
	boolean allowIdentityEdits();

	/**
	 * HiddenRegions are considers undefined when their whitespace/comments are unknown. This happens for HiddenRegions
	 * that emerged between programmatically created (not parsed!) model elements.
	 */
	boolean formatUndefinedHiddenRegionsOnly();

	ITypedPreferenceValues getPreferences();

	FormatterProblemReporter getProblemHandler();

	/**
	 * The regions for which the formatter should produce {@link ITextReplacement}s.
	 */
	Collection<org.eclipse.xtext.util.ITextRegion> getRegions();

	/**
	 * The formatter uses {@link ITextRegionAccess } to map model elements and values to text regions.
	 */
	ITextRegionAccess getTextRegionAccess();
}