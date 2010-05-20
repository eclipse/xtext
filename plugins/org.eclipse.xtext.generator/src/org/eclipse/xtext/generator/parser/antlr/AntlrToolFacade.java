package org.eclipse.xtext.generator.parser.antlr;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.WrappedException;

public class AntlrToolFacade {

	private final static Logger log = Logger.getLogger(AntlrToolFacade.class);

	public final static String className = "de.itemis.xtext.antlr.AntlrToolRunner";

	private ClassLoader loader = AntlrToolFacade.class.getClassLoader();

	public void setLoader(ClassLoader loader) {
		this.loader = loader;
	}

	private String downloadURL = "http://download.itemis.com/antlr-generator-3.0.1.jar";
	private boolean askBeforeDownload = true;

	public void setAskBeforeDownload(boolean shouldAsk) {
		this.askBeforeDownload = shouldAsk;
	}

	public void setDownloadFrom(String downloadURL) {
		this.downloadURL = downloadURL;
	}
	
	private String downloadTo = "./.antlr-generator-3.0.1.jar";

	public void setDownloadTo(String path) {
		this.downloadTo = path;
	}
	protected File file() {
		return new File(downloadTo);
	}

	protected Class<?> getToolClass() {
		try {
			return loader.loadClass(className);
		} catch (ClassNotFoundException e) {
			if (!file().exists()) {
				if (!download())
					return null;
			}
			if (file().exists()) {
				try {
					loader = new URLClassLoader(new URL[] { file().toURL() }, loader);
					ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
					try {
						Thread.currentThread().setContextClassLoader(loader);
						return loader.loadClass(className);
					} finally {
						Thread.currentThread().setContextClassLoader(contextClassLoader);
					}
				} catch (MalformedURLException e1) {
					log.error(e1.getMessage());
				} catch (ClassNotFoundException e1) {
					log.error(e1.getMessage());
				}
			}
			return null;
		}
	}


	public boolean download() {
		try {
			if (askBeforeDownload) {
				boolean ok = false;
				while (!ok) {
					System.err.print("\n*ATTENTION*\nIt is recommended to use the ANTLR 3 parser generator (BSD licence - http://www.antlr.org/license.html).\nDo you agree to download it (size 1MB) from '"
							+ downloadURL + "'? (type 'y' or 'n' and hit enter)");
					int read = System.in.read();
					if (read == 'n') {
						return false;
					} else if (read == 'y') {
						ok = true;
					}
				}
			}
			log.info("downloading file from '"+downloadURL+"' ...");
			BufferedInputStream in = new BufferedInputStream(new URL(downloadURL).openStream());
			FileOutputStream out = new FileOutputStream(file());
			byte[] buffer = new byte[2048];
			int readBytes = -1;
			while ((readBytes = in.read(buffer)) != -1) {
				out.write(buffer, 0, readBytes);
			}
			out.close();
			log.info("finished downloading.");
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
		if (getToolClass() == null) {
			log.error("Loaded jar doesn't contain");
			return false;
		}
		return true;
	}

	private IllegalStateException getNoClassFoundException() {
		return new IllegalStateException("Couldn't find ANTLR generator on class path. Please download manually from '"
				+ downloadURL + "' and put it on the classpath.");
	}

	public void runWithParams(String grammarFullPath, String... furtherArgs) {
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader(loader);
			Class<?> class1 = getToolClass();
			if (class1 == null)
				throw getNoClassFoundException();
			Method method = class1.getMethod("runWithParams", new Class[] { String.class, String[].class });
			method.invoke(null, grammarFullPath, furtherArgs);
		} catch (Exception e) {
			throw new WrappedException(e);
		} finally {
			Thread.currentThread().setContextClassLoader(contextClassLoader);
		}
	}

	public boolean isWorkable() {
		return getToolClass()!=null;
	}
}
