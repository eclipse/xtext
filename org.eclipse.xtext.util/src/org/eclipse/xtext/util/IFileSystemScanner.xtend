/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import java.io.File
import java.nio.file.Paths
import org.eclipse.emf.common.util.URI

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@ImplementedBy(JavaIoFileSystemScanner)
interface IFileSystemScanner {
    
    def void scan(URI root, IAcceptor<URI> acceptor)
    
    static class JavaIoFileSystemScanner implements IFileSystemScanner {
    	
        @Inject extension UriExtensions
        
        override scan(URI root, IAcceptor<URI> acceptor) {
            val file = new File(root.toFileString)
            scanRec(file, acceptor)
        }
        
        def void scanRec(File file, IAcceptor<URI> acceptor) {
            // we need to convert the given file to a decoded emf file uri
            // e.g. file:///Users/x/y/z
            // or file:///C:/x/y/z
            val path = Paths.get(file.absoluteFile.toURI)
            val uri = path.toUri.toString.toUri
            acceptor.accept(uri)
            if (file.isDirectory) {
                val files = file.listFiles
                if (files !== null) {
                    for (f : files) {
                        scanRec(f, acceptor)
                    }
                }
            }
        }
        
    }

}