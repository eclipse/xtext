if [ -z "$JENKINS_URL" ]; then
  # if not set in environment use default
  JENKINS_URL=https://ci.eclipse.org/xtext/
fi

if [ -f "/.dockerenv" ]; then
  export GRADLE_OPTS="-Dorg.gradle.daemon=false"
fi

./gradlew \
  clean cleanGenerateXtext build publish \
  -Dmaven.repo.local=$(pwd)/.m2/repository \
  -PcompileXtend=true \
  -PJENKINS_URL=$JENKINS_URL \
  -PignoreTestFailures=true \
  --refresh-dependencies \
  --continue \
  $@
