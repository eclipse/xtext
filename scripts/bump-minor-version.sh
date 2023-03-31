#!/bin/sh

# Bumps the minor version to the next one, taking care of updating also
# references and Eclipse metadata.
# First the version must be bumped on the dev BOM, which is disconnected from the parent.
# Then, we update all the other POMs and Eclipse metadata.

# Call it like that:
# ./scripts/bump-minor-version.sh

mvn -f org.eclipse.xtext.dev-bom \
	build-helper:parse-version \
	versions:set \
	-DgenerateBackupPoms=false \
	-DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.nextMinorVersion}.\${parsedVersion.incrementalVersion}-SNAPSHOT

mvn \
	build-helper:parse-version \
	versions:set \
	-DgenerateBackupPoms=false \
	-DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.nextMinorVersion}.\${parsedVersion.incrementalVersion}-SNAPSHOT \
	org.eclipse.tycho:tycho-versions-plugin:update-eclipse-metadata

