package org.eclipse.xpect.xtext.lib.setup;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.xpect.XpectImport;
import org.eclipse.xpect.state.XpectStateAnnotation;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@XpectStateAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.PARAMETER, ElementType.FIELD })
@XpectImport({ XtextStandaloneSetup.class, XtextWorkspaceSetup.class })
public @interface ThisFile {
}
