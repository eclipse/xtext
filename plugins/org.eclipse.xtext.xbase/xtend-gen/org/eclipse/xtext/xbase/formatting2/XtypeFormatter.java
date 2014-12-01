package org.eclipse.xtext.xbase.formatting2;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;

@SuppressWarnings("all")
public class XtypeFormatter extends AbstractFormatter2 {
  protected void _format(final XFunctionTypeRef func, @Extension final IFormattableDocument document) {
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(func, "(");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.append(_regionForKeyword, _function);
    EList<JvmTypeReference> _paramTypes = func.getParamTypes();
    for (final JvmTypeReference param : _paramTypes) {
      {
        this.format(param, document);
        ISemanticRegion _immediatelyFollowingKeyword = this.regionAccess.immediatelyFollowingKeyword(param, ",");
        final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        ISemanticRegion _prepend = document.prepend(_immediatelyFollowingKeyword, _function_1);
        final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        document.append(_prepend, _function_2);
      }
    }
    ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(func, ")");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        EList<JvmTypeReference> _paramTypes = func.getParamTypes();
        boolean _isEmpty = _paramTypes.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          it.noSpace();
        }
      }
    };
    ISemanticRegion _prepend = document.prepend(_regionForKeyword_1, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.append(_prepend, _function_2);
    ISemanticRegion _regionForKeyword_2 = this.regionAccess.regionForKeyword(func, "=>");
    final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.append(_regionForKeyword_2, _function_3);
    JvmTypeReference _returnType = func.getReturnType();
    this.format(_returnType, document);
  }
  
  protected void _format(final JvmParameterizedTypeReference ref, @Extension final IFormattableDocument document) {
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(ref, "<");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.surround(_regionForKeyword, _function);
    EList<JvmTypeReference> _arguments = ref.getArguments();
    for (final JvmTypeReference arg : _arguments) {
      {
        this.format(arg, document);
        ISemanticRegion _immediatelyFollowingKeyword = this.regionAccess.immediatelyFollowingKeyword(arg, ",");
        final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
          public void apply(final IHiddenRegionFormatter it) {
            it.noSpace();
          }
        };
        ISemanticRegion _prepend = document.prepend(_immediatelyFollowingKeyword, _function_1);
        final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
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
      ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(ref, ">");
      final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      document.prepend(_regionForKeyword_1, _function_1);
    }
  }
  
  protected void _format(final JvmWildcardTypeReference ref, @Extension final IFormattableDocument document) {
    EList<JvmTypeConstraint> _constraints = ref.getConstraints();
    boolean _isEmpty = _constraints.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(ref, "?");
      final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.oneSpace();
        }
      };
      document.append(_regionForKeyword, _function);
    }
    EList<JvmTypeConstraint> _constraints_1 = ref.getConstraints();
    for (final JvmTypeConstraint c : _constraints_1) {
      this.format(c, document);
    }
  }
  
  protected void _format(final JvmTypeParameter ref, @Extension final IFormattableDocument document) {
    EList<JvmTypeConstraint> _constraints = ref.getConstraints();
    for (final JvmTypeConstraint c : _constraints) {
      {
        final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
          public void apply(final IHiddenRegionFormatter it) {
            it.oneSpace();
          }
        };
        document.<JvmTypeConstraint>prepend(c, _function);
        this.format(c, document);
      }
    }
  }
  
  protected void _format(final XImportSection section, @Extension final IFormattableDocument format) {
    EList<XImportDeclaration> _importDeclarations = section.getImportDeclarations();
    for (final XImportDeclaration imp : _importDeclarations) {
      {
        this.format(imp, format);
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
    ISemanticRegion _regionForKeyword = this.regionAccess.regionForKeyword(imp, "import");
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_regionForKeyword, _function);
    ISemanticRegion _regionForFeature = this.regionAccess.regionForFeature(imp, XtypePackage.Literals.XIMPORT_DECLARATION__STATIC);
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_regionForFeature, _function_1);
    ISemanticRegion _regionForFeature_1 = this.regionAccess.regionForFeature(imp, XtypePackage.Literals.XIMPORT_DECLARATION__EXTENSION);
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.oneSpace();
      }
    };
    document.append(_regionForFeature_1, _function_2);
    List<ISemanticRegion> _regionsForKeywords = this.regionAccess.regionsForKeywords(imp, ".");
    for (final ISemanticRegion node : _regionsForKeywords) {
      final Procedure1<IHiddenRegionFormatter> _function_3 = new Procedure1<IHiddenRegionFormatter>() {
        public void apply(final IHiddenRegionFormatter it) {
          it.noSpace();
        }
      };
      document.surround(node, _function_3);
    }
    ISemanticRegion _regionForKeyword_1 = this.regionAccess.regionForKeyword(imp, ";");
    final Procedure1<IHiddenRegionFormatter> _function_4 = new Procedure1<IHiddenRegionFormatter>() {
      public void apply(final IHiddenRegionFormatter it) {
        it.noSpace();
      }
    };
    document.prepend(_regionForKeyword_1, _function_4);
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
