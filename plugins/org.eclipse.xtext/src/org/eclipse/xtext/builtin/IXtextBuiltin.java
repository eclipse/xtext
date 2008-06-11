package org.eclipse.xtext.builtin;

public interface IXtextBuiltin {
    /**
     * the unique identifier of this language. 
     * To be used to get the language descriptor and related services from the registry.
     * Within ILanguageServices it is encouraged to use dependency injection instead
     * of directly accessing the ServiceRegistry 
     */
    public static final String ID = "org.eclipse.xtext.builtin.XtextBuiltin";
    public static final String NAME = "Xtext Builtin";
    public static final String NAMESPACE = "org.eclipse.xtext.builtin";
}
