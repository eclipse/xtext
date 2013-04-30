/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.parser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.eclipse.xtend.caliper.tests.parser.edited.NewXtendParser;
import org.eclipse.xtend.caliper.tests.parser.minified.XtendParser;
import org.eclipse.xtend.caliper.tests.parser.minified.XtendParserNoNotification;
import org.eclipse.xtend.caliper.tests.parser.old.OldXtendParser;
import org.eclipse.xtend.core.XtendStandaloneSetup;
import org.eclipse.xtext.parser.IParser;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;
import com.google.common.io.CharStreams;
import com.google.inject.Injector;

/**
 0% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfAbstractTypeResolverTest.txt, implementation=Old} 34494241.38 ns; ?=555283.22 ns @ 10 trials
 1% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfAbstractTypeResolverTest.txt, implementation=Old} 28806985.29 ns; ?=428639.83 ns @ 10 trials
 2% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfAbstractTypeResolverTest.txt, implementation=Old} 29746166.67 ns; ?=1030607.62 ns @ 10 trials
 3% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfAnnotationProcessor.txt, implementation=Old} 979951.93 ns; ?=73972.19 ns @ 10 trials
 4% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfAnnotationProcessor.txt, implementation=Old} 868839.78 ns; ?=87349.47 ns @ 10 trials
 6% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfAnnotationProcessor.txt, implementation=Old} 895268.93 ns; ?=113952.26 ns @ 10 trials
 7% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfDataTypes.txt, implementation=Old} 17369352.94 ns; ?=48573.06 ns @ 3 trials
 8% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfDataTypes.txt, implementation=Old} 15195437.50 ns; ?=122312.52 ns @ 3 trials
 9% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfDataTypes.txt, implementation=Old} 13970793.65 ns; ?=1175089.50 ns @ 10 trials
10% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfJvmModelGenerator.txt, implementation=Old} 12604119.40 ns; ?=929652.84 ns @ 10 trials
11% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfJvmModelGenerator.txt, implementation=Old} 11154284.72 ns; ?=1013441.32 ns @ 10 trials
12% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfJvmModelGenerator.txt, implementation=Old} 11637696.97 ns; ?=1160482.31 ns @ 10 trials
13% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatter.txt, implementation=Old} 16401453.70 ns; ?=859453.38 ns @ 10 trials
14% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatter.txt, implementation=Old} 14129484.13 ns; ?=766822.00 ns @ 10 trials
16% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatter.txt, implementation=Old} 14610590.16 ns; ?=857691.26 ns @ 10 trials
17% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatterTest.txt, implementation=Old} 5027153.85 ns; ?=15293.24 ns @ 3 trials
18% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatterTest.txt, implementation=Old} 4421307.87 ns; ?=99548.95 ns @ 10 trials
19% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatterTest.txt, implementation=Old} 4633120.22 ns; ?=217445.68 ns @ 10 trials
20% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfAbstractTypeResolverTest.txt, implementation=Minified} 25803684.21 ns; ?=162184.62 ns @ 3 trials
21% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfAbstractTypeResolverTest.txt, implementation=Minified} 19739040.00 ns; ?=136723.78 ns @ 3 trials
22% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfAbstractTypeResolverTest.txt, implementation=Minified} 20122291.67 ns; ?=714865.58 ns @ 10 trials
23% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfAnnotationProcessor.txt, implementation=Minified} 868370.27 ns; ?=74175.95 ns @ 10 trials
24% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfAnnotationProcessor.txt, implementation=Minified} 753339.15 ns; ?=91063.35 ns @ 10 trials
26% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfAnnotationProcessor.txt, implementation=Minified} 780710.39 ns; ?=89006.84 ns @ 10 trials
27% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfDataTypes.txt, implementation=Minified} 13758246.15 ns; ?=731720.25 ns @ 10 trials
28% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfDataTypes.txt, implementation=Minified} 11419918.92 ns; ?=992678.09 ns @ 10 trials
29% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfDataTypes.txt, implementation=Minified} 12204802.82 ns; ?=866553.91 ns @ 10 trials
30% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfJvmModelGenerator.txt, implementation=Minified} 10198752.69 ns; ?=294929.29 ns @ 10 trials
31% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfJvmModelGenerator.txt, implementation=Minified} 8559442.31 ns; ?=430957.66 ns @ 10 trials
32% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfJvmModelGenerator.txt, implementation=Minified} 9321382.35 ns; ?=887588.64 ns @ 10 trials
33% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatter.txt, implementation=Minified} 13484149.25 ns; ?=712235.94 ns @ 10 trials
34% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatter.txt, implementation=Minified} 11208366.67 ns; ?=1030361.98 ns @ 10 trials
36% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatter.txt, implementation=Minified} 11931768.12 ns; ?=1115453.13 ns @ 10 trials
37% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatterTest.txt, implementation=Minified} 3828829.46 ns; ?=19171.26 ns @ 3 trials
38% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatterTest.txt, implementation=Minified} 3482985.51 ns; ?=27579.17 ns @ 3 trials
39% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatterTest.txt, implementation=Minified} 3510252.54 ns; ?=208534.89 ns @ 10 trials
40% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfAbstractTypeResolverTest.txt, implementation=MinifiedNoNotification} 25259888.74 ns; ?=336341.14 ns @ 10 trials
41% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfAbstractTypeResolverTest.txt, implementation=MinifiedNoNotification} 19173160.00 ns; ?=177274.90 ns @ 3 trials
42% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfAbstractTypeResolverTest.txt, implementation=MinifiedNoNotification} 18402110.26 ns; ?=180828.68 ns @ 6 trials
43% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfAnnotationProcessor.txt, implementation=MinifiedNoNotification} 837802.94 ns; ?=63699.93 ns @ 10 trials
44% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfAnnotationProcessor.txt, implementation=MinifiedNoNotification} 720188.88 ns; ?=79294.00 ns @ 10 trials
46% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfAnnotationProcessor.txt, implementation=MinifiedNoNotification} 753850.79 ns; ?=103729.58 ns @ 10 trials
47% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfDataTypes.txt, implementation=MinifiedNoNotification} 13103753.62 ns; ?=683938.05 ns @ 10 trials
48% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfDataTypes.txt, implementation=MinifiedNoNotification} 10799610.39 ns; ?=920447.06 ns @ 10 trials
49% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfDataTypes.txt, implementation=MinifiedNoNotification} 11351525.97 ns; ?=950723.82 ns @ 10 trials
50% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfJvmModelGenerator.txt, implementation=MinifiedNoNotification} 9757345.74 ns; ?=362832.97 ns @ 10 trials
51% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfJvmModelGenerator.txt, implementation=MinifiedNoNotification} 8168294.39 ns; ?=549776.09 ns @ 10 trials
52% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfJvmModelGenerator.txt, implementation=MinifiedNoNotification} 9143152.94 ns; ?=1093265.19 ns @ 10 trials
53% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatter.txt, implementation=MinifiedNoNotification} 13278571.52 ns; ?=874155.83 ns @ 10 trials
54% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatter.txt, implementation=MinifiedNoNotification} 10855615.38 ns; ?=865313.80 ns @ 10 trials
56% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatter.txt, implementation=MinifiedNoNotification} 11647304.05 ns; ?=806093.22 ns @ 10 trials
57% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatterTest.txt, implementation=MinifiedNoNotification} 3570677.12 ns; ?=49996.94 ns @ 10 trials
58% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatterTest.txt, implementation=MinifiedNoNotification} 3143081.97 ns; ?=75283.84 ns @ 10 trials
59% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatterTest.txt, implementation=MinifiedNoNotification} 3213296.61 ns; ?=70028.81 ns @ 10 trials
60% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfAbstractTypeResolverTest.txt, implementation=Current} 26967621.62 ns; ?=328693.22 ns @ 10 trials
61% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfAbstractTypeResolverTest.txt, implementation=Current} 21064550.00 ns; ?=150213.59 ns @ 3 trials
62% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfAbstractTypeResolverTest.txt, implementation=Current} 21059434.78 ns; ?=192477.83 ns @ 5 trials
63% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfAnnotationProcessor.txt, implementation=Current} 900616.22 ns; ?=71085.99 ns @ 10 trials
64% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfAnnotationProcessor.txt, implementation=Current} 806586.98 ns; ?=84795.61 ns @ 10 trials
66% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfAnnotationProcessor.txt, implementation=Current} 813358.19 ns; ?=96131.51 ns @ 10 trials
67% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfDataTypes.txt, implementation=Current} 15123048.39 ns; ?=591913.78 ns @ 10 trials
68% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfDataTypes.txt, implementation=Current} 12306767.61 ns; ?=894004.64 ns @ 10 trials
69% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfDataTypes.txt, implementation=Current} 12713146.15 ns; ?=1032789.49 ns @ 10 trials
70% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfJvmModelGenerator.txt, implementation=Current} 10978074.71 ns; ?=339684.21 ns @ 10 trials
71% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfJvmModelGenerator.txt, implementation=Current} 9604608.97 ns; ?=1108863.07 ns @ 10 trials
72% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfJvmModelGenerator.txt, implementation=Current} 10051107.59 ns; ?=947186.58 ns @ 10 trials
73% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatter.txt, implementation=Current} 14684088.71 ns; ?=687729.32 ns @ 10 trials
74% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatter.txt, implementation=Current} 12144309.86 ns; ?=865352.09 ns @ 10 trials
76% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatter.txt, implementation=Current} 12826301.47 ns; ?=866596.11 ns @ 10 trials
77% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatterTest.txt, implementation=Current} 4122844.30 ns; ?=70443.51 ns @ 10 trials
78% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatterTest.txt, implementation=Current} 3712755.91 ns; ?=22724.81 ns @ 3 trials
79% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatterTest.txt, implementation=Current} 3606375.52 ns; ?=209575.07 ns @ 10 trials
80% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfAbstractTypeResolverTest.txt, implementation=Edited} 26007092.11 ns; ?=258642.22 ns @ 6 trials
81% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfAbstractTypeResolverTest.txt, implementation=Edited} 20234406.25 ns; ?=309776.43 ns @ 10 trials
82% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfAbstractTypeResolverTest.txt, implementation=Edited} 20145447.92 ns; ?=616712.55 ns @ 10 trials
83% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfAnnotationProcessor.txt, implementation=Edited} 907009.62 ns; ?=66756.00 ns @ 10 trials
84% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfAnnotationProcessor.txt, implementation=Edited} 767181.86 ns; ?=87208.01 ns @ 10 trials
86% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfAnnotationProcessor.txt, implementation=Edited} 797019.19 ns; ?=109043.54 ns @ 10 trials
87% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfDataTypes.txt, implementation=Edited} 14366904.76 ns; ?=735430.96 ns @ 10 trials
88% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfDataTypes.txt, implementation=Edited} 12135652.78 ns; ?=868970.64 ns @ 10 trials
89% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfDataTypes.txt, implementation=Edited} 12306842.86 ns; ?=1067347.75 ns @ 10 trials
90% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfJvmModelGenerator.txt, implementation=Edited} 10632511.24 ns; ?=365111.35 ns @ 10 trials
91% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfJvmModelGenerator.txt, implementation=Edited} 9550786.59 ns; ?=979931.50 ns @ 10 trials
92% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfJvmModelGenerator.txt, implementation=Edited} 9645943.75 ns; ?=1111637.35 ns @ 10 trials
93% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatter.txt, implementation=Edited} 14010671.88 ns; ?=747935.18 ns @ 10 trials
94% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatter.txt, implementation=Edited} 11850890.41 ns; ?=876123.68 ns @ 10 trials
96% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatter.txt, implementation=Edited} 12473333.33 ns; ?=1069764.57 ns @ 10 trials
97% Scenario{vm=java6, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatterTest.txt, implementation=Edited} 3828724.21 ns; ?=62519.35 ns @ 10 trials
98% Scenario{vm=java7, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatterTest.txt, implementation=Edited} 3384010.49 ns; ?=73164.16 ns @ 10 trials
99% Scenario{vm=java8, trial=0, benchmark=ParseFile, fileName=CopyOfXbaseFormatterTest.txt, implementation=Edited} 3616927.01 ns; ?=16230.90 ns @ 3 trials

                          fileName    vm         implementation    us linear runtime
CopyOfAbstractTypeResolverTest.txt java6                    Old 34494 ==============================
CopyOfAbstractTypeResolverTest.txt java6               Minified 25804 ======================
CopyOfAbstractTypeResolverTest.txt java6 MinifiedNoNotification 25260 =====================
CopyOfAbstractTypeResolverTest.txt java6                Current 26968 =======================
CopyOfAbstractTypeResolverTest.txt java6                 Edited 26007 ======================
CopyOfAbstractTypeResolverTest.txt java7                    Old 28807 =========================
CopyOfAbstractTypeResolverTest.txt java7               Minified 19739 =================
CopyOfAbstractTypeResolverTest.txt java7 MinifiedNoNotification 19173 ================
CopyOfAbstractTypeResolverTest.txt java7                Current 21065 ==================
CopyOfAbstractTypeResolverTest.txt java7                 Edited 20234 =================
CopyOfAbstractTypeResolverTest.txt java8                    Old 29746 =========================
CopyOfAbstractTypeResolverTest.txt java8               Minified 20122 =================
CopyOfAbstractTypeResolverTest.txt java8 MinifiedNoNotification 18402 ================
CopyOfAbstractTypeResolverTest.txt java8                Current 21059 ==================
CopyOfAbstractTypeResolverTest.txt java8                 Edited 20145 =================
     CopyOfAnnotationProcessor.txt java6                    Old   980 =
     CopyOfAnnotationProcessor.txt java6               Minified   868 =
     CopyOfAnnotationProcessor.txt java6 MinifiedNoNotification   838 =
     CopyOfAnnotationProcessor.txt java6                Current   901 =
     CopyOfAnnotationProcessor.txt java6                 Edited   907 =
     CopyOfAnnotationProcessor.txt java7                    Old   869 =
     CopyOfAnnotationProcessor.txt java7               Minified   753 =
     CopyOfAnnotationProcessor.txt java7 MinifiedNoNotification   720 =
     CopyOfAnnotationProcessor.txt java7                Current   807 =
     CopyOfAnnotationProcessor.txt java7                 Edited   767 =
     CopyOfAnnotationProcessor.txt java8                    Old   895 =
     CopyOfAnnotationProcessor.txt java8               Minified   781 =
     CopyOfAnnotationProcessor.txt java8 MinifiedNoNotification   754 =
     CopyOfAnnotationProcessor.txt java8                Current   813 =
     CopyOfAnnotationProcessor.txt java8                 Edited   797 =
               CopyOfDataTypes.txt java6                    Old 17369 ===============
               CopyOfDataTypes.txt java6               Minified 13758 ===========
               CopyOfDataTypes.txt java6 MinifiedNoNotification 13104 ===========
               CopyOfDataTypes.txt java6                Current 15123 =============
               CopyOfDataTypes.txt java6                 Edited 14367 ============
               CopyOfDataTypes.txt java7                    Old 15195 =============
               CopyOfDataTypes.txt java7               Minified 11420 =========
               CopyOfDataTypes.txt java7 MinifiedNoNotification 10800 =========
               CopyOfDataTypes.txt java7                Current 12307 ==========
               CopyOfDataTypes.txt java7                 Edited 12136 ==========
               CopyOfDataTypes.txt java8                    Old 13971 ============
               CopyOfDataTypes.txt java8               Minified 12205 ==========
               CopyOfDataTypes.txt java8 MinifiedNoNotification 11352 =========
               CopyOfDataTypes.txt java8                Current 12713 ===========
               CopyOfDataTypes.txt java8                 Edited 12307 ==========
       CopyOfJvmModelGenerator.txt java6                    Old 12604 ==========
       CopyOfJvmModelGenerator.txt java6               Minified 10199 ========
       CopyOfJvmModelGenerator.txt java6 MinifiedNoNotification  9757 ========
       CopyOfJvmModelGenerator.txt java6                Current 10978 =========
       CopyOfJvmModelGenerator.txt java6                 Edited 10633 =========
       CopyOfJvmModelGenerator.txt java7                    Old 11154 =========
       CopyOfJvmModelGenerator.txt java7               Minified  8559 =======
       CopyOfJvmModelGenerator.txt java7 MinifiedNoNotification  8168 =======
       CopyOfJvmModelGenerator.txt java7                Current  9605 ========
       CopyOfJvmModelGenerator.txt java7                 Edited  9551 ========
       CopyOfJvmModelGenerator.txt java8                    Old 11638 ==========
       CopyOfJvmModelGenerator.txt java8               Minified  9321 ========
       CopyOfJvmModelGenerator.txt java8 MinifiedNoNotification  9143 =======
       CopyOfJvmModelGenerator.txt java8                Current 10051 ========
       CopyOfJvmModelGenerator.txt java8                 Edited  9646 ========
          CopyOfXbaseFormatter.txt java6                    Old 16401 ==============
          CopyOfXbaseFormatter.txt java6               Minified 13484 ===========
          CopyOfXbaseFormatter.txt java6 MinifiedNoNotification 13279 ===========
          CopyOfXbaseFormatter.txt java6                Current 14684 ============
          CopyOfXbaseFormatter.txt java6                 Edited 14011 ============
          CopyOfXbaseFormatter.txt java7                    Old 14129 ============
          CopyOfXbaseFormatter.txt java7               Minified 11208 =========
          CopyOfXbaseFormatter.txt java7 MinifiedNoNotification 10856 =========
          CopyOfXbaseFormatter.txt java7                Current 12144 ==========
          CopyOfXbaseFormatter.txt java7                 Edited 11851 ==========
          CopyOfXbaseFormatter.txt java8                    Old 14611 ============
          CopyOfXbaseFormatter.txt java8               Minified 11932 ==========
          CopyOfXbaseFormatter.txt java8 MinifiedNoNotification 11647 ==========
          CopyOfXbaseFormatter.txt java8                Current 12826 ===========
          CopyOfXbaseFormatter.txt java8                 Edited 12473 ==========
      CopyOfXbaseFormatterTest.txt java6                    Old  5027 ====
      CopyOfXbaseFormatterTest.txt java6               Minified  3829 ===
      CopyOfXbaseFormatterTest.txt java6 MinifiedNoNotification  3571 ===
      CopyOfXbaseFormatterTest.txt java6                Current  4123 ===
      CopyOfXbaseFormatterTest.txt java6                 Edited  3829 ===
      CopyOfXbaseFormatterTest.txt java7                    Old  4421 ===
      CopyOfXbaseFormatterTest.txt java7               Minified  3483 ===
      CopyOfXbaseFormatterTest.txt java7 MinifiedNoNotification  3143 ==
      CopyOfXbaseFormatterTest.txt java7                Current  3713 ===
      CopyOfXbaseFormatterTest.txt java7                 Edited  3384 ==
      CopyOfXbaseFormatterTest.txt java8                    Old  4633 ====
      CopyOfXbaseFormatterTest.txt java8               Minified  3510 ===
      CopyOfXbaseFormatterTest.txt java8 MinifiedNoNotification  3213 ==
      CopyOfXbaseFormatterTest.txt java8                Current  3606 ===
      CopyOfXbaseFormatterTest.txt java8                 Edited  3617 ===

 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserBenchmark extends SimpleBenchmark {

	@Param({ 
		"CopyOfAbstractTypeResolverTest.txt",
		"CopyOfAnnotationProcessor.txt",
		"CopyOfDataTypes.txt",
		"CopyOfJvmModelGenerator.txt",
		"CopyOfXbaseFormatter.txt", 
		"CopyOfXbaseFormatterTest.txt"
	})
	String fileName;

	@Param
	ParserImplementation implementation;

	enum ParserImplementation {
		Old {
			@Override
			IParser getParser(Injector injector) {
				return injector.getInstance(OldXtendParser.class);
			}
		},
		Minified {
			@Override
			IParser getParser(Injector injector) {
				return injector.getInstance(XtendParser.class);
			}
		},
		MinifiedNoNotification {
			@Override
			IParser getParser(Injector injector) {
				return injector.getInstance(XtendParserNoNotification.class);
			}
		},
		Current {
			@Override
			IParser getParser(Injector injector) {
				return injector.getInstance(IParser.class);
			}
		},
		Edited {
			@Override
			IParser getParser(Injector injector) {
				return injector.getInstance(NewXtendParser.class);
			}
		};
		abstract IParser getParser(Injector injector);
	}

	private String contentToParse;
	private IParser parser;

	public String loadString() {
		URL resource = ParserBenchmark.class.getResource(fileName);
		try {
			InputStreamReader reader = new InputStreamReader(resource.openStream(), Charset.forName("ISO-8859-1"));
			return CharStreams.toString(reader);
		} catch (IOException e) {
			throw new AssertionError(e);
		}
	}

	@Override
	protected void setUp() throws Exception {
		contentToParse = loadString();
		parser = implementation.getParser(new XtendStandaloneSetup().createInjectorAndDoEMFRegistration());
	}

	public int timeParseFile(int reps) throws Exception {
		int result = reps;
		for (int i = 0; i < reps; i++) {
			parser.parse(new StringReader(contentToParse));
			result += reps;
		}
		return result;
	}

	public static void main(String[] args) {
		Runner.main(ParserBenchmark.class, args);
	}

}