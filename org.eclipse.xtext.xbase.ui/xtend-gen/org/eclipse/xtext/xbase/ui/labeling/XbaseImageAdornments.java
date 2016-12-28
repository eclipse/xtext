package org.eclipse.xtext.xbase.ui.labeling;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.ui.JavaElementImageDescriptor;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.util.DeprecationUtil;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;

@SuppressWarnings("all")
public class XbaseImageAdornments {
  @Inject
  @Extension
  private OverrideHelper _overrideHelper;
  
  protected int _get(final JvmDeclaredType it) {
    return this.or(this.or(this.or(this.or(0, it.isAbstract(), JavaElementImageDescriptor.ABSTRACT), it.isFinal(), JavaElementImageDescriptor.FINAL), it.isStatic(), JavaElementImageDescriptor.STATIC), DeprecationUtil.isDeprecatedMember(it), JavaElementImageDescriptor.DEPRECATED);
  }
  
  protected int _get(final JvmField it) {
    return this.or(this.or(this.or(this.or(this.or(0, it.isFinal(), JavaElementImageDescriptor.FINAL), it.isStatic(), JavaElementImageDescriptor.STATIC), DeprecationUtil.isDeprecatedMember(it), JavaElementImageDescriptor.DEPRECATED), it.isVolatile(), JavaElementImageDescriptor.VOLATILE), it.isTransient(), JavaElementImageDescriptor.TRANSIENT);
  }
  
  protected int _get(final JvmConstructor it) {
    return this.or(JavaElementImageDescriptor.CONSTRUCTOR, DeprecationUtil.isDeprecatedMember(it), JavaElementImageDescriptor.DEPRECATED);
  }
  
  protected int _get(final JvmOperation it) {
    final int adornment = this.or(this.or(this.or(this.or(this.or(this.or(0, it.isAbstract(), JavaElementImageDescriptor.ABSTRACT), it.isFinal(), JavaElementImageDescriptor.FINAL), it.isSynchronized(), JavaElementImageDescriptor.SYNCHRONIZED), it.isStatic(), JavaElementImageDescriptor.STATIC), DeprecationUtil.isDeprecatedMember(it), JavaElementImageDescriptor.DEPRECATED), it.isNative(), 0x4000);
    Resource _eResource = it.eResource();
    ResourceSet _resourceSet = null;
    if (_eResource!=null) {
      _resourceSet=_eResource.getResourceSet();
    }
    boolean _tripleNotEquals = (_resourceSet != null);
    if (_tripleNotEquals) {
      final JvmOperation overriddenOperation = this._overrideHelper.findOverriddenOperation(it);
      if ((overriddenOperation != null)) {
        return (adornment | this.getOverrideAdornment(overriddenOperation));
      }
    }
    return adornment;
  }
  
  protected int _get(final Void it) {
    return 0;
  }
  
  public int getOverrideAdornment(final JvmExecutable overriddenOperation) {
    int _switchResult = (int) 0;
    boolean _matched = false;
    if (overriddenOperation instanceof JvmOperation) {
      _matched=true;
      int _xifexpression = (int) 0;
      boolean _isAbstract = ((JvmOperation)overriddenOperation).isAbstract();
      if (_isAbstract) {
        _xifexpression = JavaElementImageDescriptor.IMPLEMENTS;
      } else {
        _xifexpression = JavaElementImageDescriptor.OVERRIDES;
      }
      _switchResult = _xifexpression;
    }
    if (!_matched) {
      _switchResult = 0;
    }
    return _switchResult;
  }
  
  protected int _get(final JvmIdentifiableElement it) {
    return 0;
  }
  
  protected int or(final int adornment, final boolean condition, final int oredValue) {
    int _xifexpression = (int) 0;
    if (condition) {
      _xifexpression = (adornment | oredValue);
    } else {
      _xifexpression = adornment;
    }
    return _xifexpression;
  }
  
  public int get(final JvmIdentifiableElement it) {
    if (it instanceof JvmConstructor) {
      return _get((JvmConstructor)it);
    } else if (it instanceof JvmOperation) {
      return _get((JvmOperation)it);
    } else if (it instanceof JvmField) {
      return _get((JvmField)it);
    } else if (it instanceof JvmDeclaredType) {
      return _get((JvmDeclaredType)it);
    } else if (it != null) {
      return _get(it);
    } else if (it == null) {
      return _get((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
