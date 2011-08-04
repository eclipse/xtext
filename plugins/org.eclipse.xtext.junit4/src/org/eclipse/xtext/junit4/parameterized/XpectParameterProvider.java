/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.parameterized;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectParameterProvider implements IParameterProvider {

	protected static Pattern XPECT_PATTERN = Pattern.compile("XPECT ([a-zA-Z0-9]+) --");

	public void collectParameters(XtextResource resource, IAcceptor<URI> importAcceptor,
			IAcceptor<Class<?>> testAcceptor, IAcceptor<Pair<String, Object[]>> parameterAcceptor) {
		for (ILeafNode leaf : resource.getParseResult().getRootNode().getLeafNodes())
			if (leaf.isHidden() && leaf.getText().contains("XPECT")) {
				String text = leaf.getText();
				Matcher matcher = XPECT_PATTERN.matcher(text);
				while (matcher.find()) {
					String name = matcher.group(1);
					int end = text.indexOf("---", matcher.end());
					String expected = end > 0 ? text.substring(matcher.end() + 1, end) : null;
					parameterAcceptor.accept(Tuples.create(name, new Object[] { leaf, expected }));
				}
			}
	}

}
