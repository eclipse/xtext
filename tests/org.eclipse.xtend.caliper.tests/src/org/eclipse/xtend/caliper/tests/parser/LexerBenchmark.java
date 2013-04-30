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
import java.net.URL;
import java.nio.charset.Charset;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.eclipse.xtend.caliper.tests.parser.noUnicode.InternalXtendLexerNoUnicode;
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;
import org.eclipse.xtext.parser.antlr.Lexer;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;
import com.google.common.io.CharStreams;

/**
 

 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LexerBenchmark extends SimpleBenchmark {

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
	LexerImplementation implementation;

	enum LexerImplementation {
		Current {
			@Override
			Lexer getLexer() {
				return new InternalXtendLexer(null);
			}
		},
		NoUnicode {
			@Override
			Lexer getLexer() {
				return new InternalXtendLexerNoUnicode(null);
			}
		};
		abstract Lexer getLexer();
	}

	private String contentToParse;
	private Lexer lexer;

	public String loadString() {
		URL resource = LexerBenchmark.class.getResource(fileName);
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
		lexer = implementation.getLexer();
	}

	public int timeLexing(int reps) throws Exception {
		int result = reps;
		for (int i = 0; i < reps; i++) {
			Token tok = null;
			lexer.setCharStream(new ANTLRStringStream(contentToParse));
			while(tok != Token.EOF_TOKEN) {
				tok = lexer.nextToken();
				result++;
			}
			result += reps;
		}
		return result;
	}

	public static void main(String[] args) {
		Runner.main(LexerBenchmark.class, args);
	}

}