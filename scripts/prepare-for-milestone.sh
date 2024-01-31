#!/bin/sh

if [ $# -eq 0 ]; then
    echo "No arguments provided: pass the milestone, e.g., M1"
    exit 1
fi

# First, update the version of the BOM, which is disconnected from the parent.
# For example, 2.31.0-SNAPSHOT becomes 2.31.0.M1

./mvnw -f org.eclipse.xtext.dev-bom \
  build-helper:parse-version \
  versions:set \
  -DgenerateBackupPoms=false \
  -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.incrementalVersion}.$1

# The updated BOM must be installed, or the next runs will complain they can't find it.

./mvnw -f org.eclipse.xtext.dev-bom install

# Replace the property "xtext-dev-bom-version" in the parent POM, with the new version of the BOM.
# For example,
# <xtext-dev-bom-version>${project.version}</xtext-dev-bom-version>
# becomes
# <xtext-dev-bom-version>2.31.0.M1</xtext-dev-bom-version>

./mvnw \
  build-helper:parse-version \
  versions:set-property \
  -DgenerateBackupPoms=false \
  -Dproperty=xtext-dev-bom-version \
  -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.incrementalVersion}.$1

# With Tycho, replace all versions (in POMs and Eclipse metadata) with the timestamp as the qualifier.
# For example, in POMs, 2.31.0-SNAPSHOT becomes 2.31.0.v2023...
# In MANIFEST and features, 2.31.0.qualifier becomes 2.31.0.v2023...

./mvnw \
  -Preplace-qualifier-with-timestamp \
  build-helper:parse-version \
  build-helper:timestamp-property@timestamp \
  org.eclipse.tycho:tycho-versions-plugin:set-version \
  -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.incrementalVersion}.\${computedTimestamp} \
  -DgenerateBackupPoms=false

# Update the versions in the POMs only with the milestone number as the qualifier
# For example, in POMs, 2.31.0.v2023... becomes 2.31.0.M1
# In MANIFEST and features, 2.31.0.v2023... stays the same

./mvnw \
  build-helper:parse-version \
  versions:set \
  -DgenerateBackupPoms=false \
  -DnewVersion=\${parsedVersion.majorVersion}.\${parsedVersion.minorVersion}.\${parsedVersion.incrementalVersion}.$1
