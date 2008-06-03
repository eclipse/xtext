package org.eclipse.xtext.service;

public class InjectedLanguageService implements ILanguageService {
    private ILanguageDescriptor languageDescriptor;
    
    public ILanguageDescriptor getLanguageDescriptor() {
        return languageDescriptor;
    }

    public void setLanguageDescriptor(ILanguageDescriptor languageDescriptor) {
        this.languageDescriptor = languageDescriptor;
    }
}
