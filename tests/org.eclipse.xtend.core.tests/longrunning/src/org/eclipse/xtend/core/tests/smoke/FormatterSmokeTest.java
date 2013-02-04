/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.smoke;

import java.util.HashMap;

import org.eclipse.xtend.core.formatting.XtendFormatter;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.xbase.formatting.FormattingPreferenceValues;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormatterSmokeTest extends AbstractSmokeTest {

	@Inject
	private XtendFormatter formatter;

	@Override
	protected void checkForSmoke(String model, LazyLinkingResource resource) {
		IPreferenceValues cfg = new MapBasedPreferenceValues(new HashMap<String, String>());
		formatter.setDiagnoseConflicts(false);
		formatter.format(resource, 0, model.length(), new FormattingPreferenceValues(cfg));
	}

	@Test
	@Override
	@Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=394277")
	public void testSkipNodesInBetween() throws Exception {
	}

	@Test
	@Override
	@Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=394277")
	public void testSkipNodesInBetweenWithoutResourceSet() throws Exception {
	}
}
