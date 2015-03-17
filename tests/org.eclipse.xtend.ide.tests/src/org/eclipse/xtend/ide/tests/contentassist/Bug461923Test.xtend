/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug461923Test extends AbstractXtendContentAssistBugTest {
	
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T> m(List<? extends T> list, T value) {
			        ImmutableList.builder.addAll(list.<|>filter[it != value]).build
			    }
			}
		''')
			.assertProposalAtCursor('filter[]')
	}
	
	@Test def void test_02() throws Exception {
		newBuilder.append('''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T> m(List<T> list, T value) {
			        ImmutableList.builder.addAll(list.<|>filter[it != value]).build
			    }
			}
		''')
			.assertProposalAtCursor('filter[]')
	}
	
	@Test def void test_03() throws Exception {
		newBuilder.append('''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T> m(List<? super T> list, T value) {
			        ImmutableList.builder.addAll(list.<|>filter[it != value]).build
			    }
			}
		''')
			.assertProposalAtCursor('filter[]')
	}
	
	@Test def void test_04() throws Exception {
		newBuilder.append('''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static m(List<? extends String> list, String value) {
			        ImmutableList.builder.addAll(list.<|>filter[it != value]).build
			    }
			}
		''')
			.assertProposalAtCursor('filter[]')
	}
	
	@Test def void test_05() throws Exception {
		newBuilder.append('''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static m(List<String> list, String value) {
			        ImmutableList.builder.addAll(list.<|>filter[it != value]).build
			    }
			}
		''')
			.assertProposalAtCursor('filter[]')
	}
	
	@Test def void test_06() throws Exception {
		newBuilder.append('''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static m(List<? super String> list, String value) {
			        ImmutableList.builder.addAll(list.<|>filter[it != value]).build
			    }
			}
		''')
			.assertProposalAtCursor('filter[]')
	}
	
	@Test def void test_07() throws Exception {
		newBuilder.append('''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T> m(T[] arr, T value) {
			        ImmutableList.builder.addAll(arr.<|>filter[it != value]).build
			    }
			}
		''')
			.assertProposalAtCursor('filter[]')
	}
	
	@Test def void test_08() throws Exception {
		newBuilder.append('''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T extends Number> m(T[] arr, T value) {
			        ImmutableList.builder.addAll(arr.<|>filter[it != value]).build
			    }
			    def static sum(List<? extends Number> list) {
			        null
			    }
			}
		''')
			.assertProposalAtCursor('sum')
	}
	
	@Test def void test_09() throws Exception {
		newBuilder.append('''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T extends Number> m(List<? extends T> list, T value) {
			        ImmutableList.builder.addAll(list.<|>filter[it != value]).build
			    }
			    def static sum(List<? extends Number> list) {
			        null
			    }
			}
		''')
			.assertProposalAtCursor('sum')
	}
	
	@Test def void test_10() throws Exception {
		newBuilder.append('''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T extends CharSequence> m(CharSequence[] arr, T value) {
			        ImmutableList.builder.addAll(arr.<|>filter[it != value]).build
			    }
			    def static sum(List<? extends Number> list) {
			        null
			    }
			}
		''')
			.assertNoProposalAtCursor('sum')
	}
	
	@Test def void test_11() throws Exception {
		newBuilder.append('''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def static <T extends CharSequence> m(List<? extends T> list, T value) {
			        ImmutableList.builder.addAll(list.<|>filter[it != value]).build
			    }
			    def static sum(List<? extends Number> list) {
			        null
			    }
			}
		''')
			.assertNoProposalAtCursor('sum')
	}
	
	@Test def void test_12() throws Exception {
		newBuilder.append('''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def <T extends Number> m(T[] arr, T value) {
			        ImmutableList.builder.addAll(arr.<|>filter[it != value]).build
			    }
			    def sum(List<? extends Number> list) {
			        null
			    }
			}
		''')
			.assertProposalAtCursor('sum')
	}
	
	@Test def void test_13() throws Exception {
		newBuilder.append('''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def <T extends Number> m(List<? extends T> list, T value) {
			        ImmutableList.builder.addAll(list.<|>filter[it != value]).build
			    }
			    def sum(List<? extends Number> list) {
			        null
			    }
			}
		''')
			.assertProposalAtCursor('sum')
	}
	
	@Test def void test_14() throws Exception {
		newBuilder.append('''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def <T extends CharSequence> m(CharSequence[] arr, T value) {
			        ImmutableList.builder.addAll(arr.<|>filter[it != value]).build
			    }
			    def sum(List<? extends Number> list) {
			        null
			    }
			}
		''')
			.assertNoProposalAtCursor('sum')
	}
	
	@Test def void test_15() throws Exception {
		newBuilder.append('''
			import java.util.List
			import com.google.common.collect.ImmutableList
			
			class C {
			    def <T extends CharSequence> m(List<? extends T> list, T value) {
			        ImmutableList.builder.addAll(list.<|>filter[it != value]).build
			    }
			    def sum(List<? extends Number> list) {
			        null
			    }
			}
		''')
			.assertNoProposalAtCursor('sum')
	}
	
}