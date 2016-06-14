/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.typesystem;

import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputer;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import com.google.caliper.Param;
import com.google.caliper.Runner;

//Starting Point (v2.4.2)



// 05.06.2013

//0% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT, right=OBJECT} 51.09 ns; ?=0.38 ns @ 3 trials
//0% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT, right=OBJECT} 98.73 ns; ?=4.74 ns @ 10 trials
//1% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT, right=OBJECT} 92.56 ns; ?=5.54 ns @ 10 trials
//1% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT, right=OBJECT} 104.52 ns; ?=0.95 ns @ 3 trials
//1% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT, right=OBJECT} 92.89 ns; ?=0.34 ns @ 3 trials
//2% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT, right=OBJECT} 90.08 ns; ?=0.78 ns @ 4 trials
//2% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Legacy, left=OBJECT, right=OBJECT} 312.71 ns; ?=2.13 ns @ 3 trials
//2% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Legacy, left=OBJECT, right=OBJECT} 311.17 ns; ?=4.37 ns @ 10 trials
//3% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Legacy, left=OBJECT, right=OBJECT} 288.31 ns; ?=2.83 ns @ 4 trials
//3% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=NoOp, left=OBJECT, right=OBJECT} 0.30 ns; ?=0.00 ns @ 3 trials
//3% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=NoOp, left=OBJECT, right=OBJECT} 0.31 ns; ?=0.00 ns @ 3 trials
//4% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=NoOp, left=OBJECT, right=OBJECT} 0.31 ns; ?=0.00 ns @ 3 trials
//4% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT_ARRAY, right=OBJECT} 1993.48 ns; ?=22.07 ns @ 10 trials
//4% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT_ARRAY, right=OBJECT} 1943.85 ns; ?=33.54 ns @ 10 trials
//5% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT_ARRAY, right=OBJECT} 1715.54 ns; ?=38.42 ns @ 10 trials
//5% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT_ARRAY, right=OBJECT} 885.97 ns; ?=4.90 ns @ 3 trials
//5% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT_ARRAY, right=OBJECT} 915.91 ns; ?=6.02 ns @ 3 trials
//6% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT_ARRAY, right=OBJECT} 869.83 ns; ?=6.52 ns @ 3 trials
//6% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Legacy, left=OBJECT_ARRAY, right=OBJECT} 3127.25 ns; ?=30.33 ns @ 3 trials
//6% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Legacy, left=OBJECT_ARRAY, right=OBJECT} 3227.94 ns; ?=75.67 ns @ 10 trials
//7% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Legacy, left=OBJECT_ARRAY, right=OBJECT} 2847.34 ns; ?=42.26 ns @ 10 trials
//7% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=NoOp, left=OBJECT_ARRAY, right=OBJECT} 4.59 ns; ?=0.04 ns @ 3 trials
//7% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=NoOp, left=OBJECT_ARRAY, right=OBJECT} 4.63 ns; ?=0.06 ns @ 10 trials
//8% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=NoOp, left=OBJECT_ARRAY, right=OBJECT} 4.64 ns; ?=0.03 ns @ 3 trials
//8% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Old, left=CLONEABLE, right=OBJECT} 3574.53 ns; ?=32.79 ns @ 3 trials
//8% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=CLONEABLE, right=OBJECT} 4322.96 ns; ?=22.88 ns @ 3 trials
//9% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Old, left=CLONEABLE, right=OBJECT} 3539.36 ns; ?=58.80 ns @ 10 trials
//9% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=CLONEABLE, right=OBJECT} 1412.33 ns; ?=6.19 ns @ 3 trials
//9% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=CLONEABLE, right=OBJECT} 1410.35 ns; ?=4.81 ns @ 3 trials
//10% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=CLONEABLE, right=OBJECT} 1339.45 ns; ?=16.30 ns @ 10 trials
//10% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Legacy, left=CLONEABLE, right=OBJECT} 4169.92 ns; ?=15.96 ns @ 3 trials
//10% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Legacy, left=CLONEABLE, right=OBJECT} 4376.06 ns; ?=11.43 ns @ 3 trials
//11% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Legacy, left=CLONEABLE, right=OBJECT} 4310.67 ns; ?=32.09 ns @ 3 trials
//11% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=NoOp, left=CLONEABLE, right=OBJECT} 0.38 ns; ?=0.00 ns @ 3 trials
//11% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=NoOp, left=CLONEABLE, right=OBJECT} 0.47 ns; ?=0.00 ns @ 3 trials
//12% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=NoOp, left=CLONEABLE, right=OBJECT} 0.48 ns; ?=0.00 ns @ 3 trials
//12% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Old, left=INT, right=OBJECT} 5307.57 ns; ?=18.28 ns @ 3 trials
//12% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=INT, right=OBJECT} 5727.70 ns; ?=42.08 ns @ 3 trials
//13% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Old, left=INT, right=OBJECT} 5411.99 ns; ?=55.22 ns @ 10 trials
//13% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=INT, right=OBJECT} 2985.69 ns; ?=10.78 ns @ 3 trials
//13% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=INT, right=OBJECT} 3260.61 ns; ?=32.35 ns @ 5 trials
//14% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=INT, right=OBJECT} 2920.94 ns; ?=14.89 ns @ 3 trials
//14% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Legacy, left=INT, right=OBJECT} 5773.42 ns; ?=10.70 ns @ 3 trials
//14% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Legacy, left=INT, right=OBJECT} 6586.61 ns; ?=27.94 ns @ 3 trials
//15% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Legacy, left=INT, right=OBJECT} 5998.15 ns; ?=30.63 ns @ 3 trials
//15% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=NoOp, left=INT, right=OBJECT} 0.37 ns; ?=0.00 ns @ 6 trials
//15% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=NoOp, left=INT, right=OBJECT} 0.48 ns; ?=0.00 ns @ 3 trials
//16% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=NoOp, left=INT, right=OBJECT} 0.48 ns; ?=0.00 ns @ 3 trials
//16% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_COMPARABLE, right=OBJECT} 907.98 ns; ?=0.44 ns @ 3 trials
//16% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_COMPARABLE, right=OBJECT} 1031.79 ns; ?=4.14 ns @ 3 trials
//17% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_COMPARABLE, right=OBJECT} 1006.44 ns; ?=3.18 ns @ 3 trials
//17% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_COMPARABLE, right=OBJECT} 1396.38 ns; ?=5.39 ns @ 3 trials
//17% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_COMPARABLE, right=OBJECT} 1423.12 ns; ?=14.49 ns @ 10 trials
//18% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_COMPARABLE, right=OBJECT} 1329.78 ns; ?=16.19 ns @ 10 trials
//18% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Legacy, left=RAW_COMPARABLE, right=OBJECT} 1202.47 ns; ?=9.61 ns @ 3 trials
//18% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Legacy, left=RAW_COMPARABLE, right=OBJECT} 1284.17 ns; ?=20.99 ns @ 10 trials
//19% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Legacy, left=RAW_COMPARABLE, right=OBJECT} 1207.95 ns; ?=9.30 ns @ 3 trials
//19% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=NoOp, left=RAW_COMPARABLE, right=OBJECT} 0.38 ns; ?=0.00 ns @ 3 trials
//19% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=NoOp, left=RAW_COMPARABLE, right=OBJECT} 0.47 ns; ?=0.00 ns @ 4 trials
//20% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=NoOp, left=RAW_COMPARABLE, right=OBJECT} 0.47 ns; ?=0.01 ns @ 10 trials
//20% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT, right=OBJECT_ARRAY} 180.21 ns; ?=0.54 ns @ 3 trials
//20% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT, right=OBJECT_ARRAY} 222.49 ns; ?=2.63 ns @ 10 trials
//21% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT, right=OBJECT_ARRAY} 208.56 ns; ?=1.00 ns @ 3 trials
//21% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT, right=OBJECT_ARRAY} 192.14 ns; ?=0.17 ns @ 3 trials
//21% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT, right=OBJECT_ARRAY} 222.50 ns; ?=1.25 ns @ 3 trials
//22% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT, right=OBJECT_ARRAY} 202.14 ns; ?=1.27 ns @ 3 trials
//22% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Legacy, left=OBJECT, right=OBJECT_ARRAY} 525.63 ns; ?=4.83 ns @ 6 trials
//22% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Legacy, left=OBJECT, right=OBJECT_ARRAY} 467.02 ns; ?=3.82 ns @ 3 trials
//23% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Legacy, left=OBJECT, right=OBJECT_ARRAY} 450.39 ns; ?=0.26 ns @ 3 trials
//23% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=NoOp, left=OBJECT, right=OBJECT_ARRAY} 3.71 ns; ?=0.01 ns @ 3 trials
//23% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=NoOp, left=OBJECT, right=OBJECT_ARRAY} 3.75 ns; ?=0.08 ns @ 10 trials
//24% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=NoOp, left=OBJECT, right=OBJECT_ARRAY} 3.80 ns; ?=0.02 ns @ 3 trials
//24% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 70.43 ns; ?=0.44 ns @ 3 trials
//24% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 109.32 ns; ?=0.69 ns @ 3 trials
//25% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 103.95 ns; ?=0.51 ns @ 3 trials
//25% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 123.46 ns; ?=0.44 ns @ 3 trials
//25% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 111.96 ns; ?=0.76 ns @ 3 trials
//26% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 111.36 ns; ?=1.16 ns @ 10 trials
//26% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Legacy, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 363.24 ns; ?=3.43 ns @ 3 trials
//26% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Legacy, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 334.37 ns; ?=0.66 ns @ 3 trials
//27% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Legacy, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 323.32 ns; ?=1.81 ns @ 3 trials
//27% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=NoOp, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 4.87 ns; ?=0.01 ns @ 3 trials
//27% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=NoOp, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 5.99 ns; ?=0.05 ns @ 3 trials
//28% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=NoOp, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 5.93 ns; ?=0.03 ns @ 3 trials
//28% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Old, left=CLONEABLE, right=OBJECT_ARRAY} 496.02 ns; ?=2.02 ns @ 3 trials
//28% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=CLONEABLE, right=OBJECT_ARRAY} 559.49 ns; ?=5.37 ns @ 6 trials
//29% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Old, left=CLONEABLE, right=OBJECT_ARRAY} 534.26 ns; ?=3.75 ns @ 3 trials
//29% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=CLONEABLE, right=OBJECT_ARRAY} 539.92 ns; ?=2.56 ns @ 3 trials
//29% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=CLONEABLE, right=OBJECT_ARRAY} 617.77 ns; ?=0.79 ns @ 3 trials
//30% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=CLONEABLE, right=OBJECT_ARRAY} 564.38 ns; ?=2.17 ns @ 3 trials
//30% Scenario{vm=java6, trial=0, benchmark=IsAssignable, implementation=Legacy, left=CLONEABLE, right=OBJECT_ARRAY} 837.63 ns; ?=2.33 ns @ 3 trials
//30% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Legacy, left=CLONEABLE, right=OBJECT_ARRAY} 824.18 ns; ?=12.84 ns @ 10 trials
//31% Scenario{vm=java8, trial=0, benchmark=IsAssignable, implementation=Legacy, left=CLONEABLE, right=OBJECT_ARRAY}

// 06.06

//0% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=OBJECT, right=OBJECT} 90.27 ns; ?=0.25 ns @ 3 trials
//1% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT, right=OBJECT} 93.55 ns; ?=0.67 ns @ 3 trials
//1% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT, right=OBJECT} 95.75 ns; ?=0.15 ns @ 3 trials
//2% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=OBJECT_ARRAY, right=OBJECT} 93.29 ns; ?=1.99 ns @ 10 trials
//3% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT_ARRAY, right=OBJECT} 3605.11 ns; ?=65.51 ns @ 10 trials
//3% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT_ARRAY, right=OBJECT} 927.93 ns; ?=10.00 ns @ 10 trials
//4% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=CLONEABLE, right=OBJECT} 756.80 ns; ?=8.86 ns @ 10 trials
//5% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=CLONEABLE, right=OBJECT} 5596.56 ns; ?=83.28 ns @ 10 trials
//5% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=CLONEABLE, right=OBJECT} 1422.41 ns; ?=17.61 ns @ 10 trials
//6% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=INT, right=OBJECT} 603.63 ns; ?=2.98 ns @ 3 trials
//7% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=INT, right=OBJECT} 6617.21 ns; ?=36.57 ns @ 3 trials
//7% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=INT, right=OBJECT} 3358.94 ns; ?=20.14 ns @ 3 trials
//8% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=RAW_COMPARABLE, right=OBJECT} 1015.00 ns; ?=5.61 ns @ 3 trials
//9% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_COMPARABLE, right=OBJECT} 1038.49 ns; ?=3.41 ns @ 3 trials
//10% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_COMPARABLE, right=OBJECT} 1597.45 ns; ?=23.80 ns @ 10 trials
//10% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=OBJECT} 768.40 ns; ?=9.35 ns @ 10 trials
//11% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=OBJECT} 1064.21 ns; ?=10.01 ns @ 6 trials
//12% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=OBJECT} 1470.28 ns; ?=39.01 ns @ 10 trials
//12% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=RAW_ELIST_SUBTYPE, right=OBJECT} 1723.58 ns; ?=13.23 ns @ 3 trials
//13% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_ELIST_SUBTYPE, right=OBJECT} 1795.28 ns; ?=17.03 ns @ 3 trials
//14% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_ELIST_SUBTYPE, right=OBJECT} 2199.33 ns; ?=21.03 ns @ 3 trials
//14% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=OBJECT, right=OBJECT_ARRAY} 271.35 ns; ?=3.17 ns @ 10 trials
//15% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT, right=OBJECT_ARRAY} 214.16 ns; ?=3.53 ns @ 10 trials
//16% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT, right=OBJECT_ARRAY} 246.35 ns; ?=3.34 ns @ 10 trials
//16% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 189.84 ns; ?=2.19 ns @ 10 trials
//17% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 118.11 ns; ?=3.43 ns @ 10 trials
//18% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 110.51 ns; ?=0.78 ns @ 3 trials
//18% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=CLONEABLE, right=OBJECT_ARRAY} 640.64 ns; ?=8.73 ns @ 10 trials
//19% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=CLONEABLE, right=OBJECT_ARRAY} 596.66 ns; ?=9.91 ns @ 10 trials
//20% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=CLONEABLE, right=OBJECT_ARRAY} 631.03 ns; ?=2.63 ns @ 3 trials
//20% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=INT, right=OBJECT_ARRAY} 3980.31 ns; ?=145.98 ns @ 10 trials
//21% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=INT, right=OBJECT_ARRAY} 11520.76 ns; ?=428.99 ns @ 10 trials
//22% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=INT, right=OBJECT_ARRAY} 9478.55 ns; ?=89.96 ns @ 4 trials
//22% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=RAW_COMPARABLE, right=OBJECT_ARRAY} 4446.99 ns; ?=171.35 ns @ 10 trials
//23% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_COMPARABLE, right=OBJECT_ARRAY} 5187.79 ns; ?=67.05 ns @ 10 trials
//24% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_COMPARABLE, right=OBJECT_ARRAY} 8922.23 ns; ?=711.17 ns @ 10 trials
//24% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=OBJECT_ARRAY} 6001.94 ns; ?=404.17 ns @ 10 trials
//25% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=OBJECT_ARRAY} 7327.93 ns; ?=67.45 ns @ 4 trials
//26% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=OBJECT_ARRAY} 8259.53 ns; ?=76.54 ns @ 4 trials
//27% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=RAW_ELIST_SUBTYPE, right=OBJECT_ARRAY} 11828.71 ns; ?=202.06 ns @ 10 trials
//27% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_ELIST_SUBTYPE, right=OBJECT_ARRAY} 14980.50 ns; ?=241.77 ns @ 10 trials
//28% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_ELIST_SUBTYPE, right=OBJECT_ARRAY} 8355.10 ns; ?=144.23 ns @ 10 trials
//29% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=OBJECT, right=CLONEABLE} 691.47 ns; ?=6.90 ns @ 8 trials
//29% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT, right=CLONEABLE} 575.04 ns; ?=6.41 ns @ 10 trials
//30% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT, right=CLONEABLE} 354.59 ns; ?=3.45 ns @ 10 trials
//31% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=OBJECT_ARRAY, right=CLONEABLE} 93.01 ns; ?=0.20 ns @ 3 trials
//31% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT_ARRAY, right=CLONEABLE} 4996.30 ns; ?=68.01 ns @ 10 trials
//32% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT_ARRAY, right=CLONEABLE} 1249.25 ns; ?=4.02 ns @ 3 trials
//33% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=CLONEABLE, right=CLONEABLE} 90.52 ns; ?=4.88 ns @ 10 trials
//33% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=CLONEABLE, right=CLONEABLE} 99.31 ns; ?=0.96 ns @ 8 trials
//34% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=CLONEABLE, right=CLONEABLE} 103.39 ns; ?=5.12 ns @ 10 trials
//35% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=INT, right=CLONEABLE} 607.21 ns; ?=4.31 ns @ 3 trials
//35% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=INT, right=CLONEABLE} 6771.32 ns; ?=26.77 ns @ 3 trials
//36% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=INT, right=CLONEABLE} 3714.81 ns; ?=34.77 ns @ 3 trials
//37% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=RAW_COMPARABLE, right=CLONEABLE} 1065.41 ns; ?=4.15 ns @ 3 trials
//37% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_COMPARABLE, right=CLONEABLE} 1088.93 ns; ?=4.46 ns @ 3 trials
//38% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_COMPARABLE, right=CLONEABLE} 1829.14 ns; ?=5.55 ns @ 3 trials
//39% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=CLONEABLE} 697.01 ns; ?=6.60 ns @ 6 trials
//39% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=CLONEABLE} 1028.39 ns; ?=7.24 ns @ 3 trials
//40% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=CLONEABLE} 1760.36 ns; ?=7.92 ns @ 3 trials
//41% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=RAW_ELIST_SUBTYPE, right=CLONEABLE} 955.14 ns; ?=53.01 ns @ 10 trials
//41% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_ELIST_SUBTYPE, right=CLONEABLE} 1736.19 ns; ?=29.62 ns @ 10 trials
//42% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_ELIST_SUBTYPE, right=CLONEABLE} 2518.66 ns; ?=39.57 ns @ 10 trials
//43% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=OBJECT, right=INT} 703.16 ns; ?=7.48 ns @ 10 trials
//44% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT, right=INT} 546.73 ns; ?=1.62 ns @ 3 trials
//44% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT, right=INT} 2916.80 ns; ?=50.26 ns @ 10 trials
//45% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=OBJECT_ARRAY, right=INT} 170.78 ns; ?=2.41 ns @ 10 trials
//46% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT_ARRAY, right=INT} 9588.85 ns; ?=194.66 ns @ 10 trials
//46% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT_ARRAY, right=INT} 971.50 ns; ?=4.23 ns @ 3 trials
//47% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=CLONEABLE, right=INT} 5632.07 ns; ?=123.22 ns @ 10 trials
//48% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=CLONEABLE, right=INT} 22023.40 ns; ?=448.29 ns @ 10 trials
//48% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=CLONEABLE, right=INT} 9661.56 ns; ?=133.66 ns @ 10 trials
//49% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=INT, right=INT} 180.03 ns; ?=0.17 ns @ 3 trials
//50% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=INT, right=INT} 202.13 ns; ?=0.78 ns @ 3 trials
//50% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=INT, right=INT} 82.79 ns; ?=0.35 ns @ 3 trials
//51% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=RAW_COMPARABLE, right=INT} 9396.02 ns; ?=88.88 ns @ 6 trials
//52% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_COMPARABLE, right=INT} 9429.52 ns; ?=346.34 ns @ 10 trials
//52% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_COMPARABLE, right=INT} 4994.60 ns; ?=90.32 ns @ 10 trials
//53% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=INT} 5814.61 ns; ?=140.30 ns @ 10 trials
//54% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=INT} 6836.98 ns; ?=126.66 ns @ 10 trials
//54% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=INT} 10017.19 ns; ?=399.18 ns @ 10 trials
//55% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=RAW_ELIST_SUBTYPE, right=INT} 7028.38 ns; ?=118.69 ns @ 10 trials
//56% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_ELIST_SUBTYPE, right=INT} 8710.08 ns; ?=172.55 ns @ 10 trials
//56% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_ELIST_SUBTYPE, right=INT} 12017.02 ns; ?=114.17 ns @ 3 trials
//57% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=OBJECT, right=RAW_COMPARABLE} 994.25 ns; ?=4.55 ns @ 3 trials
//58% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT, right=RAW_COMPARABLE} 582.43 ns; ?=1.41 ns @ 3 trials
//59% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT, right=RAW_COMPARABLE} 361.59 ns; ?=7.02 ns @ 10 trials
//59% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=OBJECT_ARRAY, right=RAW_COMPARABLE} 436.30 ns; ?=4.37 ns @ 8 trials
//60% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT_ARRAY, right=RAW_COMPARABLE} 5082.21 ns; ?=95.07 ns @ 10 trials
//61% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT_ARRAY, right=RAW_COMPARABLE} 1312.70 ns; ?=12.98 ns @ 9 trials
//61% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=CLONEABLE, right=RAW_COMPARABLE} 1123.12 ns; ?=10.10 ns @ 3 trials
//62% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=CLONEABLE, right=RAW_COMPARABLE} 5964.66 ns; ?=99.43 ns @ 10 trials
//63% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=CLONEABLE, right=RAW_COMPARABLE} 1996.84 ns; ?=59.47 ns @ 10 trials
//63% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=INT, right=RAW_COMPARABLE} 956.90 ns; ?=11.73 ns @ 10 trials
//64% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=INT, right=RAW_COMPARABLE} 6791.29 ns; ?=164.42 ns @ 10 trials
//65% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=INT, right=RAW_COMPARABLE} 3700.56 ns; ?=36.42 ns @ 10 trials
//65% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=RAW_COMPARABLE, right=RAW_COMPARABLE} 289.27 ns; ?=9.62 ns @ 10 trials
//66% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_COMPARABLE, right=RAW_COMPARABLE} 78.07 ns; ?=2.71 ns @ 10 trials
//67% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_COMPARABLE, right=RAW_COMPARABLE} 96.72 ns; ?=0.51 ns @ 3 trials
//67% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=RAW_COMPARABLE} 1002.74 ns; ?=10.20 ns @ 10 trials
//68% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=RAW_COMPARABLE} 1061.40 ns; ?=1.82 ns @ 3 trials
//69% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=RAW_COMPARABLE} 1870.11 ns; ?=16.28 ns @ 3 trials
//69% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=RAW_ELIST_SUBTYPE, right=RAW_COMPARABLE} 918.99 ns; ?=18.79 ns @ 10 trials
//70% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_ELIST_SUBTYPE, right=RAW_COMPARABLE} 1776.24 ns; ?=70.20 ns @ 10 trials
//71% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_ELIST_SUBTYPE, right=RAW_COMPARABLE} 2719.20 ns; ?=70.24 ns @ 10 trials
//71% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=OBJECT, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 720.25 ns; ?=4.06 ns @ 3 trials
//72% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 581.59 ns; ?=4.91 ns @ 4 trials
//73% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 355.49 ns; ?=3.25 ns @ 6 trials
//73% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=OBJECT_ARRAY, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 93.60 ns; ?=2.08 ns @ 10 trials
//74% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT_ARRAY, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 6291.90 ns; ?=129.49 ns @ 10 trials
//75% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT_ARRAY, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 6123.83 ns; ?=38.46 ns @ 3 trials
//76% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=CLONEABLE, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 1777.40 ns; ?=16.99 ns @ 3 trials
//76% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=CLONEABLE, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 8226.96 ns; ?=198.40 ns @ 10 trials
//77% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=CLONEABLE, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 9213.06 ns; ?=11.69 ns @ 3 trials
//78% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=INT, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 634.24 ns; ?=6.07 ns @ 7 trials
//78% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=INT, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 7578.47 ns; ?=135.79 ns @ 10 trials
//79% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=INT, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 43125.00 ns; ?=76386513.96 ns @ 10 trials
//80% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=RAW_COMPARABLE, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 2008.61 ns; ?=18.62 ns @ 6 trials
//80% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_COMPARABLE, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 2083.44 ns; ?=19.34 ns @ 7 trials
//81% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_COMPARABLE, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 9297.88 ns; ?=76.86 ns @ 3 trials
//82% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 89.37 ns; ?=1.27 ns @ 10 trials
//82% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 94.21 ns; ?=1.36 ns @ 10 trials
//83% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 91.47 ns; ?=0.86 ns @ 4 trials
//84% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=RAW_ELIST_SUBTYPE, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 2438.49 ns; ?=10.18 ns @ 3 trials
//84% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_ELIST_SUBTYPE, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 2542.76 ns; ?=5.73 ns @ 3 trials
//85% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_ELIST_SUBTYPE, right=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 9868.84 ns; ?=175.00 ns @ 10 trials
//86% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=OBJECT, right=RAW_ELIST_SUBTYPE} 978.14 ns; ?=0.66 ns @ 3 trials
//86% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT, right=RAW_ELIST_SUBTYPE} 588.88 ns; ?=2.03 ns @ 3 trials
//87% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT, right=RAW_ELIST_SUBTYPE} 339.62 ns; ?=2.38 ns @ 3 trials
//88% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=OBJECT_ARRAY, right=RAW_ELIST_SUBTYPE} 433.32 ns; ?=0.85 ns @ 3 trials
//88% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=OBJECT_ARRAY, right=RAW_ELIST_SUBTYPE} 11205.72 ns; ?=24.93 ns @ 3 trials
//89% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=OBJECT_ARRAY, right=RAW_ELIST_SUBTYPE} 13402.67 ns; ?=9.10 ns @ 3 trials
//90% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=CLONEABLE, right=RAW_ELIST_SUBTYPE} 2118.68 ns; ?=13.69 ns @ 3 trials
//90% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=CLONEABLE, right=RAW_ELIST_SUBTYPE} 1818.52 ns; ?=16.61 ns @ 3 trials
//91% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=CLONEABLE, right=RAW_ELIST_SUBTYPE} 2809.93 ns; ?=16.69 ns @ 3 trials
//92% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=INT, right=RAW_ELIST_SUBTYPE} 1042.43 ns; ?=3.19 ns @ 3 trials
//93% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=INT, right=RAW_ELIST_SUBTYPE} 8291.04 ns; ?=76.04 ns @ 4 trials
//93% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=INT, right=RAW_ELIST_SUBTYPE} 16521.48 ns; ?=15.00 ns @ 3 trials
//94% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=RAW_COMPARABLE, right=RAW_ELIST_SUBTYPE} 3046.23 ns; ?=12.70 ns @ 3 trials
//95% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_COMPARABLE, right=RAW_ELIST_SUBTYPE} 3240.90 ns; ?=24.66 ns @ 3 trials
//95% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_COMPARABLE, right=RAW_ELIST_SUBTYPE} 17554.54 ns; ?=216.45 ns @ 10 trials
//96% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=RAW_ELIST_SUBTYPE} 2712.99 ns; ?=15.92 ns @ 3 trials
//97% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=RAW_ELIST_SUBTYPE} 2713.24 ns; ?=10.83 ns @ 3 trials
//97% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=RAW_ELIST_SUBTYPE} 17323.34 ns; ?=38.41 ns @ 3 trials
//98% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=New, left=RAW_ELIST_SUBTYPE, right=RAW_ELIST_SUBTYPE} 286.07 ns; ?=2.32 ns @ 3 trials
//99% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Old, left=RAW_ELIST_SUBTYPE, right=RAW_ELIST_SUBTYPE} 73.93 ns; ?=1.51 ns @ 10 trials
//99% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=Deprecated, left=RAW_ELIST_SUBTYPE, right=RAW_ELIST_SUBTYPE} 95.32 ns; ?=0.24 ns @ 3 trials
//
//implementation                            right                             left      ns linear runtime
//          New                           OBJECT                           OBJECT    90.3 =
//          New                           OBJECT                     OBJECT_ARRAY    93.3 =
//          New                           OBJECT                        CLONEABLE   756.8 =
//          New                           OBJECT                              INT   603.6 =
//          New                           OBJECT                   RAW_COMPARABLE  1015.0 =
//          New                           OBJECT XMEMBER_FEATURE_CALL_IMPL_CUSTOM   768.4 =
//          New                           OBJECT                RAW_ELIST_SUBTYPE  1723.6 =
//          New                     OBJECT_ARRAY                           OBJECT   271.4 =
//          New                     OBJECT_ARRAY                     OBJECT_ARRAY   189.8 =
//          New                     OBJECT_ARRAY                        CLONEABLE   640.6 =
//          New                     OBJECT_ARRAY                              INT  3980.3 ==
//          New                     OBJECT_ARRAY                   RAW_COMPARABLE  4447.0 ===
//          New                     OBJECT_ARRAY XMEMBER_FEATURE_CALL_IMPL_CUSTOM  6001.9 ====
//          New                     OBJECT_ARRAY                RAW_ELIST_SUBTYPE 11828.7 ========
//          New                        CLONEABLE                           OBJECT   691.5 =
//          New                        CLONEABLE                     OBJECT_ARRAY    93.0 =
//          New                        CLONEABLE                        CLONEABLE    90.5 =
//          New                        CLONEABLE                              INT   607.2 =
//          New                        CLONEABLE                   RAW_COMPARABLE  1065.4 =
//          New                        CLONEABLE XMEMBER_FEATURE_CALL_IMPL_CUSTOM   697.0 =
//          New                        CLONEABLE                RAW_ELIST_SUBTYPE   955.1 =
//          New                              INT                           OBJECT   703.2 =
//          New                              INT                     OBJECT_ARRAY   170.8 =
//          New                              INT                        CLONEABLE  5632.1 ===
//          New                              INT                              INT   180.0 =
//          New                              INT                   RAW_COMPARABLE  9396.0 ======
//          New                              INT XMEMBER_FEATURE_CALL_IMPL_CUSTOM  5814.6 ====
//          New                              INT                RAW_ELIST_SUBTYPE  7028.4 ====
//          New                   RAW_COMPARABLE                           OBJECT   994.2 =
//          New                   RAW_COMPARABLE                     OBJECT_ARRAY   436.3 =
//          New                   RAW_COMPARABLE                        CLONEABLE  1123.1 =
//          New                   RAW_COMPARABLE                              INT   956.9 =
//          New                   RAW_COMPARABLE                   RAW_COMPARABLE   289.3 =
//          New                   RAW_COMPARABLE XMEMBER_FEATURE_CALL_IMPL_CUSTOM  1002.7 =
//          New                   RAW_COMPARABLE                RAW_ELIST_SUBTYPE   919.0 =
//          New XMEMBER_FEATURE_CALL_IMPL_CUSTOM                           OBJECT   720.2 =
//          New XMEMBER_FEATURE_CALL_IMPL_CUSTOM                     OBJECT_ARRAY    93.6 =
//          New XMEMBER_FEATURE_CALL_IMPL_CUSTOM                        CLONEABLE  1777.4 =
//          New XMEMBER_FEATURE_CALL_IMPL_CUSTOM                              INT   634.2 =
//          New XMEMBER_FEATURE_CALL_IMPL_CUSTOM                   RAW_COMPARABLE  2008.6 =
//          New XMEMBER_FEATURE_CALL_IMPL_CUSTOM XMEMBER_FEATURE_CALL_IMPL_CUSTOM    89.4 =
//          New XMEMBER_FEATURE_CALL_IMPL_CUSTOM                RAW_ELIST_SUBTYPE  2438.5 =
//          New                RAW_ELIST_SUBTYPE                           OBJECT   978.1 =
//          New                RAW_ELIST_SUBTYPE                     OBJECT_ARRAY   433.3 =
//          New                RAW_ELIST_SUBTYPE                        CLONEABLE  2118.7 =
//          New                RAW_ELIST_SUBTYPE                              INT  1042.4 =
//          New                RAW_ELIST_SUBTYPE                   RAW_COMPARABLE  3046.2 ==
//          New                RAW_ELIST_SUBTYPE XMEMBER_FEATURE_CALL_IMPL_CUSTOM  2713.0 =
//          New                RAW_ELIST_SUBTYPE                RAW_ELIST_SUBTYPE   286.1 =
//          Old                           OBJECT                           OBJECT    93.6 =
//          Old                           OBJECT                     OBJECT_ARRAY  3605.1 ==
//          Old                           OBJECT                        CLONEABLE  5596.6 ===
//          Old                           OBJECT                              INT  6617.2 ====
//          Old                           OBJECT                   RAW_COMPARABLE  1038.5 =
//          Old                           OBJECT XMEMBER_FEATURE_CALL_IMPL_CUSTOM  1064.2 =
//          Old                           OBJECT                RAW_ELIST_SUBTYPE  1795.3 =
//          Old                     OBJECT_ARRAY                           OBJECT   214.2 =
//          Old                     OBJECT_ARRAY                     OBJECT_ARRAY   118.1 =
//          Old                     OBJECT_ARRAY                        CLONEABLE   596.7 =
//          Old                     OBJECT_ARRAY                              INT 11520.8 ========
//          Old                     OBJECT_ARRAY                   RAW_COMPARABLE  5187.8 ===
//          Old                     OBJECT_ARRAY XMEMBER_FEATURE_CALL_IMPL_CUSTOM  7327.9 =====
//          Old                     OBJECT_ARRAY                RAW_ELIST_SUBTYPE 14980.5 ==========
//          Old                        CLONEABLE                           OBJECT   575.0 =
//          Old                        CLONEABLE                     OBJECT_ARRAY  4996.3 ===
//          Old                        CLONEABLE                        CLONEABLE    99.3 =
//          Old                        CLONEABLE                              INT  6771.3 ====
//          Old                        CLONEABLE                   RAW_COMPARABLE  1088.9 =
//          Old                        CLONEABLE XMEMBER_FEATURE_CALL_IMPL_CUSTOM  1028.4 =
//          Old                        CLONEABLE                RAW_ELIST_SUBTYPE  1736.2 =
//          Old                              INT                           OBJECT   546.7 =
//          Old                              INT                     OBJECT_ARRAY  9588.9 ======
//          Old                              INT                        CLONEABLE 22023.4 ===============
//          Old                              INT                              INT   202.1 =
//          Old                              INT                   RAW_COMPARABLE  9429.5 ======
//          Old                              INT XMEMBER_FEATURE_CALL_IMPL_CUSTOM  6837.0 ====
//          Old                              INT                RAW_ELIST_SUBTYPE  8710.1 ======
//          Old                   RAW_COMPARABLE                           OBJECT   582.4 =
//          Old                   RAW_COMPARABLE                     OBJECT_ARRAY  5082.2 ===
//          Old                   RAW_COMPARABLE                        CLONEABLE  5964.7 ====
//          Old                   RAW_COMPARABLE                              INT  6791.3 ====
//          Old                   RAW_COMPARABLE                   RAW_COMPARABLE    78.1 =
//          Old                   RAW_COMPARABLE XMEMBER_FEATURE_CALL_IMPL_CUSTOM  1061.4 =
//          Old                   RAW_COMPARABLE                RAW_ELIST_SUBTYPE  1776.2 =
//          Old XMEMBER_FEATURE_CALL_IMPL_CUSTOM                           OBJECT   581.6 =
//          Old XMEMBER_FEATURE_CALL_IMPL_CUSTOM                     OBJECT_ARRAY  6291.9 ====
//          Old XMEMBER_FEATURE_CALL_IMPL_CUSTOM                        CLONEABLE  8227.0 =====
//          Old XMEMBER_FEATURE_CALL_IMPL_CUSTOM                              INT  7578.5 =====
//          Old XMEMBER_FEATURE_CALL_IMPL_CUSTOM                   RAW_COMPARABLE  2083.4 =
//          Old XMEMBER_FEATURE_CALL_IMPL_CUSTOM XMEMBER_FEATURE_CALL_IMPL_CUSTOM    94.2 =
//          Old XMEMBER_FEATURE_CALL_IMPL_CUSTOM                RAW_ELIST_SUBTYPE  2542.8 =
//          Old                RAW_ELIST_SUBTYPE                           OBJECT   588.9 =
//          Old                RAW_ELIST_SUBTYPE                     OBJECT_ARRAY 11205.7 =======
//          Old                RAW_ELIST_SUBTYPE                        CLONEABLE  1818.5 =
//          Old                RAW_ELIST_SUBTYPE                              INT  8291.0 =====
//          Old                RAW_ELIST_SUBTYPE                   RAW_COMPARABLE  3240.9 ==
//          Old                RAW_ELIST_SUBTYPE XMEMBER_FEATURE_CALL_IMPL_CUSTOM  2713.2 =
//          Old                RAW_ELIST_SUBTYPE                RAW_ELIST_SUBTYPE    73.9 =
//   Deprecated                           OBJECT                           OBJECT    95.7 =
//   Deprecated                           OBJECT                     OBJECT_ARRAY   927.9 =
//   Deprecated                           OBJECT                        CLONEABLE  1422.4 =
//   Deprecated                           OBJECT                              INT  3358.9 ==
//   Deprecated                           OBJECT                   RAW_COMPARABLE  1597.4 =
//   Deprecated                           OBJECT XMEMBER_FEATURE_CALL_IMPL_CUSTOM  1470.3 =
//   Deprecated                           OBJECT                RAW_ELIST_SUBTYPE  2199.3 =
//   Deprecated                     OBJECT_ARRAY                           OBJECT   246.4 =
//   Deprecated                     OBJECT_ARRAY                     OBJECT_ARRAY   110.5 =
//   Deprecated                     OBJECT_ARRAY                        CLONEABLE   631.0 =
//   Deprecated                     OBJECT_ARRAY                              INT  9478.5 ======
//   Deprecated                     OBJECT_ARRAY                   RAW_COMPARABLE  8922.2 ======
//   Deprecated                     OBJECT_ARRAY XMEMBER_FEATURE_CALL_IMPL_CUSTOM  8259.5 =====
//   Deprecated                     OBJECT_ARRAY                RAW_ELIST_SUBTYPE  8355.1 =====
//   Deprecated                        CLONEABLE                           OBJECT   354.6 =
//   Deprecated                        CLONEABLE                     OBJECT_ARRAY  1249.3 =
//   Deprecated                        CLONEABLE                        CLONEABLE   103.4 =
//   Deprecated                        CLONEABLE                              INT  3714.8 ==
//   Deprecated                        CLONEABLE                   RAW_COMPARABLE  1829.1 =
//   Deprecated                        CLONEABLE XMEMBER_FEATURE_CALL_IMPL_CUSTOM  1760.4 =
//   Deprecated                        CLONEABLE                RAW_ELIST_SUBTYPE  2518.7 =
//   Deprecated                              INT                           OBJECT  2916.8 ==
//   Deprecated                              INT                     OBJECT_ARRAY   971.5 =
//   Deprecated                              INT                        CLONEABLE  9661.6 ======
//   Deprecated                              INT                              INT    82.8 =
//   Deprecated                              INT                   RAW_COMPARABLE  4994.6 ===
//   Deprecated                              INT XMEMBER_FEATURE_CALL_IMPL_CUSTOM 10017.2 ======
//   Deprecated                              INT                RAW_ELIST_SUBTYPE 12017.0 ========
//   Deprecated                   RAW_COMPARABLE                           OBJECT   361.6 =
//   Deprecated                   RAW_COMPARABLE                     OBJECT_ARRAY  1312.7 =
//   Deprecated                   RAW_COMPARABLE                        CLONEABLE  1996.8 =
//   Deprecated                   RAW_COMPARABLE                              INT  3700.6 ==
//   Deprecated                   RAW_COMPARABLE                   RAW_COMPARABLE    96.7 =
//   Deprecated                   RAW_COMPARABLE XMEMBER_FEATURE_CALL_IMPL_CUSTOM  1870.1 =
//   Deprecated                   RAW_COMPARABLE                RAW_ELIST_SUBTYPE  2719.2 =
//   Deprecated XMEMBER_FEATURE_CALL_IMPL_CUSTOM                           OBJECT   355.5 =
//   Deprecated XMEMBER_FEATURE_CALL_IMPL_CUSTOM                     OBJECT_ARRAY  6123.8 ====
//   Deprecated XMEMBER_FEATURE_CALL_IMPL_CUSTOM                        CLONEABLE  9213.1 ======
//   Deprecated XMEMBER_FEATURE_CALL_IMPL_CUSTOM                              INT 43125.0 ==============================
//   Deprecated XMEMBER_FEATURE_CALL_IMPL_CUSTOM                   RAW_COMPARABLE  9297.9 ======
//   Deprecated XMEMBER_FEATURE_CALL_IMPL_CUSTOM XMEMBER_FEATURE_CALL_IMPL_CUSTOM    91.5 =
//   Deprecated XMEMBER_FEATURE_CALL_IMPL_CUSTOM                RAW_ELIST_SUBTYPE  9868.8 ======
//   Deprecated                RAW_ELIST_SUBTYPE                           OBJECT   339.6 =
//   Deprecated                RAW_ELIST_SUBTYPE                     OBJECT_ARRAY 13402.7 =========
//   Deprecated                RAW_ELIST_SUBTYPE                        CLONEABLE  2809.9 =
//   Deprecated                RAW_ELIST_SUBTYPE                              INT 16521.5 ===========
//   Deprecated                RAW_ELIST_SUBTYPE                   RAW_COMPARABLE 17554.5 ============
//   Deprecated                RAW_ELIST_SUBTYPE XMEMBER_FEATURE_CALL_IMPL_CUSTOM 17323.3 ============
//   Deprecated                RAW_ELIST_SUBTYPE                RAW_ELIST_SUBTYPE    95.3 =

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AssignabilityBenchmark extends TypeBasedSimpleBenchmark {
	
	public enum Impl {
		
//		 0% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=RAW_MAP, right=RAW_MAP} 12.42 ns; ?=0.12 ns @ 7 trials
//		 0% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=OBJECT_ARRAY, right=RAW_MAP} 14.01 ns; ?=0.06 ns @ 3 trials
//		 1% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=RAW_ELIST_SUBTYPE, right=RAW_MAP} 22.99 ns; ?=0.85 ns @ 10 trials
//		 1% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=CLONEABLE, right=RAW_MAP} 74.58 ns; ?=1.11 ns @ 10 trials
//		 2% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=INT, right=RAW_MAP} 49.21 ns; ?=0.04 ns @ 3 trials
//		 2% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=STRING, right=RAW_MAP} 31.25 ns; ?=0.27 ns @ 3 trials
//		 3% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=DOUBLE, right=RAW_MAP} 50.82 ns; ?=1.66 ns @ 10 trials
//		 3% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=INT_ARRAY, right=RAW_MAP} 21.49 ns; ?=0.45 ns @ 10 trials
//		 4% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=INT_ARRAY_ARRAY_ARRAY, right=RAW_MAP} 32.55 ns; ?=1.14 ns @ 10 trials
//		 4% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=RAW_COMPARABLE, right=RAW_MAP} 73.53 ns; ?=6.18 ns @ 10 trials
//		 4% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=RAW_ITERABLE, right=RAW_MAP} 69.47 ns; ?=0.67 ns @ 7 trials
//		 5% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=RAW_ARRAYLIST, right=RAW_MAP} 24.12 ns; ?=0.24 ns @ 6 trials
//		 5% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=RAW_MAP} 26.00 ns; ?=0.25 ns @ 5 trials
//		 6% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=ELIST_SUBTYPE, right=RAW_MAP} 210.50 ns; ?=2.70 ns @ 10 trials
//		 6% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=OBJECT, right=RAW_MAP} 23.05 ns; ?=0.39 ns @ 10 trials
//		 7% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=RAW_MAP, right=OBJECT_ARRAY} 59.97 ns; ?=0.29 ns @ 3 trials
//		 7% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=OBJECT_ARRAY, right=OBJECT_ARRAY} 32.55 ns; ?=0.62 ns @ 10 trials
//		 8% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=RAW_ELIST_SUBTYPE, right=OBJECT_ARRAY} 6621.51 ns; ?=30.20 ns @ 3 trials
//		 8% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=CLONEABLE, right=OBJECT_ARRAY} 19.53 ns; ?=0.62 ns @ 10 trials
//		 8% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=INT, right=OBJECT_ARRAY} 27.56 ns; ?=0.77 ns @ 10 trials
//		 9% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=STRING, right=OBJECT_ARRAY} 224.40 ns; ?=3.23 ns @ 10 trials
//		 9% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=DOUBLE, right=OBJECT_ARRAY} 28.62 ns; ?=1.14 ns @ 10 trials
//		10% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=INT_ARRAY, right=OBJECT_ARRAY} 2448.43 ns; ?=83.73 ns @ 10 trials
//		10% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=INT_ARRAY_ARRAY_ARRAY, right=OBJECT_ARRAY} 43.58 ns; ?=1.25 ns @ 10 trials
//		11% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=RAW_COMPARABLE, right=OBJECT_ARRAY} 79.90 ns; ?=3.42 ns @ 10 trials
//		11% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=RAW_ITERABLE, right=OBJECT_ARRAY} 10328.39 ns; ?=253.53 ns @ 10 trials
//		12% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=RAW_ARRAYLIST, right=OBJECT_ARRAY} 7521.86 ns; ?=245.27 ns @ 10 trials
//		12% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=XMEMBER_FEATURE_CALL_IMPL_CUSTOM, right=OBJECT_ARRAY} 818.50 ns; ?=29.38 ns @ 10 trials
//		12% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=ELIST_SUBTYPE, right=OBJECT_ARRAY} 24293.14 ns; ?=1810.12 ns @ 10 trials
//		13% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=OBJECT, right=OBJECT_ARRAY} 14.95 ns; ?=1.44 ns @ 10 trials
//		13% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=RAW_MAP, right=RAW_ELIST_SUBTYPE} 476.81 ns; ?=4.47 ns @ 6 trials
//		14% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=OBJECT_ARRAY, right=RAW_ELIST_SUBTYPE} 14.50 ns; ?=0.21 ns @ 10 trials
//		14% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=RAW_ELIST_SUBTYPE, right=RAW_ELIST_SUBTYPE} 13.27 ns; ?=0.08 ns @ 3 trials
//		15% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=CLONEABLE, right=RAW_ELIST_SUBTYPE} 605.24 ns; ?=10.46 ns @ 10 trials
//		15% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=INT, right=RAW_ELIST_SUBTYPE} 45.27 ns; ?=0.53 ns @ 10 trials
//		16% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=STRING, right=RAW_ELIST_SUBTYPE} 29.15 ns; ?=0.39 ns @ 10 trials
//		16% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=DOUBLE, right=RAW_ELIST_SUBTYPE} 51.19 ns; ?=0.32 ns @ 3 trials
//		16% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=INT_ARRAY, right=RAW_ELIST_SUBTYPE} 20.75 ns; ?=0.18 ns @ 5 trials
//		17% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=INT_ARRAY_ARRAY_ARRAY, right=RAW_ELIST_SUBTYPE} 30.67 ns; ?=0.45 ns @ 10 trials
//		17% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=RAW_COMPARABLE, right=RAW_ELIST_SUBTYPE} 483.68 ns; ?=88.38 ns @ 10 trials
//		18% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=RAW_ITERABLE, right=RAW_ELIST_SUBTYPE} 603.64 ns; ?=71.13 ns @ 10 trials
//		18% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=REWRITTEN, left=RAW_ARRAYLIST, right=RAW_ELIST_SUBTYPE}
		
		REWRITTEN {
			@Override
			boolean isAssignable(AssignabilityBenchmark benchmark) {
				return benchmark.newConformanceComputer.isConformant(benchmark.leftReference, benchmark.rightReference);
			}
		},
		
//		 0% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=CURRENT, left=RAW_MAP, right=RAW_MAP} 86.15 ns; ?=0.31 ns @ 3 trials
//		 0% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=CURRENT, left=RAW_ELIST_SUBTYPE, right=RAW_MAP} 92.91 ns; ?=0.93 ns @ 4 trials
//		 1% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=CURRENT, left=OBJECT_ARRAY, right=RAW_MAP} 126.56 ns; ?=1.20 ns @ 3 trials
//		 1% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=CURRENT, left=CLONEABLE, right=RAW_MAP} 162.27 ns; ?=2.71 ns @ 10 trials
//		 2% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=CURRENT, left=INT, right=RAW_MAP} 2068.72 ns; ?=36.83 ns @ 10 trials
//		 2% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=CURRENT, left=STRING, right=RAW_MAP} 81.12 ns; ?=1.93 ns @ 10 trials
//		 3% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=CURRENT, left=DOUBLE, right=RAW_MAP} 2221.46 ns; ?=59.96 ns @ 10 trials
//		 3% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=CURRENT, left=INT_ARRAY, right=RAW_MAP} 108.93 ns; ?=2.25 ns @ 10 trials
//		 4% Scenario{vm=java7, trial=0, benchmark=IsAssignable, implementation=CURRENT, left=INT_ARRAY_ARRAY_ARRAY, right=RAW_MAP} 128.57 ns; ?=2.35 ns @ 10 trials
		
//		CURRENT {
//			@Override
//			boolean isAssignable(AssignabilityBenchmark benchmark) {
//				return benchmark.leftReference.isAssignableFrom(benchmark.rightReference);
//			}
//		},
		;
		abstract boolean isAssignable(AssignabilityBenchmark benchmark);
	}
	
	
	
	@Param
	Impl implementation;

	@Param
	Type right;
	
	@Param
	Type left;
	
	private LightweightTypeReference leftReference;
	private LightweightTypeReference rightReference;

	private TypeConformanceComputer newConformanceComputer;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		leftReference = getTypeReference(left);
		rightReference = getTypeReference(right);
		newConformanceComputer = new TypeConformanceComputer();
	}

	public int timeIsAssignable(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.isAssignable(this)) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Runner.main(AssignabilityBenchmark.class, args);
	}
	
}