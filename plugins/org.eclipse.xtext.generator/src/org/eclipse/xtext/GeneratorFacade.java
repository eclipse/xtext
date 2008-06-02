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
import org.eclipse.xtext.util.GenProperties;
import org.eclipse.xtext.xtextutil.XtextutilPackage;
import org.openarchitectureware.expression.ExecutionContextImpl;
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
    public static void generate(Grammar grammarModel, String languageName, String languageNamespace, String srcGenPath,
            String uiSrcGenPath, String modelFileExtension) throws IOException {

        OutputImpl output = new OutputImpl();
        Outlet defaultOutlet = new Outlet();
        defaultOutlet.setPath(srcGenPath);

        Outlet uiOutlet = new Outlet();
        uiOutlet.setName("UI_SRC_GEN");
        uiOutlet.setPath(uiSrcGenPath);

        output.addOutlet(defaultOutlet);
        output.addOutlet(uiOutlet);

        XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null);
        EmfRegistryMetaModel metamodel = new EmfRegistryMetaModel() {
            @Override
            protected EPackage[] allPackages() {
                return new EPackage[] { XtextPackage.eINSTANCE, XtextutilPackage.eINSTANCE, EcorePackage.eINSTANCE };
            }
        };
        execCtx.registerMetaModel(metamodel);

        Properties p = new Properties();
        p.setProperty("language.name", languageName);
        p.setProperty("language.namespace", languageNamespace);
        p.setProperty("src.gen.path", srcGenPath);
        p.setProperty("model.file.extension", modelFileExtension);
        GenProperties.setProperties(p);

        ResourceSetImpl setImpl = new ResourceSetImpl();
        Resource resource = setImpl.createResource(URI.createURI(srcGenPath + "/" + languageNamespace + "/" + languageName + ".xmi"));
        resource.getContents().add(grammarModel);
        resource.save(null);

        XpandFacade facade = XpandFacade.create(execCtx);
        facade.evaluate("org::eclipse::xtext::grammargen::AntlrGrammar::grammar", grammarModel);
        facade.evaluate("org::eclipse::xtext::parsetree::ParseTreeConstructor::file", grammarModel);
        facade.evaluate("org::eclipse::xtext::LanguageFacade::file", grammarModel);
        facade.evaluate("org::eclipse::xtext::TokenTypes::file", grammarModel);
        facade.evaluate("org::eclipse::xtext::StandaloneSetup::file", grammarModel);
        facade.evaluate("org::eclipse::xtext::ParserFacade::parser", grammarModel);
        facade.evaluate("org::eclipse::xtext::ResourceFactory::factory", grammarModel);
        facade.evaluate("org::eclipse::xtext::services::GrammarAccess::file", grammarModel);
        facade.evaluate("org::eclipse::xtext::services::MetamodelAccess::file", grammarModel);
        facade.evaluate("org::eclipse::xtext::services::ServiceFactories::factories", grammarModel);
        if (uiSrcGenPath == null) {
            facade.evaluate("org::eclipse::xtext::ui::Plugin::file", grammarModel);
            facade.evaluate("org::eclipse::xtext::ui::Editor::file", grammarModel);
        }
        String grammar = languageNamespace + "/parser/internal/Internal" + languageName + ".g";

        Tool antlr = new Tool(new String[] { srcGenPath + "/" + grammar });
        antlr.process();

        // generate Lexer constants (not needed any longer)
        // TokenTypesExtensions.doGenerate(srcGenPath, languageNamespace,
        // languageName);

        // generate AntlrTokenResolver
        TokenTypesExtensions.loadTokenTypeNames(srcGenPath, languageNamespace, languageName);
        facade.evaluate("org::eclipse::xtext::AntlrTokenTypeResolver::file", grammarModel);

        // generate EPackage
        ExecutionContextImpl executionContext = new ExecutionContextImpl();
        executionContext.registerMetaModel(metamodel);
        XtendFacade xtendfacade = XtendFacade.create(executionContext, "org::eclipse::xtext::xtext2ecore::Xtext2Ecore");
        List<EPackage> result = (List<EPackage>) xtendfacade.call("transform", grammarModel);

        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
        for (EPackage pack : result) {
            URI uri = URI.createFileURI(srcGenPath + "/" + languageNamespace + "/" + pack.getName() + ".ecore");
            Resource metaModelResource = new ResourceSetImpl().createResource(uri);
            metaModelResource.getContents().add(pack);
            metaModelResource.save(null);
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
            if (!".cvsignore".equals(file.getName())) {
                if (!delete(file)) {
                    log.error("Couldn't delete " + file.getAbsolutePath());
                }
            }
        }
    }
}
