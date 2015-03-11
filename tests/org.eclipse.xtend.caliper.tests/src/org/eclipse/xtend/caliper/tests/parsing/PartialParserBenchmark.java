/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.parsing;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.eclipse.xtend.core.XtendStandaloneSetup;
import org.eclipse.xtend.core.parser.CustomXtendParser;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.google.inject.Inject;
import com.google.inject.Injector;

/*

Sebastian - 2014/01/02 - Baseline
-------------------------------------------------------------------------------------------------------------------------
Task 'with    - CopyOfAnnotationProcessor.txt' took 136ms (1 measurements).
Task 'without - CopyOfAnnotationProcessor.txt' took 5089ms (1 measurements).
Task 'with    - CopyOfDataTypes.txt' took 93ms (1 measurements).
Task 'without - CopyOfDataTypes.txt' took 2834ms (1 measurements).
Task 'with    - CopyOfJvmModelGenerator.txt' took 7323ms (1 measurements).
Task 'without - CopyOfJvmModelGenerator.txt' took 366623ms (1 measurements).
-------------------------------------------------------------------------------------------------------------------------
Sebastian - 2014/01/02 - Partial parsing selectively enabled
-------------------------------------------------------------------------------------------------------------------------
Task 'CopyOfAbstractTypeResolverTest.txt' took 142217ms (1 measurements).
Task 'CopyOfAnnotationProcessor.txt' took 113ms (1 measurements).
Task 'CopyOfDataTypes.txt' took 67ms (1 measurements).
Task 'CopyOfJvmModelGenerator.txt' took 11426ms (1 measurements).
Task 'CopyOfXbaseFormatter.txt' took 15250ms (1 measurements).
Task 'CopyOfXbaseFormatterTest.txt' took 3144ms (1 measurements).
-------------------------------------------------------------------------------------------------------------------------

 */
public class PartialParserBenchmark {

	private String contentToParse;
	
	@Inject
	private CustomXtendParser parser;

	private IParseResult parseResult;

	private final String fileName;

	PartialParserBenchmark(String fileName) {
		this.fileName = fileName;
	}
	
	private static String loadString(String fileName) {
		URL resource = PartialParserBenchmark.class.getResource(fileName);
		try {
			InputStreamReader reader = new InputStreamReader(resource.openStream(), Charsets.ISO_8859_1);
			return CharStreams.toString(reader);
		} catch (IOException e) {
			throw new AssertionError(e);
		}
	}

	protected void setUp() {
		contentToParse = loadString(fileName);
		parseResult = parser.doParse(contentToParse);
	}
	
	public int doTime(IParser parser, int windowSize) {
		int result = 0;
		for (int j = 0; j < contentToParse.length() - windowSize; j++) {
			ReplaceRegion replaceRegion = new ReplaceRegion(new TextRegion(j, windowSize), contentToParse.substring(j, j + windowSize));
			IParseResult newParseResult = parser.reparse(parseResult, replaceRegion);
			if (newParseResult.getRootASTElement() != null) {
				result ++;
			}
		}
		return result;
	}

	public int measure() throws Exception {
		System.out.println(fileName);
		StoppedTask task = Stopwatches.forTask(fileName);
		try {
			task.start();
			return doTime(parser, 1);
		} finally {
			task.stop();
			System.out.println("done");
		}
	}
	
	public static void main(String[] args) throws Exception {
		String[] fileNames = { 
			"CopyOfAbstractTypeResolverTest.txt",
			"CopyOfAnnotationProcessor.txt",
			"CopyOfDataTypes.txt",
			"CopyOfJvmModelGenerator.txt",
			"CopyOfXbaseFormatter.txt", 
			"CopyOfXbaseFormatterTest.txt"
		};
		Injector injector = new XtendStandaloneSetup().createInjectorAndDoEMFRegistration();
		Stopwatches.setEnabled(true);
		for(String fileName: fileNames) {
			PartialParserBenchmark benchmark = new PartialParserBenchmark(fileName);
			injector.injectMembers(benchmark);
			benchmark.setUp();
			benchmark.measure();
		}
		System.out.println(Stopwatches.getPrintableStopwatchData());
	}

}