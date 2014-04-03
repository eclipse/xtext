/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.compiler;

import com.google.common.base.Objects;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.compiler.MacroAwareStringConcatenation;
import org.eclipse.xtend.core.macro.ActiveAnnotationContext;
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts;
import org.eclipse.xtend.core.macro.CodeGenerationContextImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.lib.macro.CodeGenerationParticipant;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.output.ImportingStringConcatenation;
import org.eclipse.xtext.xbase.compiler.output.SharedAppendableState;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendGenerator extends JvmModelGenerator {
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
    super.doGenerate(input, fsa);
    this.callMacroProcessors(input);
  }
  
  public void callMacroProcessors(final Resource input) {
    final ActiveAnnotationContexts ctxs = ActiveAnnotationContexts.find(input);
    boolean _equals = Objects.equal(ctxs, null);
    if (_equals) {
      return;
    }
    Map<JvmAnnotationType, ActiveAnnotationContext> _contexts = ctxs.getContexts();
    Collection<ActiveAnnotationContext> _values = _contexts.values();
    for (final ActiveAnnotationContext context : _values) {
      try {
        Object _processorInstance = context.getProcessorInstance();
        final Object processor = _processorInstance;
        boolean _matched = false;
        if (!_matched) {
          if (processor instanceof CodeGenerationParticipant) {
            _matched=true;
            CodeGenerationContextImpl _codeGenerationContextImpl = new CodeGenerationContextImpl();
            final Procedure1<CodeGenerationContextImpl> _function = new Procedure1<CodeGenerationContextImpl>() {
              public void apply(final CodeGenerationContextImpl it) {
                CompilationUnitImpl _compilationUnit = context.getCompilationUnit();
                MutableFileSystemSupport _fileSystemSupport = _compilationUnit.getFileSystemSupport();
                it.setFileSystemSupport(_fileSystemSupport);
                CompilationUnitImpl _compilationUnit_1 = context.getCompilationUnit();
                FileLocations _fileLocations = _compilationUnit_1.getFileLocations();
                it.setFileLocations(_fileLocations);
              }
            };
            final CodeGenerationContextImpl codeGenServices = ObjectExtensions.<CodeGenerationContextImpl>operator_doubleArrow(_codeGenerationContextImpl, _function);
            List<XtendAnnotationTarget> _annotatedSourceElements = context.getAnnotatedSourceElements();
            final Function1<XtendAnnotationTarget, MemberDeclaration> _function_1 = new Function1<XtendAnnotationTarget, MemberDeclaration>() {
              public MemberDeclaration apply(final XtendAnnotationTarget it) {
                CompilationUnitImpl _compilationUnit = context.getCompilationUnit();
                return _compilationUnit.toXtendMemberDeclaration(((XtendMember) it));
              }
            };
            final List<MemberDeclaration> elements = ListExtensions.<XtendAnnotationTarget, MemberDeclaration>map(_annotatedSourceElements, _function_1);
            ((CodeGenerationParticipant<NamedElement>)processor).doGenerateCode(elements, codeGenServices);
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable t = (Throwable)_t;
          context.handleProcessingError(input, t);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
  
  protected ImportingStringConcatenation createImportingStringConcatenation(final SharedAppendableState state, final ITypeReferenceOwner owner) {
    return new MacroAwareStringConcatenation(state, owner);
  }
  
  /**
   * Convert a given input string to a Java string.
   * 
   * Unicode escaping is handled by the {@link UnicodeAwarePostProcessor}.
   */
  public String doConvertToJavaString(final String input) {
    return Strings.convertToJavaString(input, false);
  }
}
