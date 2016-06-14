/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.compiler.batch;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.xtend.core.XtendInjectorSingleton;

import com.google.common.base.Joiner;
import com.google.inject.Injector;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class Main {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		Injector injector = XtendInjectorSingleton.INJECTOR;
		XtendBatchCompiler compiler = injector.getInstance(XtendBatchCompiler.class);
		if ((args == null) || (args.length == 0)) {
			printUsage();
			return;
		}
		Iterator<String> arguments = Arrays.asList(args).iterator();
		while (arguments.hasNext()) {
			String argument = arguments.next().trim();
			if ("-d".equals(argument)) {
				compiler.setOutputPath(arguments.next().trim());
			} else if ("-classpath".equals(argument) || "-cp".equals(argument)) {
				compiler.setClassPath(arguments.next().trim());
			} else if ("-tempdir".equals(argument) || "-td".equals(argument)) {
				compiler.setTempDirectory(arguments.next().trim());
			} else if ("-encoding".equals(argument)) {
				compiler.setFileEncoding(arguments.next().trim());
			} else if ("-javaSourceVersion".equals(argument)) {
				compiler.setJavaSourceVersion(arguments.next().trim());
			} else if ("-noSuppressWarningsAnnotation".equals(argument)) {
				compiler.setGenerateSyntheticSuppressWarnings(false);
			} else if ("-generateGeneratedAnnotation".equals(argument)) {
				compiler.setGenerateGeneratedAnnotation(true);
			} else if ("-includeDateInGeneratedAnnnotation".equals(argument)) {
				compiler.setIncludeDateInGeneratedAnnotation(true);
			} else if ("-generateAnnotationComment".equals(argument)) {
				compiler.setGeneratedAnnotationComment(arguments.next().trim());
			} else if ("-useCurrentClassLoader".equals(argument)) {
				compiler.setUseCurrentClassLoaderAsParent(true);
			} else if ("-writeTraceFiles".equals(argument)) {
				compiler.setWriteTraceFiles(true);
			} else {
				List<String> existingDirs = new ArrayList<String>(compiler.getSourcePathDirectories());
				existingDirs.add(argument);
				String pathes = Joiner.on(File.pathSeparator).join(existingDirs);
				compiler.setSourcePath(pathes);
			}
		}
		if (!compiler.compile()) {
			System.exit(1);
		}
	}

	private static void printUsage() {
		PrintStream out = System.out;
		out.println("Usage: Main <options> <source directories>");
		out.println("where possible options include:");
		out.println("-d <directory>                      Specify where to place generated xtend files");
		out.println("-tp <path>                          Temp directory to hold generated stubs and classes");
		out.println("-cp <path>                          Specify where to find user class files");
		out.println("-encoding <encoding>                Specify character encoding used by source files");
		out.println("-javaSourceVersion <version>        Create Java Source compatible to this version. Can be: 1.5, 1.6, 1.7 or 1.8");
		out.println("-noSuppressWarningsAnnotation       Don't put @SuppressWarnings() into generated Java Code");
		out.println("-generateGeneratedAnnotation        Put @Generated into generated Java Code");
		out.println("-includeDateInGeneratedAnnnotation  If -generateGeneratedAnnotation is used, add the current date/time.");
		out.println("-generateAnnotationComment <string> If -generateGeneratedAnnotation is used, add a comment.");
		out.println("-useCurrentClassLoader              Use current classloader as parent classloader");
		out.println("-writeTraceFiles                    Write Trace-Files");
	}

}
