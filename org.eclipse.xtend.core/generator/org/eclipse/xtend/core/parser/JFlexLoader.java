/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;

import com.google.common.io.ByteStreams;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JFlexLoader implements IWorkflowComponent, JFlexMain {

	private final static Logger log = Logger.getLogger(JFlexLoader.class);
	
	private static final String DOWNLOAD_URL = "http://jflex.de/jflex-1.4.3.zip";
	
	private static final String MAIN_CLASS = "JFlex.Main";

	private ClassLoader loader = JFlexLoader.class.getClassLoader();
	
	private String downloadTo = "./.jflex.jar";

	private boolean askBeforeDownload = true;
	
	public ClassLoader getClassLoader() {
		return loader;
	}
	
	@Override
	public void runJFlex(String... args) {
		try {
			Class<?> main = loader.loadClass(MAIN_CLASS);
			Method mainMethod = main.getMethod("main", String[].class);
			mainMethod.invoke(null, new Object[] { args });
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void setDownloadPath(String downloadTo) {
		this.downloadTo = downloadTo;
	}
	
	public void setAskBeforeDownload(boolean askBeforeDownload) {
		this.askBeforeDownload = askBeforeDownload;
	}
	
	public String getDownloadTo() {
		return downloadTo;
	}
	
	public File getJarFile() {
		return new File(downloadTo);
	}
	
	@Override
	public void preInvoke() {
		try {
			loader.loadClass(MAIN_CLASS);
		} catch (ClassNotFoundException e) {
			File jarFile = getJarFile();
			if (!jarFile.exists()) {
				try {
					if (!download(jarFile))
						return;
				} catch(IOException ioe) {
					throw new RuntimeException(ioe);
				}
			}
			if (jarFile.exists()) {
				try {
					URL url = jarFile.toURI().toURL();
					loader = new URLClassLoader(new URL[] { url }, loader);
					ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
					try {
						Thread.currentThread().setContextClassLoader(loader);
						loader.loadClass(MAIN_CLASS);
					} finally {
						Thread.currentThread().setContextClassLoader(contextClassLoader);
					}
				} catch (Exception e1) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	private boolean download(final File jarFile) throws IOException {
		final File tempFile = File.createTempFile("JFlex", "zip");
		tempFile.deleteOnExit();
		if (askBeforeDownload) {
			boolean ok = false;
			while (!ok) {
				System.err.print("Download JFlex 1.4.3? (type 'y' or 'n' and hit enter)");
				int read = System.in.read();
				if (read == 'n') {
					return false;
				} else if (read == 'y') {
					ok = true;
				}
			}
		}
		log.info("downloading JFlex 1.4.3 from '"+DOWNLOAD_URL+"' ...");
		copyIntoFileAndCloseStream(new URL(DOWNLOAD_URL).openStream(), tempFile);
		log.info("finished downloading. Now extracting to " + downloadTo);
		final ZipFile zipFile = new ZipFile(tempFile);
		try {
			final ZipEntry entry = zipFile.getEntry("jflex/lib/JFlex.jar");
			copyIntoFileAndCloseStream(zipFile.getInputStream(entry), jarFile);
		} finally {
			zipFile.close();
		}
		return true;
	}

	protected void copyIntoFileAndCloseStream(InputStream content, final File file) throws FileNotFoundException, IOException {
		BufferedInputStream inputStream = new BufferedInputStream(content);
		try {
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
			try {
				ByteStreams.copy(inputStream, outputStream);
			} finally {
				outputStream.close();
			}
		} finally {
			inputStream.close();
		}
	}

	@Override
	public void invoke(IWorkflowContext ctx) {
	}

	@Override
	public void postInvoke() {
	}

}
