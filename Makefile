##@ Utility

.PHONY: help
help: ## Display this help
	@awk 'BEGIN {FS = ":.*##"; printf "\nUsage:\n  make \033[36m\033[0m\n"} /^[a-zA-Z0-9_-]+:.*?##/ { printf "  \033[36m%-15s\033[0m %s\n", $$1, $$2 } /^##@/ { printf "\n\033[1m%s\033[0m\n", substr($$0, 5) } ' $(MAKEFILE_LIST)

##@ Dependencies

.PHONY: build
build: ## Build the project
	@./gradlew clean build -x test

.PHONY: dep
dep: ## Download Dependencies
	@./gradlew downloadDependencies

.PHONY: format
format: ## Format Project
	@./gradlew spotlessApply

##@ Tests

.PHONY: test
test: ## Run all tests
	@./gradlew test

.PHONY: unit
unit: ## Run unit tests
	@./gradlew unit
