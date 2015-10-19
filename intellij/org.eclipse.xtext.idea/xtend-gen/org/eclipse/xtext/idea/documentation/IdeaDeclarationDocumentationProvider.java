/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.documentation;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.idea.filesystem.IdeaProjectConfig;
import org.eclipse.xtext.idea.filesystem.IdeaProjectConfigProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.PsiEObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaDeclarationDocumentationProvider {
  @Inject
  private IdeaProjectConfigProvider projectConfigProvider;
  
  @Inject
  private IQualifiedNameProvider qNameProvider;
  
  @Inject
  private IEObjectDocumentationProvider eObjectDocProvider;
  
  protected String getElementInfo(final PsiEObject element) {
    final EObject obj = element.getEObject();
    final QualifiedName name = this.qNameProvider.getFullyQualifiedName(obj);
    if ((name != null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<b>");
      EClass _eClass = obj.eClass();
      String _name = _eClass.getName();
      _builder.append(_name, "");
      _builder.append(" \'");
      _builder.append(name, "");
      _builder.append("\'</b>");
      return _builder.toString();
    } else {
      Iterable<EObject> _allContainers = EcoreUtil2.getAllContainers(obj);
      final Function1<EObject, QualifiedName> _function = new Function1<EObject, QualifiedName>() {
        @Override
        public QualifiedName apply(final EObject it) {
          return IdeaDeclarationDocumentationProvider.this.qNameProvider.getFullyQualifiedName(it);
        }
      };
      Iterable<QualifiedName> _map = IterableExtensions.<EObject, QualifiedName>map(_allContainers, _function);
      final Function1<QualifiedName, Boolean> _function_1 = new Function1<QualifiedName, Boolean>() {
        @Override
        public Boolean apply(final QualifiedName it) {
          return Boolean.valueOf((it != null));
        }
      };
      final QualifiedName container = IterableExtensions.<QualifiedName>findFirst(_map, _function_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<b>");
      EClass _eClass_1 = obj.eClass();
      String _name_1 = _eClass_1.getName();
      _builder_1.append(_name_1, "");
      _builder_1.append(" in \'");
      _builder_1.append(container, "");
      _builder_1.append("\'</b>");
      return _builder_1.toString();
    }
  }
  
  protected String getFileInfo(final PsiEObject element) {
    EObject _eObject = element.getEObject();
    final Resource resource = _eObject.eResource();
    ResourceSet _resourceSet = resource.getResourceSet();
    final IdeaProjectConfig projectConfig = this.projectConfigProvider.getProjectConfig(_resourceSet);
    if ((projectConfig != null)) {
      URI _uRI = resource.getURI();
      URI _path = projectConfig.getPath();
      final URI uri = _uRI.deresolve(_path);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[");
      String _name = projectConfig.getName();
      _builder.append(_name, "");
      _builder.append("] ");
      _builder.append(uri, "");
      return _builder.toString();
    } else {
      URI _uRI_1 = resource.getURI();
      return _uRI_1.lastSegment();
    }
  }
  
  public String getQuickNavigateInfo(final PsiEObject element) {
    StringConcatenation _builder = new StringConcatenation();
    String _elementInfo = this.getElementInfo(element);
    _builder.append(_elementInfo, "");
    _builder.newLineIfNotEmpty();
    String _fileInfo = this.getFileInfo(element);
    _builder.append(_fileInfo, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String generateDoc(final PsiEObject element) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("\t");
    String _elementInfo = this.getElementInfo(element);
    _builder.append(_elementInfo, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("</p>");
    _builder.newLine();
    _builder.append("<br/>");
    _builder.newLine();
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("\t");
    String _fileInfo = this.getFileInfo(element);
    _builder.append(_fileInfo, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("</p>");
    _builder.newLine();
    _builder.append("<br/>");
    _builder.newLine();
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("\t");
    EObject _eObject = element.getEObject();
    String _documentation = this.eObjectDocProvider.getDocumentation(_eObject);
    _builder.append(_documentation, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("</p>");
    _builder.newLine();
    return _builder.toString();
  }
}
