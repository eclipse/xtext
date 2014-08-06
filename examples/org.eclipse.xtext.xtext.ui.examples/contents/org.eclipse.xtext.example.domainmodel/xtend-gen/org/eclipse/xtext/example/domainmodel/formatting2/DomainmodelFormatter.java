package org.eclipse.xtext.example.domainmodel.formatting2;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.xtext.example.domainmodel.services.DomainmodelGrammarAccess;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportSection;

@SuppressWarnings("all")
public class DomainmodelFormatter extends XbaseFormatter {
  @Inject
  @Extension
  private DomainmodelGrammarAccess _domainmodelGrammarAccess;
  
  protected void _format(final DomainModel domainmodel, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.setNewLines(0, 0, 1);
        it.noSpace();
      }
    };
    DomainModel _prepend = document.<DomainModel>prepend(domainmodel, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
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
  
  protected void _format(final PackageDeclaration packagedeclaration, @Extension final IFormattableDocument document) {
    ISemanticRegion _regionForFeature = this.regionAccess.regionForFeature(packagedeclaration, DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME);
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.surround(_regionForFeature, _function);
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(packagedeclaration, "{");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
        it.increaseIndentation();
      }
    };
    document.append(_regionForKeyword, _function_1);
    EList<AbstractElement> _elements = packagedeclaration.getElements();
    for (final AbstractElement element : _elements) {
      {
        this.format(element, document);
        final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
          public void apply(final IHiddenRegionFormatter it) {
            it.setNewLines(1, 1, 2);
          }
        };
        document.<AbstractElement>append(element, _function_2);
      }
    }
    ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(packagedeclaration, "}");
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.decreaseIndentation();
      }
    };
    document.prepend(_regionForKeyword_1, _function_2);
  }
  
  protected void _format(final Entity entity, @Extension final IFormattableDocument document) {
    ISemanticRegion _regionForFeature = this.regionAccess.regionForFeature(entity, DomainmodelPackage.Literals.ABSTRACT_ELEMENT__NAME);
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.surround(_regionForFeature, _function);
    JvmParameterizedTypeReference _superType = entity.getSuperType();
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.<JvmParameterizedTypeReference>surround(_superType, _function_1);
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(entity, "{");
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
        it.increaseIndentation();
      }
    };
    document.append(_regionForKeyword, _function_2);
    JvmParameterizedTypeReference _superType_1 = entity.getSuperType();
    this.format(_superType_1, document);
    EList<Feature> _features = entity.getFeatures();
    for (final Feature feature : _features) {
      {
        this.format(feature, document);
        final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
          public void apply(final IHiddenRegionFormatter it) {
            it.setNewLines(1, 1, 2);
          }
        };
        document.<Feature>append(feature, _function_3);
      }
    }
    ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(entity, "}");
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.decreaseIndentation();
      }
    };
    document.prepend(_regionForKeyword_1, _function_3);
  }
  
  protected void _format(final Property property, @Extension final IFormattableDocument document) {
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(property, ":");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.surround(_regionForKeyword, _function);
    JvmTypeReference _type = property.getType();
    this.format(_type, document);
  }
  
  protected void _format(final Operation operation, @Extension final IFormattableDocument document) {
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(operation, "op");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_regionForKeyword, _function);
    ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(operation, "(");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.surround(_regionForKeyword_1, _function_1);
    EList<JvmFormalParameter> _params = operation.getParams();
    boolean _isEmpty = _params.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      List<ISemanticRegion> _regionsForKeywords = this.regionAccess.regionsForKeywords(operation, ",");
      for (final ISemanticRegion comma : _regionsForKeywords) {
        final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        ISemanticRegion _prepend = document.prepend(comma, _function_2);
        final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        document.append(_prepend, _function_3);
      }
      EList<JvmFormalParameter> _params_1 = operation.getParams();
      for (final JvmFormalParameter params : _params_1) {
        this.format(params, document);
      }
      ISemanticRegion _regionForKeyword_2 = this.regionAccess.regionForKeyword(operation, ")");
      final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      document.prepend(_regionForKeyword_2, _function_4);
    }
    JvmTypeReference _type = operation.getType();
    boolean _notEquals = (!Objects.equal(_type, null));
    if (_notEquals) {
      ISemanticRegion _regionForKeyword_3 = this.regionAccess.regionForKeyword(operation, ")");
      final Procedure1<IHiddenRegionFormatter> _function_5 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      document.append(_regionForKeyword_3, _function_5);
      JvmTypeReference _type_1 = operation.getType();
      final Procedure1<IHiddenRegionFormatter> _function_6 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      JvmTypeReference _prepend_1 = document.<JvmTypeReference>prepend(_type_1, _function_6);
      final Procedure1<IHiddenRegionFormatter> _function_7 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.<JvmTypeReference>append(_prepend_1, _function_7);
      JvmTypeReference _type_2 = operation.getType();
      this.format(_type_2, document);
    } else {
      ISemanticRegion _regionForKeyword_4 = this.regionAccess.regionForKeyword(operation, ")");
      final Procedure1<IHiddenRegionFormatter> _function_8 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_regionForKeyword_4, _function_8);
    }
    XExpression _body = operation.getBody();
    this.format(_body, document);
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
    } else if (entity instanceof XAnnotation) {
      _format((XAnnotation)entity, document);
      return;
    } else if (entity instanceof JvmTypeConstraint) {
      _format((JvmTypeConstraint)entity, document);
      return;
    } else if (entity instanceof DomainModel) {
      _format((DomainModel)entity, document);
      return;
    } else if (entity instanceof XCatchClause) {
      _format((XCatchClause)entity, document);
      return;
    } else if (entity instanceof XExpression) {
      _format((XExpression)entity, document);
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
