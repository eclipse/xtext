/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.domainmodel.formatting2;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.example.domainmodel.domainmodel.AbstractElement;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.PackageDeclaration;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@SuppressWarnings("all")
public class DomainmodelFormatter extends XbaseFormatter {
  protected void _format(final DomainModel domainmodel, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.setNewLines(0, 0, 1);
        it.noSpace();
      }
    };
    DomainModel _prepend = document.<DomainModel>prepend(domainmodel, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    document.<DomainModel>append(_prepend, _function_1);
    XImportSection _importSection = domainmodel.getImportSection();
    this.format(_importSection, document);
    EList<AbstractElement> _elements = domainmodel.getElements();
    for (final AbstractElement element : _elements) {
      this.format(element, document);
    }
  }
  
  protected void _format(final PackageDeclaration pkg, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(pkg);
    final ISemanticRegion open = _regionFor.keyword("{");
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(pkg);
    final ISemanticRegion close = _regionFor_1.keyword("}");
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(pkg);
    ISemanticRegion _feature = _regionFor_2.feature(DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME);
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.surround(_feature, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    document.append(open, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.indent();
      }
    };
    document.<ISemanticRegion, ISemanticRegion>interior(open, close, _function_2);
    EList<AbstractElement> _elements = pkg.getElements();
    for (final AbstractElement element : _elements) {
      {
        document.<AbstractElement>format(element);
        final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.setNewLines(1, 1, 2);
          }
        };
        document.<AbstractElement>append(element, _function_3);
      }
    }
  }
  
  protected void _format(final Entity entity, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(entity);
    final ISemanticRegion open = _regionFor.keyword("{");
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(entity);
    final ISemanticRegion close = _regionFor_1.keyword("}");
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(entity);
    ISemanticRegion _feature = _regionFor_2.feature(DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME);
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.surround(_feature, _function);
    JvmParameterizedTypeReference _superType = entity.getSuperType();
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.<JvmParameterizedTypeReference>surround(_superType, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    document.append(open, _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.indent();
      }
    };
    document.<ISemanticRegion, ISemanticRegion>interior(open, close, _function_3);
    JvmParameterizedTypeReference _superType_1 = entity.getSuperType();
    this.format(_superType_1, document);
    EList<Feature> _features = entity.getFeatures();
    for (final Feature feature : _features) {
      {
        document.<Feature>format(feature);
        final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.setNewLines(1, 1, 2);
          }
        };
        document.<Feature>append(feature, _function_4);
      }
    }
  }
  
  protected void _format(final Property property, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(property);
    ISemanticRegion _keyword = _regionFor.keyword(":");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.surround(_keyword, _function);
    JvmTypeReference _type = property.getType();
    document.<JvmTypeReference>format(_type);
  }
  
  protected void _format(final Operation operation, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(operation);
    ISemanticRegion _keyword = _regionFor.keyword("op");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(operation);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("(");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.surround(_keyword_1, _function_1);
    EList<JvmFormalParameter> _params = operation.getParams();
    boolean _isEmpty = _params.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(operation);
      List<ISemanticRegion> _keywords = _regionFor_2.keywords(",");
      for (final ISemanticRegion comma : _keywords) {
        final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        ISemanticRegion _prepend = document.prepend(comma, _function_2);
        final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        document.append(_prepend, _function_3);
      }
      EList<JvmFormalParameter> _params_1 = operation.getParams();
      for (final JvmFormalParameter params : _params_1) {
        document.<JvmFormalParameter>format(params);
      }
      ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(operation);
      ISemanticRegion _keyword_2 = _regionFor_3.keyword(")");
      final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      document.prepend(_keyword_2, _function_4);
    }
    JvmTypeReference _type = operation.getType();
    boolean _notEquals = (!Objects.equal(_type, null));
    if (_notEquals) {
      ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(operation);
      ISemanticRegion _keyword_3 = _regionFor_4.keyword(")");
      final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      document.append(_keyword_3, _function_5);
      JvmTypeReference _type_1 = operation.getType();
      final Procedure1<IHiddenRegionFormatter> _function_6 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      JvmTypeReference _prepend_1 = document.<JvmTypeReference>prepend(_type_1, _function_6);
      final Procedure1<IHiddenRegionFormatter> _function_7 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.<JvmTypeReference>append(_prepend_1, _function_7);
      JvmTypeReference _type_2 = operation.getType();
      document.<JvmTypeReference>format(_type_2);
    } else {
      ISemanticRegionsFinder _regionFor_5 = this.textRegionExtensions.regionFor(operation);
      ISemanticRegion _keyword_4 = _regionFor_5.keyword(")");
      final Procedure1<IHiddenRegionFormatter> _function_8 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_keyword_4, _function_8);
    }
    XExpression _body = operation.getBody();
    document.<XExpression>format(_body);
  }
  
  public void format(final Object entity, final IFormattableDocument document) {
    if (entity instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)entity, document);
      return;
    } else if (entity instanceof JvmFormalParameter) {
      _format((JvmFormalParameter)entity, document);
      return;
    } else if (entity instanceof XtextResource) {
      _format((XtextResource)entity, document);
      return;
    } else if (entity instanceof XAssignment) {
      _format((XAssignment)entity, document);
      return;
    } else if (entity instanceof XBinaryOperation) {
      _format((XBinaryOperation)entity, document);
      return;
    } else if (entity instanceof XDoWhileExpression) {
      _format((XDoWhileExpression)entity, document);
      return;
    } else if (entity instanceof XFeatureCall) {
      _format((XFeatureCall)entity, document);
      return;
    } else if (entity instanceof XMemberFeatureCall) {
      _format((XMemberFeatureCall)entity, document);
      return;
    } else if (entity instanceof XPostfixOperation) {
      _format((XPostfixOperation)entity, document);
      return;
    } else if (entity instanceof XWhileExpression) {
      _format((XWhileExpression)entity, document);
      return;
    } else if (entity instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)entity, document);
      return;
    } else if (entity instanceof JvmGenericArrayTypeReference) {
      _format((JvmGenericArrayTypeReference)entity, document);
      return;
    } else if (entity instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)entity, document);
      return;
    } else if (entity instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)entity, document);
      return;
    } else if (entity instanceof Entity) {
      _format((Entity)entity, document);
      return;
    } else if (entity instanceof Operation) {
      _format((Operation)entity, document);
      return;
    } else if (entity instanceof PackageDeclaration) {
      _format((PackageDeclaration)entity, document);
      return;
    } else if (entity instanceof Property) {
      _format((Property)entity, document);
      return;
    } else if (entity instanceof XBasicForLoopExpression) {
      _format((XBasicForLoopExpression)entity, document);
      return;
    } else if (entity instanceof XBlockExpression) {
      _format((XBlockExpression)entity, document);
      return;
    } else if (entity instanceof XCastedExpression) {
      _format((XCastedExpression)entity, document);
      return;
    } else if (entity instanceof XClosure) {
      _format((XClosure)entity, document);
      return;
    } else if (entity instanceof XCollectionLiteral) {
      _format((XCollectionLiteral)entity, document);
      return;
    } else if (entity instanceof XConstructorCall) {
      _format((XConstructorCall)entity, document);
      return;
    } else if (entity instanceof XForLoopExpression) {
      _format((XForLoopExpression)entity, document);
      return;
    } else if (entity instanceof XIfExpression) {
      _format((XIfExpression)entity, document);
      return;
    } else if (entity instanceof XInstanceOfExpression) {
      _format((XInstanceOfExpression)entity, document);
      return;
    } else if (entity instanceof XReturnExpression) {
      _format((XReturnExpression)entity, document);
      return;
    } else if (entity instanceof XSwitchExpression) {
      _format((XSwitchExpression)entity, document);
      return;
    } else if (entity instanceof XSynchronizedExpression) {
      _format((XSynchronizedExpression)entity, document);
      return;
    } else if (entity instanceof XThrowExpression) {
      _format((XThrowExpression)entity, document);
      return;
    } else if (entity instanceof XTryCatchFinallyExpression) {
      _format((XTryCatchFinallyExpression)entity, document);
      return;
    } else if (entity instanceof XTypeLiteral) {
      _format((XTypeLiteral)entity, document);
      return;
    } else if (entity instanceof XVariableDeclaration) {
      _format((XVariableDeclaration)entity, document);
      return;
    } else if (entity instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)entity, document);
      return;
    } else if (entity instanceof DomainModel) {
      _format((DomainModel)entity, document);
      return;
    } else if (entity instanceof XExpression) {
      _format((XExpression)entity, document);
      return;
    } else if (entity instanceof XImportDeclaration) {
      _format((XImportDeclaration)entity, document);
      return;
    } else if (entity instanceof XImportSection) {
      _format((XImportSection)entity, document);
      return;
    } else if (entity instanceof EObject) {
      _format((EObject)entity, document);
      return;
    } else if (entity == null) {
      _format((Void)null, document);
      return;
    } else if (entity != null) {
      _format(entity, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(entity, document).toString());
    }
  }
}
