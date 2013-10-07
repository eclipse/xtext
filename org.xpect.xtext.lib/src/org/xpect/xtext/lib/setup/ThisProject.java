package org.xpect.xtext.lib.setup;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.xpect.setup.XpectSetup;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.PARAMETER, ElementType.FIELD })
@XpectSetup(XtextWorkspaceSetup.class)
public @interface ThisProject {

}
