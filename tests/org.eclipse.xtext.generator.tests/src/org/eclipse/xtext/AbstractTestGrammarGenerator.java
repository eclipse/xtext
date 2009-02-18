/*******************************************************************************
 * __  ___            _   
 * \ \/ / |_ _____  __ |_
 *  \  /| __/ _ \ \/ / __|
 *  /  \| |_  __/>  <| |_
 * /_/\_\\__\___/_/\_\\__|
 * 
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.core.WorkflowFacade;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtext.util.Files;

public abstract class AbstractTestGrammarGenerator {

	private static Logger log = Logger.getLogger(GenerateAllTestGrammars.class);
	private String runtimeProject;

	public abstract Class<?>[] getTestGrammarClasses();

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

	protected void generateAll() {
		try {
			new StandaloneSetup().setPlatformUri("..");
			new XtextStandaloneSetup().createInjectorAndDoEMFRegistration();
			for (Class<?> c : getTestGrammarClasses()) {
				String filename = getGrammarFileNameAsURI(c);
				log.info("loading " + filename);
				Map<String, String> properties = new HashMap<String, String>();
				properties.put("grammarURI", filename);
				properties.put("runtimeProject", getRuntimeProject());
				if (getUiProject() != null) {
					properties.put("uiProject", getUiProject());
				}
				properties.put("file.extensions", c.getSimpleName().toLowerCase());
				modifyProperties(properties);
				WorkflowFacade workflowFacade = new WorkflowFacade(getWorkflow(), properties);
				workflowFacade.check();
				if (workflowFacade.getIssues().hasErrors()) {
					log.error("Errors checking workflow file :" + workflowFacade.getIssues());
					log.error("Aborting.");
				} else {
					workflowFacade.run();
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	protected void modifyProperties(Map<String, String> properties) {
	}

	protected abstract String getWorkflow();

	protected String getUiProject() {
		return null;
	}

	protected String getRuntimeProject() {
		return runtimeProject;
	}

	private static String[] defaultExcludes = new String[] { "CVS", ".cvsignore", ".svn" };

	public static String getGrammarFileNameAsURI(Class<?> c) {
		String filename = "classpath:/" + getGrammarFileName(c);
		return filename;
	}

	public static String getGrammarFileName(Class<?> c) {
		try {
			Method m = c.getMethod("getGrammarFileName");
			if (m != null && Modifier.isStatic(m.getModifiers()) && String.class.equals(m.getReturnType()))
				try {
					return ((String) m.invoke(null)).replace('.', '/') + ".xtext";
				} catch (Exception e) {
					log.error("Cannot invoke 'getGrammarFileName'", e);
				}
		} catch (NoSuchMethodException e) {
		}
		return c.getName().replace('.', '/') + ".xtext";
	}

	public AbstractTestGrammarGenerator(String[] args) {
		if (args != null && args.length == 1) {
			this.runtimeProject = args[0];
		} else {
			this.runtimeProject = ".";
		}
	}

}