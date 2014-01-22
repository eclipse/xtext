/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import com.google.inject.Inject
import org.eclipse.xtext.xbase.typing.XbaseTypeArgumentContextProvider
import org.eclipse.xtext.xbase.typing.XbaseTypeProvider
import org.junit.Ignore
import org.junit.Test

/**
 * @author Sebastian Zarnekow
 */
class OldAPITypeResolverTest extends AbstractOldAPITypeResolverTest {

	@Inject
	XbaseTypeProvider typeProvider
	
	override protected getTypeProvider() {
		typeProvider
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testBlockExpression_03() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Test
    override testBlockExpression_07() throws Exception {
        "{
            val (Integer, Double, Boolean) => void fun1 = null
            val (byte[], Object) => double[] fun2 = null
            val test = newArrayList.map[1 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]
            val test2 = newArrayList.map[2 -> org::eclipse::xtext::xbase::lib::Pair::of(fun1, fun2)]
            val test3 = com::google::common::collect::Iterables::concat(test, test2).toMap[key].entrySet.map[value].toList
            test3
        }".resolvesTo("List<Pair<Integer, Pair<Procedure3<? super Integer, ? super Double, ? super Boolean>, Function2<? super byte[], ? super Object, ? extends double[]>>>>")
    }
    
	@Ignore("fails in old implementation") @Test override testBlockExpression_09() throws Exception {
		fail("fails in old implementation")
	}
    
	@Ignore("fails in old implementation") @Test override testBlockExpression_10() throws Exception {
		fail("fails in old implementation")
	}
    
	@Ignore("fails in old implementation") @Test override testBlockExpression_11() throws Exception {
		fail("fails in old implementation")
	}
    
	@Ignore("fails in old implementation") @Test override testBlockExpression_12() throws Exception {
		fail("fails in old implementation")
	}
    
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_b() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_c() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_d() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_d_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_e_2() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_f() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_f_2() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_g() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_g_2() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_h() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_h_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_i() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_i_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_i_3() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_15_i_4() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_j() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_j_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_k() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_k_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_l() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_l_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_m() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_n() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_n_1() throws Exception {
		fail("timeout")
	}
	
	@Ignore("timeout")
	@Test
	override testFeatureCall_15_n_2() throws Exception {
		fail("timeout")
	}
	
	@Ignore("not a timeout but too slow")
	@Test
	override testFeatureCall_25_d() throws Exception {
		fail("not a timeout but too slow")
	}
	
	@Ignore("fails in old implementation") @Test override testEntrySet_01() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testAssignment_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testAssignment_06() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_03_b() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_10() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_13() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_24_a() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_24_b() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_32() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_33() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testMemberFeatureCall_04() throws Exception {
		fail("fails in old implementation") 
	}
	@Ignore("fails in old implementation") @Test override testMemberFeatureCall_05() throws Exception {
		fail("fails in old implementation") 
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCallWithArrayToIterableConversion_04() throws Exception {
        fail("fails in old implementation")
    }
	@Ignore("fails in old implementation") @Test override testFeatureCallWithArrayToIterableConversion_06() throws Exception {
        fail("fails in old implementation")
    }
	@Ignore("fails in old implementation") @Test override testFeatureCallWithArrayToIterableConversion_07() throws Exception {
        fail("fails in old implementation")
    }
	
	@Ignore("fails in old implementation") @Test override testOverloadedVarArgs_03() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testImplicitImportPrintln_01() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testImplicitImportEmptyList() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testMethodTypeParamInference_03() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testMethodTypeParamInference_04() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testMethodTypeParamInference_05() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_06() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_08() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_10() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_13() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_13a() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_13b() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_15() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_16() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_16_02() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_17() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_18() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_19() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_20() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_21() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_22() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_23() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_24() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_25() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_26() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_27() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_28() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_29() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_30() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_31() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testIfExpression_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_06() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_07() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_08() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_09() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_10() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_11() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_12() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_17() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_18() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_23() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_24() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_25() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_27() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_31() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_33() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_34() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testVarArgs_07() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testSwitchExpression_2() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testSwitchExpression_3() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testSwitchExpression_4() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testSwitchExpression_6() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testSwitchExpression_7() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testSwitchExpression_8() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testSwitchExpression_9() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testSwitchExpression_10() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testSwitchExpression_11() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testTypeLiteral_2() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testTypeLiteral_3() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testTypeLiteral_6() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testTypeLiteral_7() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testTypeLiteral_8() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testTypeLiteral_9() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testTypeGuardedCase_2() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorCall_01() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorCall_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorCall_03() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_06_00() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_27() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testFeatureCall_28() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testToList_04() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testToList_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testToList_07() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testBounds_24() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testBounds_26() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testPropertyAccess_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testPropertyAccess_06() throws Exception {
		fail("fails in old implementation")
	}
	
    @Ignore("fails in old implementation") @Test override testBug_381466_01() throws Exception {
        fail("fails in old implementation")
    }
    @Ignore("fails in old implementation") @Test override testBug_381466_02() throws Exception {
        fail("fails in old implementation")
    }
    @Ignore("fails in old implementation") @Test override testBug_381466_03() throws Exception {
        fail("fails in old implementation")
    }
    @Ignore("fails in old implementation") @Test override testBug_381466_04() throws Exception {
        fail("fails in old implementation")
    }
	
	@Ignore("fails in old implementation") @Test override testTypeByTransitiveExpectation_01() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testTypeByTransitiveExpectation_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_002() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_003() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_004() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_005() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_006() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_007() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_008() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_009() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_010() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_011() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_012() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_013() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_014() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_015() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_016() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_017() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_018() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_019() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_020() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_021() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_022() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_023() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_024() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_025() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_026() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_027() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_028() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_029() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_030() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_031() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_032() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_033() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_034() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_035() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_036() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_037() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_038() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_039() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_040() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_041() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_042() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_043() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_044() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_045() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_046() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_048() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_049() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_050() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_051() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_052() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_053() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_054() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_055() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_056() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_057() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_058() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_059() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_060() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_061() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_062() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_063() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_064() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_065() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_066() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_067() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_068() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_069() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_070() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_071() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_072() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_073() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_074() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_075() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_076() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_077() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_078() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_079() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_080() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_081() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_082() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_083() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_084() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_085() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_086() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_087() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_088() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_089() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_090() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_091() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_092() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_093() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_094() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_095() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_096() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_097() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_098() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_099() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_100() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_101() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_102() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_103() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_104() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_105() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_106() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_107() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_108() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_109() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_110() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_111() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_112() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_113() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_114() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_115() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_116() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_117() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_118() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_119() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_120() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_121() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_122() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_123() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_124() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_125() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_126() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_127() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_128() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_129() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_130() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_131() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_132() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_133() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_134() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_135() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_136() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_137() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_138() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_139() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_140() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_141() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_142() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_143() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_144() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_145() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_146() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_147() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_148() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_149() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_150() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_151() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_152() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_153() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_154() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_155() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_156() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_157() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_158() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_159() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_160() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_161() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_162() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_163() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_164() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_165() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_167() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_04() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_06() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_07() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_08() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testBug_391758() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testRawType_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testListLiteral_00() {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testListLiteral_03() {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testListLiteral_05() {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testListLiteral_09() {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testListLiteral_10() {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testListLiteral_11() {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testListLiteral_12() {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testListLiteral_13() {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testListLiteral_14() {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testSetLiteral_00() {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testSetLiteral_03() {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testSetLiteral_05() {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testSetLiteral_08() {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testSetLiteral_09() {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testSetLiteral_10() {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testBrokenConstructorCall_01() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testBrokenConstructorCall_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClassGetSuperclass_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClassGetSuperclass_04() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testTypeForVoidClosure_02() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testTypeForVoidClosure_04() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testTypeForVoidClosure_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testTypeForVoidClosure_07() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testTypeForEmptyClosure_01() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testTypeForEmptyClosure_02() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testTypeForEmptyClosure_03() throws Exception {
		fail("fails in old implementation")
	}
}

/**
 * @author Sebastian Zarnekow
 */
class OldAPITypeArgumentTest extends AbstractOldAPITypeArgumentTest {
	
	@Inject
	XbaseTypeArgumentContextProvider typeArgumentContextProvider
	
	@Inject
	XbaseTypeProvider typeProvider
	
	override protected getTypeProvider() {
		typeProvider
	}
	
	override protected getTypeArgumentContextProvider() {
		typeArgumentContextProvider
	}
	
	
	@Ignore("fails in old implementation") @Test override testNumberLiteralInClosure_01() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testOverloadedMethods_09() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_06() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_28() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_31() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_71() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_72() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_74() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testMethodTypeParamInference_11() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testMethodTypeParamInference_13() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testMethodTypeParamInference_18() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testMethodTypeParamInference_20() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testMethodTypeParamInference_24() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testMethodTypeParamInference_25() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testMethodTypeParamInference_26() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testImplicitImportPrintln_01() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testImplicitImportEmptyList_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_06() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_07() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_08() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_09() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_13() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_13a() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_13b() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_16() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_17() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_18() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_19() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_20() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_21() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_22() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_24() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_25() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_26() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_27() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testEMap_01() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testEMap_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testEMap_03() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testEMap_05() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testEMap_06() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testEMap_07() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testEMap_09() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testEMap_10() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testEMap_11() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorCall_03() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorCall_04() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorCall_05() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorCall_06() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorCall_07() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorTypeInference_04() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testToList_04() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testToList_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testToList_07() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testTypeByTransitiveExpectation_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testExpectationActualMismatch_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_08() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_10() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_002() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_003() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_004() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_005() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_006() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_007() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_008() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_009() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_010() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_011() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_012() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_013() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_014() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_015() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_016() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_017() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_018() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_019() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_020() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_021() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_022() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_023() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_024() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_025() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_026() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_027() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_028() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_029() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_030() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_031() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_032() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_033() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_034() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_035() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_036() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_037() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_041() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_042() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_043() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_044() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_045() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_046() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_048() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_049() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_050() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_051() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_053() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_057() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_060() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_061() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_062() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_063() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_064() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_065() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_067() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_068() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_069() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_070() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_071() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_072() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_073() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_074() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_075() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_076() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_077() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_078() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_079() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_080() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_081() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_082() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_083() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_084() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_085() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_086() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_087() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_088() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_089() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_090() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_091() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_092() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_093() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_094() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_095() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_096() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_097() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_098() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_099() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_100() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_101() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_102() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_103() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_107() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_108() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_109() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_110() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_111() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_112() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_113() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_114() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_115() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_116() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_117() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_118() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_119() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_123() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_126() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_127() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_128() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_129() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_130() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_131() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_133() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_134() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_135() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_136() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_137() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_138() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_139() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_143() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_148() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_149() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_150() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_152() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_153() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_154() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_155() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_156() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_157() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_158() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_159() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_160() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_161() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_01() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_04() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_06() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_07() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_08() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testRawType_01() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRawType_02() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRawType_04() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRawType_05() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCallWithExpectation_01() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testFeatureCallWithExpectation_02() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testFeatureCallWithExpectation_04() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testFeatureCallWithExpectation_05() throws Exception {
		fail("fails in old implementation")
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class OldAPIClosureTypeTest extends AbstractOldAPIClosureTypeTest {
	
	@Inject
	XbaseTypeProvider typeProvider
	
	override protected getTypeProvider() {
		typeProvider
	}
	
	@Ignore("fails in old impl")
	@Test 
	override testAbstractIterator_01() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test 
	override testAbstractIterator_02() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test 
	override testSpecializedSubInterface_01() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test 
	override testSpecializedSubInterface_02() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test 
	override testSpecializedSubInterface_03() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test 
	override testSpecializedSubInterface_04() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test 
	override testSpecializedSubInterface_05() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test 
	override testSpecializedSubInterface_06() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test 
	override testSpecializedSubInterface_07() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test 
	override testOverloadedOperators_03() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_04() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_12() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_13() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_14() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_16() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_17() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_19() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_20() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_22() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_23() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_30() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_31() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_32() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_33() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_34() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_35() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testOverloadedOperators_37() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_02() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_03() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_04() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_05() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_06() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_08() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_09() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_09_2() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_10() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_11() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_12() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_13() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_14() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_15() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_16() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_17() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_18() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_19() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_20() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_21() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_22() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_23() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_24() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_26() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_27() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_30() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_31() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_32() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_33() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_34() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_36() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_37() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_37_02() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_38() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_39() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_40() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_41() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_42() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_43() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_44() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_45() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_46() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_47() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_48() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_49() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_50() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_52() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_54() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_55() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_57() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testClosure_58() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testMemberFeatureCall_01() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testMemberFeatureCall_02() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testNumberLiteralInClosure_01() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testNumberLiteralInClosure_02() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_016() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_019() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_065() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_086() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_088() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_089() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_096() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_097() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_098() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_099() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_102() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_103() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_106() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_107() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_108() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_109() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_110() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_111() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_114() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_115() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_116() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_117() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_118() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_119() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_122() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_123() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_124() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testFeatureCall_135() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testIfExpression_05() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testIfExpression_07() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testIfExpression_09() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testIfExpression_12() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testIfExpression_17() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testIfExpression_19() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testIfExpression_21() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testIfExpression_24() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testIfExpression_25() throws Exception {
		fail("fails in old impl")
	}

	@Ignore("fails in old impl")
	@Test
	override testDeferredTypeArgumentResolution_15() throws Exception {
		fail("fails in old impl")
	}
	
	@Ignore("fails in old impl")
	@Test
	override testDeferredTypeArgumentResolution_16() throws Exception {
		fail("fails in old impl")
	}

	@Ignore("fails in old impl")
	@Test
	override testIncompatibleExpression_01() throws Exception {
		fail("fails in old impl")	
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class OldAPIConstructorCallTypeTest extends AbstractOldAPIConstructorCallTypeTest {
	
	@Inject
	XbaseTypeProvider typeProvider
	
	override protected getTypeProvider() {
		typeProvider
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorTypeParameters_01() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testConstructorTypeParameters_02() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testConstructorTypeParameters_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testConstructorTypeParameters_04() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorTypeInference_04() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testConstructorTypeInference_06() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testConstructorTypeInference_07() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_08() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_10() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_068() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_069() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_070() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_071() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_072() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_073() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_074() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_075() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_076() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_077() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_078() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_079() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_080() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_081() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_082() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_083() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_084() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_085() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_086() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_087() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_088() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_089() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_090() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_091() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_092() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_093() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_094() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_095() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_096() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_097() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_098() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_099() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_100() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_101() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_102() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_103() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_104() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_105() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_106() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_107() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_108() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_109() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_110() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_111() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_112() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_113() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_114() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_115() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_116() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_117() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_118() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_119() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_120() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_121() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_122() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_123() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_124() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_125() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_126() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_127() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_128() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_129() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_130() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_131() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_132() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_134() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_136() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_143() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_144() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_145() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_146() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_147() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_148() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_149() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_150() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_151() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_155() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_06() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_07() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_08() throws Exception {
		fail("fails in old implementation")
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class OldAPIFeatureCallTypeTest extends AbstractOldAPIFeatureCallTypeTest { 
	
	@Inject
	XbaseTypeProvider typeProvider
	
	override protected getTypeProvider() {
		typeProvider
	}
	
	@Ignore("fails in old implementation") @Test override testMethodTypeParamInference_04() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testMethodTypeParamInference_05() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testReturnType_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testOverloadedMethods_01() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testOverloadedMethods_02() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testOverloadedMethods_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testOverloadedMethods_04() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testOverloadedMethods_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testOverloadedMethods_06() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testOverloadedMethods_07() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testOverloadedMethods_08() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testOverloadedMethods_09() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testOverloadedMethods_10() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testOverloadedMethods_11() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testOverloadedMethods_12() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testJEP101Example_01() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testJEP101Example_02() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testJEP101Example_03() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testNumberLiteralInClosure_01() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testArray_04() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testArray_07() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testArray_08() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testArray_09() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_03() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_05() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_13() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_15() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_27() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_30() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_31() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testIfExpression_01() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testIfExpression_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testSwitchExpression_4() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testSwitchExpression_5() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testSwitchExpression_6() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testSwitchExpression_7() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testTypeGuardedCase_1() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testConstructorTypeInference_04() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_06_00() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_33() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_35() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCallWithOperatorOverloading_6() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testToList_01() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testToList_02() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testToList_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testToList_04() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testToList_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testToList_06() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testToList_07() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testToList_08() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testToList_09() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testPropertyAccess_05() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testPropertyAccess_06() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testBug_389512() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testBug_391758() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testTypeByTransitiveExpectation_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_01() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_02() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_03() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_04() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_05() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_06() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_07() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_08() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_09() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDependentTypeArgumentResolution_10() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_002() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_003() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_004() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_005() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_006() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_007() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_010() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_011() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_014() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_015() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_017() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_041() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_068() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_069() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_070() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_071() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_072() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_073() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_074() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_075() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_076() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_077() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_080() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_081() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_082() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_083() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_107() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_110() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_114() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_116() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_117() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_119() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_123() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_134() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_138() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_158() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testRecursiveTypeArgumentResolution_05() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testRawType_01() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testRawType_02() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testRawType_05() throws Exception {
		fail("fails in old implementation")
	}
	
}

/**
 * @author Sebastian Zarnekow
 */
class OldAPIIdentifiableTypeTest extends AbstractOldAPIIdentifiableTypeTest {
	
	@Inject
	XbaseTypeProvider typeProvider
	
	override protected getTypeProvider() {
		typeProvider
	}
	
	@Ignore("fails in old implementation") @Test override testIfExpression_01() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_03() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_04() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_13() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_13b() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_15() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_16() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_17() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_21() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_22() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testClosure_26() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_27() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_30() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testClosure_31() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_32() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testFeatureCall_35() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_002() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_012() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_016() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_036() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_037() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_038() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_040() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_042() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_061() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_062() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_102() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_106() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_133() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_134() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_135() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_136() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_137() throws Exception {
		fail("fails in old implementation")
	}
	@Ignore("fails in old implementation") @Test override testDeferredTypeArgumentResolution_138() throws Exception {
		fail("fails in old implementation")
	}
	
	@Ignore("takes too long") @Test override testFeatureCall_15_b() throws Exception {
		fail("takes too long")
	}
	@Ignore("takes too long") @Test override testFeatureCall_15_f() throws Exception {
		fail("takes too long")
	}
}
