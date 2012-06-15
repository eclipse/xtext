package de.itemis.junit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

public class ParameterizedCSV extends Suite {

	protected static class FileRunner extends ParentRunner<LineRunner> {
		protected Map<Integer, LineRunner> children;
		protected List<List<String>> contents;
		protected File file;

		public FileRunner(Class<?> testClass, File file) throws InitializationError {
			super(testClass);
			this.file = file;
			this.contents = loadFile(file);
			this.children = new LinkedHashMap<Integer, LineRunner>();
			for (int i = 0; i < this.contents.size(); i++)
				if (this.contents.get(i).size() >= 2)
					children.put(i, new LineRunner(testClass, this, i));
		}

		@Override
		protected Description describeChild(LineRunner child) {
			return child.getDescription();
		}

		@Override
		protected List<LineRunner> getChildren() {
			return new ArrayList<LineRunner>(children.values());
		}

		protected String getExpectedContents() {
			List<String> result = new ArrayList<String>();
			for (int i = 0; i < this.contents.size(); i++)
				result.add(join(this.contents.get(i), ", "));
			return join(result, "\n");
		}

		protected String getActualContents() {
			List<String> result = new ArrayList<String>();
			for (int i = 0; i < this.contents.size(); i++) {
				LineRunner lr = children.get(i);
				if (lr != null && lr.getActualLine() != null)
					result.add(lr.getActualLine());
				else
					result.add(join(this.contents.get(i), ", "));
			}
			return join(result, "\n");
		}

		@Override
		protected String getName() {
			return file.getName();
		}

		protected List<List<String>> loadFile(File file) {
			try {
				List<List<String>> result = new ArrayList<List<String>>();
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				try {
					String lineString;
					while ((lineString = br.readLine()) != null) {
						List<String> lineTokens = new ArrayList<String>();
						for (String token : lineString.split(","))
							lineTokens.add(token.trim());
						result.add(lineTokens);
					}
				} finally {
					br.close();
				}
				return result;
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		protected Statement childrenInvoker(final RunNotifier notifier) {
			final Statement children = super.childrenInvoker(notifier);
			return new Statement() {
				@Override
				public void evaluate() throws Throwable {
//					notifier.fireTestStarted(getDescription());
					children.evaluate();
					try {
						Assert.assertEquals(getExpectedContents(), getActualContents());
					} catch (Throwable t) {
						notifier.fireTestFailure(new Failure(getDescription(), t));
					}
//					notifier.fireTestFinished(getDescription());

				}
			};
		}

		@Override
		protected void runChild(LineRunner child, RunNotifier notifier) {
			child.run(notifier);
		}

	}

	public static String join(List<String> tokens, String separator) {
		StringBuilder result = new StringBuilder();
		for (String token : tokens) {
			if (result.length() > 0)
				result.append(separator);
			result.append(token);
		}
		return result.toString();
	}

	protected static class LineRunner extends Runner {
		protected Class<?> clazz;
		protected FileRunner file;
		protected int line;
		protected List<String> actualTokens;

		public LineRunner(Class<?> klass, FileRunner file, int line) throws InitializationError {
			this.file = file;
			this.line = line;
			this.clazz = klass;
		}

		@Override
		public Description getDescription() {
			return Description.createTestDescription(clazz, line + ": " + getMethodName());
		}

		protected String getMethodName() {
			return file.contents.get(line).get(0);
		}

		protected List<String> getExpectedTokens() {
			return file.contents.get(line).subList(1, file.contents.get(line).size());
		}

		protected String getActualLine() {
			if (actualTokens == null)
				return null;
			List<String> actual = new ArrayList<String>();
			actual.add(getMethodName());
			actual.addAll(actualTokens);
			return join(actual, ", ");
		}

		protected String getExpectedLine() {
			return join(file.contents.get(line), ", ");
		}

		@SuppressWarnings("unchecked")
		@Override
		public void run(RunNotifier notifier) {
			notifier.fireTestStarted(getDescription());
			try {
				Object obj = clazz.newInstance();
				Method m = clazz.getMethod(getMethodName(), List.class);
				if (m == null)
					throw new RuntimeException("method " + getMethodName() + " not found in " + clazz);
				this.actualTokens = (List<String>) m.invoke(obj, new ArrayList<String>(getExpectedTokens()));
				Assert.assertEquals(getExpectedLine(), getActualLine());
			} catch (Throwable e) {
				notifier.fireTestFailure(new Failure(getDescription(), e));
			}
			notifier.fireTestFinished(getDescription());
		}

	}

	protected final ArrayList<Runner> runners = new ArrayList<Runner>();

	public ParameterizedCSV(Class<?> klass) throws Throwable {
		super(klass, Collections.<Runner> emptyList());
		List<File> files = new ArrayList<File>();
		collectFiles(getFolder(klass), files);
		for (File f : files)
			runners.add(new FileRunner(klass, f));
	}

	protected void collectFiles(File root, List<File> result) {
		if (root.isFile() && root.getName().toLowerCase().endsWith(".csv"))
			result.add(root);
		if (root.isDirectory())
			for (File child : root.listFiles())
				collectFiles(child, result);
	}

	@Override
	protected List<Runner> getChildren() {
		return runners;
	}

	protected File getFolder(Class<?> clazz) {
		URL resource = clazz.getClassLoader().getResource(clazz.getName().replace(".", "/") + ".class");
		try {
			return new File(resource.toURI()).getParentFile();
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
}
