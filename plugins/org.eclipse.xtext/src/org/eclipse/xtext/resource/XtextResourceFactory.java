package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.InjectedService;

public class XtextResourceFactory implements IResourceFactory {

    private ILanguageDescriptor languageDescriptor;

    private IParser parser;

    private IElementFactory elementFactory;

    private IParseTreeConstructor parsetreeConstructor;

    public Resource createResource(URI uri) {
        return new NewXtextResource(elementFactory, parser, parsetreeConstructor, uri);
    }

    public ILanguageDescriptor getLanguageDescriptor() {
        return languageDescriptor;
    }

    @InjectedService
    public void setLanguageDescriptor(ILanguageDescriptor languageDescriptor) {
        this.languageDescriptor = languageDescriptor;
    }

    @InjectedService
    public void setParser(IParser parser) {
        this.parser = parser;
    }

    @InjectedService
    public void setElementFactory(IElementFactory elementFactory) {
        this.elementFactory = elementFactory;
    }
    
    @InjectedService
    public void setParsetreeConstructor(IParseTreeConstructor parsetreeConstructor) {
        this.parsetreeConstructor = parsetreeConstructor;
    }

}
