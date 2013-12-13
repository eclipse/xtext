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
import java.io.StringReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendFlexer;
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;
import org.eclipse.xtend.core.parser.antlr.internal.FlexTokenSource;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;
import com.google.common.io.CharStreams;

/**
 
 0% Scenario{vm=java7, trial=0, benchmark=Lexing, fileName=CopyOfAbstractTypeResolverTest.txt} 62830260.87 ns; ?=577068.40 ns @ 5 trials
 6% Scenario{vm=java7, trial=0, benchmark=Flexing, fileName=CopyOfAbstractTypeResolverTest.txt} 1650701.47 ns; ?=20127.34 ns @ 10 trials
11% Scenario{vm=java7, trial=0, benchmark=FlexingWithoutTokens, fileName=CopyOfAbstractTypeResolverTest.txt} 1159555.43 ns; ?=11137.67 ns @ 3 trials
17% Scenario{vm=java7, trial=0, benchmark=Lexing, fileName=CopyOfAnnotationProcessor.txt} 2473051.24 ns; ?=4723.89 ns @ 3 trials
22% Scenario{vm=java7, trial=0, benchmark=Flexing, fileName=CopyOfAnnotationProcessor.txt} 46161.22 ns; ?=486.45 ns @ 10 trials
28% Scenario{vm=java7, trial=0, benchmark=FlexingWithoutTokens, fileName=CopyOfAnnotationProcessor.txt} 31919.75 ns; ?=76.16 ns @ 3 trials
33% Scenario{vm=java7, trial=0, benchmark=Lexing, fileName=CopyOfDataTypes.txt} 2483412.94 ns; ?=3431.14 ns @ 3 trials
39% Scenario{vm=java7, trial=0, benchmark=Flexing, fileName=CopyOfDataTypes.txt} 41518.37 ns; ?=225.65 ns @ 3 trials
44% Scenario{vm=java7, trial=0, benchmark=FlexingWithoutTokens, fileName=CopyOfDataTypes.txt} 27135.61 ns; ?=135.12 ns @ 3 trials
50% Scenario{vm=java7, trial=0, benchmark=Lexing, fileName=CopyOfJvmModelGenerator.txt} 28002094.34 ns; ?=85432.33 ns @ 3 trials
56% Scenario{vm=java7, trial=0, benchmark=Flexing, fileName=CopyOfJvmModelGenerator.txt} 486123.83 ns; ?=2784.60 ns @ 3 trials
61% Scenario{vm=java7, trial=0, benchmark=FlexingWithoutTokens, fileName=CopyOfJvmModelGenerator.txt} 336383.84 ns; ?=715.59 ns @ 3 trials
67% Scenario{vm=java7, trial=0, benchmark=Lexing, fileName=CopyOfXbaseFormatter.txt} 30478625.00 ns; ?=151099.45 ns @ 3 trials
72% Scenario{vm=java7, trial=0, benchmark=Flexing, fileName=CopyOfXbaseFormatter.txt} 556024.73 ns; ?=4677.08 ns @ 4 trials
78% Scenario{vm=java7, trial=0, benchmark=FlexingWithoutTokens, fileName=CopyOfXbaseFormatter.txt} 358377.24 ns; ?=1026.89 ns @ 3 trials
83% Scenario{vm=java7, trial=0, benchmark=Lexing, fileName=CopyOfXbaseFormatterTest.txt} 9741831.68 ns; ?=31586.97 ns @ 3 trials
89% Scenario{vm=java7, trial=0, benchmark=Flexing, fileName=CopyOfXbaseFormatterTest.txt} 227321.13 ns; ?=2941.55 ns @ 10 trials
94% Scenario{vm=java7, trial=0, benchmark=FlexingWithoutTokens, fileName=CopyOfXbaseFormatterTest.txt} 173917.16 ns; ?=373.22 ns @ 3 trials

           benchmark                           fileName      us linear runtime
              Lexing CopyOfAbstractTypeResolverTest.txt 62830.3 ==============================
              Lexing      CopyOfAnnotationProcessor.txt  2473.1 =
              Lexing                CopyOfDataTypes.txt  2483.4 =
              Lexing        CopyOfJvmModelGenerator.txt 28002.1 =============
              Lexing           CopyOfXbaseFormatter.txt 30478.6 ==============
              Lexing       CopyOfXbaseFormatterTest.txt  9741.8 ====
             Flexing CopyOfAbstractTypeResolverTest.txt  1650.7 =
             Flexing      CopyOfAnnotationProcessor.txt    46.2 =
             Flexing                CopyOfDataTypes.txt    41.5 =
             Flexing        CopyOfJvmModelGenerator.txt   486.1 =
             Flexing           CopyOfXbaseFormatter.txt   556.0 =
             Flexing       CopyOfXbaseFormatterTest.txt   227.3 =
FlexingWithoutTokens CopyOfAbstractTypeResolverTest.txt  1159.6 =
FlexingWithoutTokens      CopyOfAnnotationProcessor.txt    31.9 =
FlexingWithoutTokens                CopyOfDataTypes.txt    27.1 =
FlexingWithoutTokens        CopyOfJvmModelGenerator.txt   336.4 =
FlexingWithoutTokens           CopyOfXbaseFormatter.txt   358.4 =
FlexingWithoutTokens       CopyOfXbaseFormatterTest.txt   173.9 =


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

	private String contentToParse;
	private InternalXtendLexer lexer;
	private FlexTokenSource flexerTokenSource;
	private InternalXtendFlexer bareFlexer;

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
		lexer = new InternalXtendLexer(null);
		flexerTokenSource = new FlexTokenSource(null);
		bareFlexer = new InternalXtendFlexer();
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
	
	public int timeFlexing(int reps) throws Exception {
		int result = reps;
		for (int i = 0; i < reps; i++) {
			Token tok = null;
			flexerTokenSource.reset(new StringReader(contentToParse));
			while(tok != Token.EOF_TOKEN) {
				tok = flexerTokenSource.nextToken();
				result++;
			}
			result += reps;
		}
		return result;
	}
	
	public int timeFlexingWithoutTokens(int reps) throws Exception {
		int result = reps;
		for (int i = 0; i < reps; i++) {
			bareFlexer.yyreset(new StringReader(contentToParse));
			while(bareFlexer.advance() != Token.EOF) {
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