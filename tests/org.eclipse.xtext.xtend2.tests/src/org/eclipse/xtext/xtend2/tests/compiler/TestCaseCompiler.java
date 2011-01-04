package org.eclipse.xtext.xtend2.tests.compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.IAppendable.StringBuilderBasedAppendable;
import org.eclipse.xtext.xtend2.Xtend2StandaloneSetup;
import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;

import com.google.inject.Injector;

public class TestCaseCompiler {

	public static void main(String[] args) throws Exception {
		try {
			TestCaseCompiler compiler = new TestCaseCompiler();
			compiler.compile(TestCaseCompiler.class.getPackage().getName() + ".TestClass1");
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	private Injector injector;

	public TestCaseCompiler() {
		try {
			injector = new Xtend2StandaloneSetup().createInjectorAndDoEMFRegistration();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void compile(String qualifiedName) throws IOException {
		ResourceSet set = injector.getInstance(ResourceSet.class);
		final String from = "src/" + qualifiedName.replace('.', '/') + ".xtd";
		final String to = "src-gen/" + qualifiedName.replace('.', '/') + ".java";

		Resource res = set.getResource(org.eclipse.emf.common.util.URI.createFileURI(from), true);

		StringBuilderBasedAppendable appendable = new IAppendable.StringBuilderBasedAppendable();
		Xtend2Compiler compiler = injector.getInstance(Xtend2Compiler.class);
		compiler.compile(res.getContents().get(0), appendable);
		final File file = new File(to);
		createFolders(file);
		FileWriter writer = new FileWriter(file);
		writer.append(appendable.toString());
		writer.close();
		System.out.println("compiled " + from + " to " + to);
	}

	private static void createFolders(File file) {
		if (!file.getParentFile().exists())
			createFolders(file.getParentFile());
		if (!file.exists())
			try {
				if (file.getName().indexOf('.') == -1)
					file.mkdir();
				else
					file.createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
	}
}
