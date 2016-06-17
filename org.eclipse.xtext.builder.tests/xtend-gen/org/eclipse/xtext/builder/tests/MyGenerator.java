package org.eclipse.xtext.builder.tests;

import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.tests.builderTestLanguage.Element;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class MyGenerator implements IGenerator {
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
    TreeIterator<EObject> _allContents = input.getAllContents();
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_allContents);
    Iterable<Element> _filter = Iterables.<Element>filter(_iterable, Element.class);
    for (final Element ele : _filter) {
      {
        if ((fsa instanceof IFileSystemAccess2)) {
          StringConcatenation _builder = new StringConcatenation();
          String _name = ele.getName();
          _builder.append(_name, "");
          _builder.append(".txt");
          boolean _isFile = ((IFileSystemAccess2)fsa).isFile(_builder.toString());
          if (_isFile) {
            StringConcatenation _builder_1 = new StringConcatenation();
            String _name_1 = ele.getName();
            _builder_1.append(_name_1, "");
            _builder_1.append(".txt");
            ((IFileSystemAccess2)fsa).readTextFile(_builder_1.toString());
          }
        }
        StringConcatenation _builder_2 = new StringConcatenation();
        String _name_2 = ele.getName();
        _builder_2.append(_name_2, "");
        _builder_2.append(".txt");
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("object ");
        String _name_3 = ele.getName();
        _builder_3.append(_name_3, "");
        fsa.generateFile(_builder_2.toString(), _builder_3);
      }
    }
  }
}
