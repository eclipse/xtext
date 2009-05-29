/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

import java.io.File;
import java.io.OutputStream;

import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenClassGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenPackageGeneratorAdapter;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtext.util.LineFilterOutputStream;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class GenerateParseTree {
	public static void main(String[] args) {
		try {
			new StandaloneSetup().setPlatformUri("..");
			final String uri = new File("./emf-gen").getAbsolutePath();
			GenModelPackage.eINSTANCE.getGenAnnotation();

			ResourceSet rs = new ResourceSetImpl();
			Resource resource = rs.getResource(URI
					.createURI("platform:/resource/org.eclipse.xtext/model/parsetree.genmodel"), true);
			GenModel genModel = (GenModel) resource.getContents().get(0);
			genModel.setForceOverwrite(true);
			genModel.setCanGenerate(true);
			genModel.reconcile();

			Generator generator = new Generator();
			generator.getAdapterFactoryDescriptorRegistry().addDescriptor(GenModelPackage.eNS_URI,
					new GeneratorAdapterFactory.Descriptor() {
						public GeneratorAdapterFactory createAdapterFactory() {
							return new GenModelGeneratorAdapterFactory() {

								@Override
								public Adapter createGenClassAdapter() {
									return new GenClassGeneratorAdapter(this) {
										@Override
										protected OutputStream createOutputStream(URI workspacePath) throws Exception {
											return new LineFilterOutputStream(getURIConverter().createOutputStream(workspacePath),
													" * $Id" + "$");
										}

										@Override
										protected URI toURI(String pathName) {
											return URI.createFileURI(uri);
										}
									};
								}

								@Override
								public Adapter createGenPackageAdapter() {
									return new GenPackageGeneratorAdapter(this) {
										@Override
										protected URI toURI(String pathName) {
											return URI.createFileURI(uri);
										}

										@Override
										protected OutputStream createOutputStream(URI workspacePath) throws Exception {
											return new LineFilterOutputStream(getURIConverter().createOutputStream(workspacePath),
													" * $Id" + "$");
										}

									};
								}
							};
						}
					});
			generator.setInput(genModel);
			Diagnostic diagnostic = generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE,
					new BasicMonitor());

			if (diagnostic.getSeverity() != Diagnostic.OK)
				System.err.println(diagnostic);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
