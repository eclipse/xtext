package org.eclipse.xtext.java.resource

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.JavaVersion
import org.eclipse.xtext.util.internal.EmfAdaptable

@EmfAdaptable
class JavaConfig {
    @Accessors JavaVersion javaSourceLevel
    @Accessors JavaVersion javaTargetLevel
}