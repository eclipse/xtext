#!/bin/sh

if [ "$1" == "milestones" ]; then
  REPO_NAME="TMF Xtext Update Site (Milestones)"
elif [ "$1" == "releases" ]; then
  REPO_NAME="TMF Xtext Update Site (Releases)"
else
  echo "Error: Missing Repository Path!"
  exit 1
fi

cd /home/data/httpd/download.eclipse.org/modeling/tmf/xtext/updates/$1

TIMESTAMP=$(date +%s000)
UPDATE_SITES=$(find . -regex '.*/content.\(xml\|jar\|xz\)' -printf "%h\n" | cut -c 3- | sort -u)
NUMBER_UPDATE_SITES=$(echo "$UPDATE_SITES" | wc -l)

CONTENTXML="<?xml version='1.0' encoding='UTF-8'?>
<?compositeMetadataRepository version='1.0.0'?>
<repository name='$REPO_NAME'
    type='org.eclipse.equinox.internal.p2.metadata.repository.CompositeMetadataRepository'
    version='1.0.0'>
  <properties size='1'>
    <property name='p2.timestamp' value='${TIMESTAMP}'/>
  </properties>
  <children size='${NUMBER_UPDATE_SITES}'>
$(
for site in $UPDATE_SITES
do
printf "    <child location='${site}'/>\n"
done
)
  </children>
</repository>
"

echo "$CONTENTXML" > ./compositeContent.xml

ARTIFACTXML="<?xml version='1.0' encoding='UTF-8'?>
<?compositeArtifactRepository version='1.0.0'?>
<repository name='${REPO_NAME}'
    type='org.eclipse.equinox.internal.p2.artifact.repository.CompositeArtifactRepository'
    version='1.0.0'>
  <properties size='1'>
    <property name='p2.timestamp' value='${TIMESTAMP}'/>
  </properties>
  <children size='${NUMBER_UPDATE_SITES}'>
$(
for site in $UPDATE_SITES
do
printf "    <child location='${site}'/>\n"
done
)
  </children>
</repository>
"

echo "$ARTIFACTXML" > ./compositeArtifacts.xml
