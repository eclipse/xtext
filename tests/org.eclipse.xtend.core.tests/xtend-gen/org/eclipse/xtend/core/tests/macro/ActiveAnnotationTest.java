package org.eclipse.xtend.core.tests.macro;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class ActiveAnnotationTest extends AbstractXtendTestCase {
  @Ignore
  @Test
  public void testSimpleModification() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@org.eclipse.xtend.core.tests.macro.Abstract");
      _builder.newLine();
      _builder.append("class MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.file(_builder.toString(), true);
      Resource _eResource = file.eResource();
      EList<EObject> _contents = _eResource.getContents();
      EObject _get = _contents.get(1);
      boolean _isAbstract = ((JvmDeclaredType) _get).isAbstract();
      Assert.assertTrue(_isAbstract);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
