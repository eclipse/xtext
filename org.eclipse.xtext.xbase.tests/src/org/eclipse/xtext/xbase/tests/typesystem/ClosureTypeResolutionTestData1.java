/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.List;

import org.eclipse.xtext.xbase.tests.typesystem.TypeResolutionTestData.ListFunction1;
import org.eclipse.xtext.xbase.tests.typesystem.TypeResolutionTestData.ListFunction2;
import org.eclipse.xtext.xbase.tests.typesystem.TypeResolutionTestData.ListFunction3;
import org.eclipse.xtext.xbase.tests.typesystem.TypeResolutionTestData.ListFunction4;
import org.eclipse.xtext.xbase.tests.typesystem.TypeResolutionTestData.ListFunction5;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @TODO move to TypeResolutionStateTest
 */
@SuppressWarnings({ "unused", "null" })
public class ClosureTypeResolutionTestData1 {

	public <In, Out> List<Out> method_1_1_a(Iterable<In> it, ListFunction1<? super In, ? extends Out> fun) { return null; }
	
	{
		Iterable<? super StringBuffer> iter = null;
		ClosureTypeResolutionTestData1 testData = null;
		ListFunction1<Object, String> fun = null;
		new ListFunction1<Object, String>() {
			@Override
			public List<String> apply(List<Object> list) {
			return null;	
			}
		};
		Iterable<? extends String> res = testData.method_1_1_a(iter, fun);
	}
	
	public <In, Out> List<? extends Out> method_1_1_b(Iterable<In> it, ListFunction1<? super In, ? extends Out> fun) { return null; }
	
	{
		Iterable<StringBuffer> iter = null;
		ClosureTypeResolutionTestData1 testData = null;
		ListFunction1<StringBuffer, String> fun = null;
//		Iterable<? super String> res = testData.method_1_1_b(iter, null);
	}
	
	public <In, Out> List<? super Out> method_1_1_c(Iterable<In> it, ListFunction1<? super In, ? extends Out> fun) { return null; }
	
	{
		Iterable<StringBuffer> iter = null;
		ClosureTypeResolutionTestData1 testData = null;
		ListFunction1<StringBuffer, String> fun = null;
//		Iterable<String> res = testData.method_1_1_c(iter, fun);
	}
	
	public <In, Out> List<Out> method_1_2_a(Iterable<? extends In> it, ListFunction1<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_1_2_b(Iterable<? extends In> it, ListFunction1<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? super Out> method_1_2_c(Iterable<? extends In> it, ListFunction1<? super In, ? extends Out> fun) { return null; }
	
	public <In, Out> List<Out> method_1_3_a(Iterable<? super In> it, ListFunction1<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_1_3_b(Iterable<? super In> it, ListFunction1<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? super Out> method_1_3_c(Iterable<? super In> it, ListFunction1<? super In, ? extends Out> fun) { return null; }
	
	public <In, Out> List<Out> method_1_4_a(Iterable<In> it, ListFunction1<In, Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_1_4_b(Iterable<In> it, ListFunction1<In, Out> fun) { return null; }
	public <In, Out> List<? super Out> method_1_4_c(Iterable<In> it, ListFunction1<In, Out> fun) { return null; }
	
	public <In, Out> List<Out> method_1_5_a(Iterable<? extends In> it, ListFunction1<In, Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_1_5_b(Iterable<? extends In> it, ListFunction1<In, Out> fun) { return null; }
	public <In, Out> List<? super Out> method_1_5_c(Iterable<? extends In> it, ListFunction1<In, Out> fun) { return null; }
	
	public <In, Out> List<Out> method_1_6_a(Iterable<? super In> it, ListFunction1<In, Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_1_6_b(Iterable<? super In> it, ListFunction1<In, Out> fun) { return null; }
	public <In, Out> List<? super Out> method_1_6_c(Iterable<? super In> it, ListFunction1<In, Out> fun) { return null; }
	
	public <In, Out> List<Out> method_2_1_a(Iterable<In> it, ListFunction2<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_2_1_b(Iterable<In> it, ListFunction2<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? super Out> method_2_1_c(Iterable<In> it, ListFunction2<? super In, ? extends Out> fun) { return null; }
	
	public <In, Out> List<Out> method_2_2_a(Iterable<? extends In> it, ListFunction2<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_2_2_b(Iterable<? extends In> it, ListFunction2<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? super Out> method_2_2_c(Iterable<? extends In> it, ListFunction2<? super In, ? extends Out> fun) { return null; }
	
	public <In, Out> List<Out> method_2_3_a(Iterable<? super In> it, ListFunction2<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_2_3_b(Iterable<? super In> it, ListFunction2<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? super Out> method_2_3_c(Iterable<? super In> it, ListFunction2<? super In, ? extends Out> fun) { return null; }
	
	public <In, Out> List<Out> method_2_4_a(Iterable<In> it, ListFunction2<In, Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_2_4_b(Iterable<In> it, ListFunction2<In, Out> fun) { return null; }
	public <In, Out> List<? super Out> method_2_4_c(Iterable<In> it, ListFunction2<In, Out> fun) { return null; }
	
	public <In, Out> List<Out> method_2_5_a(Iterable<? extends In> it, ListFunction2<In, Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_2_5_b(Iterable<? extends In> it, ListFunction2<In, Out> fun) { return null; }
	public <In, Out> List<? super Out> method_2_5_c(Iterable<? extends In> it, ListFunction2<In, Out> fun) { return null; }
	
	public <In, Out> List<Out> method_2_6_a(Iterable<? super In> it, ListFunction2<In, Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_2_6_b(Iterable<? super In> it, ListFunction2<In, Out> fun) { return null; }
	public <In, Out> List<? super Out> method_2_6_c(Iterable<? super In> it, ListFunction2<In, Out> fun) { return null; }
	
	public <In, Out> List<Out> method_3_1_a(Iterable<In> it, ListFunction3<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_3_1_b(Iterable<In> it, ListFunction3<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? super Out> method_3_1_c(Iterable<In> it, ListFunction3<? super In, ? extends Out> fun) { return null; }
	
	public <In, Out> List<Out> method_3_2_a(Iterable<? extends In> it, ListFunction3<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_3_2_b(Iterable<? extends In> it, ListFunction3<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? super Out> method_3_2_c(Iterable<? extends In> it, ListFunction3<? super In, ? extends Out> fun) { return null; }
	
	public <In, Out> List<Out> method_3_3_a(Iterable<? super In> it, ListFunction3<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_3_3_b(Iterable<? super In> it, ListFunction3<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? super Out> method_3_3_c(Iterable<? super In> it, ListFunction3<? super In, ? extends Out> fun) { return null; }
	
	public <In, Out> List<Out> method_3_4_a(Iterable<In> it, ListFunction3<In, Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_3_4_b(Iterable<In> it, ListFunction3<In, Out> fun) { return null; }
	public <In, Out> List<? super Out> method_3_4_c(Iterable<In> it, ListFunction3<In, Out> fun) { return null; }
	
	public <In, Out> List<Out> method_3_5_a(Iterable<? extends In> it, ListFunction3<In, Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_3_5_b(Iterable<? extends In> it, ListFunction3<In, Out> fun) { return null; }
	public <In, Out> List<? super Out> method_3_5_c(Iterable<? extends In> it, ListFunction3<In, Out> fun) { return null; }
	
	public <In, Out> List<Out> method_3_6_a(Iterable<? super In> it, ListFunction3<In, Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_3_6_b(Iterable<? super In> it, ListFunction3<In, Out> fun) { return null; }
	public <In, Out> List<? super Out> method_3_6_c(Iterable<? super In> it, ListFunction3<In, Out> fun) { return null; }
	
	public <In, Out> List<Out> method_4_1_a(Iterable<In> it, ListFunction4<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_4_1_b(Iterable<In> it, ListFunction4<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? super Out> method_4_1_c(Iterable<In> it, ListFunction4<? super In, ? extends Out> fun) { return null; }
	
	public <In, Out> List<Out> method_4_2_a(Iterable<? extends In> it, ListFunction4<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_4_2_b(Iterable<? extends In> it, ListFunction4<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? super Out> method_4_2_c(Iterable<? extends In> it, ListFunction4<? super In, ? extends Out> fun) { return null; }
	
	public <In, Out> List<Out> method_4_3_a(Iterable<? super In> it, ListFunction4<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_4_3_b(Iterable<? super In> it, ListFunction4<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? super Out> method_4_3_c(Iterable<? super In> it, ListFunction4<? super In, ? extends Out> fun) { return null; }
	
	public <In, Out> List<Out> method_4_4_a(Iterable<In> it, ListFunction4<In, Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_4_4_b(Iterable<In> it, ListFunction4<In, Out> fun) { return null; }
	public <In, Out> List<? super Out> method_4_4_c(Iterable<In> it, ListFunction4<In, Out> fun) { return null; }
	
	public <In, Out> List<Out> method_4_5_a(Iterable<? extends In> it, ListFunction4<In, Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_4_5_b(Iterable<? extends In> it, ListFunction4<In, Out> fun) { return null; }
	public <In, Out> List<? super Out> method_4_5_c(Iterable<? extends In> it, ListFunction4<In, Out> fun) { return null; }
	
	public <In, Out> List<Out> method_4_6_a(Iterable<? super In> it, ListFunction4<In, Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_4_6_b(Iterable<? super In> it, ListFunction4<In, Out> fun) { return null; }
	public <In, Out> List<? super Out> method_4_6_c(Iterable<? super In> it, ListFunction4<In, Out> fun) { return null; }
	
	public <In, Out> List<Out> method_5_1_a(Iterable<In> it, ListFunction5<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_5_1_b(Iterable<In> it, ListFunction5<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? super Out> method_5_1_c(Iterable<In> it, ListFunction5<? super In, ? extends Out> fun) { return null; }
	
	public <In, Out> List<Out> method_5_2_a(Iterable<? extends In> it, ListFunction5<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_5_2_b(Iterable<? extends In> it, ListFunction5<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? super Out> method_5_2_c(Iterable<? extends In> it, ListFunction5<? super In, ? extends Out> fun) { return null; }
	
	public <In, Out> List<Out> method_5_3_a(Iterable<? super In> it, ListFunction5<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_5_3_b(Iterable<? super In> it, ListFunction5<? super In, ? extends Out> fun) { return null; }
	public <In, Out> List<? super Out> method_5_3_c(Iterable<? super In> it, ListFunction5<? super In, ? extends Out> fun) { return null; }
	
	public <In, Out> List<Out> method_5_4_a(Iterable<In> it, ListFunction5<In, Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_5_4_b(Iterable<In> it, ListFunction5<In, Out> fun) { return null; }
	public <In, Out> List<? super Out> method_5_4_c(Iterable<In> it, ListFunction5<In, Out> fun) { return null; }
	
	public <In, Out> List<Out> method_5_5_a(Iterable<? extends In> it, ListFunction5<In, Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_5_5_b(Iterable<? extends In> it, ListFunction5<In, Out> fun) { return null; }
	public <In, Out> List<? super Out> method_5_5_c(Iterable<? extends In> it, ListFunction5<In, Out> fun) { return null; }
	
	public <In, Out> List<Out> method_5_6_a(Iterable<? super In> it, ListFunction5<In, Out> fun) { return null; }
	public <In, Out> List<? extends Out> method_5_6_b(Iterable<? super In> it, ListFunction5<In, Out> fun) { return null; }
	public <In, Out> List<? super Out> method_5_6_c(Iterable<? super In> it, ListFunction5<In, Out> fun) { return null; }
	
}
