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
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
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
  
  @Test
  public void testErrorModel_17() throws Exception {
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
    final JvmFormalParameter implicit = closure.getImplicitParameter();
    Assert.assertNotNull(implicit);
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(implicit);
    LightweightTypeReference _actualType = resolvedTypes.getActualType(implicit);
    Assert.assertNotNull(_actualType);
  }
  
  @Test
  public void testErrorModel_18() throws Exception {
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
  public void testErrorModel_19() throws Exception {
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
  public void testErrorModel_20() throws Exception {
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
  public void testErrorModel_21() throws Exception {
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
  public void testErrorModel_22() throws Exception {
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
  public void testErrorModel_23() throws Exception {
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
  public void testErrorModel_24() throws Exception {
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
  public void testErrorModel_25() throws Exception {
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
  public void testErrorModel_26() throws Exception {
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
  public void testErrorModel_27() throws Exception {
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
  public void testErrorModel_28() throws Exception {
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
  public void testErrorModel_30() throws Exception {
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
  public void testErrorModel_31() throws Exception {
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
  public void testErrorModel_32() throws Exception {
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
  public void testErrorModel_33() throws Exception {
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
  public void testErrorModel_34() throws Exception {
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
  public void testErrorModel_35() throws Exception {
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
  public void testErrorModel_36() throws Exception {
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
  public void testErrorModel_37() throws Exception {
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
  public void testErrorModel_38() throws Exception {
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
  public void testErrorModel_39() throws Exception {
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
  public void testErrorModel_40() throws Exception {
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
  public void testErrorModel_41() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class E<T> extends E<T> {}");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_42() throws Exception {
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
  public void testErrorModel_43() throws Exception {
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
  public void testErrorModel_44() throws Exception {
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
  public void testErrorModel_45() throws Exception {
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
  public void testErrorModel_46() throws Exception {
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
  public void testErrorModel_47() throws Exception {
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
  public void testErrorModel_48() throws Exception {
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
  public void testErrorModel_49() throws Exception {
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
  public void testErrorModel_50() throws Exception {
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
  public void testErrorModel_51() throws Exception {
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
  public void testErrorModel_52() throws Exception {
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
  public void testErrorModel_53() throws Exception {
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
  public void testErrorModel_54() throws Exception {
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
  public void testErrorModel_55() throws Exception {
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
  public void testErrorModel_56() throws Exception {
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
  public void testErrorModel_57() throws Exception {
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
  public void testErrorModel_58() throws Exception {
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
  public void testErrorModel_59() throws Exception {
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
  public void testErrorModel_60() throws Exception {
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
  public void testErrorModel_61() throws Exception {
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
  public void testErrorModel_62() throws Exception {
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
  public void testErrorModel_63() throws Exception {
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
  public void testErrorModel_64() throws Exception {
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
  public void testErrorModel_65() throws Exception {
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
  public void testErrorModel_66() throws Exception {
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
  public void testErrorModel_67() throws Exception {
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
  public void testErrorModel_68() throws Exception {
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
  public void testErrorModel_69() throws Exception {
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
  public void testErrorModel_70() throws Exception {
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
  public void testErrorModel_71() throws Exception {
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
  public void testErrorModel_72() throws Exception {
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
  public void testErrorModel_73() throws Exception {
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
  public void testErrorModel_74() throws Exception {
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
  public void testErrorModel_75() throws Exception {
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
  public void testErrorModel_76() throws Exception {
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
  public void testErrorModel_77() throws Exception {
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
  public void testErrorModel_78() throws Exception {
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
  public void testErrorModel_79() throws Exception {
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
  public void testErrorModel_80() throws Exception {
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
  public void testErrorModel_81() throws Exception {
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
  public void testErrorModel_82() throws Exception {
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
  public void testErrorModel_83() throws Exception {
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
  public void testErrorModel_84() throws Exception {
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
  public void testErrorModel_85() throws Exception {
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
  public void testErrorModel_86() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_87() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/");
    _builder.newLine();
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_88() throws Exception {
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
  public void testErrorModel_89() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_90() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/");
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_91() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_92() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    this.processWithoutException(_builder);
  }
  
  @Test
  public void testErrorModel_93() throws Exception {
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
  public void testErrorModel_94() throws Exception {
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
  public void testErrorModel_95() throws Exception {
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
  public void testErrorModel_96() throws Exception {
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
