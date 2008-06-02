package org.eclipse.xtext.reference;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.GeneratorFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextLanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parser.XtextASTFactory;
import org.eclipse.xtext.parser.XtextParser;

/**
 * Run this class in order to generate the Reference grammar.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Peter Friese
 */
public class ReferenceGrammar {
    private static final String PATH = "./src-gen";
    private static final String UI_PATH = "../org.eclipse.xtext.reference.ui/src-gen";

    public void generate() throws IOException {
        XtextStandaloneSetup.doSetup();

        GeneratorFacade.cleanFolder(PATH);

        String filename = this.getClass().getName().replace('.', '/') + ".xtext";

        System.out.println("loading " + filename);
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filename);

        EPackage.Registry.INSTANCE.put(XtextLanguageFacade.XTEXT_NS_URI, XtextPackage.eINSTANCE);
        XtextParser xtext2Parser = new XtextParser();
        Grammar grammarModel = (Grammar) xtext2Parser.parse(resourceAsStream, new XtextASTFactory())
                .getRootASTElement();

        GeneratorFacade.generate(grammarModel, this.getClass().getSimpleName(), this.getClass().getPackage().getName()
                .replace('.', '/'), PATH, UI_PATH, "xtext");
        System.out.println("Done.");
    }

    public static void main(String[] args) throws IOException {
        ReferenceGrammar generator = new ReferenceGrammar();
        generator.generate();
    }

}
