package org.eclipse.xtext.ecore;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.EmfFormater;

public class GenerateJavaFromEcore {

	public static void doGenerate(Collection<? extends EPackage> packs, String src, String namespace) {
		GenModel genModel = GenModelPackage.eINSTANCE.getGenModelFactory().createGenModel();
		genModel.initialize(packs);
		genModel.setModelDirectory("org.eclipse.xtext.generator");
		genModel.setModelPluginID("org.eclipse.xtext.generator");
		genModel.setValidateModel(false);
		genModel.setForceOverwrite(true);
		genModel.setCanGenerate(true);
		genModel.setFacadeHelperClass(null);
		GenPackage genPackage = genModel.getGenPackages().get(0);
		genPackage.setBasePackage(namespace);
		genModel.reconcile();
		Generator generator = new Generator();
		generator.getAdapterFactoryDescriptorRegistry().addDescriptor(GenModelPackage.eNS_URI,
				GenModelGeneratorAdapterFactory.DESCRIPTOR);
		generator.setInput(genModel);
		Diagnostic diagnostic = generator.generate(genModel, GenModelGeneratorAdapter.MODEL_PROJECT_TYPE,
				new BasicMonitor());
		System.out.println(EmfFormater.objToStr(diagnostic, ""));
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		setPlatformUri("..");
		XtextResourceSet rs = new XtextResourceSet();
		
		XtextStandaloneSetup.doSetup();
		Resource resource = rs.createResource(URI.createURI("classpath:/org/eclipse/xtext/xtext2ecore/test.ecore"));
		resource.load(null);
		doGenerate((Collection<? extends EPackage>) resource.getContents(), "/src", "org.eclipse.");
	}


	public static void setPlatformUri(final String pathToPlatform) {
		File f = new File(pathToPlatform);
		if (!f.exists()) {
			throw new ConfigurationException("The platformUri location '" + pathToPlatform + "' does not exist");
		}
		if (!f.isDirectory()) {
			throw new ConfigurationException("The platformUri location must point to a directory");
		}
		if (f.exists()) {
			for (File subdir : f.listFiles(new FileFilter() {
				public boolean accept(final File arg0) {
					return arg0.exists() && arg0.isDirectory() && !arg0.getName().startsWith(".");
				}
			})) {
				String s = subdir.getName();
				try {
					URI uri = URI.createFileURI(subdir.getCanonicalPath() + "/src-gen/");
					EcorePlugin.getPlatformResourceMap().put(s, uri);
				} catch (IOException e) {
					throw new ConfigurationException("Error when registering platform location", e);
				}
			}
		}
	}
}
