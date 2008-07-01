package org.eclipse.xtext.parser;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.SyntaxError;

public interface IParseResult {

    EObject getRootASTElement();
    
    CompositeNode getRootNode();
    
    List<SyntaxError> getParseErrors();
}
