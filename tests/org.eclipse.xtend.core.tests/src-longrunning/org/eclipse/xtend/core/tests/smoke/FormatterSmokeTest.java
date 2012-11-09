/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.smoke;

import org.eclipse.xtend.core.formatting.IConfigurationValues;
import org.eclipse.xtend.core.formatting.MapBasedConfigurationValues;
import org.eclipse.xtend.core.formatting.XtendFormatter;
import org.eclipse.xtend.core.formatting.XtendFormatterConfigKeys;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FormatterSmokeTest extends AbstractSmokeTest {

	@Inject
	private XtendFormatter formatter;

	@Override
	protected void checkForSmoke(String model, LazyLinkingResource resource) {
		IConfigurationValues<XtendFormatterConfigKeys> cfg = new MapBasedConfigurationValues<XtendFormatterConfigKeys>(
				new XtendFormatterConfigKeys());
		formatter.setDiagnoseConflicts(false);
		formatter.format(resource, 0, model.length(), cfg);
	}
}
