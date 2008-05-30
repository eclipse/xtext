package org.eclipse.xtext.service;

public interface ILanguageDescriptor {

    public final static String ID_ATTRIBUTE = "id";
    public final static String NAME_ATTRIBUTE = "name";
    public final static String LANGUAGEFACADE_CLASS_ATTRIBUTE = "languageFacade";

    public abstract String getId();

    public abstract String getName();

    public abstract String getNameSpace();

}