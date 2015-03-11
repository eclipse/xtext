/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.parsing;

import java.io.StringReader;

import org.eclipse.xtend.core.XtendStandaloneSetup;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;
import com.google.inject.Injector;

/**
 * AT REVISED ANNOTATIONS PARSER RULE (incl comma lists without brackets) 

 0% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=1} 51124.82 ns; ?=771.78 ns @ 10 trials
17% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=1} 53618.13 ns; ?=525.38 ns @ 9 trials
33% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=1} 61143.48 ns; ?=588.76 ns @ 5 trials
50% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=6} 309884.62 ns; ?=13624.95 ns @ 10 trials
67% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=6} 1826206.80 ns; ?=117771.34 ns @ 10 trials
83% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=6} 510752000.00 ns; ?=310544503.20 ns @ 10 trials

 * AT REVISED ANNOTATIONS PARSER RULE (no comma lists without brackets) 

 0% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=1} 51377.22 ns; ?=354.21 ns @ 3 trials
17% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=1} 53498.13 ns; ?=550.38 ns @ 10 trials
33% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=1} 60599.44 ns; ?=876.47 ns @ 10 trials
50% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=6} 316482.14 ns; ?=16486.85 ns @ 10 trials
67% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=6} 1813146.89 ns; ?=71214.59 ns @ 10 trials
83% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=6} 504988000.00 ns; ?=59288878.61 ns @ 10 trials

 * AT JAVA MODIFIERS

 0% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=1} 51256.18 ns; ?=1255.28 ns @ 10 trials
17% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=1} 56160.07 ns; ?=673.09 ns @ 10 trials
33% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=1} 63294.23 ns; ?=969.74 ns @ 10 trials
50% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=6} 407342.82 ns; ?=23857.66 ns @ 10 trials
67% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=6} 2346562.75 ns; ?=37368.68 ns @ 10 trials
83% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=6} 661910000.00 ns; ?=28628085.54 ns @ 10 trials

 * AT IMPROVED LEXING PERF

 0% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=1} 53810.69 ns; ?=420.15 ns @ 3 trials
17% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=1} 54730.32 ns; ?=550.30 ns @ 10 trials
33% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=1} 61836.23 ns; ?=1126.73 ns @ 10 trials
50% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=6} 396213.87 ns; ?=20311.07 ns @ 10 trials
67% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=6} 2320401.46 ns; ?=92696.72 ns @ 10 trials
83% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=6} 636571000.00 ns; ?=32694434.44 ns @ 10 trials
 
 * AT DON'T ALLOW SUPER FOO 

 0% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=1} 80955.29 ns; ?=528.61 ns @ 3 trials
17% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=1} 91017.89 ns; ?=13173.43 ns @ 10 trials
33% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=1} 114103.11 ns; ?=2008.32 ns @ 10 trials
50% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=6} 877789.75 ns; ?=4956.51 ns @ 3 trials
67% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=6} 4584078.88 ns; ?=80908.19 ns @ 10 trials
83% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=6} 1085108000.00 ns; ?=9658044.37 ns @ 3 trials

 * AT ALLOW ALL EXPRESSIONS AS ANNOTATION VALUES (annotations valid, 2.5.0)

 0% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=1} 78804.94 ns; ?=930.99 ns @ 10 trials
17% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=1} 92100.78 ns; ?=3769.27 ns @ 10 trials
33% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=1} 114080.94 ns; ?=1865.12 ns @ 10 trials
50% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=6} 845277.33 ns; ?=35734.64 ns @ 10 trials
67% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=6} 4569695.91 ns; ?=103459.85 ns @ 10 trials
83% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=6} 982557000.00 ns; ?=43172424.03 ns @ 10 trials

 * AT ALLOW IDENTIFIER SYNTAX AS IN JAVA (annotations still invalid)

 0% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=1} 100624.28 ns; ?=5475.24 ns @ 10 trials
17% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=1} 117995.79 ns; ?=2830.89 ns @ 10 trials
33% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=1} 170302.38 ns; ?=32626.61 ns @ 10 trials
50% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=6} 1088375.00 ns; ?=22064.12 ns @ 10 trials
67% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=6} 6214903.85 ns; ?=254083.02 ns @ 10 trials
83% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=6} 1425079000.00 ns; ?=268856041.25 ns @ 10 trials

 * AT SMOOTHER TRANSITION FOR JAVA DEVS (baseline, comparable to 2.4.2)

 0% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=1} 72943.54 ns; ?=2297.26 ns @ 10 trials
17% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=1} 85119.72 ns; ?=2319.18 ns @ 10 trials
33% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=1} 122830.17 ns; ?=5355.27 ns @ 10 trials
50% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=1, numberOfAnnotations=6} 722243.16 ns; ?=26346.09 ns @ 10 trials
67% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=2, numberOfAnnotations=6} 4070780.33 ns; ?=136512.32 ns @ 10 trials
83% Scenario{vm=java7, trial=0, benchmark=AnnotationValueParsing, nestingLevel=5, numberOfAnnotations=6} 944561000.00 ns; ?=276236123.07 ns @ 10 trials

 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AnnotationValueParserBenchmark extends SimpleBenchmark {

	@Param({ 
		"1", "2", "5"
	})
	int nestingLevel;
	
	@Param({ 
		"1", "6"
	})
	int numberOfAnnotations;
	
	private String contentToParse;
	private IParser parser;

	@Override
	protected void setUp() throws Exception {
		StringBuilder contentToParse = new StringBuilder();
		for(int i = 0; i < numberOfAnnotations; i++) {
			contentToParse.append("@A(#[");
			appendNested(contentToParse, nestingLevel);
			contentToParse.append("])");
		}
		contentToParse.append("class X {}");
		this.contentToParse = contentToParse.toString();
		
		Injector injector = new XtendStandaloneSetup().createInjectorAndDoEMFRegistration();
		
		parser = injector.getInstance(IParser.class);
	}

	private void appendNested(StringBuilder result, int nestingLevel) {
		if (nestingLevel == 0) {
			result.append("'value'");
		} else {
			for(int i = 0; i < numberOfAnnotations; i++) {
				if (i != 0) {
					result.append(",");
				}
				result.append("@B(#[");
				appendNested(result, nestingLevel - 1);
				result.append("])");
			}
		}
	}

	public int timeAnnotationValueParsing(int reps) throws Exception {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			StringReader reader = new StringReader(contentToParse);
			IParseResult parseResult = parser.parse(reader);
			result += parseResult.getRootNode().getLength();
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		Runner.main(AnnotationValueParserBenchmark.class, args);
	}

}