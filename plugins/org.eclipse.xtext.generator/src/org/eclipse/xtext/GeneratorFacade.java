/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.antlr.Tool;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2t.type.emf.EmfRegistryMetaModel;
import org.eclipse.xtext.ui.CopyImages;
import org.eclipse.xtext.util.GenProperties;
import org.eclipse.xtext.xtextutil.XtextutilPackage;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.workflow.issues.IssuesImpl;
import org.openarchitectureware.xpand2.XpandExecutionContextImpl;
import org.openarchitectureware.xpand2.XpandFacade;
import org.openarchitectureware.xpand2.output.Outlet;
import org.openarchitectureware.xpand2.output.OutputImpl;
import org.openarchitectureware.xtend.XtendFacade;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class GeneratorFacade {
	private static Log log = LogFactory.getLog(GeneratorFacade.class);

	// Deletes all files and subdirectories under dir.
	// Returns true if all deletions were successful.
	// If a deletion fails, the method stops attempting to delete and returns
	// false.
	private static boolean delete(final File file) {
		if (file.isDirectory()) {
			final String[] children = file.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = delete(new File(file, children[i]));
				if (!success)
					return false;
			}
		}

		// The directory is now empty so delete it
		return file.delete();
	}

	@SuppressWarnings("unchecked")
	public static void generate(Grammar grammarModel, String srcGenPath,
			String uiProjectPath, String... modelFileExtensions) throws IOException {
		EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(XtextPackage.eNS_URI, XtextPackage.eINSTANCE);
		OutputImpl output = new OutputImpl();

		// default outlet
		Outlet defaultOutlet = new Outlet();
		defaultOutlet.setPath(srcGenPath);
		output.addOutlet(defaultOutlet);
		
		// UI project, root path
		Outlet uiOutlet = new Outlet(uiProjectPath);
		uiOutlet.setName("UI");
		output.addOutlet(uiOutlet);

		// UI project, src-gen path 
		String uiProjectSrcGenPath = uiProjectPath + "/src-gen";
		Outlet uiSrcGenOutlet = new Outlet(uiProjectSrcGenPath);
		uiSrcGenOutlet.setName("UI_SRC_GEN");
		output.addOutlet(uiSrcGenOutlet);
		
		// UI project, META-INF path
		String uiProjectManifestPath = uiProjectPath + "/META-INF";
		Outlet uiManifestOutlet = new Outlet(uiProjectManifestPath);
		uiManifestOutlet.setName("UI_MANIFEST");
		output.addOutlet(uiManifestOutlet);

		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null);
		EmfRegistryMetaModel metamodel = new EmfRegistryMetaModel() {
			@Override
			protected EPackage[] allPackages() {
				return new EPackage[] { XtextPackage.eINSTANCE, XtextutilPackage.eINSTANCE, EcorePackage.eINSTANCE };
			}
		};
		execCtx.registerMetaModel(metamodel);
		
		String languageName = GrammarUtil.getName(grammarModel);
		String languageNamespace = GrammarUtil.getNamespace(grammarModel);
		Properties p = new Properties();
		p.setProperty("language.name", languageName);
		p.setProperty("language.namespace", languageNamespace);
		p.setProperty("src.gen.path", srcGenPath);
		StringBuffer stringBuffer = new StringBuffer(modelFileExtensions[0]);
		for (int i=1; i<  modelFileExtensions.length; ++i) {
            stringBuffer.append(",");
            stringBuffer.append(modelFileExtensions[i]);
        }
        p.setProperty("model.file.extensions", stringBuffer.toString());
        p.setProperty("file.header", "");
		GenProperties.setProperties(p);

		ResourceSetImpl setImpl = new ResourceSetImpl();
		Resource resource = setImpl.createResource(URI.createURI(srcGenPath + "/" + languageNamespace + "/"
				+ languageName + ".xmi"));
		resource.getContents().add(grammarModel);
		resource.save(null);

		XpandFacade facade = XpandFacade.create(execCtx);
		facade.evaluate("org::eclipse::xtext::StandaloneSetup::file", grammarModel);
		facade.evaluate("org::eclipse::xtext::services::GrammarAccess::file", grammarModel);
		facade.evaluate("org::eclipse::xtext::services::MetamodelAccess::file", grammarModel);
		if (!GrammarUtil.isAbstract(grammarModel)) {
			facade.evaluate("org::eclipse::xtext::ILanguage::file", grammarModel);
            facade.evaluate("org::eclipse::xtext::services::ResourceFactory::file", grammarModel);
			facade.evaluate("org::eclipse::xtext::parser::IParser::parser", grammarModel);
			facade.evaluate("org::eclipse::xtext::parser::AntlrGrammar::grammar", grammarModel);
			String grammar = languageNamespace + "/parser/internal/Internal" + languageName + ".g";
			Tool antlr = new Tool(new String[] { srcGenPath + "/" + grammar });
			antlr.process();
			facade.evaluate("org::eclipse::xtext::parsetree::ParseTreeConstructor::file", grammarModel);
			// generate EPackage
			ExecutionContextImpl executionContext = new ExecutionContextImpl();
			executionContext.registerMetaModel(metamodel);
			XtendFacade xtendfacade = XtendFacade.create(executionContext,
					"org::eclipse::xtext::xtext2ecore::Xtext2Ecore");
			List<EPackage> result = (List<EPackage>) xtendfacade.call("getGeneratedEPackages", grammarModel);

			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
			for (EPackage pack : result) {
				URI uri = URI.createFileURI(srcGenPath + "/" + languageNamespace + "/" + pack.getName() + ".ecore");
				Resource metaModelResource = new ResourceSetImpl().createResource(uri);
				metaModelResource.getContents().add(pack);
				metaModelResource.save(null);
			}
			if (uiProjectPath != null) {
				facade.evaluate("org::eclipse::xtext::ui::Project::root", grammarModel);
				facade.evaluate("org::eclipse::xtext::ui::Plugin::file", grammarModel);
				facade.evaluate("org::eclipse::xtext::ui::Manifest::file", grammarModel);
				facade.evaluate("org::eclipse::xtext::ui::Editor::file", grammarModel);
				
				CopyImages copier = new CopyImages();
				copier.setTargetDir(uiProjectPath + "/icons/");
				copier.invoke(null, null, new IssuesImpl());
			}
		}
	}

	public static void cleanFolder(String srcGenPath) throws FileNotFoundException {
		File f = new File(srcGenPath);
		if (!f.exists()) {
			throw new FileNotFoundException(srcGenPath);
		}
		log.info("Cleaning folder " + srcGenPath);
		final File[] contents = f.listFiles();
		for (int j = 0; j < contents.length; j++) {
			final File file = contents[j];
			if (file.isDirectory()) {
			    cleanFolder(file.getAbsolutePath());
			}
			else {
    			if (!isCVSFile(file)) {
    				if (!delete(file)) {
    					log.error("Couldn't delete " + file.getAbsolutePath());
    				}
    			}
			}
		}
	}
	
	private static boolean isCVSFile(File file) {
        if (".cvsignore".equals(file.getName())) return true;
        if ("CVS".equals(file.getName())) return true;
        if ("Entries".equals(file.getName())) return true;
        if ("Repository".equals(file.getName())) return true;
        if ("Root".equals(file.getName())) return true;
	    return false;
	}
}
