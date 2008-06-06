/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.antlr.Tool;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class AntlrToolRunner {
    
    public static void run(String grammarFullPath) {        
        Tool antlr = new Tool(new String[] { grammarFullPath });
        antlr.process();
    }
}
