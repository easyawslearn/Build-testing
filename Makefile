
build:
	mvn clean package

.PHONY: build

docker:
	mvn clean package docker:build

.PHONY: docker

clean:
	rm -rf ./target/

.PHONY: clean
