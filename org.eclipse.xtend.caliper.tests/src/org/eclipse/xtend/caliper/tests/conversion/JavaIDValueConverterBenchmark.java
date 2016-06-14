/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.conversion;

import org.eclipse.xtend.core.conversion.JavaIDValueConverter;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

/*

 0% Scenario{vm=java7, trial=0, benchmark=ToValue, id=a, implementation=New} 4.04 ns; ?=0.09 ns @ 10 trials
 3% Scenario{vm=java7, trial=0, benchmark=ToValue, id=ABCDEF, implementation=New} 7.54 ns; ?=0.14 ns @ 10 trials
 6% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghij, implementation=New} 6.64 ns; ?=0.15 ns @ 10 trials
 9% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghijfawjoiug, implementation=New} 9.84 ns; ?=0.16 ns @ 10 trials
12% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghijklmnopqrstuvwxyz, implementation=New} 12.29 ns; ?=0.32 ns @ 10 trials
15% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghijklmnopqrstuvwxyzABCDEFGHAIEHFAIEWFK2ff, implementation=New} 23.38 ns; ?=0.66 ns @ 10 trials
18% Scenario{vm=java7, trial=0, benchmark=ToValue, id=\u0050, implementation=New} 58.54 ns; ?=1.02 ns @ 10 trials
21% Scenario{vm=java7, trial=0, benchmark=ToValue, id=a\u0050, implementation=New} 60.72 ns; ?=0.60 ns @ 4 trials
24% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghij\u0050, implementation=New} 67.84 ns; ?=0.29 ns @ 3 trials
27% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghijklm\u0050nopqrstuvwxyz, implementation=New} 132.96 ns; ?=1.84 ns @ 10 trials
30% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghijklmnopqrstuvwxyz\u0050, implementation=New} 75.22 ns; ?=0.75 ns @ 10 trials
33% Scenario{vm=java7, trial=0, benchmark=ToValue, id=a, implementation=Old} 37.84 ns; ?=0.46 ns @ 10 trials
36% Scenario{vm=java7, trial=0, benchmark=ToValue, id=ABCDEF, implementation=Old} 60.71 ns; ?=0.37 ns @ 3 trials
39% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghij, implementation=Old} 78.45 ns; ?=0.78 ns @ 7 trials
42% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghijfawjoiug, implementation=Old} 107.47 ns; ?=0.95 ns @ 3 trials
45% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghijklmnopqrstuvwxyz, implementation=Old} 137.68 ns; ?=0.90 ns @ 3 trials
48% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghijklmnopqrstuvwxyzABCDEFGHAIEHFAIEWFK2ff, implementation=Old} 223.35 ns; ?=0.78 ns @ 3 trials
52% Scenario{vm=java7, trial=0, benchmark=ToValue, id=\u0050, implementation=Old} 56.14 ns; ?=0.79 ns @ 10 trials
55% Scenario{vm=java7, trial=0, benchmark=ToValue, id=a\u0050, implementation=Old} 65.11 ns; ?=0.47 ns @ 3 trials
58% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghij\u0050, implementation=Old} 91.86 ns; ?=0.64 ns @ 3 trials
61% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghijklm\u0050nopqrstuvwxyz, implementation=Old} 150.49 ns; ?=1.33 ns @ 5 trials
64% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghijklmnopqrstuvwxyz\u0050, implementation=Old} 144.80 ns; ?=0.08 ns @ 3 trials
67% Scenario{vm=java7, trial=0, benchmark=ToValue, id=a, implementation=NOOP} 2.41 ns; ?=0.02 ns @ 3 trials
70% Scenario{vm=java7, trial=0, benchmark=ToValue, id=ABCDEF, implementation=NOOP} 5.77 ns; ?=0.14 ns @ 10 trials
73% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghij, implementation=NOOP} 6.06 ns; ?=0.09 ns @ 10 trials
76% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghijfawjoiug, implementation=NOOP} 8.80 ns; ?=0.15 ns @ 10 trials
79% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghijklmnopqrstuvwxyz, implementation=NOOP} 11.89 ns; ?=0.07 ns @ 3 trials
82% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghijklmnopqrstuvwxyzABCDEFGHAIEHFAIEWFK2ff, implementation=NOOP} 20.81 ns; ?=0.28 ns @ 10 trials
85% Scenario{vm=java7, trial=0, benchmark=ToValue, id=\u0050, implementation=NOOP} 1.51 ns; ?=0.02 ns @ 10 trials
88% Scenario{vm=java7, trial=0, benchmark=ToValue, id=a\u0050, implementation=NOOP} 2.72 ns; ?=0.03 ns @ 10 trials
91% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghij\u0050, implementation=NOOP} 6.38 ns; ?=0.06 ns @ 9 trials
94% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghijklm\u0050nopqrstuvwxyz, implementation=NOOP} 6.69 ns; ?=0.12 ns @ 10 trials
97% Scenario{vm=java7, trial=0, benchmark=ToValue, id=abcdefghijklmnopqrstuvwxyz\u0050, implementation=NOOP} 11.72 ns; ?=0.19 ns @ 10 trials

implementation                                               id     ns linear runtime
           New                                                a   4.04 =
           New                                           ABCDEF   7.54 =
           New                                       abcdefghij   6.64 =
           New                               abcdefghijfawjoiug   9.84 =
           New                       abcdefghijklmnopqrstuvwxyz  12.29 =
           New abcdefghijklmnopqrstuvwxyzABCDEFGHAIEHFAIEWFK2ff  23.38 ===
           New                                           \u0050  58.54 =======
           New                                          a\u0050  60.72 ========
           New                                 abcdefghij\u0050  67.84 =========
           New                 abcdefghijklm\u0050nopqrstuvwxyz 132.96 =================
           New                 abcdefghijklmnopqrstuvwxyz\u0050  75.22 ==========
           Old                                                a  37.84 =====
           Old                                           ABCDEF  60.71 ========
           Old                                       abcdefghij  78.45 ==========
           Old                               abcdefghijfawjoiug 107.47 ==============
           Old                       abcdefghijklmnopqrstuvwxyz 137.68 ==================
           Old abcdefghijklmnopqrstuvwxyzABCDEFGHAIEHFAIEWFK2ff 223.35 ==============================
           Old                                           \u0050  56.14 =======
           Old                                          a\u0050  65.11 ========
           Old                                 abcdefghij\u0050  91.86 ============
           Old                 abcdefghijklm\u0050nopqrstuvwxyz 150.49 ====================
           Old                 abcdefghijklmnopqrstuvwxyz\u0050 144.80 ===================
          NOOP                                                a   2.41 =
          NOOP                                           ABCDEF   5.77 =
          NOOP                                       abcdefghij   6.06 =
          NOOP                               abcdefghijfawjoiug   8.80 =
          NOOP                       abcdefghijklmnopqrstuvwxyz  11.89 =
          NOOP abcdefghijklmnopqrstuvwxyzABCDEFGHAIEHFAIEWFK2ff  20.81 ==
          NOOP                                           \u0050   1.51 =
          NOOP                                          a\u0050   2.72 =
          NOOP                                 abcdefghij\u0050   6.38 =
          NOOP                 abcdefghijklm\u0050nopqrstuvwxyz   6.69 =
          NOOP                 abcdefghijklmnopqrstuvwxyz\u0050  11.72 =

 */

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaIDValueConverterBenchmark extends SimpleBenchmark {

	enum Implementation {
		New {
			@Override
			String parsedStringToValue(String s) {
				return JavaIDValueConverter.convertFromJavaIdentifier(s, null);
			}
		},
		Old {

			@Override
			String parsedStringToValue(String s) {
				return OldJavaIDValueConverter.convertFromJavaIdentifier(s, null);
			}
		},
		NOOP {
			@Override
			String parsedStringToValue(String s) {
				s.indexOf('\\');
				return s;
			}
		};
		abstract String parsedStringToValue(String s);
	}
	
	@Param
	Implementation implementation;
	
	@Param({ 
		"a",
		"ABCDEF",
		"abcdefghij",
		"abcdefghijfawjoiug",
		"abcdefghijklmnopqrstuvwxyz",
		"abcdefghijklmnopqrstuvwxyzABCDEFGHAIEHFAIEWFK2ff",
		"\\u0050",
		"a\\u0050",
		"abcdefghij\\u0050",
		"abcdefghijklm\\u0050nopqrstuvwxyz",
		"abcdefghijklmnopqrstuvwxyz\\u0050",
	})
	String id;
	
	public int timeToValue(int reps) throws Exception {
		int result = reps;
		for(int i = 0; i < reps; i++) {
			result += implementation.parsedStringToValue(id).length();
		}
		return result;
	}

	public static void main(String[] args) {
		Runner.main(JavaIDValueConverterBenchmark.class, args);
	}

	
}
