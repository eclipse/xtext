/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.validation.IssueCodes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class UniqueClassNameValidator extends AbstractDeclarativeValidator {
  @Inject
  private ResourceDescriptionsProvider resourceDescriptionsProvider;
  
  @Inject
  private IQualifiedNameProvider qualifiedNameProvider;
  
  @Inject
  private IJvmModelAssociations associations;
  
  @Override
  public void register(final EValidatorRegistrar registrar) {
  }
  
  @Inject
  protected void register(final EValidatorRegistrar registrar, final IGrammarAccess grammarAccess) {
    Grammar _grammar = grammarAccess.getGrammar();
    EList<AbstractRule> _rules = _grammar.getRules();
    final AbstractRule entryRule = IterableExtensions.<AbstractRule>head(_rules);
    if ((entryRule instanceof ParserRule)) {
      TypeRef _type = ((ParserRule)entryRule).getType();
      EClassifier _classifier = _type.getClassifier();
      EPackage _ePackage = _classifier.getEPackage();
      registrar.register(_ePackage, this);
    }
  }
  
  @Check
  public void checkUniqueName(final EObject root) {
    EObject _eContainer = root.eContainer();
    boolean _equals = Objects.equal(_eContainer, null);
    if (_equals) {
      final Resource resource = root.eResource();
      EList<EObject> _contents = resource.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      boolean _equals_1 = Objects.equal(_head, root);
      if (_equals_1) {
        EList<EObject> _contents_1 = resource.getContents();
        Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_contents_1, JvmDeclaredType.class);
        for (final JvmDeclaredType it : _filter) {
          this.doCheckUniqueName(it);
        }
      }
    }
  }
  
  protected void doCheckUniqueName(final JvmDeclaredType type) {
    EObject _eContainer = type.eContainer();
    boolean _equals = Objects.equal(_eContainer, null);
    if (_equals) {
      final QualifiedName name = this.qualifiedNameProvider.getFullyQualifiedName(type);
      boolean _notEquals = (!Objects.equal(name, null));
      if (_notEquals) {
        this.doCheckUniqueName(name, type);
      }
    }
  }
  
  protected boolean doCheckUniqueName(final QualifiedName name, final JvmDeclaredType type) {
    Resource _eResource = type.eResource();
    final IResourceDescriptions index = this.resourceDescriptionsProvider.getResourceDescriptions(_eResource);
    final Iterable<IEObjectDescription> others = index.getExportedObjects(TypesPackage.Literals.JVM_DECLARED_TYPE, name, false);
    return this.checkUniqueInIndex(type, others);
  }
  
  protected boolean checkUniqueInIndex(final JvmDeclaredType type, final Iterable<IEObjectDescription> descriptions) {
    final Function1<IEObjectDescription, URI> _function = new Function1<IEObjectDescription, URI>() {
      @Override
      public URI apply(final IEObjectDescription it) {
        URI _eObjectURI = it.getEObjectURI();
        return _eObjectURI.trimFragment();
      }
    };
    Iterable<URI> _map = IterableExtensions.<IEObjectDescription, URI>map(descriptions, _function);
    final Set<URI> resourceURIs = IterableExtensions.<URI>toSet(_map);
    int _size = resourceURIs.size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      final Function1<URI, Boolean> _function_1 = new Function1<URI, Boolean>() {
        @Override
        public Boolean apply(final URI it) {
          Resource _eResource = type.eResource();
          URI _uRI = _eResource.getURI();
          return Boolean.valueOf((!Objects.equal(it, _uRI)));
        }
      };
      Iterable<URI> _filter = IterableExtensions.<URI>filter(resourceURIs, _function_1);
      URI _head = IterableExtensions.<URI>head(_filter);
      String _lastSegment = _head.lastSegment();
      this.addIssue(type, _lastSegment);
      return false;
    }
    return true;
  }
  
  protected void addIssue(final JvmDeclaredType type, final String fileName) {
    final EObject sourceElement = this.associations.getPrimarySourceElement(type);
    boolean _equals = Objects.equal(sourceElement, null);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("The type ");
      String _simpleName = type.getSimpleName();
      _builder.append(_simpleName, "");
      _builder.append(" is already defined in ");
      _builder.append(fileName, "");
      _builder.append(".");
      this.addIssue(_builder.toString(), type, IssueCodes.DUPLICATE_TYPE);
    } else {
      EClass _eClass = sourceElement.eClass();
      final EStructuralFeature feature = _eClass.getEStructuralFeature("name");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("The type ");
      String _simpleName_1 = type.getSimpleName();
      _builder_1.append(_simpleName_1, "");
      _builder_1.append(" is already defined in ");
      _builder_1.append(fileName, "");
      _builder_1.append(".");
      this.addIssue(_builder_1.toString(), sourceElement, feature, IssueCodes.DUPLICATE_TYPE);
    }
  }
}
