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

    @InjectedService
    private IParser parser;

    @InjectedService
    private IElementFactory elementFactory;

    @InjectedService
    private IParseTreeConstructor parsetreeConstructor;

    public Resource createResource(URI uri) {
        return new NewXtextResource(elementFactory, parser, parsetreeConstructor, uri);
    }

    public ILanguageDescriptor getLanguageDescriptor() {
        return languageDescriptor;
    }

    public void setLanguageDescriptor(ILanguageDescriptor languageDescriptor) {
        this.languageDescriptor = languageDescriptor;
    }

    public void setParser(IParser parser) {
        this.parser = parser;
    }

    public void setElementFactory(IElementFactory elementFactory) {
        this.elementFactory = elementFactory;
    }

    public void setParsetreeConstructor(IParseTreeConstructor parsetreeConstructor) {
        this.parsetreeConstructor = parsetreeConstructor;
    }

}
