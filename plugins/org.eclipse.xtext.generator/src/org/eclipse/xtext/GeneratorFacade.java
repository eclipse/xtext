/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.antlr.Tool;
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
	
	@SuppressWarnings("unchecked")
	public static void generate(Grammar grammarModel, String languageName, String languageNamespace, String srcGenPath)
			throws IOException {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		
		OutputImpl output = new OutputImpl();
		Outlet outlet = new Outlet();
		outlet.setPath(srcGenPath);
		output.addOutlet(outlet);
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
		GenProperties.setProperties(p);

		XpandFacade facade = XpandFacade.create(execCtx);
		facade.evaluate("org::eclipse::xtext::grammargen::AntlrGrammar::grammar", grammarModel);
		facade.evaluate("org::eclipse::xtext::Constants::file", grammarModel);
		facade.evaluate("org::eclipse::xtext::StandaloneSetup::file", grammarModel);
		facade.evaluate("org::eclipse::xtext::ParserFacade::parser", grammarModel);
		facade.evaluate("org::eclipse::xtext::ASTFactory::factory", grammarModel);

		String grammar = languageNamespace + "/parser/internal/Internal" + languageName + ".g";

		Tool antlr = new Tool(new String[] { srcGenPath+"/" + grammar });
		antlr.process();
		
		// generate Lexer constants
		GenerateTokensEnum.doGenerate(srcGenPath, languageNamespace, languageName);

		// generate EPackage
		ExecutionContextImpl executionContext = new ExecutionContextImpl();
		executionContext.registerMetaModel(metamodel);
		XtendFacade xtendfacade = XtendFacade.create(executionContext, "org::eclipse::xtext::xtext2ecore::Xtext2Ecore");
		List<EPackage> result = (List<EPackage>) xtendfacade.call("transform", grammarModel);

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		for (EPackage pack : result) {
			URI uri = URI.createFileURI(srcGenPath+"/" + languageNamespace + "/" + pack.getName() + ".ecore");
			Resource metaModelResource = new ResourceSetImpl().createResource(uri);
			metaModelResource.getContents().add(pack);
			metaModelResource.save(null);
		}
		
		ResourceSetImpl setImpl = new ResourceSetImpl();
		Resource resource = setImpl.createResource(URI.createURI(srcGenPath+"/"+languageNamespace+"/"+languageName+".xmi"));
		resource.getContents().add(grammarModel);
		resource.save(null);
	}
}
