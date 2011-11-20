package org.eclipse.xtext.xtend2.tests.compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xtend2.Xtend2StandaloneSetup;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

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
		final String from = "src/" + qualifiedName.replace('.', '/') + ".xtend";
		final String to = "src-gen/" + qualifiedName.replace('.', '/') + ".java";

		Resource res = set.getResource(org.eclipse.emf.common.util.URI.createFileURI(from), true);
		EcoreUtil.resolveAll(res);
		if (!res.getErrors().isEmpty())
			throw new RuntimeException(res.getErrors().toString());
		final File file = new File(to);
		createFolders(file);
		FileWriter writer = new FileWriter(file);
		IXtend2JvmAssociations associations = injector.getInstance(IXtend2JvmAssociations.class);
		JvmModelGenerator generator = injector.getInstance(JvmModelGenerator.class);
		XtendFile xtendFile = (XtendFile)res.getContents().get(0);
		JvmGenericType inferredType = associations.getInferredType(xtendFile.getXtendClass());
		CharSequence javaCode = generator.generateType(inferredType);
		writer.append(javaCode);
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
