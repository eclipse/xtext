/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.BindingKey;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.WorkingCopyOwner;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.internal.core.DefaultWorkingCopyOwner;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;

/**
 * Internal implementation that allows to convert Java top-level classes that
 * are represented as JDTs {@link IType ITypes} to {@link JvmType JvmTypes}.
 * 
 * Clients are not supposed to use this class directly but the {@link IJvmTypeProvider}
 * or {@link TypeReferences} instead. Those will take care of types that are requested more than
 * once and therefore should return the very same {@link JvmType type} on subsequent queries.
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.7
 */
public class JdtBasedTypeFactory extends AbstractJdtBasedTypeFactory implements ITypeFactory<IType, JvmDeclaredType>, ITypeFactory.OptionsAware<IType, JvmDeclaredType> {

	/**
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @since 2.4
	 */
	public static class ParameterNameInitializer implements Runnable {
		private final static Logger log = Logger.getLogger(JdtBasedTypeFactory.ParameterNameInitializer.class);
		private StoppedTask resolveParamNames = Stopwatches.forTask("resolve param names (JdtBasedTypeFactory)");
		private WorkingCopyOwner workingCopyOwner;
		private JvmExecutable executable;
		private String handleIdentifier; 
		private String[] path; 
		private String name; 
		private CharSequence signature;

		/**
		 * @noreference This constructor is not intended to be referenced by clients.
		 */
		protected ParameterNameInitializer(WorkingCopyOwner workingCopyOwner, JvmExecutable executable, String handleIdentifier, String[] path, String name, CharSequence signature) {
			super();
			this.workingCopyOwner = workingCopyOwner;
			this.executable = executable;
			this.handleIdentifier = handleIdentifier;
			this.path = path;
			this.name = name;
			this.signature = signature;
		}

		@Override
		public void run() {
			try {
				resolveParamNames.start();
				
				// Use the handle to find the top level type and then use the path the traverse to the correct nested type.
				//
				IType type = findTypeByHandleIdentifier();

				List<JvmFormalParameter> parameters = executable.getParameters();
				if (type != null) {
					IMethod javaMethod = findJavaMethod(type);
					int numberOfParameters = javaMethod.getNumberOfParameters();
					if (numberOfParameters != 0) {
						try {
							setParameterNames(javaMethod, parameters);
							return;
						} catch (JavaModelException ex) {
							if (!ex.isDoesNotExist())
								log.warn("IMethod.getParameterNames failed", ex);
						}
					}
				}

				// We generally should not ever get here.
				//
				synthesizeNames(parameters);
			} finally {
				resolveParamNames.stop();
			}
		}

		/**
		 * @since 2.4
		 */
		protected void setParameterNames(IMethod javaMethod, List<JvmFormalParameter> parameters)
				throws JavaModelException {
			String[] parameterNames = javaMethod.getParameterNames();
			int size = parameters.size();
			if (size != parameterNames.length) {
				throw new IllegalStateException("unmatching arity for java method "+javaMethod.toString()+" and "+getExecutable().getIdentifier());
			}
			for (int i = 0; i < parameterNames.length; i++) {
				String string = parameterNames[i];
				parameters.get(i).setName(string);
			}
		}

		private IMethod findJavaMethod(IType type) {
			// Locate the method from its signature.
			//
			String[] parameterTypes = Signature.getParameterTypes(new BindingKey("Lx;.x(" + signature + ")").toSignature());
			IMethod javaMethod = type.getMethod(name, parameterTypes);

			// If the method doesn't exist and this is a nested type...
			//
			if (!javaMethod.exists() && type.getDeclaringType() != null) {
				// This special case handles what appears to be a JDT bug 
				// that sometimes it knows when there are implicit constructor arguments for nested types and sometimes it doesn't.
				// Infer one more initial parameter type and locate the method based on that.
				//
				String[] augmented = new String[parameterTypes.length + 1];
				System.arraycopy(parameterTypes, 0, augmented, 1, parameterTypes.length);
				String first = Signature.createTypeSignature(type.getDeclaringType().getFullyQualifiedName(), true);
				augmented[0] = first;
				javaMethod = type.getMethod(name, augmented);
			}
			return javaMethod;
		}
		
		/**
		 * @since 2.4
		 */
		protected JvmExecutable getExecutable() {
			return executable;
		}

		private void synthesizeNames(List<JvmFormalParameter> parameters) {
			int i = 0;
			for (JvmFormalParameter p : parameters) {
				if (p.getName() == null) {
					p.setName("arg"+i);
				}
				i++;
			}
		}

		private IType findTypeByHandleIdentifier() {
			IType type = (IType)JavaCore.create(handleIdentifier, workingCopyOwner);
			if (type != null) {
				for (String typeName : path) {
					type = type.getType(typeName);
					if (type == null) {
						break;
					}
				}
			}
			return type;
		}
		
	}
	
	/**
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @since 2.4
	 */
	protected static class EnumConstructorParameterNameInitializer extends ParameterNameInitializer {

		protected EnumConstructorParameterNameInitializer(WorkingCopyOwner workingCopyOwner, JvmExecutable executable,
				String handleIdentifier, String[] path, String name, CharSequence signature) {
			super(workingCopyOwner, executable, handleIdentifier, path, name, signature);
		}
		
		@Override
		protected void setParameterNames(IMethod javaMethod, List<JvmFormalParameter> parameters)
				throws JavaModelException {
			String[] parameterNames = javaMethod.getParameterNames();
			if (parameterNames.length == parameters.size()) {
				// classes compiled with javaC look different thus here we find the correct number of arguments
				// we have to use the super implementation
				super.setParameterNames(javaMethod, parameters);
			} else {
				int size = parameters.size();
				if (size + 2 != parameterNames.length) {
					throw new IllegalStateException("unmatching arity for java method "+javaMethod.toString()+" and "+getExecutable().getIdentifier());
				}
				for (int i = 2; i < parameterNames.length; i++) {
					String string = parameterNames[i];
					parameters.get(i - 2).setName(string);
				}
			}
		}
		
	}
	
	private final WorkingCopyOwner workingCopyOwner;

	/**
	 * A cached AST parser that's reused by top-level type {@link #createType(IType) creation}.
	 */
	@SuppressWarnings("all")
	private final ASTParser parser = ASTParser.newParser(AST.JLS3);

	private StoppedTask resolveBinding = Stopwatches.forTask("resolve binding (JdtBasedTypeFactory)");

	@Deprecated
	public JdtBasedTypeFactory(TypeURIHelper uriHelper) {
		this(uriHelper, DefaultWorkingCopyOwner.PRIMARY);
	}

	/**
	 * @since 2.4
	 */
	public JdtBasedTypeFactory(TypeURIHelper uriHelper, WorkingCopyOwner workingCopyOwner) {
		super(uriHelper);
		this.workingCopyOwner = workingCopyOwner;
	}

	/**
	 * @since 2.8
	 */
	@Override
	protected IBinding doResolveBindings(IType jdtType, IJavaProject javaProject) {
		IBinding binding = resolveBindings(jdtType, javaProject);
		if (binding == null) {
			IJavaProject fallbackProject = jdtType.getJavaProject();
			// fallback to the project of the given jdtType if it is different from the explicitly given project
			if (!fallbackProject.equals(javaProject)) {
				binding = resolveBindings(jdtType, fallbackProject);
				if (binding == null) {
					throw new IllegalStateException("Could not create binding for '" + jdtType.getFullyQualifiedName() + 
							"' in context of projects '" + javaProject.getElementName() + "' and '" + fallbackProject.getElementName() + "'.");
				}
			} else {
				throw new IllegalStateException("Could not create binding for '" + jdtType.getFullyQualifiedName() + "' in context of project '" + javaProject.getElementName() + "'.");
			}
		}
		return binding;
	}
	
	@Override
	protected WorkingCopyOwner getWorkingCopyOwner() {
		return workingCopyOwner;
	}
	
	private IBinding resolveBindings(IType jdtType, IJavaProject javaProject) {
		resolveBinding.start();

		parser.setWorkingCopyOwner(workingCopyOwner);
		parser.setIgnoreMethodBodies(true);
		
		parser.setProject(javaProject);
		
		@SuppressWarnings("unchecked")
		Map<Object, Object> options = javaProject.getOptions(true);
		options.put(JavaCore.COMPILER_DOC_COMMENT_SUPPORT, JavaCore.DISABLED);
		parser.setCompilerOptions(options);

		IBinding[] bindings = parser.createBindings(new IJavaElement[] { jdtType }, null);
		resolveBinding.stop();
		return bindings[0];
	}
	
}
