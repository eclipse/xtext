/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
public class Bug412894Test extends AbstractXbaseTestCase {
	@Test
	public void test() throws Exception {
		StringConcatenation builder = new StringConcatenation();
		builder.append("{\n");
		builder.append("	val list = newArrayList\n");
		builder.append("	list.forEach [\n");
		builder.append("		switch it {\n");
		builder.append("			String: list.add(it)\n");
		builder.append("		}\n");
		builder.append("	]\n");
		builder.append("}");
		expression(builder, true);
	}
}
