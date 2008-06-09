/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class Files {

    private static Log log = LogFactory.getLog(Files.class);

    public static void copyFiles(String sourceDir, String targetDir, List<String> files) {
        File target = new File(targetDir);
        if (!target.exists()) {
            target.mkdir();
        }
        for (String file : files) {
            File copy = new File(target.getAbsolutePath() + File.separatorChar + file);
            if (!copy.exists()) {
                try {
                    ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                    String uri = sourceDir + "/" + file;
                    InputStream is = contextClassLoader.getResourceAsStream(uri);
                    copy.createNewFile();
                    FileOutputStream fwr = new FileOutputStream(copy);
                    byte[] buff = new byte[1024];
                    int read;
                    while ((read = is.read(buff)) != -1) {
                        fwr.write(buff, 0, read);
                    }
                    log.debug("Copied " + copy);
                } catch (IOException e) {
                    log.error(e);
                }
            }
        }
    }
}
