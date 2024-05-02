/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.formatter;

import java.util.function.Consumer;

import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.common.annotations.Beta;
import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 * @since 2.35
 */
@Beta
public abstract class AbstractFormatterTest {

	@Inject @Extension
	protected FormatterTestHelper formatterTestHelper;

	/**
	 * Verifies whether the formatted document equals the unformatted document.
	 * 
	 * @param formatterInput
	 *				The document content before and after formatting.
	 */
	protected void assertUnformattedEqualsFormatted(CharSequence formatterInput) {
		assertFormattedTo(formatterInput, null);
	}

	/**
	 * Verifies whether the formatted document equals the unformatted document.
	 * 
	 * @param formatterInput
	 *				The document content before and after formatting.
	 * @param preferences
	 *				The preferences to configure the formatter.
	 */
	protected void assertUnformattedEqualsFormatted(CharSequence formatterInput, Consumer<MapBasedPreferenceValues> preferences) {
		assertFormattedTo(formatterInput, formatterInput, preferences);
	}

	/**
	 * Verifies whether formatting the <i>formatterInput</i> results in the <i>formatterExpectation</i>.
	 *
	 * @param formatterInput
	 *				The document content before formatting.
	 * @param formatterExpectation
	 *				The document content after formatting.
	 */
	protected void assertFormattedTo(CharSequence formatterInput, CharSequence formatterExpectation) {
		assertFormattedTo(formatterInput, formatterExpectation, null);
	}

	/**
	 * Verifies whether formatting the <i>formatterInput</i> results in the <i>formatterExpectation</i>.
	 *
	 * @param formatterInput
	 *				The document content before formatting.
	 * @param formatterExpectation
	 *				The document content after formatting.
	 * @param preferences
	 *				The preferences to configure the formatter.
	 */
	protected void assertFormattedTo(CharSequence formatterInput, CharSequence formatterExpectation, Consumer<MapBasedPreferenceValues> preferences) {
		formatterTestHelper.assertFormatted(request -> {
			request.setToBeFormatted(formatterInput);
			request.setExpectation(formatterExpectation);
			if (preferences != null) {
				preferences.accept(request.getOrCreateMapBasedPreferences());
			}
		});
	}
}
