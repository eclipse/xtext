/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.binary.BinaryClass;
import org.eclipse.xtext.common.types.access.binary.asm.ClassFileBytesAccess;
import org.eclipse.xtext.common.types.access.binary.asm.JvmDeclaredTypeBuilder;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;

import com.google.inject.Inject;

/**
 * Internal implementation that allows to convert the bytes of Java top-level classes to {@link JvmType types}.
 * 
 * Clients are not supposed to use this class directly but the {@link IJvmTypeProvider} or {@link TypeReferences}
 * instead. Those will take care of types that are requested more than once and therefore should return the very same
 * {@link JvmType type} on subsequent queries.
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class DeclaredTypeFactory implements ITypeFactory<BinaryClass, JvmDeclaredType> {

	private final StoppedTask createTypeTask = Stopwatches.forTask("AsmTypeFactory.createType");

	/**
	 * The classLoader that is used to find the class files for nested types.
	 */
	private final ClassLoader classLoader;

	/**
	 * The reader may cache the read structure of the class files.
	 */
	private final ClassFileBytesAccess bytesAccess;

	@Inject
	public DeclaredTypeFactory(ClassFileBytesAccess bytesAccess, ClassLoader loader) {
		this.bytesAccess = bytesAccess;
		this.classLoader = loader;
	}

	/**
	 * Creates a new {@link JvmDeclaredType type} from the given binary class..
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public JvmDeclaredType createType(BinaryClass binaryClass) {
		try {
			createTypeTask.start();
			return doCreateType(binaryClass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			createTypeTask.stop();
		}
	}

	protected JvmDeclaredType doCreateType(BinaryClass binaryClass) {
		JvmDeclaredTypeBuilder builder = new JvmDeclaredTypeBuilder(binaryClass, bytesAccess, classLoader);
		return builder.buildType();
	}

}
