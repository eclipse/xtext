/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util

import org.eclipse.xtext.util.IAcceptor
import org.eclipse.emf.common.util.URI
import com.google.inject.ImplementedBy
import java.io.File

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(JavaIoFileSystemScanner)
interface IFileSystemScanner {
    
    def void scan(URI root, IAcceptor<URI> acceptor)
    
    static class JavaIoFileSystemScanner implements IFileSystemScanner {
        
        override scan(URI root, IAcceptor<URI> acceptor) {
            val file = new File(root.toFileString)
            scanRec(file, acceptor)
        }
        
        def void scanRec(File file, IAcceptor<URI> acceptor) {
            acceptor.accept(URI.createFileURI(file.absolutePath))
            if (file.isDirectory) {
                for (f : file.listFiles) {
                    scanRec(f, acceptor)
                }
            }
        }
        
    }
}