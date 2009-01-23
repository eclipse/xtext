package org.eclipse.xtext.reference;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.GeneratorFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.ClassloaderClasspathUriResolver;
import org.eclipse.xtext.resource.XtextResourceSet;

import ReferenceModel.ReferenceModelPackage;

/**
 * Run this class in order to generate the Reference grammar.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Peter Friese
 */
public class ReferenceGrammar {
	private Logger log = Logger.getLogger(ReferenceGrammar.class);

	private static final String RUNTIME_PATH = ".";
	private static final String UI_PATH = "../org.eclipse.xtext.reference.ui";

	private String uiPath = UI_PATH;
	private String runtimePath = RUNTIME_PATH;

	private ReferenceGrammar(String... args) {
		if (args.length > 0) {
			runtimePath = args[0];
			uiPath = args[0] + "/" + UI_PATH;
		}
	}
	
	public void generate() throws IOException {
		XtextStandaloneSetup.doSetup();
		ReferenceModelPackage.eINSTANCE.getCustomType(); // initialize

		GeneratorFacade.cleanFolder(runtimePath + "/src-gen");
		GeneratorFacade.cleanFolder(uiPath + "/src-gen");

		String classpathUri = "classpath:/" + getClass().getName().replace('.', '/') + ".xtext";
		log.info("loading " + classpathUri);
		ResourceSet rs = new XtextResourceSet();
		Resource resource = rs.createResource(new ClassloaderClasspathUriResolver().resolve(null, URI
				.createURI(classpathUri)));
		resource.load(null);
		Grammar grammarModel = (Grammar) resource.getContents().get(0);

		GeneratorFacade.generate(grammarModel, runtimePath, uiPath, "xtest", "tst");
		log.info("Done.");
	}

	public static void main(String... args) throws IOException {
		try {
			ReferenceGrammar generator = new ReferenceGrammar(args);
			generator.generate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
