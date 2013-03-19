/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package extract;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ExtractProcessor extends AbstractClassProcessor {
  public void doRegisterGlobals(final ClassDeclaration annotatedClass, final RegisterGlobalsContext context) {
    String _interfaceName = this.getInterfaceName(annotatedClass);
    context.registerInterface(_interfaceName);
  }
  
  public String getInterfaceName(final ClassDeclaration annotatedClass) {
    String _qualifiedName = annotatedClass.getQualifiedName();
    String _plus = (_qualifiedName + "Interface");
    return _plus;
  }
  
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    String _interfaceName = this.getInterfaceName(annotatedClass);
    final MutableInterfaceDeclaration interfaceType = context.findInterface(_interfaceName);
    List<TypeReference> _implementedInterfaces = annotatedClass.getImplementedInterfaces();
    TypeReference _newTypeReference = context.newTypeReference(interfaceType);
    List<TypeReference> _xlistliteral = null;
    Builder<TypeReference> _builder = ImmutableList.builder();
    _builder.add(_newTypeReference);
    _xlistliteral = _builder.build();
    Iterable<TypeReference> _plus = Iterables.<TypeReference>concat(_implementedInterfaces, _xlistliteral);
    annotatedClass.setImplementedInterfaces(_plus);
    Iterable<? extends MutableMethodDeclaration> _declaredMethods = annotatedClass.getDeclaredMethods();
    for (final MutableMethodDeclaration method : _declaredMethods) {
      Visibility _visibility = method.getVisibility();
      boolean _equals = Objects.equal(_visibility, Visibility.PUBLIC);
      if (_equals) {
        String _simpleName = method.getSimpleName();
        final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
            public void apply(final MutableMethodDeclaration it) {
              String _docComment = method.getDocComment();
              it.setDocComment(_docComment);
              TypeReference _returnType = method.getReturnType();
              it.setReturnType(_returnType);
              List<MutableParameterDeclaration> _parameters = method.getParameters();
              for (final MutableParameterDeclaration p : _parameters) {
                String _simpleName = p.getSimpleName();
                TypeReference _type = p.getType();
                it.addParameter(_simpleName, _type);
              }
              List<TypeReference> _exceptions = method.getExceptions();
              it.setExceptions(((TypeReference[])Conversions.unwrapArray(_exceptions, TypeReference.class)));
            }
          };
        interfaceType.addMethod(_simpleName, _function);
      }
    }
  }
}
