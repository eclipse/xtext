/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.macro.lang.processing;

import java.util.List;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.macro.RegistrationContext;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Basic implementation of Registration context.
 * 
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class RegistrationContextImpl implements RegistrationContext {
  private IJvmDeclaredTypeAcceptor _acceptor;
  
  public IJvmDeclaredTypeAcceptor getAcceptor() {
    return this._acceptor;
  }
  
  public void setAcceptor(final IJvmDeclaredTypeAcceptor acceptor) {
    this._acceptor = acceptor;
  }
  
  private JvmTypesBuilder _typesBuilder;
  
  public JvmTypesBuilder getTypesBuilder() {
    return this._typesBuilder;
  }
  
  public void setTypesBuilder(final JvmTypesBuilder typesBuilder) {
    this._typesBuilder = typesBuilder;
  }
  
  private XtendFile _source;
  
  public XtendFile getSource() {
    return this._source;
  }
  
  public void setSource(final XtendFile source) {
    this._source = source;
  }
  
  private List<XtendAnnotationTarget> _annotatedElements;
  
  public List<XtendAnnotationTarget> getAnnotatedElements() {
    return this._annotatedElements;
  }
  
  public void setAnnotatedElements(final List<XtendAnnotationTarget> annotatedElements) {
    this._annotatedElements = annotatedElements;
  }
  
  private IJvmModelAssociator _associator;
  
  public IJvmModelAssociator getAssociator() {
    return this._associator;
  }
  
  public void setAssociator(final IJvmModelAssociator associator) {
    this._associator = associator;
  }
  
  public void registerAnnotation(final String name) {
    List<XtendAnnotationTarget> _annotatedElements = this.getAnnotatedElements();
    XtendAnnotationTarget _head = IterableExtensions.<XtendAnnotationTarget>head(_annotatedElements);
    final Procedure1<JvmAnnotationType> _function = new Procedure1<JvmAnnotationType>() {
        public void apply(final JvmAnnotationType it) {
        }
      };
    final JvmAnnotationType annoType = this._typesBuilder.toAnnotationType(_head, name, _function);
    IJvmDeclaredTypeAcceptor _acceptor = this.getAcceptor();
    _acceptor.<JvmAnnotationType>accept(annoType);
  }
  
  public void registerClass(final String name) {
    List<XtendAnnotationTarget> _annotatedElements = this.getAnnotatedElements();
    XtendAnnotationTarget _head = IterableExtensions.<XtendAnnotationTarget>head(_annotatedElements);
    final JvmGenericType annoType = this._typesBuilder.toClass(_head, name);
    IJvmDeclaredTypeAcceptor _acceptor = this.getAcceptor();
    _acceptor.<JvmGenericType>accept(annoType);
  }
  
  public void registerEnum(final String name) {
    List<XtendAnnotationTarget> _annotatedElements = this.getAnnotatedElements();
    XtendAnnotationTarget _head = IterableExtensions.<XtendAnnotationTarget>head(_annotatedElements);
    final Procedure1<JvmEnumerationType> _function = new Procedure1<JvmEnumerationType>() {
        public void apply(final JvmEnumerationType it) {
        }
      };
    final JvmEnumerationType annoType = this._typesBuilder.toEnumerationType(_head, name, _function);
    IJvmDeclaredTypeAcceptor _acceptor = this.getAcceptor();
    _acceptor.<JvmEnumerationType>accept(annoType);
  }
  
  public void registerInterface(final String name) {
    List<XtendAnnotationTarget> _annotatedElements = this.getAnnotatedElements();
    XtendAnnotationTarget _head = IterableExtensions.<XtendAnnotationTarget>head(_annotatedElements);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
        }
      };
    final JvmGenericType annoType = this._typesBuilder.toInterface(_head, name, _function);
    IJvmDeclaredTypeAcceptor _acceptor = this.getAcceptor();
    _acceptor.<JvmGenericType>accept(annoType);
  }
}
