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

import org.eclipse.xtend.caliper.tests.parser.trial.XtendParser;
import org.eclipse.xtend.caliper.tests.parser.trial.XtendParserNoNotification;
import org.eclipse.xtend.core.XtendStandaloneSetup;
import org.eclipse.xtext.parser.IParser;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;
import com.google.common.io.CharStreams;
import com.google.inject.Injector;

/**
 

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