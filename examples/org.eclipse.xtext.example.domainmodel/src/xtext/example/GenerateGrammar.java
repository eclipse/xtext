package xtext.example;

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

import com.google.inject.Injector;

/**
 * Run this class in order to generate the domain model grammar.
 */
public class  GenerateGrammar {
	private final Logger log = Logger.getLogger(GenerateGrammar.class);

	private static final String RUNTIME_PATH = ".";
	private static final String UI_PATH = "../org.eclipse.xtext.example.domainmodel.ui";


	private String uiPath = UI_PATH;
	private String runtimePath = RUNTIME_PATH;

	private GenerateGrammar(String... args) {
		if (args.length > 0) {
			runtimePath = args[0];
			uiPath = args[0] + "/" + UI_PATH;
		}
	}

	public void generate() throws IOException {
		Injector injector = new XtextStandaloneSetup().createInjectorAndDoEMFRegistration();

		GeneratorFacade.cleanFolder(runtimePath + "/src-gen");
		GeneratorFacade.cleanFolder(uiPath + "/src-gen");

		String classpathUri = "classpath:/xtext/example/Domainmodel.xtext";
		log.info("loading " + classpathUri);
		ResourceSet rs = injector.getInstance(XtextResourceSet.class);
		Resource resource = rs
				.createResource(new ClassloaderClasspathUriResolver().resolve(
						null, URI.createURI(classpathUri)));
		resource.load(null);
		Grammar grammarModel = (Grammar) resource.getContents().get(0);

		GeneratorFacade.generate(grammarModel, runtimePath, uiPath, "dmodel");
		log.info("Done.");
	}

	public static void main(String... args) throws IOException {
		GenerateGrammar generator = new GenerateGrammar(args);
		generator.generate();
	}

}

