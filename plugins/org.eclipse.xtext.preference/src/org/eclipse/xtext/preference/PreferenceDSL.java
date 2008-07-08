package org.eclipse.xtext.preference;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.GeneratorFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * Run this class in order to generate the Reference grammar.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Peter Friese
 */
public class PreferenceDSL {
    private static final String PATH = "./src-gen";
    private static final String UI_PATH = "../org.eclipse.xtext.preference.ui_gen";

    public void generate() throws IOException {
        XtextStandaloneSetup.doSetup();

        GeneratorFacade.cleanFolder(PATH);

        String classpathUri = "classpath:/"+getClass().getName().replace('.', '/') + ".xtext";
        System.out.println("loading " + classpathUri);
        XtextResourceSet rs = new XtextResourceSet();
        Resource resource = rs.createResource(URI.createURI(classpathUri));
        resource.load(null);
        Grammar grammarModel = (Grammar) resource.getContents().get(0);

        GeneratorFacade.generate(grammarModel, PATH, UI_PATH, "pref");
        System.out.println("Done.");
    }

    public static void main(String[] args) throws IOException {
    	Thread.currentThread().setContextClassLoader(PreferenceDSL.class.getClassLoader());
        PreferenceDSL generator = new PreferenceDSL();
        try {
        	generator.generate();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
