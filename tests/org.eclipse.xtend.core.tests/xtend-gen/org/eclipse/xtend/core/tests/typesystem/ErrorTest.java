/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(value = XtextRunner.class)
@InjectWith(value = NewTypeSystemRuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class ErrorTest extends AbstractXtendTestCase {
  @Inject
  private IResourceValidator resourceValidator;
  
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Inject
  private IJvmModelAssociations associations;
  
  @Test
  public void testErrorModel_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static extension Throwables.*");
    _builder.newLine();
    _builder.append("import java.net.URI");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Client {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val uri = [| new URI(\'\')].propagate [ new IllegalArgumentException(it) ]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Throwables {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static <T> T propagate((");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class TestXtend {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val static int a = 4");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    final XtendClass clazz = ((XtendClass) _head);
    EList<XtendMember> _members = clazz.getMembers();
    final XtendMember lastMember = IterableExtensions.<XtendMember>last(_members);
    final EList<XAnnotation> annotations = lastMember.getAnnotations();
    XAnnotation _head_1 = IterableExtensions.<XAnnotation>head(annotations);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(_head_1);
    XAnnotation _head_2 = IterableExtensions.<XAnnotation>head(annotations);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(_head_2);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class TestXtend {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val static int a = 4");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Click({ a, a })");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("d");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    final XtendClass clazz = ((XtendClass) _head);
    EList<XtendMember> _members = clazz.getMembers();
    final XtendMember lastMember = IterableExtensions.<XtendMember>last(_members);
    final EList<XAnnotation> annotations = lastMember.getAnnotations();
    XAnnotation _head_1 = IterableExtensions.<XAnnotation>head(annotations);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(_head_1);
    XAnnotation _head_2 = IterableExtensions.<XAnnotation>head(annotations);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(_head_2);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class TestXtend {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val static int a = 4");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Click({ a, a })");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    final XtendClass clazz = ((XtendClass) _head);
    EList<XtendMember> _members = clazz.getMembers();
    final XtendMember lastMember = IterableExtensions.<XtendMember>last(_members);
    final EList<XAnnotation> annotations = lastMember.getAnnotations();
    XAnnotation _head_1 = IterableExtensions.<XAnnotation>head(annotations);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(_head_1);
    XAnnotation _head_2 = IterableExtensions.<XAnnotation>head(annotations);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(_head_2);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_05() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration typeDeclaration = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    final EList<XAnnotation> annotations = typeDeclaration.getAnnotations();
    XAnnotation _head = IterableExtensions.<XAnnotation>head(annotations);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(_head);
    XAnnotation _head_1 = IterableExtensions.<XAnnotation>head(annotations);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(_head_1);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_06() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Data class A {}");
    _builder.newLine();
    _builder.append("@");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration typeDeclaration = IterableExtensions.<XtendTypeDeclaration>last(_xtendTypes);
    final EList<XAnnotation> annotations = typeDeclaration.getAnnotations();
    XAnnotation _head = IterableExtensions.<XAnnotation>head(annotations);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(_head);
    XAnnotation _head_1 = IterableExtensions.<XAnnotation>head(annotations);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(_head_1);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_07() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Data class A {}");
    _builder.newLine();
    _builder.append("@Data class");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration typeDeclaration = IterableExtensions.<XtendTypeDeclaration>last(_xtendTypes);
    final EList<XAnnotation> annotations = typeDeclaration.getAnnotations();
    XAnnotation _head = IterableExtensions.<XAnnotation>head(annotations);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(_head);
    XAnnotation _head_1 = IterableExtensions.<XAnnotation>head(annotations);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(_head_1);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_08() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("annotation Bar { @");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration typeDeclaration = IterableExtensions.<XtendTypeDeclaration>last(_xtendTypes);
    EList<XtendMember> _members = typeDeclaration.getMembers();
    XtendMember _last = IterableExtensions.<XtendMember>last(_members);
    final EList<XAnnotation> annotations = _last.getAnnotations();
    XAnnotation _head = IterableExtensions.<XAnnotation>head(annotations);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(_head);
    XAnnotation _head_1 = IterableExtensions.<XAnnotation>head(annotations);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(_head_1);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_09() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property val S");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration typeDeclaration = IterableExtensions.<XtendTypeDeclaration>last(_xtendTypes);
    EList<XtendMember> _members = typeDeclaration.getMembers();
    XtendMember _last = IterableExtensions.<XtendMember>last(_members);
    final EList<XAnnotation> annotations = _last.getAnnotations();
    XAnnotation _head = IterableExtensions.<XAnnotation>head(annotations);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(_head);
    XAnnotation _head_1 = IterableExtensions.<XAnnotation>head(annotations);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(_head_1);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_10() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@SuppressWarnings(\"unused\"");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration typeDeclaration = IterableExtensions.<XtendTypeDeclaration>last(_xtendTypes);
    final EList<XAnnotation> annotations = typeDeclaration.getAnnotations();
    XAnnotation _head = IterableExtensions.<XAnnotation>head(annotations);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(_head);
    XAnnotation _head_1 = IterableExtensions.<XAnnotation>head(annotations);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(_head_1);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_11() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("annotation { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val inferred = \'bar\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration annotation = IterableExtensions.<XtendTypeDeclaration>last(_xtendTypes);
    EList<XtendMember> _members = annotation.getMembers();
    XtendMember _head = IterableExtensions.<XtendMember>head(_members);
    final XtendField field = ((XtendField) _head);
    final XExpression initializer = field.getInitialValue();
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(initializer);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(initializer);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_12() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Y {");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("static def <T> IExpectationSetters<T> expect(T value) {");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("HeaderAccess<?> unboundedMockHeaderAccess");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("val Object header = unboundedMockHeaderAccess.header");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("val IExpectationSettersObject> exp1 = expect(header)");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("val IExpectationSetters<Object> exp2 = expect(unboundedMockHeaderAccess.getHeader())");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface HeaderAccess<T> {");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("def T getHeader();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface IExpectationSetters<T> {}");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration y = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    EList<XtendMember> _members = y.getMembers();
    XtendMember _get = _members.get(3);
    final XtendField exp1 = ((XtendField) _get);
    final XExpression initializer = exp1.getInitialValue();
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(initializer);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(initializer);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_13() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Y {");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("static def <T> IExpectationSetters<T> expect(T value) {");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("HeaderAccess<?> unboundedMockHeaderAccess");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("val Object header = unboundedMockHeaderAccess.header");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("val IExpectationSetters<Object> exp1 = expect(header)");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("val IExpectationSetters<Object> exp2 = expect(unboundedMockHeaderAccess.getHeader())");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface IExpectationSetters<T> {}");
    _builder.newLine();
    _builder.append("interface HeaderAccess<T> {");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("def  getHeader();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration headerAccess = IterableExtensions.<XtendTypeDeclaration>last(_xtendTypes);
    EList<XtendMember> _members = headerAccess.getMembers();
    XtendMember _head = IterableExtensions.<XtendMember>head(_members);
    final XtendFunction function = ((XtendFunction) _head);
    Set<EObject> _jvmElements = this.associations.getJvmElements(function);
    EObject _head_1 = IterableExtensions.<EObject>head(_jvmElements);
    final JvmOperation operation = ((JvmOperation) _head_1);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(operation);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(operation);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_14() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class B extends  {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override foo(String x, String...args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("abstract class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String foo(String x, String...args)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration headerAccess = IterableExtensions.<XtendTypeDeclaration>last(_xtendTypes);
    EList<XtendMember> _members = headerAccess.getMembers();
    XtendMember _head = IterableExtensions.<XtendMember>head(_members);
    final XtendFunction function = ((XtendFunction) _head);
    Set<EObject> _jvmElements = this.associations.getJvmElements(function);
    EObject _head_1 = IterableExtensions.<EObject>head(_jvmElements);
    final JvmOperation operation = ((JvmOperation) _head_1);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(operation);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(operation);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_15() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@ class Node {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration node = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    EList<XAnnotation> _annotations = node.getAnnotations();
    final XAnnotation annotation = IterableExtensions.<XAnnotation>head(_annotations);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(annotation);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(annotation);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_16() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class <T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val String s");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("new(String ^new) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("s = ^new");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration unnamed = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    EList<XtendMember> _members = unnamed.getMembers();
    XtendMember _last = IterableExtensions.<XtendMember>last(_members);
    final XtendConstructor constructor = ((XtendConstructor) _last);
    XExpression _expression = constructor.getExpression();
    final XBlockExpression body = ((XBlockExpression) _expression);
    EList<XExpression> _expressions = body.getExpressions();
    XExpression _head = IterableExtensions.<XExpression>head(_expressions);
    final XAssignment assignment = ((XAssignment) _head);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(assignment);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(assignment);
    Assert.assertNotNull(_actualType);
  }
  
  public XtendFile processWithoutException(final CharSequence input) throws Exception {
    XtextResourceSet _resourceSet = this.getResourceSet();
    URI _createURI = URI.createURI("abcdefg.xtend");
    final Resource resource = _resourceSet.createResource(_createURI);
    String _string = input.toString();
    StringInputStream _stringInputStream = new StringInputStream(_string);
    resource.load(_stringInputStream, null);
    this.resourceValidator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    return ((XtendFile) _head);
  }
}
