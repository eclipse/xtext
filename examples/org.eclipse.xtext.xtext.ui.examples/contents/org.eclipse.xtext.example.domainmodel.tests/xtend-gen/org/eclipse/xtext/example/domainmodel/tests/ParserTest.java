package org.eclipse.xtext.example.domainmodel.tests;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.example.domainmodel.DomainmodelInjectorProvider;
import org.eclipse.xtext.example.domainmodel.domainmodel.AbstractElement;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(DomainmodelInjectorProvider.class)
@SuppressWarnings("all")
public class ParserTest {
  @Inject
  @Extension
  private ParseHelper<DomainModel> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;
  
  @Test
  public void testParsing() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package example {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("entity MyEntity {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("property : String");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final DomainModel model = this._parseHelper.parse(_builder);
      EList<AbstractElement> _elements = model.getElements();
      AbstractElement _get = _elements.get(0);
      final PackageDeclaration pack = ((PackageDeclaration) _get);
      String _name = pack.getName();
      Assert.assertEquals("example", _name);
      EList<AbstractElement> _elements_1 = pack.getElements();
      AbstractElement _get_1 = _elements_1.get(0);
      final Entity entity = ((Entity) _get_1);
      String _name_1 = entity.getName();
      Assert.assertEquals("MyEntity", _name_1);
      EList<Feature> _features = entity.getFeatures();
      Feature _get_2 = _features.get(0);
      final Property property = ((Property) _get_2);
      String _name_2 = property.getName();
      Assert.assertEquals("property", _name_2);
      JvmTypeReference _type = property.getType();
      String _identifier = _type.getIdentifier();
      Assert.assertEquals("java.lang.String", _identifier);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testJvmTypeReferencesValidator() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("package example {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("entity MyEntity {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("p : List<int>");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      DomainModel _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertError(_parse, 
        TypesPackage.Literals.JVM_TYPE_REFERENCE, 
        IssueCodes.INVALID_USE_OF_TYPE, 
        "The primitive \'int\' cannot be a type argument");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParsingAndLinking() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package example {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("entity MyEntity {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("property : String");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("op foo(String s) : String {");
      _builder.newLine();
      _builder.append("    \t");
      _builder.append("this.property = s");
      _builder.newLine();
      _builder.append("    \t");
      _builder.append("return s.toUpperCase");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      DomainModel _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParsingAndLinkingWithImports() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.append("package example {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("entity MyEntity {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("p : List<String>");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      DomainModel _parse = this._parseHelper.parse(_builder);
      this._validationTestHelper.assertNoErrors(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testReturnTypeInference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package example {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("entity MyEntity {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("property : String");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("op foo(String s) {");
      _builder.newLine();
      _builder.append("    \t");
      _builder.append("return property.toUpperCase + s");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final DomainModel model = this._parseHelper.parse(_builder);
      EList<AbstractElement> _elements = model.getElements();
      AbstractElement _head = IterableExtensions.<AbstractElement>head(_elements);
      final PackageDeclaration pack = ((PackageDeclaration) _head);
      EList<AbstractElement> _elements_1 = pack.getElements();
      AbstractElement _head_1 = IterableExtensions.<AbstractElement>head(_elements_1);
      final Entity entity = ((Entity) _head_1);
      EList<Feature> _features = entity.getFeatures();
      Feature _last = IterableExtensions.<Feature>last(_features);
      final Operation op = ((Operation) _last);
      Set<EObject> _jvmElements = this._iJvmModelAssociations.getJvmElements(op);
      EObject _head_2 = IterableExtensions.<EObject>head(_jvmElements);
      final JvmOperation method = ((JvmOperation) _head_2);
      JvmTypeReference _returnType = method.getReturnType();
      String _simpleName = _returnType.getSimpleName();
      Assert.assertEquals("String", _simpleName);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
