package org.eclipse.xtext.index;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.index.indexTestLanguage.Entity;

@SuppressWarnings("all")
public class IndexTestLanguageGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    final TreeIterator<EObject> iter = input.getAllContents();
    while (iter.hasNext()) {
      EObject _next = iter.next();
      final EObject e = _next;
      boolean _matched = false;
      if (e instanceof Entity) {
        _matched=true;
        String _name = ((Entity)e).getName();
        String _plus = (_name + ".txt");
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Hello ");
        String _name_1 = ((Entity)e).getName();
        _builder.append(_name_1, "");
        _builder.append("!");
        _builder.newLineIfNotEmpty();
        fsa.generateFile(_plus, _builder);
      }
    }
  }
}
