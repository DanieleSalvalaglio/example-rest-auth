echo "Update apt-get and install tools"
apt-get update -qq
apt-get install -y wget
apt-get install -y -qq build-essential libz-dev zlib1g-dev

echo "Downloading GraalVM"
wget -q https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-22.2.0/graalvm-ce-java17-linux-amd64-22.2.0.tar.gz
tar zxf graalvm-ce-java17-linux-amd64-22.2.0.tar.gz

echo "Installing GraalVM via gu"

${CI_PROJECT_DIR}/graalvm-ce-java17-22.2.0/bin/gu install native-image  