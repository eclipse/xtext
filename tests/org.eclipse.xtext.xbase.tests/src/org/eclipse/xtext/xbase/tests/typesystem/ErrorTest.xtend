/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.xbase.junit.typesystem.Oven
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ErrorTest extends AbstractXbaseTestCase {
	
	@Inject extension Oven
	
	@Test
	def void testErrorModel_01() throws Exception {
		'''ewArrayList('').map[ length + 1 * 5 - length + 1 * 5 ].map [ it / 5 + 1 / it ].head'''.fireproof
	}
	
	@Test
	def void testErrorModel_02() throws Exception {
		'''
			{ val list = newArrayList(if (false) new Double('-20') else  Integer('20')).map(v|v.intValue)
				val Object o = list.head 
				list.head
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_03() throws Exception {
		'''
			{ val list = newArrayList(if (false) new Double('-20') else  Integer('20')).map(v|v.compareTo(null))
				val Object o = list.head 
				list.head
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_04() throws Exception {
		'''newArrayList(if (true) new Double('-20') else  Integer('20'))'''.fireproof
	}
	
	@Test
	def void testErrorModel_05() throws Exception {
		'''
			{ val list = newArrayList(if (false) new Double('-20') else  Integer('20')).map(v|v.intValue)
				val Object o = list.head 
				list
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_06() throws Exception {
		'''
			{ val list = org::eclipse::xtext::xbase::lib::ListExtensions::map(newArrayList(if (false) new Double('-20') else  Integer('20'))) [ v|v.intValue ]
				val Object o = list.head 
				list
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_07() throws Exception {
		'''{ val list = newArrayList(if (false) new Double('-20') else n'''.fireproof
	}
	
	@Test
	def void testErrorModel_08() throws Exception {
		'''{ val list = newArrayList(if (false) new Double('-20') else ne'''.fireproof
	}
	
	@Test
	def void testErrorModel_09() throws Exception {
		'''newArrayList(if (true) new Double('-20') else n'''.fireproof
	}
	
	@Test
	def void testErrorModel_10() throws Exception {
		'''newArrayList(if (true) new Double('-20') else ne'''.fireproof
	}
	
	@Test
	def void testErrorModel_11() throws Exception {
		'''newArrayList(if (true) new Double('-20') else new I'''.fireproof
	}
	
	@Test
	def void testErrorModel_12() throws Exception {
		'''newArrayList(if (true) new Double('-20') else new In'''.fireproof
	}
	
	@Test
	def void testErrorModel_13() throws Exception {
		'''{ val list = newArrayList(if (false) new Double('-20') else new I'''.fireproof
	}
	
	@Test
	def void testErrorModel_14() throws Exception {
		'''{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else n'''.fireproof
	}
	
	@Test
	def void testErrorModel_15() throws Exception {
		'''
			{ val list = newArrayList(if (false) new Double('-20') else ew Integer('20')).map(v|v.intValue)
				val Object o = list.head 
				list.head
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_16() throws Exception {
		'''
			{ val list = newArrayList(if (false) new Double('-20') else ew Integer('20')).map(v|v.compareTo(null))
				val Object o = list.head 
				list.head
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_17() throws Exception {
		'''newArrayList(if (true) new Double('-20') else ew Integer('20'))'''.fireproof
	}
	
	@Test
	def void testErrorModel_18() throws Exception {
		'''newArrayList(if (true) new Double('-20') else ew Integer('20'), new Integer('29'))'''.fireproof
	}
	
	@Test
	def void testErrorModel_19() throws Exception {
		'''newArrayList(if (true) new Double('-20') else ew Integer('20'), new Double('29'))'''.fireproof
	}
	
	@Test
	def void testErrorModel_20() throws Exception {
		'''newArrayList(if (true) new Double('-20') else ew Integer('20'), new Integer('29'), new Double('29'))'''.fireproof
	}
	
	@Test
	def void testErrorModel_21() throws Exception {
		'''
			{ val list = newArrayList(if (false) new Double('-20') else ew Integer('20')).map(v|v.intValue)
				val Object o = list.head 
				list
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_22() throws Exception {
		'''
			{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else ew Integer('20'))) [ v|v.intValue ]
				val Object o = list.head 
				list
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_23() throws Exception {
		'''
			{ val list = newArrayList(if (false) new Double('-20') else newInteger('20')).map(v|v.intValue)
				val Object o = list.head 
				list.head
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_24() throws Exception {
		'''
			{ val list = newArrayList(if (false) new Double('-20') else newInteger('20')).map(v|v.compareTo(null))
				val Object o = list.head 
				list.head
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_25() throws Exception {
		'''newArrayList(if (true) new Double('-20') else newInteger('20'))'''.fireproof
	}
	
	@Test
	def void testErrorModel_26() throws Exception {
		'''
			{ val list = newArrayList(if (false) new Double('-20') else newInteger('20')).map(v|v.intValue)
				val Object o = list.head 
				list
			}
		'''.fireproof
	}
	
	@Test
	def void testErrorModel_27() throws Exception {
		'''
			{ val list = $$ListExtensions::map(newArrayList(if (false) new Double('-20') else  Integer('20'))) [ v|v.intValue ]
				val Object o = list.head 
				list
			}
		'''.fireproof
	}
	
}