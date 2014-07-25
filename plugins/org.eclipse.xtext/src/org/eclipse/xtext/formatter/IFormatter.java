/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatter;

import java.util.Collection;
import java.util.List;

import org.eclipse.xtext.formatter.impl.FormatterRequest;
import org.eclipse.xtext.formatter.impl.RegionSet;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;

/**
 * This interface is the 'outer' view of of the formatter. If you want to invoke a formatter, have an implementation of
 * this interface injected via Guice, compose a {@link Request}-object and call {@link #format(Request)}.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.7
 */
public interface IFormatter {

	public interface ProblemHandler {
		void handleMergeConflict(RegionSet<?> regionSet, ITextRegion existing, ITextRegion add);

		void handleOutsideOfRegion(RegionSet<?> regionSet, ITextRegion region);
	}

	/**
	 * A Request tells the formatter what and how to format. Don't implement or extend this interface. Use
	 * {@link FormatterRequest} instead.
	 * 
	 * @noextend This interface is not intended to be extended by clients.
	 * @noimplement This interface is not intended to be implemented by clients.
	 * @author Moritz Eysholdt - Initial contribution and API
	 */
	public interface Request {

		/**
		 * Allow the formatter to produce {@link ITextReplacement}s that replace regions with text equal to the text of
		 * the region. Since these TextReplacements don't change anything, one usually doens't want to have them in a
		 * production environment. However, they're useful to test of a formatter considers all significant regions,
		 * e.g. all gaps.
		 */
		boolean allowIdentityEdits();

		/**
		 * Gaps are considers undefined when their whitespace/comments are unknown. This happens for gaps that emerged
		 * between programmatically created (not parsed!) model elements.
		 */
		boolean formatUndefinedGapsOnly();

		ITypedPreferenceValues getPreferences();

		ProblemHandler getProblemHandler();

		/**
		 * The regions for which the formatter should produce {@link ITextReplacement}s.
		 */
		Collection<org.eclipse.xtext.util.ITextRegion> getRegions();

		/**
		 * The formatter uses {@link ITokenAccess } to map model elements and values to text regions.
		 */
		ITokenAccess getTokens();
	}

	/**
	 * Execute the formatter.
	 */
	List<ITextReplacement> format(Request request);

}
