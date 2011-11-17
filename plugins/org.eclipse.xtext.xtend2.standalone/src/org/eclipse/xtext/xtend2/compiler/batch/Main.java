/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.compiler.batch;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.xtext.xtend2.Xtend2StandaloneSetup;

import com.google.inject.Injector;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class Main {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		Injector injector = new Xtend2StandaloneSetup().createInjectorAndDoEMFRegistration();
		Xtend2BatchCompiler xtend2BatchCompiler = injector.getInstance(Xtend2BatchCompiler.class);
		if ((args == null) || (args.length == 0)) {
			printUsage();
			return;
		}
		Iterator<String> arguments = Arrays.asList(args).iterator();
		while (arguments.hasNext()) {
			String argument = arguments.next();
			if ("-d".equals(argument.trim())) {
				xtend2BatchCompiler.setOutputPath(arguments.next().trim());
			} else if ("-classpath".equals(argument.trim()) || "-cp".equals(argument.trim())) {
				xtend2BatchCompiler.setClassPath(arguments.next().trim());
			} else {
				xtend2BatchCompiler.setSourcePath(argument);
			}
		}
		xtend2BatchCompiler.compile();
	}
	
	private static void printUsage() {
		System.out.println("Usage: Xtend2BatchCompiler <options> <source directories>");
		System.out.println("where possible options include:");
		System.out.println("-d <directory>             Specify where to place generated xtend files");
		System.out.println("-cp <path>                 Specify where to find user class files");
	}

}
