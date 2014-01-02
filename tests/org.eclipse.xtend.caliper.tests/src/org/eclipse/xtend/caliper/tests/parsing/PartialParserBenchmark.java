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
import org.eclipse.xtend.core.parser.ParserWithoutPartialParsing;
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

/**
 
Task 'with    - CopyOfAnnotationProcessor.txt' took 136ms (1 measurements).
Task 'without - CopyOfAnnotationProcessor.txt' took 5089ms (1 measurements).
Task 'with    - CopyOfDataTypes.txt' took 93ms (1 measurements).
Task 'without - CopyOfDataTypes.txt' took 2834ms (1 measurements).
Task 'with    - CopyOfJvmModelGenerator.txt' took 7323ms (1 measurements).
Task 'without - CopyOfJvmModelGenerator.txt' took 366623ms (1 measurements).

 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PartialParserBenchmark {

	public static class ParserWithPartialParsing extends ParserWithoutPartialParsing {
		
		@Override
		protected boolean isReparseSupported() {
			return true;
		}
		
	}
	
	private String contentToParse;
	
	@Inject
	private ParserWithPartialParsing withPartialParsing;
	
	@Inject
	private ParserWithoutPartialParsing withoutPartialParsing;

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
		parseResult = withoutPartialParsing.doParse(contentToParse);
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

	public int timeWithPartialParsing() throws Exception {
		System.out.println("with - " + fileName);
		StoppedTask task = Stopwatches.forTask("with    - " + fileName);
		try {
			task.start();
			return doTime(withPartialParsing, 1);
		} finally {
			task.stop();
			System.out.println("done");
		}
	}
	
	public int timeWithoutPartialParsing() throws Exception {
		System.out.println("without - " + fileName);
		StoppedTask task = Stopwatches.forTask("without - " + fileName);
		try {
			task.start();
			return doTime(withoutPartialParsing, 1);
		} finally {
			task.stop();
			System.out.println("done");
		}
	}
	
	public static void main(String[] args) throws Exception {
		String[] fileNames = { 
//			"CopyOfAbstractTypeResolverTest.txt",
			"CopyOfAnnotationProcessor.txt",
			"CopyOfDataTypes.txt",
			"CopyOfJvmModelGenerator.txt",
//			"CopyOfXbaseFormatter.txt", 
//			"CopyOfXbaseFormatterTest.txt"
		};
		Injector injector = new XtendStandaloneSetup().createInjectorAndDoEMFRegistration();
		Stopwatches.setEnabled(true);
		for(String fileName: fileNames) {
			PartialParserBenchmark benchmark = new PartialParserBenchmark(fileName);
			injector.injectMembers(benchmark);
			benchmark.setUp();
			System.out.println(benchmark.timeWithPartialParsing());
			System.out.println(benchmark.timeWithoutPartialParsing());
		}
		System.out.println(Stopwatches.getPrintableStopwatchData());
	}

}