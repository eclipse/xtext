/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.eclipse.xtext.util.Files;

public class GeneratorUtil {
	
	private static Logger log = Logger.getLogger(GeneratorUtil.class);
	private static String[] defaultExcludes = new String[] { "CVS", ".cvsignore", ".svn" };
	
	public static void cleanFolder(String srcGenPath) throws FileNotFoundException {
		File f = new File(srcGenPath);
		if (!f.exists())
			throw new FileNotFoundException(srcGenPath + " " + f.getAbsolutePath());
		log.info("Cleaning folder " + f.getPath());
		Files.cleanFolder(f, new FileFilter() {
			private final Collection<String> excludes = new HashSet<String>(Arrays.asList(defaultExcludes));
			public boolean accept(File pathname) {
				return !excludes.contains(pathname.getName());
			}
		}, false, false);
	}
}
