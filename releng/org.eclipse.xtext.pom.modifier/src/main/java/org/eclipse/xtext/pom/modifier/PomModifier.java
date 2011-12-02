/**
 * 
 */
package org.eclipse.xtext.pom.modifier;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.DefaultModelWriter;
import org.apache.maven.model.io.ModelWriter;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.FileUtils;

/**
 * @author huebner
 * 
 */
public class PomModifier {
	private static final Logger LOG = Logger.getLogger(PomModifier.class
			.getName());

	private List<ModelModifier> modifiers = new ArrayList<ModelModifier>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String rootFolder = null;
		if (args.length > 0) {
			rootFolder = args[0];
		}
		if (rootFolder == null || rootFolder.isEmpty()) {
			throw new IllegalArgumentException("root folder argument not set");
		}
		PomModifier modifier = new PomModifier();
		modifier.addModifier(new XtendGroupIdDependencyModifier());
		modifier.addModifier(new ThirdPartyArifactDependencyModifier());
		modifier.addModifier(new LicensePusher());

		File rootDir = new File(rootFolder);
		modifier.modify(rootDir);
	}

	@SuppressWarnings("unchecked")
	public void modify(File rootFolder) {
		logInfo("Working with: " + rootFolder.getAbsolutePath());
		try {
			List<File> files = FileUtils.getFiles(rootFolder, "**/*.pom", null);
			logInfo("Found " + files.size() + " pom's");
			int modified = 0;
			for (File file : files) {
				Model pomModel = readModel(file);
				if (pomModel != null) {
					String executeModifieres = executeModifieres(pomModel);
					if (!executeModifieres.isEmpty()) {
						logInfo(pomModel.getArtifactId() + " was modified by "
								+ executeModifieres);
						modified++;
						saveModel(pomModel, file);
					}
				}
			}
			logInfo("Modified " + modified + " pom's");

		} catch (IOException ioe) {
			logError("Error during root folder discovering", ioe);
		}
	}

	private Model readModel(File file) {
		MavenXpp3Reader reader = new MavenXpp3Reader();
		Model pomModel = null;
		try {
			pomModel = reader.read(new FileInputStream(file));
		} catch (Exception e) {
			logError("Failed to parse " + file.getName(), e);
		}

		return pomModel;
	}

	/**
	 * @param pomModel
	 * @return separated involved Modifier names if any, empty string otherwise
	 */
	private String executeModifieres(Model pomModel) {
		StringBuilder modifiersInvolved = new StringBuilder();
		for (ModelModifier modifier : modifiers) {
			if (modifier.modifiy(pomModel)) {
				if (modifiersInvolved.length() != 0) {
					modifiersInvolved.append(", ");
				}
				modifiersInvolved.append(modifier.getClass().getSimpleName());
			}
		}
		return modifiersInvolved.toString();
	}

	private void saveModel(Model pomModel, File file) {
		ModelWriter writer = new DefaultModelWriter();
		try {
			writer.write(file, null, pomModel);
		} catch (IOException ioe) {
			logError("Failed to save pom " + file.getName(), ioe);
		}
	}

	private void addModifier(ModelModifier modelModifier) {
		modifiers.add(modelModifier);
	}

	private void logError(String errorMessage, Exception exception) {
		LOG.log(Level.SEVERE, errorMessage, exception);
	}

	private void logInfo(String infoMessage) {
		System.out.println(infoMessage);
	}
}
