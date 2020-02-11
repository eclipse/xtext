/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.postProcessing;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class SuppressWarningsProcessor {

	public String process(String content) {
		String result = content.replaceFirst("public class ", "@SuppressWarnings(\"all\")\n" +
				"public class ");
		return result;
	}

}
