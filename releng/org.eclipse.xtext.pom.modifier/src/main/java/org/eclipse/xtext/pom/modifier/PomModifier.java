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

		File rootDir = new File(rootFolder);
		modifier.modify(rootDir);
	}

	@SuppressWarnings("unchecked")
	public void modify(File rootFolder) {
		try {
			List<File> files = FileUtils.getFiles(rootFolder, "**/*.pom", null);

			for (File file : files) {
				Model pomModel = readModel(file);
				if (pomModel != null) {
					if (executeModifieres(pomModel)) {
						logInfo(pomModel.getArtifactId() + " was modified");
						if (saveModel(pomModel, file)) {
							logInfo(pomModel.getArtifactId()
									+ " was saved under " + file.getName());
						}
					}
				}
			}

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
	 * @return <code>true</code> if some modifier changed model
	 */
	private boolean executeModifieres(Model pomModel) {
		boolean modelChanged = false;
		for (ModelModifier modifier : modifiers) {
			modelChanged |= modifier.modifiy(pomModel);
		}
		return modelChanged;
	}

	private boolean saveModel(Model pomModel, File file) {
		ModelWriter writer = new DefaultModelWriter();
		try {
			writer.write(file, null, pomModel);
			return true;
		} catch (IOException ioe) {
			LOG.log(Level.SEVERE, "Failed to save pom " + file.getName(), ioe);
			return false;
		}
	}

	private void addModifier(ModelModifier modelModifier) {
		modifiers.add(modelModifier);
	}

	private void logError(String errorMessage, Exception exception) {
		System.err.println(errorMessage + exception.getMessage());
	}

	private void logInfo(String infoMessage) {
		System.out.println(infoMessage);
	}
}
