/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import org.eclipse.xtext.util.formallang.StringPda.StringPdaFactory;
import org.eclipse.xtext.util.formallang.StringProduction.ProdElement;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class CfgToPdaTest extends Assert {

	private String createPda(StringCfg cfg) {
		FollowerFunction<ProdElement> ff = new FollowerFunctionImpl<ProdElement, String>(cfg);
		Pda<String, String> pda = new PdaUtil().create(cfg, ff, new StringPdaFactory<ProdElement>("start", "stop"));
		PdaListFormatter<String, String> fmt = new PdaListFormatter<String, String>();
		String actual = fmt.format(pda);
		return actual;
	}

	@Test public void testSimple() {
		StringCfg cfg = new StringCfg();
		cfg.rule("Foo: 'foo' Bar");
		cfg.rule("Bar: 'bar'");

		StringBuilder exp = new StringBuilder();
		exp.append("start -> 'foo'\n");
		exp.append("'bar' -> <<Bar\n");
		exp.append("'foo' -> >>Bar\n");
		exp.append("<<Bar -> stop\n");
		exp.append(">>Bar -> 'bar'");

		Assert.assertEquals(exp.toString(), createPda(cfg));
	}

	@Test public void testSimple2() {
		StringCfg cfg = new StringCfg();
		cfg.rule("Foo: Bar");
		cfg.rule("Bar: 'bar1' Baz 'bar2'");
		cfg.rule("Baz: 'baz1' | 'baz2'");

		StringBuilder exp = new StringBuilder();
		exp.append("start -> >>Bar\n");
		exp.append("'bar1' -> >>Baz\n");
		exp.append("'bar2' -> <<Bar\n");
		exp.append("'baz1' -> <<Baz\n");
		exp.append("'baz2' -> <<Baz\n");
		exp.append("<<Bar -> stop\n");
		exp.append("<<Baz -> 'bar2'\n");
		exp.append(">>Bar -> 'bar1'\n");
		exp.append(">>Baz -> 'baz1', 'baz2'");

		Assert.assertEquals(exp.toString(), createPda(cfg));
	}

	@Test public void testRecursion() {
		StringCfg cfg = new StringCfg();
		cfg.rule("Foo: Bar");
		cfg.rule("Bar: 'bar1' Foo? 'bar2'");

		StringBuilder exp = new StringBuilder();
		exp.append("start -> >>Bar\n");
		exp.append("'bar1' -> >>Foo, 'bar2'\n");
		exp.append("'bar2' -> <<Bar\n");
		exp.append("<<Bar -> stop, <<Foo\n");
		exp.append("<<Foo -> 'bar2'\n");
		exp.append(">>Bar -> 'bar1'\n");
		exp.append(">>Foo -> >>Bar");

		Assert.assertEquals(exp.toString(), createPda(cfg));
	}

	@Test public void testChain() {
		StringCfg cfg = new StringCfg();
		cfg.rule("Foo: Bar1");
		cfg.rule("Bar1: Bar2");
		cfg.rule("Bar2: Bar3");
		cfg.rule("Bar3: 'x'");

		StringBuilder exp = new StringBuilder();
		exp.append("start -> >>Bar1\n");
		exp.append("'x' -> <<Bar3\n");
		exp.append("<<Bar1 -> stop\n");
		exp.append("<<Bar2 -> <<Bar1\n");
		exp.append("<<Bar3 -> <<Bar2\n");
		exp.append(">>Bar1 -> >>Bar2\n");
		exp.append(">>Bar2 -> >>Bar3\n");
		exp.append(">>Bar3 -> 'x'");

		Assert.assertEquals(exp.toString(), createPda(cfg));
	}

}
