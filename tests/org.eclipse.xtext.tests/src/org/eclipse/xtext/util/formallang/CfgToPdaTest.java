/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.xtext.util.formallang.StringProduction.ProdElement;
import org.eclipse.xtext.util.formallang.StringPda.StringPdaFactory;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class CfgToPdaTest extends TestCase {

	private String createPda(StringCfg cfg) {
		FollowerFunction<ProdElement> ff = new FollowerFunctionImpl<ProdElement, String>(cfg);
		Pda<String, String> pda = new PdaUtil().create(cfg, ff, new StringPdaFactory("start", "stop"));
		PdaListFormatter<String, String> fmt = new PdaListFormatter<String, String>();
		String actual = fmt.format(pda);
		return actual;
	}

	public void testSimple() {
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

	public void testSimple2() {
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

	public void testRecursion() {
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

	public void testChain() {
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
