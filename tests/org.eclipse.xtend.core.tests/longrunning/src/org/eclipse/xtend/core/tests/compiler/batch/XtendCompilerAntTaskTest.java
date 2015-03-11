/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler.batch;

import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintStream;

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.BuildListener;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
import org.apache.tools.ant.types.selectors.FilenameSelector;
import org.eclipse.pde.core.plugin.TargetPlatform;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendCompilerAntTaskTest {
	protected Project project;
	private StringBuffer outBuffer;
	private StringBuffer errBuffer;
	private BuildException buildException;
	private AntTestListener antTestListener;

	@Before
	public void setUp() {
		// initialize Ant
		configureProject("batch-compiler-data/ant/test.ant");
	}

	@After
	public void tearDown() {
		project = null;
	}

	@Test
	public void testSrcdirAsAttr() {
		executeTarget("compile");
		Assert.assertEquals("Message was logged but should not.", getLog(), "");
		File genFolder = new File("batch-compiler-data/ant/xtend-gen/test");
		Assert.assertTrue("Gen folder created", genFolder.exists());
		Assert.assertTrue("Gen folder not empty", genFolder.list() != null);
		Assert.assertEquals("Gen folder contains 7 compiled java files", 7, genFolder.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		}).length);
	}

	@Test
	public void testSrcdirAsNestedPath() {
		executeTarget("compile.multisrc");
		Assert.assertEquals("Message was logged but should not.", getLog(), "");
		File genFolder = new File("batch-compiler-data/ant/xtend-gen/test");
		Assert.assertTrue("Gen folder created", genFolder.exists());
		Assert.assertTrue("Gen folder not empty", genFolder.list() != null);
		Assert.assertEquals("Gen folder contains 8 compiled java files", 8, genFolder.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		}).length);
	}

	@Test
	public void testSrcdirNotADir() {
		expectBuildException("compile.srdir.not.a.dir", "Srcdir entry is not a dir",
				"Source directory must be a directory. Check 'srcdir' entry: ");
	}

	@Test
	public void testmMissingSrcdir() {
		expectBuildException("compile.missing.srcdir", "Srcdir is not set", "Sources directory 'srcdir' is required.");
	}

	@Test
	public void testMissingDestDir() {
		expectBuildException("compile.missing.destdir", "Destdir is not set",
				"Destination directory 'destdir' is required.");
	}

	public String getLog() {
		return antTestListener.getLog();
	}

	public BuildException getBuildException() {
		return buildException;
	}

	/**
	 * Sets up to run the named project
	 * 
	 * @param filename
	 *            name of project file to run
	 */
	protected void configureProject(String filename) throws BuildException {
		project = new Project();
		project.init();
		File antFile = new File(System.getProperty("root"), filename);
		File pluginsFolder = new File(new File(TargetPlatform.getLocation()), "plugins");
		project.setUserProperty("deps.dir", pluginsFolder.getAbsolutePath());
		project.setUserProperty("ant.file", antFile.getAbsolutePath());
		antTestListener = new AntTestListener(Project.MSG_ERR);
		project.addBuildListener(antTestListener);
		ProjectHelper.configureProject(project, antFile);
	}

	/**
	 * Executes a target we have set up
	 * 
	 * @pre configureProject has been called
	 * @param targetName
	 *            target to run
	 */
	public void executeTarget(String targetName) {
		PrintStream sysOut = System.out;
		PrintStream sysErr = System.err;
		try {
			sysOut.flush();
			sysErr.flush();
			outBuffer = new StringBuffer();
			PrintStream out = new PrintStream(new AntOutputStream(outBuffer));
			System.setOut(out);
			errBuffer = new StringBuffer();
			PrintStream err = new PrintStream(new AntOutputStream(errBuffer));
			System.setErr(err);
			buildException = null;
			antTestListener = new AntTestListener(Project.MSG_ERR);
			project.executeTarget(targetName);
		} finally {
			System.setOut(sysOut);
			System.setErr(sysErr);
		}

	}

	/**
	 * run a target, expect an exception string containing the substring we look for (case sensitive match)
	 * 
	 * @param target
	 *            target to run
	 * @param cause
	 *            information string to reader of report
	 * @param contains
	 *            substring of the build exception to look for
	 */
	public void expectBuildException(String target, String cause, String contains) {
		try {
			executeTarget(target);
		} catch (org.apache.tools.ant.BuildException ex) {
			buildException = ex;
			if ((null != contains) && (ex.getMessage().indexOf(contains) == -1)) {
				Assert.fail("Should throw BuildException because '" + cause + "' with message containing '" + contains
						+ "' (actual message '" + ex.getMessage() + "' instead)");
			}
			return;
		}
		Assert.fail("Should throw BuildException because: " + cause);
	}

	/**
	 * an output stream which saves stuff to our buffer.
	 */
	protected static class AntOutputStream extends java.io.OutputStream {
		private StringBuffer buffer;

		public AntOutputStream(StringBuffer buffer) {
			this.buffer = buffer;
		}

		@Override
		public void write(int b) {
			buffer.append((char) b);
		}
	}

	class NameSelector extends FilenameSelector {
		public NameSelector(String name) {
			this.setName(name);
		}
	}

	/**
	 * Our own personal build listener.
	 */
	private static class AntTestListener implements BuildListener {
		private int logLevel;
		private StringBuffer logBuffer = new StringBuffer();

		/**
		 * Constructs a test listener which will ignore log events above the given level.
		 */
		public AntTestListener(int logLevel) {
			this.logLevel = logLevel;
		}

		public String getLog() {
			return logBuffer.toString();
		}

		/**
		 * Fired before any targets are started.
		 */
		@Override
		public void buildStarted(BuildEvent event) {
		}

		/**
		 * Fired after the last target has finished. This event will still be thrown if an error occurred during the
		 * build.
		 * 
		 * @see BuildEvent#getException()
		 */
		@Override
		public void buildFinished(BuildEvent event) {
		}

		/**
		 * Fired when a target is started.
		 * 
		 * @see BuildEvent#getTarget()
		 */
		@Override
		public void targetStarted(BuildEvent event) {
			//System.out.println("targetStarted " + event.getTarget().getName());
		}

		/**
		 * Fired when a target has finished. This event will still be thrown if an error occurred during the build.
		 * 
		 * @see BuildEvent#getException()
		 */
		@Override
		public void targetFinished(BuildEvent event) {
			//System.out.println("targetFinished " + event.getTarget().getName());
		}

		/**
		 * Fired when a task is started.
		 * 
		 * @see BuildEvent#getTask()
		 */
		@Override
		public void taskStarted(BuildEvent event) {
			//System.out.println("taskStarted " + event.getTask().getTaskName());
		}

		/**
		 * Fired when a task has finished. This event will still be throw if an error occurred during the build.
		 * 
		 * @see BuildEvent#getException()
		 */
		@Override
		public void taskFinished(BuildEvent event) {
			//System.out.println("taskFinished " + event.getTask().getTaskName());
		}

		/**
		 * Fired whenever a message is logged.
		 * 
		 * @see BuildEvent#getMessage()
		 * @see BuildEvent#getPriority()
		 */
		@Override
		public void messageLogged(BuildEvent event) {
			if (event.getPriority() > logLevel) {
				// ignore event
				return;
			}
			if (event.getPriority() == Project.MSG_INFO || event.getPriority() == Project.MSG_WARN
					|| event.getPriority() == Project.MSG_ERR) {
				logBuffer.append(event.getMessage());
			}
		}

	}
}
