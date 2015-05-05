package org.eclipse.xtext.builder.tests;

import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.tests.builderTestLanguage.Element;
import org.eclipse.xtext.generator.IFileSystemAccess;
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
      StringConcatenation _builder = new StringConcatenation();
      String _name = ele.getName();
      _builder.append(_name, "");
      _builder.append(".txt");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("object ");
      String _name_1 = ele.getName();
      _builder_1.append(_name_1, "");
      fsa.generateFile(_builder.toString(), _builder_1);
    }
  }
}
