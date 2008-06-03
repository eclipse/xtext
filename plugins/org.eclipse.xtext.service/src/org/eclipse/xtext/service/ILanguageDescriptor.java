package org.eclipse.xtext.service;

public interface ILanguageDescriptor {

    String getId();

    String getName();

    String getNameSpace();
    
    ILanguageDescriptor getSuperLanguage();

}