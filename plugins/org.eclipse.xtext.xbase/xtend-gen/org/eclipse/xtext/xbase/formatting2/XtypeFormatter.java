/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.formatting2;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionFinder;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@SuppressWarnings("all")
public class XtypeFormatter extends AbstractFormatter2 {
  protected void _format(final XFunctionTypeRef func, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(func);
    ISemanticRegion _keyword = _regionFor.keyword("(");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.append(_keyword, _function);
    EList<JvmTypeReference> _paramTypes = func.getParamTypes();
    for (final JvmTypeReference param : _paramTypes) {
      {
        document.<JvmTypeReference>format(param);
        ISemanticRegionFinder _immediatelyFollowing = this.textRegionExtensions.immediatelyFollowing(param);
        ISemanticRegion _keyword_1 = _immediatelyFollowing.keyword(",");
        final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        ISemanticRegion _prepend = document.prepend(_keyword_1, _function_1);
        final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        document.append(_prepend, _function_2);
      }
    }
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(func);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword(")");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        EList<JvmTypeReference> _paramTypes = func.getParamTypes();
        boolean _isEmpty = _paramTypes.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          it.noSpace();
        }
      }
    };
    ISemanticRegion _prepend = document.prepend(_keyword_1, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.append(_prepend, _function_2);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(func);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword("=>");
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.append(_keyword_2, _function_3);
    JvmTypeReference _returnType = func.getReturnType();
    document.<JvmTypeReference>format(_returnType);
  }
  
  protected void _format(final JvmParameterizedTypeReference ref, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ref);
    ISemanticRegion _keyword = _regionFor.keyword("<");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.surround(_keyword, _function);
    EList<JvmTypeReference> _arguments = ref.getArguments();
    for (final JvmTypeReference arg : _arguments) {
      {
        document.<JvmTypeReference>format(arg);
        ISemanticRegionFinder _immediatelyFollowing = this.textRegionExtensions.immediatelyFollowing(arg);
        ISemanticRegion _keyword_1 = _immediatelyFollowing.keyword(",");
        final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        ISemanticRegion _prepend = document.prepend(_keyword_1, _function_1);
        final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        document.append(_prepend, _function_2);
      }
    }
    EList<JvmTypeReference> _arguments_1 = ref.getArguments();
    boolean _isEmpty = _arguments_1.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(ref);
      ISemanticRegion _keyword_1 = _regionFor_1.keyword(">");
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      document.prepend(_keyword_1, _function_1);
    }
  }
  
  protected void _format(final JvmWildcardTypeReference ref, @Extension final IFormattableDocument document) {
    EList<JvmTypeConstraint> _constraints = ref.getConstraints();
    boolean _isEmpty = _constraints.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(ref);
      ISemanticRegion _keyword = _regionFor.keyword("?");
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_keyword, _function);
    }
    EList<JvmTypeConstraint> _constraints_1 = ref.getConstraints();
    for (final JvmTypeConstraint c : _constraints_1) {
      document.<JvmTypeConstraint>format(c);
    }
  }
  
  protected void _format(final JvmTypeParameter ref, @Extension final IFormattableDocument document) {
    EList<JvmTypeConstraint> _constraints = ref.getConstraints();
    for (final JvmTypeConstraint c : _constraints) {
      {
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          @Override
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        document.<JvmTypeConstraint>prepend(c, _function);
        document.<JvmTypeConstraint>format(c);
      }
    }
  }
  
  protected void _format(final XImportSection section, @Extension final IFormattableDocument format) {
    EList<XImportDeclaration> _importDeclarations = section.getImportDeclarations();
    for (final XImportDeclaration imp : _importDeclarations) {
      {
        format.<XImportDeclaration>format(imp);
        EList<XImportDeclaration> _importDeclarations_1 = section.getImportDeclarations();
        XImportDeclaration _last = IterableExtensions.<XImportDeclaration>last(_importDeclarations_1);
        boolean _notEquals = (!Objects.equal(imp, _last));
        if (_notEquals) {
          format.<XImportDeclaration>append(imp, XbaseFormatterPreferenceKeys.blankLinesBetweenImports);
        } else {
          format.<XImportDeclaration>append(imp, XbaseFormatterPreferenceKeys.blankLinesAfterImports);
        }
      }
    }
  }
  
  protected void _format(final XImportDeclaration imp, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(imp);
    ISemanticRegion _keyword = _regionFor.keyword("import");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(imp);
    ISemanticRegion _feature = _regionFor_1.feature(XtypePackage.Literals.XIMPORT_DECLARATION__STATIC);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_feature, _function_1);
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(imp);
    ISemanticRegion _feature_1 = _regionFor_2.feature(XtypePackage.Literals.XIMPORT_DECLARATION__EXTENSION);
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_feature_1, _function_2);
    ISemanticRegionsFinder _regionFor_3 = this.textRegionExtensions.regionFor(imp);
    List<ISemanticRegion> _keywords = _regionFor_3.keywords(".");
    for (final ISemanticRegion node : _keywords) {
      final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
        @Override
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      document.surround(node, _function_3);
    }
    ISemanticRegionsFinder _regionFor_4 = this.textRegionExtensions.regionFor(imp);
    ISemanticRegion _keyword_1 = _regionFor_4.keyword(";");
    final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.prepend(_keyword_1, _function_4);
  }
  
  public void format(final Object ref, final IFormattableDocument document) {
    if (ref instanceof JvmTypeParameter) {
      _format((JvmTypeParameter)ref, document);
      return;
    } else if (ref instanceof XtextResource) {
      _format((XtextResource)ref, document);
      return;
    } else if (ref instanceof XFunctionTypeRef) {
      _format((XFunctionTypeRef)ref, document);
      return;
    } else if (ref instanceof JvmParameterizedTypeReference) {
      _format((JvmParameterizedTypeReference)ref, document);
      return;
    } else if (ref instanceof JvmWildcardTypeReference) {
      _format((JvmWildcardTypeReference)ref, document);
      return;
    } else if (ref instanceof XImportDeclaration) {
      _format((XImportDeclaration)ref, document);
      return;
    } else if (ref instanceof XImportSection) {
      _format((XImportSection)ref, document);
      return;
    } else if (ref instanceof EObject) {
      _format((EObject)ref, document);
      return;
    } else if (ref == null) {
      _format((Void)null, document);
      return;
    } else if (ref != null) {
      _format(ref, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ref, document).toString());
    }
  }
}
