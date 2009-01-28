package org.eclipse.xtext.ecore;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenClassGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenPackageGeneratorAdapter;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.xtext.util.EmfFormater;

public class GenerateJavaFromEcore {
	
	private static Logger log = Logger.getLogger(GenerateJavaFromEcore.class);
	
	public static void generateEcoreJavaClasses( Collection<? extends EPackage> packs, String basePackage, final String uri) throws IOException, ConfigurationException {
		
		GenModel genModel = GenModelPackage.eINSTANCE.getGenModelFactory()
				.createGenModel();
		genModel.initialize(packs);
		
		genModel.setModelDirectory(uri);
		
		//genModel.setModelDirectory(modelProjectName);

		genModel.setValidateModel(false);
		genModel.setForceOverwrite(true);
		genModel.setCanGenerate(true);
		genModel.setFacadeHelperClass(null);
		genModel.setBundleManifest(false);

		
		for (GenPackage genPackage : genModel.getGenPackages()) {
			genPackage.setBasePackage(basePackage);
		}
		genModel.reconcile();
		Generator generator = new Generator();
		generator.getAdapterFactoryDescriptorRegistry().addDescriptor(GenModelPackage.eNS_URI,
				new GeneratorAdapterFactory.Descriptor()
		  {
		    public GeneratorAdapterFactory createAdapterFactory()
		    {
		      return new GenModelGeneratorAdapterFactory(){
		    	  
		    	  @Override
		    	public Adapter createGenClassAdapter() {
		    		return new GenClassGeneratorAdapter(this) {
		    			@Override
		    			protected OutputStream createOutputStream(
		    					URI workspacePath) throws Exception {

		    				return getURIConverter().createOutputStream(workspacePath);
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
		    			protected OutputStream createOutputStream(
		    					URI workspacePath) throws Exception {
		    				return getURIConverter().createOutputStream(workspacePath);
		    			}
		    			
		    		};
		    	}
		      };
		    }});
		generator.setInput(genModel);
		Diagnostic diagnostic = generator
				.generate(genModel,
						GenModelGeneratorAdapter.MODEL_PROJECT_TYPE,
						new BasicMonitor());
		if (log.isInfoEnabled())
			log.info(EmfFormater.objToStr(diagnostic));
	}
}
