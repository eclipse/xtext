/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.logging;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class LoggerMapEntry {
    private String bundleId;
    private Pattern loggerPattern;

    public LoggerMapEntry(String bundleId, String loggerPattern) {
        this.bundleId = bundleId;
        this.loggerPattern = Pattern.compile(loggerPattern);
    }

    public String getLoggerPattern() {
        return loggerPattern.pattern();
    }

    public String getBundleId() {
        return bundleId;
    }

    public Matcher matcher(String loggerName) {
        return loggerPattern.matcher(loggerName);
    }

    public boolean matches(String loggerName) {
        return loggerPattern.matcher(loggerName).matches();
    }

}
