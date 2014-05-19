/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.typesystem;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;

import com.google.caliper.Param;
import com.google.caliper.Runner;

/*

// Starting Point

 0% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=BASELINE, type=CLONEABLE} 100.16 ns; ?=1.88 ns @ 10 trials
 0% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=BASELINE, type=CLONEABLE} 1733.62 ns; ?=51.01 ns @ 10 trials
 1% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=BASELINE, type=CLONEABLE} 2244.34 ns; ?=18.45 ns @ 3 trials
 1% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=BASELINE, type=CLONEABLE} 54.75 ns; ?=0.33 ns @ 3 trials
 2% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=BASELINE, type=CLONEABLE} 1791.78 ns; ?=40.14 ns @ 10 trials
 2% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=BASELINE, type=CLONEABLE} 55.33 ns; ?=0.22 ns @ 3 trials
 3% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=BASELINE, type=CLONEABLE} 1810.10 ns; ?=53.44 ns @ 10 trials
 3% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=BASELINE, type=CLONEABLE} 104.84 ns; ?=1.52 ns @ 10 trials
 3% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=BASELINE, type=CLONEABLE} 2008.44 ns; ?=42.82 ns @ 10 trials
 4% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=BASELINE, type=CLONEABLE} 101.29 ns; ?=2.39 ns @ 10 trials
 4% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=BASELINE, type=CLONEABLE} 1701.28 ns; ?=25.64 ns @ 10 trials
 5% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=BASELINE, type=CLONEABLE} 101.19 ns; ?=0.40 ns @ 3 trials
 5% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=BASELINE, type=CLONEABLE} 1858.29 ns; ?=18.55 ns @ 9 trials
 5% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=BASELINE, type=CLONEABLE} 54.72 ns; ?=0.14 ns @ 3 trials
 6% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=BASELINE, type=CLONEABLE} 1703.16 ns; ?=54.86 ns @ 10 trials
 6% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=BASELINE, type=CLONEABLE} 133.26 ns; ?=0.73 ns @ 3 trials
 7% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=BASELINE, type=DOUBLE} 148.83 ns; ?=1.09 ns @ 3 trials
 7% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=BASELINE, type=DOUBLE} 2004.21 ns; ?=23.61 ns @ 10 trials
 8% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=BASELINE, type=DOUBLE} 2086.67 ns; ?=33.51 ns @ 10 trials
 8% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=BASELINE, type=DOUBLE} 149.07 ns; ?=0.41 ns @ 3 trials
 8% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=BASELINE, type=DOUBLE} 2280.95 ns; ?=11.79 ns @ 3 trials
 9% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=BASELINE, type=DOUBLE} 146.86 ns; ?=0.70 ns @ 3 trials
 9% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=BASELINE, type=DOUBLE} 1780.30 ns; ?=46.04 ns @ 10 trials
10% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=BASELINE, type=DOUBLE} 147.37 ns; ?=0.76 ns @ 3 trials
10% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=BASELINE, type=DOUBLE} 1949.70 ns; ?=18.72 ns @ 3 trials
10% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=BASELINE, type=DOUBLE} 147.72 ns; ?=0.45 ns @ 3 trials
11% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=BASELINE, type=DOUBLE} 1935.15 ns; ?=26.41 ns @ 10 trials
11% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=BASELINE, type=DOUBLE} 149.07 ns; ?=0.62 ns @ 3 trials
12% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=BASELINE, type=DOUBLE} 2222.03 ns; ?=11.61 ns @ 3 trials
12% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=BASELINE, type=DOUBLE} 147.44 ns; ?=0.40 ns @ 3 trials
13% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=BASELINE, type=DOUBLE} 1910.26 ns; ?=39.75 ns @ 10 trials
13% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=BASELINE, type=DOUBLE} 148.63 ns; ?=0.70 ns @ 3 trials
13% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=BASELINE, type=ELIST_SUBTYPE} 11352.72 ns; ?=33.14 ns @ 3 trials
14% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=BASELINE, type=ELIST_SUBTYPE} 16799.73 ns; ?=313.58 ns @ 10 trials
14% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=BASELINE, type=ELIST_SUBTYPE} 16270.09 ns; ?=58.71 ns @ 3 trials
15% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=BASELINE, type=ELIST_SUBTYPE} 11385.93 ns; ?=142.53 ns @ 10 trials
15% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=BASELINE, type=ELIST_SUBTYPE} 16252.34 ns; ?=73.00 ns @ 3 trials
15% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=BASELINE, type=ELIST_SUBTYPE} 11120.97 ns; ?=89.10 ns @ 3 trials
16% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=BASELINE, type=ELIST_SUBTYPE} 16291.84 ns; ?=94.78 ns @ 3 trials
16% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=BASELINE, type=ELIST_SUBTYPE} 11198.26 ns; ?=67.90 ns @ 3 trials
17% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=BASELINE, type=ELIST_SUBTYPE} 16585.77 ns; ?=85.94 ns @ 3 trials
17% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=BASELINE, type=ELIST_SUBTYPE} 11153.94 ns; ?=70.86 ns @ 3 trials
18% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=BASELINE, type=ELIST_SUBTYPE} 4672.79 ns; ?=75.52 ns @ 10 trials
18% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=BASELINE, type=ELIST_SUBTYPE} 1460.82 ns; ?=3.43 ns @ 3 trials
18% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=BASELINE, type=ELIST_SUBTYPE} 3684.07 ns; ?=44.29 ns @ 10 trials
19% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=BASELINE, type=ELIST_SUBTYPE} 1082.98 ns; ?=7.16 ns @ 3 trials
19% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=BASELINE, type=ELIST_SUBTYPE} 1805.00 ns; ?=16.13 ns @ 3 trials
20% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=BASELINE, type=ELIST_SUBTYPE} 131.89 ns; ?=1.39 ns @ 10 trials
20% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=BASELINE, type=INT} 147.77 ns; ?=0.31 ns @ 3 trials
20% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=BASELINE, type=INT} 1739.09 ns; ?=34.92 ns @ 10 trials
21% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=BASELINE, type=INT} 1863.43 ns; ?=34.20 ns @ 10 trials
21% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=BASELINE, type=INT} 147.20 ns; ?=1.24 ns @ 3 trials
22% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=BASELINE, type=INT} 2273.19 ns; ?=39.87 ns @ 10 trials
22% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=BASELINE, type=INT} 148.29 ns; ?=0.11 ns @ 3 trials
23% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=BASELINE, type=INT} 2287.77 ns; ?=21.55 ns @ 3 trials
23% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=BASELINE, type=INT} 146.97 ns; ?=0.69 ns @ 3 trials
23% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=BASELINE, type=INT} 1877.08 ns; ?=38.60 ns @ 10 trials
24% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=BASELINE, type=INT} 147.10 ns; ?=1.15 ns @ 3 trials
24% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=BASELINE, type=INT} 2186.44 ns; ?=12.89 ns @ 3 trials
25% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=BASELINE, type=INT} 146.04 ns; ?=0.58 ns @ 3 trials
25% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=BASELINE, type=INT} 1915.60 ns; ?=48.52 ns @ 10 trials
25% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=BASELINE, type=INT} 147.72 ns; ?=1.12 ns @ 3 trials
26% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=BASELINE, type=INT} 1821.85 ns; ?=90.62 ns @ 10 trials
26% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=BASELINE, type=INT} 145.45 ns; ?=0.25 ns @ 3 trials
27% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=BASELINE, type=INT_ARRAY} 565.27 ns; ?=1.17 ns @ 3 trials
27% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=BASELINE, type=INT_ARRAY} 2224.67 ns; ?=14.31 ns @ 3 trials
28% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=BASELINE, type=INT_ARRAY} 2348.20 ns; ?=11.88 ns @ 3 trials
28% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=BASELINE, type=INT_ARRAY} 571.17 ns; ?=2.25 ns @ 3 trials
28% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=BASELINE, type=INT_ARRAY} 2269.76 ns; ?=10.45 ns @ 3 trials
29% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=BASELINE, type=INT_ARRAY} 564.83 ns; ?=1.06 ns @ 3 trials
29% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=BASELINE, type=INT_ARRAY} 2282.14 ns; ?=9.19 ns @ 3 trials
30% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=BASELINE, type=INT_ARRAY} 564.07 ns; ?=5.48 ns @ 9 trials
30% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=BASELINE, type=INT_ARRAY} 2349.64 ns; ?=22.53 ns @ 5 trials
30% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=BASELINE, type=INT_ARRAY} 565.63 ns; ?=3.85 ns @ 3 trials
31% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=BASELINE, type=INT_ARRAY} 2349.39 ns; ?=4.04 ns @ 3 trials
31% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=BASELINE, type=INT_ARRAY} 563.93 ns; ?=1.51 ns @ 3 trials
32% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=BASELINE, type=INT_ARRAY} 2249.15 ns; ?=9.03 ns @ 3 trials
32% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=BASELINE, type=INT_ARRAY} 561.80 ns; ?=1.42 ns @ 3 trials
33% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=BASELINE, type=INT_ARRAY} 2252.62 ns; ?=21.17 ns @ 4 trials
33% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=BASELINE, type=INT_ARRAY} 621.58 ns; ?=1.68 ns @ 3 trials
33% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 566.90 ns; ?=9.34 ns @ 10 trials
34% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 2230.39 ns; ?=20.20 ns @ 3 trials
34% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 2322.53 ns; ?=22.10 ns @ 3 trials
35% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 562.56 ns; ?=1.74 ns @ 3 trials
35% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 2413.52 ns; ?=14.48 ns @ 3 trials
35% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 564.77 ns; ?=1.12 ns @ 3 trials
36% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 2279.87 ns; ?=7.94 ns @ 3 trials
36% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 565.38 ns; ?=5.09 ns @ 3 trials
37% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 2215.96 ns; ?=8.59 ns @ 3 trials
37% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 560.75 ns; ?=0.38 ns @ 3 trials
38% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 2319.55 ns; ?=3.62 ns @ 3 trials
38% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 562.18 ns; ?=1.08 ns @ 3 trials
38% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 2274.67 ns; ?=9.13 ns @ 3 trials
39% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 574.77 ns; ?=1.69 ns @ 3 trials
39% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 2223.49 ns; ?=5.10 ns @ 3 trials
40% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=BASELINE, type=INT_ARRAY_ARRAY_ARRAY} 625.29 ns; ?=3.09 ns @ 3 trials
40% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=BASELINE, type=OBJECT} 60.65 ns; ?=0.36 ns @ 3 trials
40% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=BASELINE, type=OBJECT} 1779.04 ns; ?=46.15 ns @ 10 trials
41% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=BASELINE, type=OBJECT} 1791.82 ns; ?=39.62 ns @ 10 trials
41% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=BASELINE, type=OBJECT} 60.31 ns; ?=0.48 ns @ 3 trials
42% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=BASELINE, type=OBJECT} 1849.71 ns; ?=35.08 ns @ 10 trials
42% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=BASELINE, type=OBJECT} 60.72 ns; ?=0.95 ns @ 10 trials
43% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=BASELINE, type=OBJECT} 1768.46 ns; ?=55.09 ns @ 10 trials
43% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=BASELINE, type=OBJECT} 60.89 ns; ?=1.16 ns @ 10 trials
43% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=BASELINE, type=OBJECT} 1882.01 ns; ?=24.07 ns @ 10 trials
44% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=BASELINE, type=OBJECT} 59.61 ns; ?=0.35 ns @ 3 trials
44% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=BASELINE, type=OBJECT} 1730.66 ns; ?=25.05 ns @ 10 trials
45% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=BASELINE, type=OBJECT} 61.04 ns; ?=0.03 ns @ 3 trials
45% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=BASELINE, type=OBJECT} 1800.68 ns; ?=13.45 ns @ 3 trials
45% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=BASELINE, type=OBJECT} 60.90 ns; ?=0.58 ns @ 8 trials
46% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=BASELINE, type=OBJECT} 182.36 ns; ?=0.28 ns @ 3 trials
46% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=BASELINE, type=OBJECT} 0.30 ns; ?=0.00 ns @ 3 trials
47% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=BASELINE, type=OBJECT_ARRAY} 561.38 ns; ?=1.93 ns @ 3 trials
47% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=BASELINE, type=OBJECT_ARRAY} 2392.20 ns; ?=35.50 ns @ 10 trials
48% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=BASELINE, type=OBJECT_ARRAY} 2225.41 ns; ?=21.57 ns @ 6 trials
48% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=BASELINE, type=OBJECT_ARRAY} 563.36 ns; ?=2.41 ns @ 3 trials
48% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=BASELINE, type=OBJECT_ARRAY} 2304.47 ns; ?=7.49 ns @ 3 trials
49% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=BASELINE, type=OBJECT_ARRAY} 565.99 ns; ?=0.59 ns @ 3 trials
49% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=BASELINE, type=OBJECT_ARRAY} 2320.31 ns; ?=5.52 ns @ 3 trials
50% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=BASELINE, type=OBJECT_ARRAY} 567.50 ns; ?=1.55 ns @ 3 trials
50% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=BASELINE, type=OBJECT_ARRAY} 2203.51 ns; ?=4.02 ns @ 3 trials
50% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=BASELINE, type=OBJECT_ARRAY} 563.76 ns; ?=5.64 ns @ 7 trials
51% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=BASELINE, type=OBJECT_ARRAY} 2204.75 ns; ?=7.42 ns @ 3 trials
51% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=BASELINE, type=OBJECT_ARRAY} 564.76 ns; ?=0.64 ns @ 3 trials
52% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=BASELINE, type=OBJECT_ARRAY} 2259.23 ns; ?=12.13 ns @ 3 trials
52% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=BASELINE, type=OBJECT_ARRAY} 562.72 ns; ?=0.54 ns @ 3 trials
53% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=BASELINE, type=OBJECT_ARRAY} 2211.93 ns; ?=8.14 ns @ 3 trials
53% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=BASELINE, type=OBJECT_ARRAY} 629.23 ns; ?=0.77 ns @ 3 trials
53% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=BASELINE, type=RAW_ARRAYLIST} 1169.65 ns; ?=4.47 ns @ 3 trials
54% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=BASELINE, type=RAW_ARRAYLIST} 5228.41 ns; ?=45.77 ns @ 3 trials
54% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=BASELINE, type=RAW_ARRAYLIST} 4543.07 ns; ?=23.45 ns @ 3 trials
55% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=BASELINE, type=RAW_ARRAYLIST} 960.70 ns; ?=12.19 ns @ 10 trials
55% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=BASELINE, type=RAW_ARRAYLIST} 5025.99 ns; ?=9.32 ns @ 3 trials
55% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=BASELINE, type=RAW_ARRAYLIST} 929.10 ns; ?=3.32 ns @ 3 trials
56% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=BASELINE, type=RAW_ARRAYLIST} 4982.33 ns; ?=48.77 ns @ 5 trials
56% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=BASELINE, type=RAW_ARRAYLIST} 1052.40 ns; ?=46.31 ns @ 10 trials
57% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=BASELINE, type=RAW_ARRAYLIST} 5117.45 ns; ?=14.74 ns @ 3 trials
57% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=BASELINE, type=RAW_ARRAYLIST} 1251.48 ns; ?=0.85 ns @ 3 trials
57% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=BASELINE, type=RAW_ARRAYLIST} 2820.05 ns; ?=3.10 ns @ 3 trials
58% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=BASELINE, type=RAW_ARRAYLIST} 682.08 ns; ?=15.82 ns @ 10 trials
58% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=BASELINE, type=RAW_ARRAYLIST} 2651.63 ns; ?=81.58 ns @ 10 trials
59% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=BASELINE, type=RAW_ARRAYLIST} 470.55 ns; ?=81.68 ns @ 10 trials
59% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=BASELINE, type=RAW_ARRAYLIST} 1781.91 ns; ?=43.76 ns @ 10 trials
60% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=BASELINE, type=RAW_ARRAYLIST} 131.16 ns; ?=1.30 ns @ 4 trials
60% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=BASELINE, type=RAW_COMPARABLE} 99.25 ns; ?=1.22 ns @ 10 trials
60% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=BASELINE, type=RAW_COMPARABLE} 1825.51 ns; ?=43.85 ns @ 10 trials
61% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=BASELINE, type=RAW_COMPARABLE} 1846.99 ns; ?=22.39 ns @ 10 trials
61% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=BASELINE, type=RAW_COMPARABLE} 54.97 ns; ?=0.23 ns @ 3 trials
62% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=BASELINE, type=RAW_COMPARABLE} 1757.72 ns; ?=32.96 ns @ 10 trials
62% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=BASELINE, type=RAW_COMPARABLE} 55.48 ns; ?=0.91 ns @ 10 trials
63% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=BASELINE, type=RAW_COMPARABLE} 1741.50 ns; ?=55.13 ns @ 10 trials
63% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=BASELINE, type=RAW_COMPARABLE} 100.35 ns; ?=0.94 ns @ 4 trials
63% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=BASELINE, type=RAW_COMPARABLE} 1726.47 ns; ?=28.99 ns @ 10 trials
64% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=BASELINE, type=RAW_COMPARABLE} 98.82 ns; ?=0.69 ns @ 3 trials
64% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=BASELINE, type=RAW_COMPARABLE} 1788.06 ns; ?=44.94 ns @ 10 trials
65% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=BASELINE, type=RAW_COMPARABLE} 98.85 ns; ?=0.25 ns @ 3 trials
65% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=BASELINE, type=RAW_COMPARABLE} 1830.96 ns; ?=34.17 ns @ 10 trials
65% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=BASELINE, type=RAW_COMPARABLE} 54.80 ns; ?=0.18 ns @ 3 trials
66% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=BASELINE, type=RAW_COMPARABLE} 1789.61 ns; ?=53.49 ns @ 10 trials
66% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=BASELINE, type=RAW_COMPARABLE} 134.64 ns; ?=1.22 ns @ 6 trials
67% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 1616.30 ns; ?=46.18 ns @ 10 trials
67% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 5606.01 ns; ?=44.87 ns @ 3 trials
68% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 5489.16 ns; ?=30.79 ns @ 3 trials
68% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 1461.90 ns; ?=6.76 ns @ 3 trials
68% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 5306.25 ns; ?=79.79 ns @ 10 trials
69% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 1413.73 ns; ?=11.57 ns @ 3 trials
69% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 5689.07 ns; ?=67.52 ns @ 10 trials
70% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 1512.75 ns; ?=3.56 ns @ 3 trials
70% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 5720.94 ns; ?=192.57 ns @ 10 trials
70% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 1710.55 ns; ?=2.33 ns @ 3 trials
71% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 4702.88 ns; ?=26.09 ns @ 3 trials
71% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 1457.40 ns; ?=20.41 ns @ 10 trials
72% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 3520.00 ns; ?=105.51 ns @ 10 trials
72% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 1104.70 ns; ?=9.17 ns @ 3 trials
73% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 2160.63 ns; ?=12.15 ns @ 3 trials
73% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=BASELINE, type=RAW_ELIST_SUBTYPE} 131.74 ns; ?=0.27 ns @ 3 trials
73% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=BASELINE, type=RAW_ITERABLE} 0.31 ns; ?=0.00 ns @ 3 trials
74% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=BASELINE, type=RAW_ITERABLE} 182.01 ns; ?=1.06 ns @ 3 trials
74% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=BASELINE, type=RAW_ITERABLE} 1783.79 ns; ?=18.60 ns @ 10 trials
75% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=BASELINE, type=RAW_ITERABLE} 55.79 ns; ?=0.34 ns @ 3 trials
75% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=BASELINE, type=RAW_ITERABLE} 2001.07 ns; ?=39.45 ns @ 10 trials
75% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=BASELINE, type=RAW_ITERABLE} 55.77 ns; ?=0.55 ns @ 8 trials
76% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=BASELINE, type=RAW_ITERABLE} 1771.96 ns; ?=15.90 ns @ 3 trials
76% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=BASELINE, type=RAW_ITERABLE} 100.58 ns; ?=0.42 ns @ 3 trials
77% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=BASELINE, type=RAW_ITERABLE} 1803.00 ns; ?=33.12 ns @ 10 trials
77% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=BASELINE, type=RAW_ITERABLE} 103.60 ns; ?=1.06 ns @ 10 trials
78% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=BASELINE, type=RAW_ITERABLE} 1903.72 ns; ?=86.54 ns @ 10 trials
78% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=BASELINE, type=RAW_ITERABLE} 100.38 ns; ?=1.12 ns @ 10 trials
78% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=BASELINE, type=RAW_ITERABLE} 1839.87 ns; ?=12.89 ns @ 3 trials
79% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=BASELINE, type=RAW_ITERABLE} 55.54 ns; ?=0.55 ns @ 7 trials
79% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=BASELINE, type=RAW_ITERABLE} 1731.69 ns; ?=30.34 ns @ 10 trials
80% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=BASELINE, type=RAW_ITERABLE} 131.57 ns; ?=2.62 ns @ 10 trials
80% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=BASELINE, type=RAW_MAP} 100.07 ns; ?=0.65 ns @ 3 trials
80% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=BASELINE, type=RAW_MAP} 2027.75 ns; ?=0.78 ns @ 3 trials
81% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=BASELINE, type=RAW_MAP} 1786.73 ns; ?=11.69 ns @ 3 trials
81% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=BASELINE, type=RAW_MAP} 56.53 ns; ?=0.30 ns @ 3 trials
82% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=BASELINE, type=RAW_MAP} 1934.12 ns; ?=36.39 ns @ 10 trials
82% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=BASELINE, type=RAW_MAP} 56.55 ns; ?=0.38 ns @ 3 trials
83% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=BASELINE, type=RAW_MAP} 1871.03 ns; ?=84.69 ns @ 10 trials
83% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=BASELINE, type=RAW_MAP} 100.34 ns; ?=2.01 ns @ 10 trials
83% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=BASELINE, type=RAW_MAP} 1817.15 ns; ?=28.32 ns @ 10 trials
84% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=BASELINE, type=RAW_MAP} 100.94 ns; ?=1.27 ns @ 10 trials
84% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=BASELINE, type=RAW_MAP} 1930.02 ns; ?=30.77 ns @ 10 trials
85% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=BASELINE, type=RAW_MAP} 100.70 ns; ?=1.67 ns @ 10 trials
85% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=BASELINE, type=RAW_MAP} 1815.75 ns; ?=30.34 ns @ 10 trials
85% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=BASELINE, type=RAW_MAP} 55.46 ns; ?=1.18 ns @ 10 trials
86% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=BASELINE, type=RAW_MAP} 1793.92 ns; ?=17.49 ns @ 3 trials
86% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=BASELINE, type=RAW_MAP} 135.02 ns; ?=1.31 ns @ 7 trials
87% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=BASELINE, type=STRING} 343.12 ns; ?=1.93 ns @ 3 trials
87% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=BASELINE, type=STRING} 2322.54 ns; ?=29.17 ns @ 10 trials
88% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=BASELINE, type=STRING} 2261.28 ns; ?=11.17 ns @ 3 trials
88% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=BASELINE, type=STRING} 244.69 ns; ?=2.61 ns @ 10 trials
88% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=BASELINE, type=STRING} 2406.53 ns; ?=50.19 ns @ 10 trials
89% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=BASELINE, type=STRING} 244.34 ns; ?=15.76 ns @ 10 trials
89% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=BASELINE, type=STRING} 2277.71 ns; ?=7.15 ns @ 3 trials
90% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=BASELINE, type=STRING} 347.82 ns; ?=2.42 ns @ 3 trials
90% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=BASELINE, type=STRING} 2285.51 ns; ?=17.96 ns @ 3 trials
90% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=BASELINE, type=STRING} 344.73 ns; ?=0.35 ns @ 3 trials
91% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=BASELINE, type=STRING} 2356.81 ns; ?=50.06 ns @ 10 trials
91% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=BASELINE, type=STRING} 347.35 ns; ?=19.61 ns @ 10 trials
92% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=BASELINE, type=STRING} 2275.36 ns; ?=20.49 ns @ 3 trials
92% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=BASELINE, type=STRING} 247.85 ns; ?=16.58 ns @ 10 trials
93% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=BASELINE, type=STRING} 1873.81 ns; ?=45.01 ns @ 10 trials
93% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=BASELINE, type=STRING} 132.51 ns; ?=1.13 ns @ 3 trials
93% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 1083.23 ns; ?=10.27 ns @ 3 trials
94% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 4320.38 ns; ?=5.27 ns @ 3 trials
94% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 3275.15 ns; ?=111.81 ns @ 10 trials
95% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 831.66 ns; ?=4.84 ns @ 3 trials
95% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 3512.08 ns; ?=108.28 ns @ 10 trials
95% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 823.94 ns; ?=8.87 ns @ 10 trials
96% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 3644.62 ns; ?=48.62 ns @ 10 trials
96% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 1079.73 ns; ?=10.49 ns @ 3 trials
97% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 3451.54 ns; ?=33.94 ns @ 4 trials
97% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 1081.53 ns; ?=2.57 ns @ 3 trials
98% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 3762.07 ns; ?=33.79 ns @ 4 trials
98% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 1081.38 ns; ?=13.41 ns @ 10 trials
98% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 3141.29 ns; ?=124.16 ns @ 10 trials
99% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 848.51 ns; ?=7.33 ns @ 3 trials
99% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 2343.11 ns; ?=44.63 ns @ 10 trials
100% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=BASELINE, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 134.34 ns; ?=0.64 ns @ 3 trials

                            type                             benchmark        ns linear runtime
                       CLONEABLE                  GetSuperTypeIterable   100.165 =
                       CLONEABLE           GetSuperTypeByClassIterable  1733.624 ===
                       CLONEABLE GetSuperTypeByClassAbstractCollection  2244.335 ====
                       CLONEABLE        GetSuperTypeAbstractCollection    54.752 =
                       CLONEABLE       GetSuperTypeByClassAbstractList  1791.781 ===
                       CLONEABLE              GetSuperTypeAbstractList    55.335 =
                       CLONEABLE         GetSuperTypeByClassCollection  1810.096 ===
                       CLONEABLE                GetSuperTypeCollection   104.839 =
                       CLONEABLE               GetSuperTypeByClassList  2008.435 ===
                       CLONEABLE                      GetSuperTypeList   101.294 =
                       CLONEABLE                GetSuperTypeByClassSet  1701.279 ===
                       CLONEABLE                       GetSuperTypeSet   101.190 =
                       CLONEABLE      GetSuperTypeByClassStringBuilder  1858.294 ===
                       CLONEABLE             GetSuperTypeStringBuilder    54.723 =
                       CLONEABLE             GetSuperTypeByClassObject  1703.162 ===
                       CLONEABLE                    GetSuperTypeObject   133.262 =
                          DOUBLE                  GetSuperTypeIterable   148.828 =
                          DOUBLE           GetSuperTypeByClassIterable  2004.213 ===
                          DOUBLE GetSuperTypeByClassAbstractCollection  2086.670 ===
                          DOUBLE        GetSuperTypeAbstractCollection   149.072 =
                          DOUBLE       GetSuperTypeByClassAbstractList  2280.949 ====
                          DOUBLE              GetSuperTypeAbstractList   146.856 =
                          DOUBLE         GetSuperTypeByClassCollection  1780.298 ===
                          DOUBLE                GetSuperTypeCollection   147.369 =
                          DOUBLE               GetSuperTypeByClassList  1949.698 ===
                          DOUBLE                      GetSuperTypeList   147.723 =
                          DOUBLE                GetSuperTypeByClassSet  1935.148 ===
                          DOUBLE                       GetSuperTypeSet   149.066 =
                          DOUBLE      GetSuperTypeByClassStringBuilder  2222.026 ===
                          DOUBLE             GetSuperTypeStringBuilder   147.440 =
                          DOUBLE             GetSuperTypeByClassObject  1910.262 ===
                          DOUBLE                    GetSuperTypeObject   148.634 =
                   ELIST_SUBTYPE                  GetSuperTypeIterable 11352.716 ====================
                   ELIST_SUBTYPE           GetSuperTypeByClassIterable 16799.725 ==============================
                   ELIST_SUBTYPE GetSuperTypeByClassAbstractCollection 16270.087 =============================
                   ELIST_SUBTYPE        GetSuperTypeAbstractCollection 11385.931 ====================
                   ELIST_SUBTYPE       GetSuperTypeByClassAbstractList 16252.335 =============================
                   ELIST_SUBTYPE              GetSuperTypeAbstractList 11120.974 ===================
                   ELIST_SUBTYPE         GetSuperTypeByClassCollection 16291.844 =============================
                   ELIST_SUBTYPE                GetSuperTypeCollection 11198.255 ===================
                   ELIST_SUBTYPE               GetSuperTypeByClassList 16585.773 =============================
                   ELIST_SUBTYPE                      GetSuperTypeList 11153.942 ===================
                   ELIST_SUBTYPE                GetSuperTypeByClassSet  4672.793 ========
                   ELIST_SUBTYPE                       GetSuperTypeSet  1460.825 ==
                   ELIST_SUBTYPE      GetSuperTypeByClassStringBuilder  3684.074 ======
                   ELIST_SUBTYPE             GetSuperTypeStringBuilder  1082.982 =
                   ELIST_SUBTYPE             GetSuperTypeByClassObject  1805.001 ===
                   ELIST_SUBTYPE                    GetSuperTypeObject   131.887 =
                             INT                  GetSuperTypeIterable   147.770 =
                             INT           GetSuperTypeByClassIterable  1739.085 ===
                             INT GetSuperTypeByClassAbstractCollection  1863.426 ===
                             INT        GetSuperTypeAbstractCollection   147.200 =
                             INT       GetSuperTypeByClassAbstractList  2273.185 ====
                             INT              GetSuperTypeAbstractList   148.289 =
                             INT         GetSuperTypeByClassCollection  2287.772 ====
                             INT                GetSuperTypeCollection   146.972 =
                             INT               GetSuperTypeByClassList  1877.081 ===
                             INT                      GetSuperTypeList   147.105 =
                             INT                GetSuperTypeByClassSet  2186.444 ===
                             INT                       GetSuperTypeSet   146.035 =
                             INT      GetSuperTypeByClassStringBuilder  1915.597 ===
                             INT             GetSuperTypeStringBuilder   147.720 =
                             INT             GetSuperTypeByClassObject  1821.851 ===
                             INT                    GetSuperTypeObject   145.445 =
                       INT_ARRAY                  GetSuperTypeIterable   565.265 =
                       INT_ARRAY           GetSuperTypeByClassIterable  2224.670 ===
                       INT_ARRAY GetSuperTypeByClassAbstractCollection  2348.195 ====
                       INT_ARRAY        GetSuperTypeAbstractCollection   571.172 =
                       INT_ARRAY       GetSuperTypeByClassAbstractList  2269.759 ====
                       INT_ARRAY              GetSuperTypeAbstractList   564.835 =
                       INT_ARRAY         GetSuperTypeByClassCollection  2282.144 ====
                       INT_ARRAY                GetSuperTypeCollection   564.069 =
                       INT_ARRAY               GetSuperTypeByClassList  2349.640 ====
                       INT_ARRAY                      GetSuperTypeList   565.633 =
                       INT_ARRAY                GetSuperTypeByClassSet  2349.394 ====
                       INT_ARRAY                       GetSuperTypeSet   563.931 =
                       INT_ARRAY      GetSuperTypeByClassStringBuilder  2249.152 ====
                       INT_ARRAY             GetSuperTypeStringBuilder   561.796 =
                       INT_ARRAY             GetSuperTypeByClassObject  2252.624 ====
                       INT_ARRAY                    GetSuperTypeObject   621.583 =
           INT_ARRAY_ARRAY_ARRAY                  GetSuperTypeIterable   566.897 =
           INT_ARRAY_ARRAY_ARRAY           GetSuperTypeByClassIterable  2230.388 ===
           INT_ARRAY_ARRAY_ARRAY GetSuperTypeByClassAbstractCollection  2322.525 ====
           INT_ARRAY_ARRAY_ARRAY        GetSuperTypeAbstractCollection   562.558 =
           INT_ARRAY_ARRAY_ARRAY       GetSuperTypeByClassAbstractList  2413.521 ====
           INT_ARRAY_ARRAY_ARRAY              GetSuperTypeAbstractList   564.768 =
           INT_ARRAY_ARRAY_ARRAY         GetSuperTypeByClassCollection  2279.872 ====
           INT_ARRAY_ARRAY_ARRAY                GetSuperTypeCollection   565.381 =
           INT_ARRAY_ARRAY_ARRAY               GetSuperTypeByClassList  2215.959 ===
           INT_ARRAY_ARRAY_ARRAY                      GetSuperTypeList   560.748 =
           INT_ARRAY_ARRAY_ARRAY                GetSuperTypeByClassSet  2319.553 ====
           INT_ARRAY_ARRAY_ARRAY                       GetSuperTypeSet   562.181 =
           INT_ARRAY_ARRAY_ARRAY      GetSuperTypeByClassStringBuilder  2274.673 ====
           INT_ARRAY_ARRAY_ARRAY             GetSuperTypeStringBuilder   574.770 =
           INT_ARRAY_ARRAY_ARRAY             GetSuperTypeByClassObject  2223.490 ===
           INT_ARRAY_ARRAY_ARRAY                    GetSuperTypeObject   625.294 =
                          OBJECT                  GetSuperTypeIterable    60.645 =
                          OBJECT           GetSuperTypeByClassIterable  1779.035 ===
                          OBJECT GetSuperTypeByClassAbstractCollection  1791.816 ===
                          OBJECT        GetSuperTypeAbstractCollection    60.308 =
                          OBJECT       GetSuperTypeByClassAbstractList  1849.711 ===
                          OBJECT              GetSuperTypeAbstractList    60.715 =
                          OBJECT         GetSuperTypeByClassCollection  1768.462 ===
                          OBJECT                GetSuperTypeCollection    60.885 =
                          OBJECT               GetSuperTypeByClassList  1882.014 ===
                          OBJECT                      GetSuperTypeList    59.608 =
                          OBJECT                GetSuperTypeByClassSet  1730.656 ===
                          OBJECT                       GetSuperTypeSet    61.037 =
                          OBJECT      GetSuperTypeByClassStringBuilder  1800.677 ===
                          OBJECT             GetSuperTypeStringBuilder    60.895 =
                          OBJECT             GetSuperTypeByClassObject   182.357 =
                          OBJECT                    GetSuperTypeObject     0.304 =
                    OBJECT_ARRAY                  GetSuperTypeIterable   561.377 =
                    OBJECT_ARRAY           GetSuperTypeByClassIterable  2392.199 ====
                    OBJECT_ARRAY GetSuperTypeByClassAbstractCollection  2225.411 ===
                    OBJECT_ARRAY        GetSuperTypeAbstractCollection   563.359 =
                    OBJECT_ARRAY       GetSuperTypeByClassAbstractList  2304.471 ====
                    OBJECT_ARRAY              GetSuperTypeAbstractList   565.989 =
                    OBJECT_ARRAY         GetSuperTypeByClassCollection  2320.313 ====
                    OBJECT_ARRAY                GetSuperTypeCollection   567.497 =
                    OBJECT_ARRAY               GetSuperTypeByClassList  2203.508 ===
                    OBJECT_ARRAY                      GetSuperTypeList   563.764 =
                    OBJECT_ARRAY                GetSuperTypeByClassSet  2204.751 ===
                    OBJECT_ARRAY                       GetSuperTypeSet   564.765 =
                    OBJECT_ARRAY      GetSuperTypeByClassStringBuilder  2259.234 ====
                    OBJECT_ARRAY             GetSuperTypeStringBuilder   562.715 =
                    OBJECT_ARRAY             GetSuperTypeByClassObject  2211.931 ===
                    OBJECT_ARRAY                    GetSuperTypeObject   629.231 =
                   RAW_ARRAYLIST                  GetSuperTypeIterable  1169.646 ==
                   RAW_ARRAYLIST           GetSuperTypeByClassIterable  5228.407 =========
                   RAW_ARRAYLIST GetSuperTypeByClassAbstractCollection  4543.068 ========
                   RAW_ARRAYLIST        GetSuperTypeAbstractCollection   960.696 =
                   RAW_ARRAYLIST       GetSuperTypeByClassAbstractList  5025.986 ========
                   RAW_ARRAYLIST              GetSuperTypeAbstractList   929.103 =
                   RAW_ARRAYLIST         GetSuperTypeByClassCollection  4982.332 ========
                   RAW_ARRAYLIST                GetSuperTypeCollection  1052.395 =
                   RAW_ARRAYLIST               GetSuperTypeByClassList  5117.452 =========
                   RAW_ARRAYLIST                      GetSuperTypeList  1251.480 ==
                   RAW_ARRAYLIST                GetSuperTypeByClassSet  2820.055 =====
                   RAW_ARRAYLIST                       GetSuperTypeSet   682.082 =
                   RAW_ARRAYLIST      GetSuperTypeByClassStringBuilder  2651.628 ====
                   RAW_ARRAYLIST             GetSuperTypeStringBuilder   470.555 =
                   RAW_ARRAYLIST             GetSuperTypeByClassObject  1781.911 ===
                   RAW_ARRAYLIST                    GetSuperTypeObject   131.164 =
                  RAW_COMPARABLE                  GetSuperTypeIterable    99.251 =
                  RAW_COMPARABLE           GetSuperTypeByClassIterable  1825.506 ===
                  RAW_COMPARABLE GetSuperTypeByClassAbstractCollection  1846.988 ===
                  RAW_COMPARABLE        GetSuperTypeAbstractCollection    54.975 =
                  RAW_COMPARABLE       GetSuperTypeByClassAbstractList  1757.723 ===
                  RAW_COMPARABLE              GetSuperTypeAbstractList    55.477 =
                  RAW_COMPARABLE         GetSuperTypeByClassCollection  1741.503 ===
                  RAW_COMPARABLE                GetSuperTypeCollection   100.349 =
                  RAW_COMPARABLE               GetSuperTypeByClassList  1726.467 ===
                  RAW_COMPARABLE                      GetSuperTypeList    98.823 =
                  RAW_COMPARABLE                GetSuperTypeByClassSet  1788.064 ===
                  RAW_COMPARABLE                       GetSuperTypeSet    98.847 =
                  RAW_COMPARABLE      GetSuperTypeByClassStringBuilder  1830.956 ===
                  RAW_COMPARABLE             GetSuperTypeStringBuilder    54.801 =
                  RAW_COMPARABLE             GetSuperTypeByClassObject  1789.615 ===
                  RAW_COMPARABLE                    GetSuperTypeObject   134.640 =
               RAW_ELIST_SUBTYPE                  GetSuperTypeIterable  1616.300 ==
               RAW_ELIST_SUBTYPE           GetSuperTypeByClassIterable  5606.011 ==========
               RAW_ELIST_SUBTYPE GetSuperTypeByClassAbstractCollection  5489.161 =========
               RAW_ELIST_SUBTYPE        GetSuperTypeAbstractCollection  1461.901 ==
               RAW_ELIST_SUBTYPE       GetSuperTypeByClassAbstractList  5306.249 =========
               RAW_ELIST_SUBTYPE              GetSuperTypeAbstractList  1413.733 ==
               RAW_ELIST_SUBTYPE         GetSuperTypeByClassCollection  5689.074 ==========
               RAW_ELIST_SUBTYPE                GetSuperTypeCollection  1512.748 ==
               RAW_ELIST_SUBTYPE               GetSuperTypeByClassList  5720.936 ==========
               RAW_ELIST_SUBTYPE                      GetSuperTypeList  1710.554 ===
               RAW_ELIST_SUBTYPE                GetSuperTypeByClassSet  4702.884 ========
               RAW_ELIST_SUBTYPE                       GetSuperTypeSet  1457.396 ==
               RAW_ELIST_SUBTYPE      GetSuperTypeByClassStringBuilder  3519.999 ======
               RAW_ELIST_SUBTYPE             GetSuperTypeStringBuilder  1104.697 =
               RAW_ELIST_SUBTYPE             GetSuperTypeByClassObject  2160.632 ===
               RAW_ELIST_SUBTYPE                    GetSuperTypeObject   131.736 =
                    RAW_ITERABLE                  GetSuperTypeIterable     0.307 =
                    RAW_ITERABLE           GetSuperTypeByClassIterable   182.012 =
                    RAW_ITERABLE GetSuperTypeByClassAbstractCollection  1783.791 ===
                    RAW_ITERABLE        GetSuperTypeAbstractCollection    55.795 =
                    RAW_ITERABLE       GetSuperTypeByClassAbstractList  2001.073 ===
                    RAW_ITERABLE              GetSuperTypeAbstractList    55.768 =
                    RAW_ITERABLE         GetSuperTypeByClassCollection  1771.962 ===
                    RAW_ITERABLE                GetSuperTypeCollection   100.580 =
                    RAW_ITERABLE               GetSuperTypeByClassList  1802.996 ===
                    RAW_ITERABLE                      GetSuperTypeList   103.604 =
                    RAW_ITERABLE                GetSuperTypeByClassSet  1903.724 ===
                    RAW_ITERABLE                       GetSuperTypeSet   100.384 =
                    RAW_ITERABLE      GetSuperTypeByClassStringBuilder  1839.870 ===
                    RAW_ITERABLE             GetSuperTypeStringBuilder    55.539 =
                    RAW_ITERABLE             GetSuperTypeByClassObject  1731.694 ===
                    RAW_ITERABLE                    GetSuperTypeObject   131.575 =
                         RAW_MAP                  GetSuperTypeIterable   100.071 =
                         RAW_MAP           GetSuperTypeByClassIterable  2027.747 ===
                         RAW_MAP GetSuperTypeByClassAbstractCollection  1786.735 ===
                         RAW_MAP        GetSuperTypeAbstractCollection    56.532 =
                         RAW_MAP       GetSuperTypeByClassAbstractList  1934.124 ===
                         RAW_MAP              GetSuperTypeAbstractList    56.549 =
                         RAW_MAP         GetSuperTypeByClassCollection  1871.034 ===
                         RAW_MAP                GetSuperTypeCollection   100.338 =
                         RAW_MAP               GetSuperTypeByClassList  1817.152 ===
                         RAW_MAP                      GetSuperTypeList   100.942 =
                         RAW_MAP                GetSuperTypeByClassSet  1930.025 ===
                         RAW_MAP                       GetSuperTypeSet   100.697 =
                         RAW_MAP      GetSuperTypeByClassStringBuilder  1815.748 ===
                         RAW_MAP             GetSuperTypeStringBuilder    55.462 =
                         RAW_MAP             GetSuperTypeByClassObject  1793.915 ===
                         RAW_MAP                    GetSuperTypeObject   135.022 =
                          STRING                  GetSuperTypeIterable   343.118 =
                          STRING           GetSuperTypeByClassIterable  2322.535 ====
                          STRING GetSuperTypeByClassAbstractCollection  2261.277 ====
                          STRING        GetSuperTypeAbstractCollection   244.690 =
                          STRING       GetSuperTypeByClassAbstractList  2406.525 ====
                          STRING              GetSuperTypeAbstractList   244.340 =
                          STRING         GetSuperTypeByClassCollection  2277.708 ====
                          STRING                GetSuperTypeCollection   347.819 =
                          STRING               GetSuperTypeByClassList  2285.514 ====
                          STRING                      GetSuperTypeList   344.727 =
                          STRING                GetSuperTypeByClassSet  2356.810 ====
                          STRING                       GetSuperTypeSet   347.352 =
                          STRING      GetSuperTypeByClassStringBuilder  2275.363 ====
                          STRING             GetSuperTypeStringBuilder   247.846 =
                          STRING             GetSuperTypeByClassObject  1873.811 ===
                          STRING                    GetSuperTypeObject   132.514 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM                  GetSuperTypeIterable  1083.227 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM           GetSuperTypeByClassIterable  4320.384 =======
XMEMBER_FEATURE_CALL_IMPL_CUSTOM GetSuperTypeByClassAbstractCollection  3275.155 =====
XMEMBER_FEATURE_CALL_IMPL_CUSTOM        GetSuperTypeAbstractCollection   831.664 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM       GetSuperTypeByClassAbstractList  3512.080 ======
XMEMBER_FEATURE_CALL_IMPL_CUSTOM              GetSuperTypeAbstractList   823.939 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM         GetSuperTypeByClassCollection  3644.625 ======
XMEMBER_FEATURE_CALL_IMPL_CUSTOM                GetSuperTypeCollection  1079.728 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM               GetSuperTypeByClassList  3451.539 ======
XMEMBER_FEATURE_CALL_IMPL_CUSTOM                      GetSuperTypeList  1081.529 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM                GetSuperTypeByClassSet  3762.072 ======
XMEMBER_FEATURE_CALL_IMPL_CUSTOM                       GetSuperTypeSet  1081.381 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM      GetSuperTypeByClassStringBuilder  3141.290 =====
XMEMBER_FEATURE_CALL_IMPL_CUSTOM             GetSuperTypeStringBuilder   848.513 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM             GetSuperTypeByClassObject  2343.105 ====
XMEMBER_FEATURE_CALL_IMPL_CUSTOM                    GetSuperTypeObject   134.338 =


As of 21. June

 0% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=REWRITTEN, type=CLONEABLE} 34.79 ns; ?=0.13 ns @ 3 trials
 0% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=REWRITTEN, type=CLONEABLE} 38.03 ns; ?=0.37 ns @ 4 trials
 1% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=REWRITTEN, type=CLONEABLE} 8.20 ns; ?=0.03 ns @ 3 trials
 1% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=REWRITTEN, type=CLONEABLE} 8.67 ns; ?=0.02 ns @ 3 trials
 2% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=REWRITTEN, type=CLONEABLE} 8.17 ns; ?=0.05 ns @ 3 trials
 2% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=REWRITTEN, type=CLONEABLE} 8.67 ns; ?=0.01 ns @ 3 trials
 3% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=REWRITTEN, type=CLONEABLE} 37.85 ns; ?=0.38 ns @ 6 trials
 3% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=REWRITTEN, type=CLONEABLE} 35.24 ns; ?=0.11 ns @ 3 trials
 3% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=REWRITTEN, type=CLONEABLE} 38.15 ns; ?=0.64 ns @ 10 trials
 4% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=REWRITTEN, type=CLONEABLE} 35.42 ns; ?=0.14 ns @ 3 trials
 4% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=REWRITTEN, type=CLONEABLE} 37.85 ns; ?=1.34 ns @ 10 trials
 5% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=REWRITTEN, type=CLONEABLE} 35.20 ns; ?=0.30 ns @ 4 trials
 5% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=REWRITTEN, type=CLONEABLE} 7.66 ns; ?=0.02 ns @ 3 trials
 5% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=REWRITTEN, type=CLONEABLE} 7.84 ns; ?=0.01 ns @ 3 trials
 6% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=REWRITTEN, type=CLONEABLE} 200.32 ns; ?=2.53 ns @ 10 trials
 6% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=REWRITTEN, type=CLONEABLE} 63.22 ns; ?=0.57 ns @ 4 trials
 7% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=REWRITTEN, type=DOUBLE} 0.59 ns; ?=0.00 ns @ 3 trials
 7% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=REWRITTEN, type=DOUBLE} 5.89 ns; ?=0.02 ns @ 3 trials
 8% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=REWRITTEN, type=DOUBLE} 5.89 ns; ?=0.05 ns @ 3 trials
 8% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=REWRITTEN, type=DOUBLE} 0.59 ns; ?=0.00 ns @ 3 trials
 8% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=REWRITTEN, type=DOUBLE} 5.87 ns; ?=0.06 ns @ 4 trials
 9% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=REWRITTEN, type=DOUBLE} 0.59 ns; ?=0.00 ns @ 3 trials
 9% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=REWRITTEN, type=DOUBLE} 5.86 ns; ?=0.02 ns @ 3 trials
10% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=REWRITTEN, type=DOUBLE} 0.59 ns; ?=0.00 ns @ 3 trials
10% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=REWRITTEN, type=DOUBLE} 5.88 ns; ?=0.05 ns @ 3 trials
10% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=REWRITTEN, type=DOUBLE} 0.59 ns; ?=0.01 ns @ 5 trials
11% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=REWRITTEN, type=DOUBLE} 5.86 ns; ?=0.02 ns @ 3 trials
11% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=REWRITTEN, type=DOUBLE} 0.59 ns; ?=0.00 ns @ 3 trials
12% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=REWRITTEN, type=DOUBLE} 5.85 ns; ?=0.02 ns @ 3 trials
12% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=REWRITTEN, type=DOUBLE} 0.58 ns; ?=0.01 ns @ 10 trials
13% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=REWRITTEN, type=DOUBLE} 5.92 ns; ?=0.01 ns @ 3 trials
13% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=REWRITTEN, type=DOUBLE} 0.59 ns; ?=0.01 ns @ 10 trials
13% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=REWRITTEN, type=ELIST_SUBTYPE} 10427.83 ns; ?=47.61 ns @ 3 trials
14% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=REWRITTEN, type=ELIST_SUBTYPE} 10285.59 ns; ?=3.71 ns @ 3 trials
14% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=REWRITTEN, type=ELIST_SUBTYPE} 10170.18 ns; ?=35.76 ns @ 3 trials
15% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=REWRITTEN, type=ELIST_SUBTYPE} 10224.99 ns; ?=140.25 ns @ 10 trials
15% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=REWRITTEN, type=ELIST_SUBTYPE} 10265.21 ns; ?=50.34 ns @ 3 trials
15% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=REWRITTEN, type=ELIST_SUBTYPE} 10057.22 ns; ?=97.40 ns @ 4 trials
16% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=REWRITTEN, type=ELIST_SUBTYPE} 10620.53 ns; ?=46.22 ns @ 3 trials
16% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=REWRITTEN, type=ELIST_SUBTYPE} 10108.44 ns; ?=62.42 ns @ 3 trials
17% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=REWRITTEN, type=ELIST_SUBTYPE} 10483.42 ns; ?=79.16 ns @ 3 trials
17% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=REWRITTEN, type=ELIST_SUBTYPE} 10432.06 ns; ?=44.14 ns @ 3 trials
18% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=REWRITTEN, type=ELIST_SUBTYPE} 1000.16 ns; ?=9.93 ns @ 6 trials
18% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=REWRITTEN, type=ELIST_SUBTYPE} 936.35 ns; ?=1.38 ns @ 3 trials
18% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=REWRITTEN, type=ELIST_SUBTYPE} 7.77 ns; ?=0.02 ns @ 3 trials
19% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=REWRITTEN, type=ELIST_SUBTYPE} 7.82 ns; ?=0.01 ns @ 3 trials
19% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=REWRITTEN, type=ELIST_SUBTYPE} 205.66 ns; ?=1.92 ns @ 4 trials
20% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=REWRITTEN, type=ELIST_SUBTYPE} 63.50 ns; ?=0.63 ns @ 10 trials
20% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=REWRITTEN, type=INT} 0.59 ns; ?=0.00 ns @ 3 trials
20% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=REWRITTEN, type=INT} 5.87 ns; ?=0.01 ns @ 3 trials
21% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=REWRITTEN, type=INT} 5.86 ns; ?=0.06 ns @ 4 trials
21% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=REWRITTEN, type=INT} 0.59 ns; ?=0.00 ns @ 3 trials
22% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=REWRITTEN, type=INT} 5.91 ns; ?=0.02 ns @ 3 trials
22% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=REWRITTEN, type=INT} 0.59 ns; ?=0.00 ns @ 3 trials
23% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=REWRITTEN, type=INT} 5.91 ns; ?=0.03 ns @ 3 trials
23% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=REWRITTEN, type=INT} 0.59 ns; ?=0.01 ns @ 10 trials
23% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=REWRITTEN, type=INT} 5.89 ns; ?=0.02 ns @ 3 trials
24% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=REWRITTEN, type=INT} 0.59 ns; ?=0.01 ns @ 10 trials
24% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=REWRITTEN, type=INT} 5.91 ns; ?=0.06 ns @ 4 trials
25% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=REWRITTEN, type=INT} 0.59 ns; ?=0.00 ns @ 3 trials
25% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=REWRITTEN, type=INT} 5.91 ns; ?=0.05 ns @ 3 trials
25% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=REWRITTEN, type=INT} 0.59 ns; ?=0.00 ns @ 3 trials
26% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=REWRITTEN, type=INT} 5.98 ns; ?=0.03 ns @ 3 trials
26% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=REWRITTEN, type=INT} 0.59 ns; ?=0.00 ns @ 3 trials
27% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=REWRITTEN, type=INT_ARRAY} 7.34 ns; ?=0.04 ns @ 3 trials
27% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=REWRITTEN, type=INT_ARRAY} 1319.69 ns; ?=31.63 ns @ 10 trials
28% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=REWRITTEN, type=INT_ARRAY} 1364.20 ns; ?=38.20 ns @ 10 trials
28% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=REWRITTEN, type=INT_ARRAY} 7.20 ns; ?=0.02 ns @ 3 trials
28% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=REWRITTEN, type=INT_ARRAY} 1668.99 ns; ?=18.92 ns @ 10 trials
29% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=REWRITTEN, type=INT_ARRAY} 7.31 ns; ?=0.02 ns @ 3 trials
29% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=REWRITTEN, type=INT_ARRAY} 1218.41 ns; ?=28.00 ns @ 10 trials
30% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=REWRITTEN, type=INT_ARRAY} 9.39 ns; ?=0.03 ns @ 3 trials
30% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=REWRITTEN, type=INT_ARRAY} 1259.55 ns; ?=37.55 ns @ 10 trials
30% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=REWRITTEN, type=INT_ARRAY} 7.21 ns; ?=0.02 ns @ 3 trials
31% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=REWRITTEN, type=INT_ARRAY} 1234.28 ns; ?=30.09 ns @ 10 trials
31% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=REWRITTEN, type=INT_ARRAY} 7.19 ns; ?=0.03 ns @ 3 trials
32% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=REWRITTEN, type=INT_ARRAY} 1385.02 ns; ?=26.63 ns @ 10 trials
32% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=REWRITTEN, type=INT_ARRAY} 7.22 ns; ?=0.10 ns @ 10 trials
33% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=REWRITTEN, type=INT_ARRAY} 1366.00 ns; ?=54.53 ns @ 10 trials
33% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=REWRITTEN, type=INT_ARRAY} 63.31 ns; ?=0.13 ns @ 3 trials
33% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 7.02 ns; ?=0.03 ns @ 3 trials
34% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 1264.42 ns; ?=52.75 ns @ 10 trials
34% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 1144.05 ns; ?=11.25 ns @ 3 trials
35% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 6.95 ns; ?=0.01 ns @ 3 trials
35% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 1581.79 ns; ?=3.42 ns @ 3 trials
35% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 7.06 ns; ?=0.12 ns @ 10 trials
36% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 1299.12 ns; ?=24.71 ns @ 10 trials
36% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 9.45 ns; ?=0.02 ns @ 3 trials
37% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 1237.26 ns; ?=21.23 ns @ 10 trials
37% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 6.98 ns; ?=0.05 ns @ 3 trials
38% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 1356.06 ns; ?=39.06 ns @ 10 trials
38% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 6.98 ns; ?=0.06 ns @ 3 trials
38% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 1183.26 ns; ?=17.81 ns @ 10 trials
39% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 6.97 ns; ?=0.00 ns @ 3 trials
39% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 1368.91 ns; ?=40.92 ns @ 10 trials
40% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=REWRITTEN, type=INT_ARRAY_ARRAY_ARRAY} 63.18 ns; ?=0.02 ns @ 3 trials
40% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=REWRITTEN, type=OBJECT} 18.68 ns; ?=0.06 ns @ 3 trials
40% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=REWRITTEN, type=OBJECT} 19.35 ns; ?=0.02 ns @ 3 trials
41% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=REWRITTEN, type=OBJECT} 19.48 ns; ?=0.11 ns @ 3 trials
41% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=REWRITTEN, type=OBJECT} 19.39 ns; ?=0.24 ns @ 10 trials
42% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=REWRITTEN, type=OBJECT} 19.21 ns; ?=0.04 ns @ 3 trials
42% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=REWRITTEN, type=OBJECT} 19.26 ns; ?=0.14 ns @ 3 trials
43% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=REWRITTEN, type=OBJECT} 19.69 ns; ?=0.09 ns @ 3 trials
43% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=REWRITTEN, type=OBJECT} 18.74 ns; ?=0.26 ns @ 10 trials
43% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=REWRITTEN, type=OBJECT} 19.59 ns; ?=0.10 ns @ 3 trials
44% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=REWRITTEN, type=OBJECT} 18.84 ns; ?=0.03 ns @ 3 trials
44% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=REWRITTEN, type=OBJECT} 19.80 ns; ?=0.08 ns @ 3 trials
45% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=REWRITTEN, type=OBJECT} 18.79 ns; ?=0.18 ns @ 6 trials
45% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=REWRITTEN, type=OBJECT} 7.65 ns; ?=0.02 ns @ 3 trials
45% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=REWRITTEN, type=OBJECT} 7.86 ns; ?=0.07 ns @ 6 trials
46% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=REWRITTEN, type=OBJECT} 5.23 ns; ?=0.02 ns @ 3 trials
46% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=REWRITTEN, type=OBJECT} 0.31 ns; ?=0.00 ns @ 3 trials
47% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=REWRITTEN, type=OBJECT_ARRAY} 7.25 ns; ?=0.03 ns @ 3 trials
47% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=REWRITTEN, type=OBJECT_ARRAY} 1139.81 ns; ?=17.79 ns @ 10 trials
48% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=REWRITTEN, type=OBJECT_ARRAY} 1227.40 ns; ?=38.30 ns @ 10 trials
48% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=REWRITTEN, type=OBJECT_ARRAY} 7.19 ns; ?=0.02 ns @ 3 trials
48% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=REWRITTEN, type=OBJECT_ARRAY} 1387.23 ns; ?=33.22 ns @ 10 trials
49% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=REWRITTEN, type=OBJECT_ARRAY} 7.20 ns; ?=0.03 ns @ 3 trials
49% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=REWRITTEN, type=OBJECT_ARRAY} 1116.16 ns; ?=2.49 ns @ 3 trials
50% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=REWRITTEN, type=OBJECT_ARRAY} 9.52 ns; ?=0.06 ns @ 3 trials
50% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=REWRITTEN, type=OBJECT_ARRAY} 1299.22 ns; ?=59.62 ns @ 10 trials
50% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=REWRITTEN, type=OBJECT_ARRAY} 7.21 ns; ?=0.06 ns @ 3 trials
51% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=REWRITTEN, type=OBJECT_ARRAY} 1202.07 ns; ?=11.20 ns @ 6 trials
51% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=REWRITTEN, type=OBJECT_ARRAY} 7.20 ns; ?=0.01 ns @ 3 trials
52% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=REWRITTEN, type=OBJECT_ARRAY} 1135.13 ns; ?=8.58 ns @ 3 trials
52% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=REWRITTEN, type=OBJECT_ARRAY} 7.19 ns; ?=0.18 ns @ 10 trials
53% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=REWRITTEN, type=OBJECT_ARRAY} 1245.61 ns; ?=38.81 ns @ 10 trials
53% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=REWRITTEN, type=OBJECT_ARRAY} 63.13 ns; ?=0.20 ns @ 3 trials
53% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=REWRITTEN, type=RAW_ARRAYLIST} 183.56 ns; ?=1.13 ns @ 3 trials
54% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=REWRITTEN, type=RAW_ARRAYLIST} 201.44 ns; ?=0.88 ns @ 3 trials
54% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=REWRITTEN, type=RAW_ARRAYLIST} 142.55 ns; ?=0.95 ns @ 3 trials
55% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=REWRITTEN, type=RAW_ARRAYLIST} 131.92 ns; ?=0.63 ns @ 3 trials
55% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=REWRITTEN, type=RAW_ARRAYLIST} 129.52 ns; ?=0.69 ns @ 3 trials
55% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=REWRITTEN, type=RAW_ARRAYLIST} 116.28 ns; ?=0.80 ns @ 3 trials
56% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=REWRITTEN, type=RAW_ARRAYLIST} 179.74 ns; ?=1.12 ns @ 3 trials
56% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=REWRITTEN, type=RAW_ARRAYLIST} 167.42 ns; ?=0.16 ns @ 3 trials
57% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=REWRITTEN, type=RAW_ARRAYLIST} 238.42 ns; ?=1.09 ns @ 3 trials
57% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=REWRITTEN, type=RAW_ARRAYLIST} 216.37 ns; ?=1.24 ns @ 3 trials
57% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=REWRITTEN, type=RAW_ARRAYLIST} 313.27 ns; ?=1.14 ns @ 3 trials
58% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=REWRITTEN, type=RAW_ARRAYLIST} 291.45 ns; ?=2.49 ns @ 4 trials
58% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=REWRITTEN, type=RAW_ARRAYLIST} 7.73 ns; ?=0.08 ns @ 3 trials
59% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=REWRITTEN, type=RAW_ARRAYLIST} 8.07 ns; ?=0.23 ns @ 10 trials
59% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=REWRITTEN, type=RAW_ARRAYLIST} 201.06 ns; ?=1.97 ns @ 3 trials
60% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=REWRITTEN, type=RAW_ARRAYLIST} 70.69 ns; ?=4.97 ns @ 10 trials
60% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=REWRITTEN, type=RAW_COMPARABLE} 36.60 ns; ?=4.02 ns @ 10 trials
60% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=REWRITTEN, type=RAW_COMPARABLE} 38.37 ns; ?=0.22 ns @ 3 trials
61% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=REWRITTEN, type=RAW_COMPARABLE} 8.22 ns; ?=0.06 ns @ 3 trials
61% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=REWRITTEN, type=RAW_COMPARABLE} 8.66 ns; ?=0.06 ns @ 3 trials
62% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=REWRITTEN, type=RAW_COMPARABLE} 8.19 ns; ?=0.05 ns @ 3 trials
62% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=REWRITTEN, type=RAW_COMPARABLE} 8.60 ns; ?=0.02 ns @ 3 trials
63% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=REWRITTEN, type=RAW_COMPARABLE} 42.08 ns; ?=0.16 ns @ 3 trials
63% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=REWRITTEN, type=RAW_COMPARABLE} 35.23 ns; ?=0.01 ns @ 3 trials
63% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=REWRITTEN, type=RAW_COMPARABLE} 38.22 ns; ?=0.19 ns @ 3 trials
64% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=REWRITTEN, type=RAW_COMPARABLE} 35.08 ns; ?=0.09 ns @ 3 trials
64% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=REWRITTEN, type=RAW_COMPARABLE} 38.27 ns; ?=0.44 ns @ 10 trials
65% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=REWRITTEN, type=RAW_COMPARABLE} 35.32 ns; ?=0.33 ns @ 4 trials
65% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=REWRITTEN, type=RAW_COMPARABLE} 7.75 ns; ?=0.02 ns @ 3 trials
65% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=REWRITTEN, type=RAW_COMPARABLE} 7.74 ns; ?=0.00 ns @ 3 trials
66% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=REWRITTEN, type=RAW_COMPARABLE} 201.24 ns; ?=1.65 ns @ 3 trials
66% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=REWRITTEN, type=RAW_COMPARABLE} 64.20 ns; ?=0.55 ns @ 3 trials
67% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 422.79 ns; ?=5.39 ns @ 10 trials
67% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 454.43 ns; ?=1.83 ns @ 3 trials
68% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 344.29 ns; ?=2.42 ns @ 3 trials
68% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 314.38 ns; ?=1.42 ns @ 3 trials
68% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 319.89 ns; ?=2.28 ns @ 3 trials
69% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 289.93 ns; ?=2.12 ns @ 3 trials
69% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 424.17 ns; ?=3.28 ns @ 3 trials
70% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 391.17 ns; ?=1.01 ns @ 3 trials
70% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 515.74 ns; ?=2.85 ns @ 3 trials
70% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 480.21 ns; ?=2.43 ns @ 3 trials
71% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 994.20 ns; ?=2.73 ns @ 3 trials
71% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 958.88 ns; ?=2.23 ns @ 3 trials
72% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 7.70 ns; ?=0.02 ns @ 3 trials
72% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 7.81 ns; ?=0.02 ns @ 3 trials
73% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 202.43 ns; ?=0.81 ns @ 3 trials
73% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 64.72 ns; ?=0.13 ns @ 3 trials
73% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=REWRITTEN, type=RAW_ITERABLE} 0.31 ns; ?=0.00 ns @ 3 trials
74% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=REWRITTEN, type=RAW_ITERABLE} 5.20 ns; ?=0.02 ns @ 3 trials
74% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=REWRITTEN, type=RAW_ITERABLE} 8.24 ns; ?=0.34 ns @ 10 trials
75% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=REWRITTEN, type=RAW_ITERABLE} 8.69 ns; ?=0.01 ns @ 3 trials
75% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=REWRITTEN, type=RAW_ITERABLE} 8.25 ns; ?=0.02 ns @ 3 trials
75% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=REWRITTEN, type=RAW_ITERABLE} 8.67 ns; ?=0.03 ns @ 3 trials
76% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=REWRITTEN, type=RAW_ITERABLE} 37.81 ns; ?=0.07 ns @ 3 trials
76% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=REWRITTEN, type=RAW_ITERABLE} 35.63 ns; ?=0.38 ns @ 10 trials
77% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=REWRITTEN, type=RAW_ITERABLE} 37.77 ns; ?=0.02 ns @ 3 trials
77% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=REWRITTEN, type=RAW_ITERABLE} 35.74 ns; ?=0.08 ns @ 3 trials
78% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=REWRITTEN, type=RAW_ITERABLE} 39.37 ns; ?=0.38 ns @ 4 trials
78% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=REWRITTEN, type=RAW_ITERABLE} 35.66 ns; ?=0.33 ns @ 7 trials
78% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=REWRITTEN, type=RAW_ITERABLE} 7.73 ns; ?=0.00 ns @ 3 trials
79% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=REWRITTEN, type=RAW_ITERABLE} 7.81 ns; ?=0.02 ns @ 3 trials
79% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=REWRITTEN, type=RAW_ITERABLE} 202.90 ns; ?=1.98 ns @ 3 trials
80% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=REWRITTEN, type=RAW_ITERABLE} 64.50 ns; ?=0.25 ns @ 3 trials
80% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=REWRITTEN, type=RAW_MAP} 35.45 ns; ?=0.26 ns @ 3 trials
80% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=REWRITTEN, type=RAW_MAP} 37.82 ns; ?=0.43 ns @ 10 trials
81% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=REWRITTEN, type=RAW_MAP} 8.21 ns; ?=0.03 ns @ 3 trials
81% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=REWRITTEN, type=RAW_MAP} 8.68 ns; ?=0.03 ns @ 3 trials
82% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=REWRITTEN, type=RAW_MAP} 8.23 ns; ?=0.04 ns @ 3 trials
82% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=REWRITTEN, type=RAW_MAP} 8.70 ns; ?=0.02 ns @ 3 trials
83% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=REWRITTEN, type=RAW_MAP} 37.83 ns; ?=0.05 ns @ 3 trials
83% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=REWRITTEN, type=RAW_MAP} 35.49 ns; ?=0.05 ns @ 3 trials
83% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=REWRITTEN, type=RAW_MAP} 37.89 ns; ?=0.37 ns @ 3 trials
84% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=REWRITTEN, type=RAW_MAP} 35.38 ns; ?=0.16 ns @ 3 trials
84% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=REWRITTEN, type=RAW_MAP} 44.85 ns; ?=0.80 ns @ 10 trials
85% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=REWRITTEN, type=RAW_MAP} 35.16 ns; ?=0.10 ns @ 3 trials
85% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=REWRITTEN, type=RAW_MAP} 7.72 ns; ?=0.07 ns @ 3 trials
85% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=REWRITTEN, type=RAW_MAP} 7.82 ns; ?=0.08 ns @ 10 trials
86% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=REWRITTEN, type=RAW_MAP} 207.85 ns; ?=0.80 ns @ 3 trials
86% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=REWRITTEN, type=RAW_MAP} 64.29 ns; ?=0.12 ns @ 3 trials
87% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=REWRITTEN, type=STRING} 121.85 ns; ?=0.32 ns @ 3 trials
87% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=REWRITTEN, type=STRING} 137.45 ns; ?=0.80 ns @ 3 trials
88% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=REWRITTEN, type=STRING} 71.54 ns; ?=1.97 ns @ 10 trials
88% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=REWRITTEN, type=STRING} 61.50 ns; ?=0.52 ns @ 3 trials
88% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=REWRITTEN, type=STRING} 75.16 ns; ?=0.99 ns @ 10 trials
89% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=REWRITTEN, type=STRING} 61.27 ns; ?=0.23 ns @ 3 trials
89% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=REWRITTEN, type=STRING} 148.12 ns; ?=0.81 ns @ 3 trials
90% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=REWRITTEN, type=STRING} 121.77 ns; ?=0.40 ns @ 3 trials
90% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=REWRITTEN, type=STRING} 139.10 ns; ?=0.55 ns @ 3 trials
90% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=REWRITTEN, type=STRING} 121.71 ns; ?=0.64 ns @ 3 trials
91% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=REWRITTEN, type=STRING} 138.75 ns; ?=1.36 ns @ 7 trials
91% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=REWRITTEN, type=STRING} 121.53 ns; ?=2.03 ns @ 10 trials
92% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=REWRITTEN, type=STRING} 7.62 ns; ?=0.06 ns @ 3 trials
92% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=REWRITTEN, type=STRING} 7.83 ns; ?=0.06 ns @ 3 trials
93% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=REWRITTEN, type=STRING} 203.81 ns; ?=1.66 ns @ 3 trials
93% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=REWRITTEN, type=STRING} 63.19 ns; ?=0.15 ns @ 3 trials
93% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeIterable, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 525.82 ns; ?=3.07 ns @ 3 trials
94% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassIterable, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 587.79 ns; ?=1.73 ns @ 3 trials
94% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractCollection, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 308.89 ns; ?=2.39 ns @ 3 trials
95% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractCollection, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 261.45 ns; ?=0.49 ns @ 3 trials
95% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassAbstractList, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 305.52 ns; ?=1.97 ns @ 3 trials
95% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeAbstractList, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 261.17 ns; ?=0.79 ns @ 3 trials
96% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassCollection, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 591.90 ns; ?=2.59 ns @ 3 trials
96% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeCollection, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 526.51 ns; ?=0.70 ns @ 3 trials
97% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassList, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 591.91 ns; ?=5.76 ns @ 6 trials
97% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeList, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 525.84 ns; ?=1.70 ns @ 3 trials
98% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassSet, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 588.73 ns; ?=2.06 ns @ 3 trials
98% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeSet, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 524.91 ns; ?=1.71 ns @ 3 trials
98% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassStringBuilder, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 7.69 ns; ?=0.04 ns @ 3 trials
99% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeStringBuilder, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 7.82 ns; ?=0.02 ns @ 3 trials
99% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeByClassObject, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 203.65 ns; ?=1.76 ns @ 4 trials
100% Scenario{vm=java7, trial=0, benchmark=GetSuperTypeObject, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 64.53 ns; ?=0.16 ns @ 3 trials

                            type                             benchmark        ns linear runtime
                       CLONEABLE                  GetSuperTypeIterable    34.794 =
                       CLONEABLE           GetSuperTypeByClassIterable    38.031 =
                       CLONEABLE GetSuperTypeByClassAbstractCollection     8.199 =
                       CLONEABLE        GetSuperTypeAbstractCollection     8.669 =
                       CLONEABLE       GetSuperTypeByClassAbstractList     8.172 =
                       CLONEABLE              GetSuperTypeAbstractList     8.672 =
                       CLONEABLE         GetSuperTypeByClassCollection    37.851 =
                       CLONEABLE                GetSuperTypeCollection    35.239 =
                       CLONEABLE               GetSuperTypeByClassList    38.149 =
                       CLONEABLE                      GetSuperTypeList    35.419 =
                       CLONEABLE                GetSuperTypeByClassSet    37.851 =
                       CLONEABLE                       GetSuperTypeSet    35.202 =
                       CLONEABLE      GetSuperTypeByClassStringBuilder     7.662 =
                       CLONEABLE             GetSuperTypeStringBuilder     7.843 =
                       CLONEABLE             GetSuperTypeByClassObject   200.324 =
                       CLONEABLE                    GetSuperTypeObject    63.223 =
                          DOUBLE                  GetSuperTypeIterable     0.591 =
                          DOUBLE           GetSuperTypeByClassIterable     5.893 =
                          DOUBLE GetSuperTypeByClassAbstractCollection     5.888 =
                          DOUBLE        GetSuperTypeAbstractCollection     0.594 =
                          DOUBLE       GetSuperTypeByClassAbstractList     5.871 =
                          DOUBLE              GetSuperTypeAbstractList     0.592 =
                          DOUBLE         GetSuperTypeByClassCollection     5.863 =
                          DOUBLE                GetSuperTypeCollection     0.592 =
                          DOUBLE               GetSuperTypeByClassList     5.881 =
                          DOUBLE                      GetSuperTypeList     0.590 =
                          DOUBLE                GetSuperTypeByClassSet     5.859 =
                          DOUBLE                       GetSuperTypeSet     0.592 =
                          DOUBLE      GetSuperTypeByClassStringBuilder     5.853 =
                          DOUBLE             GetSuperTypeStringBuilder     0.578 =
                          DOUBLE             GetSuperTypeByClassObject     5.920 =
                          DOUBLE                    GetSuperTypeObject     0.592 =
                   ELIST_SUBTYPE                  GetSuperTypeIterable 10427.832 =============================
                   ELIST_SUBTYPE           GetSuperTypeByClassIterable 10285.586 =============================
                   ELIST_SUBTYPE GetSuperTypeByClassAbstractCollection 10170.182 ============================
                   ELIST_SUBTYPE        GetSuperTypeAbstractCollection 10224.993 ============================
                   ELIST_SUBTYPE       GetSuperTypeByClassAbstractList 10265.208 ============================
                   ELIST_SUBTYPE              GetSuperTypeAbstractList 10057.224 ============================
                   ELIST_SUBTYPE         GetSuperTypeByClassCollection 10620.533 ==============================
                   ELIST_SUBTYPE                GetSuperTypeCollection 10108.435 ============================
                   ELIST_SUBTYPE               GetSuperTypeByClassList 10483.422 =============================
                   ELIST_SUBTYPE                      GetSuperTypeList 10432.058 =============================
                   ELIST_SUBTYPE                GetSuperTypeByClassSet  1000.162 ==
                   ELIST_SUBTYPE                       GetSuperTypeSet   936.354 ==
                   ELIST_SUBTYPE      GetSuperTypeByClassStringBuilder     7.765 =
                   ELIST_SUBTYPE             GetSuperTypeStringBuilder     7.821 =
                   ELIST_SUBTYPE             GetSuperTypeByClassObject   205.656 =
                   ELIST_SUBTYPE                    GetSuperTypeObject    63.503 =
                             INT                  GetSuperTypeIterable     0.592 =
                             INT           GetSuperTypeByClassIterable     5.870 =
                             INT GetSuperTypeByClassAbstractCollection     5.860 =
                             INT        GetSuperTypeAbstractCollection     0.593 =
                             INT       GetSuperTypeByClassAbstractList     5.913 =
                             INT              GetSuperTypeAbstractList     0.592 =
                             INT         GetSuperTypeByClassCollection     5.910 =
                             INT                GetSuperTypeCollection     0.591 =
                             INT               GetSuperTypeByClassList     5.885 =
                             INT                      GetSuperTypeList     0.591 =
                             INT                GetSuperTypeByClassSet     5.915 =
                             INT                       GetSuperTypeSet     0.592 =
                             INT      GetSuperTypeByClassStringBuilder     5.912 =
                             INT             GetSuperTypeStringBuilder     0.592 =
                             INT             GetSuperTypeByClassObject     5.976 =
                             INT                    GetSuperTypeObject     0.594 =
                       INT_ARRAY                  GetSuperTypeIterable     7.342 =
                       INT_ARRAY           GetSuperTypeByClassIterable  1319.694 ===
                       INT_ARRAY GetSuperTypeByClassAbstractCollection  1364.201 ===
                       INT_ARRAY        GetSuperTypeAbstractCollection     7.203 =
                       INT_ARRAY       GetSuperTypeByClassAbstractList  1668.993 ====
                       INT_ARRAY              GetSuperTypeAbstractList     7.312 =
                       INT_ARRAY         GetSuperTypeByClassCollection  1218.405 ===
                       INT_ARRAY                GetSuperTypeCollection     9.394 =
                       INT_ARRAY               GetSuperTypeByClassList  1259.551 ===
                       INT_ARRAY                      GetSuperTypeList     7.208 =
                       INT_ARRAY                GetSuperTypeByClassSet  1234.280 ===
                       INT_ARRAY                       GetSuperTypeSet     7.191 =
                       INT_ARRAY      GetSuperTypeByClassStringBuilder  1385.018 ===
                       INT_ARRAY             GetSuperTypeStringBuilder     7.218 =
                       INT_ARRAY             GetSuperTypeByClassObject  1366.001 ===
                       INT_ARRAY                    GetSuperTypeObject    63.309 =
           INT_ARRAY_ARRAY_ARRAY                  GetSuperTypeIterable     7.019 =
           INT_ARRAY_ARRAY_ARRAY           GetSuperTypeByClassIterable  1264.420 ===
           INT_ARRAY_ARRAY_ARRAY GetSuperTypeByClassAbstractCollection  1144.050 ===
           INT_ARRAY_ARRAY_ARRAY        GetSuperTypeAbstractCollection     6.954 =
           INT_ARRAY_ARRAY_ARRAY       GetSuperTypeByClassAbstractList  1581.789 ====
           INT_ARRAY_ARRAY_ARRAY              GetSuperTypeAbstractList     7.063 =
           INT_ARRAY_ARRAY_ARRAY         GetSuperTypeByClassCollection  1299.119 ===
           INT_ARRAY_ARRAY_ARRAY                GetSuperTypeCollection     9.445 =
           INT_ARRAY_ARRAY_ARRAY               GetSuperTypeByClassList  1237.261 ===
           INT_ARRAY_ARRAY_ARRAY                      GetSuperTypeList     6.985 =
           INT_ARRAY_ARRAY_ARRAY                GetSuperTypeByClassSet  1356.060 ===
           INT_ARRAY_ARRAY_ARRAY                       GetSuperTypeSet     6.983 =
           INT_ARRAY_ARRAY_ARRAY      GetSuperTypeByClassStringBuilder  1183.257 ===
           INT_ARRAY_ARRAY_ARRAY             GetSuperTypeStringBuilder     6.967 =
           INT_ARRAY_ARRAY_ARRAY             GetSuperTypeByClassObject  1368.911 ===
           INT_ARRAY_ARRAY_ARRAY                    GetSuperTypeObject    63.180 =
                          OBJECT                  GetSuperTypeIterable    18.684 =
                          OBJECT           GetSuperTypeByClassIterable    19.347 =
                          OBJECT GetSuperTypeByClassAbstractCollection    19.482 =
                          OBJECT        GetSuperTypeAbstractCollection    19.388 =
                          OBJECT       GetSuperTypeByClassAbstractList    19.206 =
                          OBJECT              GetSuperTypeAbstractList    19.265 =
                          OBJECT         GetSuperTypeByClassCollection    19.689 =
                          OBJECT                GetSuperTypeCollection    18.737 =
                          OBJECT               GetSuperTypeByClassList    19.594 =
                          OBJECT                      GetSuperTypeList    18.845 =
                          OBJECT                GetSuperTypeByClassSet    19.803 =
                          OBJECT                       GetSuperTypeSet    18.790 =
                          OBJECT      GetSuperTypeByClassStringBuilder     7.649 =
                          OBJECT             GetSuperTypeStringBuilder     7.861 =
                          OBJECT             GetSuperTypeByClassObject     5.229 =
                          OBJECT                    GetSuperTypeObject     0.312 =
                    OBJECT_ARRAY                  GetSuperTypeIterable     7.247 =
                    OBJECT_ARRAY           GetSuperTypeByClassIterable  1139.815 ===
                    OBJECT_ARRAY GetSuperTypeByClassAbstractCollection  1227.397 ===
                    OBJECT_ARRAY        GetSuperTypeAbstractCollection     7.190 =
                    OBJECT_ARRAY       GetSuperTypeByClassAbstractList  1387.225 ===
                    OBJECT_ARRAY              GetSuperTypeAbstractList     7.204 =
                    OBJECT_ARRAY         GetSuperTypeByClassCollection  1116.158 ===
                    OBJECT_ARRAY                GetSuperTypeCollection     9.517 =
                    OBJECT_ARRAY               GetSuperTypeByClassList  1299.223 ===
                    OBJECT_ARRAY                      GetSuperTypeList     7.208 =
                    OBJECT_ARRAY                GetSuperTypeByClassSet  1202.070 ===
                    OBJECT_ARRAY                       GetSuperTypeSet     7.203 =
                    OBJECT_ARRAY      GetSuperTypeByClassStringBuilder  1135.125 ===
                    OBJECT_ARRAY             GetSuperTypeStringBuilder     7.190 =
                    OBJECT_ARRAY             GetSuperTypeByClassObject  1245.606 ===
                    OBJECT_ARRAY                    GetSuperTypeObject    63.135 =
                   RAW_ARRAYLIST                  GetSuperTypeIterable   183.558 =
                   RAW_ARRAYLIST           GetSuperTypeByClassIterable   201.441 =
                   RAW_ARRAYLIST GetSuperTypeByClassAbstractCollection   142.555 =
                   RAW_ARRAYLIST        GetSuperTypeAbstractCollection   131.916 =
                   RAW_ARRAYLIST       GetSuperTypeByClassAbstractList   129.523 =
                   RAW_ARRAYLIST              GetSuperTypeAbstractList   116.279 =
                   RAW_ARRAYLIST         GetSuperTypeByClassCollection   179.745 =
                   RAW_ARRAYLIST                GetSuperTypeCollection   167.420 =
                   RAW_ARRAYLIST               GetSuperTypeByClassList   238.422 =
                   RAW_ARRAYLIST                      GetSuperTypeList   216.368 =
                   RAW_ARRAYLIST                GetSuperTypeByClassSet   313.266 =
                   RAW_ARRAYLIST                       GetSuperTypeSet   291.449 =
                   RAW_ARRAYLIST      GetSuperTypeByClassStringBuilder     7.731 =
                   RAW_ARRAYLIST             GetSuperTypeStringBuilder     8.068 =
                   RAW_ARRAYLIST             GetSuperTypeByClassObject   201.055 =
                   RAW_ARRAYLIST                    GetSuperTypeObject    70.693 =
                  RAW_COMPARABLE                  GetSuperTypeIterable    36.602 =
                  RAW_COMPARABLE           GetSuperTypeByClassIterable    38.369 =
                  RAW_COMPARABLE GetSuperTypeByClassAbstractCollection     8.216 =
                  RAW_COMPARABLE        GetSuperTypeAbstractCollection     8.657 =
                  RAW_COMPARABLE       GetSuperTypeByClassAbstractList     8.192 =
                  RAW_COMPARABLE              GetSuperTypeAbstractList     8.600 =
                  RAW_COMPARABLE         GetSuperTypeByClassCollection    42.085 =
                  RAW_COMPARABLE                GetSuperTypeCollection    35.231 =
                  RAW_COMPARABLE               GetSuperTypeByClassList    38.218 =
                  RAW_COMPARABLE                      GetSuperTypeList    35.083 =
                  RAW_COMPARABLE                GetSuperTypeByClassSet    38.265 =
                  RAW_COMPARABLE                       GetSuperTypeSet    35.318 =
                  RAW_COMPARABLE      GetSuperTypeByClassStringBuilder     7.753 =
                  RAW_COMPARABLE             GetSuperTypeStringBuilder     7.736 =
                  RAW_COMPARABLE             GetSuperTypeByClassObject   201.242 =
                  RAW_COMPARABLE                    GetSuperTypeObject    64.198 =
               RAW_ELIST_SUBTYPE                  GetSuperTypeIterable   422.794 =
               RAW_ELIST_SUBTYPE           GetSuperTypeByClassIterable   454.429 =
               RAW_ELIST_SUBTYPE GetSuperTypeByClassAbstractCollection   344.285 =
               RAW_ELIST_SUBTYPE        GetSuperTypeAbstractCollection   314.382 =
               RAW_ELIST_SUBTYPE       GetSuperTypeByClassAbstractList   319.888 =
               RAW_ELIST_SUBTYPE              GetSuperTypeAbstractList   289.928 =
               RAW_ELIST_SUBTYPE         GetSuperTypeByClassCollection   424.174 =
               RAW_ELIST_SUBTYPE                GetSuperTypeCollection   391.173 =
               RAW_ELIST_SUBTYPE               GetSuperTypeByClassList   515.742 =
               RAW_ELIST_SUBTYPE                      GetSuperTypeList   480.211 =
               RAW_ELIST_SUBTYPE                GetSuperTypeByClassSet   994.196 ==
               RAW_ELIST_SUBTYPE                       GetSuperTypeSet   958.884 ==
               RAW_ELIST_SUBTYPE      GetSuperTypeByClassStringBuilder     7.700 =
               RAW_ELIST_SUBTYPE             GetSuperTypeStringBuilder     7.807 =
               RAW_ELIST_SUBTYPE             GetSuperTypeByClassObject   202.431 =
               RAW_ELIST_SUBTYPE                    GetSuperTypeObject    64.721 =
                    RAW_ITERABLE                  GetSuperTypeIterable     0.313 =
                    RAW_ITERABLE           GetSuperTypeByClassIterable     5.197 =
                    RAW_ITERABLE GetSuperTypeByClassAbstractCollection     8.239 =
                    RAW_ITERABLE        GetSuperTypeAbstractCollection     8.686 =
                    RAW_ITERABLE       GetSuperTypeByClassAbstractList     8.255 =
                    RAW_ITERABLE              GetSuperTypeAbstractList     8.673 =
                    RAW_ITERABLE         GetSuperTypeByClassCollection    37.807 =
                    RAW_ITERABLE                GetSuperTypeCollection    35.630 =
                    RAW_ITERABLE               GetSuperTypeByClassList    37.774 =
                    RAW_ITERABLE                      GetSuperTypeList    35.735 =
                    RAW_ITERABLE                GetSuperTypeByClassSet    39.374 =
                    RAW_ITERABLE                       GetSuperTypeSet    35.661 =
                    RAW_ITERABLE      GetSuperTypeByClassStringBuilder     7.735 =
                    RAW_ITERABLE             GetSuperTypeStringBuilder     7.808 =
                    RAW_ITERABLE             GetSuperTypeByClassObject   202.897 =
                    RAW_ITERABLE                    GetSuperTypeObject    64.501 =
                         RAW_MAP                  GetSuperTypeIterable    35.452 =
                         RAW_MAP           GetSuperTypeByClassIterable    37.821 =
                         RAW_MAP GetSuperTypeByClassAbstractCollection     8.213 =
                         RAW_MAP        GetSuperTypeAbstractCollection     8.683 =
                         RAW_MAP       GetSuperTypeByClassAbstractList     8.229 =
                         RAW_MAP              GetSuperTypeAbstractList     8.700 =
                         RAW_MAP         GetSuperTypeByClassCollection    37.830 =
                         RAW_MAP                GetSuperTypeCollection    35.493 =
                         RAW_MAP               GetSuperTypeByClassList    37.889 =
                         RAW_MAP                      GetSuperTypeList    35.385 =
                         RAW_MAP                GetSuperTypeByClassSet    44.847 =
                         RAW_MAP                       GetSuperTypeSet    35.157 =
                         RAW_MAP      GetSuperTypeByClassStringBuilder     7.721 =
                         RAW_MAP             GetSuperTypeStringBuilder     7.817 =
                         RAW_MAP             GetSuperTypeByClassObject   207.855 =
                         RAW_MAP                    GetSuperTypeObject    64.285 =
                          STRING                  GetSuperTypeIterable   121.848 =
                          STRING           GetSuperTypeByClassIterable   137.445 =
                          STRING GetSuperTypeByClassAbstractCollection    71.541 =
                          STRING        GetSuperTypeAbstractCollection    61.503 =
                          STRING       GetSuperTypeByClassAbstractList    75.161 =
                          STRING              GetSuperTypeAbstractList    61.269 =
                          STRING         GetSuperTypeByClassCollection   148.124 =
                          STRING                GetSuperTypeCollection   121.767 =
                          STRING               GetSuperTypeByClassList   139.102 =
                          STRING                      GetSuperTypeList   121.708 =
                          STRING                GetSuperTypeByClassSet   138.753 =
                          STRING                       GetSuperTypeSet   121.530 =
                          STRING      GetSuperTypeByClassStringBuilder     7.624 =
                          STRING             GetSuperTypeStringBuilder     7.828 =
                          STRING             GetSuperTypeByClassObject   203.814 =
                          STRING                    GetSuperTypeObject    63.189 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM                  GetSuperTypeIterable   525.818 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM           GetSuperTypeByClassIterable   587.792 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM GetSuperTypeByClassAbstractCollection   308.894 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM        GetSuperTypeAbstractCollection   261.452 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM       GetSuperTypeByClassAbstractList   305.520 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM              GetSuperTypeAbstractList   261.171 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM         GetSuperTypeByClassCollection   591.904 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM                GetSuperTypeCollection   526.508 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM               GetSuperTypeByClassList   591.905 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM                      GetSuperTypeList   525.840 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM                GetSuperTypeByClassSet   588.735 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM                       GetSuperTypeSet   524.915 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM      GetSuperTypeByClassStringBuilder     7.690 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM             GetSuperTypeStringBuilder     7.818 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM             GetSuperTypeByClassObject   203.648 =
XMEMBER_FEATURE_CALL_IMPL_CUSTOM                    GetSuperTypeObject    64.525 =

vm: java7
trial: 0
implementation: REWRITTEN

 */

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GetSuperTypeBenchmark extends TypeBasedSimpleBenchmark {
	
	public enum Impl {
		REWRITTEN {
			@Override
			LightweightTypeReference getSuperType(LightweightTypeReference typeReference, Class<?> type) {
				return typeReference.getSuperType(type);
			}
			
			@Override
			/* @Nullable */
			LightweightTypeReference getSuperType(LightweightTypeReference typeReference, JvmType rawType) {
				return typeReference.getSuperType(rawType);
			}
		},
//		BASELINE { 
//			// has to be executed against 2.4.2, otherwise the code would benefit from changes 
//			// that have been made under the covers
//			@Override
//			LightweightTypeReference getSuperType(LightweightTypeReference typeReference, Class<?> rawType) {
//				if (typeReference.isType(rawType)) {
//					return typeReference;
//				}
//				ITypeReferenceOwner owner = typeReference.getOwner();
//				JvmType type = owner.getServices().getTypeReferences().findDeclaredType(rawType, owner.getContextResourceSet());
//				if (type == null)
//					return null;
//				return typeReference.getSuperType(type);
//			}
//			
//			@Override
//			/* @Nullable */
//			LightweightTypeReference getSuperType(LightweightTypeReference typeReference, JvmType rawType) {
//				return typeReference.getSuperType(rawType);
//			}
//		},
		;
		abstract LightweightTypeReference getSuperType(LightweightTypeReference typeReference, JvmType type);
		abstract LightweightTypeReference getSuperType(LightweightTypeReference typeReference, Class<?> type);
	}

	@Param
	Impl implementation;

//	@Param
	Type type = Type.INT_ARRAY;

	private LightweightTypeReference typeReference;
	private JvmType abstractCollection;
	private JvmType abstractList;
	private JvmType collection;
	private JvmType iterable;
	private JvmType list;
	private JvmType object;
	private JvmType set;
	private JvmType stringBuilder;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		typeReference = getTypeReference(type);
		TypeReferences typeReferences = typeReference.getOwner().getServices().getTypeReferences();
		abstractCollection = typeReferences.findDeclaredType(AbstractCollection.class, typeReference.getType());
		abstractList = typeReferences.findDeclaredType(AbstractList.class, typeReference.getType());
		collection = typeReferences.findDeclaredType(Collection.class, typeReference.getType());
		iterable = typeReferences.findDeclaredType(Iterable.class, typeReference.getType());
		list = typeReferences.findDeclaredType(List.class, typeReference.getType());
		object = typeReferences.findDeclaredType(Object.class, typeReference.getType());
		set = typeReferences.findDeclaredType(Set.class, typeReference.getType());
		stringBuilder = typeReferences.findDeclaredType(StringBuilder.class, typeReference.getType());
		EcoreUtil.resolveAll(typeReference.getOwner().getContextResourceSet());
	}

	protected int doTimeGetSuperType(int reps, JvmType type) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.getSuperType(typeReference, type) != null) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}

	protected int doTimeGetSuperTypeByClass(int reps, Class<?> type) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.getSuperType(typeReference, type) != null) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}
	
	public int timeGetSuperTypeIterable(int reps) {
		return doTimeGetSuperType(reps, iterable);
	}
	
	public int timeGetSuperTypeByClassIterable(int reps) {
		return doTimeGetSuperTypeByClass(reps, Iterable.class);
	}
	
	public int timeGetSuperTypeByClassAbstractCollection(int reps) {
		return doTimeGetSuperTypeByClass(reps, AbstractCollection.class);
	}
	
	public int timeGetSuperTypeAbstractCollection(int reps) {
		return doTimeGetSuperType(reps, abstractCollection);
	}
	
	public int timeGetSuperTypeByClassAbstractList(int reps) {
		return doTimeGetSuperTypeByClass(reps, AbstractList.class);
	}
	
	public int timeGetSuperTypeAbstractList(int reps) {
		return doTimeGetSuperType(reps, abstractList);
	}
	
	public int timeGetSuperTypeByClassCollection(int reps) {
		return doTimeGetSuperTypeByClass(reps, Collection.class);
	}
	
	public int timeGetSuperTypeCollection(int reps) {
		return doTimeGetSuperType(reps, collection);
	}
	
	public int timeGetSuperTypeByClassList(int reps) {
		return doTimeGetSuperTypeByClass(reps, List.class);
	}
	
	public int timeGetSuperTypeList(int reps) {
		return doTimeGetSuperType(reps, list);
	}
	
	public int timeGetSuperTypeByClassSet(int reps) {
		return doTimeGetSuperTypeByClass(reps, Set.class);
	}
	
	public int timeGetSuperTypeSet(int reps) {
		return doTimeGetSuperType(reps, set);
	}
	
	public int timeGetSuperTypeByClassStringBuilder(int reps) {
		return doTimeGetSuperTypeByClass(reps, StringBuilder.class);
	}
	
	public int timeGetSuperTypeStringBuilder(int reps) {
		return doTimeGetSuperType(reps, stringBuilder);
	}
	
	public int timeGetSuperTypeByClassObject(int reps) {
		return doTimeGetSuperTypeByClass(reps, Object.class);
	}
	
	public int timeGetSuperTypeObject(int reps) {
		return doTimeGetSuperType(reps, object);
	}
	
	public static void main(String[] args) {
		Runner.main(GetSuperTypeBenchmark.class, args);
	}

}
