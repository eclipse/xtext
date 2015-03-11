package org.eclipse.xtend.core.tests.compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.XtendStandaloneSetup;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;

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
			injector = new XtendStandaloneSetup().createInjectorAndDoEMFRegistration();
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
		IXtendJvmAssociations associations = injector.getInstance(IXtendJvmAssociations.class);
		JvmModelGenerator generator = injector.getInstance(JvmModelGenerator.class);
		XtendFile xtendFile = (XtendFile)res.getContents().get(0);
		JvmGenericType inferredType = associations.getInferredType((XtendClass) xtendFile.getXtendTypes().get(0));
		GeneratorConfig config = injector.getInstance(IGeneratorConfigProvider.class).get(inferredType);
		CharSequence javaCode = generator.generateType(inferredType, config);
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
