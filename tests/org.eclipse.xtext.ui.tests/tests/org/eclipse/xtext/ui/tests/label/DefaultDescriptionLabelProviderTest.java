/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.label;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class DefaultDescriptionLabelProviderTest extends Assert {
	@Test public void testBug414194() throws Exception {

		DefaultDescriptionLabelProvider lp = new DefaultDescriptionLabelProvider() {

			@Override
			public Object text(IEObjectDescription element) {
				return element.getName();
			}
		};
		EObjectDescription element = new EObjectDescription(QualifiedName.create("Foo"),null, null);
		assertEquals("Foo", lp.getText(element));
		StyledString styledText = lp.getStyledText(element);
		assertEquals("Foo", styledText.toString());
	}
}
