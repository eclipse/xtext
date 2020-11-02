/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.junit.typesystem.Oven;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ErrorTest extends AbstractXbaseTestCase {
	@Inject
	private Oven oven;

	@Test
	public void testErrorModel_01() throws Exception {
		oven.fireproof("ewArrayList('').map[ length + 1 * 5 - length + 1 * 5 ].map [ it / 5 + 1 / it ].head");
	}

	@Test
	public void testErrorModel_02() throws Exception {
		oven.fireproof(
				"{ val list = newArrayList(if (false) new Double('-20') else  Integer('20')).map(v|v.intValue)\n" +
				"\tval Object o = list.head \n" +
				"\tlist.head\n" +
				"}\n");
	}

	@Test
	public void testErrorModel_03() throws Exception {
		oven.fireproof(
				"{ val list = newArrayList(if (false) new Double('-20') else  Integer('20')).map(v|v.compareTo(null))\n" +
				"\tval Object o = list.head \n" +
				"\tlist.head\n" +
				"}\n");
	}

	@Test
	public void testErrorModel_04() throws Exception {
		oven.fireproof("newArrayList(if (true) new Double('-20') else  Integer('20'))");
	}

	@Test
	public void testErrorModel_05() throws Exception {
		oven.fireproof(
				"{ val list = newArrayList(if (false) new Double('-20') else  Integer('20')).map(v|v.intValue)\n" +
				"\tval Object o = list.head \n" +
				"\tlist\n" +
				"}\n");
	}

	@Test
	public void testErrorModel_06() throws Exception {
		oven.fireproof(
				"{ val list = org::eclipse::xtext::xbase::lib::ListExtensions::map(newArrayList(if (false) new Double('-20') else  Integer('20'))) [ v|v.intValue ]\n" +
				"\tval Object o = list.head \n" +
				"\tlist\n" +
				"}\n");
	}

	@Test
	public void testErrorModel_07() throws Exception {
		oven.fireproof("{ val list = newArrayList(if (false) new Double('-20') else n");
	}

	@Test
	public void testErrorModel_08() throws Exception {
		oven.fireproof("{ val list = newArrayList(if (false) new Double('-20') else ne");
	}

	@Test
	public void testErrorModel_09() throws Exception {
		oven.fireproof("newArrayList(if (true) new Double('-20') else n");
	}

	@Test
	public void testErrorModel_10() throws Exception {
		oven.fireproof("newArrayList(if (true) new Double('-20') else ne");
	}

	@Test
	public void testErrorModel_11() throws Exception {
		oven.fireproof("newArrayList(if (true) new Double('-20') else new I");
	}

	@Test
	public void testErrorModel_12() throws Exception {
		oven.fireproof("newArrayList(if (true) new Double('-20') else new In");
	}

	@Test
	public void testErrorModel_13() throws Exception {
		oven.fireproof("{ val list = newArrayList(if (false) new Double('-20') else new I");
	}

	@Test
	public void testErrorModel_14() throws Exception {
		oven.fireproof("{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else n");
	}

	@Test
	public void testErrorModel_15() throws Exception {
		oven.fireproof(
				"{ val list = newArrayList(if (false) new Double('-20') else ew Integer('20')).map(v|v.intValue)\n" +
				"\tval Object o = list.head \n" +
				"\tlist.head\n" +
				"}\n");
	}

	@Test
	public void testErrorModel_16() throws Exception {
		oven.fireproof(
				"{ val list = newArrayList(if (false) new Double('-20') else ew Integer('20')).map(v|v.compareTo(null))\n" +
				"\tval Object o = list.head \n" +
				"\tlist.head\n" +
				"}\n");
	}

	@Test
	public void testErrorModel_17() throws Exception {
		oven.fireproof("newArrayList(if (true) new Double('-20') else ew Integer('20'))");
	}

	@Test
	public void testErrorModel_18() throws Exception {
		oven.fireproof("newArrayList(if (true) new Double('-20') else ew Integer('20'), new Integer('29'))");
	}

	@Test
	public void testErrorModel_19() throws Exception {
		oven.fireproof("newArrayList(if (true) new Double('-20') else ew Integer('20'), new Double('29'))");
	}

	@Test
	public void testErrorModel_20() throws Exception {
		this.oven
				.fireproof("newArrayList(if (true) new Double('-20') else ew Integer('20'), new Integer('29'), new Double('29'))");
	}

	@Test
	public void testErrorModel_21() throws Exception {
		oven.fireproof(
				"{ val list = newArrayList(if (false) new Double('-20') else ew Integer('20')).map(v|v.intValue)\n" +
				"\tval Object o = list.head \n" +
				"\tlist\n" +
				"}\n");
	}

	@Test
	public void testErrorModel_22() throws Exception {
		oven.fireproof(
				"{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else ew Integer('20'))) [ v|v.intValue ]\n" +
				"\tval Object o = list.head \n" +
				"\tlist\n" +
				"}\n");
	}

	@Test
	public void testErrorModel_23() throws Exception {
		oven.fireproof(
				"{ val list = newArrayList(if (false) new Double('-20') else newInteger('20')).map(v|v.intValue)\n\tval Object o = list.head \n" +
				"\tlist.head\n" +
				"}\n");
	}

	@Test
	public void testErrorModel_24() throws Exception {
		oven.fireproof(
				"{ val list = newArrayList(if (false) new Double('-20') else newInteger('20')).map(v|v.compareTo(null))\n" +
				"\tval Object o = list.head \n" +
				"\tlist.head\n" +
				"}\n");
	}

	@Test
	public void testErrorModel_25() throws Exception {
		oven.fireproof("newArrayList(if (true) new Double('-20') else newInteger('20'))");
	}

	@Test
	public void testErrorModel_26() throws Exception {
		oven.fireproof(
				"{ val list = newArrayList(if (false) new Double('-20') else newInteger('20')).map(v|v.intValue)\n" +
				"\tval Object o = list.head \n" +
				"\tlist\n" +
				"}\n");
	}

	@Test
	public void testErrorModel_27() throws Exception {
		oven.fireproof(
				"{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else  Integer('20'))) [ v|v.intValue ]\n" +
				"\tval Object o = list.head \n" +
				"\tlist\n" +
				"}\n");
	}

	@Test
	public void testErrorModel_28() throws Exception {
		this.oven
				.fireproof("{ val Iterable<Object> branch = if (true) [|<Object>newArrayList(terator] else newArrayList('a').toArray }");
	}

	@Test
	public void testErrorModel_29() throws Exception {
		oven.fireproof("{ var java.io.FileFilter filter = (if (true) [return true] else [return");
	}

	@Test
	public void testErrorModel_30() throws Exception {
		oven.fireproof("{ var java.io.FileFilter filter = (if (true) [return ] else [return false])");
	}

	@Test
	public void testErrorModel_31() throws Exception {
		oven.fireproof("{ var java.io.FileFilter filter = (if (true) [return] else [return false])");
	}

	@Test
	public void testErrorModel_32() throws Exception {
		oven.fireproof("testdata::OuterClass$InnerClass");
	}

	@Test
	public void testErrorModel_33() throws Exception {
		oven.fireproof("[testdata.OuterClass$InnerClass");
	}

	@Test
	public void testErrorModel_34() throws Exception {
		oven.fireproof("testdata.OuterClass$InnerClass");
	}

	@Test
	public void testErrorModel_35() throws Exception {
		oven.fireproof("testdata::OuterClass$InnerClass::SINGLETON");
	}

	@Test
	public void testErrorModel_36() throws Exception {
		this.oven
				.fireproof("testdata.OuterClass$InnerClass param| param.toUpperCase('foo')].apply(new testdata.OuterClass$InnerClass())");
	}

	@Test
	public void testErrorModel_37() throws Exception {
		oven.fireproof("testdata.OuterClass$InnerClass param| param.toUpperCase('foo')].apply(new testdata.OuterClass$InnerClass)");
	}

	@Test
	public void testErrorModel_38() throws Exception {
		oven.fireproof("testdata.OuterClass$InnerClass::SINGLETON");
	}

	@Test
	public void testErrorModel_39() throws Exception {
		oven.fireproof("ypeof(java.util.Map$Entry)");
	}

	@Test
	public void testErrorModel_40() throws Exception {
		oven.fireproof("java.util.Map$Entry");
	}

	@Test
	public void testErrorModel_41() throws Exception {
		oven.fireproof("org::eclipse::xtext::xbase::lib::ListExtensions::map(newArrayList()) [ it ]");
	}

	@Test
	public void testErrorModel_42() throws Exception {
		oven.fireproof("new testdata.ClosureClient2([|'1'],2']) [|'3'].value");
	}
}
