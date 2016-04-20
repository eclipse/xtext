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
import com.sun.jdi.request.StepRequest;
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
      if ((Objects.equal(context, null) || (!this.isXtextSourced(context)))) {
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
        if (((((!Objects.equal(method, null)) && method.isConstructor()) && method.argumentTypes().isEmpty()) && (method.declaringType().name().indexOf("$") > 0))) {
          return true;
        }
      }
      return false;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
