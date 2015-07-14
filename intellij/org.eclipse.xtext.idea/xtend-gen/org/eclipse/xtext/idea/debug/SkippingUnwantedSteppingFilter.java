/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.debug;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.debugger.PositionManager;
import com.intellij.debugger.SourcePosition;
import com.intellij.debugger.engine.DebugProcess;
import com.intellij.debugger.engine.ExtraSteppingFilter;
import com.intellij.debugger.engine.SuspendContext;
import com.intellij.debugger.engine.jdi.StackFrameProxy;
import com.sun.jdi.Location;
import com.sun.jdi.Method;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.Type;
import com.sun.jdi.request.StepRequest;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.idea.debug.DebugProcessExtensions;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class SkippingUnwantedSteppingFilter implements ExtraSteppingFilter {
  @Inject
  @Extension
  private DebugProcessExtensions _debugProcessExtensions;
  
  public SkippingUnwantedSteppingFilter(final IXtextLanguage language) {
    language.injectMembers(this);
  }
  
  @Override
  public int getStepRequestDepth(final SuspendContext context) {
    boolean _isEmptyAnonymousClassConstructor = this.isEmptyAnonymousClassConstructor(context);
    if (_isEmptyAnonymousClassConstructor) {
      return StepRequest.STEP_OUT;
    }
    return StepRequest.STEP_OVER;
  }
  
  @Override
  public boolean isApplicable(final SuspendContext context) {
    try {
      boolean _or = false;
      boolean _equals = Objects.equal(context, null);
      if (_equals) {
        _or = true;
      } else {
        boolean _isXtextSourced = this.isXtextSourced(context);
        boolean _not = (!_isXtextSourced);
        _or = _not;
      }
      if (_or) {
        return false;
      }
      final DebugProcess debugProcess = context.getDebugProcess();
      final PositionManager positionManager = debugProcess.getPositionManager();
      StackFrameProxy _frameProxy = context.getFrameProxy();
      final Location location = _frameProxy.location();
      boolean _isEmptyAnonymousClassConstructor = this.isEmptyAnonymousClassConstructor(context);
      if (_isEmptyAnonymousClassConstructor) {
        return true;
      }
      SourcePosition _sourcePosition = positionManager.getSourcePosition(location);
      final boolean result = Objects.equal(_sourcePosition, null);
      if (result) {
        return true;
      }
      return false;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected boolean isXtextSourced(final SuspendContext context) {
    try {
      StackFrameProxy _frameProxy = context.getFrameProxy();
      final Location location = _frameProxy.location();
      DebugProcess _debugProcess = context.getDebugProcess();
      URI _findOriginalDeclaration = this._debugProcessExtensions.findOriginalDeclaration(_debugProcess, location);
      return (!Objects.equal(_findOriginalDeclaration, null));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean isEmptyAnonymousClassConstructor(final SuspendContext context) {
    try {
      StackFrameProxy _frameProxy = context.getFrameProxy();
      final Location location = _frameProxy.location();
      boolean _notEquals = (!Objects.equal(location, null));
      if (_notEquals) {
        final Method method = location.method();
        boolean _and = false;
        boolean _and_1 = false;
        boolean _and_2 = false;
        boolean _notEquals_1 = (!Objects.equal(method, null));
        if (!_notEquals_1) {
          _and_2 = false;
        } else {
          boolean _isConstructor = method.isConstructor();
          _and_2 = _isConstructor;
        }
        if (!_and_2) {
          _and_1 = false;
        } else {
          List<Type> _argumentTypes = method.argumentTypes();
          boolean _isEmpty = _argumentTypes.isEmpty();
          _and_1 = _isEmpty;
        }
        if (!_and_1) {
          _and = false;
        } else {
          ReferenceType _declaringType = method.declaringType();
          String _name = _declaringType.name();
          int _indexOf = _name.indexOf("$");
          boolean _greaterThan = (_indexOf > 0);
          _and = _greaterThan;
        }
        if (_and) {
          return true;
        }
      }
      return false;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
