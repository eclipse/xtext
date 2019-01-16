if [ -z "$JENKINS_URL" ]; then
  # if not set in environment use default
  JENKINS_URL=https://ci.eclipse.org/xtext/
fi
if [ -z "$WORKSPACE" ]; then
  # if not set in environment use default
  WORKSPACE=$(pwd)
fi

mvn \
  -f maven-pom.xml \
  --batch-mode \
  --update-snapshots \
  -fae \
  -PuseJenkinsSnapshots \
  -DJENKINS_URL=$JENKINS_URL \
  -DWORKSPACE=$WORKSPACE \
  -Dmaven.test.failure.ignore=true \
  -Dit-archetype-tests-skip=true \
  -Dmaven.repo.local=$WORKSPACE/.m2/repository \
  -DgradleMavenRepo=file:${WORKSPACE}/build/maven-repository/ \
  -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn \
  -Dmaven.javadoc.skip=true \
  deploy \
  $@
