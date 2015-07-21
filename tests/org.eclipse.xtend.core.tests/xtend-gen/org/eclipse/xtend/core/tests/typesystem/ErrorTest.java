/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.junit.typesystem.NoJRESmokeTester;
import org.eclipse.xtext.xbase.junit.typesystem.Oven;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ErrorTest extends AbstractXtendTestCase {
  public static class ResolveBatchedWithoutJRE extends NoJRESmokeTester {
    @Inject
    private IBatchTypeResolver resolver;
    
    @Override
    protected void checkNoErrorsInValidator(final String model, final XtextResource resource) {
      this.resolver.resolveTypes(resource);
      super.checkNoErrorsInValidator(model, resource);
    }
  }
  
  @Inject
  private IResourceValidator resourceValidator;
  
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Inject
  private IJvmModelAssociations associations;
  
  @Inject
  private ErrorTest.ResolveBatchedWithoutJRE noJRETester;
  
  @Inject
  @Extension
  private Oven _oven;
  
  @Test
  public void testErrorModel_001() throws Exception {
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
  public void testErrorModel_002() throws Exception {
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
  public void testErrorModel_003() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class TestXtend {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val static int a = 4");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Click(#[ a, a ])");
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
  public void testErrorModel_004() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class TestXtend {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val static int a = 4");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Click(#[ a, a ])");
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
  public void testErrorModel_005() throws Exception {
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
  public void testErrorModel_006() throws Exception {
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
  public void testErrorModel_007() throws Exception {
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
  public void testErrorModel_008() throws Exception {
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
  public void testErrorModel_009() throws Exception {
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
  public void testErrorModel_010() throws Exception {
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
  public void testErrorModel_011() throws Exception {
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
  public void testErrorModel_012() throws Exception {
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
  public void testErrorModel_013() throws Exception {
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
  public void testErrorModel_014() throws Exception {
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
  public void testErrorModel_015() throws Exception {
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
  public void testErrorModel_016() throws Exception {
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
  
  @Test
  public void testErrorModel_017() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static extension Throwables.*");
    _builder.newLine();
    _builder.append("import java.net.URI");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Throwables {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static <T> T propagate(()=>T proc, (Exception)=>Exception handler) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("proc.apply");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch(Exception e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw handler.apply(e)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Client {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("valuri = [| new URI(\'\')].propagate [ new IllegalArgumentException(it) ]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration client = IterableExtensions.<XtendTypeDeclaration>last(_xtendTypes);
    EList<XtendMember> _members = client.getMembers();
    XtendMember _head = IterableExtensions.<XtendMember>head(_members);
    final XtendField field = ((XtendField) _head);
    XExpression _initialValue = field.getInitialValue();
    final XMemberFeatureCall initializer = ((XMemberFeatureCall) _initialValue);
    EList<XExpression> _memberCallArguments = initializer.getMemberCallArguments();
    XExpression _head_1 = IterableExtensions.<XExpression>head(_memberCallArguments);
    final XClosure closure = ((XClosure) _head_1);
    EList<JvmFormalParameter> _implicitFormalParameters = closure.getImplicitFormalParameters();
    final JvmFormalParameter implicit = IterableExtensions.<JvmFormalParameter>head(_implicitFormalParameters);
    Assert.assertNotNull(implicit);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(implicit);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(implicit);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_018() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(@");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration c = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    EList<XtendMember> _members = c.getMembers();
    XtendMember _head = IterableExtensions.<XtendMember>head(_members);
    final XtendFunction function = ((XtendFunction) _head);
    EList<XtendParameter> _parameters = function.getParameters();
    final XtendParameter param = IterableExtensions.<XtendParameter>head(_parameters);
    EList<XAnnotation> _annotations = param.getAnnotations();
    final XAnnotation annotation = IterableExtensions.<XAnnotation>head(_annotations);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(annotation);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(annotation);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_019() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x");
    _builder.newLine();
    _builder.append("import bug396879.*");
    _builder.newLine();
    _builder.append("class Z {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("def addListeners(BooleanProperty prop) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val ChangeListenerBoolean> listener = [ p, oldValue, newValue | ]\t\tprop.addListener(listener)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration z = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    EList<XtendMember> _members = z.getMembers();
    XtendMember _get = _members.get(1);
    final XtendField field = ((XtendField) _get);
    XExpression _initialValue = field.getInitialValue();
    final XClosure closure = ((XClosure) _initialValue);
    EList<JvmFormalParameter> _declaredFormalParameters = closure.getDeclaredFormalParameters();
    final JvmFormalParameter param = IterableExtensions.<JvmFormalParameter>head(_declaredFormalParameters);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(param);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(param);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_020() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x");
    _builder.newLine();
    _builder.append("class Y {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@com.google.inject.Inject extension test.GenericExtensionMethods<String,Integer> x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String arg) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("arg.method");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
    final XtendTypeDeclaration y = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
    EList<XtendMember> _members = y.getMembers();
    XtendMember _last = IterableExtensions.<XtendMember>last(_members);
    final XtendFunction function = ((XtendFunction) _last);
    XExpression _expression = function.getExpression();
    final XBlockExpression body = ((XBlockExpression) _expression);
    EList<XExpression> _expressions = body.getExpressions();
    XExpression _head = IterableExtensions.<XExpression>head(_expressions);
    final XMemberFeatureCall featureCall = ((XMemberFeatureCall) _head);
    XExpression _implicitReceiver = featureCall.getImplicitReceiver();
    final XMemberFeatureCall implicitReceiver = ((XMemberFeatureCall) _implicitReceiver);
    final XExpression this_ = implicitReceiver.getMemberCallTarget();
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(this_);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(this_);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_021() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x class Z {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def generate(java.util.List<String> d, String fsa) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("d.iter(e | e.generate(fsa))");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void generate(String e, String fsa) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T,R> iter(java.util.List<T> list, (T)=>void proc) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for(element  list) { proc.apply(element); }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_022() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package generics class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends (Object)=>T> T bar( t) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar(t).apply(bar(t))");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_023() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package generics class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends (Object)=>T> T bar() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar(t).apply(bar(t))");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_024() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bug<A> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("A a");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(A a) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.a = a");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static of (A a) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Bug<A>(a)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_025() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x class Y {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bug343090(Integer a, Integer b) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("<Integer>addFunction.apply(a, b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends> addFunction() {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("[T a,T b|a+b] as (T,T)=>T");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_026() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x class Y {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bug343090(Integer a, Integer b) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("addFunction.apply(a, b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends> addFunction() {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("[T a,T b|a+b] as (T,T)=>T");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_027() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x class Y {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bug343090(Integer a, Integer b) {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<Integer>addFunction.apply(a, b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends> addFunction() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("[T a,T b|(a+b) as Integer] as (T,T)=>T");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_028() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x class Y {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bug343090(Integer a, Integer b) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("<Integer>addFunction.apply(a, b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends> addFunction() {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("[T a,T b|(a+b) as T] as (T,T)=>T");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_029() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x");
    _builder.newLine();
    _builder.append("class Y {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newArrayList(\'fo\',\'bar\').minBy[]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <A,B extends Comparable<? super B>> A minBy(Iterable<A> iterable, (A)=>B maxOn) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("iterable.sortBy(maxOn).last");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <A,B extends Comparable<? super B>> A minBy(java.util.Collection<A> iterable, (A)=>B maxOn) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("iterable.sortBy(maxOn).last");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_030() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x class Y {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bug343088(Integer a, Integer b) {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("addFunction.apply(a, b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends> (T,T)=>T addFunction() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("[T a,T b|(a+(b as Integer)) as T]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_031() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x class Y {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bug343088(Integer a, Integer b) {");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("addFunction.apply(a, b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends> (T,T)=>T addFunction() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("[T a,T b|(a+b) as T]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_032() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x class Y {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def bug343090(Integer a, Integer b) {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<Integer>addFunction.apply(a, b)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends > addFunction() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("[T a,T b|a+b] as (T,T)=>T");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_033() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x");
    _builder.newLine();
    _builder.append("import java.util.Collection");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("class Z {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def generate() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val List<CharSequence> seq = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val List<String> strings = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val result = seq.addAll2(strings)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val Collection<String> test = result");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val result2 = strings.addAll3(seq)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val Collection<String> test2 = result2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <N extends N> Collection<K> addAll2(Collection<N> collection, Iterable<K> elements){");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("collection.addAll(elements)");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <N, K extends N> Collection<K> addAll3(Iterable<K> elements, Collection<N> collection){");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("collection.addAll(elements)");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_034() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x");
    _builder.newLine();
    _builder.append("import java.util.Collection");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("class Z {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def generate() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val List<CharSequence> seq = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val List<String> strings = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val result = seq.addAll2(strings)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val Collection<CharSequence> test = result");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val result2 = strings.addAll3(seq)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val Collection<CharSequence> test2 = result2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends T> Collection<T> addAll2(Collection<T> collection, Iterable<U> elements){");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("collection.addAll(elements)");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("collection.<T>addAll(elements)");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T, U extends T> Collection<T> addAll3(Iterable<U> elements, Collection<T> collection){");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("collection.addAll(elements)");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("collection.<T>addAll(elements)");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_035() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x");
    _builder.newLine();
    _builder.append("import java.util.Collection");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("class Z {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def generate() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val List<CharSequence> seq = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val List<String> strings = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val result = seq.addAll2(strings)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val Collection<CharSequence> test = result");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val result2 = strings.addAll3(seq)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val Collection<CharSequence> test2 = result2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T1 extends T2, T2 extends T1> Collection<T1> addAll2(Collection<T1> collection, Iterable<T2> elements){");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("collection.addAll(elements)");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("collection.<T2>addAll(elements)");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_036() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bar<T extends T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new Bar(T t) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_037() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bar<T1 extends T2, T2 extends T1> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new Bar(T1 t1, T2 t2) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_038() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import bug380058.Amount");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import static bug380058.SI.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class JScienceTest {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def void test() { ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("val w = Amount::valueOf(100, MILLIMETER)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("val h = Amount::valueOf(50, MILLIMETER)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("val perim = w.plus(h).times(2)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("println(\"perim = \" + perim)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_039() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("abstract class Option<T> {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def <X> Option<X> map((T)=>X f) { switch this {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Some<T> : new Some<X>(f.apply(get))");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("None<T> : new None<X>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Some<T> extends Option<T> {}");
    _builder.newLine();
    _builder.append("class None<T> extends Option<T> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_040() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("abstract class Option<T> {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def <X> Option<X> map((T)=>X f) { switch this {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Some<T> : new Some<X>(f.apply(get))");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("None<T> : new None<X>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class Intermediate1<T> extends Option<T> {}");
    _builder.newLine();
    _builder.append("class Intermediate2<T> extends Intermediate1<T> {}");
    _builder.newLine();
    _builder.append("class Some<T> extends Intermediate2<T> {}");
    _builder.newLine();
    _builder.append("class None<T> extends Intermediate2<T> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_041() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class E<T> extends E<T> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_042() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C<T> extends E<T> {}");
    _builder.newLine();
    _builder.append("class D<T> extends C<T> {}");
    _builder.newLine();
    _builder.append("class E<T> extends D<T> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_043() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Data class Weight<T extends Comparable> implements Comparable<Weight<T>> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("T weight");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override int compareTo(Weight w) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.weight.compareTo(w.weight)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_044() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Data class Weight<T extends Comparable<T>> implements Comparable<Weight<T>> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("T weight");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override int compareTo(Weight<T> w) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.weight.compareTo(w.weight)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_045() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Data class Weight<T extends Comparable<T>> implements Comparable<Weight<T>> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("T weight");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override int compareTo(Weight<T> w) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this..compareTo(w.weight)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_046() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("annotation DependsOn {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Class<?>[] value = #[ typeof(), typeof(CharSequence) ]");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_047() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Data class Weight<T extends Comparable<T>> implements Comparable<Weight<T>> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("T weight");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override int compareTo(Weight<T> w) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.weight.compareTo");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_048() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Data class Weight<T extends Comparable<Iterable<T>>> implements Comparable<Iterable<Weight<T>>> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("T weight");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override int compareTo(Iterable<Weight<T>> w) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.weight.compareTo(w.head.weight)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_049() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(Class<?> type) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("type.enumConstants.findFirst[ it != null]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_050() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def void m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("#[ \'\' ].flatMap[].sortBy [length]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <A,B> Iterable<? extends B> flatMap(Iterable<? extends A> iterable, (A)=>B map) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_051() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val list = #[ \'\' ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Test def void m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("#[ \'\' ].flatMap[].sortBy [length]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <A,B> Iterable<B> flatMap(Iterable<? extends A> iterable, (A)=>B map) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_052() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import com.google.inject.Injector");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <T extends Comparable<T>, X extends void m(T t, X x) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(\'\', \'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Injector i, Class<? extends CharSequence> c) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\'\'.m(\'\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_053() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C extends D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(int it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("substring");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("it.substring");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected extension String");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_054() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtext.xbase.lib.Extension");
    _builder.newLine();
    _builder.append("class C extends D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(int it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("substring");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("it.substring");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Extension protected String string");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_055() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C extends D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected extension String local");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(int it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("substring");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected extension String inherited");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_056() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C extends D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected extension CharSequence local");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(int it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("charAt");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected extension String inherited");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_057() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x class Y {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static int j");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int i");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this(j)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(int i) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.i = i");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static invokeMe() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("j = 47 new .i");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_058() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("{ ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("var Object x = (\'\' a<b>).toString() ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("x ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_059() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("{ ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("var Object x = null");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("x ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} + \'\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_060() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newArrayList.fold(newHashMap) [a,b | a.put]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_061() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C<T> implements C1<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(C1<?> p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(this)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface C1<A1> extends C2<A1> {}");
    _builder.newLine();
    _builder.append("interface C2<A2> extends C3<A2, C2<A2>> {}");
    _builder.newLine();
    _builder.append("interface C3<A3, B3> extends C4<A3, C1<A3>> {}");
    _builder.newLine();
    _builder.append("interface C4<A4, B4> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_062() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(C1<?> p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(a)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface C1<A1> extends C2<A1> {}");
    _builder.newLine();
    _builder.append("interface C2<A2> extends C3<A2, C2<A2>> {}");
    _builder.newLine();
    _builder.append("interface C3<A3, B3> extends C4<A3, C1<A3>> {}");
    _builder.newLine();
    _builder.append("interface C4<A4, B4> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_063() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(C1<?> p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(null as C1<String>)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface C1<A1> extends C2<A1> {}");
    _builder.newLine();
    _builder.append("interface C2<A2> extends C3<A2, C2<A2>> {}");
    _builder.newLine();
    _builder.append("interface C3<A3, B3> extends C4<A3, C1<A3>> {}");
    _builder.newLine();
    _builder.append("interface C4<A4, B4> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_064() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C<T> implements C1<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(C1<T> p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(this)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface C1<A1> extends C2<A1> {}");
    _builder.newLine();
    _builder.append("interface C2<A2> extends C3<A2, C2<A2>> {}");
    _builder.newLine();
    _builder.append("interface C3<A3, B3> extends C4<A3, C1<A3>> {}");
    _builder.newLine();
    _builder.append("interface C4<A4, B4> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_065() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(C1<String> p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(a)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface C1<A1> extends C2<A1> {}");
    _builder.newLine();
    _builder.append("interface C2<A2> extends C3<A2, C2<A2>> {}");
    _builder.newLine();
    _builder.append("interface C3<A3, B3> extends C4<A3, C1<A3>> {}");
    _builder.newLine();
    _builder.append("interface C4<A4, B4> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_066() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(C1<String> p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(null as C1<String>)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface C1<A1> extends C2<A1> {}");
    _builder.newLine();
    _builder.append("interface C2<A2> extends C3<A2, C2<A2>> {}");
    _builder.newLine();
    _builder.append("interface C3<A3, B3> extends C4<A3, C1<A3>> {}");
    _builder.newLine();
    _builder.append("interface C4<A4, B4> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_067() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C<T> implements C1<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(C2<?> p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(this)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface C1<A1> extends C2<A1> {}");
    _builder.newLine();
    _builder.append("interface C2<A2> extends C3<A2, C2<A2>> {}");
    _builder.newLine();
    _builder.append("interface C3<A3, B3> extends C4<A3, C1<A3>> {}");
    _builder.newLine();
    _builder.append("interface C4<A4, B4> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_068() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C<T> implements C1<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(C3<?, ?> p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(this)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface C1<A1> extends C2<A1> {}");
    _builder.newLine();
    _builder.append("interface C2<A2> extends C3<A2, C2<A2>> {}");
    _builder.newLine();
    _builder.append("interface C3<A3, B3> extends C4<A3, C1<A3>> {}");
    _builder.newLine();
    _builder.append("interface C4<A4, B4> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_069() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C<T> implements C1<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(C4<?, ?> p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(this)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface C1<A1> extends C2<A1> {}");
    _builder.newLine();
    _builder.append("interface C2<A2> extends C3<A2, C2<A2>> {}");
    _builder.newLine();
    _builder.append("interface C3<A3, B3> extends C4<A3, C1<A3>> {}");
    _builder.newLine();
    _builder.append("interface C4<A4, B4> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_070() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(C1<?> p) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(a)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface C1<A1> extends C2<C1<C1<A1>>> {}");
    _builder.newLine();
    _builder.append("interface C2<A2> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_071() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <A> Map<A, Expression<A>> then(Expression<A> expr) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <A extends Number & Comparable<?>> Map<A, NumberExpression<A>> then(NumberExpression<A> expr) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val NumberPath<Long> = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val y = then(count)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(y)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class NumberPath<T extends Number & Comparable<?>> extends NumberExpression<T> {}");
    _builder.newLine();
    _builder.append("class NumberExpression<T extends Number & Comparable<?>> extends ComparableExpressionBase<T> {}");
    _builder.newLine();
    _builder.append("class ComparableExpressionBase<T extends Comparable<?>> extends SimpleExpression<T> {}");
    _builder.newLine();
    _builder.append("class SimpleExpression<T> extends ExpressionBase<T> {}");
    _builder.newLine();
    _builder.append("class ExpressionBase<T> implements Expression<T> {}");
    _builder.newLine();
    _builder.append("interface Expression<T> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_072() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class TestTypes {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var A tmp = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (tmp) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("B: {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("tmp = tmp.bar ?: tmp.baz");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def B bar(Object x) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return x as B");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def C baz(Object x) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return x as C");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class A {}");
    _builder.newLine();
    _builder.append("class B extends }");
    _builder.newLine();
    _builder.append("class C extends A {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_073() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static dispatch m(DoesNotExist d) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("m(d)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_074() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(int it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for(ension s: <String>newArrayList) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("substring");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_075() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(int it) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for(xtension s: <String>newArrayList) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("substring");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_076() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String m(boolean b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch \'a\' {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case \'b\': \'a\'");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case \'c\': {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("return \'b\'");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("return \'c\'");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(file);
    TreeIterator<EObject> _eAllContents = file.eAllContents();
    Iterator<XIfExpression> _filter = Iterators.<XIfExpression>filter(_eAllContents, XIfExpression.class);
    final XIfExpression ifExpression = IteratorExtensions.<XIfExpression>head(_filter);
    XExpression _then = ifExpression.getThen();
    Assert.assertNull(_then);
    XExpression _else = ifExpression.getElse();
    Assert.assertNull(_else);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(ifExpression);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_077() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try return \'literal\' as as Boolean");
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("catch(NullPointerException e) return \'second thing is thrown\'\t\t  ");
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("catch(ClassCastException e) throw new NullPointerException()");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(file);
    TreeIterator<EObject> _eAllContents = file.eAllContents();
    Iterator<XCastedExpression> _filter = Iterators.<XCastedExpression>filter(_eAllContents, XCastedExpression.class);
    final XCastedExpression casted = IteratorExtensions.<XCastedExpression>last(_filter);
    JvmTypeReference _type = casted.getType();
    Assert.assertNull(_type);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(casted);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_078() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package org.eclipse.xtend.core.tests.smoke");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Case_4 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def richStrings_01() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\'\'");
    _builder.append("\'foobar\'");
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_079() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package org.eclipse.xtend.core.tests.smoke");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Case_4 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def richStrings_01() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\'\'");
    _builder.append("\'foobar\'\'");
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_080() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package org.eclipse.xtend.core.tests.smoke");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Case_4 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def richStrings_01() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\'\'");
    _builder.append("\'foobar\'");
    _builder.append(" ");
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_081() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package org.eclipse.xtend.core.tests.smoke");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Case_4 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def richStrings_01() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("\'\'");
    _builder.append("\'foobar\'\'");
    _builder.append(" ");
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_082() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x");
    _builder.newLine();
    _builder.append("class Y {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static int j");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int i");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this(j)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(int i) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.i = i");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static invokeMe() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("j = 4ew Y().i");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_083() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x");
    _builder.newLine();
    _builder.append("class Y {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@com.google.inject.Inject extension test.GenericExtensionMethods<String,Integer> x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(String arg) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("arg.method");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("4ethod");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return x.result");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_084() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(int bar) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch(bar) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case 1bar\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_085() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("/**/");
    _builder.newLine();
    _builder.append("/***/");
    _builder.newLine();
    _builder.append("/** valid */");
    _builder.newLine();
    _builder.append("/** valid **/");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* invalid/");
    _builder.newLine();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def foo(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("1 + 1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_086() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_087() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_088() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* header");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*//**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* javadoc");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class bar { ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_089() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_090() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/");
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_091() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_092() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_093() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(java.util.List<String[]> arg) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def n() {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("m(#[[\'a\', \'a\']])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_094() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def enumValue(Class<?> clazz, String value) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if(clazz.enum)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Enum.valueOf(clazz as Class<Enum>, value)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_095() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def add(T item) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_096() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def add(T item) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("new(A<B> gen) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.gen = gen");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_097() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m(Class<?>... c) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("class B extends A {");
    _builder.newLine();
    _builder.append(" \t\t");
    _builder.append("override m(Class<? extends Object>... c) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_098() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.LinkedList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class XList<T extends XType> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val items = new LinkedList<XItem<T>>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def add(T item) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val result = new XItem<T>(this, item)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("items.add(result)");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("interface XType {}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class XItem<T extends XType> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("XList<T> gen");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("T item");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(XList<T> gen, T item) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.gen = gen");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.item = item");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_099() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x ");
    _builder.newLine();
    _builder.append("class Y {  ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static int j   ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int i   ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() { ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this(j   ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new(int i) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.i = i");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}   ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def static invokeMe() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("j = 47 new Y().i");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_100() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x class Y {def dispatch void recursiveMethod(CharSequence r, java.util.Set<Object> shapes) {}");
    _builder.newLine();
    _builder.append("def dispatch vorecursiveMethod(Appendable c, java.util.Set<Object> shapes) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// If method2 is called directly, no NPE is thrown");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val Object o = method1()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("def Object method1() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return method2()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("// Inferred return type that causes the NPE");
    _builder.newLine();
    _builder.append("def method2() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val java.util.Set<Object> objects = newHashSet()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// If the recursive method is not called, no NPE is thrown");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("recursiveMethod(new String(), objects)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return objects.findFirst([ Object o | o instanceof CharSequence])");
    _builder.newLine();
    _builder.append("}}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_101() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package bug411973 class Bug {val ()=>String init new() { this([|\"Hello World!\"]new(()=>String init) { this.init = init } @Override override toString() { init.apply } }");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_102() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x class Y {def String rawListGet(java.util.List elements) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (elements.(0) instanceof String) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\'string\'");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} else {    \'no string\'  }}}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_103() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static dispatch apply(String element) {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("throw new UnsupportedOperationException(\"missing implementation for \" + element.class)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_104() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import com.google.common.base.Optional");
    _builder.newLine();
    _builder.append("import static java.lang.Enum.*");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import java.util.Set");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Optional<Object> m2(Object o, List<Object> list, Object context, Set<Object> set) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (o instanceof String) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val idx = valueOf(null, null)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("idx.present");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_105() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C extends Override {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_106() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C extends java.lang.annotation.RetentionPolicy {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_107() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Override x");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_108() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Override<String> x");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_109() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Override<String> x() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_110() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def x(Override<String> o) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_111() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("java.lang.annotation.RetentionPolicy<String> x");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_112() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package x");
    _builder.newLine();
    _builder.append("class Y {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newArrayList(\'fo\',\'bar\').maxBy[]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <A,B extends Comparable<? super B>> A maxBy(Iterable<A> iterable, (A)=>B maxOn) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("iterable.sortBy(maxOn).last");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_113() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package org.eclipse.xtend.core.tests.smoke");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Case_2 {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def aOrB(String a, String b) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (a.isNullOrEmpty()) ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("b");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("a ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def returnInIf() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (\'x\'!=) return \'xx\' else return \'yy\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_114() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Runnable() { override run() {} }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_115() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("valr = new Runnable() { override run() { println(x) } }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public val x = 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_116() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("valbar = new Runnable() { override run() {} }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_117() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val r = new Runnable() { override run() { println(x) } }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public val x = 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_118() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(Iterable<String> iterable) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("iterable.flatMap[].sortBy [ length ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <A,B extends Iterable<? extends B> flatMap(Iterable<? extends A> iterable, (A)=>B map) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_119() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(Iterable<String> iterable) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("iterable.flatMap[].sortBy [ length ]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <A,B extends Iterable<? extends B>> flatMap(Iterable<? extends A> iterable, (A)=>B map) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return null");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_120() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("StringRepository repository");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m()\t{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("var string = repository.findByStringId(1L)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("repository.save(string)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("public interface StringRepository extends GraphRepository<String> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String findByStringId(Long id);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface GraphRepository<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <U extends U save(U entity);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <U extends T> Iterable<U> save(Iterable<U> entities);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_121() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C { StringRepository repository def m()\t{ repository.save(#[]) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("public interface StringRepository extends GraphRepository<String> { def String findByStringId(Long id);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface GraphRepository<T> { def <U extends U save(U entity); def <U extends T> Iterable<U> save(Iterable<U> entities);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_122() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C { CharSeqRepository repository def m()\t{ repository.<String>save(newArrayList) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("public interface CharSeqRepository extends GraphRepository<CharSequence> {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface GraphRepository<T> { def <U extends U save(U entity); def <U extends T> Iterable<U> save(Iterable<U> entities);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_123() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C { CharSeqRepository repository def m()\t{ repository.save(#[\'a\']) }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("public interface CharSeqRepository extends GraphRepository<CharSequence> {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface GraphRepository<T> { def <U extends U save(U entity); def <U extends T> Iterable<U> save(Iterable<U> entities);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_124() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static com.google.common.base.Preconditions.*");
    _builder.newLine();
    _builder.append("class Test<JAVA_TYPE> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val Functions.Function0<JAVA_TYPE> constructor");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val list = new(Functions.Function0<JAVA_TYPE> theConstructor, Class<JAVA_TYPE> theType) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("constructor = if (theConstructor == null) new NoConstructor<JAVA_TYPE>(theType) else theConstructor");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static test(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Test(null, String)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class NoConstructor<JAVA_TYPE> implements Functions.Function0<JAVA_TYPE> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val String type");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(String theTypeName) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("type = checkNotNull(theTypeName, \"theTypeName\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(Class<JAVA_TYPE> theType) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("type = checkNotNull(theType, \"theType\").name");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override apply() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new UnsupportedOperationException(\"Instances of type \"+type +\" cannot be created (without parameters?)\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_125() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static interface B {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("A a");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("B b");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("C c");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("D d");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("static class D {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("A a");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("B b =  A.B {}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("C c = new C");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("D d = new B.C.D {}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("A a");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("B b = new B {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("B.C c");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("B.C.D d");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_126() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Object foo() throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val (java.util.List<String>,String)=>java.util.List<String> functionReturningList = [$");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_127() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Object foo() throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val (java.util.List<String>,String)=>java.util.List<String> functionReturningList = [$ += $1 return $0 ]");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("#[\'foo\'].fold(newArrayList, functionReturningList)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_128() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension Util");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getRunnable() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Runnable {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("override ru {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("sayHello");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static class Util {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def sayHello() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\'Hello\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_129() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def getRunnable() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val extension Util u = null");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Runnable {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("override ru {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("sayHello");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static class Util {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("def sayHello() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\'Hello\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_130() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val int a");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val String b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@FinalFieldsConstructor new()");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_131() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val int a");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val String b");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@FinalFieldsConstructor new() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_132() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor");
    _builder.newLine();
    _builder.append("@FinalFieldsConstructor");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val int a");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@FinalFieldsConstructor new");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_133() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor");
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val int a");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@FinalFieldsConstructor new() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("FinalFieldsConstructor new() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_134() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static interface B {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("static class D {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("B b = B.C ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("c B.C");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_135() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import .eclipse.xtend.lib.annotations.ToString");
    _builder.newLine();
    _builder.append("import org.eclipse.xtend.lib.annotations.Data");
    _builder.newLine();
    _builder.append("@ToString(hideFieldNames=true) @Data class Foo { String b = \"Bar\"");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_136() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("final class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static extension D = D.instance");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("package abstract class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static instance() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_137() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m0() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new D().m2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override protected m1() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new Object() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("override m3() \'\'");
    _builder.append("\'\'");
    _builder.append("\'\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m2() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this._oven.fireproof(_builder);
  }
  
  @Test
  public void testErrorModel_138() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package test");
    _builder.newLine();
    _builder.append("class Bar<T> extends test.Bar.Foo<T> {}");
    _builder.newLine();
    final XtendFile file = this.processWithoutException(_builder);
    Resource _eResource = file.eResource();
    EList<Resource.Diagnostic> _errors = _eResource.getErrors();
    final Procedure1<EList<Resource.Diagnostic>> _function = new Procedure1<EList<Resource.Diagnostic>>() {
      @Override
      public void apply(final EList<Resource.Diagnostic> it) {
        String _string = it.toString();
        final Function1<Resource.Diagnostic, Boolean> _function = new Function1<Resource.Diagnostic, Boolean>() {
          @Override
          public Boolean apply(final Resource.Diagnostic it) {
            String _message = it.getMessage();
            return Boolean.valueOf(_message.startsWith("Cyclic "));
          }
        };
        boolean _exists = IterableExtensions.<Resource.Diagnostic>exists(it, _function);
        Assert.assertFalse(_string, _exists);
      }
    };
    ObjectExtensions.<EList<Resource.Diagnostic>>operator_doubleArrow(_errors, _function);
  }
  
  @Test
  public void testErrorModel_139() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("MyComparator.comparingInt [String s| s.length].thenComparing[]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("static abstract class MyComparator<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static <T> MyComparator<T> comparingInt(ToIntFunction<? super T> fun) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <U extends Comparable<? super U>> MyComparator<T> thenComparing(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Function<? super T, ? extends U> keyExtractor,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("MyComparator<? super U> keyComparator)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def MyComparator<T> thenComparing(MyComparator<? super T> other)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <U extends Comparable<? super U>> MyComparator<T> thenComparing(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Function<? super T, ? extends U> keyExtractor)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface ToIntFunction<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def int apply(T t)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface Function<T, R> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def R apply(T)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_140() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("MyComparator.comparingInt [String s| s.length].thenComparing[]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("static abstract class MyComparator<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static <T> MyComparator<T> comparingInt(ToIntFunction<? super T> fun) {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <U extends Comparable<? super Iterable<? extends U>>> MyComparator<T> thenComparing(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Function<? super T, ? extends U> keyExtractor,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("MyComparator<? super U> keyComparator)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def MyComparator<T> thenComparing(MyComparator<? super T> other)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <U extends Comparable<? super U>> MyComparator<T> thenComparing(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Function<? super T, ? extends U> keyExtractor)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface ToIntFunction<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def int apply(T t)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("interface Function<T, R> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def R apply(T)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_141() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.lib.annotations.Data");
    _builder.newLine();
    _builder.append("@D class A {}");
    _builder.newLine();
    _builder.append("@Data class C extends A { val int c }");
    _builder.newLine();
    _builder.append("@Data class B { val int b }");
    _builder.newLine();
    _builder.append("@Data class D extends B { val double d }");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_142() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class TestXtend {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val static int a = Click(#[ a, a.bitwiseAnd(3) << 1 ])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def meth() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation Click {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_143() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void test()");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_144() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def create \"\" test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("_createCache_test.clear");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.noJRETester.processFile(_builder.toString());
  }
  
  @Test
  public void testErrorModel_145() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import com.google.common.base.Function");
    _builder.newLine();
    _builder.append("abstract class C<A> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def A get();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <B> C<B> map(Function<A, B> f) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val thiz = this");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return [");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val A a = thiz.get");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val B b = f.applya)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return b");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.processWithoutException(_builder);
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
